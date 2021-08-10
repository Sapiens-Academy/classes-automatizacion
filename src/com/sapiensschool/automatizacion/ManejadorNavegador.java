package com.sapiensschool.automatizacion;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ManejadorNavegador {

	public static void main(String[] args) throws InterruptedException {
		// Instanciar y lanzar el navegador
		System.setProperty("webdriver.chrome.driver", "D:\\driversParaNavegadores\\chromedriver.exe");
		//Here we will create and launch our browser
		WebDriver customDriver = new ChromeDriver();		
		customDriver.get("https://www.google.com/");
		customDriver.manage().window().maximize();
		customDriver.navigate().to("https://winstoncastillo.com/robot-selenium");
		System.out.println(customDriver.getCurrentUrl());
		System.out.println(customDriver.getTitle());
		//Codigo para crear acciones del navegador
		Actions mouseAction = new Actions(customDriver);
		WebElement menuOption = customDriver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]/a"));
		mouseAction.moveToElement(menuOption).perform();
		Thread.sleep(3000);		
		//Este comando presiona la flecha de regreso
		customDriver.navigate().back();
		//Este comando presiona la flecha hacia adelante
		customDriver.navigate().forward();
		//Este comando presiona refresca la pagina		
		customDriver.navigate().refresh();
		//Vamos a abrir una segunda pestana
		String firstTab = customDriver.getWindowHandle();
		//System.out.println(firstTab);
		Integer sizeOfTabs = customDriver.getWindowHandles().size();
		//System.out.println(sizeOfTabs);
		JavascriptExecutor codeToOpenTab = (JavascriptExecutor)customDriver;
		codeToOpenTab.executeScript("window.open();");
		sizeOfTabs = customDriver.getWindowHandles().size();
		//System.out.println(sizeOfTabs);
		//Este comando cierra la pestana
		ArrayList<String> tabNames = new ArrayList<String>(customDriver.getWindowHandles());
		customDriver.switchTo().window(tabNames.get(1));
		customDriver.get("https://www.google.com/");
		codeToOpenTab.executeScript("window.open();");
		tabNames = new ArrayList<String>(customDriver.getWindowHandles());
		customDriver.switchTo().window(tabNames.get(2));
		customDriver.get("http://winstoncastillo.com/ejercicios/atoc.html");
		customDriver.findElement(By.cssSelector("#testCasesAtoC > p:nth-child(2) > button")).click();
		Thread.sleep(3000);
		String message = customDriver.switchTo().alert().getText();
		System.out.println("Este es el mensaje de la ventana: " + message);
		customDriver.switchTo().alert().accept();
		Thread.sleep(3000);
		customDriver.close();
		customDriver.switchTo().window(tabNames.get(1));
		customDriver.close();
		customDriver.switchTo().window(tabNames.get(0));
		Thread.sleep(1000);
		customDriver.close();
		//customDriver.quit();
	}

}
