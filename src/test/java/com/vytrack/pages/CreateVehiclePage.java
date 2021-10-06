package com.vytrack.pages;

import com.github.javafaker.Faker;
import com.vytrack.utilities.BrowserUtil;
import com.vytrack.utilities.Driver;
//import com.vytrack.utility.BrowserUtility;
//import com.vytrack.utility.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreateVehiclePage {

    /**
     * AC #1: only store/sales manager able to create car
     * Given store/sales manager is on the homePage
     * When user select “Vehicles” under Fleet module
     * And user click “create car” button
     * When user fill out general information
     * And click “Save and Close” button
     * Then verify “Entity saved” confirm message
     */

    /**
     * AC #2: drivers should not able to create a car
     * Given driver is on the homePage
     * When user select “Vehicles” under Fleet module
     * Then “create car” button should not be visible
     */


    @FindBy(xpath = "(//li/a/span[@class='title title-level-1'])[2]")
    public WebElement fleetBtn;

    @FindBy(xpath = "//div/ul/li[3]/a/span[.='Vehicles']")
    public WebElement vehicleBtn;

    @FindBy(xpath = "//div/a[@title='Create Car']")
    public WebElement createCarBtn;

    @FindBy(xpath =" (//div/input[@type='text'])[1]")
    public WebElement licencePlateBox;

    @FindBy(xpath = "//div/input[@type='checkbox'] [1]")
    public List<WebElement> allCheckBoxes;

    @FindBy(xpath= "(//div/input[@type='text'])[2]")
    public WebElement driverBox;

    @FindBy(xpath = "(//div/input[@type='text'])[3]")
    public WebElement locationBox;

    @FindBy(xpath ="(//div/input[@type='number'])[1]")
    public WebElement chassisNumberBox;

    @FindBy(xpath ="(//div/input[@type='text'])[4]")
    public WebElement modelYearBox;

    @FindBy(xpath = "(//div/input[@type='number'])[2]")
    public WebElement lastOdometerBox;

    @FindBy(xpath= "(//div/input[@type='text'])[5]")
    public WebElement immatriculationDateBox;

    @FindBy(xpath = "//div/select[@class='ui-datepicker-year']")
    public WebElement calenderYear;
    //select by visible text ==> 2017

    @FindBy(xpath = "//div/select[@class='ui-datepicker-month']")
    public WebElement calenderMonth;
    //select by visible text ==> Sep

    @FindBy(xpath = "//div/select[@class='ui-datepicker-month']")
    public WebElement calenderDay;


    @FindBy(xpath = "//div/button[@data-handler='today']")
    public WebElement todayDateOption;


    @FindBy(xpath = "(//div/input[@type='text'])[6]")
    public WebElement firstContractDateBox;

    @FindBy(xpath = "(//div/input[@type='text'])[7]")
    public WebElement catalogValueBox;

    @FindBy(xpath = "(//div/input[@type='number'])[3]")
    public WebElement seatsNumberBox;

    @FindBy(xpath = "(//div/input[@type='number'])[4]")
    public WebElement doorsNumberBox;

    @FindBy(xpath= "(//div/input[@type='text'])[8]")
    public WebElement colorBox;

    @FindBy(xpath = "(//a/span[text()='Choose a value...'])[1]")
    public WebElement transmissionDropDown;

    @FindBy(xpath = "(//li/div[@class='select2-result-label'])[1]")
    public WebElement transmissionOptionMaual;

    @FindBy(xpath = "(//li/div[@class='select2-result-label'])[1]")
    public WebElement transmissionOptionAutomatic;

    @FindBy(xpath = "(//a/span[@class='select2-chosen'])[2]")
    public WebElement fuelTypeDropDown;

    @FindBy(xpath = "(//li/div[@class='select2-result-label'])[2]")
    public WebElement fuelTypeDiesel;
    //div/input[@type='file']

    @FindBy(xpath =" (//div/input[@type='text'])[11]")
    public WebElement emissionBox;

    @FindBy(xpath = "(//div/input[@type='number'])[5]")
    public WebElement horsepowerBox;

    @FindBy(xpath= "(//div/input[@type='text'])[12]")
    public WebElement horsepowerTaxationBox;

    @FindBy(xpath = "(//div/input[@type='number'])[6]")
    public WebElement powerBox;

    @FindBy(xpath= "//div/input[@type='file']")
    public WebElement logoUploadBox;

    @FindBy(xpath = "(//div/button[@class='btn btn-medium add-btn'])[1]")
    public WebElement vehicleModelBtn;

    @FindBy(xpath = "(//div/button[@class='btn btn-medium add-btn'])[2]")
    public WebElement vehicleMakeBtn;

    @FindBy(xpath="//div[@class='pull-right pinned-dropdown']")         // //div/button[@class='btn btn-success action-button']
    public WebElement saveAndClose;

    @FindBy(xpath = "//a[@class='btn-success btn dropdown-toggle']")
    public WebElement saveAndCloseDropDown;

    @FindBy(xpath = "// li/button[@type='submit']")
    public WebElement saveAndCloseInDropDown;


    @FindBy(className = "message")
    public WebElement toastMessage;

    @FindBy(className = "message")
    public WebElement flashMessage;


    public CreateVehiclePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void createVehicleWithManager(String tagsName) {
        Actions action = new Actions(Driver.getDriver());
       /* fleetBtn.click();
        BrowserUtility.waitFor(2);
        vehicleBtn.click();
        BrowserUtility.waitFor(5);
        BrowserUtility.checkVisibilityOfElement(By.xpath("//div/a[@title='Create Car']"), 10);
        action.click(createCarBtn).pause(1000).perform();

        BrowserUtility.waitFor(5);

        */
        action.moveToElement(fleetBtn).perform();
        BrowserUtil.waitfor(2);
        action.moveToElement(vehicleBtn).pause(2000).click().perform();
        BrowserUtil.waitfor(5);
        //Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        action.click(createCarBtn).click().perform();
        BrowserUtil.waitfor(3);

        Faker faker = new Faker();
        action.click(licencePlateBox).pause(2000).sendKeys(faker.number().digits(9)).perform();
        BrowserUtil.waitfor(5);

        if (tagsName.equalsIgnoreCase("Junior")) {
            allCheckBoxes.get(0).click();
        } else if (tagsName.equalsIgnoreCase("Senior")) {
            allCheckBoxes.get(1).click();
        } else if (tagsName.equalsIgnoreCase("Employee Car")) {
            allCheckBoxes.get(2).click();
        } else if (tagsName.equalsIgnoreCase("Purchased")) {
            allCheckBoxes.get(3).click();
        } else if (tagsName.equalsIgnoreCase("Compact")) {
            allCheckBoxes.get(4).click();
        } else if (tagsName.equalsIgnoreCase("Sedan")) {
            allCheckBoxes.get(5).click();
        } else if (tagsName.equalsIgnoreCase("Convertible")) {
            allCheckBoxes.get(6).click();

        }

        BrowserUtil.waitfor(2);

        action.click(driverBox).pause(1000).sendKeys(faker.name().fullName()).perform();
        BrowserUtil.waitfor(2);
/*
        action.click(locationBox).pause(1000).sendKeys(faker.address().city()).perform();
        BrowserUtility.waitFor(2);
        action.click(chassisNumberBox).pause(1000).sendKeys(faker.number().digits(17)).perform();
        BrowserUtility.waitFor(2);

        action.click(modelYearBox).pause(1000).sendKeys(String.valueOf(faker.number().numberBetween(2000, 2022))).perform();
        BrowserUtility.waitFor(2);
        action.click(lastOdometerBox).pause(1000).sendKeys(faker.number().digits(10)).perform();
        BrowserUtility.waitFor(2);

        immatriculationDateBox.click();
        BrowserUtility.waitFor(5);
        todayDateOption.click();
        BrowserUtility.waitFor(2);
        firstContractDateBox.click();
        BrowserUtility.waitFor(2);
        todayDateOption.click();
        BrowserUtility.waitFor(2);

        action.click(catalogValueBox).pause(1000).sendKeys(faker.number().digits(7)).perform();
        BrowserUtility.waitFor(2);

        action.click(seatsNumberBox).pause(1000).sendKeys(String.valueOf(faker.number().numberBetween(2, 6))).
                sendKeys(Keys.TAB).perform();
        BrowserUtility.waitFor(2);

        doorsNumberBox.sendKeys(String.valueOf(faker.number().numberBetween(2, 4)));
        BrowserUtility.waitFor(2);

        action.click(colorBox).sendKeys(faker.color().name()).perform();
        BrowserUtility.waitFor(2);

        transmissionDropDown.click();
        BrowserUtility.waitFor(2);
       transmissionOptionMaual.click();
        BrowserUtility.waitFor(2);

        fuelTypeDropDown.click();
        BrowserUtility.waitFor(2);
        fuelTypeDiesel.click();
        BrowserUtility.waitFor(2);

        action.click(emissionBox).pause(1000).sendKeys(faker.number().digits(8)).perform();
        BrowserUtility.waitFor(2);
        action.click(horsepowerBox).pause(1000).sendKeys(faker.number().digits(4)).perform();
        BrowserUtility.waitFor(2);
        action.click(horsepowerTaxationBox).pause(1000).sendKeys(faker.number().digits(6)).perform();
        BrowserUtility.waitFor(2);
        action.click(powerBox).pause(1000).sendKeys(faker.number().digits(8)).perform();
*/
        BrowserUtil.waitfor(2);
        saveAndClose.click();
        BrowserUtil.waitfor(10);
        // saveAndCloseDropDown.click();
        BrowserUtil.waitfor(2);
        // saveAndCloseInDropSown.click();
        BrowserUtil.waitfor(5);

        // System.out.println(toastMessage.getText());
        //  WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));

        // BrowserUtility.waitFor(2);
        // logoUploadBox.click();
        // BrowserUtility.waitFor(2);
        // String filePath = "\"C:\\Desktop\\wrk.png\"";
        //  action.click(logoUploadBox).pause(2).sendKeys(filePath).perform();

        //  BrowserUtility.waitFor(3);
        //  vehicleModelBtn.click();

        // BrowserUtility.waitFor(2);
        //  vehicleMakeBtn.click();

        // BrowserUtility.waitFor(2);
        //   saveAndClose.click();
        //  BrowserUtility.waitFor(25);





        //  BrowserUtility.checkVisibilityOfElement(By.xpath("//*[@id=\"flash-messages\"]/div/div"), 10);
        //  String expectedToastMsg = toastMessage.getText();
        //  Assertions.assertEquals("Entity saved",toastMessage.getText());

        Assertions.assertEquals("Entity saved",flashMessage.getText());

    }


}
