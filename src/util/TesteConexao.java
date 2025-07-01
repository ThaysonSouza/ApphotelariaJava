package util;

import controller.UsuariosController;
import model.Usuario;
import dao.*;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();

        UsuariosController usuariosController = new UsuariosController();
        //Novo objeto criado(nova instancia da classe model.Usuarios )
//        Usuario usuario = new Usuario("Pamella", "pamella@gmail.com", "123", 1);
//      class   objeto        construtor
        Connection condb = conexao.conectar();
        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {
                //INSERT DE TODAS AS TABELAS
//                UsuariosDAO usuariosDAO = new UsuariosDAO();
//                usuariosDAO.inserirUsuario();
//                System.out.println("Usuario Inserido com sucesso!");
//
//                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
//                adicionaisDAO.inserirAdicionais();
//                System.out.println("Adicional Inserido com sucesso!");
//
//                ClientesDAO clientesDAO = new ClientesDAO();
//                clientesDAO.inserirCliente();
//                System.out.println("Cliente Inserido com sucesso!");
//
//                PedidosDAO pedidosDAO = new PedidosDAO();
//                pedidosDAO.inserirPedido();
//                System.out.println("Pedido Inserido com sucesso!");
//
//                QuartosDAO quartosDAO = new QuartosDAO();
//                quartosDAO.inserirQuarto();
//                System.out.println("Adicional Inserido com sucesso!");
//
//                RolesDAO rolesDAO = new RolesDAO();
//                rolesDAO.inserirRole();
//                System.out.println("role Inserido com sucesso!");
//
                 //DELETE DE TODAS AS TABELAS
//                UsuariosDAO usuariosDAO = new UsuariosDAO();
//                usuariosDAO.deleteUsuario();
//                System.out.println("Usuario deletado com sucesso!");
//
//                PedidosDAO pedidosDAO = new PedidosDAO();
//                pedidosDAO.deletePedido();
//                System.out.println("Pedido deletado com sucesso!");
//
//                QuartosDAO QuartoDAO = new QuartosDAO();
//                QuartoDAO.deleteQuarto();
//                System.out.println("Quarto deletado com sucesso!");
//
//                ReservasDAO reservasDAO = new ReservasDAO();
//                reservasDAO.deleteReserva();
//                System.out.println("Reserva deletado com sucesso!");
//
//                ClientesDAO clientesDAO = new ClientesDAO();
//                clientesDAO.deleteCliente();
//                System.out.println("Delete deletado com sucesso!");
//
//                RolesDAO rolesDAO = new RolesDAO();
//                rolesDAO.deleteRole();
//                System.out.println("Role deletado com sucesso!");

//                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
//                adicionaisDAO.deleteAdicionais();
//                System.out.println("Adicionais deletado com sucesso!");

//                ClientesDAO clientesDAO = new ClientesDAO();
//                clientesDAO.alterarCliente();
//                System.out.println("Cliente alterado com sucesso!");
//
//                QuartosDAO quartosDAO = new QuartosDAO();
//                quartosDAO.alterarQuarto();
//                System.out.println("Quarto alterado com sucesso!");
//
//                ReservasDAO reservasDAO = new ReservasDAO();
//                reservasDAO.alterarReserva();
//                System.out.println("Reserva alterado com sucesso!");
//
//                UsuariosDAO usuariosDAO = new UsuariosDAO();
//                usuariosDAO.alterarUsuario();
//                System.out.println("Usuario alterado com sucesso!");
//
//                PedidosDAO pedidosDAO = new PedidosDAO();
//                pedidosDAO.alterarPedido();
//                System.out.println("Pedido alterado com sucesso!");
//
//                RolesDAO rolesDAO = new RolesDAO();
//                rolesDAO.alterarRole();
//                System.out.println("Role alterado com sucesso!");
//
//                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
//                adicionaisDAO.alterarAdicionais();
//                System.out.println("Adicionais alterado com sucesso!");

                //COMANDOS SELECT
//                UsuariosDAO usuariosDAO = new UsuariosDAO();
//                usuariosDAO.autenticarUsuario(usuario);// objeto passasdo como parametro para autenticaçao
//                System.out.println("Usuario autenticado com sucesso!");

//                QuartosDAO quartosDAO = new QuartosDAO();
//                quartosDAO.buscarQuarto();
//                System.out.println("Quarto encontrado com sucesso!");

//                ClientesDAO clientesDAO = new ClientesDAO();
//                clientesDAO.buscarCliente();
//                System.out.println("Cliente encontrados com sucesso!");

                //Testando a autenticaçao de um usuario
                usuariosController.verificarCredencias("pamella@gmail.com", "123");

                condb.close();
                System.out.println("Conexão encerrada");
            } catch (Exception erro) {
                System.out.println("Erro ao encerrar a conexão:" + erro.getMessage());
            }
        }

        else {
                System.out.println("Falha ao conectar ao banco de dados!");
        }
    }
}
