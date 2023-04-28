#Senaryo
  # Exam formunun calismasini test ediniz
  # 1 sinav girisi yapip
  # sonrasinda silmesini yapiniz

Feature: New Exam Creation

  Background:
    Given Navigate to Campus
    When Enter username and password correctly and click login button
    Then User should login successfully

  Scenario: Creating a new exam with necessary inputs

    And Click on the element in LeftNav
      | examsTab     |
      | examSetupTab |
      | examsMenu    |

    And Click on the element in Dialog Content
      | addBtn |

    And User sending the keys in Dialog Content
      | nameInput | Selenium 75 |

    And Click on the element in Dialog Content
      | periodSelect  |
      | periodSelect2 |
      | gradeSelect   |
      | gradeSelect2  |
      | saveButton    |

    Then Success message should be displayed

    And Click on the element in LeftNav
      | examsTab     |
      | examSetupTab |
      | examsMenu    |

    And User delete item from Dialog Content
      | Selenium 75 |

    Then Success message should be displayed
