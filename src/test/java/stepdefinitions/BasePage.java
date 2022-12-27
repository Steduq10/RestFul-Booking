package stepdefinitions;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import org.apache.log4j.PropertyConfigurator;

import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;
import static util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;

public class BasePage {
    protected static final String BASE_URL = "https://restful-booker.herokuapp.com";
    protected static final String BASE_PATH = "/booking";

    protected static final String AUTH= "/auth";

    protected static final String PING = "/ping";


    protected void generalSetUp(){
        setUpLog4j2();
        configurationForRestAssured();
    }

    private void setUpLog4j2(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

    public void configurationForRestAssured(){
        RestAssured.baseURI = BASE_URL;
        //RestAssured.requestSpecification = new RequestSpecBuilder()
               // .setContentType(ContentType.JSON).build();
    }
}
