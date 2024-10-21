package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.google.j2objc.annotations.Property;
/**
 * This class contains reusable methods to read data from properties file
 * @author Sai_Teja
 */
public class PropertiesUtility {
 		
	Properties property;
	/**
	 * This method initializes properties file
	 * @param filepath
	 */
	
	public void propertiesInit(String filepath) {
		FileInputStream fis = null;
		try {
		    fis = new FileInputStream(filepath);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		property = new Properties();
		try {
		property.load(fis);
	}catch (IOException e) { 
		e.printStackTrace();
	}
}
		/**
		 * This method fetches data from properties file
		 * @param key
		 * @return String
		 */
		public String getDataFromProperties(String Key) {
			return property.getProperty(Key);
	}
}