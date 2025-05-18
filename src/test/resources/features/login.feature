Feature: Get Post

    Scenario: Get post with ID 1
        When User sends GET request to post endpoint
        Then Response status code should be 200
        And Response title should be "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
