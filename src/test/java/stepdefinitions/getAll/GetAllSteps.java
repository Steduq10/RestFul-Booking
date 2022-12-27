package stepdefinitions.getAll;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;

import org.apache.log4j.Logger;
import stepdefinitions.BasePage;

import static io.restassured.RestAssured.given;

public class GetAllSteps extends BasePage {

    public static final Logger LOGGER = Logger.getLogger(GetAllSteps.class);
    private RequestSpecification request;
    private Response response;


    @Dado("el usuario quiere consultar el listado de libros")
    public void elUsuarioQuiereConsultarElListadoDeLibros() {
        try {
            generalSetUp();
            request = given()
                    .log()
                    .all().contentType(ContentType.ANY);

        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }

    @Cuando("el usuario hace la peticion de obtener el listado de libros completo")
    public void elUsuarioHaceLaPeticionDeObtenerElListadoDeLibrosCompleto() {
        try {
            response = request.when()
                                .get(BASE_PATH);
            LOGGER.info("Se hace la peticion para obtener el listado de libros");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Entonces("el usuario deberia obtener el listado de libros completo")
    public void elUsuarioDeberiaObtenerElListadoDeLibrosCompleto() {
        try {
            response.then()
                    .log()
                    .body();
            LOGGER.info("Se obtiene el listado completo de libros");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Y("un codigo de respuesta {int}")
    public void unCodigoDeRespuesta(int respuesta) {
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
}
