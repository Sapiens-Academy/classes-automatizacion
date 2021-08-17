package com.sapiensschool.automatizacion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RegisterNewUser {

	public static void main(String[] args) throws InterruptedException {
		//Codigo para llenar el formulario
		System.setProperty("webdriver.chrome.driver", "D:\\driversParaNavegadores\\chromedriver.exe");
		WebDriver customDriver = new ChromeDriver();
		customDriver.get("https://winstoncastillo.com/robot-selenium/index.php?route=account/register");
		Assert.assertEquals(customDriver.getTitle(), "Register Account");
		customDriver.findElement(By.id("input-firstname")).sendKeys("Name01");
		customDriver.findElement(By.id("input-lastname")).sendKeys("LastName01");
		String email = new String();
		Integer randomNumber = (int) (Math.random() * 100 +1);
		email = "email" + randomNumber.toString() + "@email.com";
		System.out.println(email);
		customDriver.findElement(By.id("input-email")).sendKeys(email);
		customDriver.findElement(By.id("input-telephone")).sendKeys("024426589");
		customDriver.findElement(By.id("input-password")).sendKeys("P*ssw0rd01");
		customDriver.findElement(By.id("input-confirm")).sendKeys("P*ssw0rd01");
		customDriver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		String message = new String();
		message = customDriver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
		Assert.assertEquals(message, "Warning: You must agree to the Privacy Policy!");
		Assert.assertTrue(customDriver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).isSelected());
		Assert.assertFalse(customDriver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).isSelected());
		customDriver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
		Assert.assertFalse(customDriver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")).isSelected());
		Assert.assertTrue(customDriver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).isSelected());
		customDriver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		Assert.assertTrue(customDriver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).isSelected());
		Thread.sleep(3000);
		customDriver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		System.out.println(customDriver.getTitle());
		Assert.assertEquals(customDriver.getTitle(), "Your Account Has Been Created!");
		//Your Account Has Been Created!
		Thread.sleep(3000);
		customDriver.close();		
	}

}
