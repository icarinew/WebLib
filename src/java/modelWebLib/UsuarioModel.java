package modelWebLib;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelWebLib.Dao.UsuarioDao;
import modelWebLib.Entidades.Usuario;
import modelWebLib.Hibernate.UsuarioHibernate;

public class UsuarioModel {
    
    private final UsuarioDao dao;
    
    public UsuarioModel(){
        this.dao = new UsuarioHibernate();
    }
    
    public void cadastrarUsuario(Usuario usuario) {
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            if(this.dao.buscarPorLogin(usuario.getUser()) == null) {
                if(usuario.getNome() != null && usuario.getSenha() != null && usuario.getUser() != null) {
                     dao.inserir(usuario);

                }
            } 
        } catch(Exception e) {
            context.addMessage(null, new FacesMessage("Falha ao cadastrar o usuário!"));
        }    
    }
    
    public void deletarUsuario(Usuario usuario) {
        dao.deletar(usuario);
    }
    
    public void alterarUsuario(Usuario usuario) {
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            if(this.dao.buscarPorLogin(usuario.getUser()) == null) {
                if(usuario.getNome() != null && usuario.getSenha() != null && usuario.getUser() != null) {
                     dao.alterar(usuario);

                }
            } 
        } catch(Exception e) {
            context.addMessage(null, new FacesMessage("Falha ao alterar o usuário!"));
        } 
    }
    
    public Usuario buscarUsuario(long id_usuario) {
        return this.dao.buscar(id_usuario);
    }
    
    public Usuario buscarPorLogin(String login){
        return this.dao.buscarPorLogin(login);
    }
    
    public List<Usuario> buscarUsuarios() {
        return this.dao.listarTodos() ;
    }
}
