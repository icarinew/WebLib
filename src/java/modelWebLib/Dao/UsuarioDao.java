package modelWebLib.Dao;
import java.util.List;
import modelWebLib.Entidades.Usuario;

public interface UsuarioDao extends Dao<Usuario>{
    
    public List<Usuario> buscarPorNome(String nome);
    public Usuario buscarPorLogin(String login);
}
