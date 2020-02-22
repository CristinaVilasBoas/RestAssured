package org.example.healthCheck;

import org.junit.Test;
import static io.restassured.RestAssured.given;

public class RandomUser_health {

    @Test
    public void randomUserBrazilian() {
        given().
            param("nat", "br").
            body("").
        when().
            get("https://randomuser.me/api/").
        then().
            assertThat().statusCode(200);
    }

}
