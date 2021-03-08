# Bootiful Calculator | SwingSpringer entry
## 🥈 🎊 2nd place 🎊 🥈
This is my first attempt at Spring Boot and Integration testing. Fortunately I won 2nd place! Very happy with the results since I'm against many people knowledgeable in Java
![Coding Challenge announcement](https://imgur.com/RHDavRB.png)

Entry for the [Shaunwild97's](https://github.com/Shaunwild97/CodingChallenges/tree/master/bootiful-calculator) Coding challenge from the Java Discord server. I recommend to use [VS Code](https://code.visualstudio.com/) for the workspace. The project is built using Spring Boot version 2.4.3 and Java version 1.8.0_261, but any version of Java 8 and above will work.

This project is hosted on [https://bootiful-calculator.herokuapp.com](https://bootiful-calculator.herokuapp.com/). Hook up your favorite REST Client and test the requests! Note that heroku instances falls asleep after minutes of inactivity so be notified that your first request might take time!

To run the project locally, clone or fork it. Open the project in VS Code and run in Spring Boot Dashboard. Afterwards, access it via **http://localhost:8080/calculate** on your favorite REST Client. The workspace recommends [REST Client Extension](https://marketplace.visualstudio.com/items?itemName=humao.rest-client) for VS Code that you can use once installed.


# Setting up
To run the project locally, clone or fork it. Open the project in VS Code and run in Spring Boot Dashboard. Afterwards, access it via **http://localhost:8080/calculate** on your favorite REST Client. The workspace recommends [REST Client Extension](https://marketplace.visualstudio.com/items?itemName=humao.rest-client) for VS Code that you can use once installed.


# Usage
This project only has 1 endpoint: `/calculate`. This endpoint will accept a POST request with the following body template:

```json
POST /calculate
{
  "values": [5, 1, 20],
  "operation": "add",
  "type": "integer"
}
```

field | type | description |
------|------|-------------|
values| Array\<Number\> | A list of numbers, can be whole or decimal. |
operation | String | The operation to perform, possible values are: **add**, **sub**, **mul**, **div**. |
type | String | The type of the expected result, possible values are: **integer**, **decimal**, **safe**.  |


And will respond with a JSON object containing the result:

```json
HTTP 200
{
  "result": 26
}
```

Or in the case of a user error:

```json
HTTP 400
{
  "error": "error reason"
}
```

### Types

The type field is important, it can be one of three values:
value | description |
---   |     ---     |
integer | The values will be processed as whole numbers, any decimals passed into **values** should return an error.
decimal | The values will be processed as decimal numbers, 32-bits of precision will suffice.
safe | The values will be processed as safe decimals, you must ensure there are no floating-point precision errors when applying operations to safe decimals.

### Operations

There are 4 operations this program will support:
operation | description | example
---       | ----        | ----  
add       | Will add all the values together | `[5, 10, 2] => 17`
sub       | Will subtract all the values, starting at the left-most value, and ending at the right-most value. | `[10, 2, 2] => 6`
mul       | Will multiply all the values together. | `[5, 5, 2] => 50`
div       | Will divide all the values, starting at the left-most value, and ending at the right-most value. | `[10, 1, 2] => 5`