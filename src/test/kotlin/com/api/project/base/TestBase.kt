package com.api.project.base

import io.restassured.RestAssured
import org.junit.Before

open class TestBase {

    @Before
    fun setup() {
        RestAssured.baseURI = "https://5e8dd23722d8cd0016a79af9.mockapi.io"
        RestAssured.basePath = "/api/v1/students"
    }
}