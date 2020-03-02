package com.acc.cucumberhelper;

import com.acc.driverfactory.BaseClass;
import com.acc.manager.PageObjectManager;

public class TestContext {

	private BaseClass baseClass;
	private PageObjectManager pageObjectManager;
	
	public TestContext()
	{
		baseClass = new BaseClass();
		pageObjectManager = new PageObjectManager(baseClass.getDriver());
	}
	
	public BaseClass getBaseClass()
	{
		return baseClass;
	}
	
	public PageObjectManager getPageObjectManager()
	{
		return pageObjectManager;
	}
}
