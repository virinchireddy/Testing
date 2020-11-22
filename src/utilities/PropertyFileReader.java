package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {

	public  String getProperty(String propertyName) throws Exception{
		FileInputStream fileInput = null;
		File file = new File(System.getProperty("user.dir") + "//Resources//application.properties");
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		return prop.getProperty(propertyName);
	}
}
