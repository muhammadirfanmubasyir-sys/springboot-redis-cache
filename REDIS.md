# Redis Client Guide

## Accessing Redis Client

### Via Docker Compose

Start Redis:

```bash
docker-compose up -d
```

Open a Redis CLI session inside the running container:

```bash
docker-compose exec redis redis-cli
```

### Via WSL (if Redis is installed locally)

```bash
redis-cli
```

### Connect to Remote Redis

```bash
redis-cli -h <host> -p <port> -a <password>
```

Example:

```bash
redis-cli -h 127.0.0.1 -p 6379
```

## Key Commands

### Connection

| Command | Description |
|---------|-------------|
| `PING` | Test connection, returns `PONG` |
| `AUTH <password>` | Authenticate with password |
| `INFO server` | Show server info (version, uptime, etc.) |
| `QUIT` | Close the connection |

### String (Key-Value)

| Command | Description |
|---------|-------------|
| `SET key value` | Set a key-value pair |
| `GET key` | Get the value of a key |
| `DEL key` | Delete a key |
| `EXISTS key` | Check if a key exists (1 = yes, 0 = no) |
| `EXPIRE key seconds` | Set a TTL on a key |
| `TTL key` | Check remaining TTL of a key (-1 = no expiry, -2 = key does not exist) |
| `KEYS pattern` | Find keys matching a pattern (e.g., `KEYS *`, `KEYS products:*`) |

### Hash

| Command | Description |
|---------|-------------|
| `HSET key field value` | Set a field in a hash |
| `HGET key field` | Get a field from a hash |
| `HGETALL key` | Get all fields and values in a hash |
| `HDEL key field` | Delete a field from a hash |

### List

| Command | Description |
|---------|-------------|
| `LPUSH key value` | Push value to the left (head) of a list |
| `RPUSH key value` | Push value to the right (tail) of a list |
| `LPOP key` | Pop value from the left |
| `RPOP key` | Pop value from the right |
| `LRANGE key start stop` | Get a range of elements (e.g., `LRANGE mylist 0 -1` for all) |

### Set

| Command | Description |
|---------|-------------|
| `SADD key value` | Add a value to a set |
| `SMEMBERS key` | Get all members of a set |
| `SISMEMBER key value` | Check if a value is in a set |
| `SREM key value` | Remove a value from a set |

### Sorted Set

| Command | Description |
|---------|-------------|
| `ZADD key score member` | Add a member with a score |
| `ZRANGE key start stop` | Get members by index range |
| `ZRANGEBYSCORE key min max` | Get members by score range |
| `ZREM key member` | Remove a member |

### Server / Administration

| Command | Description |
|---------|-------------|
| `DBSIZE` | Number of keys in the current database |
| `FLUSHDB` | Delete all keys in the current database |
| `FLUSHALL` | Delete all keys in all databases |
| `SELECT index` | Switch to a different database (0-15) |
| `INFO` | Show server info (memory, clients, stats, etc.) |
| `MONITOR` | Real-time log of all commands (press Ctrl+C to stop) |
| `CONFIG GET *` | Show all configuration settings |

## Useful Patterns for This Project

### Check cached products

```bash
redis-cli KEYS "products::*"
```

### Inspect a cached product

```bash
redis-cli GET "products::1"
```

### Flush all cache

```bash
redis-cli FLUSHALL
```

### Monitor cache activity in real-time

```bash
redis-cli MONITOR
```

### Check Redis memory usage

```bash
redis-cli INFO memory
```
