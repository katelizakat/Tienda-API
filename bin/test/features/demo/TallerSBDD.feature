@REQ_PQBP-511 @TallerSBDD
Feature:  Taller de pruebas para automatizacion WEB desde SerenityBDD

  @id:1 @AfiliacionTCEmailIncorrecto
  Scenario Outline: T-E2E-PQBP-511-CA07 - Ingreso al flujo con mail incorrecto
    Given que el cliente esta en la pantalla de login
    When ingresa sus credenciales incorrectas cedula "<dni>" y mail "<mail>"
    Then deberia visualizar el mensaje de error "Por favor, revisa que el número celular o correo coincida con el registrado en el banco"
    Examples:
      | @externaldata@taller\DataAffiliation.xlsx..AfTC |
