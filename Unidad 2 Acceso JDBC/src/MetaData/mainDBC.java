package MetaData;

public class mainDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MetaData accJDBC = new MetaData();
		accJDBC.crearConexion("bolsas","remotoODBC","remotoODBC");
		
		
		//accJDBC.obtenerInfoBBDD("bolsas");
		//accJDBC.obtenerInfoTabla("bolsas");
		//accJDBC.obtenerInfoResultSet("bolsas");

		//accJDBC.obtenerDatosTabla("bolsas");
		
		accJDBC.leerDatosUsuarios();
		
		accJDBC.cerrarConexion();
		
		
	}

}
