package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.Matchers.containsString;

public class GetByIDTest {
  @Test
  public void getProductByID(){
    RestAssured.given()

      .contentType(ContentType.JSON)
      .when()
      .get("http://localhost:8090/api/v1/products/dca23ba6-449f-4eda-82ee-9839d3ce0343")

      .then()
      .assertThat().statusCode(200)
      .log().all();



  }

}
