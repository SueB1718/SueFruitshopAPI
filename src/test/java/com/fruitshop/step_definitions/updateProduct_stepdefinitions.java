package com.fruitshop.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class updateProduct_stepdefinitions {

    String updateBody = "{\n" +
            "  \"name\": \"Watermelon\",\n" +
            "  \"price\": 5.99,\n" +
            "  \"category_url\": \"/shop/categories/Fruits\",\n" +
            "  \"vendor_url\": \"/shop/vendors/817\"\n" +
            "}" ;

    @When("user update the name and price of the product")
    public void user_update_the_name_and_price_of_the_product() {


       given()
                .contentType(JSON)
                .body(updateBody).log().all()
                .pathParam("id", 417)
                .when()
                .put("/products/{id}").
                        then().log().all()
                .statusCode(200)
               .body("name", is("Watermelon"))
               .body("price", is(5.99f)) // by default is comparing as float
               // matcher not taking double so put float
               .body("category_url", is("/shop/categories/Fruits"))
               .body("vendor_url", is("/shop/vendors/817"));



//        JsonPath jsonPath = response.jsonPath();
//        String updatedName = jsonPath.getString("name");
//        System.out.println("updatedName = " + updatedName);
//
//     double updatedPrice = jsonPath.getDouble("price");
//      // price has decimal point so no int but double
//        // in case double doesn't work try with getString
//        // But here change getDouble
//        System.out.println("updatedPrice = " + updatedPrice);
//
//        String category_url = jsonPath.getString("category_url");
//        System.out.println("category_url = " + category_url);
//
//        String vendor_url = jsonPath.getString("vendor_url");


    }


    @Then("user is able to verify the updated name and a price")
    public void user_is_able_to_verify_the_updated_name_and_a_price() {

        Response response = given()
                .contentType(JSON)
                .body(updateBody).log().all()
                .pathParam("id", 417)
                .when()
                .put("/products/{id}");


        JsonPath jsonPath = response.jsonPath();
        String updatedName = jsonPath.getString("name");
        System.out.println("updatedName = " + updatedName);

     double updatedPrice = jsonPath.getDouble("price");
      // price has decimal point so no int but double
        // in case double doesn't work try with getString
        // But here change getDouble
        System.out.println("updatedPrice = " + updatedPrice);

        String category_url = jsonPath.getString("category_url");
        System.out.println("category_url = " + category_url);

        String vendor_url = jsonPath.getString("vendor_url");


        Assert.assertEquals(jsonPath.getString("name"), "Watermelon");
        Assert.assertEquals(jsonPath.getString("price"), "5.99");
        Assert.assertEquals(jsonPath.getDouble("price"), 5.99, DELTA );
    }

    private static final double DELTA = 1e-15;

    @Then("list the product")
    public void list_the_product() {

    }


}
