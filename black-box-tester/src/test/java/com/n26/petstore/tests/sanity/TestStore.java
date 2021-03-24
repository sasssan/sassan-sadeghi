package com.n26.petstore.tests.sanity;

import com.n26.TestRunnerBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

@Slf4j
public class TestStore {

    @BeforeClass
    void before() {
        TestRunnerBase.config();
        RestAssured.baseURI = TestRunnerBase.getProps().getPetStoreURL() + "/store/";
    }

    @Test
    void testGetInventory() {
        Response response = when().get("inventory");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    void testGetOrderID() {
        Response response = when().get("order/1");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    void testPostOrder() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", 10);
        requestBody.put("quantity", 7);
        requestBody.put("status", "approved");
        Response response = given().header("Content-Type", "application/json").
                header("Accept", "application/json").body(requestBody).
                when().post("order");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    void testDeleteOrder() {
        Response response = given().header("Content-Type", "application/json")
                .header("Accept", "application/json").
                        when().delete("order/10");
        Assert.assertEquals(response.statusCode(), 200);
    }

}
