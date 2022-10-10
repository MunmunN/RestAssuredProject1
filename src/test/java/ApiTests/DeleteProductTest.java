package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;


public class DeleteProductTest  {
  @Test
  public void deleteProduct()

  {
    RestAssured.baseURI="http://localhost:8090";
    RestAssured.basePath="/api/v1/products/3aa2a0b2-bd51-4668-b1a0-727e6877aeda";

    Response response=
      given()
        .contentType(ContentType.JSON)
        .when()
           .delete()
           .then()
           .assertThat()
           .statusCode(204)
        //.statusLine("HTTP/1.1 204 No Content")
           .log().all()
           .extract().response();

    String jsonAsString=response.asString();
    Assert.assertEquals(response.equals(response),true);








  }
}


