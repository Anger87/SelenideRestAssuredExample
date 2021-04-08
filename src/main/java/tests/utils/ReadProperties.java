package tests.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {


    public  Properties initProperty() {
	    Properties property = null;
	    try {
		    FileInputStream fis;
		    property = new Properties();
		    fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/properties/config.properties");
		    property.load(fis);
	    } catch (IOException e) {
		    System.err.println("Error: properties file is absent");
	    }
	    return property;
    }


    public static String getPropValue(Properties property, String propName) {
        return property.getProperty(propName);
    }

}
