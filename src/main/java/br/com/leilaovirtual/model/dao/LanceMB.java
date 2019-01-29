
package br.com.leilaovirtual.model.dao;
import br.com.leilaovirtual.model.entities.Lance;
import br.com.leilaovirtual.model.entities.Leilao;
import br.com.leilaovirtual.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="lanceMB")
@SessionScoped
public class LanceMB implements Serializable{
    private static final long serialVerisonUID = 1L;
    
    private Lance lance = new Lance();
    private List<Lance> lances;
    
    public LanceMB(){     
    }
    
    private InterfaceDAO<Lance> lanceDAO(){
        InterfaceDAO<Lance> lanceDAO = new HibernateDAO<Lance>(Lance.class, FacesContextUtil.getRequestSession());
        return lanceDAO;
    }
    
     public String limpLance() {
        lance = new Lance();
        return editLance();
    }
    
    public String editLance(){
        return "/restrict/cadastralance.faces";
    }
    
    public String addLance(){
        if(lance.getIdLance()==null || lance.getIdLance()==0){
            insertLance();
        }else{
            updateLance();
        }
        limpLance();
        return null;
    }
    
    private void insertLance(){
        lanceDAO().save(lance);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }
    
    private void updateLance(){
        lanceDAO().update(lance);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }
    
   public List<Lance> getLances() {
         lances = lanceDAO().getEntities();
        return lances;
    }
    
    public void deleteLance(){
        lanceDAO().remove(lance);
    }

    public Lance getLance() {
        return lance;
    }

    public void setLance(Lance lance) {
        this.lance = lance;
    }

    public void setLances(List<Lance> lances) {
        this.lances = lances;
    }
}

