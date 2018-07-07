package modelWebLib.Dao;
import java.util.List;

public interface Dao <E> {
    public void inserir(E e);
    public void alterar(E e);
    public E buscar(long id);
    public void deletar(E e);
    public List<E> listarTodos();
}
