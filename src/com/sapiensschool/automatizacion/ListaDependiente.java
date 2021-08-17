package com.sapiensschool.automatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListaDependiente {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\driversParaNavegadores\\chromedriver.exe");
		WebDriver customDriver = new ChromeDriver();
		customDriver.get("https://www.codigopostal.gob.ec/");
		customDriver.manage().window().maximize();
		customDriver.findElement(By.xpath("/html/body/div[1]/section/div[4]/article[1]/div[1]/div[1]/div/p[1]/span/span/span/span"));
		Thread.sleep(2000);
		customDriver.findElement(By.xpath("//*[@id=\"provincias_listbox\"]/li[19]"));
		Thread.sleep(2000);
	}

}
