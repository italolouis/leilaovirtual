
package br.com.leilaovirtual.model.dao;
import br.com.leilaovirtual.model.entities.Vencedor;
import br.com.leilaovirtual.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="vencedorMB")
@SessionScoped
public class VencedorMB implements Serializable{
    private static final long serialVerisonUID = 1L;
    
    private Vencedor vencedor = new Vencedor();
    private List<Vencedor> vencedores;
    
    public VencedorMB(){     
    }
    
    private InterfaceDAO<Vencedor> vencedorDAO(){
        InterfaceDAO<Vencedor> vencedorDAO = new HibernateDAO<Vencedor>(Vencedor.class, FacesContextUtil.getRequestSession());
        return vencedorDAO;
    }
    
     public String limpVencedor() {
        vencedor = new Vencedor();
        return editVencedor();
    }
    
    public String editVencedor(){
        return "/restrict/cadastraleilao.faces";
    }
    
    public String addVencedor(){
        if(vencedor.getIdVencedor()==null || vencedor.getIdVencedor()==0){
            insertVencedor();
        }else{
            updateVencedor();
        }
        limpVencedor();
        return null;
    }
    
    private void insertVencedor(){
        vencedorDAO().save(vencedor);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }
    
    private void updateVencedor(){
        vencedorDAO().update(vencedor);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }
    
   public List<Vencedor> getVencedores() {
         vencedores = vencedorDAO().getEntities();
        return vencedores;
    }
    
    public void deleteVencedor(){
        vencedorDAO().remove(vencedor);
    }

    public Vencedor getVencedor() {
        return vencedor;
    }

    public void setVencedor(Vencedor vencedor) {
        this.vencedor = vencedor;
    }

    public void setVencedores(List<Vencedor> vencedores) {
        this.vencedores = vencedores;
    }
}

