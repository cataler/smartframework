package tools;

import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置文件工具
 * Created by Collegepre on 2016/12/19.
 */
public class PropsUtil {

    /**
     * 日志记录
     */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     * @param fileName 配置文件名
     * @return 配置类
     */
    public static Properties loadProps(String fileName) {
        Properties properties = null;
        InputStream inputStream = null;
        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                throw new FileNotFoundException(fileName + "file is not found");
            }
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("load properties file failure",e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LOGGER.error("close inputStream failure",e);
                }
            }
        }
        return properties;
    }

    /**
     * 根据KEY获取配置文件中的相应的值
     * @param properties 配置类
     * @param key 关键字
     * @param defaultValue
     * @return 该关键字下的值
     */
    public static String getString(Properties properties,String key) {
        return getString(properties,key,"");
    }
    public static String getString(Properties properties,String key,String defaultValue) {
        String value = defaultValue;
        if (properties.containsKey(key)) {
            value = properties.getProperty(key);
        }
        return value;
    }
}
