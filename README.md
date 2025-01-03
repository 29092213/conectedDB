# CRUD com Java Puro 🖥️

Este projeto implementa um CRUD básico utilizando Java puro e JDBC para operações em um banco de dados relacional. Ele permite inserir, atualizar, listar, consultar e excluir registros na tabela `usuariostb`.

## 📋 Funcionalidades

- Inserir novos registros na tabela.
- Atualizar dados de um usuário existente.
- Listar todos os registros da tabela.
- Consultar um registro específico pelo ID.
- Excluir um registro pelo ID.

## 🚀 Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/seu-repositorio.git
   cd seu-repositorio`` 

- 2.  Configure a conexão com o banco de dados:
    
   ````
  java
  
    Connection connection = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/seubanco", 
        "usuario", 
        "senha"
    );```

- 3.  Instancie a classe principal:
    
    
  ````
  
    java
    
    InserirValores inserirValores = new InserirValores();
   
   ````


## Operações CRUD

### 1. Inserir um novo registro

- Adicione um novo usuário com o método `InserirDados`:

```
java

`inserirValores.InserirDados(connection, "Fernando", "ie@gmail.com");` 
```

----------

### 2. Atualizar dados de um usuário

- Atualize os dados de um usuário existente passando o ID, o novo nome e o novo email:

```
java

`inserirValores.AttProfile(connection, 3, "Luiz Henrique", "luiz@gmail.com");` 

```

----------

### 3. Listar todos os registros

- Liste todos os usuários cadastrados com o método `ListarTable`:

```
java

`inserirValores.ListarTable(connection);`
``` 

**Exemplo de saída:**

```
yaml

Table
ID: 1, Nome: Fernando, Email: ie@gmail.com
ID: 2, Nome: Luiz, Email: luiz@gmail.com 
```
----------

### 4. Consultar um registro específico

- Consulte os dados de um único usuário pelo ID com o método `SelectOne`:

```java

inserirValores.SelectOne(connection, 6); 
```

**Exemplo de saída:**

```
yaml

ID: 6, Nome: Fernando, Email: ie@gmail.com 
```
----------

### 5. Excluir um registro

- Remova um usuário pelo ID com o método `Excluir`:

```
java

inserirValores.Excluir(connection, 6);
```


**Exemplo de saída:**

```
bash

Dados foram excluídos referentes ao cliente com id: 6 
```
----------

## 📄 Estrutura do Banco de Dados

- Certifique-se de criar a tabela `usuariostb` antes de executar o projeto. Exemplo para MySQL:

```
sql

`CREATE TABLE usuariostb (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);
````

----------

## 🔒 Considerações de Segurança

-   **Evite SQL Injection:** Use `PreparedStatement` sempre que possível. Métodos como `AttProfile` já seguem essa prática.
-   **Não exponha dados sensíveis:** Evite exibir informações confidenciais ou mensagens de erro completas em ambientes de produção.

----------

## 📄 Licença

- Este projeto está licenciado sob a Licença MIT. Sinta-se à vontade para usá-lo e modificá-lo conforme necessário.
