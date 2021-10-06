package com.vytrack.tests;

import com.vytrack.pages.VyTrack;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class VytrackWithPom_userStory2 extends TestBase {

    @Test
    public void createVehicles(){
        VyTrack vyTrack=new VyTrack();
        vyTrack.goTo();
        vyTrack.login("salesmanager106","UserUser123");

        vyTrack.selectVehicle();


        BrowserUtil.waitfor(5);

       // WebElement selectVehicle= (WebElement) Driver.getDriver().findElements(By.cssSelector("li:nth-of-type(2) > .unclickable > .title.title-level-1"));
       // Select select=new Select(selectVehicle);
       // select.selectByIndex(2);
      //  BrowserUtil.waitfor(x4);
    }

    @Test
    public void visible(){
        VyTrack vyTrack=new VyTrack();
        vyTrack.goTo();
        vyTrack.login("user4","UserUser123");
        vyTrack.notVissibleButton();
    }

}
//salesmanager104 , salesmanager105 , salesmanager106
