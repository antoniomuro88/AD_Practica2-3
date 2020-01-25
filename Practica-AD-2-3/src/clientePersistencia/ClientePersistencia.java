package clientePersistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.persistence.Entity;

@Entity
public class ClientePersistencia {
	private final static String MySQL_DB_USUARIO = "root";
	private final static String MySQL_DB_PASSWORD = "Studium2019;";

	private final static String MySQL_DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String MySQL_DB_URL = "jdbc:mysql://localhost:3306/hotel?serverTimezone=UTC";

	public static synchronized Connection getMySQL_Connection() throws Exception {
		Connection connMySQL;
		try {
			Class.forName(MySQL_DB_DRIVER);
			connMySQL = DriverManager.getConnection(MySQL_DB_URL, MySQL_DB_USUARIO, MySQL_DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new Exception("\nError obteniendo la conexión: " + e.getMessage());
		}
		return connMySQL;
	}

	public static int createCliente(String nombreC, String apellidosC, String emailC, String dniC, String claveC) {
		int idC = 0;
		try {
			Connection conection = getMySQL_Connection();
			String consulta = "INSERT INTO clientes VALUES (null, '" + nombreC + "', '" + apellidosC + "', '" + emailC
					+ "', '" + dniC + "', '" + claveC + "');";
			Statement st = conection.createStatement();
			st.execute(consulta);
			st.close();
			st = conection.createStatement();
			consulta = "SELECT MAX(idCliente) AS 'MAXID' FROM clientes";
			ResultSet rs = st.executeQuery(consulta);
			rs.next();
			int idc = rs.getInt("MAXID");
			idC = idc;
			System.out.println(
					"\nEl cliente '" + nombreC + " " + apellidosC + "' con ID '" + idc + "' se ha creado con éxito");

			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idC;
	}

	public static String readCliente(int idCliente, String campo) {
		String res = "";
		try {
			Connection conection = getMySQL_Connection();
			String consulta = "SELECT * from clientes where idCliente=" + idCliente + ";";
			Statement st;
			st = conection.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			rs.next();
			switch (campo) {
			case "nombre":
			case "Nombre":
				res = rs.getString("nombreCliente");
				break;
			case "apellidos":
			case "Apellidos":
				res = rs.getString("apellidosCliente");
				break;
			case "email":
			case "Email":
				res = rs.getString("emailCliente");
				break;
			case "DNI":
			case "dni":
				res = rs.getString("dniCliente");
				break;
			case "clave":
			case "Clave":
				res = rs.getString("claveCliente");
				break;
			}
			System.out.println("\nEl campo '" + campo + "' del cliente con ID '" + idCliente + "' es: ");
			st.close();
		} catch (SQLException e) {
			System.out.println("\nNo existe ningún cliente con id: " + idCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public static boolean updateCliente(int idCliente, String campo, String nuevoCampo) {
		boolean res = false;
		try {
			Connection conection = getMySQL_Connection();
			String consulta = "SELECT * from clientes where idCliente=" + idCliente + ";";
			Statement st = conection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery(consulta);
			rs.absolute(1);
			switch (campo) {
			case "nombre":
			case "Nombre":
				rs.updateString("nombreCliente", nuevoCampo);
				break;
			case "apellidos":
			case "Apellidos":
				rs.updateString("apellidosCliente", nuevoCampo);
				break;
			case "email":
				rs.updateString("emailCliente", nuevoCampo);
				break;
			case "DNI":
			case "dni":
				rs.updateString("dniCliente", nuevoCampo);
				break;
			case "clave":
			case "Clave":
				rs.updateString("claveCliente", nuevoCampo);
				break;
			}
			rs.updateRow();
			System.out
					.println("\nEl registro con ID '" + idCliente + "' ha recibo una actualización del campo '"+campo+"'");
			st.close();
			res = true;
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}
		return res;
	}

	public static boolean deleteCliente(int idCliente) {
		boolean res = false;
		int idC = 0;
		try {
			Connection conection = getMySQL_Connection();
			String consulta = "DELETE FROM clientes where idCliente =" + idCliente + ";";
			Statement st = conection.createStatement();
			idC = st.executeUpdate(consulta);
			st.close();
		} catch (SQLException e) {
			System.out.println("\nNo existe ningún cliente con id: " + idCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (idC != 0) {
			res = true;
			System.out.println("\nEl cliente con ID '" + idCliente + "' fue borrado correctamente");
		}
		return res;
	}
}
