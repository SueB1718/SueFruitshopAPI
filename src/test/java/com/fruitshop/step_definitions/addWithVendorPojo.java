package com.fruitshop.step_definitions;

import com.fruitshop.pojo.VendorNamePojo;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.json.Json;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class addWithVendorPojo {

    // 1. instance was created at VendorNamePojo class
    // 2. using the constructor with parameter (here instance giving name)
    // so we can initialize the constructor with here
    // the private variable name is read here  setter -> write the value
    // getter -> read value
    VendorNamePojo vendorNamePojo = new VendorNamePojo("Sue's magic shop") ;
    public String vendorId ;

    Map<String, Object> addProduct = new LinkedHashMap<>() ; //  this is bodymap
    public String productId ;

    @When("create a vendor for the new product")
    public void create_a_vendor_for_the_new_product() {

        JsonPath jsonPath = given(). // option enter will show you possible variable you can save
                log().all().
                contentType(JSON)
                .body(vendorNamePojo)
                .when()
                .post("vendors/") // endpoint
                .then()
                .statusCode(201)
                .extract() //
                .jsonPath().prettyPeek();

        VendorNamePojo object = new VendorNamePojo() ;
       object = jsonPath.getObject("", VendorNamePojo.class);
        System.out.println("object = " + object);

    }


    @When("user add a product")
    public void user_add_a_product() {

    }

    @Then("user is able to verify the new product on the vendor")
    public void user_is_able_to_verify_the_new_product_on_the_vendor() {

    }



    @When("user get a existing vendor")
    public void user_get_a_existing_vendor() {


        String vendorurl = given()
                .accept(JSON).  //please send me response in JSON format
                log().all().

                        when()  // after when() http method .get, post, put, patch, delete,
                .get("/vendors/"). //
                        then().
                        extract().  // extract() used before jsonPath()
                        jsonPath().prettyPeek().getString("vendors.vendor_url[0]");
        System.out.println("vendorurl = " + vendorurl);

        int i= 0;
    vendorId = "";
        String[] arr = vendorurl.split("");

        for (String each : arr) {
            System.out.println("each = " + each);
            if(Character.isDigit(each.charAt(i))){
                vendorId+= each ;
            }
        }
        System.out.println("vendorId = " + vendorId);

    }


    @When("user is able to add a new product")
    public void user_is_able_to_add_a_new_product() {
        addProduct.put("name", "Fruit of love") ;
        addProduct.put("price", 12.99);
        addProduct.put("category_url", "/shop/categories/Fruits" ) ;
        addProduct.put("vendor_url", "/shop/vendors/" + vendorId ) ;

//        given().
//                log().all()
//                .contentType(JSON)
//                .body(addProduct)
//                .when()
//                .post("products/")
//                .then()
//                .statusCode(201)
//                .extract()  // from the extract we can get jsonPath()
//                .jsonPath().prettyPeek().getString("vendor_url").contains(vendorId);

        Response response = given().
                log().all()
                .contentType(JSON). // when posting contentType and body must include
                body(addProduct)
                .when()
                .post("products/");

        Assert.assertEquals(response.statusCode(), 201);
        JsonPath jsonPath = response.jsonPath();
        String vendor_url = jsonPath.getString("vendor_url");
        Assert.assertTrue(vendor_url.contains(vendorId));

    }
    @Then("user is able to verify product is added on vendor")
    public void user_is_able_to_verify_product_is_added_on_vendor() {

    }



}
