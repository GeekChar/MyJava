import nu.pattern.OpenCV;
import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Test2 {
    public static void main(String[] args) {
        //加载驱动
        OpenCV.loadLocally();
        Mat mat = Imgcodecs.imread(Test2.class.getClassLoader().getResource("").getPath().replaceFirst("/", "") + "1.png");
        Mat logo = Imgcodecs.imread(Test2.class.getClassLoader().getResource("").getPath().replaceFirst("/", "") + "logo.jpg");
        Mat zeros = new Mat(new Size(mat.width(),mat.height()),CvType.CV_8UC3,new Scalar(255,255,255));
        HighGui.namedWindow("0",HighGui.WINDOW_AUTOSIZE);
        HighGui.namedWindow("1",HighGui.WINDOW_NORMAL);
//        Imgproc.resize(logo,zeros,new Size(logo.width(),logo.height()));
        Core.bitwise_and(zeros,mat,mat);
        HighGui.imshow("mat",mat);

        HighGui.imshow("0",zeros);
        HighGui.imshow("1",logo);
        HighGui.waitKey(0);
        System.exit(0);
    }

    private static void reSize(Mat logo, Mat zeros) {
        System.out.println(logo.rows()+"-->"+zeros.rows());
        System.out.println(logo.size()+"-->"+zeros.size());
        System.out.println(logo.channels()+"-->"+zeros.channels());
        for (int i = 0; i < logo.rows(); i++) {
            for (int j = 0; j < logo.cols(); j++) {
                double[] data = logo.get(i, j);
                zeros.put(i+300,j,data);
            }
        }
    }
}
