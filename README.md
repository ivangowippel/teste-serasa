# Teste técnico da empresa Serasa

Neste documento é descrito o setup para execução do backend, desenvolvido em Java + Spring Boot.

Para a explicação da arquitetura da solução, consulte o arquivo [SOLUCAO.md](SOLUCAO.md)

## Pré Requisitos

* [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) instalado e configurado;
* Banco de Dados [MYSQL](https://dev.mysql.com/downloads/installer/) rodando.

## Setup

* Para fazer o backend rodar de forma correta, é necessário primeiramente criar um schema no MYSQL com o nome 'teste_serasa';

* Após criado o banco de dados, deve-se verificar se os seguintes parâmetros estão corretos no arquivo [application.properties](src/main/resources/application.properties).

```
spring.datasource.url=jdbc:mysql://localhost:3306/<NOME_SCHEMA_AQUI>?serverTimezone=UTC
spring.datasource.username=<USUARIO_DO_BANCO>
spring.datasource.password=<SENHA_DO_BANCO>
```

## Execução

Após efetuar o setup, é possível executar o backend através do comando abaixo no terminal:

```
.\mvnw spring-boot:run
```

Com isso, o backend estará no ar disponível na url: [http://localhost:8080/](http://localhost:8080/)

Quando o backend sobe, o Spring Data JPA cria todas as tabelas e colunas no banco de dados.
Com as tabelas criadas devem ser executados os comandos abaixo:

```
insert into empresa(nome, reputacao) values ('Empresa 1', 50);
insert into empresa(nome, reputacao) values ('Empresa 2', 50);
insert into empresa(nome, reputacao) values ('Empresa 3', 50);
```