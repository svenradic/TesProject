package page_objects;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Employee
{
    private static final String ROOT_URI = "http://localhost:7000/employees";

    public Response getEmployeeList() {
        return get(ROOT_URI + "/list");
    }

    public Response createEmployee(String name, String salary) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"name\": \"" + name + "\",\"salary\": \"" + salary + "\"}")
                .when()
                .post(ROOT_URI + "/create");
    }

    public Response updateEmployee(int id, String name, String salary) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"name\": \"" + name + "\",\"salary\": \"" + salary + "\"}")
                .when()
                .put(ROOT_URI + "/update/" + id);
    }

    public Response deleteEmployee(int id) {
        return delete(ROOT_URI + "/delete/" + id);
    }

    public Response getEmployeeById(int id) {
        return get(ROOT_URI + "/get/" + id);
    }
}
