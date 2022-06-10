package Edit.EstudiandoSelenium;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class rncd {

	@Test
	public void formularioRncd() {
		String url = "https://tramitespublicosdesa.trabajo.gob.ar/";
		String driverPaht = "..\\EstudiandoSelenium\\drivers\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", driverPaht); // configuracion inicial
		
		WebDriver driver = new ChromeDriver(); // abrir chrome
		driver.get(url);
		driver.manage().window().maximize(); // maximiza ventana.
		
		WebElement txtBuscar = driver.findElement(By.cssSelector("#inputTematica"));
		txtBuscar.sendKeys("RNCD");
		
		WebElement txtIngresar = driver.findElement(By.cssSelector("div.container:nth-child(2) main.pb-3 form:nth-child(2) div.row.row-search:nth-child(4) div.col-md-3 > input.btn.btn-primary"));
		txtIngresar.click();
		
		//WebDriverWait wait = new WebDriverWait(driver,10);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.container:nth-child(2) main.pb-3 form:nth-child(2) div.row.row-search:nth-child(4) div.col-md-3 > input.btn.btn-primary")));
		
		//Solicitante
		WebElement aspirantes = driver.findElement(By.xpath("//body/div[1]/main[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]"));
		aspirantes.click();
		
		WebElement usuario = driver.findElement(By.id("content__login_Cuit"));
		usuario.sendKeys("20399648018");
		WebElement pass = driver.findElement(By.id("content__login_Password"));
		pass.sendKeys("Naranja");
		WebElement ingreso = driver.findElement(By.cssSelector("#content__login_LoginButton"));
		ingreso.click();
		
		WebElement correo1 = driver.findElement(By.cssSelector("#correo"));
		correo1.clear();
		correo1.sendKeys("hola@homail.com");
		
		Select tiponum = new Select(driver.findElement(By.cssSelector("#tipoTelefono")));
		tiponum.selectByValue("Celular");
		
		WebElement tel1 = driver.findElement(By.cssSelector("#telefonoSolicitante"));
		tel1.sendKeys("111111111");
		
		// Aspirante
		
		WebElement perso = driver.findElement(By.id("radioPersonal"));
		perso.click();
		
		Select estado = new Select(driver.findElement(By.id("estadoCivil")));
		estado.selectByVisibleText("Conviviente");
		
		//WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cudInput")));
		WebElement cud= driver.findElement(By.id("cudInput"));
		cud.clear();
		cud.sendKeys("123321456");
		
		Select tipodisca = new Select(driver.findElement(By.cssSelector("#tipoDiscapacidad")));
		tipodisca.selectByValue("Multiple");
		
		WebElement discamulti = driver.findElement(By.id("checkFisicaMotora"));
		discamulti.click();
		WebElement discamulti2 = driver.findElement(By.id("checkSensorialAuditiva"));
		discamulti2.click();
		
		
	}
	
}
