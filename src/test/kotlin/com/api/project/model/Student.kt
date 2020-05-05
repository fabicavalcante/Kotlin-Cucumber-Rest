package com.api.project.junit.model

import com.fasterxml.jackson.annotation.JsonInclude
import lombok.Getter
import lombok.Setter

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)

class Student {
    var nome: String? = null
    var sobrenome: String? = null
    var email: String? = null
    var curso: String? = null
    var periodo: String? = null
    var disciplinas: List<String>? = null
}