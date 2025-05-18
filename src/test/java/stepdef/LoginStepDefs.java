package stepdef;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginStepDefs {
    private Response response;

    @When("User sends GET request to post endpoint")
    public void user_sends_get_request_to_post_endpoint() {
        response = given()
            .header("Content-Type", "application/json")
            .get("https://jsonplaceholder.typicode.com/posts/1");

        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asPrettyString());
    }

    @Then("Response status code should be {int}")
    public void response_status_code_should_be(int statusCode) {
        assertThat(response.statusCode(), is(statusCode));
    }

    @Then("Response title should be {string}")
    public void response_title_should_be(String title) {
        assertThat(response.jsonPath().getString("title"), is(title));
    }
}
