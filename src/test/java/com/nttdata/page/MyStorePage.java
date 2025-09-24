package com.nttdata.page;
import org.openqa.selenium.By;

public class MyStorePage {
    public static By botonInciarSesion = By.xpath("//a/span[@class=\"hidden-sm-down\"]");
    public static By textoCorreo = By.id("field-email");
    public static By textoContrasena = By.id("field-password");
    public static By botonIniciarSesion = By.id("submit-login");

    //header
    public static By botonClothes = By.xpath("//li[@id='category-3']//a[@class='dropdown-item']");
    public static By subbotonMen = By.xpath("//a[normalize-space()='Men']");

    //Tienda mostrando los articulos men
    public static By botonProducto = By.xpath("//article[@data-id-product='1']");

    //Dentro del articulo
    public static By botonAumentar = By.xpath("//i[@class='material-icons touchspin-up']");
}
