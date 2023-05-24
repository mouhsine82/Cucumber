package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HardcodedExamples {

    String baseURI = RestAssured.baseURI= "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token= "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODQ4ODM3NDEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NDkyNjk0MSwidXNlcklkIjoiNTIyNSJ9.ccjl2p3MdQRd2hkQU7m30DK8QIZUeIxmXf4yVpVhlM8";

    @Test
    public void createEmployee(){
        // This is for POST (Create)
        // 1. prepare the request.
        RequestSpecification preparedRequest= given().
                header("Content-Type","application/json").
                header("Authorization",token).
                body("{\n" +
                        "  \"emp_firstname\": \"DoDo\",\n" +
                        "  \"emp_lastname\": \"BiBi\",\n" +
                        "  \"emp_middle_name\": \"Ds\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1943-05-09\",\n" +
                        "  \"emp_status\": \"Confirmed\",\n" +
                        "  \"emp_job_title\": \"Investor\"\n" +
                        "}");

        // 2. hitting the endpoint.
        Response response =preparedRequest.when().post("/createEmployee.php");
        // print the ouptput in the console
        response.prettyPrint();
        // 3. verifying the assertions
        response.then().assertThat().statusCode(201);
        // verifying the firstname in the response body
        response.then().assertThat().body("Employee.emp_firstname", equalTo("DoDo"));
        System.out.println("My test case is passed");




    }
}
