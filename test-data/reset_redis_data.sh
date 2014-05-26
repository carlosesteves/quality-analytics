# clear everything
redis-cli flushall

# set data
redis-cli set "rc201:core:build:2014-05-01:1560" 1560
redis-cli set "rc202:core:build:2014-05-01:560" 560
redis-cli set "rc202:core:unit:2014-05-01:150" 150

