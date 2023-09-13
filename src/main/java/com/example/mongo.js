[
    {$match: {gender: "female"}},
    {$group: {_id: {state: "$location.state"}, totalPersons: { $sum: 1}}}
]

[
    {$match: {gender: "female"}},
    {$group: {_id: {state: "$location.state"}, totalPersons: { $sum: 1}}},
    {$sort: {totalPersons: -1}}
]

db.users.aggregate([
    {$project: { _id: 0, gender: 1, fulllName: { $concat: ["$name.first", " ", "$name.last"]}}}

]);

db.users.aggregate([
    {
        $project: {
            _id: 0,
            gender: 1,
            fulllName: {
                $concat: [
                    {$toUpper: {$substrCP: ["$name.first", 0, 1]}},
                    {$substrCP: ["$name.first", 1, {$subtract: [{$strLenCp: "$strLenCP"}, 1]}]},
                    " ",
                    {$toUpper: "$name.last"}]
            }
        }
    }

]);

db.users.aggregate([
    {
        $project: {
            _id: 0,
            name: 1,
            email: 1,
            location: {
                type: "Point",
                coordinates: [
                    {$convert: {
                        input: "$location.coordinates.longitude",
                            to: "double",
                            onError: 0.0,
                            onNull: 0.0}},
                    {$convert: {
                            input: "$location.coordinates.latitude",
                            to: "double",
                            onError: 0.0,
                            onNull: 0.0}},
                    ]
            }
        }
    },
    {
        $project: {
            _id: 0,
            gender: 1,
            fulllName: {
                $concat: [
                    {$toUpper: {$substrCP: ["$name.first", 0, 1]}},
                    {$substrCP: ["$name.first", 1, {$subtract: [{$strLenCP: "$name.last"}, 1]}]},
                    " ",
                    {$toUpper: "$name.last"}]
            }
        }
    }

]);

db.friends.aggregate([
    {$unwind: "$hobbies"},
    {$group: {_id: {age: "$age"}, allHobbies: {$addToSet: "$hobbies"}}}
])

db.friends.aggregate([
    {$project: {_id: 0, examScore: {$slice: ["$examScores", 1 ]}}}
])

db.friends.aggregate([
    {$project: {_id: 0, scores: {$filter: {input: "$examScores", as: "sc", cond: {$gt: ["$$sc.score",60]}}}}}
])

db.friends.aggregate([
    {$unwind: "$examScores"},
    {$project: {_id: 1, name: 1, score: "$examScore.score"}},
    {$sort: {score: -1}},
    {$group: {_id: "$_id", name: {$first: "$name"}, maxScore: {$max: "$score"}}},
    {$sort: {maxScore: -1}}
])

db.friends.aggregate([
    {$project: {_id: 0, name: 1, birthdate: {$toDate: "$dob.date"}}},
    {$sort: {birthdate: 1}},
    {$skip: 10},
    {$limit: 10}
])

//join 2 tables
db.person.aggregate([
    {$match: {"_id": "ee733320-5dae-42b4-af42-1006847688de"}},
    {$lookup: {
        from: "company",
        localField: "companyId",
        foreignField: "_id",
        as: "companyData"
    }},
    {$project: {"_id": 0, "companyId": "$companyData._id", "name": "$companyData.name"}}
])

//join 3 tables
db.person.aggregate([
    {$match: {"_id": "ee733320-5dae-42b4-af42-1006847688de"}},
    {$lookup: {
            from: "company",
            localField: "companyId",
            foreignField: "_id",
            as: "companyData"
        }},
    {$unwind: "$companyData"},
    {$lookup: {
        from: "phone",
            localField: "companyData._id",
            foreignField: "companyId",
            as: "phoneData"
        }},
    {$project: {"_id": 0, "phones": "$phoneData"}}

])




