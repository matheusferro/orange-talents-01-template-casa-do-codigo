# Casa do código - API

## Descrição
API destinada a criação de Autor, Categoria, Pais, Estado, Livro e Compra de livro.

## Setup
```
> git clone https://github.com/matheusferro/orange-talents-01-template-casa-do-codigo.git
> mvn dependency:resolve dependency:resolve-plugins
> mvn clean package
> java -jar .\target\casaDoCodigoApp-1.jar
```

## Restrições
- Não utilizar bibliotecas que geram código. (EX: Lombok, Model mapper, Map Struct ...)
- Somente dois setters, por classe dominante.
- Não utilizar classes services.        

## Endpoints
### Autor
- Cadastro ```AUTOR```:
```
curl localhost:8080/autor -i -XPOST \
-H 'Content-Type: application/json' \
-d '{"nome":"Nome do Autor",email":"autor@gmail.com", "descricao":"desc"}' 
```

Resultado:
```
HTTP/1.1 200
Content-Type: text/plain;charset=UTF-8
Content-Length: 107
Date: 30 Feb 3099 06:42:12 GMT

Autor{id=2, nome='nome', email='autor@gmail.com', descricao='desc', instante=3099-03-30T06:42:12.825583200}
```
### Categoria
- Cadastro ```CATEGORIA```:
```
curl localhost:8080/categoria -i -XPOST \
-H 'Content-Type: application/json' \
-d '{"nome":"Nome da Categoria"}'
```

Resultado:
```
HTTP/1.1 200
Content-Type: text/plain;charset=UTF-8
Content-Length: 41
Date: 30 Feb 3099 06:42:12 GMT

Categoria{id=1, nome='Nome da Categoria'}
```

### Livro
- Cadastro ```LIVRO```:
```
curl localhost:8080/livro -i -XPOST \
-H 'Content-Type: application/json' \
-d '{"titulo":"Livro teste","resumo":"resumo do livro...","sumario":"sumario","preco":20,"numPaginas":100,"isbn": "85-359-027732-5","dataPublicacao":"20/10/2023","idCategoria":1,"idAutor":1}'
```

Resultado:
```
HTTP/1.1 200
Content-Type: text/plain;charset=UTF-8
Content-Length: 199
Date: 30 Feb 3099 06:42:12 GMT

Livro{id=1, titulo='Livro teste', resumo='resumo do livro...', sumario='sumario', preco=20, numPaginas=100, isbn='85-359-027732-5', dataPublicacao=2023-10-20, categoria=Nome da Categoria, autor=nome}
```

-Exibir lista de ```LIVROS```:
```
curl localhost:8080/livro -i -X GET \
-H 'Content-Type: application/json'
```

Resultado:
```
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: 30 Feb 3099 06:42:12 GMT

{"content":[{"id":1,"titulo":"Livro teste"}],
"pageable":{"sort":{"sorted":true,"unsorted":false,"empty":false},
"offset":0,"pageNumber":0,"pageSize":10,"unpaged":false,"paged":true},
"last":true,"totalElements":1,"totalPages":1,"size":10,"number":0,"sort":
{"sorted":true,"unsorted":false,"empty":false},"first":true,"numberOfElements":1,"empty":false}
```


-Exibir detalhes de ```LIVRO```:
```
curl localhost:8080/livro/1 -i -X GET \
-H 'Content-Type: application/json'
```

Resultado:
```
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: 30 Feb 3099 06:42:12 GMT

{"titulo":"Livro teste","resumo":"resumo do livro...","sumario":"sumario","preco":20.00,"numPaginas":100,"isbn":"85-359-027732-5","dataPublicacao":"20/10/2023","autor":{"nome":"nome","descricao":"desc"}}
```

### Pais

-Cadastro ```PAIS```:
```
curl localhost:8080/pais -i -XPOST \
-H 'Content-Type: application/json' \
-d '{"nome":"Brasil"}'
```

Resultado:
```
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked

{"pais":"Brasil"}
```

### Estado

-Cadastro ```ESTADO```:
```
curl localhost:8080/estado -i -XPOST \
-H 'Content-Type: application/json' \
-d '{"nome":"São Paulo", "idPais":1}'
```

Resultado:
```
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: 30 Feb 3099 06:42:12 GMT

{"estado":"São Paulo2","pais":"Brasil"}
```

### Compra parcial

-Realizar compra parcial:
```
curl localhost:8080/compra -i -XPOST \
-H 'Content-Type: application/json' \
-d '{"nome":"nome","sobrenome":"sobrenome","email":"teste@email.com","documento":"742.422.483-26","endereco":"Rua exemplo","complemento":"Casa 9","cidade":"cidade","idPais":1,"idEstado":1,"telefone":"(011)999999999","cep":"0000-000"}'
```

Resultado:
```
HTTP/1.1 200
Content-Type: application/json
Transfer-Encoding: chunked
Date: 30 Feb 3099 06:42:12 GMT

{"nome":"nome","sobrenome":"sobrenome","email":"teste@email.com","documento":"742.422.483-26","endereco":"Rua exemplo","complemento":"Casa 9","cidade":"cidade","idPais":1,"idEstado":1,"telefone":"(011)999999999","cep":"0000-000"}
```

