package com.nttdata.steps;

import com.nttdata.page.MyStorePage;
import org.openqa.selenium.WebDriver;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MyStoreLoginStep {

    public WebDriver driver;

    //constructor
    public MyStoreLoginStep(WebDriver driver){
        this.driver = driver;
    }

    //Click en Iniciar Sesion
    public void ClickPaginaLogin(){
        this.driver.findElement(MyStorePage.botonInciarSesion).click();
    }

    //Escribir correo
    public void typeUser(String usuario){
        WebElement userInputElement = driver.findElement(MyStorePage.textoCorreo);
        userInputElement.sendKeys(usuario);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    //Escribir la contraseña
    public void typePassword(String contrasena){
        this.driver.findElement(MyStorePage.textoContrasena).sendKeys(contrasena);
    }

    //Click en Boton Iniciar Sesión


}
