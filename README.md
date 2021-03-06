# Autor

- João Paulo Santarém
- Email: jpstrm@gmail.com

# SLC

Serviço de Liquidação Centralizada

# Solução
A solução utilizada foi usar a biblioteca `jackson-dataformat-xml` para ler o arquivo em XML
utilizando o framework Spring boot. 
        
# Tecnologias usadas

* SpringBoot / JPA / Swagger / Jackson Dataformat Xml
* Junit 4 / PowerMock / Mockito
* MySQL

# Requisitos

- Certifique-se de primeiro ter instalado e configurado as tecnologias:
    - JDK 8
    - Maven

# Execução

## Pré-requisitos
- Trocar as variáveis do ambiente em src/main/resources/application.yml por configurações válidas
ou exportar as variáveis de ambiente para a máquina local

### Maven

- Executando no ambiente local 

```sh
mvn clean package spring-boot:run
```

- Buildar

```sh
mvn clean package
```

# Documentação

- Swagger
    - [local](http://localhost:8000/swagger-ui.html)
    - [heroku](https://slc-api.herokuapp.com/swagger-ui.html)
