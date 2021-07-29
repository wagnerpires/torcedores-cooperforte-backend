# Cadastro de Torcedores - COOPERFORTE 2021

## Para executar o projeto

### mvn clean install -DskipTests=true
### cd target
### javar -jar cooperforte-service-0.0.1-SNAPSHOT.jar

Acessar a url [http://localhost:3000](http://localhost:3000) para navegar

### Para acesso ao sistema:

    usuário: admin 
	senha: 123456 - Administrador (todas as operações CRUD permitidas)
	
	usuário: cooper - Visualização (listar torcedores)
	senha: 123456

### Para acesso ao banco de dados:

    http://localhost:8080/h2-console/
    JDBC url: jdbc:h2:mem:testdb
    user: sa
    password: (em branco)

### FRONTEND

github: https://github.com/wagnerpires/torcedores-cooperforte-frontend

### Principais tecnologias utilizadas no desenvolvimento:

* Apache Maven
* Java 11
* React
* Formik para gerenciar formulários
* Docker
* H2 Database
* Maven
* Ecossistema Spring
* Material ui (Ui Framework)
* Via Cep (API)
* JUnit 5
* Apache Kafka (mock)
