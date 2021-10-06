/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_t1a1_444modalno;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class DI_Modality_None extends Application {

    @Override
    public void start(final Stage primaryStage) {
        //Añadimos titulo a nuestra ventana principal
        primaryStage.setTitle("Dialog");
        //Añadimos nodo primario
        Group root = new Group();
        //Creamos una escena con dicho nodo
        Scene scene = new Scene(root, 400, 300, Color.WHITE);

        //Escogemos la escena para la stage
        primaryStage.setScene(scene);
        //Mostramos la Stage
        primaryStage.show();

        //Creamos una Stage que pertenece a la case MyDialog
        Stage myDialog = new MyDialog(primaryStage);
        //Ajustamos el tamaño de la escena y ventana al contenido
        myDialog.sizeToScene();
        //Mostramos el dialogo
        myDialog.show();

    }
}

//Creamos la clase MyDialog
class MyDialog extends Stage {
    //Constructor
    public MyDialog(Stage owner) {
        //Permitimo el uso de caracteristicas y metodos del padre (Stage)
        super();
        //Decimos que la clase MyDialog pertenecce a la clase "owner" que al declarar
        //la instancia anteriormente dijimos que era "primaryStage"
        initOwner(owner);
        //Esogemos titulo para la ventana
        setTitle("title");
        //Decimos el tipo de modalidad que tiene NO MODAL
        initModality(Modality.NONE);
        //Creamos un nodo root con layout group
        Group root = new Group();
        //Creamos escena
        Scene scene = new Scene(root, 250, 150, Color.WHITE);
        //Asignamos escena a la ventana
        setScene(scene);

        //Añadimos un layout gridPane con padding, Hgap y Vgap de 5
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(5);
        gridpane.setVgap(5);

        //Creamos etiqueta y la añadimos al gridPane
        Label userNameLbl = new Label("User Name: ");
        gridpane.add(userNameLbl, 0, 1);

        //Creamos etiqueta y la añadimos al gridPane
        Label passwordLbl = new Label("Password: ");
        gridpane.add(passwordLbl, 0, 2);
        
        //Creamos textField y la añadimos al gridPane
        final TextField userNameFld = new TextField("Admin");
        gridpane.add(userNameFld, 1, 1);

        //Creamos password y la añadimos al gridPane
        final PasswordField passwordFld = new PasswordField();
        passwordFld.setText("password");
        gridpane.add(passwordFld, 1, 2);

        //Añadimso boton, le añadimos evento para que al pulsarlo cierre
        //la ventana y la añadimos al gridPane
        Button login = new Button("Change");
        login.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                close();
            }
        });
        gridpane.add(login, 1, 3);
        //Alineamos en orientación horizontal en la posición right al boton "login"
        GridPane.setHalignment(login, HPos.RIGHT);
        //Añadimos gridPane al root
        root.getChildren().add(gridpane);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
