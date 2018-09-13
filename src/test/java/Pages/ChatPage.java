package Pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.whatsapptest.base.BaseClass;

/**
 * This page contains the methods related to chat page.
 * 
 * @author Sri Harsha H
 *
 */
public class ChatPage extends BaseClass {

  /**
   * This method verifies whether message is received or not.
   * 
   * @param messageReceiver contains the reference of the message receiver
   * @param messageSender contains the reference of the message sender
   * @throws Throwable
   */
  public void sendMessage(String User1, String message) throws FileNotFoundException, IOException {
    // There is an issue with explicit wait. So using thread.sleep
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {

    }
    driver(User1).findElementByXPath(getLocator("chatScreen.SendMessageTextBox")).click();
    driver(User1).findElementByXPath(getLocator("chatScreen.SendMessageTextBox")).sendKeys(message);
    driver(User1).findElementByXPath(getLocator("chatScreen.sendMessageButton")).click();
  }
}
