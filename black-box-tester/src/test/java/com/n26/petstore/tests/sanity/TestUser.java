package com.n26.petstore.tests.sanity;

import com.n26.TestRunnerBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

@Slf4j
public class TestUser {

    @BeforeClass
    void before() {
        TestRunnerBase.config();
        RestAssured.baseURI = TestRunnerBase.getProps().getPetStoreURL() + "/user/";
    }

    @Test
    void testGetLogin() {
        Response response = given().
                queryParam("username", "abc").
                queryParam("password", "123").
                when().get("login");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    void testGetLogout() {
        Response response = when().get("logout");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority=2)
    void testGetUser() {
        Response response = when().get("testUser");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority=1)
    void testPostUser() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", "10");
        requestBody.put("username", "testUser");
        requestBody.put("userStatus", 1);
        Response response = given().
                header("Content-Type", "application/json").
                header("Accept", "application/json").
                body(requestBody).
                when().post();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority=1)
    void testPostUserList() {
        JSONArray requestBody = new JSONArray();
        JSONObject user1 = new JSONObject();
        user1.put("id", "11");
        user1.put("username", "user1");
        user1.put("userStatus", 1);

        JSONObject user2 = new JSONObject();
        user2.put("id", "12");
        user2.put("username", "user2");
        user2.put("userStatus", 1);

        requestBody.add(user1);
        requestBody.add(user2);

        Response response = given().
                header("Content-Type", "application/json").
                header("Accept", "application/json").
                body(requestBody).
                when().post("createWithList");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority=3)
    void testPutUser() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", "11");
        requestBody.put("username", "theUser1");
        requestBody.put("userStatus", 1);
        Response response = given().header("Content-Type", "application/json").
                header("Accept", "application/json").
                        body(requestBody).when().put("user1");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority=4)
    void testDeleteUser() {
        Response response = given().header("Content-Type", "application/json").
                header("Accept", "application/json").
                        when().delete("theUser1");
        Assert.assertEquals(response.statusCode(), 200);
    }

}
