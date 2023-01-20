import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import nu.pattern.OpenCV;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import utils.Timer;
import utils.TimerTask;


import java.awt.image.BufferedImage;

public  class TestColor3 extends Application implements TimerTask {
    AnchorPane anchorPane;
 private    Mat mat;
    private Mat temp;
    int count=1;
    public static void main(String[] args) {
        System.out.println(2112);
        OpenCV.loadLocally();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        mat = Imgcodecs.imread(TestColor3.class.getClassLoader().getResource("").getPath().replaceFirst("/", "") + "1.png");
        ImageView view = getImageView(mat);
        //0-130
        temp=new Mat(mat.rows(),mat.cols(),CvType.CV_8UC3);
//        Imgproc.applyColorMap(mat,temp, Imgproc.COLOR_BayerBG2BGR);
        anchorPane = new AnchorPane();
        anchorPane.getChildren().add(view);
        stage.setScene(new Scene(anchorPane));
        new Timer(this,2000L).start();
        stage.show();
    }

    private ImageView getImageView(Mat mat) {
        return new ImageView(SwingFXUtils.toFXImage((BufferedImage) HighGui.toBufferedImage(mat), null));
    }


    @Override
    public void run() {
        Platform.runLater(()->{
            count++;
            Imgproc.applyColorMap(mat,temp,count);
            ImageView imageView = getImageView(temp);
            anchorPane.getChildren().add(imageView);
        });
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.exit(0);
    }
}
