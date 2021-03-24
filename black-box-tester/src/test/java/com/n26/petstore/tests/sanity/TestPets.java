package com.n26.petstore.tests.sanity;


import com.n26.TestRunnerBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Base64;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


@Slf4j
public class TestPets {

    Integer petID = 100;

    @BeforeClass
    void before() {
        TestRunnerBase.config();
        RestAssured.baseURI = TestRunnerBase.getProps().getPetStoreURL() + "/pet/";
    }

    @Test(priority=1)
    void testPostPet() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", petID);
        requestBody.put("name", "testPet");
        requestBody.put("status", "available");
        Response response = given().header("Content-Type", "application/json")
                .header("Accept", "application/json").body(requestBody).when().post();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority=2)
    void testGetPetID() {
        Response response = when().get("2");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    void testGetByStatus() {
        Response response = given().queryParam("status", "available").
                when().get("findByStatus");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    void testGetByTag() {
        Response response = given().queryParam("tags", "tag1").
                when().get("findByTags");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority=2)
    void testPostPetByID() {
        Response response = given().header("Content-Type", "application/json")
                .header("Accept", "application/json").
                        queryParam("status", "available").
                        queryParam("name", "testPetNew").
                        when().post(petID.toString());
        Assert.assertEquals(response.statusCode(), 200);
    }


//    @SneakyThrows
//    @Test
//    void testPostUploadImage() {
//        File image = new File("C:/Users/sassans/workspace/Nodejs/My-React-App/public/assets/img/about-us.jpg");
//        image.createNewFile();
//        byte[] fileContent = FileUtils.readFileToByteArray(new File("C:/Users/sassans/workspace/Nodejs/My-React-App/public/assets/img/about-us.jpg"));
//        byte[] bytes = Base64.getDecoder().decode("octetStream");
//        Response response = given().
////                multiPart("file", new File("test.jpg"), "text/html").
//                header("Content-Type", "application/octet-stream").
//                header("Accept", "application/json").
//                        body(bytes).
//                        urlEncodingEnabled(false).
//                        when().post("2" + "/uploadImage?additionalMetadata=%22%22");
//        Assert.assertEquals(response.statusCode(), 200);
//    }


    @Test(priority=3)
    void testPutPet() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", petID);
        requestBody.put("name", "testPetUpdated");
        requestBody.put("status", "available");
        Response response = given().header("Content-Type", "application/json")
                .header("Accept", "application/json").
                        body(requestBody).when().put();
        Assert.assertEquals(response.statusCode(), 200);
    }


    @Test(priority=4)
    void testDeletePet() {
        Response response = given().header("Content-Type", "application/json")
                .header("Accept", "application/json").
                        when().delete(petID.toString());
        Assert.assertEquals(response.statusCode(), 200);
    }


}
