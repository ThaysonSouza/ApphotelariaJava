package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientesDAO {
    //Obejeto para instanciar claase Conexao para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirCliente() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoCliente = conndb.prepareStatement("INSERT INTO clientes " + "(nome, email, cpf, telefone) VALUES (?, ?, ?, ?);");
            //Setar os parametros
            novoCliente.setString(1, "Thayson");
            novoCliente.setString(2, "thayson@gmail.com");
            novoCliente.setString(3, "12321.324.432");
            novoCliente.setString(4, "15 6668 4518");

            int linhaAfetada = novoCliente.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir Cliente" + erro);
            return false;
        }
    }

    public boolean alterarCliente() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarCliente = conndb.prepareStatement("UPDATE Clientes " +
                    "SET nome = ?, email = ?, cpf = ?, telefone =?"
                    + " WHERE id = ?;");

            alterarCliente.setString(1, "Thayson Souza");
            alterarCliente.setString(2, "thayson.ssousa@gmail.com");
            alterarCliente.setString(3, "400.289.22");
            alterarCliente.setString(4, "15 4002 8922");
            alterarCliente.setInt(5, 1);//Alterar Usuario com ID = 1

            int linhaAfetada = alterarCliente.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar Cliente" + erro);
            return false;
        }
    }

    public boolean deleteCliente() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeCliente = conndb.prepareStatement
                    ("DELETE FROM clientes WHERE id = ?;");
            removeCliente.setInt(1, 1);
            int linhaAfetada = removeCliente.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar Cliente" + erro);
            return false;
        }
    }

    public void buscarCliente() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement pesquisaCliente = conndb.prepareStatement("SELECT nome, email, cpf, telefone FROM clientes WHERE id = ?;");
            pesquisaCliente.setInt(1, 1);
            ResultSet result = pesquisaCliente.executeQuery();

            while (result.next()) {
                String nome = result.getString("nome");
                String email = result.getString("email");
                String cpf = result.getString("cpf");
                String telefone = result.getString("telefone");
                System.out.println("Nome: " + nome + " Email: " + email +  " CPF: " + cpf + " Telefone: " + telefone );
            }
            conndb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao buscar Cliente" + erro);
        }
    }
}

