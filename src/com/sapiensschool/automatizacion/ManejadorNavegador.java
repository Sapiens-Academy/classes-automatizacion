package com.sapiensschool.automatizacion;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManejadorNavegador {

	public static void main(String[] args) {
		// Instanciar y lanzar el navegador
		System.setProperty("webdriver.chrome.driver", "D:\\driversParaNavegadores\\chromedriver.exe");
		//Here we will create and launch our browser
		WebDriver customDriver = new ChromeDriver();		
		customDriver.get("https://www.google.com/");
		customDriver.navigate().to("https://winstoncastillo.com/robot-selenium");
		System.out.println(customDriver.getCurrentUrl());
		System.out.println(customDriver.getTitle());
		//Este comando presiona la flecha de regreso
		customDriver.navigate().back();
		//Este comando presiona la flecha hacia adelante
		customDriver.navigate().forward();
		//Este comando presiona refresca la pagina		
		customDriver.navigate().refresh();
		//Vamos a abrir una segunda pestana
		String firstTab = customDriver.getWindowHandle();
		System.out.println(firstTab);
		Integer sizeOfTabs = customDriver.getWindowHandles().size();
		System.out.println(sizeOfTabs);
		JavascriptExecutor codeToOpenTab = (JavascriptExecutor)customDriver;
		codeToOpenTab.executeScript("window.open();");
		sizeOfTabs = customDriver.getWindowHandles().size();
		System.out.println(sizeOfTabs);
		//Este comando cierra la pestana
		//customDriver.close();
	}

}
