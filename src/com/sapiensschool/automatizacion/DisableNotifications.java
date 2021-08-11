package com.sapiensschool.automatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableNotifications {

	public static void main(String[] args) {
		ChromeOptions notifications = new ChromeOptions();
		notifications.addArguments("--disable-notifications");
		// In this code we will disable notificacions
		System.setProperty("webdriver.chrome.driver", "D:\\driversParaNavegadores\\chromedriver.exe");
		//Here we will create and launch our browser
		WebDriver customDriver = new ChromeDriver(notifications);
		customDriver.get("https://www.reddit.com/");
		customDriver.findElement(By.id("header-search-bar")).sendKeys("TestingConcepts");
	}

}
