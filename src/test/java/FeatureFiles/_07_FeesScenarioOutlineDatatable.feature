#Senaryo
  # Daha onceki fee functionality senaryosunu
  # name , code , intCode ve priority icin 5 farkli kombinasyon icin calistirin

Feature: Fee creating

  Background:
    Given Navigate to Campus
    When Enter username and password correctly and click login button
    Then User should login successfully

  Scenario Outline: Fee Functionality

    And Click on the element in LeftNav
      | setupTab      |
      | parametersTab |
      | feesTab       |

    And Click on the element in Dialog Content
      | addBtn |

    And User sending the keys in Dialog Content
      | nameInput     | <name>     |
      | codeInput     | <code>     |
      | priorityInput | <priority> |

    And Click on the element in Dialog Content
      | activeToggle |
      | saveButton   |

    Then Success message should be displayed

    And User delete item from Dialog Content
      | <name> |

    Then Success message should be displayed

    Examples:
      | name    | code | priority |
      | erdem12 | 3331 | 88755    |
      | erdem12 | 3332 | 88756    |
      | erdem12 | 3333 | 88757    |
      | erdem12 | 2223 | 88758    |
