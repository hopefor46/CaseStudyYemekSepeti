Feature: Login Cases

  Scenario Outline: Login With Valid Credentials
    Given "<browser>" and user is on Main Page
    When user enters username as "<username>"
    And user enters password as "<password>"
    And user hits login
    Then username should be "Cihan Küçük"

    Examples:
      | browser | username              | password     |
      | chrome  | izzetcihank@gmail.com | YemekIcmek;1 |
      | firefox | izzetcihank@gmail.com | YemekIcmek;1 |

  Scenario Outline: Failed Login With Invalid Username
    Given "<browser>" and user is on Main Page
    When user enters username as "<username>"
    And user enters password as "<password>"
    And user hits login
    Then username should be "Cihan Küçük"

    Examples:
      | browser | username                 | password     |
      | chrome  | izzetcihankabc@gmail.com | YemekIcmek;1 |
      | firefox | izzetcihankabc@gmail.com | YemekIcmek;1 |

  Scenario Outline: Failed Login With Invalid Password
    Given "<browser>" and user is on Main Page
    When user enters username as "<username>"
    And user enters password as "<password>"
    And user hits login
    Then username should be "Cihan Küçük"

    Examples:
      | browser | username                 | password     |
      | chrome  | izzetcihank@gmail.com | YemekIcmek;1abc |
      | firefox | izzetcihank@gmail.com | YemekIcmek;1abc |

  Scenario Outline: Adding Kukla and Big Bang to Favourites
    Given "<browser>" and user is on Main Page
    When user enters username as "<username>"
    And user enters password as "<password>"
    And user hits login
    And user searchs for "<place>" selects with home address
    And user adds place to favourites
    Then favourite places include "<place>"

    Examples:
      | browser | username              | password     | place        |
      | chrome  | izzetcihank@gmail.com | YemekIcmek;1 | Good Beef    |
      | chrome  | izzetcihank@gmail.com | YemekIcmek;1 | Ekrem Coşkun |
      | firefox | izzetcihank@gmail.com | YemekIcmek;1 | Good Beef    |
      | firefox | izzetcihank@gmail.com | YemekIcmek;1 | Ekrem Coşkun |