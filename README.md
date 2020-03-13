Можно улучшить:(но надо время)
1) валидация данных
2) мне кажется можно было бы воспользоваться Spring Integration, но с ним мало опыта
3) нет проверки на "дурака"


Технологии/Библиотеки:
1) H2
2) Spring Boot(Data, Web,)
3) Swagger
4) Lombok
5) ModelMapper
6) Spring Cloud Openfeign



Для просмотра и удобного теста запросов заходим на: http://localhost:8080/swagger-ui.html  (после запуска)


Docker

https://hub.docker.com/r/ksergey1999/santa

docker run -p 8080:8080 ksergey1999/santa
