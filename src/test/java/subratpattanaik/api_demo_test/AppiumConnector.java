package subratpattanaik.api_demo_test;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumConnector {
	AndroidDriver driver; 
	@BeforeMethod
	public void openAppium() throws Exception {
		
		File f = new File("src"); 
		File fs = new File(f,"ApiDemos-debug.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "SubratPhone2");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println("*************************** App testing Started********************************");
	}
	

	public String count(String text) {
		String content = text;
		String[] words = content.split(":");
		for(String w : words) {
			System.out.println(w);
		}
		return words[1].trim();
	}
	
	@AfterMethod
	public void stopServer() {
		driver.quit();
		System.out.println("*************************** App testing Closed********************************");
	}
}
