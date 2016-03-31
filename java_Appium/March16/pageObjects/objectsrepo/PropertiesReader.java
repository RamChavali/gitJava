package objectsrepo;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

	private static PropertiesReader INSTANCE;
	Properties data = new Properties();
	InputStream fileInputStream;
	
	
	public static PropertiesReader getInstance() throws Exception{
		if (INSTANCE==null){
			INSTANCE = new PropertiesReader();
		}	
		return INSTANCE;
	}
	
	PropertiesReader() throws Exception{
		
			String filePath = new java.io.File(".").getCanonicalPath() + "/src/map.properties";
			fileInputStream = new java.io.FileInputStream(filePath);
			data.load(fileInputStream);	
	}
	
	public String get(String key){
		return data.getProperty(key);
	}	
}
