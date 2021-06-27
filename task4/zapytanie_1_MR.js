var mapper = function() {
    weight = parseFloat(this.weight) 
    height = parseFloat(this.height)
    emit(this.sex, { weight, height, count:1 })
};

var reducer = function(key, values) { 
	return values.reduce(function(previous, current) {
		previous.weight += current.weight;
		previous.height += current.height;
		previous.count += current.count;
		return previous;
	}, { weight: 0, height:0, count: 0 });
};

var finalizer = function(key, reducedVal) {
    avg_weight = reducedVal.weight / reducedVal.count;
    avg_height = reducedVal.height / reducedVal.count;
	return {avg_weight, avg_height}
};

db.people.mapReduce(
   mapper,
   reducer,
   {
     out: 'avg_weight_and_height_by_sex',
     finalize: finalizer
   }
);

printjson(db.avg_weight_and_height_by_sex.find().toArray());