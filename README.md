# CommTh
This is my pet project where i try to learn spring-boot. This is beckend of messenger. But unfortunatelly it doesn't contain front-end, so there currently is only rest-api and some html pages for testing.

# Technologies
1) Java 17
2) Spring-boot
3) postgres (for storing information about user and message metadata)
4) haproxy (load balancer)
5) redis (cache for storing sessions)
6) cassandra (document db for storing message content)

# Scheme
![alt text](https://github.com/Ord1naryMan/CommTh/blob/master/scheme/Untitled-2023-08-19-1208.png)

# Explanation (en)

- I just started this project and i'm not best at spring, so this is not ideal, but i'm trying to fix that :) (fell free to show me my issues).

- I use Just Oauth2, because i thought that it would be enough, so I'll add password registration outh some day.

- I store sessions in redis because my load balancer uses 'round robin' mechanism (i know i can use tokens, but it is more complicated, i wanna do this in future)

# Explanation (ru)

- Я только начал этот проект и не очень хорошо разбираюсь в Spring, поэтому код не идеальный, но я пытаюсь это исправить :) (не стесняйтесь указывать на маи проблемы).
- 
- Я использую только Oauth2, потому что думал, что этого будет достаточно, но когда-нибудь добавлю регистрацию с паролем.

- Я храню сессии в Redis, потому что мой балансировщик нагрузки использует механизм циклического перебора (round robin) (я знаю, что могу использовать токены, но это сложнее, я хочу сделать это в будущем)


# Features

- You can register using oauth2
- You can send messages to another user
- You can see message history

# Setup
If you want to run this project You can use docker, but You need to configure postgres and cassandra manually :(  (i working on it)

1) open this repo by downloading it and unpacking .zip file or run this command if You have git:
```bash
git clone https://github.com/Ord1naryMan/CommTh/ && cd CommTh
```

2) build docker image:
   ```bash
   docker compose up --build
   ```

3) when everything is downloaded You can stop by pressing ctrl + c
4) now u need to go to postgress and cassandra and run this commands:
5) postgres
 ```bash
   docker exec -it commth-db-1 bash -c "psql -U postgres -d chat"
   ```
   then paste this and press enter:
   ```sql
   drop table if exists users;
drop table if exists message;

create table users (
                      id bigserial primary key ,
                      username char(128) not null unique,
                      mail char(128) not null unique
);

create table message (
    message_id uuid not null unique primary key ,
    users_id_from bigint not null,
    users_id_to bigint not null,
    time timestamp not null
);
```

6) cassandra
 ```bash
   docker exec -it commth-cassandra-1 bash -c "cqlsh -u cassandra -p cassandra"
   ```
then paste this and press enter
```sql
CREATE KEYSPACE spring_cassandra WITH replication = {'class' : 'SimpleStrategy', 'replication_factor' : 1};
```
then paste this and press enter
``` bash
create table spring_cassandra.message_content(id UUID PRIMARY KEY, message_content text);
```
Now u can run
```bash
docker compose up
```

And this app is running


# Sorry
I am really sorry for such setup proccess, i am working on automatisation.
If You can help me o nautomatisation it would be really cool :)
