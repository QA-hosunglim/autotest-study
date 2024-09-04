package org.example

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.options.BaseOptions
import org.openqa.selenium.By
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import java.net.MalformedURLException
import java.net.URL

class Android_Setup {
    private lateinit var driver: AndroidDriver

    // 메뉴명
    private val AppButton: String
    private val ActiveButton: String
    private val CustomTitle: String
    private val LeftEditText: String
    private val RightEditText: String
    private val ChangeLeftButton: String
    private val ChangeRightButton: String
    private var LeftTitle: String
    private val RightTitle: String

    init {
        AppButton = "//android.widget.TextView[@content-desc=\"App\"]"
        ActiveButton = "//android.widget.TextView[@content-desc=\"Activity\"]"
        CustomTitle = "//android.widget.TextView[@content-desc=\"Custom Title\"]"
        LeftEditText = "io.appium.android.apis:id/left_text_edit"
        RightEditText = "io.appium.android.apis:id/right_text_edit"
        ChangeLeftButton = "//android.widget.Button[@content-desc=\"Change Left\"]"
        ChangeRightButton = "//android.widget.Button[@content-desc=\"Change Right\"]"
        LeftTitle = "io.appium.android.apis:id/left_text"
        RightTitle = "io.appium.android.apis:id/right_text"
    }

    @BeforeMethod
    fun setUp() {
        val options = BaseOptions()
            .amend("platformName", "Android")
            .amend("appium:platformVersion", "13.0")
            .amend("appium:deviceName", "Pixel 7 Pro API 33")
            .amend("appium:automationName", "UiAutomator2")
            .amend("appium:udid", "emulator-5554")
            .amend("appium:app", "/Users/hosung.lim/Downloads/ApiDemos-debug.apk")
            .amend("appium:ensureWebviewsHavePages", true)
            .amend("appium:nativeWebScreenshot", true)
            .amend("appium:newCommandTimeout", 3600)
            .amend("appium:connectHardwareKeyboard", true)

        driver = AndroidDriver(getUrl(), options)
    }

    private fun getUrl(): URL {
        return try {
            URL("http://127.0.0.1:4723")
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            throw RuntimeException("Invalid URL")
        }
    }

    fun ClickXpath(xPath: String){
        driver.findElement(By.xpath(xPath)).click()
    }

    fun ClearText(id: String){
        driver.findElement(By.id(id)).clear()
    }

    fun InputText(id: String, text: String){
        driver.findElement(By.id(id)).sendKeys(text)
    }

    private fun getTextFromElementById(id: String): String {
        val element = driver.findElement(By.id(id))
        return element.text
    }

    private fun printTitles() {
        val leftTitleText = getTextFromElementById(LeftTitle)
        val rightTitleText = getTextFromElementById(RightTitle)
        println("$leftTitleText $rightTitleText")
    }

    @Test
    fun ChangingTitle() {
        // 테스트 케이스 작성
        ClickXpath(AppButton)
        ClickXpath(ActiveButton)
        ClickXpath(CustomTitle)
        ClearText(LeftEditText)
        ClearText(RightEditText)
        InputText(LeftEditText,"ChangeTitle")
        InputText(RightEditText,"Homework")
        ClickXpath(ChangeLeftButton)
        ClickXpath(ChangeRightButton)
        printTitles()
    }

    @AfterMethod
    fun tearDown() {
        driver.quit()
    }
}