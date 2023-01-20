package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import sun.plugin2.ipc.windows.WindowsEvent;

import java.util.Properties;

public class Main extends Application {
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
         this.stage =stage;
        VBox borderPane = new VBox();
        Button button = new Button();
        button.setText("点我");
        String path=System.getProperty("user.dir");
        path+="\\src\\resource\\icon.png";
        System.out.println(path);
        BackgroundImage background = new BackgroundImage(new Image("File:"+path), null, null, null, null);
        borderPane.getChildren().add(button);
        Scene scene = new Scene(borderPane,350,350);
        button.setOnMouseClicked((e)->{
            VBox vBox = new VBox();
            Scene scene1 = new Scene(vBox, 900, 900);
            vBox.setBackground(new Background(background));
            Button button1 = new Button("返回");
            button1.setOnMouseClicked((f)->{
                stage.setScene(scene);
            });
            vBox.getChildren().add(button1);
            stage.setScene(scene1);

        });

        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("初始化...........");
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("程序结束");
    }

    public static void main(String[] args) {
        launch(args);
    }
}

