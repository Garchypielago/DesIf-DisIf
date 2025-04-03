package persistencia;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@XmlRootElement(name = "profesor")
@XmlType(propOrder={"nombre", "apellido1" , "apellido2", "experiencia"})
public class Profesor {
	private StringProperty nombre;
	private StringProperty apellido1;
	private StringProperty apellido2;
	private IntegerProperty experiencia;
	
	public Profesor() {
		this("", "", "", 0); // Necesario inicializar para que existan los objetos observable
	}
	
	public Profesor(String nombre, String apellido1, String apellido2, Integer experiencia) {
		super();
		this.nombre = new SimpleStringProperty(nombre);
		this.apellido1 = new SimpleStringProperty(apellido1);
		this.apellido2 = new SimpleStringProperty(apellido2);
		this.experiencia = new SimpleIntegerProperty(experiencia);
	}

	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre.get();
	}
	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}

	@XmlElement(name="apellido1")
	public String getApellido1() {
		return apellido1.get();
	}
	public void setApellido1(String apellido1) {
		this.apellido1.set(apellido1);
	}

	@XmlElement(name="apellido2")
	public String getApellido2() {
		return apellido2.get();
	}
	public void setApellido2(String apellido2) {
		this.apellido2.set(apellido2);
	}

	@XmlElement(name="experiencia")
	public Integer getExperiencia() {
		return experiencia.get();
	}
	public void setExperiencia(Integer experiencia) {
		this.experiencia.set(experiencia);
	}
	
	public StringProperty nombreProperty() {
		return this.nombre;
	}
	
	public StringProperty apellido1Property() {
		return this.apellido1;
	}
	
	public StringProperty apellido2Property() {
		return this.apellido2;
	}
	
	public IntegerProperty experienciaProperty() {
		return this.experiencia;
	}
	
	
}
