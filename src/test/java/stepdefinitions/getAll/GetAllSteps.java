package stepdefinitions.getAll;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

import org.apache.log4j.Logger;
import stepdefinitions.BasePage;

public class GetAllSteps extends BasePage {

    public static final Logger LOGGER = Logger.getLogger(GetAllSteps.class);
    private RequestSpecification request;
    private Response response;

    private int codigo = 200;

    @Dado("el usuario quiere consultar el listado de libros")
    public void elUsuarioQuiereConsultarElListadoDeLibros() {
        try {
            generalSetUp();
            request = request.given()
                    .log()
                    .all();

        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }

    }

    @Cuando("el usuario hace la peticion de obtener el listado de libros completo")
    public void elUsuarioHaceLaPeticionDeObtenerElListadoDeLibrosCompleto() {
        try {
            response = request.when()
                                .get();
            LOGGER.info("Se hace la peticion para obtener el listado de libros");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Entonces("el usuario deberia obtener el listado de libros completo")
    public void elUsuarioDeberiaObtenerElListadoDeLibrosCompleto() {
        try {
            response.then().log().all();
            LOGGER.info("Se obtiene el listado completo de libros");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }

    @Y("un codigo de respuesta {int}")
    public void unCodigoDeRespuesta(int respuesta) {
        try {
            respuesta = codigo;
            response.then().log().all().statusCode(respuesta);
            LOGGER.info("Se obtiene el status code 200 esperado");
        }catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            Assertions.fail(e.getMessage());
        }
    }
}
