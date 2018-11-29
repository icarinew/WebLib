
package controllerWebLib;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelWebLib.Entidades.Usuario;
import modelWebLib.UsuarioModel;

@ManagedBean
@SessionScoped

public class UsuarioController {
    Usuario u = new Usuario();
    UsuarioModel um = new UsuarioModel();
    List<Usuario> usuarios = new ArrayList<>();
    
     
    public void AdicionarUsuario(){
         FacesContext context = FacesContext.getCurrentInstance();
      	 try {
            um.cadastrarUsuario(u);
            context.addMessage(null, new FacesMessage("Usuário adicionado com sucesso!"));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage("Falha ao adicionar o usuário!"));
        }
   }
      
    public void DeletarUsuario() {
       //FacesContext context = FacesContext.getCurrentInstance();
      	 try {
           um.deletarUsuario(u);
           //context.addMessage(null, new FacesMessage("Usuário deletado com sucesso!"));
        } catch (Exception ex) {
            //context.addMessage(null, new FacesMessage("Falha ao excluir usuário!"));
        }
   }     
    
    public void AlterarUsuario() {
       FacesContext context = FacesContext.getCurrentInstance();
      	 try {
            um.alterarUsuario(u);
            context.addMessage(null, new FacesMessage("Usuário alterado com sucesso!"));
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage("Falha ao alterar usuário!"));
        }
   }
    
    public Usuario BuscarUsuario() {
       FacesContext context = FacesContext.getCurrentInstance();
      	 try {
           return um.buscarUsuario(u.getId_usuario());			
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage("Falha ao buscar usuário!"));
        }
         return null;
   }
   
     public List<Usuario> BuscarUsuarios() {
       FacesContext context = FacesContext.getCurrentInstance();
      	 try {
            return um.buscarUsuarios();	
        } catch (Exception ex){ 
            context.addMessage(null, new FacesMessage("Falha ao listar usuários!"));
        }
         return null;
   }
     

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public UsuarioModel getUm() {
        return um;
    }

    public void setUm(UsuarioModel um) {
        this.um = um;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
     
     
    
}
