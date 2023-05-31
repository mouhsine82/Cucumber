package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HardcodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODUwNTg0NzYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTEwMTY3NiwidXNlcklkIjoiNTIyNSJ9.di4rHq688HKOwgpnijhTKIry_-uyuOm756ZJ8VRW0-M";
    static String employee_id;

    @Test
    public void a_createEmployee() {
        // This is for POST (Create)
        // 1. prepare the request.
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
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
        Response response = preparedRequest.when().post("/createEmployee.php");

        // print the ouptput in the console
        response.prettyPrint();

        // 3. verifying the assertions
        response.then().assertThat().statusCode(201);

        // we are capturing employee ID from the response
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

        // verifying the firstname and lastname in the response body
        response.then().assertThat().body("Employee.emp_firstname", equalTo("DoDo"));
        response.then().assertThat().body("Employee.emp_lastname", equalTo("BiBi"));

        // verify the response header
        response.then().assertThat().header("Content-Type", "application/json");


    }

    @Test
    public void b_getCreatedEmployee() {
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                queryParam("employee_id",employee_id);

        //hitting the endpoint
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        //verify the reponse
        response.then().assertThat().statusCode(200);
        String tempEmpId = response.jsonPath().getString("employee.employee_id");
        //we have 2 emp id, one is global and second is local
        Assert.assertEquals(employee_id, tempEmpId);

        System.out.println("My test case is passed");
    }
    // in homework, create a method to get all employee status and job title

    @Test
   public void e_getAllEmployeeStatus(){
       RequestSpecification preparedRequest=given().
               header("Content-Type","application/json").
               header("Authorization", token);
       //endpoint
        Response response=preparedRequest.when().get("/employeementStatus.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        response.then().assertThat().equals("id");
   }
   @Test
   public void f_JobTitle(){
        RequestSpecification preparedRequest=given().
                header("Content-Type","application/json").
                header("Authorization", token);
        //send request with endpoint
       Response response=preparedRequest.when().get("/jobTitle.php");
       response.prettyPrint();
       response.then().assertThat().statusCode(200);
       response.then().assertThat().equals("job");
   }
  @Test
    public void c_updateEmployee() {
        RequestSpecification preparedRequest=given().
                header("Content-Type","application/json").
                header("Authorization",token).body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"baffen\",\n" +
                        "  \"emp_lastname\": \"warret\",\n" +
                        "  \"emp_middle_name\": \"D\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"1994-05-20\",\n" +
                        "  \"emp_status\": \"Temporary\",\n" +
                        "  \"emp_job_title\": \"Big Boy investor\"\n" +
                        "}");
        // hitting endpoint
        Response response=preparedRequest.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);

        // for verification
        response.then().assertThat().body("Message",equalTo("Employee record Updated"));
    }
@Test
    public void d_getUpdatedEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                queryParam("employee_id",employee_id);

        Response response=preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    //if you want to verify the body of the response.
    //you can do that using hamcrest matchers

    }
}
