package com.whatsapptest.base;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/*
 * Author : H Sri Harsha This is the runner file which will be used by cucumber.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Features", glue = {"classpath:com.whatsapptest.Chats"})
public class Runner extends AbstractTestNGCucumberTests {

}
