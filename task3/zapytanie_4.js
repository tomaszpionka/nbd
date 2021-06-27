printjson(db.people.aggregate([
{$project: {_id:1, weight:{$toDouble: "$weight"}}},
{$match: {weight:{$gte:68, $lt:71.5}}}
]).toArray())