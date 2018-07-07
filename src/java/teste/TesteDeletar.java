package teste;

import javax.persistence.EntityManager;
import modelWebLib.Entidades.Texto;
import modelWebLib.Entidades.Usuario;
//import modelWebLib.Entidades.Livro;
//import modelWebLib.LivroModel;
import modelWebLib.Hibernate.HibernateUtil;
import modelWebLib.TextoModel;
import modelWebLib.UsuarioModel;

public class TesteDeletar {

//    public static void DeletarLivro(EntityManager em) {
//        Livro l;
//        LivroModel lm = new LivroModel();
//        l = lm.buscarLivro(7);
//        l = em.find(Livro.class, l.getId());
//        em.remove(l);
//    }
    
//    public static void DeletarUsuario(EntityManager em){
//        Usuario u;
//        UsuarioModel um = new UsuarioModel();
//        u = um.buscarUsuario(5);
//        u = em.find(Usuario.class, u.getId_usuario());
//        em.remove(u);
//    }
    
    public static void DeletarTexto(EntityManager em) {
        Texto t;
        TextoModel tm = new TextoModel();
        t = tm.buscarTexto(3);
        t = em.find(Texto.class, t.getId());
        em.remove(t);
        
    }



    public static void main(String[] args) {
      EntityManager em = HibernateUtil.getEntityManager();
      
      try{
          em.getTransaction().begin();
          DeletarTexto(em);
          em.getTransaction().commit();
          System.out.println("Deletado com sucesso.");
        } catch (Exception e) {
            em.getTransaction().rollback();

            System.out.print("Erro." + e);
        }  finally {
            em.close();

        }

    }
}
