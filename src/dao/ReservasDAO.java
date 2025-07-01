package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReservasDAO {
    //Obejeto para instanciar claase Conexao para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirReserva() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoReserva = conndb.prepareStatement("INSERT INTO reservas " + "(id_adicional_fk, id_quarto_fk, id_pedido_fk ) VALUES (?, ?, ?);");
            //Setar os parametros
            novoReserva.setInt(1, 1);
            novoReserva.setInt(2, 1);
            novoReserva.setInt(3, 1);

            int linhaAfetada = novoReserva.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir Reserva" + erro);
            return false;
        }
    }

    public boolean alterarReserva() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarReserva = conndb.prepareStatement("UPDATE Reservas " +
                    "SET id_adicional_fk = ?, id_quarto_fk = ?, id_pedido_fk = ?"
                    + " WHERE id = ?;");

            alterarReserva.setInt(1, 3);
            alterarReserva.setInt(2, 3);
            alterarReserva.setInt(3, 1);
            alterarReserva.setInt(4, 1); //Alterar Usuario com ID = 1

            int linhaAfetada = alterarReserva.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar Reserva" + erro);
            return false;
        }
    }

    public boolean deleteReserva() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeReserva = conndb.prepareStatement
                    ("DELETE FROM reserva WHERE id = ?;");
            removeReserva.setInt(1, 1);
            int linhaAfetada = removeReserva.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar Reserva" + erro);
            return false;
        }
    }

    public void buscarReserva() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement pesquisaReserva = conndb.prepareStatement("SELECT id_adicional_fk, id_quarto_fk, id_pedido_fk" + " FROM reservas WHERE id = ?;");
            pesquisaReserva.setInt(1, 1);
            ResultSet result = pesquisaReserva.executeQuery();

            while (result.next()) {
                int id = result.getInt("id_adicional_fk");
                int quarto = result.getInt("id_quarto_fk");
                int pedido = result.getInt("id_pedido_fk");
                System.out.println("ID: " + id + " Quarto: " + quarto + " Pedido: " + pedido);
            }
            conndb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao buscar Reserva" + erro);
        }
    }
}
