import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import page_objects.Employee;

public class RestAPITest {
    private final Employee employeeAPI = new Employee();

    @Test
    public void simple_get_test() {
        Response response = employeeAPI.getEmployeeList();
        System.out.println(response.asString());
        response.then().body("id", hasItems(1, 2));
        response.then().body("name", hasItems("Pankaj"));
    }

    @Test
    public void post_test() {
        Response response = employeeAPI.createEmployee("Lisa", "2000");
        System.out.println("POST Response\n" + response.asString());
        response.then().body("id", Matchers.any(Integer.class));

        response.then().body("name", Matchers.is("Lisa"));
    }

    @Test
    public void put_test() {
        Response response = employeeAPI.updateEmployee(3, "Lisa Tamaki", "45000");
        System.out.println("PUT Response\n" + response.asString());
        response.then().body("id", Matchers.is(3));
        response.then().body("name", Matchers.is("Lisa Tamaki"));
        response.then().body("salary", Matchers.is("45000"));
    }

    @Test
    public void delete_test() {
        Response response = employeeAPI.deleteEmployee(3);
        System.out.println(response.asString());
        response.then().statusCode(200);
        // Check if id=3 is deleted
        response = employeeAPI.getEmployeeList();
        response.then().body("id", Matchers.not(3));
    }

    @Test(dataProvider = "dpGetWithParam")
    public void get_with_param(int id, String name) {
        employeeAPI.getEmployeeById(id).then().body("name", Matchers.is(name));
    }

    @DataProvider
    public Object[][] dpGetWithParam() {
        return new Object[][]{
                {1, "Pankaj"},
                {2, "David"}
        };
    }

}
