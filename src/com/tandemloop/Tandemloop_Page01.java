package com.tandemloop;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tandemloop_Page01 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver dri = new ChromeDriver();
		dri.manage().window().maximize();
		dri.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dri.get("https://qainterview.pythonanywhere.com/");
		dri.findElement(By.id("number")).sendKeys("100");
		dri.findElement(By.id("getFactorial")).click();
		String text = dri.findElement(By.xpath("//p[contains (text(),'The factorial of 100 is')]")).getText();
		System.out.println(text);
		dri.quit();
	}
}
