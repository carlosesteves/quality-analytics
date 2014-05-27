# clear everything
mongo data --eval "db.dropDatabase()"

# add data
mongo data  --eval "db.data.insert(
{
    "projects": "core",
    "build":
        [
            { "id": "rc201", "duration": 1564, "timestamp": "2014-05-06" },
            { "id": "rc202", "duration": 1364, "timestamp": "2014-05-07" },
            { "id": "rc203", "duration": 1164, "timestamp": "2014-05-08" }
        ],
    "test":
        [
            { "id": "rc201", "duration": 164, "timestamp": "2014-05-06" },
            { "id": "rc202", "duration": 89, "timestamp": "2014-05-06" },
            { "id": "rc203", "duration": 456, "timestamp": "2014-05-06" },
        ]
}
)"