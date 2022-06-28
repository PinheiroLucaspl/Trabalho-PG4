package ifc.edu.br.av2.pgm4;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dell
 */
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;
import model.Pessoa;

public class TestarPessoa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Pessoa p = new Pessoa("João", "joao@gmail.com", 70.5f);
        Pessoa p1 = new Pessoa("Lucas", "Lucas@gmail.com", 60.5f);
        Pessoa p2 = new Pessoa("Bruna", "Bruna@gmail.com", 50.5f);
        Pessoa p3 = new Pessoa("Giovana", "Giovana@gmail.com", 30.5f);
        em.persist(p);
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

        tx.commit();
        
    }

}
