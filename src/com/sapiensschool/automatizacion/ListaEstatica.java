package com.sapiensschool.automatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListaEstatica {

	public static void main(String[] args) throws InterruptedException {
		// Vamos a crear un codigo para validar la lista estatica
		System.setProperty("webdriver.chrome.driver", "D:\\driversParaNavegadores\\chromedriver.exe");
		//Here we will create and launch our browser
		WebDriver customDriver = new ChromeDriver();
		customDriver.get("http://automationpractice.com/index.php?controller=contact");
		//here we initialize the object
		WebElement staticList = customDriver.findElement(By.id("id_contact"));
		Select selectedList = new Select(staticList);
		selectedList.selectByIndex(4);
		System.out.println(selectedList.getFirstSelectedOption().getText());
		Thread.sleep(3000);
		selectedList.selectByVisibleText("Customer service");
		System.out.println(selectedList.getFirstSelectedOption().getText());
		Thread.sleep(3000);
		selectedList.selectByValue("0");
		System.out.println(selectedList.getFirstSelectedOption().getText());
		Thread.sleep(3000);
		
	}

}
