/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import model.Paciente;
/**
 *
 * @author EduardoVM
 */
public class PacienteDAO {

    private ArrayList<Paciente> pacientes = new ArrayList();
   
    
    public ArrayList<Paciente> listarPacientes() {
        try{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        EntityManager em = emf.createEntityManager();        
        EntityTransaction tx = em.getTransaction();
        TypedQuery<Paciente> tq = em.createQuery("select p from Paciente p", Paciente.class);
        pacientes = new ArrayList<Paciente>(tq.getResultList());
        }catch(Exception ex){
           System.out.println("erro ao listar pacientes"+ ex.getMessage());
        }
        return pacientes;
    }
    
    public void adicionarPaciente(Paciente p) {
        try {         
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
            EntityManager em = emf.createEntityManager();        
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(p);
            tx.commit();
            pacientes.add(p);
        } catch (Exception e) {
            System.out.println("erro ao adicionar paciente: " + e.getMessage());
        }
    }
    
    public void removerPaciente(Integer id) {
        try {
           
            for (int i = 0; i < pacientes.size(); i++) {
                if (pacientes.get(i).getId().equals(new Long(id))) {
                    pacientes.remove(pacientes.get(i));
                    break;
                }
            }          
        } catch (Exception e) {
            System.out.println("erro ao excluir paciente: " + e.getMessage());
        }
    }
    
    public Paciente buscarPaciente(Integer id) {
        try {
            for (int i = 0; i < pacientes.size(); i++) { 
                if (pacientes.get(i).getId().equals(new Long(id))) {
                    return pacientes.get(i);
                }
            }
        } catch (Exception e) {
            System.out.println("erro ao buscar paciente: " + e.getMessage());
            return null;
        }
        return null;
    }
   
    public void atualizarPessoa(Paciente p) {
        try {
            for (int i = 0; i < pacientes.size(); i++) { 
                if (pacientes.get(i).getId().equals(p.getId())) { 
                     pacientes.set(i, p);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("erro ao atualizar a pessoa de id " + p.getId() +": " + e.getMessage());
        }
    }
}
