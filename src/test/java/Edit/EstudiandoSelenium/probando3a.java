package Edit.EstudiandoSelenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class probando3a {
	String url ="http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPaht = "..\\EstudiandoSelenium\\drivers\\chromedriver.exe";
	String imagePath = "..\\EstudiandoSelenium\\evidencias\\";
	WebDriver driver;
	File screen;
	
// metodo para configurar las propiedades del navegador t abrirlo en la pagina correspondiente.
	
	@BeforeSuite
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverPaht);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(imagePath + "01imagen.png"));
		
	}
	/*
	 * pasos para registrar un usuario*/
	@Test
	public void registrarUsuario() throws Exception {
		WebElement txtCorreo = driver.findElement(By.xpath("//input[@id='email_create']"));		
		txtCorreo.sendKeys("correrueba323d5@hotmail.com");
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(imagePath + "02imagen.png"));
		
		WebElement btnCorreo = driver.findElement(By.xpath("//*[@id='SubmitCreate']"));
		btnCorreo.click();
				
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#id_gender1")));
		
		// llenar formular y hacer clic en el  boton registrer
		
		 WebElement titulo =  driver.findElement(By.cssSelector("#id_gender1"));	
		 titulo.click();
		
		
		WebElement txtNombre = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
		txtNombre.sendKeys("Juan");
		WebElement txtApellido = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
		txtApellido.sendKeys("Perez");
		//WebElement txtMail = driver.findElement(By.xpath("//input[@id='email']"));
		//txtMail.sendKeys("holacomoteva@hotmail.com");
		WebElement txtPass = driver.findElement(By.xpath("//input[@id='passwd']"));
		txtPass.sendKeys("123456789");
		
		Select dia = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		dia.selectByValue("18"); // busca por numero, por el valor que tiene cada elemento del combo-box
		
		Select Mes = new Select(driver.findElement(By.id("months")));
		Mes.selectByValue("3"); // 
		Select anio = new Select(driver.findElement(By.id("years")));
		anio.selectByValue("2022");
		
		WebElement nuevos = driver.findElement(By.name("newsletter"));
		nuevos.click();
		
		WebElement ofertas = driver.findElement(By.name("optin"));
		ofertas.click();
		//
		
		WebElement empresa = driver.findElement(By.id("company"));
		empresa.sendKeys("Globant");
		WebElement direccion = driver.findElement(By.id("address1"));
		direccion.sendKeys("calle false 123");
		
		WebElement direccion2 = driver.findElement(By.xpath("//input[@id='address2']"));
		direccion2.sendKeys("calle numero 2");
		
		WebElement ciudad = driver.findElement(By.id("city"));
		ciudad.sendKeys("calle false 123");
		
		
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("Florida");
		
		WebElement codigopostal = driver.findElement(By.id("postcode"));
		codigopostal.sendKeys("18263");
		
		
		Select pais= new Select(driver.findElement(By.id("id_country")));
		pais.selectByValue("21");
		
		WebElement adicional = driver.findElement(By.tagName("textarea"));
		adicional.sendKeys("informacion adicional sobre el registro");
		
		
		WebElement tel = driver.findElement(By.id("phone"));
		tel.sendKeys("42051501");
		WebElement tel2 = driver.findElement(By.id("phone_mobile"));
		tel2.sendKeys("151451515");
		
		WebElement txtAlias = driver.findElement(By.xpath("//input[@id='alias']"));
		txtAlias.clear();
		txtAlias.sendKeys("alias adicional");
		
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(imagePath + "03imagen.png"));
	
		WebElement registrar = driver.findElement(By.cssSelector("#submitAccount"));
		registrar.click();
		
		String resultadoEsperado ="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(driver.getCurrentUrl(), resultadoEsperado);

		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File(imagePath + "04imagen.png"));
		
		
	}
	/*
	 * Pasos para buscar una palabra*/
	
	@Test
	public void buscarPalabras() {
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("skirt");
		txtBuscador.sendKeys(Keys.ENTER);
		
	}
	// Pasos para ir a la seccion concatc us
	@Test
	public void irAContactonos() {
		
		WebElement txtContact = driver.findElement(By.linkText("Contact us"));
		txtContact.click();
		
	}
	
	// cerrar todas las ventas y registrar la ejecucion. 
	@AfterSuite
	public void tearDown() {
		driver.close();
		System.out.println("Finalizo la suite de pruebas");
	}
	
}
