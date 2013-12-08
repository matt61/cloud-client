import org.apache.commons.lang.exception.*;
import org.apache.commons.logging.*;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Configuration {
	public Configuration(String file) {
		try {
			PropertiesConfiguration config = new PropertiesConfiguration(file);
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public PropertiesConfiguration getConfig(){
		return 
	}
}
