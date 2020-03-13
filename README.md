Можно улучшить:(но надо время)
1) валидация данных
2) мне кажется можно было бы воспользоваться Spring Integration, но с ним мало опыта
3) нет проверки на "дурака"
4) отделить производство подарков в отдельный микросервис
5) потом все в docker и docker compose
6) логгирование с помощи aop


Технологии/Библиотеки:
1) H2
2) Spring Boot(Data, Web)
3) Swagger
4) Lombok
5) ModelMapper
6) Spring Cloud Openfeign



Для просмотра и удобного теста запросов заходим на: http://localhost:8080/swagger-ui.html  (после запуска)

Для просмотра h2 базы данных: http://localhost:8080/h2-console    (ничего не меняя, сразу вход)


Docker

https://hub.docker.com/repository/docker/ksergey1999/santa/general

docker pull ksergey1999/santa:latest

docker run -d -p 8080:8080 ksergey1999/santa
