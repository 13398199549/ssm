package org.framestudy.ssm.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.framestudy.ssm.utils.PropertiesUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class GlobalUtilDateConverter implements Converter<String, Date> {

	public Date convert(String text) {
		// TODO Auto-generated method stub
		Date date = null;
		PropertiesUtils utils = new PropertiesUtils();
		SimpleDateFormat format = null;
		try {
			Properties properties = utils.getProperties();
			Set<Object> keys = properties.keySet();
			
			if(StringUtils.hasLength(text)) {
				for (Object object : keys) {
					String key = (String) object;
					Pattern p = Pattern.compile(key);
					Matcher m = p.matcher(text);
					if(m.matches()) {
						format = new SimpleDateFormat(properties.getProperty(key)); 
						date = format.parse(text);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}
