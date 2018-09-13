package Pages;

import static org.testng.Assert.assertTrue;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import com.whatsapptest.base.BaseClass;

/**
 * This class contains all the methods related to Home Page
 * 
 * @author Sri Harsha
 *
 */
public class HomePage extends BaseClass {

  /**
   * This method verifies if user is logged into whatsapp or not
   * 
   * @param User1 contains the reference of the user1
   */
  public void verifyHomePage(String User1) throws FileNotFoundException, IOException {
    assertTrue(
        driver(User1).findElementByXPath(getLocator("chatsScreen.ChatsLabel")).isDisplayed());
  }

  /**
   * This method searches for a contact
   * 
   * @param User1 contains the reference of the user1
   * @param User2 contains the reference of the user2
   */
  public void searchContact(String User1, String User2)
      throws FileNotFoundException, IOException, ParseException {
    driver(User1).findElementById(getLocator("chatsScreen.SearchContact")).click();
    driver(User1).findElementById(getLocator("chatScreen.SearchContactTextBox"))
        .sendKeys(getDeviceValue(User2, "userName"));
  }

  /**
   * This method clicks on a contact
   * 
   * @param User1 contains the reference of the user1
   * @param User2 contains the reference of the user2
   */
  public void chooseContact(String User1, String User2)
      throws FileNotFoundException, IOException, ParseException {
    String xpath = getLocator("searchContact.searchResultPart1") + getDeviceValue(User2, "userName")
        + getLocator("searchContact.searchResultPart2");
    System.out.println("Xpath is " + xpath);
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
    }
    driver(User1).findElementByXPath(xpath).click();
  }

  /**
   * This method verifies whether message is received or not.
   * 
   * @param messageReceiver contains the reference of the message receiver
   * @param messageSender contains the reference of the message sender
   */
  public void verifyMessageReceived(String messageReceiver, String messageSender,
      String messageSent) throws FileNotFoundException, IOException, ParseException {
    String Xpath = getLocator("chatScreen.clickContactInChatScreenPart1")
        + getDeviceValue(messageSender, "userName")
        + getLocator("chatScreen.clickContactInChatScreenPart2");
    driver(messageReceiver).findElementByXPath(Xpath).click();
    Xpath =
        getLocator("chatScreen.messagePart1") + messageSent + getLocator("chatScreen.messagePart2");
    assertTrue(driver(messageReceiver).findElementByXPath(Xpath).isDisplayed());

  }
}
