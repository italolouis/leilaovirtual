
package br.com.leilaovirtual.model.dao;
import br.com.leilaovirtual.model.entities.Leilao;
import br.com.leilaovirtual.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="leilaoMB")
@SessionScoped
public class LeilaoMB implements Serializable{
    private static final long serialVerisonUID = 1L;
    
    private Leilao leilao = new Leilao();
    private List<Leilao> leiloes;
    
    public LeilaoMB(){     
    }
    
    private InterfaceDAO<Leilao> leilaoDAO(){
        InterfaceDAO<Leilao> leilaoDAO = new HibernateDAO<Leilao>(Leilao.class, FacesContextUtil.getRequestSession());
        return leilaoDAO;
    }
    
     public String limpLeilao() {
        leilao= new Leilao();
        return editLeilao();
    }
    
    public String editLeilao(){
        return "/restrict/cadastraleilao.faces";
    }
    
    public String addLeilao(){
        if(leilao.getIdLeilao()==null || leilao.getIdLeilao()==0){
            insertLeilao();
        }else{
            updateLeilao();
        }
        limpLeilao();
        return null;
    }
    
    private void insertLeilao(){
        leilaoDAO().save(leilao);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }
    
    private void updateLeilao(){
        leilaoDAO().update(leilao);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }
    
   public List<Leilao> getLeiloes() {
         leiloes = leilaoDAO().getEntities();
        return leiloes;
    }
    
    public void deleteLeilao(){
        leilaoDAO().remove(leilao);
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }

    public void setLeiloes(List<Leilao> leiloes) {
        this.leiloes = leiloes;
    }
    
    
}