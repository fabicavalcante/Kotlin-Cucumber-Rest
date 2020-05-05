package com.api.project.junit.steps

import com.api.project.junit.model.Student
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.restassured.RestAssured
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import java.util.*

class StudentStep {
    var student = Student()
    lateinit var request: RequestSpecification
    lateinit var response: Response

    @Given("^Eu tenha informações do aluno como \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    fun eu_tenha_informações_do_aluno_como(nome: String?, sobrenome: String?, email: String?, curso: String?, periodo: String?, disciplina1: String, disciplina2: String, disciplina3: String) {
        val discipline = ArrayList<String>()
        discipline.add(disciplina1)
        discipline.add(disciplina2)
        discipline.add(disciplina3)

        student.nome = nome
        student.sobrenome = sobrenome
        student.email = email
        student.curso = curso
        student.periodo = periodo
        student.disciplinas = discipline
    }

    @Given("^Eu tenha um header da api$")
    fun eu_tenha_um_header_da_api() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept-Charset", "UTF-8")
                .log()
                .headers()
    }

    @When("^Eu realizar um POST para criação do aluno$")
    fun eu_realizar_um_POST_para_criação_do_aluno() {
            request = RestAssured.given()
            response = request.`when`()
                    .body(student)
                    .log()
                    .body()
                    .post("https://5e8dd23722d8cd0016a79af9.mockapi.io/api/v1/students")
        }

    @When("^eu realizar um GET para consulta do aluno$")
    fun eu_realizar_um_GET_para_consulta_do_aluno() {
        response = request.`when`()
                .get("https://5e8dd23722d8cd0016a79af9.mockapi.io/api/v1/students/1")
    }

    @When("^Eu realizar um PATCH para atualização do aluno$")
    fun eu_realizar_um_PATCH_para_atualização_do_aluno() {
        request = RestAssured.given()
        response = request.`when`()
                .body(student)
                .log()
                .body()
                .patch("https://5e8dd23722d8cd0016a79af9.mockapi.io/api/v1/students/12")
    }

    @When("^Eu realizar um DELETE para exclusão do aluno$")
    fun eu_realizar_um_DELETE_para_exclusão_do_aluno() {
        response = request.`when`()
                .delete("https://5e8dd23722d8cd0016a79af9.mockapi.io/api/v1/students/15")
    }

    @Then("^Eu terei o status code (\\d+)$")
    fun eu_terei_o_status_code(statusCode: Int) {
        request = RestAssured.given()
        response.then().statusCode(statusCode).log().all()
    }
}

