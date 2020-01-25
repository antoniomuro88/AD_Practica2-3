package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// default package
// Generated 19-ene-2020 6:11:21 by Hibernate Tools 5.4.7.Final
@Entity
@Table(name = "clientes")
/**
 * ClientesPOJO generated by hbm2java
 */
public class ClientesPOJO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCliente")
	private Integer idCliente;
	@Column(name = "nombreCliente")
	private String nombreCliente;
	@Column(name = "apellidosCliente")
	private String apellidosCliente;
	@Column(name = "emailCliente")
	private String emailCliente;
	@Column(name = "dniCliente")
	private String dniCliente;
	@Column(name = "claveCliente")
	private String claveCliente;

	public ClientesPOJO() {
	}

	public ClientesPOJO(int idEscrito) {
		this.idCliente = idEscrito;
	}

	public ClientesPOJO(String nombreCliente, String apellidosCliente, String emailCliente, String dniCliente,
			String claveCliente) {
		this.nombreCliente = nombreCliente;
		this.apellidosCliente = apellidosCliente;
		this.emailCliente = emailCliente;
		this.dniCliente = dniCliente;
		this.claveCliente = claveCliente;
	}

	public ClientesPOJO(int idScanner, String apellidoScanner) {
		this.idCliente = idScanner;
		this.apellidosCliente = apellidoScanner;
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return this.nombreCliente;

	}

	public void setNombre(String nombre) {
		this.nombreCliente = nombre;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidosCliente() {
		return this.apellidosCliente;
	}

	public void setApellidosCliente(String apellidosCliente) {
		this.apellidosCliente = apellidosCliente;
	}

	public String getEmailCliente() {
		return this.emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getDniCliente() {
		return this.dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getClaveCliente() {
		return this.claveCliente;
	}

	public void setClaveCliente(String claveCliente) {
		this.claveCliente = claveCliente;
	}
}
 