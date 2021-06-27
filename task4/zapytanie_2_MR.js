var mapper = function() {
    
    this.credit.forEach(credit => {
        balance = parseFloat(credit.balance)
        emit(credit.currency, balance)
    });
};

var reducer = function(key, values) {
	return values.reduce((previous, current) => previous + current);
};

db.people.mapReduce(
   mapper,
   reducer,
   {
     out: 'sum_balance_by_currency'
   }
);

printjson(db.sum_balance_by_currency.find().toArray());