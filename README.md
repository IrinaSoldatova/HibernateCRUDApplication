# Hibernate CRUD Application

Это Java-приложение демонстрирует базовое использование Hibernate и JPA для работы с реляционными базами данных, 
конкретно с MySQL. Приложение выполняет простые операции создания, 
чтения, обновления и удаления (CRUD) с сущностью `Person`.

## Функционал

Программа выполняет следующие функции:

1. Соединяется с базой данных MySQL с использованием Hibernate.
2. Создает таблицу `person` в базе данных, если она не существует.
3. Добавляет новые записи в таблицу `person`.
4. Показывает сгенерированные SQL-запросы в консоли для отслеживания действий Hibernate.

## Архитектура

В данной программе используется архитектура, основанная на следующем:

- **Hibernate**: ORM (Object-Relational Mapping), который упрощает работу с базами данных в Java.
- **JPA (Java Persistence API)**: спецификация управления постоянством в Java.
- **MySQL**: реляционная база данных, используемая для хранения данных.
- **Maven**: инструмент сборки для управления проектами Java и зависимостями.

## Классы:

### Person

- Поля:
    - `Long id`: Уникальный идентификатор, который будет автоматически сгенерирован базой данных.
    - `String name`: Имя человека.
    - `int age`: Возраст человека.

- Методы:
    - Конструкторы для создания новых экземпляров.
    - Геттеры и сеттеры для доступа к полям.
    - Метод toString() для вывода информации о человеке.

### Program

- Содержит метод main, который:
    - Настраивает Hibernate.
    - Создает объекты `Person`.
    - Сохраняет их в базе данных.

## Установка и настройка

### Требования

- Java Development Kit (JDK) 11 или выше
- MySQL Server
- Maven (для сборки проекта)

### Установка MySQL

1. Убедитесь, что MySQL Server установлен и запущен.
2. Создайте новую базу данных для этого приложения:

   ```sql
   CREATE DATABASE database;
   ```

### Настройка проекта

Добавьте следующие зависимости в ваш файл pom.xml:

    <dependencies>
    <!-- Hibernate Core -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>6.6.1.Final</version>
        </dependency>
    <!-- MySQL Connector/J -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.29</version>
        </dependency>
    </dependencies>

### Конфигурация Hibernate

Создайте файл конфигурации `hibernate.cfg.xml` в папке **src/main/resources** со следующим содержанием:

    <session-factory>
        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/database</property>
        <property name="hibernate.connection.username">username</property>
        <property name="hibernate.connection.password">password</property>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="hibernate.hbm2ddl.auto">update</property>
        <property name="hibernate.show_sql">true</property>
        <mapping class="example.Person"/>
    </session-factory>

## Примечания

- Этот проект является учебным и демонстрирует основы работы с Hibernate и MySQL.
- Можно расширить функционал приложения для поддержки дополнительных операций, таких как чтение, обновление и удаление данных.