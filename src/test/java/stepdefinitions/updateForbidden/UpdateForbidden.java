package stepdefinitions.updateForbidden;

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
import stepdefinitions.auth.AuthSteps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class UpdateForbidden extends BasePage {

    public static final Logger LOGGER = Logger.getLogger(AuthSteps.class);
    private RequestSpecification request;
    private Response response;
    @Dado("a que el usuario no se encuentra registrado")
    public void aQueElUsuarioNoSeEncuentraRegistrado() {
        int totalPrice = 60000;
        boolean depositPaid = true;

        try {
            generalSetUp();
            request = given()
                    .log()
                    .all()
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                            "    \"firstname\": \"" + "Yuval" + "\",\n" +
                            "    \"lastname\": \"" + "Harari" + "\",\n" +
                            "    \"totalprice\": " + totalPrice + ",\n" +
                            "    \"depositpaid\": " + depositPaid + ",\n" +
                            "    \"bookingdates\": " + "{\n"+
                            "                   \"checkin\": \"" + "2018-01-01" + "\",\n" +
                            "                   \"checkout\": \"" + "2021-01-01" + "\"\n" +
                            "},\n" +
                            "    \"additionalneeds\": \"" + "Novel" + "\"\n" +
                            "}");

            LOGGER.info("Se ingresan los datos para editar el registro");
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Cuando("el usuario hace una peticion de actualizacion de un registro")
    public void elUsuarioHaceUnaPeticionDeActualizacionDeUnRegistro() {
        try {
            response = request.when()
                    .put(UPDATE);
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Entonces("el usuario debera ver un codigo de respuesta {int}")
    public void elUsuarioDeberaVerUnCodigoDeRespuesta(int respuesta) {
        respuesta = HttpStatus.SC_FORBIDDEN;
        try {
            response.then()
                    .log()
                    .all()
                    .statusCode(respuesta);
            LOGGER.info("Se obtiene el status code 403 Forbidden esperado");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
}
