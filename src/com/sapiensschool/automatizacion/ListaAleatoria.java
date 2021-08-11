package com.sapiensschool.automatizacion;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ListaAleatoria {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions notifications = new ChromeOptions();
		notifications.addArguments("--disable-notifications");
		notifications.addArguments("--disable-extensions");
		// here we will create a code for a random list
		System.setProperty("webdriver.chrome.driver", "D:\\driversParaNavegadores\\chromedriver.exe");
		//Here we will create and launch our browser
		WebDriver customDriver = new ChromeDriver();
		customDriver.get("https://www.amazon.com/");
		customDriver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
		Thread.sleep(5000);
		WebElement temporalOptions = customDriver.findElement(By.id("suggestions"));
		List<WebElement> randomListOptions = temporalOptions.findElements(By.tagName("div"));
		System.out.println(randomListOptions.size());
		for (WebElement listOption: randomListOptions) {
			System.out.println(listOption.getText());
			if (listOption.getText().equals("laptop backpack")) {
				listOption.click();
				break;
			}
		}
		Thread.sleep(2000);
		System.out.println(customDriver.getTitle());
		Assert.assertEquals(customDriver.getTitle(), "Amazon.com : laptop backpack");
		customDriver.close();
		/* if (customDriver.getTitle().contains("Amazon.com : laptop stand for desk")) {
			System.out.println("Prueba Exitosa");
		} else {
			System.out.println("Prueba Fallida");
		}
		/* customDriver.findElement(By.id("twotabsearchtextbox")).sendKeys(" screen");
		Thread.sleep(3000);
		randomListOptions = customDriver.findElements(By.id("nav-flyout-searchAjax"));
		for (WebElement listOption: randomListOptions) {
			System.out.println(listOption.getText());
		} */
	}

}
