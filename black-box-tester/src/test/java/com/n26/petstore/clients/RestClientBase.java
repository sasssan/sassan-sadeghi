package com.n26.petstore.clients;


import com.n26.TestConfig;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

public abstract class RestClientBase {

    protected Response response;
    protected RequestSpecification request;
    @Getter
    protected static int defaultToutMilliSec;
    protected static String PetStoreURL;
    protected static RestAssuredConfig config;


    public abstract String getName();

    /**
     * Reads the injected TestConfig instance and assigns the static values
     *
     * @throws Exception
     */
    public static void init(TestConfig props) {
        defaultToutMilliSec = Integer.parseInt(props.getDefaultTimeoutMilSec());

        config = RestAssuredConfig.config().sslConfig(new SSLConfig().relaxedHTTPSValidation()).
                httpClient(HttpClientConfig.httpClientConfig().
                        setParam("http.connection.timeout", defaultToutMilliSec).
                        setParam("http.socket.timeout", defaultToutMilliSec).
                        setParam("http.connection-manager.timeout", defaultToutMilliSec));

        PetStoreURL = props.getPetStoreURL();

    }

    /**
     * @return - a printable pretty response
     */
    public String getPrettyResponse() {
        return response != null ? response.prettyPrint() : "";
    }

}
