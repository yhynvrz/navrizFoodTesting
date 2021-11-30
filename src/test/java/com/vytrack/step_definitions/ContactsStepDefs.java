package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.DriverAction;
import java.util.List;
import java.util.Map;

public class ContactsStepDefs {
    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        //go to login page

        Driver.get().get(ConfigurationReader.get("url"));

        //based on the input enter that user information
        String username = null;
        String password = null;

        if (userType.equals("driver")){
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        }else if (userType.equals("sales manager")){
            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
        }else if(userType.equals("store manager")){
            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        }


        //send username and password and login
        new LoginPage().login(username, password);

    }

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> menuOptions) {
        System.out.println(menuOptions.size());
        System.out.println(menuOptions);
        BrowserUtils.waitFor(10);
        //get the list of webelement and convert them to list of string and assert
        //getElementsText in BrowserUtils and using for loop
        List<String>actualOptions=BrowserUtils.getElementsText(new DashboardPage().menuOptions);

        Assert.assertEquals(menuOptions, actualOptions);
        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualOptions = " + actualOptions);

    }

    @When("the user logs in using following credentials")
    public void the_user_logs_in_using_following_credentials(Map<String,String> userinfo) {

        System.out.println(userinfo);

        //login with map info with key
        new LoginPage().login(userinfo.get("username"),userinfo.get("password"));

        //verify firstname and lastname
        String actualname = new DashboardPage().getUserName();
        String expectedName = userinfo.get("firstname")+" "+userinfo.get("lastname");
    }


    }



