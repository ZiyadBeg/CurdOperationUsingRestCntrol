http://localhost:8081/addEmployee
Request:
{
       "name": "Jack",
    "address": "CST",
    "email": "jack@gmail.com"
}

http://localhost:8081/getAllEmployeeById/3
Response.
{
    "id": 1,
    "name": "Jack",
    "address": "CST",
    "email": "jack@gmail.com"
}

http://localhost:8081/getAllEmployeeDetails
{
    "id": 1,
    "name": "Jack",
    "address": "CST",
    "email": "jack@gmail.com"
}

http://localhost:8081/updateEmployee/2
{
   "name": "salman",
        "address": "sion",
        "email": "salman@gmail.com"
    }
	

http://localhost:8081/updateEmployeeEmail/2/ss.salman@gmail.com
Response
{
    "id": 2,
    "name": "salman",
    "address": "sion",
    "email": "ss.salman@gmail.com"
}
