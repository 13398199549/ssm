package org.framestudy.ssm.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

	public Properties getProperties() throws Exception {
		//文件在硬盘上的绝对路径
		String path = this.getClass().getResource("/converter.properties").getPath();
		if(path.contains("%20")) {
			path = path.replace("%20", " ");
		}
		File file = new File(path);
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		Properties properties = new Properties();
		properties.load(in);
		return properties;
	}
}
