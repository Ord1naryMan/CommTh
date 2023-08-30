# CommTh
This is my pet project where i try to learn spring-boot.

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
