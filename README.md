# Что это ?
Это написаный мной плагин для моего сервера в minecraft для голосования на перезапуск сервера
Версии работы плагина 1.16.X-1.18.X

Для начала голосование напишите в чат `/voterestart` , а для голосов напишите `/vote yes` для "ЗА" и `/vote no` для "ПРОТИВ"

<img width="1050" height="536" alt="image" src="https://github.com/user-attachments/assets/a5711a75-a56e-42a2-8a9d-c210abb98bdb" />

P.S Учтите что я использую команду `/stop` потому, что у меня написан bash скрипт на перезапуск самого процесса

Вот так он выглядит

#!/bin/bash
while :
do
java -Xms7G -Xmx7G -jar magma-1.18.2-server.jar nogui
done
