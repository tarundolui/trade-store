# trade-store

> How to start the application
 This is spring boot application. Can be run as Java main program
 
> Input format and how to send trade to the system
  JSON formatted trade can be sent and below is the sample. Postman or any API client tool can be used to send it
  {
    "tradeId":"1",
    "version":1,
    "bookId":"b12",
    "counterPartyId":"CP1",
    "maturityDate":"2021-04-20",
    "expiryFlag": "N"
}
>How application will store the data
 No database has been used. Stored in class variable so data will be cleared if the application gets stopped.

