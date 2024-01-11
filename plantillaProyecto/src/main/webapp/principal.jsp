<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.plantillaproyecto.Productos" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>página principal</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form action="Controlador" method="get">
            Acceda a nuestra tienda: 
            <input type="hidden" name="task" value="tienda">
            <input type="submit" value="Tienda">
        </form>
        <br>
        <form action="Controlador" method="get">
            Revise los servicios del taller: 
            <input type="hidden" name="task" value="taller">
            <input type="submit" value="Taller">
        </form>
        <form action="Controlador" method="get">
            Listar productos:
            <input type="hidden" name="task" value="listar">
            <input type="submit" value="Listar">
        </form>
        
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Motor</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Imagen</th>
            </tr>
            
            <% if (request.getAttribute("listaProductos") != null) { %>
    	<% List<Productos> listaProductos = (List<Productos>) request.getAttribute("listaProductos"); %>
    
		<% for (Productos producto : listaProductos) { %>
                <tr>
                    <td><%= producto.getId() %></td>
                    <td><%= producto.getMarca() %></td>
                    <td><%= producto.getModelo() %></td>
                    <td><%= producto.getMotor() %></td>
                    <td><%= producto.getNombre() %></td>
                    <td><%= producto.getPrecio() %></td>
                    <td><%= producto.getUrlImagen() %></td>
                </tr>
            <% } %>

	<% } else { %>
	    <p>La lista de productos es nula o está vacía.</p>
	<% } %>
            
            
            
        </table>
        
    </body>
</html>