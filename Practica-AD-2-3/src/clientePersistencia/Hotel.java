package clientePersistencia;

import javax.persistence.Entity;

@Entity
public class Hotel {
	public static void main(String[] args) {
		int id = ClientePersistencia.createCliente("Antonio", "Muñoz", "antoniomuro88@gmail.com", "77815739T",
				"Studium2019;");
		System.out.println(ClientePersistencia.readCliente(id, "nombre"));
		System.out.println(ClientePersistencia.readCliente(id, "apellidos"));
		System.out.println(ClientePersistencia.readCliente(id, "email"));
		System.out.println(ClientePersistencia.readCliente(id, "dni"));
		System.out.println(ClientePersistencia.readCliente(id, "clave"));
		ClientePersistencia.updateCliente(id, "apellidos", "Muñoz Rodríguez");
		System.out.println(ClientePersistencia.readCliente(id, "apellidos"));
		ClientePersistencia.deleteCliente(id);
		System.out.println(ClientePersistencia.readCliente(id, "nombre"));
	}
}
