
package br.com.leilaovirtual.model.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table (name="leilao")
public class Leilao implements Serializable {
    
    private static final long serialVersionUID =  1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdLeilao", nullable=false)
    private Integer idLeilao;
    @Column(name="Produto", nullable = false, length = 60)
    private String produto;
    @Column(name="ValorMin", nullable = false, length = 80 )
    private Integer valorMin;

    public Integer getIdLeilao() {
        return idLeilao;
    }

    public void setIdLeilao(Integer idLeilao) {
        this.idLeilao = idLeilao;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getValorMin() {
        return valorMin;
    }

    public void setValorMin(Integer valorMin) {
        this.valorMin = valorMin;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.idLeilao != null ? this.idLeilao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Leilao other = (Leilao) obj;
        if (this.idLeilao != other.idLeilao && (this.idLeilao == null || !this.idLeilao.equals(other.idLeilao))) {
            return false;
        }
        return true;
    }
    
   
    
    



    
    
}