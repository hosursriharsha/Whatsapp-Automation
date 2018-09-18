package Pages;

import static org.testng.Assert.assertTrue;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.whatsapptest.base.BaseClass;
import io.appium.java_client.TouchAction;

/**
 * This page contains methods related to status
 * 
 * @author Sri Harsha
 *
 */
public class StatusPage extends BaseClass {

  private static String status = null;

  /**
   * This method clicks to status tab
   * 
   * @param User1 contains reference to user1
   * @throws Throwable
   */
  public void navigateToStatusTab(String User1) throws FileNotFoundException, IOException {
    driver(User1).findElementByXPath(getLocator("chatScreen.statusTab")).click();
  }

  /**
   * This method sets status
   * 
   * @param User1 contains reference to user1
   * @param message contains reference of the status message
   * @throws Throwable
   */
  public void setStatus(String User1, String message) throws FileNotFoundException, IOException {
    status = message;
    driver(User1).findElementByXPath(getLocator("statusScreen.newStatusTab")).click();
    driver(User1).findElementByXPath(getLocator("statusScreen.statusTextBox")).sendKeys(message);
    driver(User1).findElementByXPath(getLocator("statusScreen.updateStatusButton")).click();
  }

  /**
   * This method verifies status is updated
   * 
   * @param User1 contains reference to user1
   * @throws Throwable
   */
  public void verifyStatusUpdated(String User1)
      throws FileNotFoundException, IOException, InterruptedException {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    assertTrue(driver(User1).findElementByXPath(getLocator("statusScreen.statusUpdatedTime"))
        .isDisplayed());
    driver(User1).findElementByXPath(getLocator("statusScreen.myStatusLabel")).click();
    String xpath = getLocator("statusScreen.statusTextPart1") + status
        + getLocator("statusScreen.statusTextPart2");
    System.out.println(xpath);
    assertTrue(driver(User1).findElementByXPath(xpath).isDisplayed());
    driver(User1).findElementByXPath(getLocator("statusScreen.navigateBack")).click();
  }


  /**
   * This method deletes the status
   * 
   * @param User1 contains reference to user1
   * @throws Throwable
   */
  public void deleteStatus(String User1) throws FileNotFoundException, IOException {
    driver(User1).findElementByXPath(getLocator("statusScreen.statusEllipsis")).click();
    TouchAction action = new TouchAction(driver(User1));
    action.longPress(driver(User1).findElementByXPath(getLocator("statusScreen.myStatusPhoto")))
        .perform();
    driver(User1).findElementByXPath(getLocator("statusScreen.deleteStatus")).click();
    driver(User1).findElementByXPath(getLocator("statusScreen.deleteButton")).click();

  }

  /**
   * This method verifies status is deleted
   * 
   * @param User1 contains reference to user1
   * @throws Throwable
   */
  public void verifyStatusDeleted(String User1) throws FileNotFoundException, IOException {
    assertTrue(driver(User1).findElementById(getLocator("statusScreen.plusSymbol")).isDisplayed());
  }

}
