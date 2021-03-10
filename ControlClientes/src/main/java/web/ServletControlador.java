
package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
	if(accion != null){    
            switch(accion){
		case "editar":
                    this.editarCliente(request, response);
		    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
		    break;    
                default: 
                    this.accionDefault(request,response);
	    }			
        }else{
          this.accionDefault(request,response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Cliente> listaCliente = new ClienteDaoJDBC().listar();
            HttpSession sesion = request.getSession(); //Para visualizar los datos.
            sesion.setAttribute("clientes", listaCliente);
            sesion.setAttribute("totalClientes", listaCliente.size());
            sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(listaCliente));
            response.sendRedirect("clientes.jsp"); //Con este metodo cambiamos de url sin mostrar la accion del boton.
        } catch (IOException ex) {
            Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private double calcularSaldoTotal(List<Cliente> listaCliente) {
      double saldoTotal = 0;
       for(Cliente cliente: listaCliente){
          saldoTotal = saldoTotal + cliente.getSaldo();
       }
      return saldoTotal;
    }

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
	if(accion != null){    
            switch(accion){
		case "insertar":
                    this.insertarCliente(request, response);
		    break;
                case "modificar":
                    this.modificarCliente(request, response);
		    break;    
                default: 
                    this.accionDefault(request,response);
	    }			
        }else{
          this.accionDefault(request,response);
        }
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = Double.parseDouble(request.getParameter("saldo"));
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
        ClienteDaoJDBC clienteDAO = new ClienteDaoJDBC();
        clienteDAO.insertar(cliente);
        this.accionDefault(request, response);
    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response) {
        try {
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente));
            request.setAttribute("cliente", cliente);
            String jspEditar = "/WEB-INF/paginas/comunes/editarCliente.jsp";
            request.getRequestDispatcher(jspEditar).forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) {
       int idCliente = Integer.parseInt(request.getParameter("idCliente"));
       String nombre = request.getParameter("nombre");
       String apellido = request.getParameter("apellido");
       String email = request.getParameter("email");
       String telefono = request.getParameter("telefono");
       double saldo = Double.parseDouble(request.getParameter("saldo"));
       Cliente cliente = new Cliente(idCliente,nombre,apellido,email,telefono,saldo);
       int regActualizados = new ClienteDaoJDBC().actualizar(cliente);
       System.err.println("Registros modificados: " + regActualizados);
       this.accionDefault(request, response);
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) {
       int idCliente = Integer.parseInt(request.getParameter("idCliente"));
       Cliente cliente = new Cliente(idCliente);
       int regActualizados = new ClienteDaoJDBC().eliminar(cliente);
       System.err.println("Registros modificados: " + regActualizados);
       this.accionDefault(request, response); 
    }

        

}