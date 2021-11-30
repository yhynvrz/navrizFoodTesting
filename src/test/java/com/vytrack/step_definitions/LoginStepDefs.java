package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException{
        String url = ConfigurationReader.get("url");
        //WebDriver driver = Driver.get();
        Driver.get().get(url); //Singelton it is pointing the same object we dont need to create new object

    }

    @When("the user entres the Driver information")
    public void the_user_entres_the_Driver_information() throws InterruptedException{
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {

        String actualTitle = Driver.get().getTitle();

        Assert.assertEquals("Dashboard",actualTitle);
    }

    @When("The user enters the Salesmanager information")
    public void the_user_enters_the_Salesmanager_information() {
        String username = ConfigurationReader.get("sales_manager_username");
        String password = ConfigurationReader.get("sales_manager_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

    }

    @When("The user enters the Store manager information")
    public void the_user_enters_the_Store_manager_information() {

        String username = ConfigurationReader.get("store_manager_username");
        String password = ConfigurationReader.get("store_manager_password");


        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

    }


    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {
        BrowserUtils.waitFor(7);
        String driverUsername = ConfigurationReader.get("driver_username");
        String  driverPassword = ConfigurationReader.get("driver_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(driverUsername,driverPassword);
    }
    @Then("the title contains {string}")
    public void the_title_contains(String expectedTitle) {

        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    @When("the user navigates to {string} {string}")
    public void the_user_navigates_to(String tab, String module) {
        //making it dynamic so in the scenario we just have to change name
        new DashboardPage().navigateToModule(tab,module);
    }
    @Then("default page number should be {int}")
    public void default_page_number_should_be(Integer expectedPageNum) {
        BrowserUtils.waitFor(10);
        ContactsPage contactsPage = new ContactsPage();
        Integer actualNumber = Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));

        Assert.assertEquals(expectedPageNum,actualNumber);


    }
    @Given("the user logs in as {string}")
    public void the_user_logs_in_as(String string) {
        BrowserUtils.waitFor(10);
        // Write code here that turns the phrase above into concrete actions

    }

    @When("the user enters with {string} {string}")
    public void the_user_enters_with(String username, String password) {

        BrowserUtils.waitFor(7);

    }


}