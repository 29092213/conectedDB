package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectedOneDB {

        private static final String url = "jdbc:mysql://localhost:3306/teste";
        private static final String nameUser = "root";
        private static final String pass = "Senhateste";

        public static Connection getConnection(){
            try {
               return DriverManager.getConnection(url,nameUser, pass);
            }catch (Exception e){
                System.out.println("Falha na conexão");
                return null;
            }
        }
}
