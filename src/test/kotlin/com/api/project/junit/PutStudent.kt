package com.api.project.junit

import com.api.project.base.TestBase
import com.api.project.junit.model.Student
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.junit.Test
import java.util.ArrayList

class PutStudent : TestBase() {

    @Test
    fun shouldPutStudent() {
        val discipline = ArrayList<String>()
        discipline.add("Redes de Computadores")
        discipline.add("Banco de Dados")
        discipline.add("Sistemas para Internet")

        val student = Student()
        student.nome = "Robert"
        student.sobrenome ="Calie"
        student.email = "walter@gmail.com"
        student.curso = "Tecnologia da Informação"
        student.periodo = "5"
        student.disciplinas = discipline

        RestAssured.given()
                .contentType(ContentType.JSON)
                .`when`()
                .body(student)
                .put("/10")
                .then()
                .statusCode(200)
    }

}