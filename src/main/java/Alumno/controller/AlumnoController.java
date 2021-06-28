package Alumno.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Alumno.Dao.AlumnoDao;
import Alumno.DaoImpl.AlumnoDaoImpl;
import Alumno.entity.Alumno;

/**
 * Servlet implementation class AlumnoController
 */
public class AlumnoController extends HttpServlet {
	
	private AlumnoDao adao = new AlumnoDaoImpl();
	private Gson gson = new Gson();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int opcion = Integer.parseInt(request.getParameter("opc"));
		switch (opcion) {
		case 1://todos los roles
				out.println(gson.toJson(adao.readAll()));
			break;
		case 2://guardar
			out.println(gson.toJson(adao.create(new Alumno(request.getParameter("nombre"), request.getParameter("telefono"), request.getParameter("direccion")))));
			break;
		case 3://read
			out.println(gson.toJson(adao.read(Integer.parseInt(request.getParameter("id")))));
			break;
		case 4://modificar
			Alumno r = new Alumno();
			r.setIdalum(Integer.parseInt(request.getParameter("id")));
			r.setNombre(request.getParameter("nombre"));
			r.setDireccion(request.getParameter("direccion"));
			r.setTelefono(request.getParameter("telefono"));
			out.println(gson.toJson(adao.update(r)));
			break;
		case 5://eliminar
			out.println(gson.toJson(adao.delete(Integer.parseInt(request.getParameter("id")))));
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
