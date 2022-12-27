package stepdefinitions.auth;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import stepdefinitions.BasePage;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AuthSteps extends BasePage {

    public static final Logger LOGGER = Logger.getLogger(AuthSteps.class);
    private RequestSpecification request;
    private Response response;

    @Dado("el usuario esta en la pagina de inicio de sesion con el correo de usuario {string} y la contrasena {string}")
    public void elUsuarioEstaEnLaPaginaDeInicioDeSesionConElCorreoDeUsuarioYLaContrasena(String user, String password) {
        try {
            generalSetUp();
            request = given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                            "    \"username\": \"" + user + "\",\n" +
                            "    \"password\": \"" + password + "\"\n" +
                            "}");
            LOGGER.info("Se ingresan las credenciales para iniciar sesion");
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Cuando("el usuario hace una peticion de inicio de sesion")
    public void elUsuarioHaceUnaPeticionDeInicioDeSesion() {
        try {
            response = request.when()
                    .post(AUTH);
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Entonces("el usuario debera ver un codigo de respuesta {int} exitoso")
    public void elUsuarioDeberaVerUnCodigoDeRespuestaExitoso(int respuesta) {
        respuesta = HttpStatus.SC_OK;
        try {
            response.then()
                    .log()
                    .all()
                    .statusCode(respuesta);
            LOGGER.info("Se obtiene el status code 200 esperado");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Y("un token de respuesta.")
    public void unTokenDeRespuesta() {
        try {
            response.then()
                    .log()
                    .all()
                    .body("token", notNullValue());
            LOGGER.info("Se obtiene el token");
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
}
