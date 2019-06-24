package com.telepathy.fizzbuzz;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class FizzBuzzTest {

    public static String returnedString = "";

    public static String endPoint = "http://fibuzzapi.herokuapp.com/api/numbers";

    public static Response doGetRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;

        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }

    public static String fizzBuzz(int number) {
            if (number%15 == 0) {
                returnedString = "FizzBuzz";
            } else if (number%3 == 0 && number%5 != 0) {
                returnedString = "Fizz";
            } else if (number%5 == 0 && number%3 != 0) {
                returnedString = "Buzz";
            } else {
                returnedString = Integer.toString(number);
            }
            return returnedString;
        }

    @Test
    public void testFizzBuzz() {
        Response response = doGetRequest(endPoint);
        List<Integer> jsonResponseId = response.jsonPath().getList("numbers.id");
        List<String> jsonResponseValue = response.jsonPath().getList("numbers.value");
        List<String> actualValue = new ArrayList<>();
        for (int i = 1; i <= jsonResponseId.size(); i++) {
            actualValue.add(fizzBuzz(i));
        }
        Assert.assertEquals(actualValue, jsonResponseValue);
        }
    }

