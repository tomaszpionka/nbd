printjson(db.people.aggregate([
{$match: {birth_date:{$gte:"2001"}}},
{$project: {_id:0, first_name:1, last_name:1, city:"$location.city"}}
]).toArray())