package study;

import nu.pattern.OpenCV;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class Demo02 {
    public static void main(String[] args) {
        //1.加载OpenCV驱动
        OpenCV.loadLocally();
        //使用Imgcodes 读取 图片
        Mat mat = Imgcodecs.imread(Demo02.class.getClassLoader().getResource("1.jpg").getPath().replaceFirst("/",""));
        //使用HighGui显示读取的图片
        HighGui.imshow("first",mat);
        //阻塞线程
        HighGui.waitKey(0);
        //退出程序
        System.exit(0);
    }
}
