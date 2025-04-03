package persistencia;

import java.io.File;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;

public class TreeController {
   
    @FXML
    private TreeView<String> tree1;
    
    @FXML
    private void initialize() {         
try {
	// Crear el contexto
	JAXBContext contexto = JAXBContext.newInstance(Tutorial.class);
    Unmarshaller um = contexto.createUnmarshaller();

    // Carga datos de XML que se cargarán en un TreeView
    Tutorial tutorialBean = (Tutorial) um.unmarshal(new File("xml/prueba_r.xml"));
 	        
 	        // Ítems para el TreeView
 	        // Ítem raíz
 	        TreeItem<String> rootItem = new TreeItem<String>("Tutorial");

 	        // Ítems por cada campo de la clase
 	        TreeItem<String> nameItem = new TreeItem<String>(tutorialBean.getName());
 	        TreeItem<String> descripcionItem = new TreeItem<String>(tutorialBean.getDescripcion());
 	        TreeItem<String> horasItem = new TreeItem<String>("Horas = " + tutorialBean.getHoras());
 	        
 	        // Ítem raíz de profesor
 	        TreeItem<String> profesorItem = new TreeItem<String>("Profesor");
 	        profesorItem.getChildren().add(new TreeItem<String>(tutorialBean.getProfesor().getNombre()));
 	        profesorItem.getChildren().add(new TreeItem<String>(tutorialBean.getProfesor().getApellido1()));
 	        profesorItem.getChildren().add(new TreeItem<String>(tutorialBean.getProfesor().getApellido2()));
 	        profesorItem.getChildren().add(new TreeItem<String>("Experiencia = " + tutorialBean.getProfesor().getExperiencia() + " años"));
 	        
 	        // Ítem raíz de contenidos
 	        TreeItem<String> contenidosItem = new TreeItem<String>("Contenidos");
 	        for (String tema : tutorialBean.getContenidos()){
 	        	contenidosItem.getChildren().add(new TreeItem<String>(tema));
 	        }
 	        
 	        // Se añaden los diferentes ítems en el elemento TreeItem
 	        rootItem.getChildren().add(nameItem);
 	        rootItem.getChildren().add(descripcionItem);
 	        rootItem.getChildren().add(horasItem);
 	        rootItem.getChildren().add(profesorItem);
 	        rootItem.getChildren().add(contenidosItem);
 	        
 	        // Para que sea editable necesitamos especificar un CellFactory con el tipo que corresponda
 	        tree1.setCellFactory(TextFieldTreeCell.forTreeView());
 	        
 	        // Expadimos por defecto el ítem raíz
 	        rootItem.setExpanded(true); 
 	        tree1.setRoot(rootItem);
   				 
			// Obtener un objeto Marshaller para ese contexto
	        Marshaller objeto = contexto.createMarshaller();
	        
	        //Prueba prueba = new Prueba("AAAA", 1);
	        
	        Tutorial tutorial = new Tutorial(1, "Web", "Curso de web",
	        		new Profesor("Miguel", "Alba", "Pino", 10),
	        		100, Arrays.asList(new String[] { "JavaScript", "CSS", "Bootstrap"}));
	         
	        // Llamar al método marshal para efectuar la operación Marshall al objeto Java en el stream especificado
	        objeto.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	        objeto.marshal(tutorial, new File("xml/prueba_w.xml"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       
    }
    
}
