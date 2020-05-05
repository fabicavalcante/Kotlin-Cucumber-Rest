Feature: Customer testing

  @Smoke
  Scenario Outline: POST aluno na listagem de matricula
    Given Eu tenha informações do aluno como "<nome>","<sobrenome>","<email>","<curso>","<periodo>","<disciplina1>","<disciplina2>","<disciplina3>"
    And Eu tenha um header da api
    When Eu realizar um POST para criação do aluno
    Then Eu terei o status code 201

    Examples:
      | nome   | sobrenome | email           | curso          | periodo | disciplina1           | disciplina2 | disciplina3    |
      | Julie | Tompson   | julie@gmail.com | Banco de Dados | 3       | Qualidade de Software | Geometria   | Software Livre |

  @Smoke
  Scenario: GET aluno na listagem de matricula
    Given Eu tenha um header da api
    When eu realizar um GET para consulta do aluno
    Then Eu terei o status code 200

  @Smoke
  Scenario Outline: PATCH aluno na listagem de matricula
    Given Eu tenha informações do aluno como "<nome>","<sobrenome>","<email>","<curso>","<periodo>","<disciplina1>","<disciplina2>","<disciplina3>"
    And Eu tenha um header da api
    When Eu realizar um PATCH para atualização do aluno
    Then Eu terei o status code 200

    Examples:
      | nome   | sobrenome | email           | curso          | periodo | disciplina1           | disciplina2 | disciplina3    |
      | Serena | Woodsen   | serena@gmail.com | Banco de Dados | 3       | Redes de Computadores | Ecommerce   | Contabilidade  |

  @Smoke
  Scenario: DELETE aluno na listagem de matricula
    Given Eu tenha um header da api
    When Eu realizar um DELETE para exclusão do aluno
    Then Eu terei o status code 200

