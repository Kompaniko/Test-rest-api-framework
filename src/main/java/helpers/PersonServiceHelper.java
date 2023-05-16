package helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import constatnts.EndPoints;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Person;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.testng.Assert;
import utils.Config;
import utils.ConfigManager;

import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.ConsoleHandler.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.internal.DataProviderLoader.*;


public class PersonServiceHelper {


    private static final String BASE_URL = Config.getBaseUrl();
    private static final int PORT = Config.getPort();
    private static final Logger log = LoggerFactory.getLogger(PersonServiceHelper.class);


    public PersonServiceHelper() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = PORT;
        RestAssured.useRelaxedHTTPSValidation();
    }

    public List<Person> getAllPerson() {
        log.info("Executing getAllPerson method...");
        Response response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .get("/persons")
                .andReturn();

        Type type = new TypeReference<List<Person>>() {}.getType();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "ok");

        List<Person> personList = response.as(type);
        log.info("Response body: {}", personList);
        return personList;
    }


    public Response CreatePerson() {

       Person person = new Person();
       person.setId(4567);
       person.setFirstName("Artur");
       person.setLastName("Mikhailov");
       person.setPhoneNumbers("1234562321234562131");
       person.setAddres("giolas");
       person.setAge(12);


        // Need to make a Post call
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .body(person)
                .post(EndPoints.CREATE_PERSON)
                .andReturn();

        Assert.assertEquals(response.getStatusCode(),HttpStatus.SC_CREATED, "create new person");

        return response;
    }

    public Response updatePerson(Integer id) {
        Person person = new Person();
        person.setFirstName("Artur");
        person.setLastName("Mikhailov");
        person.setAge(34);
        person.setAddres("giolas");
        person.setPhoneNumbers("1234562321234562131");

        Response response = RestAssured.given()
                .pathParam("id", id)
                .when().body(person)
                .patch(EndPoints.UPDATE_PERSON)
                .andReturn();
        assertTrue((response.getStatusCode()== HttpStatus.SC_OK));
        return response;
    }

    public Response deletePerson(Integer id) {

        Response response = RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id", id)
                .log().all()
                        .when().delete(EndPoints.DELETE_PERSON)
                        .andReturn();
        assertTrue((response.getStatusCode()== HttpStatus.SC_OK));
        return response;
    }
}
