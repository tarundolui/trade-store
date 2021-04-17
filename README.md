# trade-store

> How to start the application
 This is spring boot application. Can be run as Java main program
 
> Input format and how to send trade to the system
  JSON formatted trade can be sent and below is the sample. Postman or any API client tool can be used to send it. After sending the trade, API will automatically pull the stored trades and display as per the requirement. Below is the sample in put and sample out put for multiple records.
 

http://localhost:8080/send
POST

  {
    "tradeId":"T1",
    "version":1,
    "bookId":"B1",
    "counterPartyId":"CP-1",
    "maturityDate":"20/04/2021"
  }

Sample output list of trades- 

[
    {
        "tradeId": "T1",
        "version": 1,
        "counterPartyId": "CP-1",
        "bookId": "B1",
        "maturityDate": "20/04/2021",
        "creatDate": "17/04/2021",
        "expiryFlag": "N"
    },
    {
        "tradeId": "T2",
        "version": 2,
        "counterPartyId": "CP-2",
        "bookId": "B1",
        "maturityDate": "20/05/2021",
        "creatDate": "17/04/2021",
        "expiryFlag": "N"
    },
    {
        "tradeId": "T2",
        "version": 1,
        "counterPartyId": "CP-1",
        "bookId": "B1",
        "maturityDate": "20/05/2021",
        "creatDate": "17/04/2021",
        "expiryFlag": "N"
    }
]

>How application will store the data
 No database has been used. Stored in class variable so data will be cleared if the application gets stopped.
 
> How to get the stored trades
  Below API has been exposed to get the stored trades 
  http://localhost:8080/get
  Method GET

