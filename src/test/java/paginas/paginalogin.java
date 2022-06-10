package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paginalogin {
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement txtPass;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement btnEnter;
	
	WebDriver driver;

	
public paginalogin(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public void completarcredenciales(String correo, String pass) {
	txtEmail.sendKeys(correo);
	txtPass.sendKeys(pass);
}

public void clicOnEnter() {
	btnEnter.click();
}
}
