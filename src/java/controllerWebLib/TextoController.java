
package controllerWebLib;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelWebLib.Entidades.Texto;
import modelWebLib.TextoModel;

@ManagedBean
@SessionScoped
public class TextoController {
    private Texto texto = new Texto();
    private TextoModel tm = new TextoModel();
    private List<Texto> textos = new ArrayList<>();
    
    public TextoController() {
    }
    
    public void AdicionarTexto(){
        FacesContext context = FacesContext.getCurrentInstance();
      	 try {
            tm.cadastrarTexto(texto);			
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage("Falha ao adicionar texto!"));
        }
   }
   public void DeletarTexto() {
       FacesContext context = FacesContext.getCurrentInstance();
      	 try {
           tm.deletarTexto(texto);			
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage("Falha ao excluir texto!"));
        }
   }
    public void AlterarTexto() {
       FacesContext context = FacesContext.getCurrentInstance();
      	 try {
            tm.alterarTexto(texto);			
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage("Falha ao alterar texto!"));
        }
   }
    public Texto BuscarTexto() {
       FacesContext context = FacesContext.getCurrentInstance();
      	 try {
           return tm.buscarTexto(texto.getId());			
        } catch (Exception ex) {
            context.addMessage(null, new FacesMessage("Falha ao buscar texto!"));
        }
         return null;
   }
    public List<Texto> BuscarTextos() {
       FacesContext context = FacesContext.getCurrentInstance();
      	 try {
            return tm.buscarTextos();	
        } catch (Exception ex){ 
            context.addMessage(null, new FacesMessage("Falha ao listar texto!"));
        }
         return null;
   }

    public Texto getTexto() {
        return texto;
    }

    public void setTexto(Texto texto) {
        this.texto = texto;
    }

    public TextoModel getTm() {
        return tm;
    }

    public void setTm(TextoModel tm) {
        this.tm = tm;
    }

    public List<Texto> getTextos() {
        return textos;
    }

    public void setTextos(List<Texto> textos) {
        this.textos = textos;
    }
      
      
      
      
}
