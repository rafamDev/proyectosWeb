
package controlador;

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
import modelo.ClienteDAO;
import pojo.Cliente;


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
                case "regresarAreaCliente":
                    this.regresarAreaCliente(request, response);
		    break;     
                default: 
                   System.err.println("");
	    }			
        }else{
            System.err.println("");
        }
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
                case "login":
                    this.setLogin(request, response);
		    break;    
                case "modificar":
                    this.modificarCliente(request, response);
		    break; 
                default: 
                    System.err.println("");
	    }			
        }else{
            System.err.println("");
        }
    }      

    private void setLogin(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
       ClienteDAO clienteDAO = new ClienteDAO();
       boolean isUser = false;
       String nombre = request.getParameter("nombre");
       String password = request.getParameter("password");
       HttpSession sesion = request.getSession();
       sesion.setAttribute("isUser",isUser);
       boolean loginOK = clienteDAO.verficarCliente(nombre, password);
        if(loginOK == true){
            isUser = true;
            this.listarClientes(request);
            String jspAreaCliente = "/WEB-INF/paginas/jspFiles/areaCliente.jsp";
            request.getRequestDispatcher(jspAreaCliente).forward(request, response);
        }else{
            isUser = false;
            response.sendRedirect("index.jsp");
        }
    }

    private void listarClientes(HttpServletRequest request) throws IOException{
      List<Cliente> listaCliente = new ClienteDAO().listar();
      HttpSession sesion = request.getSession();
      sesion.setAttribute("clientes", listaCliente);
      sesion.setAttribute("totalClientes", listaCliente.size());
    }
    
    private void editarCliente(HttpServletRequest request, HttpServletResponse response) {
        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Cliente cliente = new ClienteDAO().encontrar(new Cliente(codigo));
            request.setAttribute("cliente", cliente);
            String jspEditar = "/WEB-INF/paginas/jspFiles/editarCliente.jsp";
            request.getRequestDispatcher(jspEditar).forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServletControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       String nombre = request.getParameter("nombre");
       String password = request.getParameter("password");
       String apellido = request.getParameter("apellido");
       String email = request.getParameter("email");
       String telefono = request.getParameter("telefono");
       String provincia = request.getParameter("provincia");
       String localidad = request.getParameter("localidad");
       String direccion = request.getParameter("direccion");
       Cliente cliente = new Cliente(nombre,password,apellido,email,telefono,provincia,localidad,direccion);
       ClienteDAO clienteDAO = new ClienteDAO();
       clienteDAO.insertar(cliente);
       response.sendRedirect("index.jsp");
    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       int codigo = Integer.parseInt(request.getParameter("codigo"));
       String nombre = request.getParameter("nombre");
       String password = request.getParameter("password");
       String apellido = request.getParameter("apellido");
       String email = request.getParameter("email");
       String telefono = request.getParameter("telefono");
       String provincia = request.getParameter("provincia");
       String localidad = request.getParameter("localidad");
       String direccion = request.getParameter("direccion");
       Cliente cliente = new Cliente(codigo,nombre,password,apellido,email,telefono,provincia,localidad,direccion);
       ClienteDAO clienteDAO = new ClienteDAO();
       clienteDAO.actualizar(cliente);
       request.setAttribute("cliente", cliente);
       this.listarClientes(request);
       String jspEditar = "/WEB-INF/paginas/jspFiles/areaCliente.jsp";
       request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
     private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       int codigo = Integer.parseInt(request.getParameter("codigo"));
       Cliente cliente = new Cliente(codigo);
       ClienteDAO clienteDAO = new ClienteDAO();
       clienteDAO.eliminar(cliente);
       this.listarClientes(request);
       String jspEditar = "/WEB-INF/paginas/jspFiles/areaCliente.jsp";
       request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void regresarAreaCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String jspEditar = "/WEB-INF/paginas/jspFiles/areaCliente.jsp";
       request.getRequestDispatcher(jspEditar).forward(request, response);
    }

}
