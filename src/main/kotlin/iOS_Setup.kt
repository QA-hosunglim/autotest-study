import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.options.BaseOptions
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import java.net.MalformedURLException
import java.net.URL

class iOS_Setup {
    private lateinit var driver: IOSDriver

    @BeforeMethod
    fun setUp() {
        val options = BaseOptions()
            .amend("platformName", "iOS")
            .amend("appium:platformVersion", "17.5")
            .amend("appium:automationName", "XCuiTest")
            .amend("appium:udid", "177F3631-DCA7-4860-B5E7-1C945007D425")
            .amend("appium:app", "/Users/hosung.lim/Downloads/TestApp.app")
            .amend("appium:includeSafariInWebviews", true)
            .amend("appium:newCommandTimeout", 3600)
            .amend("appium:connectHardwareKeyboard", true)

        driver = IOSDriver(getUrl(), options)
    }

    private fun getUrl(): URL {
        return try {
            URL("http://127.0.0.1:4723")
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            throw RuntimeException("Invalid URL")
        }
    }

    @Test
    fun PrintAnswer() {
        // 테스트 케이스 작성
        driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"IntegerA\"]")).sendKeys("2022")
        driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"IntegerB\"]")).sendKeys("0817")
        driver.findElement(By.name("ComputeSumButton")).click()

        val Answer = driver.findElement(By.name("Answer")).text
        println("$Answer")
    }

    @AfterMethod
    fun tearDown() {
        driver.quit()
    }
}