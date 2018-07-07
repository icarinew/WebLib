package modelWebLib.Hibernate;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelWebLib.Dao.TextoDao;
import modelWebLib.Entidades.Texto;
import org.hibernate.HibernateException;

public class TextoHibernate implements TextoDao {

    private final EntityManager em = HibernateUtil.getEntityManager();

    @Override
    public void inserir(Texto texto) {
        try {
            em.getTransaction().begin();
            em.persist(texto);
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
    public void alterar(Texto texto) {
        try {
            em.getTransaction().begin();
            em.merge(texto);
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
    public void deletar(Texto texto) {
        try {
            em.getTransaction().begin();
            em.remove(texto);
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
    public Texto buscar(long id) {
        Texto texto = null;
        try {
            em.getTransaction().begin();
            TypedQuery qc = em.createQuery("from Texto where id = :id", Texto.class);
            qc.setParameter("id", id);
            texto = (Texto) qc.getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro" + e);
        } finally {
            em.close();
        }
        if (texto != null) {
            return texto;
        } else {
            return null;
        }

    }

    @Override
    public List<Texto> listarTodos() {
        List<Texto> textos = null;
        em.getTransaction().begin();
        TypedQuery<Texto> qc = em.createQuery("from Texto", Texto.class);
        textos = qc.getResultList();
        em.getTransaction().commit();
        if (textos != null) {
            return textos;
        } else {
            return null;
        }
    }

    @Override
    public Texto buscarPorTitulo(String titulo) {
        Texto texto = null;
        em.getTransaction().begin();
        TypedQuery qc = em.createQuery("from Texto where titulo like :%titulo%", Texto.class);
        qc.setParameter("%titulo%", titulo);
        texto = (Texto) qc.getSingleResult();
        em.getTransaction().commit();
        em.close();
        if (texto != null) {
            return texto;
        } else {
            return null;
        }
    }

    @Override
    public List<Texto> buscarPorGenero(String genero) {
        List<Texto> textos = null;
        em.getTransaction().begin();
        TypedQuery<Texto> qc = em.createQuery("from Texto where genero like :%genero%", Texto.class);
        qc.setParameter("%genero%", genero);
        textos = qc.getResultList();

        if (textos != null) {
            return textos;
        } else {
            return null;
        }
    }

    @Override
    public List<Texto> buscarPorCategoria(String categoria) {
        List<Texto> textos = null;
        em.getTransaction().begin();
        TypedQuery<Texto> qc = em.createQuery("from Texto where categoria like :%categoria%", Texto.class);
        qc.setParameter("%categoria%", categoria);
        textos = qc.getResultList();

        if (textos != null) {
            return textos;
        } else {
            return null;
        }
    }

    @Override
    public List<Texto> buscarPorAutor(String autor) {
        List<Texto> textos = null;
        em.getTransaction().begin();
        TypedQuery<Texto> qc = em.createQuery("from Texto where autor like :%autor%", Texto.class);
        qc.setParameter("%autor%", autor);
        textos = qc.getResultList();

        if (textos != null) {
            return textos;
        } else {
            return null;
        }
    }

}
