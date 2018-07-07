
package modelWebLib;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelWebLib.Dao.LivroDao;
import modelWebLib.Entidades.Livro;
import modelWebLib.Hibernate.LivroHibernate;

public class LivroModel {
    
    private LivroDao dao;
    
    public LivroModel(){
        this.dao = new LivroHibernate();
    }
    
    public void cadastrarLivro(Livro livro) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if(livro.getAutor() != null && livro.getCategoria() != null && livro.getEdicao() != null && 
                    livro.getIsbn() != null && livro.getPdf() != null && livro.getTitulo() != null){
                        dao.inserir(livro);
            } 
        } catch(Exception e) {
            context.addMessage(null, new FacesMessage("Falha ao cadastrar o livro!")); 
        }    
    }
    public void deletarLivro(Livro livro) {
        dao.deletar(livro);
    }
    public void alterarLivro(Livro livro) {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if(livro.getAutor() != null && livro.getCategoria() != null && livro.getEdicao() != null && 
                    livro.getIsbn() != null && livro.getPdf() != null && livro.getTitulo() != null){
                        dao.alterar(livro);
            } 
        } catch(Exception e) {
            context.addMessage(null, new FacesMessage("Falha ao alterar o livro!")); 
        }
    }
    public Livro buscarLivro(long id) {
        return this.dao.buscar(id);
    }
    public List<Livro> buscarLivros() {
        return this.dao.listarTodos() ;
    }
       
        
}
