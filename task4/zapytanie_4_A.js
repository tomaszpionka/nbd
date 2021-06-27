printjson(db.people.aggregate([
    {$project: {_id:1, nationality:1, bmi:{$divide:[{$toDouble: "$weight"}, {$pow:[{$divide:[{$toDouble: "$height"}, 100]}, 2]}]}}},
    {$group: {_id: "$nationality", avg_bmi: {$avg:"$bmi"}, min_bmi: {$min:"$bmi"}, max_bmi: {$max:"$bmi"}}}
    ]).toArray())