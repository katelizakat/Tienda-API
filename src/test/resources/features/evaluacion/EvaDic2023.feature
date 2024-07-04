@REQ_PQBP-556  @evaApiDic2023 @gomez123
Feature: Evaluacion de Apis con karate diciembre 2023

  Background:
    * def UtilEva = Java.type('com.pichincha.automationtest.util.UtilEva')

  @id:1 @crearNuevoUsuario123
  Scenario Outline: T-API-CA01 - Crear un nuevo usuario en signup
    Given url 'https://api.demoblaze.com/signup'
    And request {"username": "<user>","password": "<password>"}
    When method POST
    Then status 200
    * print response
    Examples:
      | read('classpath:../data/evaluacion/DataEva2024_CA01.csv') |


  @id:2 @crearNuevoUsuario123
  Scenario Outline: T-API-CA02 - Crear un nuevo usuario en signup
    Given url 'https://api.demoblaze.com/signup'
    And request {"username": "<user>","password": "<password>"}
    When method POST
    Then status 200
    * print response
    And match response.errorMessage contains "This user already exist."
    Examples:
      | read('classpath:../data/evaluacion/DataEva2024_CA02.csv') |


@id:3 @crearNuevoUsuario123
  Scenario Outline: T-API-CA03 - Crear un nuevo usuario en signup
    Given url 'https://api.demoblaze.com/login'
    And request {"username": "<user>","password": "<password>"}
    When method POST
    Then status 200
    * print response
    And match response contains "#string"
    Examples:
      | read('classpath:../data/evaluacion/DataEva2024_CA02.csv') |

 
@id:4 @crearNuevoUsuario123
  Scenario Outline: T-API-CA04 - Crear un nuevo usuario en signup
    Given url 'https://api.demoblaze.com/login'
    And request {"username": "<user>","password": "<password>"}
    When method POST
    Then status 200
    * print response
    And match response.errorMessage contains "Wrong password."
    Examples:
      | read('classpath:../data/evaluacion/DataEva2024_CA04.csv') |

 