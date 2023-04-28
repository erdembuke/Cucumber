#Senaryo :
#  Bir önceki Exam Giriş Senaryosunu
#  Aşağıdaki değerler için çalıştırınız.
#
#| ExamName        | AcademicPeriodOption         | GradeLevelOption |
#| Math exam is1   | academicPeriod1              | gradeLevel2  |
#| IT exam is1     | academicPeriod1              | gradeLevel3  |
#| Oracle exam is1 | academicPeriod1              | gradeLevel4  |
#| Math exam is2   | academicPeriod1              | gradeLevel5  |

Feature: New Exam Creation Outline

  Background:
    Given Navigate to Campus
    When Enter username and password correctly and click login button
    Then User should login successfully

  Scenario Outline: Creating a new exam with necessary inputs

    And Click on the element in LeftNav
      | examsTab     |
      | examSetupTab |
      | examsMenu    |

    And Click on the element in Dialog Content
      | addBtn |

    And User sending the keys in Dialog Content
      | nameInput | <examName> |

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
      | <examName> |

    Then Success message should be displayed
    Examples:
      | examName | academicPeriodOption | gradeLevelOption |