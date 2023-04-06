from snowflake import SnowflakeGenerator

gen = SnowflakeGenerator(0)

def next_id():
    return next(gen)