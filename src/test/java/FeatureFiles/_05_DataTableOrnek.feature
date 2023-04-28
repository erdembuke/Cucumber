Feature: DataTable Ornek

  Scenario: Users List
    When write username "ismet"
    And write username and password "ismet" "1234"
    And write username as DataTable
        | erdem |
        | emrah |
        | enes |
        | seyma |

    And write username and password as DataTable
      | erdem | 1234 |
      | emrah | 4564 |
      | enes  | 3131 |
      | seyma | 5577 |
