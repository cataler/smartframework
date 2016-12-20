package Reflecctions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射工具类
 * Created by Collegepre on 2016/12/19.
 */
public final class ReflectionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 创建实例
     * @param cls 类名
     * @return 实例对象
     */
    public static Object newInstance(Class<?> cls) {
        Object instance;
        try {
            instance = cls.newInstance();
        } catch (Exception e) {
            LOGGER.error("new instance failure",e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 调用方法
     * @param object 实例对象
     * @param method 方法
     * @param args 参数
     * @return 实例对象
     */
    public static Object invokeMethod(Object object, Method method,Object... args) {
        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(object,args);
        } catch (Exception e) {
            LOGGER.error("invoke method failure",e);
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 设置成员变量
     * @param object 实例对象
     * @param field 作用域
     * @param value 成员变量
     */
    public static void setField(Object object, Field field,Object value) {
        try {
            field.setAccessible(true);
            field.set(object,value);
        } catch (Exception e) {
            LOGGER.error("set field failure",e);
            throw new RuntimeException(e);
        }
    }
}
