package paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class home {
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement linkinicio;

	@FindBy(xpath="//header/div[2]/div[1]/div[1]/nav[1]/div[2]/a[1]")
	WebElement linkContacto;
	
	@FindBy(css="#search_query_top")
	WebElement txtBuscar;
	
	WebDriver driver;
	public home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clicIniciar() {
		linkinicio.click();
		
	}
	
	public void clicContact() {
		linkContacto.click();
	}
	
	public void escribirPalabra(String palabra) {
		txtBuscar.sendKeys(palabra);
	}
	
	public void realizarBusqueda() {
		txtBuscar.sendKeys(Keys.ENTER);
	}
}
