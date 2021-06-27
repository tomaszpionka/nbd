printjson(db.people.insertOne({
	"sex" : "Male",
        "first_name" : "Tomasz",
        "last_name" : "Pionka",
        "job" : "Junior BI Programmer",
        "email" : "s23702@pjatk.edu.pl",
        "location" : {
                "city" : "Warsaw",
                "address" : {
                        "streetname" : "Chlebowa",
                        "streetnumber" : "420"
                }
        },
        "description" : "hello there",
        "height" : "180.5",
        "weight" : "73.45",
        "birth_date" : "1994-12-29T01:22:33Z",
        "nationality" : "Poland",
        "credit" : 
		[{
                        "type" : "switch",
                        "number" : "1234555543210000420",
                        "currency" : "PLN",
                        "balance" : "1500.00"
                }]
}))