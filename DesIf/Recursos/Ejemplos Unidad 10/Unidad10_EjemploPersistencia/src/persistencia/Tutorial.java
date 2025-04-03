package persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@XmlRootElement(name = "mytutorial")
@XmlType(propOrder={"name", "descripcion" , "horas", "profesor", "contenidos"})
public class Tutorial {
	private IntegerProperty id;
	private StringProperty name;
	private StringProperty descripcion;
	private IntegerProperty horas;
	private Profesor profesor;
	private ObservableList<String> contenidos;	
	
	public Tutorial() {
		// ES necesario inicializar para que JAXB pueda crear los objetos de tipo Observable
		this(0, "", "", new Profesor(), 0, new ArrayList<String>());
	}
		
	public Tutorial(Integer id, String name, String descripcion, Profesor profesor, 
			Integer horas, List<String> contenidos) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.descripcion = new SimpleStringProperty(descripcion);
		this.horas = new SimpleIntegerProperty(horas);
		this.profesor = profesor;
		this.contenidos = FXCollections.observableArrayList(contenidos);
	}
	
	@XmlAttribute(name="id") // Será atributo de la etiqueta
	public Integer getId() {
		return this.id.get();
	}
	public void seId(Integer id) {
		this.id.set(id);
	}

	@XmlElement(name="name")
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	
	@XmlElement(name="descripcion")
	public String getDescripcion() {
		return descripcion.get();
	}
	public void setDescripcion(String descripcion) {
		this.descripcion.set(descripcion);
	}
	
	@XmlElement(name="horas")
	public Integer getHoras() {
		return this.horas.get();
	}
	public void setHoras(Integer horas) {
		this.horas.set(horas);
	}
	
	@XmlElement(name="profesor")
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@XmlElementWrapper(name="contenidos")
    @XmlElement(name="tema")
	public List<String> getContenidos() {
		return contenidos;
	}
	public void setContenidos(List<String> contenidos) {
		this.contenidos = FXCollections.observableArrayList(contenidos);
	}

	public IntegerProperty idProperty() {
		return this.id;
	}
	public StringProperty nameProperty() {
		return this.name;
	}
	public StringProperty descripcionProperty() {
		return this.descripcion;
	}
	public IntegerProperty horasProperty() {
		return this.horas;
	}
	public ObservableList<String> contenidosProperty(){
		return this.contenidos;
	}
	
}
