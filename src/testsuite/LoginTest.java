package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = " https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    //userShouldLoginSuccessfullyWithValidCredentials
    //			* Enter valid username
    //			* Enter valid password
    //			* Click on ‘LOGIN’ button
    //			* Verify the ‘Accounts Overview’ text is display
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter valid username
        sendTextToElement(By.xpath("//input[@name='username']"),"Jaimin2");
        // Enter valid password
        sendTextToElement(By.xpath("//input[@name='password']"),"12345@");
        // Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value='Log In']"));
        //Verify the ‘Accounts Overview’ text is display
//        String expectedMessage = "Accounts Overview";
//        String actualMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
//        Assert.assertEquals("Can not verify Message : ", expectedMessage, actualMessage);
        verifyTextNull("Accounts Overview", getTextFromElement(By.xpath("//h2[contains(text(),'Customer Login')]")),"Can not verify Message : ");

    }
    /*verifyTheErrorMessage
			* Enter invalid username
			* Enter invalid password
			* Click on Login button
			* Verify the error message ‘The username and password could not be verified.’*/
    @Test
    public void verifyTheErrorMessage() {
        // Enter invalid username
        sendTextToElement(By.xpath("//input[@name='username']"), "Ja562");

        //Enter invalid password
        sendTextToElement(By.xpath("//input[@name='password']"), "1345]#@");

        // Click on Login button
        clickOnElement(By.xpath("//input[@value='Log In']"));

        // Verify the error message ‘The username and password could not be verified.’
//        String expectedMessage = "The username and password could not be verified.";
//        String actualMessage = getTextFromElement(By.xpath("//p[contains(text(),'An internal error has occurred and has been logged')]"));
//        Assert.assertEquals("Can not verify Message : ", expectedMessage, actualMessage);
        verifyTextNull("The username and password could not be verified.", getTextFromElement(By.xpath("//p[contains(text(),'An internal error has occurred and has been logged')]")),
                "Can not verify Message : ");
    }
    //.userShouldLogOutSuccessfully
    //			* Enter valid username
    //			* Enter valid password
    //			* Click on ‘LOGIN’ button
    //			* Click on ‘Log Out’ link
    //			* Verify the text ‘Customer Login’
    @Test
    public void userShouldLogOutSuccessfully(){
        //Enter valid username
        sendTextToElement(By.xpath("//input[@name='username']"),"Jaimin2");
        // Enter valid password
        sendTextToElement(By.xpath("//input[@name='password']"),"12345@");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@value='Log In']"));
       //Click on ‘Log Out’ link
        clickOnElement(By.xpath("//a[@href='/parabank/logout.htm']"));
      // Verify the text ‘Customer Login’
        verifyTextNull("Customer Login",getTextFromElement(By.xpath("//p[contains(text(),'An internal error has occurred and has been logged')]"))
,"Can not verify Message :");


    }
    @After
    public void close(){
        driver.quit();
    }

}
