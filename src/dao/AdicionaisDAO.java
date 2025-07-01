package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdicionaisDAO {
    //Obejeto para instanciar claase Conexao para requisitar acesso ao DB
    private Conexao conexao = new Conexao();


    public boolean inserirAdicionais() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoAdiocional = conndb.prepareStatement("INSERT INTO adicionais " + "(nome, preco) VALUES (?, ?);");
            //Setar os parametros
            novoAdiocional.setString(1, "sldfkds");
            novoAdiocional.setDouble(2, 20.99);

            int linhaAfetada = novoAdiocional.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir adiocional" + erro);
            return false;
        }
    }

    public boolean alterarAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarAdicionais = conndb.prepareStatement("UPDATE Adicionais " +
                    "SET nome = ?, preco = ? WHERE id = ?;");

            alterarAdicionais.setString(1, "Frigobar");
            alterarAdicionais.setDouble(2, 33.00);
            alterarAdicionais.setInt(3, 1);//Alterar Usuario com ID = 1

            int linhaAfetada = alterarAdicionais.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar Adicional" + erro);
            return false;
        }
    }

    public boolean deleteAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeAdicional = conndb.prepareStatement
                    ("DELETE FROM adicionais WHERE id = ?;");
            removeAdicional.setInt(1, 1);
            int linhaAfetada = removeAdicional.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar Adicional" + erro);
            return false;
        }
    }
    public void buscarAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement pesquisaAdicionais = conndb.prepareStatement("SELECT nome, preco FROM adicionais WHERE id = ?;");
            pesquisaAdicionais.setInt(1, 1);
            ResultSet result = pesquisaAdicionais.executeQuery();

            while (result.next()) {
                String nome = result.getString("nome");
                double preco = result.getDouble("preco");
                System.out.println("Nome: " + nome + "Preco: " + preco);
            }
            conndb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao buscar Adicional" + erro);
        }
    }
}
