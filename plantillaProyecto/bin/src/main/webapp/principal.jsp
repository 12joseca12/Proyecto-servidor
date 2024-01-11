listar.jsp: <%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        
        <table>

<tr>
<th>Id</th>
<th>Marca</th>
<th>Modelo</th>
<th>Motor</th>
<th>Nombre</th>
<th>Precio</th>
<th>Imagen</th>
</tr>

<c:forEach var="listaProductos" items="${productos}">



<tr>

<td>${productos.marca}</td>
<td>${productos.modelo}</td>
<td>${productos.motor}</td>
<td>${productos.nombre}</td>
<td>${productos.precio}</td>
<td>${productos.imagen}</td>

</tr>

</c:forEach>

</table>
        
    </body>
</html>