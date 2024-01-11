/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.plantillaproyecto;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


/**
 *
 * @author dawmi
 */
public class Controlador extends HttpServlet {
	private ModelosProductos modelosProducto;
    

    @Override
    public void init() throws ServletException {
        super.init();

       try {
    	   this.modelosProducto = new ModelosProductos();
       }catch(Exception e) {
    	   throw new ServletException(e);
       }
       
       
    }


   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
        
        String elComando=request.getParameter("task");
        if(elComando==null) elComando="principal";
        
        switch(elComando) {
            
        case "principal":
    		 request.getRequestDispatcher("/principal.jsp").forward(request, response);
    		break; 
            
    	case "tienda":
    		 request.getRequestDispatcher("/tienda.jsp").forward(request, response);
    		break;
    	
    	case "taller":
    		request.getRequestDispatcher("/taller.jsp").forward(request, response);
    		break;
    	case "listar":
            System.out.println("alcanza listar");
    		try {
    	        List<Productos> productos = modelosProducto.listarProductos();
    	        if (productos != null) {
    	            request.setAttribute("listaProductos", productos);
    	            RequestDispatcher miDispatcher = request.getRequestDispatcher("principal.jsp");
    	            miDispatcher.forward(request, response);
    	        } else {
    	            // Manejar el caso donde la lista de productos es nula
    	        	System.out.println("lista de productos es nula");
    	        }
    	    }catch(Exception e){ 
    	    	System.out.println("listar lanzo excepcion");
    	    	e.printStackTrace();
            } 
            break;
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
