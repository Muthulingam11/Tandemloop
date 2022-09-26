package com.tandemloop;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tandemloop_Page02 {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver dri = new ChromeDriver();
		dri.manage().window().maximize();
		dri.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dri.get("http://tester.tandemloop.ml/");
		dri.findElement(By.id("fn")).sendKeys("Tandemloop");
		dri.findElement(By.id("mob")).sendKeys("+91123456789");
		dri.findElement(By.id("add")).sendKeys("Nagarabhavi, Bengaluru, Karnataka");
		dri.findElement(By.id("emid")).sendKeys("Tandemloop@gmail.com");
		dri.findElement(By.id("pwsd")).sendKeys("1234567890");
		try {
			dri.findElement(By.xpath("(//input[@class='form-control'])[7]")).click();
			Robot rb = new Robot();
			StringSelection str = new StringSelection("path of file");
			Toolkit.getDefaultToolkit().getSystemClipboard().getContents(str);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Defect WebElement is not clickabe in automation");	
		}
		dri.findElement(By.id("b1")).click();
		String text = dri.findElement(By.xpath("//h1")).getText();
		System.out.println(text);
	}

}
