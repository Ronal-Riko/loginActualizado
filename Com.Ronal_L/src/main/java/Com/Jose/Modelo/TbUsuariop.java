package Com.Jose.Modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_usuariop database table.
 * 
 */
@Entity
@Table(name="tb_usuariop")
@NamedQuery(name="TbUsuariop.findAll", query="SELECT t FROM TbUsuariop t")
public class TbUsuariop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUsuarios;

	private String apellido_usuario;

	private String contrasenia;

	private String nombre_usuario;

	private String usuario;

	//bi-directional many-to-one association to TbHistorial
	@OneToMany(mappedBy="tbUsuariop")
	private List<TbHistorial> tbHistorials;

	public TbUsuariop() {
	}

	public int getIdUsuarios() {
		return this.idUsuarios;
	}

	public void setIdUsuarios(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	public String getApellido_usuario() {
		return this.apellido_usuario;
	}

	public void setApellido_usuario(String apellido_usuario) {
		this.apellido_usuario = apellido_usuario;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre_usuario() {
		return this.nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<TbHistorial> getTbHistorials() {
		return this.tbHistorials;
	}

	public void setTbHistorials(List<TbHistorial> tbHistorials) {
		this.tbHistorials = tbHistorials;
	}

	public TbHistorial addTbHistorial(TbHistorial tbHistorial) {
		getTbHistorials().add(tbHistorial);
		tbHistorial.setTbUsuariop(this);

		return tbHistorial;
	}

	public TbHistorial removeTbHistorial(TbHistorial tbHistorial) {
		getTbHistorials().remove(tbHistorial);
		tbHistorial.setTbUsuariop(null);

		return tbHistorial;
	}

}