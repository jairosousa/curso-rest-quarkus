# curso-rest-quarkus

## Lidando com extensões

De dentro de um projeto Quarkus, você pode obter uma lista das extensões disponíveis com:
```
./mvnw quarkus:list-extensions
```

Você pode habilitar uma extensão usando:
```
./mvnw quarkus:add-extension -Dextensions="hibernate-validator"
```

O Quarkus vem com um modo de desenvolvimento integrado. Execute seu aplicativo com:

``` 
./mvnw compile quarkus:dev
```

Comando para adicionar a extenção do Quarkus-Swagger
```
./mvnw quarkus:add-extension -Dextensions="quarkus-smallrye-openapi"
```

Empacotando a aplicação para produção

```
./mvnw clean package -DskipTests //Gera jar sem rodar os testes
```

```
java -jar .\target\quarkus-app\quarkus-run.jar
```

