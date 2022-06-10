package prueba;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.home;
import paginas.paginalogin;

public class ejercicio {
	public class probando3a {
		String url ="http://automationpractice.com";
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
		@Test
		public void login() {
			// HACER CLIC EN EL LINK SING IN
			home inicio = new home(driver);
			inicio.clicIniciar();
			
			// INGRESAR LAS CREDENCIALES T HACER CLIC EN EL BOTON
			paginalogin login = new paginalogin(driver);
			login.completarcredenciales("correo01@gmail.com", "12345678");
			login.clicOnEnter();
			
		}
		
		@Test
		public void contactUs() {
			home inicio = new home(driver);
			inicio.clicContact();

		}
		@Test
		public void buscarPalabra() {
			home inicio = new home(driver);
			inicio.escribirPalabra("python");
			inicio.realizarBusqueda();
			
		}
		
		
		

		// cerrar todas las ventas y registrar la ejecucion. 
		@AfterSuite
		public void tearDown() {
			//driver.close();
			System.out.println("Finalizo la suite de pruebas");
		}
	}
}
