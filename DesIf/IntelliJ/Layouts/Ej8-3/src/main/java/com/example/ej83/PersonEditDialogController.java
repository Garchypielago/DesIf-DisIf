package com.example.ej83;

import com.example.ej83.objects.Person;
import com.example.ej83.objects.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PersonEditDialogController {
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField streetField;
    @FXML private TextField cityField;
    @FXML private TextField postalCodeField;
    @FXML private TextField birthdayField;

    private Dialog<Person> dialog;

    @FXML
    private void initialize() {}

    public void setDialog(Dialog<Person> dialog) {
        this.dialog = dialog;

        dialog.setResultConverter(buttonType -> {
            if (buttonType.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                return createPersonFromInput(); // Devuelve la persona si es válida
            }
            return null;
        });
    }

    private Person createPersonFromInput() {
        StringBuilder errors = new StringBuilder();

        if (firstNameField.getText().isEmpty()) errors.append("- First name is empty\n");
        if (lastNameField.getText().isEmpty()) errors.append("- Last name is empty\n");
        if (streetField.getText().isEmpty()) errors.append("- Street is empty\n");
        if (cityField.getText().isEmpty()) errors.append("- City is empty\n");

        int postalCode = -1;
        try {
            postalCode = Integer.parseInt(postalCodeField.getText());
        } catch (NumberFormatException e) {
            errors.append("- Postal code must be numeric\n");
        }

        if (!DateUtil.validDate(birthdayField.getText())) {
            errors.append("- Invalid date format (use dd/mm/yyyy)\n");
        }

        if (!errors.isEmpty()) {
            showAlert(errors.toString());
            return null;
        }

        return new Person(
                firstNameField.getText(),
                lastNameField.getText(),
                streetField.getText(),
                cityField.getText(),
                postalCodeField.getText(),
                DateUtil.parse(birthdayField.getText())
        );
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Invalid Data");
        alert.setHeaderText("Correct the following errors:");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void loadPersonData(Person person) {
        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        streetField.setText(person.getStreetAddress());
        cityField.setText(person.getCity());
        postalCodeField.setText(person.getPostalCode());
        birthdayField.setText(DateUtil.format(person.getBirthDate()));
    }
}
