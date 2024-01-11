
package com.mycompany.plantillaproyecto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sanch
 */
public class ModelosProductos {

    private Connection c;
    

    public ModelosProductos() {

    	try { 
    		
    	    Class.forName("com.mysql.cj.jdbc.Driver");
    	    this.c = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "");
    	    
    	} catch (SQLException | ClassNotFoundException ex) {
    	    this.c = null;
    	    Logger.getLogger(ModelosProductos.class.getName()).log(Level.SEVERE, "Error en la conexión a la base de datos", ex);
    	}
        
    }

    public List<Productos> listarProductos() {
    	ArrayList<Productos> lista = new ArrayList<Productos>();
    	
        String sqlSentence = "SELECT * FROM productos";
        System.out.println("Sentence: " + sqlSentence);  // verificación en consola
        Statement st;
        
        if (this.c != null) {
        try {
            st = this.c.createStatement();
            ResultSet miResultset = st.executeQuery(sqlSentence);
            while (miResultset.next()) {
				Integer id=miResultset.getInt(1);
				String marca=miResultset.getString(2);
				String modelo=miResultset.getString(3);
				String motor=miResultset.getString(4);
				String nombre=miResultset.getString(5);
				float precio=miResultset.getFloat(6);
				String urlImagen=miResultset.getString(7);
				lista.add(new Productos(id, marca, modelo, motor, nombre, precio, urlImagen));
			}
        } catch (SQLException ex) {
            Logger.getLogger(ModelosProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            System.out.println("No hay conexion a la bbdd");
        }
        return lista;
    }

    
}
