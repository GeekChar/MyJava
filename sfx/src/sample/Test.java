package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Test extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        VBox pane = new VBox();
        Button button = new Button("点我对象+1");
        button.setOnMouseClicked(e->{
            Button buttonx = new Button();
            pane.getChildren().add(buttonx);
        });
        pane.getChildren().add(button);
        Scene scene = new Scene(pane,400,400);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }
}
