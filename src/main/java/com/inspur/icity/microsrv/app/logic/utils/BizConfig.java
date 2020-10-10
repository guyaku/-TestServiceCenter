package com.inspur.icity.microsrv.app.logic.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * @Class BizConfig
 * @Description:
 *
 * @Author sunchj
 * @CreateDate 2018/2/2 16:06
 *
 */
public class BizConfig {
	private static Logger logger = LoggerFactory.getLogger(BizConfig.class);
	public BizConfig() {
	}

	private static Properties props = new Properties();
	static {

		boolean loadSuccess = loadPropertiesFromClassLoader();

		if(!loadSuccess){
			loadSuccess = loadPropertiesFromProject();
		}

		if(!loadSuccess){
			loadSuccess = loadPropertiesFromUsrDir();
		}

	}

	public static boolean loadPropertiesFromProject() {
		BufferedInputStream configBaseStream = null;
		BufferedInputStream configStream = null;

		try {
			configBaseStream = new BufferedInputStream(new FileInputStream(new File("config.properties")));
			props.load(configBaseStream);

			String env = props.getProperty("config.profile.active");
			if (StringUtil.isEmpty(env)) {
				logger.error("loadPropertiesFromProject(error)| 配置文件【config.properties】中没有配置config.profile.active！");
				return false;
			}
			configStream = new BufferedInputStream(new FileInputStream(new File("config-" + env + ".properties")));
			props.load(configStream);

			return true;

		} catch (Exception e) {
			logger.error("loadPropertiesFromProject(error)|初始化异常", e);
			return false;
		} finally {
			try {
				if (configBaseStream != null){
					configBaseStream.close();
				}
				if (configStream != null){
					configStream.close();
				}
			} catch (Exception e) {
				logger.error("loadPropertiesFromProject(error)|初始化异常", e);
			}
		}

	}

	public static boolean loadPropertiesFromClassLoader() {
		try {

			props.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("config.properties"));

			String env = props.getProperty("config.profile.active");
			if (StringUtil.isEmpty(env)) {
				logger.error("loadPropertiesFromClassLoader(error)| 配置文件【config.properties】中没有配置config.profile.active！");
				return false;
			}

			props.load(Thread.currentThread()
					.getContextClassLoader()
					.getResourceAsStream("config-" + env + ".properties"));

			return true;

		} catch (FileNotFoundException e) {
			logger.error("loadPropertiesFromClassLoader(error)|初始化异常",e);
			return false;

		} catch (IOException e) {
			logger.error("loadPropertiesFromClassLoader(error)|初始化异常",e);
			return false;

		} catch (Exception e) {
			logger.error("loadPropertiesFromClassLoader(error)|初始化异常",e);
			return false;

		}
	}

	public static boolean loadPropertiesFromUsrDir(){
		BufferedInputStream configBaseStream = null;
		BufferedInputStream configStream = null;
		try {

			StringBuilder strB = new StringBuilder();
			strB.append(System.getProperty("user.dir"));
			strB.append(File.separator);
			strB.append("config");
			strB.append(File.separator);
			String path = strB.toString();
			configBaseStream = new BufferedInputStream(new FileInputStream(new File(path + "config.properties")));
			props.load(configBaseStream);

			String env = props.getProperty("config.profile.active");
			if (StringUtil.isEmpty(env)) {
				logger.error("loadPropertiesFromProject(error)| 配置文件【config.properties】中没有配置config.profile.active！");
				return false;
			}
			configStream = new BufferedInputStream(new FileInputStream(new File(path + "config-" + env + ".properties")));
			props.load(configStream);

			return true;

		} catch (Exception e) {
			logger.error("loadPropertiesFromUsrDir(error)|初始化异常",e);
			return false;

		} finally {
			try {
				if (configBaseStream != null){
					configBaseStream.close();
				}
				if (configStream != null){
					configStream.close();
				}
			} catch (Exception e) {
				logger.error("loadPropertiesFromUsrDir(error)|初始化异常", e);
			}
		}
	}


	public static String getStringValue(String key) {
		return getStringValue(key,"");

	}

	public static String getStringValue(String key, String defaultValue) {
		String value = props.getProperty(key);
		if (StringUtil.isNotEmpty(value)) {
			return value;
		}

		return defaultValue;
	}


	public static int getIntValue(String key) {
		return getIntValue(key,0);
	}

	public static int getIntValue(String key, int defaultValue) {
		String value = props.getProperty(key);
		if (StringUtil.isNotEmpty(value)) {
			return returnIntValue(value, defaultValue);
		}

		return defaultValue;
	}

	private static int returnIntValue(String value, int defaultValue){
		try{
			return Integer.parseInt(value);
		} catch (Exception e) {
			logger.error("returnValue(error)",e);
			return defaultValue;
		}
	}


	public static long getLongValue(String key) {
		return getLongValue(key,0);
	}

	public static long getLongValue(String key, long defaultValue) {
		String value = props.getProperty(key);
		if (StringUtil.isNotEmpty(value)) {
			return returnLongValue(value, defaultValue);
		}

		return defaultValue;
	}

	private static long returnLongValue(String value, long defaultValue){
		try {
			return Long.parseLong(value);
		} catch (Exception e) {
			logger.error("returnValue(error)",e);
			return defaultValue;
		}
	}

	public static void updateProperties(String key, String value) {
		props.setProperty(key, value);
	}
}