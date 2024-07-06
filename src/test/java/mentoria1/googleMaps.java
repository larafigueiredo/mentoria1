package mentoria1;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class googleMaps {
	WebDriver driver;

	@Test
	public void openGoogleMaps() {
		// Define the webdriver path
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		// Start the webdriver
		driver = new ChromeDriver();

		// Open the page
		driver.get("https://www.google.com/maps");

		By elementAcceptAllCookiesXPath = By.xpath("//div[@class='VtwTSb']//form[1]");
		WebElement elementAcceptAllCookies = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(elementAcceptAllCookiesXPath));
		elementAcceptAllCookies.click();

		// Locate the username input field
		By elementSearchBoxId = By.id("searchboxinput");
		WebElement elementSearchBox = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(elementSearchBoxId));

		// Enter text into the username input field
		elementSearchBox.sendKeys("Dublin");

		elementSearchBox.sendKeys(Keys.ENTER);

		// Locate the dublin input field
		By elementDublinXPath = By.xpath("//h1[normalize-space()='Dublin']");
		WebElement elementDublin = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(elementDublinXPath));
		System.out.println(elementDublin.getText());
		Assert.assertTrue(elementDublin.getText().equals("Dublin"));

		// Locate the dublin input field

		By elementDirectionXPath = By
				.xpath("//button[@aria-label='Direções para Dublin']//span[contains(@class,'DVeyrd')]");
		WebElement elementDirection = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(elementDirectionXPath));
		elementDirection.click();

		By elementStartingPointXPath = By
				.xpath("//input[@placeholder='Selecione o ponto de partida ou clique no mapa...']");
		WebElement elementStartingPoint = new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.elementToBeClickable(elementStartingPointXPath));

		elementStartingPoint.sendKeys("Escadinhas Senhor da Agonia");

		elementSearchBox.sendKeys(Keys.ENTER);

	}

	@After
	public void fechaBrowser() {
		driver.quit();
	}

}
