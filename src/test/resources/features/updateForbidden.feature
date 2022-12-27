#language: es
Característica: Update Booking

  Como un usuario  no registrado
  necesito validar que la función de "update booking" no esté habilitada
  para poder garantizar que solo un usuario con perfil de admin puede realizar esta acción

  Escenario: Actualizar registro prohibido

    Dado a que el usuario no se encuentra registrado
    Cuando el usuario hace una peticion de actualizacion de un registro
    Entonces el usuario debera ver un codigo de respuesta 403
