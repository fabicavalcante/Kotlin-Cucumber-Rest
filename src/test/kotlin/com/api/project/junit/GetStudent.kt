package com.api.project.junit

import com.api.project.base.TestBase
import io.restassured.RestAssured
import org.hamcrest.Matchers
import org.hamcrest.core.IsEqual
import org.junit.Test

class GetStudent : TestBase() {

    @Test
    fun shouldReturnAllStudents() {
        RestAssured.given()
                .`when`()
                .get()
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    fun shouldReturnId() {
        RestAssured.given()
                .`when`()
                .get("/1")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    fun shouldReturnFirstName() {
        RestAssured.given()
                .`when`()
                .get()
                .then()
                .statusCode(200)
                .assertThat()
                .body("nome[0]", IsEqual.equalTo("Sister"))
    }

    @Test
    fun shouldReturnCourse() {
        RestAssured.given()
                .`when`()
                .get()
                .then()
                .statusCode(200)
                .assertThat()
                .body("curso[0]", IsEqual.equalTo("Análise e Desenvolvimento de Sistemas"));
    }

    @Test
    fun shouldReturnDiscipline() {
        RestAssured.given()
                .`when`()
                .get()
                .then()
                .statusCode(200)
                .assertThat()
                .body("disciplinas[0]", Matchers.hasItem("Contabilidade"))
    }

    @Test
    fun shouldReturnStudentDetail() {
        RestAssured.given()
                .`when`()
                .get()
                .then()
                .statusCode(200)
                .assertThat()
                .body("sobrenome[4]", IsEqual.equalTo("Barrows"))
                .body("curso[4]", IsEqual.equalTo("Rede de Computadores"))
                .body("periodo[4]", IsEqual.equalTo("3"));
    }
}