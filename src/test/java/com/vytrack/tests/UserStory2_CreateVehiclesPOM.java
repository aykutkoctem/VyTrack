package com.vytrack.tests;

import com.vytrack.pages.CreateVehiclePage;
//import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VyTrack;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.TestBase;
//import com.vytrack.utility.BrowserUtility;
//import com.vytrack.utility.ConfigurationReader;
//import com.vytrack.utility.Driver;
//import com.vytrack.utility.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserStory2_CreateVehiclesPOM  extends TestBase {

    @Test
    public void testManagersAbleCreateCars() {
        VyTrack loginPage = new VyTrack();

        loginPage.goTo();
        BrowserUtil.waitfor(2);

        loginPage.login("salesmanager109" ,"UserUser123");
/*
        String password = ConfigurationReader.read("login_Password");

        for (String eachManagerCredential : loginPage.managersCredentials()) {
            loginPage.login(eachManagerCredential, password);
            BrowserUtility.waitFor(2);

            CreateVehiclePage vehiclePage = new CreateVehiclePage();
             vehiclePage.createVehicleWithManager("junior");

            BrowserUtility.waitFor(2);
            loginPage.logOut();
*/
        CreateVehiclePage vehiclePage = new CreateVehiclePage();
        vehiclePage.createVehicleWithManager("junior");


    }
}


