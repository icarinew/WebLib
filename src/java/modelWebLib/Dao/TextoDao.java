package modelWebLib.Dao;
import java.util.List;
import modelWebLib.Entidades.Texto;


public interface TextoDao extends Dao<Texto> {
  
    public Texto buscarPorTitulo(String titulo);
    public List<Texto> buscarPorCategoria(String categoria);
    public List<Texto> buscarPorGenero(String genero);
    public List<Texto> buscarPorAutor(String autor);
    
}
