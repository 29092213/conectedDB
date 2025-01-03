CRUD com Java Puro
Este projeto implementa um CRUD básico utilizando Java puro e JDBC para operações em um banco de dados relacional. A aplicação é composta por métodos para inserir, atualizar, listar, consultar e excluir registros na tabela usuariostb.

📋 Pré-requisitos
Antes de executar o projeto, certifique-se de que você tem os seguintes itens configurados:

Java 8 ou superior instalado.
Um banco de dados relacional (MySQL, PostgreSQL, etc.).
A biblioteca JDBC correspondente ao banco de dados utilizada no projeto.
Uma tabela chamada usuariostb com a seguinte estrutura (MySQL):
sql
Copiar código
CREATE TABLE usuariostb (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);
🚀 Como usar
Configuração Inicial
Clonar o repositório:

bash
Copiar código
git clone https://github.com/seuusuario/seu-repositorio.git
cd seu-repositorio
Configurar a conexão com o banco de dados: Certifique-se de passar a Connection adequada para os métodos fornecidos. Exemplo:

java
Copiar código
Connection connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/seubanco", 
    "usuario", 
    "senha"
);
Instanciar a classe de operações:

java
Copiar código
InserirValores inserirValores = new InserirValores();
Operações CRUD
1. Inserir um novo registro
Para adicionar um novo usuário, utilize o método InserirDados.

java
Copiar código
inserirValores.InserirDados(connection, "Fernando", "ie@gmail.com");
2. Atualizar dados de um usuário
Atualize o nome e/ou email de um usuário existente passando o ID, o novo nome e o novo email.

java
Copiar código
inserirValores.AttProfile(connection, 3, "Luiz", "luiz@gmail.com");
3. Listar todos os registros
Exiba todos os registros da tabela com o método ListarTable.

java
Copiar código
inserirValores.ListarTable(connection);
Saída esperada:

yaml
Copiar código
Table
ID: 1, Nome: Fernando, Email: ie@gmail.com
ID: 2, Nome: Luiz , Email: luiz@gmail.com
4. Consultar um registro específico
Para exibir apenas os dados de um único usuário, use o método SelectOne, passando o ID como parâmetro.

java
Copiar código
inserirValores.SelectOne(connection, 6);
Saída esperada:

yaml
Copiar código
ID: 6, Nome: Fernando, Email: ie@gmail.com
5. Excluir um registro
Remova um usuário da tabela pelo ID usando o método Excluir.

java
Copiar código
inserirValores.Excluir(connection, 6);
Saída esperada:

bash
Copiar código
Dados foram excluídos referentes ao cliente com id: 6
🛠 Estrutura do Código
A classe principal, InserirValores, contém os seguintes métodos:

InserirDados(Connection connection, String nome, String email)
Insere um novo registro na tabela.
AttProfile(Connection connection, int id, String nome, String email)
Atualiza o nome e o email de um usuário com base no ID.
ListarTable(Connection connection)
Lista todos os registros da tabela.
SelectOne(Connection connection, int idConsul)
Consulta os dados de um único registro.
Excluir(Connection connection, int idConsul)
Exclui um registro com base no ID.
🧪 Teste
Cada método pode ser executado individualmente, conforme mostrado nos exemplos acima. Certifique-se de ter dados suficientes na tabela para validar as operações.

🔒 Considerações de Segurança
Evite SQL Injection: Utilize PreparedStatement para todas as consultas que aceitam entradas dinâmicas. O método AttProfile já faz isso.
Evite manipular diretamente dados sensíveis: Nunca imprima diretamente informações confidenciais em produção.
📄 Licença
Este projeto está sob a licença MIT. Sinta-se à vontade para usá-lo e modificá-lo conforme necessário.
