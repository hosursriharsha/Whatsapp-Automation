package com.whatsapptest.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * This class serves as a base class.
 * 
 * @author Sri Harsha Hosur
 *
 */
public class BaseClass {

  private static Map<String, AndroidDriver> driverManager = new HashMap<String, AndroidDriver>();
  private static int deviceCount;
  private static AndroidDriver[] driver = new AndroidDriver[5];
  private JSONObject jsonObject;
  private JSONObject jsonChildObject;
  private JSONArray jsonArrayParent;
  private String[] devices;

  /**
   * This method gets devices count
   * 
   * @param context
   */
  @BeforeSuite(alwaysRun = true)
  public void getDeviceDetails(ITestContext context) {
    String deviceList = context.getCurrentXmlTest().getLocalParameters().get("Users");
    devices = deviceList.split(",");
    deviceCount = devices.length;
    System.out.println("Number of users : " + deviceCount);
  }

  /**
   * This method sets driver manager
   * 
   * @throws FileNotFoundException
   * @throws IOException
   * @throws ParseException
   */
  @BeforeTest(alwaysRun = true)
  public void setDriverManager() throws FileNotFoundException, IOException, ParseException {
    int i = 0;
    while (i < deviceCount) {
      driver[i] = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),
          getDesiredCapabalities(devices[i]));
      i++;
    }
  }

  /**
   * This method gets desired capabilities for particular device
   * 
   * @param user contains the reference of the user
   * @return desired capabilities for particular device/user
   * @throws FileNotFoundException
   * @throws IOException
   * @throws ParseException
   */
  private DesiredCapabilities getDesiredCapabalities(String user)
      throws FileNotFoundException, IOException, ParseException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    Object obj = new JSONParser().parse(
        new FileReader(System.getProperty("user.dir") + "/src/test/Resources/DeviceDetails.json"));
    jsonObject = (JSONObject) obj;
    jsonArrayParent = (JSONArray) jsonObject.get("Devices");

    for (int i = 0; i < jsonArrayParent.size(); i++) {
      String userNumber = (String) ((JSONObject) jsonArrayParent.get(i)).get("DeviceName");
      if (userNumber.equals(user)) {
        String platformName = (String) ((JSONObject) jsonArrayParent.get(i)).get("platformName");
        String deviceName = (String) ((JSONObject) jsonArrayParent.get(i)).get("DeviceName");
        String appPackage = (String) ((JSONObject) jsonArrayParent.get(i)).get("appPackage");
        String appActivity = (String) ((JSONObject) jsonArrayParent.get(i)).get("appActivity");
        String udId = (String) ((JSONObject) jsonArrayParent.get(i)).get("UDID");
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("udid", udId);
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
        capabilities.setCapability("fullReset", false);
        System.out.println("UD ID is" + udId);
        return capabilities;
      }
    }
    return capabilities;
  }

  /**
   * This method gets value from config.properties
   * 
   * @param key contains reference to the key in the properties file
   * @return value contains reference to the value corresponding to key
   * @throws FileNotFoundException
   * @throws IOException
   */
  public String getConfigValue(String key) throws FileNotFoundException, IOException {
    Properties prop = new Properties();
    prop.load(new FileInputStream("Config.properties"));
    return prop.getProperty(key);
  }

  public String getDeviceValue(String user, String key)
      throws FileNotFoundException, IOException, ParseException {
    String value = null;
    int index = Character.getNumericValue(user.charAt(user.length() - 1));
    Object obj = new JSONParser().parse(
        new FileReader(System.getProperty("user.dir") + "/src/test/Resources/DeviceDetails.json"));
    jsonObject = (JSONObject) obj;
    jsonArrayParent = (JSONArray) jsonObject.get("Devices");
    for (int i = 0; i < jsonArrayParent.size(); i++) {
      String deviceName = (String) ((JSONObject) jsonArrayParent.get(i)).get("deviceName");
      if (deviceName.equals(devices[index])) {
        value = (String) ((JSONObject) jsonArrayParent.get(i)).get(key);
        System.out.println("Returning..." + value);
        return value;
      }
    }
    return value;

  }

  /**
   * This method gets locator from Locators.properties
   * 
   * @param key contains the reference of the key in properties file
   * @return returns the locator
   * @throws FileNotFoundException
   * @throws IOException
   */
  public String getLocator(String key) throws FileNotFoundException, IOException {
    Properties prop = new Properties();
    prop.load(new FileInputStream(
        System.getProperty("user.dir") + "/src/test/Resources/Locators.properties"));
    return prop.getProperty(key);
  }


  /**
   * This method returns the driver
   * 
   * @param user
   * @return
   */
  public AppiumDriver driver(String user) {
    int index = Character.getNumericValue(user.charAt(user.length() - 1));
    // return driverManager.get(user);
    return driver[index - 1];
  }
}
