package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidosDAO {
    //Obejeto para instanciar claase Conexao para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirPedido() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoPedido = conndb.prepareStatement("INSERT INTO pedidos " + "(id_usuario_fk, id_cliente_fk, pagamento) VALUES (?, ?, ?);");
            //Setar os parametros
            novoPedido.setInt(1, 2);
            novoPedido.setInt(2, 1);
            novoPedido.setString(3, "Pix");

            int linhaAfetada = novoPedido.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir Pedido" + erro);
            return false;
        }
    }

    public boolean alterarPedido() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarPedido = conndb.prepareStatement("UPDATE Pedidos " +
                    "SET nome = ?, email = ?, cpf = ?, telefone =?"
                    + " WHERE id = ?;");

            alterarPedido.setString(1, "Thayson Souza");
            alterarPedido.setString(2, "thayson.ssousa@gmail.com");
            alterarPedido.setString(3, "400.289.22");
            alterarPedido.setString(4, "15 4002 8922");
            alterarPedido.setInt(5, 1);//Alterar Usuario com ID = 1

            int linhaAfetada = alterarPedido.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar Pedido" + erro);
            return false;
        }
    }

    public boolean deletePedido() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removePedido = conndb.prepareStatement
                    ("DELETE FROM pedidos WHERE id = ?;");
            removePedido.setInt(1, 1);
            int linhaAfetada = removePedido.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;

        } catch (Exception erro) {
            System.out.println("Erro ao deletar Pedido" + erro);
            return false;
        }
    }

    public void buscarPedido() {

        try {
            Connection conndb = conexao.conectar();
            PreparedStatement pesquisaPedido = conndb.prepareStatement("SELECT id_usuario_fk, id_cliente_fk, pagamento FROM usuarios WHERE id = ?;");
            pesquisaPedido.setInt(1, 2);
            ResultSet result = pesquisaPedido.executeQuery();

            while (result.next()) {
                int id_usuario_fk = result.getInt("id_usuario_fk");
                int id_cliente_fk = result.getInt("id_cliente_fk");
                String pagamento = result.getString("pagamento");

                System.out.println("id_usuario_Fk: " + id_usuario_fk + " id_cliente_fk: " + id_cliente_fk + " Pagamento:" + pagamento);
            }
            conndb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao buscar Pedido" + erro);
        }
    }
}
