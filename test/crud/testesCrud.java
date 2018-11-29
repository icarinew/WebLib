package crud;

import controllerWebLib.LivroController;
import controllerWebLib.TextoController;
import controllerWebLib.UsuarioController;
import modelWebLib.Entidades.Livro;
import modelWebLib.Entidades.Texto;
import modelWebLib.Entidades.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/*
 * @author asaph
 */
public class testesCrud {
    
    public testesCrud() {
    }
    
    @Test
    public void testeBuscarUsuario (Usuario user) {
        UsuarioController uc = new UsuarioController();
        uc.setU(user);
        assertEquals(user.getId_usuario(), uc.BuscarUsuario().getId_usuario());
    }
    
    @Test
    public void testeBuscarLivro (Livro book) {
        LivroController lc = new LivroController();
        lc.setLivro(book);
        assertEquals(book.getId(), lc.BuscarLivro().getId());
    }
    
    @Test 
    public void testeBuscarTexto (Texto text) {
        TextoController tc = new TextoController();
        tc.setTexto(text);
        assertEquals(text.getId(), tc.BuscarTexto().getId());
    }
    
    @Test 
    public void listarTodosUsuarios () {
        UsuarioController uc = new UsuarioController();
        assertNotNull(uc.BuscarUsuarios());
    }
    
    @Test 
    public void listarTodosLivros () {
        LivroController lc = new LivroController();
        assertNotNull(lc.BuscarLivros());
    }
    
    @Test 
    public void listarTodosTextos () {
        TextoController tc = new TextoController();
        assertNotNull(tc.BuscarTextos());
    }
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

}
