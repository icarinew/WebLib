package controllerWebLib;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelWebLib.Entidades.Usuario;
import modelWebLib.UsuarioModel;

@ManagedBean
@SessionScoped
public class LoginController  {

    private UsuarioModel um = new UsuarioModel();
    private Usuario usuarioLogado = new Usuario();
    private Usuario usuario = new Usuario();;
    private String  senha;
    private String  confirmaSenha;
    private String  user;
    private String nome;
    
   public LoginController(){
      this.user= "";
      this.senha = "";
    }
    
    public String getUser() {
        return user;
    }

    
    public void setUser(String user) {
        this.user = user;
    }

    
    public String getSenha() {
        return senha;
    }

    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsuarioModel getUm() {
        return um;
    }

    public void setUm(UsuarioModel um) {
        this.um = um;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }
    
    
    
    public void logIn() {
        
        FacesContext context = FacesContext.getCurrentInstance();
        usuario = um.buscarPorLogin(this.user);
        if(this.usuario.getUser().equals(user) && this.usuario.getSenha().equals(senha)) {
            context.getExternalContext().getSessionMap().put("user", usuario.getId_usuario());
            context.getExternalContext().getSessionMap().put("perfil", "usuario");
            try{
                usuarioLogado = usuario;
                context.getExternalContext().redirect("paginaInicial.xhtml");
              
            } catch(IOException e){
                context.addMessage(null, new FacesMessage("A autenticaçao falhou."));
            }
        } else {
            context.addMessage(null, new FacesMessage("A autenticaçao falhou."));
        }
    }
    public void logOut(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        
        try{
            context.getExternalContext().redirect("index.xhtml");
        }catch(IOException e){
            context.addMessage(null, new FacesMessage("Falha no logout"));
        }
    }    
    public void validacaoLogin(){
        FacesContext context = FacesContext.getCurrentInstance();
        Usuario u =  um.buscarPorLogin(this.usuario.getUser());
        if(u.getUser() != null) {
            context.addMessage(null, new FacesMessage("Este usuário já existe no banco de dados."));
        } else {
            if(this.senha.equals(this.confirmaSenha)){
                context.addMessage(null, new FacesMessage("Senha e Confirmação de senha possuem valores diferentes."));
            } else {
                u.setNome(this.nome);
                u.setLogin(this.user);
                u.setSenha(this.senha);
                um.cadastrarUsuario(u);
             
            }           
        }    
    }
   
   
} 