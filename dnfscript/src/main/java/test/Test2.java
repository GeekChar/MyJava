package test;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.opencv.core.Mat;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Test2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Robot robot = new Robot();
            Thread.sleep(2000L);
            BufferedImage capture = robot.createScreenCapture(new Rectangle(405,145,800,600));
            WritableImage writableImage = SwingFXUtils.toFXImage(capture, null);
            ImageView imageView = new ImageView(writableImage);
            AnchorPane anchorPane = new AnchorPane();
            anchorPane.getChildren().add(imageView);
            Scene scene = new Scene(anchorPane);
            boolean jpg = ImageIO.write(capture, "jpg", new FileImageOutputStream(new File("6.jpg")));
            stage.setScene(scene);

        } catch (AWTException e) {
            e.printStackTrace();
        }
        stage.show();
    }
}
