var mapper = function() {
    if (this.sex == 'Female' && this.nationality == 'Poland')
    {
        this.credit.forEach(credit => {
            sum_balance = parseFloat(credit.balance)
            emit(credit.currency, {sum_balance, count: 1})
        });
    }
};

var reducer = function(key, values) { 
	return values.reduce(function(previous, current) {
		previous.sum_balance += current.sum_balance;
		previous.count += current.count;
		return previous;
	}, { sum_balance: 0, count: 0 });
};

var finalizer = function(key, reducedVal) {
    sum_balance = reducedVal.sum_balance
    avg_balance = sum_balance / reducedVal.count;
	return {avg_balance, sum_balance}
};

db.people.mapReduce(
   mapper,
   reducer,
   {
     out: 'avg_and_sum_balance_by_currency',
     finalize: finalizer
   }
);

printjson(db.avg_and_sum_balance_by_currency.find().toArray());