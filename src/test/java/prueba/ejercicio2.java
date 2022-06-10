package prueba;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.home;
import paginas.paginalogin;

	public class ejercicio2 {
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
		@Test(dataProvider="Datos login")
		public void login(String correo, String pass) {
			// HACER CLIC EN EL LINK SING IN
			home inicio = new home(driver);
			inicio.clicIniciar();
			
			// INGRESAR LAS CREDENCIALES T HACER CLIC EN EL BOTON
			paginalogin login = new paginalogin(driver);
			login.completarcredenciales(correo, pass);
			login.clicOnEnter();			

		}
		@DataProvider(name="Datos de Java") 
		public Object[][] construirDatosEntrada(){
			Object[][] datos = new Object[3][2];
			
			datos[0][0] ="hola@hotmail.com";
			datos[0][1] ="asdawda";
			
			datos[1][0] ="hola2@hotmail.com";
			datos[1][1] ="asdaw3dda";
			
			datos[2][0] ="hola3@hotmail.com";
			datos[2][1] ="asdaw32eda";
					
			return datos;
		
		
		}
		@DataProvider(name="Datos login")
		public Object[][]ObtenerDatosEntrada() throws Exception{
			String ruta="..\\EstudiandoSelenium\\Datos\\datosLab4_E2.xlsx";
			String hoja="Hoja1";
			
			return DatosExcel.leerExcel(ruta, hoja);
		}
		
		
		// cerrar todas las ventas y registrar la ejecucion. 
		@AfterSuite
		public void tearDown() {
			//driver.close();
			System.out.println("Finalizo la suite de pruebas");
		}
	}
