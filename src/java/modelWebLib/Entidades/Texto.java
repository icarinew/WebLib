package modelWebLib.Entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "texto")
public class Texto implements Serializable{
   @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_texto")
    private long id;
    @Column(name="categoria", nullable = false)
    private String categoria;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name="genero", nullable = false)
    private String genero;
    @Column(name="conteudo", nullable = false)
    private String conteudo;
    @Column(name = "autor", nullable = false)
    private String autor;
    @JoinColumn(name="id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional=false, fetch = FetchType.EAGER)
    private Usuario usuario;

    public Texto(long id, String categoria, String titulo, String genero, String conteudo, String autor, Usuario usuario) {
        this.id = id;
        this.categoria = categoria;
        this.titulo = titulo;
        this.genero = genero;
        this.conteudo = conteudo;
        this.autor = autor;
        this.usuario = usuario;
    }
   public Texto(){
       
   } 

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   @Override
    public String toString() {
        return "Texto{" + "id=" + id + "\n" + "categoria=" + categoria + "\n" +
               "titulo=" + titulo + "\n" + "genero=" + genero + "\n" + 
               "conteudo=" + conteudo + "\n" + "autor=" + autor + "\n" + 
               "usuario=" + usuario.getUser()+ '}' ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, autor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Texto texto = (Texto) obj;
        if (this.id != texto.id) {
            return false;
        }
      
        return Objects.equals(this.id, texto.id);
    }
}
