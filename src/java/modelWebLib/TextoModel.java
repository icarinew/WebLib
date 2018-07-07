
package modelWebLib;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelWebLib.Dao.TextoDao;
import modelWebLib.Entidades.Texto;
import modelWebLib.Hibernate.TextoHibernate;

public class TextoModel {
   
    private TextoDao dao;
    
    public TextoModel(){
        this.dao = new TextoHibernate();
    }
    
     public void cadastrarTexto(Texto texto) {
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            if(texto.getTitulo() != null && texto.getAutor() != null && texto.getCategoria() != null && texto.getConteudo() != null
                 && texto.getGenero() != null) {
                  dao.inserir(texto);
            }      
        } catch(Exception e) {
                  context.addMessage(null, new FacesMessage("Falha ao cadastrar o texto!"));  
        }
         
             
     }
    public void deletarTexto(Texto texto) {
            dao.deletar(texto);  
    }
    
    public void alterarTexto(Texto texto) {
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            if(texto.getTitulo() != null && texto.getAutor() != null && texto.getCategoria() != null && texto.getConteudo() != null
                     && texto.getGenero() != null) {
                      dao.alterar(texto);
            }          
        } catch(Exception e) {
                context.addMessage(null, new FacesMessage("Falha ao alterar texto!")); 
        }          
    }
        
    public Texto buscarTexto(long id) {
         return this.dao.buscar(id); 
    }
    public List<Texto> buscarTextos() {
        return this.dao.listarTodos();
    }
   
}
