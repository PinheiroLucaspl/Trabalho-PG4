/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Dell
 */
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
        
public class CriarTabelas {
    
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
    }
}
