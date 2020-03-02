package com.acc.manager;

import com.acc.dataproviders.ConfigFileReader;

public class FileReaderManager {
	
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	
	 /* A private Constructor prevents any other
	  * class from instantiating.
	  */
	
	private FileReaderManager()
	{
		
	}
	
	/* Static 'instance' method */
	public static FileReaderManager getInstance()
	{
		return fileReaderManager;
	}
	
	public ConfigFileReader getConfigReader()
	{
		if(configFileReader == null)
		{
			configFileReader= new ConfigFileReader();
		}
		return configFileReader;
	}

}
