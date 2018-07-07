package teste;

import javax.persistence.EntityManager;
import modelWebLib.Entidades.Texto;
//import modelWebLib.Entidades.Livro;
//import modelWebLib.Entidades.Usuario;
import modelWebLib.Hibernate.HibernateUtil;
import modelWebLib.TextoModel;
//import modelWebLib.LivroModel;
//import modelWebLib.UsuarioModel;

public class TesteAtualizar {
//    public static void AtualizarLivro(EntityManager em){
//        LivroModel lm = new LivroModel();
//        Livro l;
//        l = lm.buscarLivro(6);
//        l.setAutor("ALTERADO");
//        em.merge(l);
//    }
//    public static void AtualizarUsuario(EntityManager em) {
//        UsuarioModel um = new UsuarioModel();
//        Usuario u;
//        u = um.buscarUsuario(5);
//        u.setNome("Maria Joana");
//        em.merge(u);
//    }
    
    public static void AtualizaTexto(EntityManager em) {
        TextoModel tm = new TextoModel();
        Texto t;
        t = tm.buscarTexto(3);
        t.setAutor("ALTERADO.");
        em.merge(t);
    }
    
    public static void main(String[] args) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            AtualizaTexto(em);
            em.getTransaction().commit();
            System.out.println("Atualizado com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.print("Erro." + e);
        } finally {
            em.close();

        }

       

    }

}
