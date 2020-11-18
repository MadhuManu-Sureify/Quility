package Sureify.AutomationTemplate;

/**
 * @author Madhu Babu
 * @date 11-Mar-2020
 * @desc Selenium and Generic functions class
 */

import java.io.File;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.ScreenRecorder;

public class WebActions
{
	static ScreenRecorder recorder;
	static boolean recordFlag = true;
	
	public static WebDriver driver = null;
	public static WebDriverWait w;

	public static String launchSite(WebDriver dr) 
    {
		driver = dr;
		w = new WebDriverWait(driver, 50);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		driver.get(EnvSetup.siteURL_UAT);
		Suite.testInfo.log(LogStatus.INFO, " <h6>About this Test</h6>");
		Suite.testInfo.log(LogStatus.INFO, "<b>Url: </b>" + driver.getCurrentUrl());
		
		return driver.getTitle();
	}
	
	public static void quit() 
    {
		driver.quit();
    }
	
	public static void get(String url) 
    {
		driver.manage().window().maximize();
		driver.get(url);
    }
	
	public static void logTestPass(ExtentTest test, String elm)
	{
		test.log(LogStatus.PASS, elm + " Test Passed");
		Suite.logger.info(elm + " Test Passed");
	}
	
	public static void logTestFail(ExtentTest test, String elm)
	{
		if(elm.contains("Txt"))
			moveToElement(driver.findElement(By.id(elm)));
		else if(elm.contains("//"))
			moveToElement(driver.findElement(By.xpath(elm)));

		try {
			test.log(LogStatus.FAIL, elm + "Test Failed " + test.addBase64ScreenShot(getScreenshot(driver)));
			Suite.logger.info(elm +  " Test Failed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void logTestError(ExtentTest test, int exType) throws Exception
	{
		switch(exType) {
		
		case 1:
			test.log(LogStatus.ERROR, "Element no longer available", test.addBase64ScreenShot(getScreenshot(driver)));;
		    break;
		case 2:
			test.log(LogStatus.ERROR, "No Session is Running or session closed", test.addBase64ScreenShot(getScreenshot(driver)));
		    break;
		case 3:
			test.log(LogStatus.ERROR, "Webdriver initiation error", test.addBase64ScreenShot(getScreenshot(driver)));
		    break;
		case 4:
			test.log(LogStatus.ERROR, "Element is not found", test.addBase64ScreenShot(getScreenshot(driver)));
		    break;
		case 5:
			test.log(LogStatus.ERROR, "Element is overlayed by another element", test.addBase64ScreenShot(getScreenshot(driver)));
		    break;
		case 6:
			test.log(LogStatus.ERROR, "Waiting/Loading time over", test.addBase64ScreenShot(getScreenshot(driver)));
		    break;
		default:
			test.log(LogStatus.ERROR, "No Definition");
		}
	}
	
	public static void logVideo(ExtentTest test, String mediaPath)
	{
		test.log(LogStatus.INFO,  "<video controls><source src=\"" + System.getProperty("user.dir") + mediaPath + "\" type=\"video/mp4\"></video>");
	}
	
	public static void handleException(ExtentTest test, Exception e)
	{
		Suite.logger.info("Got exception : " + e.getMessage());
		try {
			if(e.getMessage().contains("StaleElementReferenceException"))
				logTestError(test, 1);
			else if(e.getMessage().contains("NoSuchSessionException"))
				logTestError(test, 2);
			else if(e.getMessage().contains("WebDriverException"))
				logTestError(test, 3);
			else if(e.getMessage().contains("NoSuchElementException") || e.getMessage().contains("no such element: Unable to locate element:"))
				logTestError(test, 4);
			else if(e.getMessage().contains("element click intercepted"))
				logTestError(test, 5);
			else if(e.getMessage().contains("TimeoutException"))
				logTestError(test, 6);
			else
				test.log(LogStatus.ERROR, "Exception: " + e.getMessage(), test.addScreenCapture(getScreenshot(driver)));
		}catch(Exception ex) {}
	}
	
	public static String getScreenshot(WebDriver driver) throws Exception
	{
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String srcBASE64 = scrShot.getScreenshotAs(OutputType.BASE64);
//		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName(); //Method name is the string which is calling method name
		String filePath = System.getProperty("user.dir") + "/target/Report/fail-screens/Screenshot_" + System.getProperties().get("user.name") +
				"_" + new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date()) + ".png";
		System.out.println(filePath);
		File DestFile=new File(filePath);
		FileUtils.copyFile(SrcFile, DestFile);
		
		return "data:image/jpeg;base64,"+ srcBASE64;
	}
	
	public static void foo()
	{
		String method_name = Thread.currentThread().getStackTrace()[2].getMethodName();
		System.out.println(method_name);
		System.out.println("this is the method");
	}
	
    public static String startRecorder()
    {
    	String outputFilename = "";
    	try {
    		outputFilename = "target/Report/recordedVideo/RecordedVideo_" + new SimpleDateFormat("ddMMyyyy_HHmmssSSS").format(new Date()) + ".mp4";
    		recorder = new ScreenRecorder(outputFilename);
    		recorder.startCapture();
    	}
    	catch(Exception ex){System.out.println(ex.getMessage());}
    	
    	return outputFilename;
    }
    
	public static void stopRecorder()
	{
		try {
			recorder.stopCapture();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public static void sendKeys(WebElement varEle, String Data)
	{
		waitFor(varEle);
		varEle.sendKeys(Data);
	}

	public static String getText(WebElement varEle)
	{
		waitFor(varEle);
		return varEle.getText();
	}

	public static String getText(String xpath)
	{
		dynamicWait(xpath);
		
		return driver.findElement(By.xpath(xpath)).getText();
	}

	public static boolean isDisplayed(String xpath)
	{
		dynamicWait(xpath);

		return driver.findElement(By.xpath(xpath)).isDisplayed();
	}
	
	public static void click(WebElement varEle) throws Exception
	{
		try {
			waitFor(varEle);
			varEle.click();
		}catch(Exception e)
		{
			jsScrollIntoView(varEle);
			varEle.click();
		}	
	}
	
	public static void clickXpath(String xpath) throws Exception
	{
		WebElement varEle = driver.findElement(By.xpath(xpath));
		try {
			waitFor(varEle);
			varEle.click();
		}catch(Exception e)
		{
			jsScrollIntoView(varEle);
			Thread.sleep(200);
			varEle.click();
		}	
	}
	
	public static void clickID(String id) throws Exception
	{
		WebElement varEle = driver.findElement(By.id(id));
		try {
			waitFor(varEle);
			varEle.click();
		}catch(Exception e)
		{
			jsScrollIntoView(varEle);
			varEle.click();
		}	
	}
	
	public static void jsClick(WebElement varEle)
	{
		try {
			waitFor(varEle);
			DriverSetUP.js.executeScript("arguments[0].click();", varEle);
			Thread.sleep(500);
		}catch(Exception e) {
			System.out.println("Javascript Click is failed to click on elment: " + e.getMessage());
		}
		
	}
	
	public static void jsClick(String xpath) throws Exception
	{
		try {
			waitFor(xpath);
			WebElement varEle = driver.findElement(By.xpath(xpath));
			DriverSetUP.js.executeScript("arguments[0].click();", varEle);
			Thread.sleep(500);
		}catch(Exception e) {
			System.out.println("Javascript Click is failed to click on elment: " + e.getMessage());
		}
		
	}
	
	public static void jsSendKeys(WebElement varEle, String value) throws Exception
	{
		waitFor(varEle);
		DriverSetUP.js.executeScript("arguments[0].value='"+ value +"';", varEle);;
		Thread.sleep(500);
	}
	
	public static void clear(WebElement varEle) throws Exception
	{
		waitFor(varEle);
		varEle.clear();
	}
	
	public static void jsScrollToBottom() throws Exception
	{
		DriverSetUP.js.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		Thread.sleep(400);
	}
	
	public static void jsScrollBy(int x, int y) throws Exception
	{
		DriverSetUP.js.executeScript("window.scrollBy(" + x +"," + y + ")");
		Thread.sleep(400);
	}
	
	public static void jsScrollToEnd() throws Exception
	{
		DriverSetUP.js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(400);
	}
	
	public static void jsScrollIntoView(WebElement varEle) throws Exception
	{
		waitFor(varEle);
		DriverSetUP.js.executeScript("arguments[0].scrollIntoView();", varEle);//Define the position change to True
		Thread.sleep(400);
	}
	
	public static void jsScrollIntoView(WebElement varEle, boolean flag) throws Exception
	{
		waitFor(varEle);
		DriverSetUP.js.executeScript("arguments[0].scrollIntoView(" + flag + ");", varEle);//Define the position change to True
		Thread.sleep(400);
	}
	
	public static void moveToElement(WebElement varEle)
	{
		new Actions(driver).moveToElement(varEle).perform();
	}
	
	public static void actionsClick(WebElement varEle)
	{
		new Actions(driver).click(varEle).perform();
	}
	
	public static void clickAndHold(WebElement varEle)
	{
		new Actions(driver).clickAndHold(varEle).perform();
	}
	
	public static void release(WebElement varEle)
	{
		new Actions(driver).release(varEle).perform();
	}
	
	public static void contextClick(WebElement varEle)
	{
		new Actions(driver).contextClick(varEle).perform();
	}
	
	public static void doubleClick(WebElement varEle)
	{
		new Actions(driver).doubleClick(varEle).perform();
	}
	
	public static void dragAndDrop(WebElement varEle1, WebElement varEle2)
	{
		new Actions(driver).dragAndDrop(varEle1, varEle2).perform();
	}
	
	public static void actionsSendKeys(WebElement varEle, String value)
	{
		new Actions(driver).sendKeys(varEle, value).perform();
	}
	
	public static void deselectAll(WebElement varEle)
	{
		waitFor(varEle);
		Select s = new Select(varEle);
		s.deselectAll();
	}
	
	public static void deselectByIndex(WebElement varEle, int index)
	{
		waitFor(varEle);
		Select s = new Select(varEle);
		s.deselectByIndex(index);
	}
	
	public static void deselectByValue(WebElement varEle, String value)
	{
		waitFor(varEle);
		Select s = new Select(varEle);
		s.deselectByValue(value);
	}
	
	public static void deselectByVisibleText(WebElement varEle, String text)
	{
		waitFor(varEle);
		Select s = new Select(varEle);
		s.deselectByVisibleText(text);
	}
	
	public static void selectByIndex(WebElement varEle, int index)
	{
		waitFor(varEle);
		Select s = new Select(varEle);
		s.selectByIndex(index);
	}
	
	public static void selectByValue(WebElement varEle, String value)
	{
		waitFor(varEle);
		Select s = new Select(varEle);
		s.selectByValue(value);
	}
	
	public static void selectByVisibleText(WebElement varEle, String text)
	{
		waitFor(varEle);
		Select s = new Select(varEle);
		s.selectByVisibleText(text);
	}
	
	public static void selectItem(WebElement varEle, String itemName) throws Exception
	{
		waitFor(varEle);
		Thread.sleep(100);
		click(varEle);
		Thread.sleep(200);
		click(driver.findElement(By.xpath("//*[text()='"+ itemName + "']")));
	}

	public static void selectmapLOC(WebElement varEle, String itemName) throws Exception
	{
		waitFor(varEle);
		varEle.sendKeys(itemName);
		Thread.sleep(500);
		varEle.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(200);
	}
	
	public static void navigate(String navigation)
	{
		if(navigation.equalsIgnoreCase("BACK")) {
			driver.navigate().back();
		}else if(navigation.equalsIgnoreCase("REFRESH")) {
			driver.navigate().refresh();
		} else if(navigation.equalsIgnoreCase("FORWARD")) {
			driver.navigate().forward();
		} 
	}
	
	public static void navigateTo(String url)
	{
		driver.navigate().to(url);
	}
	
	public static void switchToActive()
	{
		driver.switchTo().activeElement();
	}
	
	public static void switchToDefault()
	{
		driver.switchTo().defaultContent();
	}
	
	public static void waitFor(String xpath)
	{
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));	
	}
	
	public static void waitFor(WebElement varEle)
	{
		w.until(ExpectedConditions.visibilityOf(varEle));
		w.until(ExpectedConditions.elementToBeClickable(varEle));
	}
	
	public static void dynamicWait(String xpath)
	{
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		w.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
	public static void dynamicWaitToClickable(WebElement varEle)
	{
		w.until(ExpectedConditions.elementToBeClickable(varEle));
	}
	
	//Update this By send keys/ by selectDOB
	public static void selectDOB(WebElement varEle, int date, int month, int year) throws Exception
	{		
		WebElement dateWidget = varEle;
		click(dateWidget);
		
		Select yearSelect = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
		yearSelect.selectByVisibleText(Integer.toString(year));
		
		Select monthSelect = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
		monthSelect.selectByIndex(month-1);

		click(driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--0"+ Integer.toString(date) + "']")));
	}
	
	public static void enterDOB(WebElement varEle, String date) throws Exception
	{		
		WebElement dateWidget = varEle;
		click(dateWidget);
		sendKeys(dateWidget, date);
	}

	public static void enterDATE(String xpath, String date) throws Exception
	{
		WebElement dateWidget = driver.findElement(By.xpath(xpath));
		click(dateWidget);
		sendKeys(dateWidget, date);
		driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
	}
	
	public static void clickContinue() throws Exception
	{
		dynamicWait(AppData.continueBtn);
		WebElement varEle = driver.findElement(By.xpath(AppData.continueBtn));
		try {
			varEle.click();
		}catch(Exception e)
		{
			jsScrollIntoView(varEle);
			varEle.click();
		}	
	}
	
	public static void clickNestedContinue() throws Exception
	{
		waitFor(driver.findElement(By.xpath(AppData.continueBtn)));
		Thread.sleep(200);
		WebElement lastContinueBtnInPage = driver.findElements(By.xpath(AppData.continueBtn)).get(driver.findElements(By.xpath(AppData.continueBtn)).size()-1);
		jsScrollIntoView(lastContinueBtnInPage);
		click(lastContinueBtnInPage);
	}
	
	public static void clickNext() throws Exception
	{
		waitFor(driver.findElement(By.xpath(AppData.nextBtn)));
		w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(AppData.nextBtn))));
		int msTime = 30000; 
		int doUntil = (int) (msTime + System.currentTimeMillis());
		while(System.currentTimeMillis() != doUntil)
		{
			try {
				if(driver.findElement(By.xpath(AppData.nextBtn)).isEnabled())
				{
					click(driver.findElement(By.xpath(AppData.nextBtn)));
					break;
				}
			}catch(Exception nextEx) {}
		}
	}
	
	public static void clickSave() throws Exception
	{
		waitFor(driver.findElement(By.xpath(AppData.saveBtn)));
		Thread.sleep(1000);
		jsScrollIntoView(driver.findElement(By.xpath(AppData.saveBtn)));
		click(driver.findElement(By.xpath(AppData.saveBtn)));
	}
	
	public static boolean validateElement(String loc) throws Exception
	{
		boolean flag = false;

		if(driver.findElement(By.xpath(loc)).isDisplayed()) {
			jsScrollIntoView(driver.findElement(By.xpath(loc)));
			dynamicWaitToClickable(driver.findElement(By.xpath(loc)));
			flag = true;
		}
		
		return flag;
	}
	
	public static void doDocSign() throws Exception
	{
		

	}
}
