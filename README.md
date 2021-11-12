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