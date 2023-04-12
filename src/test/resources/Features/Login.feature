Feature: Login Functionalities

  @smoke
  Scenario: Valid Admin login
    # Given open the browser and launch HRMS application  (No need this line coz we did pre condition in hook class)
    When user enters valid email and valid password
    And click on login button
    Then user is logged in successfully
    # And Close the browser (No need this line coz we did post condition in hook class)



  @smoke2
  Scenario: Valid Admin login
  # Given open the browser and launch HRMS application
    When user enters valid "admin" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully
    # And Close the browser


  @scenarioOutline
  #Parameterization/Data Driven
  Scenario Outline: Login with multiple credentials using scenario outline
    # Given open the browser and launch HRMS application
    When user enters valid "<username>" and valid "<password>"
    And click on login button
    Then user is logged in successfully
    # And Close the browser
    Examples:
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |


  @dataTable
  Scenario: Login with multiple credentials using data table
    When user enters username and password and verifies login

      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |






