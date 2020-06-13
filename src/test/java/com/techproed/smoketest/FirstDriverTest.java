package com.techproed.smoketest;
import com.techproed.pages.FhcLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Drivers;
import org.testng.Assert;
import org.testng.annotations.Test;
public class FirstDriverTest {
    private Drivers Driver;

    @Test
    public void invalidPass() throws InterruptedException {
        //driver  ====   >>>>>>  Driver.
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        FhcLoginPage fhcLoginPage = new FhcLoginPage(Driver.getDriver());
        //correct username but incorrect pass
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("valid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("invalid_password"));
        Thread.sleep(5000);
        fhcLoginPage.login.click();

        Assert.assertTrue(fhcLoginPage.error_message.getText().contains(ConfigReader.getProperty("login_error_message")));
    }
}


