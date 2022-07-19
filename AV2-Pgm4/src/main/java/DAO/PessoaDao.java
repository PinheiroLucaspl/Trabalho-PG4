/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Paciente;
import model.Pessoa;

/**
 *
 * @author Dell
 */
public class PessoaDao {
    
    private ArrayList<Pessoa> pessoas = new ArrayList();
   
    
    public ArrayList<Pessoa> listarPessoas() {
        try{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        EntityManager em = emf.createEntityManager();        
        EntityTransaction tx = em.getTransaction();
        TypedQuery<Pessoa> tq = em.createQuery("select p from pgm4_lucas_pessoa p", Pessoa.class);
        pessoas = new ArrayList<Pessoa>(tq.getResultList());
        }catch(Exception ex){
           System.out.println("erro ao listar pessoas"+ ex.getMessage());
        }
        return pessoas;
    }
    
    public void adicionarPessoa(Pessoa p) {
        try {         
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
            EntityManager em = emf.createEntityManager();        
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(p);
            tx.commit();
            pessoas.add(p);
        } catch (Exception e) {
            System.out.println("erro ao adicionar pessoa: " + e.getMessage());
        }
    }
}
