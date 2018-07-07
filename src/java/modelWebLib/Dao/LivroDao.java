package modelWebLib.Dao;
import java.util.List;
import modelWebLib.Entidades.Livro;


public interface LivroDao extends Dao<Livro>{
   
    public Livro buscarPorTitulo(String titulo);
    public Livro buscarPorISBN(String isbn);
    public List<Livro> buscarPorCategoria(String categoria);
    public List<Livro> buscarPorAutor(String autor);
    
    
}
