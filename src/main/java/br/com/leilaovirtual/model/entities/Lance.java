
package br.com.leilaovirtual.model.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table (name="lance")
public class Lance implements Serializable {
    
    private static final long serialVersionUID =  1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdLance", nullable=false)
    private Integer idLance;
    @Column(name="Nome", nullable = false, length = 60)
    private String nome;
    @Column(name="ValorLance", nullable = false, length = 80 )
    private Integer valorLance;

    public Integer getIdLance() {
        return idLance;
    }

    public void setIdLance(Integer idLance) {
        this.idLance = idLance;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getValorLance() {
        return valorLance;
    }

    public void setValorLance(Integer valorLance) {
        this.valorLance = valorLance;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idLance);
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
        final Lance other = (Lance) obj;
        if (!Objects.equals(this.idLance, other.idLance)) {
            return false;
        }
        return true;
    }
    
    
    
}