package Edit.EstudiandoSelenium;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class probando2 {

	@Test
	public void registrarUsuario() {
		String url ="http://automationpractice.com/index.php?controller=authentication&back=my-account";
		String driverPaht = "..\\EstudiandoSelenium\\drivers\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", driverPaht); // configuracion inicial
		
		WebDriver driver = new ChromeDriver(); // abrir chrome
		driver.get(url);
		driver.manage().window().maximize(); // maximiza ventana.
		
		
		// ingresar el correo y hacer clic en create an account
		WebElement txtCorreo = driver.findElement(By.xpath("//input[@id='email_create']"));		
		txtCorreo.sendKeys("correoprueba2@hotmail.com");
		
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
	
		WebElement registrar = driver.findElement(By.cssSelector("#submitAccount"));
		registrar.click();
		
		// validacion de resultado esperado
		
		String UrlEsperada ="http://automationpractice.com/index.php?controller=my-account";
		String actualUrl = driver.getCurrentUrl();
		
		if(actualUrl.contentEquals(UrlEsperada)){
			System.out.println("Se creo el usuario");
			driver.close();
												 } 
		else {
				System.out.println("No se creo el usuario");
			}	
		
				
	}
}



