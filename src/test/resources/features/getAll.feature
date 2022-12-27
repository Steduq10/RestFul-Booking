#language: es
  Característica: Obtener el listado de libros completo
    Como usuario visitante en el sistema
    necesito validar que la opción de ver el listado de libros se encuentre disponible
    para poder identificar cada uno de los libros almacenados
    Escenario: Consultar listado completo de libros
      Dado el usuario quiere consultar el listado de libros
      Cuando el usuario hace la petición de obtener el listado de libros completo
      Entonces el usuario deberia obtener el listado de libros completo
      Y un código de respuesta 200.