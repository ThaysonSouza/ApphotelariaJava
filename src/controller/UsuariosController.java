package controller;
import dao.UsuariosDAO;
import model.Usuario;

public class UsuariosController {
    private final UsuariosDAO usuariosDao;

    /*construtor para inicializaçao do objeto
    Ao inicializa-lo, o contrutor de UsuariosDao() sera executado, o que significa que a camada de controle estara verificando
    se os parametros necessarios foram informados para que sejam enviados as requisicoes (package DAO)*/

    public UsuariosController() {
        this.usuariosDao = new UsuariosDAO();
    }

    /*Metodo para verificar se os parametros necessarios prara autenticaçao
    estao presentes, ou seja, nao podem ser nulos ou vazios
    */

    public boolean verificarCredencias(String email, String senha) {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            return false;}
        Usuario usuario = new Usuario("", email, senha, 0);
        return usuariosDao.autenticarUsuario(usuario);
    }

}
