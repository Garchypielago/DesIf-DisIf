package basicoEstatico;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MainEstatico extends Application {
	private GridPane rootLayout;	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el diseño del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainEstatico.class.getResource("ControlesEstaticos.fxml"));
			rootLayout = (GridPane) loader.load();

			// Mostramos la escena del BorderPane de la variable rootLayot
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ejemplo sobre controles");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
