
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ClienteDAO;


@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteDAO clienteDAO = new ClienteDAO();
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        boolean loginOK = clienteDAO.verficarCliente(nombre, password);
         if(loginOK == true){
             System.err.println("OK");
             String jspAreaCliente = "/WEB-INF/paginas/comunes/areaCliente.jsp";
             request.getRequestDispatcher(jspAreaCliente).forward(request, response);
         }else{
             System.err.println("NO OK");
         }
    }      

}
