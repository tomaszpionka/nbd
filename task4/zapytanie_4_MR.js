var mapper = function() {
    weight = parseFloat(this.weight) 
    height = parseFloat(this.height) / 100
    bmi = weight / Math.pow(height, 2)
    emit(this.nationality, { sum_bmi: bmi, min_bmi: bmi, max_bmi: bmi, count: 1 })
};

var reducer = function(key, values) { 
	return values.reduce(function(previous, current) {
		previous.sum_bmi += current.sum_bmi;
		previous.min_bmi = Math.min(previous.min_bmi, current.min_bmi);
		previous.max_bmi = Math.max(previous.max_bmi, current.max_bmi);
		previous.count += current.count;
		return previous;
	}, { sum_bmi: 0, min_bmi: 9999999, max_bmi: -1, count: 0 });
};

var finalizer = function(key, reducedVal) {
    avg_bmi = reducedVal.sum_bmi / reducedVal.count;
    min_bmi = reducedVal.min_bmi;
    max_bmi = reducedVal.max_bmi;
	return {avg_bmi, min_bmi, max_bmi}
};

db.people.mapReduce(
   mapper,
   reducer,
   {
     out: 'avg_min_max_bmi_by_nationality',
     finalize: finalizer
   }
);

printjson(db.avg_min_max_bmi_by_nationality.find().toArray());