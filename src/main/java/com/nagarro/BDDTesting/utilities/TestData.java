package com.nagarro.BDDTesting.utilities;

import org.testng.annotations.DataProvider;

import com.nagarro.BDDTesting.config.ConfigReader;


public class TestData {
	
	static ConfigReader prop;
	private static final String path = "src/test/resources/data.properties";
	
	static{
		prop= new ConfigReader(path);
	}
	
	    @DataProvider(name = "searchData")
	    public static Object[][] searchDataProvider() {
	        return new Object[][] {
	            {prop.getProperty("SearchItem1")},
	            {prop.getProperty("SearchItem2")}
	        };
	    }
	    
	    @DataProvider(name="pincodeData")
	    public static Object[][] PincodeDataProvider() {
	        return new Object[][] {
	            {prop.getProperty("Mumbai")},
	            {prop.getProperty("Amritsar")}
	        };
	    }
	    
	    @DataProvider(name="loginData")
	    public static Object[][] LoginDataProvider() {
	        return new Object[][] {
	            {prop.getProperty("email"),prop.getProperty("password")}
	        };
	    }
	    
	    @DataProvider(name="AddToCartData")
	    public static Object[][] AddToCartDataProvider() {
	        return new Object[][] {
	            {prop.getProperty("SearchItem3")}
	        };
	    }
	    
	}
	
