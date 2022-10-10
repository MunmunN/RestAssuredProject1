package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class GetProductsTest {
  @Test
  public void getProduct(){
    RestAssured.given()

      .contentType(ContentType.JSON)
      .when()
      .get("http://localhost:8090/api/v1/products")

      .then()
      .assertThat().statusCode(200)
      .log().all();



  }
}
