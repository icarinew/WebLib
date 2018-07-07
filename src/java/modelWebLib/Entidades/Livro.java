package modelWebLib.Entidades;

import java.io.File;
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
@Table(name = "livro")
public class Livro implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_livro")
    private long id;
    @Column(name="categoria", nullable = false)
    private String categoria;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name="isbn", nullable = false)
    private String isbn;
    @Column(name="edicao", nullable = false)
    private String edicao;
    @Column(name="arquivo", nullable = false)
    private File pdf;
    @Column(name = "autor", nullable = false)
    private String autor;
    @JoinColumn(name="id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional=false, fetch = FetchType.EAGER)
    private Usuario usuario;

    public Livro() {
    }

    public Livro(long id, String categoria, String titulo, String isbn, String edicao, File pdf, String autor, Usuario usuario) {
        this.id = id;
        this.categoria = categoria;
        this.titulo = titulo;
        this.isbn = isbn;
        this.edicao = edicao;
        this.pdf = pdf;
        this.autor = autor;
        this.usuario = usuario;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public File getPdf() {
        return pdf;
    }

    public void setPdf(File pdf) {
        this.pdf = pdf;
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
        return "Livro{" + "id=" + id + ", categoria=" + categoria + 
               ", titulo=" + titulo + ", isbn=" + isbn + ", edicao=" + edicao + 
               ", pdf=" + pdf + ", autor=" + autor + ", usuario=" + usuario.getUser()+ '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, titulo, autor, edicao); 
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
        final Livro livro = (Livro) obj;
        if (this.id != livro.id) {
            return false;
        }
        return Objects.equals(this.id, livro.id);
    }
    
    
    
    
    
} 
    

    