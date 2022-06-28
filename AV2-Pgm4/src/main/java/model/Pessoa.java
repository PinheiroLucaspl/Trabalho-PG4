/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dell
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;      
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
        
@Entity
@Table(name="pgm4_lucas_pessoa")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pgm4_lucas_pessoa_seq")
    @SequenceGenerator(name="pgm4_lucas_pessoa_seq", initialValue = 1)
    Long id ;
    String nome;
    String email;
    Float peso;

    public Pessoa(String nome, String email, Float peso) {
        this.nome = nome;
        this.email = email;
        this.peso = peso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", peso=" + peso + '}';
    }
    
}
