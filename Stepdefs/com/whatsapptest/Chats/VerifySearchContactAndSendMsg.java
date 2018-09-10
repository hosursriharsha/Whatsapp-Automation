package com.whatsapptest.Chats;

import static org.testng.Assert.assertTrue;
import com.whatsapptest.base.BaseClass;

import Pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VerifySearchContactAndSendMsg {

	private HomePage homePage = new HomePage();

	@Given("^\"([^\"]*)\" is logged into whatsapp$")
	public void verifyHomePage(String User1) throws Throwable {
		homePage.verifyHomePage(User1);
	}

	@When("^\"([^\"]*)\" searches for \"([^\"]*)\"$")
	public void searchForContact(String User1, String User2) throws Throwable {
		homePage.searchContact(User1, User2);
	}

	@Then("^\"([^\"]*)\" chooses the contact \"([^\"]*)\"$")
	public void chooseContact(String User1, String User2) throws Throwable {
		homePage.chooseContact(User1,User2);
	}

	@Then("^sends the message \"([^\"]*)\"$")
	public void sends_the_message(String User1) throws Throwable {
	}
}
