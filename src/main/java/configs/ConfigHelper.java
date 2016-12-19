package configs;

import tools.PropsUtil;

import java.util.Properties;

/**
 * 属性文件助手类
 * Created by Collegepre on 2016/12/19.
 */
/*
    String APP_BASE_PACKAGE = "smart.framework.app.base_package";
    String APP_JSP_PATH = "smart.framework.app.jsp_path";
    String APP_ASSET_PATH = "smart.framework.app.asset_path";
* */
public class ConfigHelper {
    // 配置文件
    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);
    // 获取 JDBC 驱动
    private static String getJdbcDriver() {
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
    }
    // 获取 JDBC 路径
    private static String getJdbcURL() {
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_URL);
    }
    // 获取 JDBC 用户名
    private static String getJdbcUserName() {
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_USERNAME);
    }
    // 获取 JDBC 密码
    private static String getJdbcPassword() {
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_PASSWORD);
    }
    // 获取应用基础包名
    private static String getAppBasePackage() {
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_BASE_PACKAGE);
    }
    // 获取应用JSP路径
    private static String getAppJSPPath() {
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_JSP_PATH,"/WEB-INF/view/");
    }
    // 获取应用静态资源路径
    private static String getAppAssetPath() {
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_ASSET_PATH,"/asset/");
    }
}
