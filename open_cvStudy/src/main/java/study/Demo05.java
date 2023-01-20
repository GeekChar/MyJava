package study;
import nu.pattern.OpenCV;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;


public class Demo05 {
    public static void main(String[] args) {
        OpenCV.loadLocally();
        String filePath = Demo05.class.getClassLoader().getResource("kunkun.jpg").getPath().replaceFirst("/", "");
        Mat mat = Imgcodecs.imread(filePath);
        Mat dst=new Mat(mat.rows(),mat.cols(),CvType.CV_8UC3);
        Core.add(mat,new Scalar(50,50,50),dst);
        HighGui.imshow("mat",mat);
        HighGui.imshow("dst",dst);
        HighGui.waitKey(0);
        System.exit(0);
    }
}
