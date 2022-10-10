package ApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.Matchers.containsString;

public class UpdateProductTest extends Product {



    @Test
    public void updateProduct(){
      Product obj=new Product();
      obj.setName("My Water bottle");
      obj.setDescription("A sporty looking one");
      obj.setPrice(10);
      RestAssured.given()
        .body(obj)
        .contentType(ContentType.JSON)
        .when()
        .put("http://localhost:8090/api/v1/products/d188f5a4-57b3-4e24-9acb-0c26825256a2")

        .then()
        .assertThat().statusCode(204)
        .log().all()
        .extract().response();


    }
}
