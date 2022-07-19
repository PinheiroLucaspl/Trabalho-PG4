/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import model.TipoDePlanoSaude;

/**
 *
 * @author Dell
 */
@Entity
@Table(name="planoDeSaude")
public class PlanoDeSaude implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name="planoDeSaude_seq", initialValue = 1)
    private Long id;
    
    private String nome;
    private float limite;
    private String tipoDeLeito;
    
   // @ManyToOne
    //private TipoDePlanoSaude tipoDePlano;

    public float calcularLimite(){
        return 0;
    }
            
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public String getTipoDeLeito() {
        return tipoDeLeito;
    }

    public void setTipoDeLeito(String tipoDeLeito) {
        this.tipoDeLeito = tipoDeLeito;
    }

   /* public TipoDePlanoSaude getTipoDePlano() {
        return tipoDePlano;
    }

    public void setTipoDePlano(TipoDePlanoSaude tipoDePlano) {
        this.tipoDePlano = tipoDePlano;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanoDeSaude)) {
            return false;
        }
        PlanoDeSaude other = (PlanoDeSaude) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PlanoDeSaude[ id=" + id + " ]";
    }
    
}
