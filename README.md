# kosmete
Webservice Restful para aplicação Kosmete

## Recomenações

Criar um container docker para o MongoDB:

```sh
$ docker pull mvertes/alpine-mongo
$ docker run -d --name mongo -p 27017:27017 mvertes/alpine-mongo
```

## Configuração
Caso seja necessário alterar alguma configuração de conexão com o MongoDB, edite o arquivo [src/main/resources/application.properties](./src/main/resources/application.properties).