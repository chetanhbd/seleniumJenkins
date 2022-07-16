package appHooks;

import com.qa.factory.DriverFactory;
import com.qa.utill.configReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class applicationHooks {
    private DriverFactory driverFactory;

    private WebDriver driver;

    private configReader config;

    private Properties properties;

    @Before(order = 0)
    public void getProperty(){
        config = new configReader();
        properties = config.initializeProperties();

    }
    @Before(order = 1)
    public void launchBrowser(){
        String browserName = properties.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.initializeDriver(browserName);

    }

    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario sc){
        if(sc.isFailed()){
            String screenShot = sc.getName().replaceAll("","_");
            byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            sc.attach(sourcePath,"image/png", screenShot);
        }

    }
}
