package hibernate;

import java.util.Scanner;

import hibernate.ClientesPOJO;
import hibernate.HotelManager;
import javax.persistence.Entity;

import org.hibernate.ObjectNotFoundException;

public class HotelPrincipal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		crearClienteP(sc);
		leerCliente(sc);
		modificarCliente(sc);
		eliminarCliente(sc);

	}

	private static void eliminarCliente(Scanner sc) {
		System.out.println("Escriba el id del cliente que desea eliminar:");
		boolean pass = false;
		while (!pass) {
			try {
				int idScanner = Integer.parseInt(sc.nextLine());
				pass = true;
				ClientesPOJO cl4 = new ClientesPOJO(idScanner);
				HotelManager.deleteClientes(cl4);
			} catch (Error e) {
				System.out.println("El ID '\"+idScanner+\"' no existe, pruebe de nuevo:");
			}
		}
	}

	private static void modificarCliente(Scanner sc) {
		boolean pass = false;
		System.out.println("Escriba el ID del Cliente al que desea cambiar el apellido:");
		int idScanner = 0;
		while (!pass) {
			try {
				idScanner = Integer.parseInt(sc.nextLine());
				pass = true;
			} catch (Error e) {
				System.out.println("El ID '" + idScanner + "' no existe, pruebe de nuevo:");
			}
		}
		System.out.println("Escriba un nuevo apellido para el Cliente con ID '" + idScanner + "': ");
		String apellidoScanner = sc.nextLine();
		ClientesPOJO cl3 = new ClientesPOJO(idScanner, apellidoScanner);
		HotelManager.updateClientes(cl3);
	}

	private static void crearClienteP(Scanner sc) {
		ClientesPOJO cl1 = creacionClientes(sc);
		HotelManager.crearCliente(cl1);
	}

	private static void leerCliente(Scanner sc) {
		boolean pass = false;

		System.out.println("Para consultar un cliente escriba su ID: ");
		while (!pass) {
			try {
				String teclado = sc.nextLine();
				int idScanner = Integer.parseInt(teclado);
				pass = true;
				HotelManager.readClientes(idScanner);
			} catch (ObjectNotFoundException e) {
				System.out.println("El ID no existe, pruebe de nuevo:");
			} catch (NumberFormatException e) {
				System.out.println("El ID NO puede estar vacío");
			}

		}
	}

	private static ClientesPOJO creacionClientes(Scanner sc) {
		System.out.println("Escriba el nombre del Cliente: ");
		String nombreScanner = sc.nextLine();
		System.out.println("Escriba el apellido del Cliente: ");
		String apellidoScanner = sc.nextLine();
		System.out.println("Escriba el correo electrónico del Cliente: ");
		String correoScanner = sc.nextLine();
		System.out.println("Escriba el DNI del Cliente: ");
		String dniScanner = sc.nextLine();
		System.out.println("Escriba la clave del Cliente: ");
		String claveScanner = sc.nextLine();
		ClientesPOJO cl1 = new ClientesPOJO(nombreScanner, apellidoScanner, correoScanner, dniScanner, claveScanner);
		return cl1;
	}
}
