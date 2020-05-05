package com.api.project.junit

import com.api.project.base.TestBase
import com.api.project.junit.model.Student
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.junit.Test
import java.util.*

class PostStudent : TestBase() {

    @Test
    fun shouldCreateNewStudent() {
        val discipline = ArrayList<String>()
        discipline.add("Qualidade de Software")
        discipline.add("Probabilidade e Estatística")
        discipline.add("Software Livre")

        val student = Student()
        student.nome = "Robert"
        student.sobrenome ="Walter"
        student.email = "walter@gmail.com"
        student.curso = "Tecnologia da Informação"
        student.periodo = "5"
        student.disciplinas = discipline

        RestAssured.given()
                .contentType(ContentType.JSON)
                .`when`()
                .body(student)
                .post()
                .then()
                .statusCode(201)
    }
}