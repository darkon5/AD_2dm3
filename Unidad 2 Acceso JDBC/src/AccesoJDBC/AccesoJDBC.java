package AccesoJDBC;

import java.sql.*;

import org.apache.commons.dbcp.BasicDataSource;

public class AccesoJDBC {

	Connection con = null;
	
	public void crearConexion(String nombreBD){

		BasicDataSource bdsource = new BasicDataSource();
		bdsource.setUrl("jdbc:mysql://localhost:3306/" + nombreBD);
		bdsource.setUsername("user_empl");
		bdsource.setPassword("vinagres");
		try{
			if(con !=null){
				System.out.println("No se puede crear la conexion");
			}else{
				con = bdsource.getConnection();
				System.out.println("Conexion creada con la BD " + nombreBD);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion(){
		try{
			con.close();
			System.out.println("Conexion cerrada. OK!");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void leerDatos(){
		try{
		//Creamos una statement - Consulta
		Statement sta = con.createStatement();
		//ejecutamos la sentencia y la metemos en un objeto resulset
		ResultSet rs = sta.executeQuery("SELECT * from empleados");
		//recorremos el resultado
		while(rs.next()){
			System.out.println("Nº de empleado: " + rs.getInt(1));
			System.out.println("Apellido empleado: " + rs.getString("Apellido"));
			System.out.println("Oficio empleado: " + rs.getString(3));
			System.out.println("Direccion empleado: " + rs.getString(4));
			System.out.println("Fecha Alta empleado: " + rs.getString(5));
			System.out.println("Salario empleado: " + rs.getString(6));
			System.out.println("Comision empleado: " + rs.getString(7));
			System.out.println("Departamento empleado: " + rs.getString(8));			
			System.out.println("------------------------------------------");	
		}
		rs.close();
		sta.close();
		
		}catch(SQLException e){
			e.printStackTrace();
		}	
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AccesoJDBC accJDBC = new AccesoJDBC();
		accJDBC.crearConexion("empleados");
		accJDBC.leerDatos();
		accJDBC.cerrarConexion();
	}

}
