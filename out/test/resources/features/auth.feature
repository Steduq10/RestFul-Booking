#language: es
Característica: Iniciar sesión usuario admin

  Como un usuario registrado con permisos admin
  necesito validar que la función de iniciar sesion esté habilitada
  para poder garantizar la seguridad del usuario

  Escenario: Inicio sesion exitoso

    Dado el usuario esta en la pagina de inicio de sesion con el correo de usuario "admin" y la contrasena "password123"
    Cuando el usuario hace una peticion de inicio de sesion
    Entonces el usuario debera ver un codigo de respuesta 200 exitoso
    Y un token de respuesta.