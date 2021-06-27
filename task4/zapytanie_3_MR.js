var mapper = function() {
    emit(this.job, 0)
};

var reducer = function(key, values) {
	return 0
};

db.people.mapReduce(
   mapper,
   reducer,
   {
     out: 'unique_jobs'
   }
);

printjson(db.unique_jobs.find().toArray());