package MetaData;

import java.sql.*;
import org.apache.commons.dbcp.BasicDataSource;


public class MetaData {

	Connection con = null;
	
	public void crearConexion(String nombreBD, String user, String pass){
	
		BasicDataSource bdSource = new BasicDataSource();
		bdSource.setUrl("jdbc:mysql://10.9.52.156/"+nombreBD);
		bdSource.setUsername(user);
		bdSource.setPassword(pass);
		
		try{
			if(con !=null){
				System.out.println("No se puede ver crear la conexion");
			}else{
				con = bdSource.getConnection();
				System.out.println("\nConexion creada con la BD"+ nombreBD);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion(){
		try{
			con.close();
			System.out.println("Conexion cerrada con exito! :)");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void obtenerInfoBBDD(String nombretabala){
		try{
			DatabaseMetaData dbmd = con.getMetaData();
			//info sobre la BBDD
			System.out.println("Info de la base de datos:");
			System.out.println("Nombre:  " +dbmd.getDatabaseProductName());
			System.out.println("Driver:  " +dbmd.getDriverName());
			System.out.println("URL:  "+dbmd.getURL());
			System.out.println("Usuario:  "+dbmd.getUserName());
			System.out.println("--------------------------------------");

			//
			ResultSet rs = dbmd.getTables(null, nombretabala, null, null);
			System.out.println("INFO DE LAS TABLAS Y VISTAS");
			while(rs.next()){
				System.out.println("Catalogo:  "+rs.getString(1));
				System.out.println("Esquema:  "+rs.getString(2));
				System.out.println("Nombre:  "+rs.getString(3));
				System.out.println("Tipo:  "+rs.getString(4));
				
			}
			
			
			
		
		}catch(SQLException e){
			e.printStackTrace();
			}
	}
	
	public void obtenerInfoTabla(String nombreTabla){
		try{
			DatabaseMetaData dbmd = con.getMetaData();
			
			System.out.println("INFO DE LAS TABLA");
			ResultSet rs = dbmd.getColumns(null, nombreTabla, null, null);
			while(rs.next()){
				System.out.println("Nombre:  " +rs.getString(4));
				System.out.println("Tipo:  " +rs.getString(6));
				System.out.println("Tama�o:  "+rs.getString(7));
				System.out.println("Puede ser nula:  "+rs.getString(4));
				System.out.println("--------------------------------------");
								
				
			}
			
		
		}catch(SQLException e){
			e.printStackTrace();
			}
	}

	public void obtenerInfoResultSet(String nombretabala){
		try{
			Statement sta= con.createStatement();
			ResultSet rs= sta.executeQuery("SELECT *");
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int nColumnas = rsmd.getColumnCount();
			
			System.out.println("INFO DE UN RESULTSET");
			
			for(int i=1; i<= nColumnas; i++){
				System.out.println("Indice column:  " + i);
				System.out.println("Nombre:  " +rsmd.getColumnName(i));
				System.out.println("Tipo:  "+rsmd.getColumnType(i));
				System.out.println("es nula?:  "+rsmd.isNullable(i));
				System.out.println("Tama�o:  "+rsmd.getColumnDisplaySize(i));
				System.out.println("--------------------------------------");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}	
	public void obtenerDatosTabla(String nombretabala){
		try{
			Statement sta= con.createStatement();
			ResultSet rs= sta.executeQuery("SELECT * from " + nombretabala);
			
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()){
				System.out.println("User: " + rs.getString(2));
				System.out.println("Pass: " + rs.getString(3));
				System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void leerDatosUsuarios(){
		try{
		//Creamos una statement - Consulta
		Statement sta = con.createStatement();
		//ejecutamos la sentencia y la metemos en un objeto resulset
		ResultSet rs = sta.executeQuery("SELECT * from wp_users");
		//recorremos el resultado
		while(rs.next()){
			System.out.println("User: " + rs.getString(2));
			System.out.println("Pass: " + rs.getString(3));	
			System.out.println("------------------------------------------");	
		}
		rs.close();
		sta.close();
		
		}catch(SQLException e){
			e.printStackTrace();
		}	
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub`
		
		//MetaData accJDBC = new MetaData();
		//accJDBC.crearConexion("bolsas");
		//accJDBC.leerDatos();
		//accJDBC.obtenerInfoBBDD();
		
		//accJDBC.obtenerInfoResultSet();

		//accJDBC.obtenerInfoTabla("bolsas");

		//accJDBC.cerrarConexion();
		
	}

}
