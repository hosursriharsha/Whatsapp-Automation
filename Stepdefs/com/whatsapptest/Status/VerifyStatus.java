package com.whatsapptest.Status;

import Pages.StatusPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * This class contains methods related to status update and delete
 * 
 * @author Sri Harsha
 *
 */
public class VerifyStatus {
  private StatusPage statusPage = new StatusPage();

  /**
   * This method clicks to status tab
   * 
   * @param User1 contains reference to user1
   * @throws Throwable
   */
  @When("^\"([^\"]*)\" navigates to Status tab$")
  public void navigateToStatusTab(String User1) throws Throwable {
    statusPage.navigateToStatusTab(User1);
  }

  /**
   * This method sets status
   * 
   * @param User1 contains reference to user1
   * @param message contains reference of the status message
   * @throws Throwable
   */
  @Then("^\"([^\"]*)\" enters status as \"([^\"]*)\"$")
  public void setStatus(String User1, String message) throws Throwable {
    statusPage.setStatus(User1, message);
  }

  /**
   * This method verifies status is updated
   * 
   * @param User1 contains reference to user1
   * @throws Throwable
   */
  @Then("^\"([^\"]*)\" verifies status is updated$")
  public void verifyStatusUpdated(String User1) throws Throwable {
    statusPage.verifyStatusUpdated(User1);
  }

  /**
   * This method deletes the status
   * 
   * @param User1 contains reference to user1
   * @throws Throwable
   */
  @Then("^\"([^\"]*)\" deletes the status$")
  public void deleteStatus(String User1) throws Throwable {
    statusPage.deleteStatus(User1);
  }

  /**
   * This method verifies status is deleted
   * 
   * @param User1 contains reference to user1
   * @throws Throwable
   */
  @Then("^\"([^\"]*)\" verifies status is deleted$")
  public void verifyStatusDeleted(String User1) throws Throwable {
    statusPage.verifyStatusDeleted(User1);
  }
}
