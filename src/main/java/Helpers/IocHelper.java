package Helpers;

import Annotations.Inject;
import Reflecctions.ReflectionUtil;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import java.lang.reflect.Field;
import java.util.Map;

/**
 *
 * Created by Collegepre on 2016/12/21.
 */
public final class IocHelper {
    static {
        // 获取所有的 Bean类与Bean实例之间的映射关系
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if (MapUtils.isNotEmpty(beanMap)) {
            // 遍历 Bean Map
            for (Map.Entry<Class<?>,Object>beanEntry:beanMap.entrySet()) {
                // 从BeanMap中获取Bean类与Bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                // 获取 Bean类定义的所有成员变量(Bean Field)
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtils.isNotEmpty(beanFields)) {
                    // 遍历 Bean Field
                    for (Field beanField : beanFields) {
                        // 判断当前 Bean Field 是否带有 Inject注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            // 在 Bean Map 中获取 Bean Field对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                // 通过反射初始化 BeanField的值
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
