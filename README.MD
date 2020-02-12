## Acessando a aplicação na Web

#### Acessando a documentação da funcionalidade.


```javascript
https://numeros-por-extenso.herokuapp.com/swagger-ui.html#/
```

## Acessando a aplicação localmente com Docker, execute o comando: 

```javascript
docker run -t -p 8000:8080 --name dockerize yurekesley/numeros-por-extenso
```

#### Acessando a documentação da funcionalidade.

```javascript
http://localhost:8000/swagger-ui.html
```

#### Obs: verificar o contexto do docker da sua máquina e substituir caso necessario.


#### Exemplo :
```javascript
http://seu-ip:8000/swagger-ui.html
```


