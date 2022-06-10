package Edit.EstudiandoSelenium;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Probando1 {
	/*
	 * metodo de prueba para acceder a selenium.dev desde crhome*/
	@Test 
	public void accederDesdeChrome() {
		// definir donde esta el chrome driver
		System.setProperty("webdriver.chrome.driver","..\\EstudiandoSelenium\\drivers\\chromedriver.exe");
		
		// indicar que navegador voy a controlar
		WebDriver driver = new ChromeDriver();
		
		// abrir el navegador chrome en la pagina selenium.dev
		driver.get("https://www.selenium.dev/");
		
		// cerrar el navegador
		driver.close();
	}
	/*
	 * metodo para acceder a selenium.dev desde firefox*/
	@Test
	public void accederDesdeFirefox() {
		// definir donde esta el gecko driver
		System.setProperty("webdriver.gecko.driver","..\\EstudiandoSelenium\\drivers\\geckodriver.exe");
		
		// indicar que navegador voy a controlar
		WebDriver driver = new FirefoxDriver();
		
		// abrir el navegador firefox en la pagina selenium.dev
		driver.get("https://www.selenium.dev/");
		
		// cerrar el navegador
				driver.close();
		
	}
	
	/*
	 * metodo para busqueda en la pagina*/
	@Test
	public void buscarPalabra() {
		System.setProperty("webdriver.chrome.driver","..\\EstudiandoSelenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize(); // maximiza la pagina
		driver.manage().deleteAllCookies(); // borra cookies
		
		WebElement txtBuscador = driver.findElement(By.id("docsearch")); // ubica  el elemento - campo de texto para busqueda
		txtBuscador.click();
		WebElement txtBuscador2 = driver.findElement(By.id("docsearch-input"));
		txtBuscador2.sendKeys("Java"); // escribe en el campo de texto la palabra indicada como parametro.
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // para darle tiempo entre instruccion e instruccion, en este caso 5 segundos.
		txtBuscador2.sendKeys(Keys.ENTER); // simular que se presiona el boton enter.
		
		
		// txtBuscador.sendKeys(Keys.chord(Keys.CONTROL, "v")); para simular el control + V
		
	} 
	
	/*
	 * Metodo para busqueda en google*/
	
	@Test
	public void buscarEnGoogle() {
		System.setProperty("webdriver.chrome.driver","..\\EstudiandoSelenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com.ar/");
		driver.manage().window().maximize(); // maximiza la pagina
		
		WebElement busca= driver.findElement(By.name("q"));
		busca.sendKeys("Java");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // para darle tiempo entre instruccion e instruccion, en este caso 5 segundos.
		busca.sendKeys(Keys.ENTER);
		
		
	}
	
	@Test
	public void cambioTitulo() {
		System.setProperty("webdriver.chrome.driver","..\\EstudiandoSelenium\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseURL = "https://www.google.com.ar/";
		String tituloEsperado = "Goog2le";
		String tituloActual= "";
		
		driver.get(baseURL); // abre chrome y va hacia la url guardada en la variable.
		
		tituloActual= driver.getTitle(); // obtiene el valor del titulo de la pagina.
		
		if (tituloActual.contentEquals(tituloEsperado)) {
		System.out.println("Paso el Test");
														}
		else {
				System.out.println("No paso el Test");
			 }
		 driver.close();
		
	}
	
	
	
	
}
