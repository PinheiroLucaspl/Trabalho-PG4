/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import DAO.PacienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Paciente;

/**
 *
 * @author EduardoVM
 */
@WebServlet(urlPatterns = {"/paciente"})
public class PacienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    PacienteDAO daopac = new PacienteDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            String op = request.getParameter("op");
           
            if(op == null){             
            ArrayList<Paciente> registros = daopac.listarPacientes();
            request.setAttribute("registros", registros);
            
            getServletContext().getRequestDispatcher("/listarPacientes.jsp").forward(request, response);
            }
            else if (op.equals("add")){
                 getServletContext().getRequestDispatcher("/adicionarPaciente.jsp").forward(request, response);
           
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf8");

        String op = request.getParameter("op");

        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String datanacimento = request.getParameter("dataNacimento");
        
        SimpleDateFormat formatodatas = new SimpleDateFormat("dd/MM/yyyy");
        try{                
         java.sql.Date sqlDate = new java.sql.Date(formatodatas.parse(datanacimento).getTime());
         Paciente novopac = new Paciente(nome, endereco,email,telefone, sqlDate);
        
        daopac.adicionarPaciente(novopac);
        }catch(Exception ex)
        {
            System.out.println("Erro convertendo data");
        }
        
        response.sendRedirect(request.getContextPath()+"/paciente");
                   
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
