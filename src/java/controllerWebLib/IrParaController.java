package controllerWebLib;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class IrParaController {

    public void irParaPagLogin() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("login.xhtml");
        } catch (IOException ex) {
            context.addMessage(null, new FacesMessage(" falhou."));
        }
    }

    public void irParaPagRegistrar() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("registrar.xhtml");
        } catch (IOException ex) {
            context.addMessage(null, new FacesMessage(" falhou."));
        }
    }

    public void irParaPagInicial() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("paginaInicial.xhtml");
        } catch (IOException ex) {
            context.addMessage(null, new FacesMessage(" falhou."));
        }
    }

    public void irParaPagLivros() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("livros.xhtml");
        } catch (IOException ex) {
            context.addMessage(null, new FacesMessage(" falhou."));
        }
    }

    public void irParaPagContos() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("contos.xhtml");
        } catch (IOException ex) {
            context.addMessage(null, new FacesMessage(" falhou."));
        }
    }

    public void irParaPagPensam() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("pensamentos.xhtml");
        } catch (IOException ex) {
            context.addMessage(null, new FacesMessage(" falhou."));
        }
    }

    public void irParaPagPoemas() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("poemas.xhtml");
        } catch (IOException ex) {
            context.addMessage(null, new FacesMessage(" falhou."));
        }
    }

    public void irParaPagMusicas() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("musicas.xhtml");
        } catch (IOException ex) {
            context.addMessage(null, new FacesMessage(" falhou."));
        }
    }

    public void irParaPagMinhasPost() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("minhasPostagens.xhtml");
        } catch (IOException ex) {
            context.addMessage(null, new FacesMessage(" falhou."));
        }
    }

    public void irParaPagEscrivaninha() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("escrivaninha.xhtml");
        } catch (IOException ex) {
            context.addMessage(null, new FacesMessage(" falhou."));
        }
    }

    public void irParaPagEscrivLivro() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("escrivLivro.xhtml");
        } catch (IOException ex) {
            context.addMessage(null, new FacesMessage(" falhou."));
        }
    }
    public void irParaPagEscrivTexto() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            context.getExternalContext().redirect("escrivTexto.xhtml");
        } catch (IOException ex) {
            context.addMessage(null, new FacesMessage(" falhou."));
        }
    }
    
}
