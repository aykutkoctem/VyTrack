package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.ConfigReader;
import com.vytrack.utilities.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VyTrack {

    public VyTrack() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input#prependedInput")
    public WebElement userNameField;

    @FindBy(css = "input#prependedInput2")
    public WebElement passwordField;

    @FindBy(css = "button#_submit")
    public WebElement loginButton;

    @FindBy(css = "[class='title title-level-1']")
    public   List<WebElement> driverModels;

    @FindBy(css = "li:nth-of-type(2) > .unclickable > .title.title-level-1")
    public WebElement fleet;

    @FindBy(css = "li:nth-of-type(1) > .unclickable > .title.title-level-1")
    public WebElement fleet2;

    @FindBy(linkText ="Vehicles" )
    public WebElement selectVehicle;

    @FindBy(xpath ="//span[.='Vehicle Odometer']")
    public WebElement VehicleOdometer;

    @FindBy(css = "[class='btn main-group btn-primary pull-right ']")
    public WebElement createCar;

    @FindBy(css = "[data-name='field__license-plate']")
    public WebElement licensePlate;


    @FindBy(css = "[value='junior']")
    public WebElement tags;

    @FindBy(css = ".action-button.btn.btn-success")
    public WebElement saveClose;

    @FindBy(css = "[title='Get help']")
    public WebElement getHelp;

    @FindBy(className = "message")
    public WebElement flashMessage;

    @FindBy(css = "[data-ftid='custom_entity_type_OdometerValue']")
    public WebElement otometerValue;

    @FindBy(css = "[title='Create Vehicle Odometer']")
    public WebElement CreateVehicle;


    @FindBy(css = "[name='custom_entity_type[Driver]']")
    public WebElement DriverText;

    @FindBy(css = "[name='custom_entity_type[Location]']")
    public WebElement LocationText;



    @FindBy(css = " [name='custom_entity_type[ChassisNumber]']")
    public WebElement ChassisNumberText;



    @FindBy(css = " [name='custom_entity_type[ModelYear]']")
    public WebElement ModelYearText;



    @FindBy(css = "[name='custom_entity_type[LastOdometer]']")
    public WebElement LastOdometerText;

    @FindBy(css = "[name='date_selector_custom_entity_type_ImmatriculationDate-uid-615d4a0dc5d95']")
    public WebElement ImmatriculationDate;

@FindBy(css = "[data-handler='today']")
public WebElement today1;

    @FindBy(css = "[name='date_selector_custom_entity_type_FirstContractDate-uid-615d4a0dc5e8d']")
    public WebElement FirstContractDate;



    @FindBy(css = "[name='custom_entity_type[CatalogValue]']")
    public WebElement CatalogValue;


    @FindBy(css = "[name='custom_entity_type[DoorsNumber]']")
    public WebElement DoorsNumber;

    @FindBy(css = "[name='custom_entity_type[Color]']")
    public WebElement Color;


    public void goTo(){
        Driver.getDriver().navigate().to( ConfigReader.read("weborder_url")    );
    }
    public void login(String username, String password ){

        // you can access directly using userNameField or this.userNameField
        this.userNameField.sendKeys(username);
        this.passwordField.sendKeys(password);
        this.loginButton.click();

    }
    public void verifyDriverModels(){
      //  List<WebElement> getAllDriver=Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));


    for (WebElement eachDriver : driverModels) {
        System.out.println(eachDriver.getText());
    }
}
    public void selectVehicle(){


        //WebElement selectVehicle=Driver.getDriver().findElement(By.cssSelector("li:nth-of-type(2) > .unclickable > .title.title-level-1"));
      //  Select select=new Select(selectVehicle);
     //   select.selectByIndex(0);
        BrowserUtil.waitfor(6);
        fleet.click();
        selectVehicle.click();
        BrowserUtil.waitfor(6);
        createCar.click();
        BrowserUtil.waitfor(3);
       licensePlate.sendKeys("12345567");
       tags.click();
       DriverText.sendKeys("60DE529");
       BrowserUtil.waitfor(3);
       LocationText.sendKeys("12142 Utah Avanue South Gate California 90280");
       ChassisNumberText.sendKeys("98765432");
       ModelYearText.sendKeys("2006");
       BrowserUtil.waitfor(7);
       LastOdometerText.sendKeys("55430");
       saveClose.click();
       Assertions.assertEquals("Entity saved",flashMessage.getText());
       // Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        //System.out.println(flashMessage.getText());

    }
    public void VehicleOdometer(){
        VyTrack vyTrack=new VyTrack();
        vyTrack.goTo();
        vyTrack.login("user1","UserUser123");
        BrowserUtil.waitfor(3);
        fleet2.click();
       // VehicleOdometer.click();
        BrowserUtil.waitfor(2);
        VehicleOdometer.click();
       BrowserUtil.waitfor(1);
       CreateVehicle.click();

        otometerValue.sendKeys("12345567");
     //   BrowserUtil.waitfor(7);
       // Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
      //  ImmatriculationDate.click();
    //    today1.click();
      //  FirstContractDate.click();
      //  today1.click();

        CatalogValue.sendKeys("123");
        DoorsNumber.sendKeys("12142");
        Color.sendKeys("Red");

        //tags.click();
       saveClose.click();
       BrowserUtil.waitfor(3);
       Assertions.assertEquals("Entity saved",flashMessage.getText());
    }
public void notVissibleButton(){

        BrowserUtil.waitfor(6);
    fleet.click();
    selectVehicle.click();
    BrowserUtil.waitfor(6);
  //  Assertions.assertFalse(createCar.isDisplayed());
}
public void getHelp(){


    getHelp.click();
    BrowserUtil.waitfor(5);
    String expectedTitle="Dashboard";
    Assertions.assertEquals(expectedTitle,Driver.getDriver().getTitle());

}

}
