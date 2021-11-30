package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.CreateCalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Calendar;

public class NavigationMenuStepsDef {

    @Given("Logged in as sales manager on the page")
    public void logged_in_as_sales_manager_on_the_page() {
        System.out.println("i logged in as Sales manager");
    }

    @When("User moves to Fleet option in the top menu")
    public void user_moves_to_Fleet_option_in_the_top_menu() {
        System.out.println("i navigate to Fleet menu");
    }

    @When("Click to Vehicles option")
    public void click_to_Vehicles_option() {
        System.out.println("i click to Vehicle option");
    }

    @Then("Title of page should be changed to Vehicles")
    public void title_of_page_should_be_changed_to_Vehicles() {
        System.out.println("title changed to Vehicles");
    }

    @And("Click to Campaigns option")
    public void clickToCampaignsOption() {
        System.out.println("i click to campaign option");
    }

    @Then("Title of page should be changed to Campaigns")
    public void titleOfPageShouldBeChangedToCampaigns() {
        System.out.println("The title changed to Campaign");

    }

    @When("User moves to Marketing option in the top menu")
    public void userMovesToMarketingOptionInTheTopMenu() {
        System.out.println("I click to Marketing");
    }

    @And("the user enters the sales manager information")
    public void theUserEntersTheSalesManagerInformation() {
        LoginPage loginPage = new LoginPage();

        loginPage.login("salesmanager101", "UserUser123");
        BrowserUtils.waitFor(5);


        DashboardPage module = new DashboardPage();
        module.navigateToModule("Activities", "Calender Events");


        System.out.println("Module Title = " + Driver.get().getTitle());


    }
}








