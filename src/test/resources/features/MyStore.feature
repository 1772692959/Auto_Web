#language: es
@testfeature
Característica: Product - Store

  @test
  Esquema del escenario: Validación del precio de un producto
    Dado estoy en la página de la tienda
    Y voy a la pantalla de Iniciar Sesion
    Y me logueo con mi usuario "<usuario>" y clave "<contrasena>"
    Cuando navego a la categoria "Clothes" y subcategoria "Men"
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito
    Y finalizo la compra compra del carrito

    Ejemplos:
    | usuario            | contrasena          |
    | hug-12@hotmail.com | starcraftystarcraft2 |
