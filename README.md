# Телефонная книга от [GeekBrains](https://gb.ru) и [@blckRbbit](https://github.com/blckRbbit)

Проект для практики по ООП на языке Java.
Изначальный проект можно посмотреть в источнике форка или [тут](https://github.com/blckRbbit/gb-notebook).

Изменения в проекте происходят на семинарах и при выполнении ДЗ.
Тут записаны только изменения при выполнении ДЗ.

<details><summary><h2>ДЗ №5</h2></summary>

1. Добавил сохранение данных в другом формате, для этого:
    - Добавил в класс UserMapper новое поле: separator, и изменил констукторы и методы для преобразования данных
    - Изменил класс DBConnector, заменил все статичексие методы на обычные, так как появилась необходимость сохранения
      данных в разных форматах и разных "БД". Добавил в него поле operation, и возможность создания экземпляров класса
      DBConnector при помощи уже существующих файловых операций. (впоследствии убрал)
    - Изменил конструкторы класса UserRepository
2. Добавил удаление данных из БД, для этого:
    - Реализовал в классе UserRepository соотв. метод из интерфейса
    - Добавил в класс UserView поведение при команде DELETE
3. Перенес в класс UserRepository и интерфейс GBRepository методы DAO (в метод write добавил поведение из метода saveAll,
   метод readAll для наглядности оставил как есть)

</details>