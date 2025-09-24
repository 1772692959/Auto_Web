package com.nttdata.page;
import org.openqa.selenium.By;

public class MyStorePage {
    public static By botonInciarSesion = By.xpath("//a/span[@class=\"hidden-sm-down\"]");
    public static By textoCorreo = By.id("field-email");
    public static By textoContrasena = By.id("field-password");
    public static By botonIniciarSesion = By.id("submit-login");
}
