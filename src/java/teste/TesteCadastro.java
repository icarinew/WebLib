package teste;

import javax.persistence.EntityManager;
import modelWebLib.Entidades.Texto;
import modelWebLib.Entidades.Usuario;
import modelWebLib.Hibernate.HibernateUtil;
import modelWebLib.UsuarioModel;

public class TesteCadastro {
//    public static void CadastrarLivro(EntityManager em) {
//        Livro l = new Livro();
//        File f = new File("C:\\PETERPAN.pdf");
//        UsuarioModel um = new UsuarioModel();
//        l.setAutor("J. M. Barrie");
//        l.setCategoria("Aventura");
//        l.setEdicao("1ª");
//        l.setIsbn("9781984094339");
//        l.setPdf(f);
//        l.setTitulo("Peter Pan");
//        l.setUsuario(um.buscarUsuario(2));
//        em.persist(l);
//    }

    public static void CadastroUsuario(EntityManager em) {
        Usuario u = new Usuario();
        u.setLogin("Joaninha");
        u.setSenha("5555");
        u.setNome("Joana");
        em.persist(u);
        
    } 
//    public static void CadastrarTexto(EntityManager em) {
//        Texto t = new Texto();
//        UsuarioModel um = new UsuarioModel();
//        t.setAutor("CaetanoVeloso");
//        t.setCategoria("Música");
//        t.setGenero("mpb");
//        t.setConteudo("Gosto muito de te ver, leãozinho\n" +
//                 "Caminhando sob o sol\n" +
//                 "Gosto muito de você, leãozinho\n" +
//                 "\n" +
//                 "Para desentristecer, leãozinho\n" +
//                 "O meu coração tão só\n" +
//                 "Basta eu encontrar você no caminho\n" +
//                 "\n" +
//                 "Um filhote de leão, raio da manhã\n"+
//                 "Arrastando o meu olhar como um ímã\n"+
//                 "O meu coração é o sol, pai de toda cor\n"+
//                 "Quando ele lhe doura a pele ao léu\n"+
//                 "\n"+
//                 "Gosto de te ver ao sol, leãozinho\n"+
//                 "De te ver entrar no mar\n"+
//                 "Tua pele, tua luz, tua juba\n"+
//                 "\n"+
//                 "Gosto de ficar ao sol, leãozinho\n"+
//                 "De molhar minha juba\n"+
//                 "De estar perto de você e entrar no mar");
//        t.setTitulo("O leãozinho");
//        t.setUsuario(um.buscarUsuario(4));
//        em.persist(t);
//        
//    }

    public static void main(String[] args) {
        EntityManager em = HibernateUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            CadastroUsuario(em);
            em.getTransaction().commit();
            System.out.println("Cadastrado com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();

            System.out.print("Erro." + e);
        } finally {
            em.close();

        }
    }

}
