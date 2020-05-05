package com.api.project.junit

import com.api.project.base.TestBase
import com.api.project.junit.model.Student
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.junit.Test
import java.util.ArrayList

class PatchStudent : TestBase(){

    @Test
    fun shouldPatchStudent() {
        val student = Student()
        student.nome = "Robert"
        student.sobrenome ="Warner"

        RestAssured.given()
                .contentType(ContentType.JSON)
                .`when`()
                .body(student)
                .patch("/9")
                .then()
                .statusCode(200)
    }
}