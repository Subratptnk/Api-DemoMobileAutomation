package subratpattanaik.api_demo_test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.HasSettings;

public class Exploring_AppSection extends AppiumConnector {

	/*
	 * TC-1:
	 * Step1: Open the api demo app
	 * Step2: Click on the App button from the list
	 * Step3: Search Activity and perform click on Activity
	 * Step4: Search HelloWorld and perform click on HelloWold
	 * Step5: Validate Hello world page
	 */
	@Test
	public void ActivityHelloWorldValidation() {
		System.out.println("***************************ActivityHelloWorldValidation starts***************************");
		WebElement appBtn = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"App\"]"));
		appBtn.click();
		WebElement activityBtn = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Activity\"]"));
		String isActivity = activityBtn.getAttribute("text");
		Assert.assertEquals(isActivity, "Activity");
		activityBtn.click();
		WebElement helloWorldBtn = driver.findElement(AppiumBy.accessibilityId("Hello World"));
		String isHelloWorld = helloWorldBtn.getAttribute("text");
		Assert.assertEquals(isHelloWorld, "Hello World");
		helloWorldBtn.click();
		String ValidationCheck = driver.findElement(By.xpath("//android.widget.TextView[@displayed = \"true\"]")).getAttribute("text");
		Assert.assertEquals(ValidationCheck, "App/Activity/Hello World");
		Boolean checkHelloWorld = driver.findElement(AppiumBy.accessibilityId("Hello, World!")).isDisplayed();
		Assert.assertTrue(checkHelloWorld);
		System.out.println("***************************ActivityHelloWorldValidation Done***************************");
	}
	
	/*
	 * TC-2:
	 * Step1: Open the api demo app
	 * Step2: Click on the App button from the list
	 * Step3: Search Activity and perform click on Activity
	 * Step4: Search Finish Affinity and perform click on that
	 * Step5: Check the current nesting number after clicking 5 times
	 * Step6: Click on finish
	 * Step7: Make sure you are on the previous page 
	 */	
	
	/**
	 * @throws Exception
	 */
	@Test
	public void ActivityFinishAffinityTest() throws Exception {
		System.out.println("*************************** ActivityFinishAffinityTest starts***************************");
		WebElement appBtn = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"App\"]"));
		appBtn.click();
		WebElement activityBtn = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Activity\"]"));
		String isActivity = activityBtn.getAttribute("text");
		Assert.assertEquals(isActivity, "Activity");
		activityBtn.click();
		WebElement finishAffinitydBtn = driver.findElement(AppiumBy.accessibilityId("Finish Affinity"));
		String isFinishAffinity = finishAffinitydBtn.getAttribute("text");
		Assert.assertEquals(isFinishAffinity, "Finish Affinity");
		String checkPagePosition = driver.findElement(By.xpath("//android.widget.TextView[@text=\"API Demos\"]")).getText();
		finishAffinitydBtn.click();
		
		boolean isCurrentNestingVisible = driver.findElement(By.id("io.appium.android.apis:id/seq")).isDisplayed();
		Assert.assertEquals(isCurrentNestingVisible, true);

		String currNestNum = driver.findElement(By.id("io.appium.android.apis:id/seq")).getText();
		
		System.out.println(currNestNum);
		System.out.println(count(currNestNum));
		Assert.assertEquals(count(currNestNum), "1");
		WebElement nextAffityBtn = driver.findElement(By.id("io.appium.android.apis:id/nest"));
		nextAffityBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		currNestNum = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]")).getText();
		System.out.println(currNestNum);
		System.out.println(count(currNestNum));
		Assert.assertEquals(count(currNestNum), "2");
		
		WebElement finishBtn = driver.findElement(AppiumBy.accessibilityId("FINISH!"));
		finishBtn.click();
		Assert.assertEquals(checkPagePosition, "API Demos");
		
		System.out.println("*************************** ActivityFinishAffinityTest Ends***************************");
		
		
	}
	
	@Test
	public void ActivityDialogTest() {
		System.out.println("*************************** ActivityDialogTest starts***************************");
		WebElement appBtn = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"App\"]"));
		appBtn.click();
		WebElement activityBtn = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Activity\"]"));
		String isActivity = activityBtn.getAttribute("text");
		Assert.assertEquals(isActivity, "Activity");
		activityBtn.click();
		WebElement dialog = driver.findElement(AppiumBy.accessibilityId("Dialog"));
		String isDialog = dialog.getAttribute("text");
		Assert.assertEquals(isDialog, "Dialog");
		dialog.click();
		String checkHeader = driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(checkHeader, "App/Activity/Dialog");
		WebElement addContentBtn = driver.findElement(By.id("io.appium.android.apis:id/add"));
		addContentBtn.click();
		boolean checkImg = driver.findElement(By.xpath("//android.widget.ImageView[@displayed = \"true\"]")).isDisplayed();
		Assert.assertEquals(checkImg, true);
		
		WebElement removeContentBtn = driver.findElement(By.id("io.appium.android.apis:id/remove"));
		removeContentBtn.click();	
		System.out.println("*************************** ActivityDialogTest Ends***************************"); 
	}
	
	@Test
	public void ActivityPresenationTest() {
		System.out.println("*************************** ActivityPresenationTest starts***************************");
		WebElement appBtn = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"App\"]"));
		appBtn.click();
		WebElement activityBtn = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Activity\"]"));
		String isActivity = activityBtn.getAttribute("text");
		Assert.assertEquals(isActivity, "Activity");
		activityBtn.click();
	
		WebElement presentationBtn = driver.findElement(AppiumBy.accessibilityId("Presentation"));
		presentationBtn.click();
		boolean checkTextVisible = driver.findElement(By.id("io.appium.android.apis:id/text")).isDisplayed();
		Assert.assertEquals(checkTextVisible, true);
		boolean checkShowbtnVisible = driver.findElement(By.id("io.appium.android.apis:id/show_all_displays")).isDisplayed();
		Assert.assertEquals(checkShowbtnVisible, true);
		
		WebElement checkbox = driver.findElement(By.id("io.appium.android.apis:id/show_all_displays"));
		checkbox.click();
		
		String text = driver.findElement(By.id("io.appium.android.apis:id/display_id")).getText();
		Assert.assertEquals(text, "Display #0: Built-in Screen");
		
		WebElement infoBtn = driver.findElement(AppiumBy.accessibilityId("Info"));
		infoBtn.click();
		
		WebElement alertPop = driver.findElement(By.id("android:id/alertTitle"));
		String alertMsg = alertPop.getAttribute("text");
		Assert.assertEquals(alertMsg, "Display #0 Info");
		
		WebElement alertOKBtn = driver.findElement(By.id("android:id/button3"));
		alertOKBtn.click();
		System.out.println("*************************** ActivityPresenationTest Ends***************************");
	}
}
