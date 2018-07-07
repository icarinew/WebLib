package teste;

//import modelWebLib.Entidades.Usuario;

import modelWebLib.Entidades.Texto;
import modelWebLib.Hibernate.TextoHibernate;

//import modelWebLib.Hibernate.UsuarioHibernate;


//import modelWebLib.Entidades.Livro;
//import modelWebLib.Hibernate.LivroHibernate;

public class TesteConsulta {

    public static void main(String[] args) {
//        LivroHibernate lh = new LivroHibernate();
//        Livro l;
//        l = lh.buscar(7);
//        System.out.println(l.toString());

//        UsuarioHibernate uh = new UsuarioHibernate();
//        Usuario u;
//        u = uh.buscar(5);
//        System.out.println(u.toString());

          TextoHibernate th = new TextoHibernate();
          Texto t;
          t = th.buscar(3);
          System.out.println(t.toString());
          
            


          
    }

}
