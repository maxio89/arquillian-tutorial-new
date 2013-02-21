package pl.itcrowd.tutorial.arquillian;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.enricher.findby.FindBy;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.itcrowd.tutorial.arquillian.jsf.Credentials;
import pl.itcrowd.tutorial.arquillian.jsf.User;
import pl.itcrowd.tutorial.arquillian.jsf.UserAuthenticator;

import java.io.File;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: piotrek
 * Date: 2/20/13
 * Time: 12:46 PM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(Arquillian.class)
public class LoginTest {

    private static final String WEBAPP_SRC = "src/main/webapp";

    @Drone
    WebDriver browser;

    @ArquillianResource
    URL deploymentUrl;

    @FindBy(id = "loginForm:username")
    private WebElement usernameInput;

    @FindBy(id = "loginForm:password")
    private WebElement passwordInput;

    @FindBy(id = "loginForm:login")
    private WebElement loginButton;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "login.war")
                .addClasses(Credentials.class, User.class, UserAuthenticator.class)
                .addAsWebResource(new File(WEBAPP_SRC, "login.xhtml"))
                .addAsWebResource(new File(WEBAPP_SRC, "home.xhtml"))
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource(new File(WEBAPP_SRC, "WEB-INF/faces-config.xml"))
                .addAsWebInfResource(new File(WEBAPP_SRC, "WEB-INF/web.xml"));
    }

    @Test
    public void loginSuccessfullyTest() {

        browser.get(deploymentUrl + "login.jsf");

        usernameInput.sendKeys("demo");
        passwordInput.sendKeys("demo");

        loginButton.click();

        Assert.assertTrue("User should be logged in!",
                isElementPresent(By.xpath("//li[contains(text(), 'Welcome')]")));
        Assert.assertTrue("Username should be shown!",
                isElementPresent(By.xpath("//p[contains(text(), 'You are signed in as demo.')]")));

    }

    public boolean isElementPresent(By locator) {
        return browser.findElements(locator).size() > 0 ? true : false;
    }

}
