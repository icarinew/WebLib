
package modelWebLib.Hibernate;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelWebLib.Dao.LivroDao;
import modelWebLib.Entidades.Livro;

import org.hibernate.HibernateException;

public class LivroHibernate implements LivroDao{
    
    private final EntityManager em = HibernateUtil.getEntityManager();
    
    @Override
    public void inserir(Livro livro) {
        try{
            em.getTransaction().begin();
            em.persist(livro);
            em.getTransaction().commit();
        }catch(HibernateException he) {
            em.getTransaction().rollback();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void alterar(Livro livro) {
        try{
            em.getTransaction().begin();
            em.merge(livro);
            em.getTransaction().commit();
        } catch(HibernateException he) {
            em.getTransaction().rollback();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    @Override
    public void deletar(Livro livro) {
          try{
            em.getTransaction().begin();
            em.remove(livro);
            em.getTransaction().commit();
        }catch(HibernateException he) {
            em.getTransaction().rollback();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public Livro buscar(long id) {
        Livro livro = null;
        TypedQuery qc = em.createQuery("from Livro where id = :id", Livro.class);
        qc.setParameter("id", id);
        livro = (Livro) qc.getSingleResult();

        if (livro != null) {
            return livro;
        } else {
            return null;
        }
    }
     
    @Override
    public List<Livro> listarTodos() {
         List<Livro> livros = null;
        TypedQuery<Livro> qc = em.createQuery("from Livro", Livro.class);
        livros = qc.getResultList();

        if (livros != null) {
            return livros;
        } else {
            return null;
        }
    }

     @Override
    public Livro buscarPorTitulo(String titulo) {
        Livro livro = null;
        em.getTransaction().begin();
        TypedQuery qc = em.createQuery("from Livro where titulo = :titulo", Livro.class);
        qc.setParameter("titulo", titulo);
        livro = (Livro) qc.getSingleResult();

        if (livro != null) {
            return livro;
        } else {
            return null;
        }
    }

    @Override
    public Livro buscarPorISBN(String isbn) {
        Livro livro = null;
        em.getTransaction().begin();
        TypedQuery qc = em.createQuery("from Livro where isnb = :isnb", Livro.class);
        qc.setParameter("isbn", isbn);
        livro = (Livro) qc.getSingleResult();

        if (livro != null) {
            return livro;
        } else {
            return null;
        }
    }
    
   

    @Override
    public List<Livro> buscarPorCategoria(String categoria) {
        List<Livro> livros = null;
        em.getTransaction().begin();
        TypedQuery<Livro> qc = em.createQuery("from Livro where categoria like :%categoria%", Livro.class);
        qc.setParameter("%categoria%", categoria);
        livros = qc.getResultList();

        if (livros != null) {
            return livros;
        } else {
            return null;
        }
    }

    @Override
    public List<Livro> buscarPorAutor(String autor) {
       List<Livro> livros = null;
        em.getTransaction().begin();
        TypedQuery<Livro> qc = em.createQuery("from Livro where autor like :%autor%", Livro.class);
        qc.setParameter("%autor%", autor);
        livros = qc.getResultList();

        if (livros != null) {
            return livros;
        } else {
            return null;
        }
    }

   
    

}

    

   

    

 

   
    

