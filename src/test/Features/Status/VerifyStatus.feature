##Author : H Sri Harsha
##This feature contains scenarios related to status
Feature: Verify status

@SetStatusAndDelete
Scenario: Set text status and delete
Given "User1" is logged into whatsapp
When "User1" navigates to Status tab
Then "User1" enters status as "Hi. This status is updated through automation."
Then "User1" verifies status is updated
Then "User1" deletes the status
Then "User1" verifies status is deleted
