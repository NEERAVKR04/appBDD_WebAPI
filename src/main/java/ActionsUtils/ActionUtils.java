package ActionsUtils;

import java.io.IOException;
import java.time.Duration;

import BaseClass.Base;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beust.jcommander.internal.Lists;


public class ActionUtils extends Base {
	
	
	public String getTitle() {
		
		return driver.getTitle();
		
	}
	
	public void openApplication(String variable) throws IOException {
		System.out.println("Opening application...");
		driver.get(getProperties().getProperty(variable));
	}
	
	public void switchWindow() {
		String parent_wind = driver.getWindowHandle();
		
		Set<String> windows=driver.getWindowHandles();
		
		Iterator<String> iter=windows.iterator();
		
		while(iter.hasNext()) {
			
			String child_window=iter.next();
			
			if(!parent_wind.equals(child_window)) {
				driver.switchTo().window(child_window);
			}
			
		}
	}
	
	public void switchToWindowIndex(int index) throws InterruptedException {
		
		List<String> windowTabs=Lists.newArrayList(driver.getWindowHandles());
		
		driver.switchTo().window(windowTabs.get(index));
		Thread.sleep(2000);
	}
	
	public void waitImplicitly(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	public void waitExplicitly(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	public void waitFluently(WebElement ele) {
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//		.withTimeout(Duration.ofSeconds(10))
//		.pollingEvery(Duration.ofSeconds(2))
//		.ignoring(NoSuchElementException.class)
//		.until(ExpectedConditions.visibilityOf(ele));
	}

}
