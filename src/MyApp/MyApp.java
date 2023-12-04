package MyApp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.InputStream;



public class MyApp extends Application {

    //SINGLETON
    public static MyApp instance;
    Stage primaryStage;
    BorderPane rootLayout;
    public static void run(String []args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        if(instance == null){
            instance = this; //singleton zuweisen
        }

        primaryStage.setTitle("Shell Game");
        primaryStage.setWidth(1024);
        primaryStage.setHeight(768);
        primaryStage.setResizable(false);

        setIcon();
        initRootLayout();
        loadView("ShellGameView");

        primaryStage.show();
    }

    void setIcon(){
        InputStream iconStream = getClass().getResourceAsStream("/images/shell.png");
        Image image = new Image(iconStream);
        primaryStage.getIcons().add(image);

    }

    public void initRootLayout(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/MyApp/View/StartView.fxml"));
            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);


        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadView(String newView) throws IOException {

        String viewPath = "/MyApp/View/" + newView + ".fxml";

        rootLayout.getChildren().remove(rootLayout.getCenter());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(viewPath));

        Pane pane = loader.load();
        rootLayout.setCenter(pane);
    }

    public void shutdown(){
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void showAboutBox() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("My App");
        alert.setHeaderText("My App 2023");
        alert.setContentText("This is a Shell Game");
        alert.show();

    }
}
