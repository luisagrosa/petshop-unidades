package br.com.tt.petshop.unidades;

import java.sql.*;

public class Conexao {

    private Connection connection;

    public void conectar(String url, String usuario,
                         String senha) throws SQLException {
        this.connection = DriverManager
                .getConnection(url, usuario, senha);
        System.out.printf("É somente leitura? %s\n",
                connection.isReadOnly());
    }

    public void inserir(String sql) throws SQLException {
        Statement statement = this.connection.createStatement();
        statement.execute(sql);
        statement.close();
    }

    public ResultSet consultar(String sql) throws SQLException {
        Statement statement = this.connection.createStatement();
        //"select v.id, v.nome, a.nome from vacina v, animal a where v.id_animal = a.id "
        return statement.executeQuery(sql);
    }

    public void desconectar() throws SQLException {
        connection.close();
    }
}
