package com.recrutamentocompasso;

import io.restassured.RestAssured;
import static io.restassured.http.ContentType.JSON;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.recrutamentocompasso.model.Cidade;

//import io.restassured.response.Response;

@SpringBootTest
class RecrutamentoCompassoApplicationTests {

	@Test
	void testPesquisarCidade() {
		//Response response = 
		RestAssured.given().when().get("/api/cidade").then().statusCode(200);
	}
	
	@Test
	void testInserirCidade() {
		Cidade cidade = new Cidade();
		cidade.setNome("São Paulo");
		cidade.setEstado("SP");
		
		//Response response = 
				RestAssured
				.given()
				.contentType(JSON)
				.body(cidade)
				.when().post("/api/cidade")
				.then().statusCode(200)
				.extract()
				.response();
		
		//response = 
				RestAssured
				.given()
				.contentType(JSON)
				.body(new Cidade())
				.when()
				.post("/api/cidade")
				.then()
				.statusCode(422)
				.extract()
				.response();
		
		//assertEquals(5, response.getBody().as(ErrorMessage[].class).length);
		
		
	}

}
