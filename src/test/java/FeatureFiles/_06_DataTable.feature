Feature: DataTable Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password correctly and click login button
    Then User should login successfully

  Scenario: Create Country
    And Click on the element in LeftNav
      | setupTab      |
      | parametersTab |
      | countries     |

    And Click on the element in Dialog Content
      | addBtn |

    And  User sending the keys in Dialog Content
      | nameInput | TechLand71 |
      | codeInput | 34802      |

    And Click on the element in Dialog Content
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog Content
      | TechLand71 |

    Then Success message should be displayed

  @Regression
  Scenario: Create Nationality

    And Click on the element in LeftNav
      | setupTab      |
      | parametersTab |
      | nationalities |

    And Click on the element in Dialog Content
      | addBtn |

    And User sending the keys in Dialog Content
      | nameInput | usaabcd |

    And Click on the element in Dialog Content
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog Content
      | usaabcd |

    Then Success message should be displayed

  @Regression
  Scenario: Fee Functionality

    And Click on the element in LeftNav
      | setupTab      |
      | parametersTab |
      | feesTab       |

    And Click on the element in Dialog Content
      | addBtn |

    And User sending the keys in Dialog Content
      | nameInput     | lk776562 |
      | codeInput     | 772441   |
      | priorityInput | 11552     |

    And Click on the element in Dialog Content
      | activeToggle |
      | saveButton   |

    Then Success message should be displayed

    And User delete item from Dialog Content
      | lk77656 |

    Then Success message should be displayed




