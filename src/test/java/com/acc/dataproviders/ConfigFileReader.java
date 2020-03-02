package com.acc.dataproviders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.acc.enums.DriverType;

public class ConfigFileReader {

	
	private Properties properties;
	private final String propertyFilepath= "src/test/resources/configs/Configuration.properties";
	
	public ConfigFileReader()
	{
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilepath));
			properties= new Properties();
			try {
				properties.load(reader);
				reader.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("configuration.properties not found at "+propertyFilepath);
		}
		
	}
	
	public String getChromeDriverPath()
	{
		String chromeDriverPath= properties.getProperty("chromeDriverPath");
		if(chromeDriverPath != null)
			return chromeDriverPath;
		else throw new RuntimeException("chrome driver's Path is not mentioned in the Configuraion,properties file");
		
	}
	
	public DriverType getBrowserName()
	{
		String browserName= properties.getProperty("browserName");
		if(browserName.equalsIgnoreCase("chrome")) return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if (browserName.equalsIgnoreCase("iexplorer")) return DriverType.INTERNETEXPLORER;
		else throw new RuntimeException("browser name is not mentioned in the Configuraion,properties file");
	}
	
	public String getApplicationUrl()
	{
		String url= properties.getProperty("url");
		if(url != null)
			return url;
		else throw new RuntimeException("url is not mentioned in the Configuraion,properties file");
	}
	
	public String getUserName()
	{
		String url= properties.getProperty("password");
		if(url != null)
			return url;
		else throw new RuntimeException("userName is not mentioned in the Configuraion,properties file");
	}
	
	public String getPassword()
	{
		String url= properties.getProperty("password");
		if(url != null)
			return url;
		else throw new RuntimeException("Password is not mentioned in the Configuraion,properties file");
	}
	
}
