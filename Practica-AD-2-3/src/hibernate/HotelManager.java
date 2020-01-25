package hibernate;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
public class HotelManager {
	private static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		return sessionFactory;
	}

	public static void crearCliente(ClientesPOJO p) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.save(p);
		transObj.commit();
		sessionObj.close();
		System.out.println("El cliente '" + p.getNombreCliente() + " " + p.getApellidosCliente() + "' con ID: '"
				+ p.getIdCliente() + "' se ha insertado con éxito");
	}

	public static void readClientes(int idScanner) {
		String c = "FROM ClientesPOJO";
		Session sessionObj = getSessionFactory().openSession();
		List<ClientesPOJO> results = sessionObj.createQuery(c, ClientesPOJO.class).list();
		Iterator<ClientesPOJO> pIterator = results.iterator();
		while (pIterator.hasNext()) {
			ClientesPOJO a2 = pIterator.next();
			if (a2.getIdCliente() == idScanner) {
				System.out.println(" -Id: '" + a2.getIdCliente() + "'\n -Nombre: '" + a2.getNombreCliente()
						+ "'\n -Apellidos: '" + a2.getApellidosCliente() + "'\n -Email: '" + a2.getEmailCliente()
						+ "'\n -DNI: '" + a2.getDniCliente() + "'\n -Clave: '" + a2.getClaveCliente() + "'");
			}
		}
		sessionObj.close();

	}

	public static void updateClientes(ClientesPOJO c3) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		ClientesPOJO p3 = sessionObj.load(ClientesPOJO.class, c3.getIdCliente());
		Integer elid = c3.getIdCliente();
		String elape = c3.getApellidosCliente();
		String elnom = c3.getApellidosCliente();
		System.out.println("-ID: '" + elid + "' - Nombre: '" + elnom + "' - Nuevos Apellidos: " + elape);

		try {
			p3.setApellidosCliente(elape);
			transObj.commit();
			sessionObj.close();
			System.out.println("Apellidos actualizados correctamente");
		} catch (NumberFormatException e) {
			System.out.println("El ID NO puede estar vacío");
		}

	}

	public static void deleteClientes(ClientesPOJO cl4) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		ClientesPOJO clienteBD = sessionObj.load(ClientesPOJO.class, cl4.getIdCliente());
		sessionObj.delete(clienteBD);
		transObj.commit();
		sessionObj.close();
		System.out.println("Cliente '" + clienteBD.getNombreCliente() + " " + clienteBD.getApellidosCliente()
				+ "'con ID '" + clienteBD.getIdCliente() + "' eliminado con éxito");
	}

}
