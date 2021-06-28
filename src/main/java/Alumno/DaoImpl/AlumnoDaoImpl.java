package Alumno.DaoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Alumno.Dao.AlumnoDao;
import Alumno.entity.Alumno;
import Alumno.config.Conexion;


public class AlumnoDaoImpl implements AlumnoDao{
	
	private Connection cx=null;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	@Override
	public int create(Alumno a) {
		int x = 0;
		String SQL = "insert into Alumno (nombre,direccion,telefono) values(?,?,?)";
		try {
			cx = Conexion.getConexion();
			pst = cx.prepareStatement(SQL);
			pst.setString(1,a.getNombre().trim());
			pst.setString(2,a.getDireccion().trim());
			pst.setString(3,a.getTelefono().trim());
			x = pst.executeUpdate();
			System.out.println(x);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		return x;
	}

	@Override
	public int update(Alumno a) {
		int x = 0;
		String SQL = "update Alumno set nombre = ?,telefono = ?, direccion = ? where idalum ="+a.getIdalum()+";";
		try {
			cx = Conexion.getConexion();
			pst = cx.prepareStatement(SQL);
			pst.setString(1, a.getNombre());
			pst.setString(2, a.getTelefono());
			pst.setString(3, a.getDireccion());
			x = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public int delete(int idalum) {
		int x = 0;
		String SQL = "delete from Alumno where idalum="+idalum+";";
		try {
			cx = Conexion.getConexion();
			pst = cx.prepareStatement(SQL);
			x = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return x;
	}

	@Override
	public Alumno read(int id) {
		// TODO Auto-generated method stub
		Alumno a = new Alumno();
		String SQL = "select *from Alumno where idalum="+id+";";
		try {
			cx = Conexion.getConexion();
			pst = cx.prepareStatement(SQL);
			rs = pst.executeQuery();
			while (rs.next()) {				
				a.setIdalum(rs.getInt("idalum"));
				a.setNombre(rs.getString("nombre"));
				a.setDireccion(rs.getString("direccion"));
				a.setTelefono(rs.getString("telefono"));		
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return a;
	}

	@Override
	public List<Alumno> readAll() {
		// TODO Auto-generated method stub
		List<Alumno> lista = new ArrayList<>();
		String SQL = "select *from Alumno";
		try {
			cx = Conexion.getConexion();
			pst = cx.prepareStatement(SQL);
			rs = pst.executeQuery(SQL);
			while(rs.next()) {
				Alumno r = new Alumno();
				r.setIdalum(rs.getInt("idalum"));
				r.setNombre(rs.getString("nombre"));
				r.setDireccion(rs.getString("direccion"));
				r.setTelefono(rs.getString("telefono"));
				lista.add(r);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		
		return lista;
	}

}
