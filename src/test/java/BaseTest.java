import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void warmUp() {
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.getDriver().quit();
    }
}
