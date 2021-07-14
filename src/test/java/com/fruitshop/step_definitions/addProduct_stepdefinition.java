package com.fruitshop.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.json.Json;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class addProduct_stepdefinition {

    Map<String, Object> bodyMap = new LinkedHashMap<>();
    public String vendorId ;


    @When("create a vendor for the product")
    public void create_a_vendor_for_the_product() {
       bodyMap.put("name", "FruitOfHolySpirit");

        JsonPath jsonPath = given(). // option enter will show you possible variable you can save
                log().all().
                contentType(ContentType.JSON)
                .body(bodyMap)
                .when()
                .post("vendors/") // endpoint
                .then()
                .statusCode(201)
                .extract() //
                .jsonPath().prettyPeek();

     String name  = jsonPath.getString("name");
        System.out.println("name = " + name);

        String vendor_url = jsonPath.getString("vendor_url");
        System.out.println("vendor_url = " + vendor_url);

        String[] splitArr = vendor_url.split("");

        int i = 0 ; // since we create each loop, there is no index, so i declare i here
        vendorId = "";
        for (String each : splitArr) {
            System.out.println("each = " + each);
            if(Character.isDigit(each.charAt(i))) {
                vendorId += each ;
            }
        }

        System.out.println("vendorId = " + vendorId);

    }

    @When("user add a new product")
    public void user_add_a_new_product() {


    }
    @Then("user is able to verify the new product")
    public void user_is_able_to_verify_the_new_product() {

    }



}
