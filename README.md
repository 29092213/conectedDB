CRUD com Java Puro 🖥️
Este projeto implementa um CRUD básico utilizando Java puro e JDBC para operações em um banco de dados relacional. A aplicação realiza operações como inserir, atualizar, listar, consultar e excluir registros na tabela usuariostb.

📋 Pré-requisitos
Antes de executar o projeto, certifique-se de que você possui:

Java 8 ou superior instalado.
Um banco de dados relacional (MySQL, PostgreSQL, etc.).
A biblioteca JDBC correspondente ao banco de dados usada no projeto.
Uma tabela chamada usuariostb com a seguinte estrutura (para MySQL):
sql
Copiar código
CREATE TABLE usuariostb (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

🚀 Como usar

1️⃣ Clonar o repositório
bash
Copiar código
git clone https://github.com/seuusuario/seu-repositorio.git
cd seu-repositorio
2️⃣ Configurar a conexão com o banco de dados
Certifique-se de configurar a conexão corretamente, passando as credenciais do banco:

java
Copiar código
Connection connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/seubanco", 
    "usuario", 
    "senha"
);
3️⃣ Instanciar a classe principal
java
Copiar código
InserirValores inserirValores = new InserirValores();
🛠️ Operações CRUD
1. Inserir um novo registro
Para adicionar um novo usuário, utilize o método InserirDados:

java
Copiar código
inserirValores.InserirDados(connection, "Fernando", "ie@gmail.com");
2. Atualizar dados de um usuário
Atualize os dados de um usuário existente passando o ID, o novo nome e o novo email:

java
Copiar código
inserirValores.AttProfile(connection, 3, "Luiz Henrique", "luiz@gmail.com");
3. Listar todos os registros
Liste todos os usuários cadastrados com o método ListarTable:

java
Copiar código
inserirValores.ListarTable(connection);
Exemplo de saída:

yaml
Copiar código
Table
ID: 1, Nome: Fernando, Email: ie@gmail.com
ID: 2, Nome: Luiz, Email: luiz@gmail.com
4. Consultar um registro específico
Consulte os dados de um único usuário pelo ID com o método SelectOne:

java
Copiar código
inserirValores.SelectOne(connection, 6);
Exemplo de saída:

yaml
Copiar código
ID: 6, Nome: Fernando, Email: ie@gmail.com
5. Excluir um registro
Exclua um usuário pelo ID com o método Excluir:

java
Copiar código
inserirValores.Excluir(connection, 6);
Exemplo de saída:

bash
Copiar código
Dados foram excluídos referentes ao cliente com id: 6
🧩 Estrutura do Código
A classe principal InserirValores contém os seguintes métodos:

Método	Descrição
InserirDados(Connection, String, String)	Insere um novo registro na tabela.
AttProfile(Connection, int, String, String)	Atualiza os dados de um usuário pelo ID.
ListarTable(Connection)	Lista todos os registros na tabela.
SelectOne(Connection, int)	Consulta os dados de um único registro pelo ID.
Excluir(Connection, int)	Exclui um registro pelo ID.
🔒 Considerações de Segurança
Evite SQL Injection: Sempre que possível, utilize PreparedStatement para entradas dinâmicas. O método AttProfile já segue essa prática.
Não exponha informações sensíveis: Evite exibir dados confidenciais ou mensagens de erro completas em ambientes de produção.
📄 Licença
Este projeto está licenciado sob a Licença MIT. Sinta-se à vontade para utilizá-lo e modificá-lo conforme necessário.
