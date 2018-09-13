package com.whatsapptest.Chats;

import java.text.SimpleDateFormat;
import java.util.Date;
import Pages.ChatPage;
import Pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * This class contains methods related to verifying searching contact and sending message
 * 
 * @author Sri Harsha H
 *
 */
public class VerifySearchContactAndSendMsg {

  private HomePage homePage = new HomePage();
  private ChatPage chatPage = new ChatPage();
  String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
  String messageSent = null;

  /**
   * This method verifies if user is logged into whatsapp or not
   * 
   * @param User1 contains the reference of the user1
   * @throws Throwable
   */
  @Given("^\"([^\"]*)\" is logged into whatsapp$")
  public void verifyHomePage(String User1) throws Throwable {
    homePage.verifyHomePage(User1);
  }

  /**
   * This method searches for a contact
   * 
   * @param User1 contains the reference of the user1
   * @param User2 contains the reference of the user2
   * @throws Throwable
   */
  @When("^\"([^\"]*)\" searches for \"([^\"]*)\"$")
  public void searchForContact(String User1, String User2) throws Throwable {
    homePage.searchContact(User1, User2);
  }

  /**
   * This method clicks on a contact
   * 
   * @param User1 contains the reference of the user1
   * @param User2 contains the reference of the user2
   * @throws Throwable
   */
  @Then("^\"([^\"]*)\" chooses the contact \"([^\"]*)\"$")
  public void chooseContact(String User1, String User2) throws Throwable {
    homePage.chooseContact(User1, User2);
  }

  /**
   * This method sends message
   * 
   * @param User1 contains the reference of the user
   * @param message contains the reference of the message
   * @throws Throwable
   */
  @Then("^\"([^\"]*)\" sends the message \"([^\"]*)\"$")
  public void sendMessage(String User1, String message) throws Throwable {
    messageSent = message + timeStamp;
    chatPage.sendMessage(User1, messageSent);

  }

  /**
   * This method verifies whether message is received or not.
   * 
   * @param messageReceiver contains the reference of the message receiver
   * @param messageSender contains the reference of the message sender
   * @throws Throwable
   */
  @Then("^\"([^\"]*)\" verifies the message received from \"([^\"]*)\"$")
  public void verifyMessageReceived(String messageReceiver, String messageSender) throws Throwable {
    homePage.verifyMessageReceived(messageReceiver, messageSender, messageSent);
  }
}
