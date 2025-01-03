package org.example;

import java.sql.Connection;


public class Main {
    public static void main(String[] args) {
        Connection connection = ConectedOneDB.getConnection();
        if (connection == null){
            System.out.println("Não encontramos o banco de dados");
        }

        InserirValores inserirValores = new InserirValores();

    }
}
