package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuartosDAO {
    //Obejeto para instanciar claase Conexao para requisitar acesso ao DB
    private Conexao conexao = new Conexao();


    public boolean inserirQuarto() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoQuarto = conndb.prepareStatement("INSERT INTO quartos "
                    + "(nome, numero, camaSolteiro, camaCasal, disponivel, preco) VALUES (?, ?, ? , ?, ?, ? );");
            //Setar os parametros
            novoQuarto.setString(1, "Quarto familia");
            novoQuarto.setString(2, "777");
            novoQuarto.setInt(3, 2);
            novoQuarto.setInt(4, 2);
            novoQuarto.setBoolean(5, true);
            novoQuarto.setDouble(6, 8.00);

            int linhaAfetada = novoQuarto.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir Quarto" + erro);
            return false;
        }
    }

    public boolean alterarQuarto() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarQuarto = conndb.prepareStatement("UPDATE Quartos " +
                    "SET nome = ?, numero = ?, camaSolteiro = ?, camaCasal = ?, disponivel = ?, preco = ?"
                    + " WHERE id = ?;");

            alterarQuarto.setString(1, "Quarto family");
            alterarQuarto.setString(2, "333");
            alterarQuarto.setInt(3, 3);
            alterarQuarto.setInt(4, 3);
            alterarQuarto.setBoolean(5, true);
            alterarQuarto.setDouble(6, 80.00);
            alterarQuarto.setInt(7, 1); //Alterar Usuario com ID = 1

            int linhaAfetada = alterarQuarto.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar Quarto" + erro);
            return false;
        }
    }

    public boolean deleteQuarto() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeQuarto = conndb.prepareStatement
                    ("DELETE FROM reserva WHERE id = ?;");
            removeQuarto.setInt(1, 1);
            int linhaAfetada = removeQuarto.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar Quarto" + erro);
            return false;
        }
    }

    public void buscarQuarto() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement pesquisaQuarto = conndb.prepareStatement("SELECT nome, numero, camaSolteiro, camaCasal, disponivel, preco"
                    + " FROM quartos WHERE id = ?;");
            pesquisaQuarto.setInt(1, 1);
            ResultSet result = pesquisaQuarto.executeQuery();

            while (result.next()) {
                String nome = result.getString("nome");
                String numero = result.getString("numero");
                int camaSolteiro = result.getInt("camaSolteiro");
                int camaCasal = result.getInt("camaCasal");
                boolean disponivel = result.getBoolean("disponivel");
                double preco = result.getDouble("preco");
                System.out.println("Nome: " + nome + " Numero: " + numero + " CamaSolteiro: " + camaSolteiro + " CamaCasal: " + camaCasal + " Disponivel: " + disponivel + " Preco: " + preco);
            }
            conndb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao buscar quarto" + erro);
        }
    }
}
