package ru.fkr.app;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.apache.log4j.Logger;

public class MainApp extends Application {

    //private static final Logger log = LoggerFactory.getLogger(MainApp.class);
    private static final Logger log = Logger.getLogger(MainApp.class);
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

        log.info("Starting Hello JavaFX and Maven demonstration application");
        System.out.println("Starting Hello JavaFX and Maven demonstration application");
        String fxmlFile = "/fxml/hello.fxml";
        log.debug("Loading FXML for main view from: {}"+ fxmlFile);
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));

        log.debug("Showing JFX scene");
        Scene scene = new Scene(rootNode, 400, 200);
        scene.getStylesheets().add("/styles/styles.css");
        
       /* scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("mouse click detected! "+event.getSource());
            }
        });

        Button button = new Button("click here");
        root.getChildren().add(button);
*/
        stage.setTitle("Hello JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
        //ListDevices.getListDevices();
        //HotPlug.hotPlugRun();
    }
}
