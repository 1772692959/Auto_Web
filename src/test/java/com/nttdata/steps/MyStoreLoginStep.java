package com.nttdata.steps;

import com.nttdata.page.MyStorePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;



public class MyStoreLoginStep {

    public WebDriver driver;
    public int cantidadproducto;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.botonIniciarSesion));

    }

    //Escribir la contraseña
    public void typePassword(String contrasena){
        this.driver.findElement(MyStorePage.textoContrasena).sendKeys(contrasena);
    }

    //Click en Boton Iniciar Sesión
    public void ButtonLogin() {
        this.driver.findElement(MyStorePage.botonIniciarSesion).click();
    }

    //Click en Boton Clothes
    public void ButtonClothes(){
        Actions action = new Actions(this.driver);
        action.moveToElement(this.driver.findElement(MyStorePage.botonClothes)).perform();
    }

    //Click en SubBoton Men
    public void SubButtonMen() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.subbotonMen));
        Assert.assertTrue(driver.findElement(MyStorePage.subbotonMen).isDisplayed());
        this.driver.findElement(MyStorePage.subbotonMen).click();
    }

    //Click en Boton del primer producto
    public void ButtonProduct() {
        this.driver.findElement(MyStorePage.botonProducto).click();
    }

    //Cambiar cantidad
    public void AddProduct(){
        this.driver.findElement(MyStorePage.botonAumentar).click();
    }

    //Agregar al Carrito
    public void ButtonCart() {
        this.driver.findElement(MyStorePage.botonCarrito).click();
    }

    //Aparece el PopUp
    public void ValidPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MyStorePage.popupCarrito));
        Assert.assertTrue(driver.findElement(MyStorePage.popupCarrito).isDisplayed());

        //Validar que se agreguen 2 productos
        int cantidadActual = Integer.parseInt(this.driver.findElement(MyStorePage.cantidadCarrito).getText());

        if(cantidadActual == 2){
            System.out.println("Hay 2 productos");
        }
        else{
            System.out.println("Cantidad erronea de productos");
        }
    }

    public void validPrice() {
        //Calculado a 2 productos
        String precioUnitarioTexto = this.driver.findElement(MyStorePage.precioUnitario).getText(); // "S/ 19.12"
        String precioTotalTexto = this.driver.findElement(MyStorePage.precioTotal).getText();       // "S/ 38.24"

        // Eliminar "S/" y espacios, luego convertir a double
        double MontoUnitario = Double.parseDouble(precioUnitarioTexto.replace("S/", "").trim());
        double MontoTotal = Double.parseDouble(precioTotalTexto.replace("S/", "").trim());

        // Comparar con tolerancia para evitar errores por decimales
        if ((MontoUnitario * 2) == MontoTotal) {
            System.out.println("Monto unitario: " + MontoUnitario);
            System.out.println("Monto total: " + MontoTotal);
            System.out.println("Suma correcta de 2 productos");
        } else {
            System.out.println("Monto unitario: " + MontoUnitario);
            System.out.println("Monto total incorrecto");
            System.out.println("Monto total: " + MontoTotal);
        }
    }

    //Click en Finalizar compra
    public void finalizePurchase() {
        this.driver.findElement(MyStorePage.botonFinalizarCompra).click();
    }

    public void TitleCarrito() {
        String TituloCarrito = this.driver.findElement(MyStorePage.tituloCarrito).getText();
        //Comparar que si diga carrito
        if (TituloCarrito.equals("CARRITO")) {
            System.out.println("Estamos dentro de CARRITO");
        }else{
            System.out.println("Página equivocada");
        }
    }

    public void ValidPriceTotalCarrito() {
        String precioUnitarioCarritoTexto = this.driver.findElement(MyStorePage.precioUnitarioCarrito).getText(); // "S/ 19.12"
        String precioTotalCarritoTexto = this.driver.findElement(MyStorePage.precioTotalCarrito).getText();       // "S/ 38.24"
        double MontoUnitarioCarrito = Double.parseDouble(precioUnitarioCarritoTexto.replace("S/", "").trim());
        double MontoTotalCarrito = Double.parseDouble(precioTotalCarritoTexto.replace("S/", "").trim());
        if ((MontoUnitarioCarrito * 2) == MontoTotalCarrito) {
            System.out.println("Monto unitario: " + MontoUnitarioCarrito);
            System.out.println("Monto total: " + MontoTotalCarrito);
            System.out.println("Suma correcta de 2 productos");
        } else {
            System.out.println("Monto unitario: " + MontoUnitarioCarrito);
            System.out.println("Monto total incorrecto");
            System.out.println("Monto total: " + MontoTotalCarrito);
        }
    }
}
