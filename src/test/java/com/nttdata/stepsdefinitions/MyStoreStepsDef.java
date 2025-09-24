package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.MyStoreLoginStep;
import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class MyStoreStepsDef {

    public WebDriver driver;
    public MyStoreLoginStep MyStore;

    private LoginSteps inventorySteps(WebDriver driver){
        return new LoginSteps(driver);
    }

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        MyStore = new MyStoreLoginStep(driver);
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();
    }

    @Y("voy a la pantalla de Iniciar Sesion")
    public void voyALaPantallaDeIniciarSesion() {
        MyStore = new MyStoreLoginStep(driver);
        MyStore.ClickPaginaLogin();
        screenShot();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String contrasena) {
        MyStoreLoginStep loginSteps = new MyStoreLoginStep(driver);
        loginSteps.typeUser(usuario);
        loginSteps.typePassword(contrasena);
        loginSteps.ButtonLogin();
        screenShot();
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String arg0, String arg1) {
        MyStore.ButtonClothes();
        MyStore.SubButtonMen();
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int arg0) {
        MyStore.ButtonProduct();
        MyStore.AddProduct();
        MyStore.ButtonCart();
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        MyStore.ValidPopUp();
        screenShot();

    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        MyStore.validPrice();
        screenShot();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        MyStore.finalizePurchase();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        MyStore.TitleCarrito();
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        MyStore.ValidPriceTotalCarrito();
    }


}
