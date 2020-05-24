package Com.Ronal.Controlador;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import Com.Jose.Dao.UsDao;
import Com.Jose.Dao.historialDao;
import Com.Jose.Modelo.TbHistorial;
import Com.Jose.Modelo.TbUsuariop;



/**
 * Servlet implementation class Servelet
 */
public class Servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String us = request.getParameter("usuario");
		String contra = request.getParameter("contrasenia");
        String cerrar = request.getParameter("btncerrar");
		
		if(cerrar!=null) {
			
			if(cerrar.equals("CERRAR")) {
				
			HttpSession cerrarsesiones = (HttpSession) request.getSession();
			cerrarsesiones.invalidate();
			
			response.sendRedirect("index.jsp");
			}
				
			}else {
				TbUsuariop u = new TbUsuariop();
				UsDao udao= new UsDao();
				
				
				u.setUsuario(us);
				u.setContrasenia(contra);
				
				int verificaion= udao.usuario(u).size();
				if (verificaion ==1) {
					
					TbHistorial tbh = new TbHistorial();
					historialDao h = new historialDao();
					Date fecha = new Date();
					tbh.setFecha(fecha);
					u.setIdUsuarios(u.getIdUsuarios());
					tbh.setTbUsuariop(u);
					h.agregarDatosHistorial(tbh);
					
					HttpSession sesion = request.getSession(true);
					sesion.setAttribute("usuarioo", us); 
					response.sendRedirect("Final.jsp");
					
					
				}else {
					System.out.println("¡Error Usuario o Contraseña incorrecto!");
					
				}
			}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
