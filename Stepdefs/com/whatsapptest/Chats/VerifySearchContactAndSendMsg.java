package com.whatsapptest.Chats;

import static org.testng.Assert.assertTrue;
import com.whatsapptest.base.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifySearchContactAndSendMsg extends BaseClass {

  @Given("^\"([^\"]*)\" is logged into whatsapp$")
  public void verifyLoginWhatsapp(String User1) throws Throwable {
    assertTrue(
        driver(User1).findElementByXPath(getLocator("chatsScreen.ChatsLabel")).isDisplayed());
  }

  @When("^\"([^\"]*)\" searches for \"([^\"]*)\"$")
  public void searches_for(String user1, String user2) throws Throwable {
    driver(user1).findElementById(getLocator("chatsScreen.SearchContact")).click();
    driver(user1).findElementById(getLocator("chatScreen.SearchContactTextBox"))
        .sendKeys(getDeviceValue(user1, "userName"));
  }

  @Then("^\"([^\"]*)\" chooses the contact \"([^\"]*)\"$")
  public void chooses_the_contact(String arg1, String arg2) throws Throwable {}

  @Then("^sends the message \"([^\"]*)\"$")
  public void sends_the_message(String arg1) throws Throwable {}
}
