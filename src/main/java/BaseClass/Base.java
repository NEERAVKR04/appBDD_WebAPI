package BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	
	public static Properties prop;
	
	public static Properties getProperties() throws IOException {
		prop=new Properties();
		
//		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\global.properties");
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/global.properties");

		prop.load(fis);
		
		String env = prop.getProperty("env");
		System.out.println(env);
		
		
		
		if(env.equalsIgnoreCase("PT")) {
//			FileInputStream fisPT = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\PT.properties");
			FileInputStream fisPT=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/PT.properties");

			prop.load(fisPT);

		}
		else if (env.equalsIgnoreCase("SIT")) {
//			FileInputStream fisSIT = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\SIT.properties");
			FileInputStream fisSIT=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/SIT.properties");

			prop.load(fisSIT);


		}
		
		return prop;
	}
		
	public static void launchBrowser() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		System.out.println("Open Web Browser...");
		
	}

}
