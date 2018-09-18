##Author : H Sri Harsha
##This feature contains scenarios related to searching a contact and sending a message in whatsapp.
Feature: Verify search contact and send message

@VerifySearchAndSendMsg
Scenario: Verify search contact and send message
Given "User1" is logged into whatsapp
When "User1" searches for "User2"
Then "User1" chooses the contact "User2"
Then "User1" sends the message "Hello. This is an automated test message."
Then "User2" verifies the message received from "User1"
