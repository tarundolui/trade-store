# trade-store

> How to start the application
 This is spring boot application. Can be run as Java main program
 
> Input format and how to send trade to the system
  JSON formatted trade can be sent and below is the sample. Postman or any API client tool can be used to send it. After sending the trade, API will automatically pull the stored trades and display as per the requirement. Below is the sample in put and sample out put for multiple records.
 

http://localhost:8080/send
POST

  {
    "tradeId":"1",
    "version":1,
    "bookId":"b12",
    "counterPartyId":"CP1",
    "maturityDate":"2021-04-20",
    "expiryFlag": "N"
}

Sample output- 


[
    {
        "tradeId": "1",
        "version": 2,
        "counterPartyId": "CP1",
        "bookId": "b12",
        "maturityDate": "2021-04-20",
        "creatDate": "2021-04-17",
        "expiryFlag": "N"
    },
    {
        "tradeId": "1",
        "version": 1,
        "counterPartyId": "CP1",
        "bookId": "b12",
        "maturityDate": "2021-04-20",
        "creatDate": "2021-04-17",
        "expiryFlag": "N"
    },
    {
        "tradeId": "2",
        "version": 1,
        "counterPartyId": "CP1",
        "bookId": "b12",
        "maturityDate": "2021-04-20",
        "creatDate": "2021-04-17",
        "expiryFlag": "N"
    }
]

>How application will store the data
 No database has been used. Stored in class variable so data will be cleared if the application gets stopped.
 
> Sample 

