package com.api.project.junit

import com.api.project.base.TestBase
import io.restassured.RestAssured
import org.junit.Test

class DeleteStudent : TestBase(){

    @Test
    fun shouldDeleteStudent() {

        RestAssured.given()
                .`when`()
                .delete("/14")
                .then()
                .statusCode(200)
    }
}