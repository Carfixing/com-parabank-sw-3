package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {
   /* 1.verifyThatSigningUpPageDisplay
			* click on the ‘Register’ link
			* Verify the text ‘Signing up is easy!’*/
   String baseUrl = " https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        // click on the ‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //Verify the text ‘Signing up is easy!’
        verifyTextNull("Signing up is easy!",getTextFromElement(By.className("title")),"Can not verify Message : ");

     }
      /*2.userSholdRegisterAccountSuccessfully
			* click on the ‘Register’ link
			* Enter First name
			* Enter Last name
			* Enter Address
			* Enter City
			* Enter State
			* Enter Zip Code
			* Enter Phone
			* Enter SSN
			* Enter Username
			* Enter Password
			* Enter Confirm
			* Click on REGISTER button
			* Verify the text 'Your account was created successfully. You are now logged in.’*/

    @Test
     public void userShouldRegisterAccountSuccessfully(){
       // click on the ‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //Enter First name
        sendTextToElement(By.id("customer.firstName"),"Jaimin3");
        //Enter Last name
        sendTextToElement(By.id("customer.lastName"),"Patel");
        //Enter address
        sendTextToElement(By.id("customer.address.street"),"4A Apt Second Avenue");
        //Enter City
        sendTextToElement(By.id("customer.address.city"),"Broklyn");
        //Enter state
        sendTextToElement(By.id("customer.address.state"),"New york");
        //Enter ZipCode
        sendTextToElement(By.id("customer.address.zipCode"),"11220");
        //Enter phone
        sendTextToElement(By.id("customer.phoneNumber"),"73237236683");
        //Enter SSN
        sendTextToElement(By.id("customer.ssn"),"123456789");
        //Enter Username
        sendTextToElement(By.id("customer.username"),"Jaimin2");
        //Enter password
        sendTextToElement(By.id("customer.password"),"12345@");
        //Enter conpassword
        sendTextToElement(By.id("repeatedPassword"),"12345@");
        //click on registre button
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        //Verify the text 'Your account was created successfully. You are now logged in.’
        //Verify the text ‘Signing up is easy!’
        verifyTextNull("Your account was created successfully. You are now logged in.",getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]")),"Can not verify Message : ");

    }
@After
    public void close(){
        driver.quit();
}
}
