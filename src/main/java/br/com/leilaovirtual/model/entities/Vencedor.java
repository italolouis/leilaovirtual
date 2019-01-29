
package br.com.leilaovirtual.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="vencedor")
public class Vencedor implements Serializable {
    
    private static final long serialVersionUID =  1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdVencedor", nullable=false)
    private Integer idVencedor;
    @Column(name="NomeVenc", nullable = false, length = 60)
    private String nomeVenc;

    public Integer getIdVencedor() {
        return idVencedor;
    }

    public void setIdVencedor(Integer idVencedor) {
        this.idVencedor = idVencedor;
    }

    public String getNomeVenc() {
        return nomeVenc;
    }

    public void setNomeVenc(String nomeVenc) {
        this.nomeVenc = nomeVenc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.idVencedor != null ? this.idVencedor.hashCode() : 0);
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
        final Vencedor other = (Vencedor) obj;
        if (this.idVencedor != other.idVencedor && (this.idVencedor == null || !this.idVencedor.equals(other.idVencedor))) {
            return false;
        }
        return true;
    }
    
    
  
}