Feature: abrir google

  Scenario: abrir o google
    Given Estou no google
    And digito 'Corsa'
    And busco
    And espero 5 segundos