local lockKey = KEYS[1]
local lockValue = KEYS[2]

--执行redis命令
local result_1 = redis.call("SETNX", lockKey, lockValue)
if result_1 == true
    then
        local result_2 = redis.call("SETEX", lockKey, 3600, lockValue)
        return result;
    else
    return result_1
end
