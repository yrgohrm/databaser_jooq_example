# A simple JOOQ example

This is a super basic example to get started with JOOQ without the most
tedious parts of cut'n'paste coding.

## Running

First of all you need a database. This simple example has been tested
with MySQL 8 and get one up and running quickly with Docker.

`docker run --name jooq-ex-mysql -e MYSQL_ROOT_PASSWORD=secretP4ssword -d mysql:8`

Then you need to create the sample database with the sample data.

`docker exec -i jooq-ex-mysql mysql -psecretP4ssword < highscore.sql`

Finally you need to build the application and run it. To do this you need to
set up three environment variables. `DB_USERNAME`, `DB_PASSWORD` and `DB_HOST`.

The following will probably do it for cmd:
```
set DB_USERNAME=root
set DB_PASSWORD=secretP4ssword
set DB_HOST=localhost
```

Now run:
```
mvn package
mvn exec:java
```
