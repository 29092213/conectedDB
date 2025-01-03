package org.example;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class InserirValores {

    public void InserirDados(Connection connection, String nome, String email){
        String inserir = String.format("INSERT INTO usuariosTB (nome, email) VALUES ('%s', '%s');", nome, email);

        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(inserir);
            System.out.println("Usuario inserido com sucesso");
        }catch (SQLException e){
            System.err.println("Erro ao inserir dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void AttProfile(Connection connection, int id, String nome, String email){

        String sqlUpdateById = "UPDATE usuariostb SET nome = ? , email = ? WHERE id = ?;";

        try(PreparedStatement statement = connection.prepareStatement(sqlUpdateById)){
            statement.setString(1, nome);
            statement.setString(2, email);
            statement.setInt(3, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Dados atualizados com sucesso!");
            } else {
                System.out.println("Nenhum registro foi atualizado.");
            }
        }catch (SQLException e){
            System.err.println("Erro ao Atualizar dados: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void ListarTable(Connection connection){

        String sqlAllFrom = String.format("SELECT * FROM usuariostb;");

        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sqlAllFrom);
            System.out.println("Table");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                System.out.printf("ID: %d, Nome: %s, Email: %s%n", id, nome, email);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void SelectOne(Connection connection, int idConsul){


        String slqConsulOne = String.format("SELECT id, nome, email FROM usuariostb WHERE id = " + idConsul);

        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(slqConsulOne);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String nome  = resultSet.getString("nome");
                String email = resultSet.getString("email");
                System.out.printf("ID: %d, Nome: %s, Email: %s%n", id, nome, email);
            }
        }catch (Exception e){
            System.out.println(e);
        }


    }

    public void Excluir(Connection connection, int idConsul){

        String Deletar = String.format("DELETE FROM usuariostb WHERE id = " + idConsul);

        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(Deletar);
            System.out.println("Dados foram excluidos referentes ao cliente com id: " + idConsul);
        }catch (SQLException e){
                System.err.println("Erro ao excluir dados: " + e.getMessage());
                e.printStackTrace();
        }
    }

}
