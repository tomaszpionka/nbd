printjson(db.people.aggregate([
    {$match: {sex:"Female", nationality:"Poland"}},
    {$unwind: "$credit"},
    {$group: {_id: "$credit.currency", avg_balance: {$avg:{$toDouble: "$credit.balance"}}, sum_balance: {$sum:{$toDouble: "$credit.balance"}}}}
    ]).toArray())