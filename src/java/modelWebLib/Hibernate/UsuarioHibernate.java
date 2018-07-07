package modelWebLib.Hibernate;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelWebLib.Dao.UsuarioDao;
import modelWebLib.Entidades.Usuario;
import org.hibernate.HibernateException;

public class UsuarioHibernate implements UsuarioDao {

    private final EntityManager em = HibernateUtil.getEntityManager();

    @Override
    public void inserir(Usuario usuario) {
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (HibernateException he) {
            em.getTransaction().rollback();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void alterar(Usuario usuario) {
        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (HibernateException he) {
            em.getTransaction().rollback();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void deletar(Usuario usuario) {
        try {
            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();
        } catch (HibernateException he) {
            em.getTransaction().rollback();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    @Override
    public Usuario buscar(long id_usuario) {
        Usuario usuario = null;
            em.getTransaction().begin();
            TypedQuery qc = em.createQuery("from Usuario u where u.id_usuario = :id", Usuario.class);
            qc.setParameter("id", id_usuario);
            usuario = (Usuario) qc.getSingleResult();
        if(usuario != null){
            return usuario;
        }
        else{
            return null;
        }
    }
    
    @Override
    public List<Usuario> listarTodos() {
        List<Usuario> usuarios =  null;
        em.getTransaction().begin();
        TypedQuery<Usuario> qc = em.createQuery("from Usuario", Usuario.class);
        usuarios = qc.getResultList();
       
        if(usuarios != null){
            return usuarios;
        }
        else{
            return null;
        }
    }
    
    @Override
    public List<Usuario> buscarPorNome(String nome) {
        List<Usuario> usuarios =  null;
        em.getTransaction().begin();
        TypedQuery<Usuario> qc = em.createQuery("from Usuario u where u.nome like :%nome%", Usuario.class);
        qc.setParameter("%nome%", nome);
        usuarios = qc.getResultList();

        if(usuarios != null){
            return usuarios;
        }
        else{
            return null;
        }
    }

    @Override
    public Usuario buscarPorLogin(String user) {
        Usuario usuario =  null;
        em.getTransaction().begin();
        TypedQuery qc = em.createQuery("from Usuario u where u.user = :login", Usuario.class);
        qc.setParameter("login", user);
        usuario = (Usuario) qc.getSingleResult();
        System.out.println("modelWebLib.Hibernate.UsuarioHibernate.buscarPorLogin()");
        if(usuario != null){
            return usuario;
        }
        else{
            return null;
        }
    }

  

}
