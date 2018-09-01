package util;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

/**
 * Class that extracts properties from the prop file.
 */
public class PropertyLoader {

  private static final String DEBUG_PROPERTIES = "/debug.properties";

  public static DesiredCapabilities  loadCapabilities() throws IOException {
    return loadCapabilities(System.getProperty("application.properties", DEBUG_PROPERTIES));
  }

  public static DesiredCapabilities  loadCapabilities(String fromResource) throws IOException {
    Properties props = new Properties();
    props.load(PropertyLoader.class.getResourceAsStream(fromResource));
    String capabilitiesFile = props.getProperty("capabilities");

    Properties capsProps = new Properties();
    capsProps.load(PropertyLoader.class.getResourceAsStream(capabilitiesFile));

    DesiredCapabilities capabilities = new DesiredCapabilities();
    for (String name : capsProps.stringPropertyNames()) {
      String value = capsProps.getProperty(name);
      if (value.toLowerCase().equals("true") || value.toLowerCase().equals("false")) {
        capabilities.setCapability(name, Boolean.valueOf(value));
      } else if (value.startsWith("file:")) {
        capabilities.setCapability(name, new File(".", value.substring(5)).getCanonicalFile().getAbsolutePath());
      } else if(value.startsWith("{")){

        Map<String, Object> map = new HashMap<>();
        String line = StringUtils.substringBetween(value, "{", "}");
        List<String> listLines = Arrays.asList(line.split(";"));
        for (String lin : listLines) {
          Properties proper = new Properties();
          proper.load(new StringReader(lin));

          for (String key : proper.stringPropertyNames()) {
            String val = proper.getProperty(key);
            if (val.startsWith("[")) {
              String listLine = StringUtils.substringBetween(value, "[", "]");
              List<String> list = Arrays.asList(listLine.split("\\s*,\\s*"));
              map.put(key, list);
            } else {
              map.put(key, val);
            }

          }
        }

        capabilities.setCapability(name, map);
      }
      else {
        capabilities.setCapability(name, value);
      }
    }

    return capabilities;
  }

  public static String loadProperty(String name) throws IOException {
    return loadProperty(name, System.getProperty("application.properties", DEBUG_PROPERTIES));
  }

  public static String loadProperty(String name, String fromResource) throws IOException {
    Properties props = new Properties();
    props.load(PropertyLoader.class.getResourceAsStream(fromResource));

    return props.getProperty(name);
  }

}