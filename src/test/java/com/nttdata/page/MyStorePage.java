package com.nttdata.page;
import org.openqa.selenium.By;

public class MyStorePage {
    public static By botonInciarSesion = By.xpath("//a/span[@class=\"hidden-sm-down\"]");

    //Dentro del Login
    public static By textoCorreo = By.id("field-email");
    public static By textoContrasena = By.id("field-password");
    public static By botonIniciarSesion = By.id("submit-login");

    //Headers
    public static By botonClothes = By.xpath("//li[@id='category-3']//a[@class='dropdown-item']");
    public static By subbotonMen = By.xpath("//a[normalize-space()='Men']");

    //Tienda mostrando los Productos MEN
    public static By botonProducto = By.xpath("//article[@data-id-product='1']");

    //Dentro del Producto
    public static By botonAumentar = By.xpath("//i[@class='material-icons touchspin-up']");
    public static By botonCarrito = By.xpath("//button[@type='submit']");

    //Aparece PopUp
    public static By popupCarrito = By.id("blockcart-modal");
    public static By cantidadCarrito = By.xpath("//strong[normalize-space()='2']");
    public static By precioUnitario = By.xpath("//p[@class='product-price']");
    public static By precioTotal = By.xpath("//span[@class='value'][normalize-space()='S/ 38.24']");
    public static By botonFinalizarCompra = By.xpath("//div[@class='cart-content-btn']//a[@class='btn btn-primary']");

    //Dentro del Carrito
    public static By tituloCarrito = By.xpath("//h1[normalize-space()='Carrito']");
    public static By precioTotalCarrito = By.xpath("//div[@id='cart-subtotal-products']//span[@class='value']");
    public static By precioUnitarioCarrito = By.xpath("//span[@class='price']");
}
