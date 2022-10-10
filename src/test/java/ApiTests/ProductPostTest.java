package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.core.IsEqual;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.Matchers.containsString;

public class ProductPostTest {

  @Test
  public void createProduct(){
    RestAssured.given()
      .body(new File("src/main/resources/data/Product.json"))
      .contentType(ContentType.JSON)
      .when()
      .post("http://localhost:8090/api/v1/products")
      .then()
      .assertThat().statusCode(201)
      .header("Location",containsString("/api/v1/products"))

      .log().all()
      .extract().response();


  }
}
