package com.example.ej83;

import com.example.ej83.objects.DateUtil;
import com.example.ej83.objects.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Optional;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person,String> firstNameColumn;
    @FXML
    private TableColumn<Person,String> secondNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label secondNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label birthdayLabel;

    private Ej8_3Application application;

//    @FXML
//    private void initialize() {
//        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
//        secondNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
//        personTable.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldValue, newValue) -> showPersonDetails(newValue)
//        );
//        showPersonDetails(null);
//    }
//
//    private void showPersonDetails(Person person) {
//        if (person != null) {
//            firstNameLabel.setText(person.getFirstName());
//            secondNameLabel.setText(person.getLastName());
//            streetLabel.setText(person.getStreetAddress());
//            cityLabel.setText(person.getCity());
//            postalCodeLabel.setText(person.getPostalCode());
//            birthdayLabel.setText(DateUtil.format(person.getBirthDate())); // Usa DateUtil para formatear
//        } else {
//            // Limpiar etiquetas si no hay selección
//            firstNameLabel.setText("");
//            secondNameLabel.setText("");
//            streetLabel.setText("");
//            cityLabel.setText("");
//            postalCodeLabel.setText("");
//            birthdayLabel.setText("");
//        }
//    }

    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        secondNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        // Listener para mostrar detalles al seleccionar fila
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue)
        );
    }

    private void showPersonDetails(Person person) {
        if (person != null) {
            firstNameLabel.setText(person.getFirstName());
            secondNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreetAddress());
            cityLabel.setText(person.getCity());
            postalCodeLabel.setText(person.getPostalCode());
            birthdayLabel.setText(DateUtil.format(person.getBirthDate()));
        } else {
            // Limpiar campos si no hay selección
            firstNameLabel.setText("");
            secondNameLabel.setText("");
            streetLabel.setText("");
            cityLabel.setText("");
            postalCodeLabel.setText("");
            birthdayLabel.setText("");
        }
    }



    public void setApplication(Ej8_3Application application) {
        this.application = application;
        personTable.setItems(this.application.getPeopleData());
    }

    @FXML
    private void handleNewPerson() {
        Dialog<Person> dialog = new Dialog<>();
        dialog.setTitle("New Contact");
        dialog.initOwner(application.getPrimaryStage());

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("PersonEditDialog.fxml"));
            DialogPane dialogPane = loader.load();

            dialog.setDialogPane(dialogPane);
            PersonEditDialogController controller = loader.getController();
            controller.setDialog(dialog);

            Optional<Person> result = dialog.showAndWait();
            result.ifPresent(person -> application.getPeopleData().add(person));

        } catch (IOException e) {
            // Mostrar error detallado
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Failed to load dialog");
            alert.setContentText("Check the FXML file for syntax errors: " + e.getMessage());
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEditPerson() {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

        if (selectedPerson == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al editar");
            alert.setHeaderText("No se ha seleccionado ninguna fila");
            alert.setContentText("Por favor, selecciona una persona en la tabla.");
            alert.showAndWait();
            return;
        }

        // Abrir diálogo de edición
        Dialog<Person> dialog = new Dialog<>();
        dialog.setTitle("Editar Contacto");
        dialog.initOwner(application.getPrimaryStage());

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PersonEditDialog.fxml"));
            DialogPane dialogPane = loader.load();
            dialog.setDialogPane(dialogPane);

            PersonEditDialogController controller = loader.getController();
            controller.setDialog(dialog);
            controller.loadPersonData(selectedPerson); // Cargar datos en el diálogo

            Optional<Person> result = dialog.showAndWait();
            result.ifPresent(updatedPerson -> {
                // Actualizar datos de la persona seleccionada
                selectedPerson.setFirstName(updatedPerson.getFirstName());
                selectedPerson.setLastName(updatedPerson.getLastName());
                selectedPerson.setStreetAddress(updatedPerson.getStreetAddress());
                selectedPerson.setCity(updatedPerson.getCity());
                selectedPerson.setPostalCode(updatedPerson.getPostalCode());
                selectedPerson.setBirthDate(updatedPerson.getBirthDate());

                // Refrescar la tabla
                personTable.refresh();
            });

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("No se pudo cargar el diálogo: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void handleDeletePerson() {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();

        if (selectedPerson == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error al eliminar");
            alert.setHeaderText("No se ha seleccionado ninguna fila");
            alert.setContentText("No se puede eliminar porque no ha seleccionado una fila o la tabla está vacía.");
            alert.showAndWait();
            return;
        }

        // Diálogo de confirmación
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Confirmar eliminación");
        confirmation.setHeaderText("¿Está seguro de eliminar la fila actual?");
        confirmation.setContentText("Esta acción no se puede deshacer.");

        Optional<ButtonType> result = confirmation.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            application.getPeopleData().remove(selectedPerson);
        }
    }



}