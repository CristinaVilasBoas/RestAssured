package org.example.tests;

import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class RandomUser {
    @Test
    public void randomUserBrazilian() {
        given().
            param("nat", "br").
            body("").
        when().
            get("https://randomuser.me/api/").
        then().
            assertThat().body("results[0].nat", containsString("BR"));
    }

    @Test
    public void randomResults() {
        given().
                param("page",3).
                body("").
                when().
                get("https://randomuser.me/api/?page=3").
                then().log().all().
                assertThat().body("info.page",equalTo(3));
    }
    @Test
    public void randomUserNats() {
        given().
                param("nat","br", "ca", "us", "es").
                body("").
                when().
                get("https://randomuser.me/api/?nat=br,ca,us,es").
                then().log().all().
                assertThat().body("results[0].nat", anyOf(containsString("BR"),
                containsString("CA"),
                containsString("US"),
                containsString("ES")));
    }
    @Test
    public void randomSize() {
        given().
                param("results" , 5).
                body("").
                when().
                get("https://randomuser.me/api/?results=5").
                then().log().all().
                assertThat().body("info.results", equalTo(5));
    }
    
    @Test
    public void randomEmail()
    {
    	given().
    		param("email", "name")
    		.body("")
    		.when()
    		.get("https://randomuser.me/api/?inc=email")
    		.then().log().all().
    		assertThat().body("results[0].email", notNullValue());
    }
    
    @Test
    public void randomName()
    {
    	given().
    		param("email", "name")
    		.body("")
    		.when()
    		.get("https://randomuser.me/api/?inc=name")
    		.then().log().all().
    		assertThat().body("results[0].name", notNullValue());
    }  
    @Test
    public void randomKeyName()
    {
    	given().
    		param("name")
    		.body("")
    		.when()
    		.get("https://randomuser.me/api/?inc=name")
    		.then().log().all().
    		assertThat().body(containsString("name"));
    }  
    
    @Test
    public void randomKeyEmail()
    {
    	given().
		param("email")
		.body("")
		.when()
		.get("https://randomuser.me/api/?inc=email")
		.then().log().all().
		assertThat().body(containsString("email"));
    	
    }
    
    @Test
    public void randomSize10()
    {
    	given().
		param("email", "name", 10)
		.body("")
		.when()
		.get("https://randomuser.me/api/?results=10&inc=name,email")
		.then().log().all().
		assertThat().body("info.results", equalTo(10));
    }  
    
    @Test
    public void randomEmailNome() {
    	given().
		param("email", "name")
		.body("")
		.when()
		.get("https://randomuser.me/api/?results=10&inc=name,email")
		.then().log().all().
		assertThat().body((containsString("email")),
                containsString("name"));
    }
}
    

