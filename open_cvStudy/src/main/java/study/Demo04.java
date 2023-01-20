package study;
import nu.pattern.OpenCV;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
public class Demo04 {
    public static void main(String[] args) {
        OpenCV.loadLocally();
        //使用Imgcodes 读取 图片
        Mat mat = Imgcodecs.imread(Demo03.class.getClassLoader().getResource("yellow.jpg").getPath().replaceFirst("/",""));
        //复制一个 做对比
        Mat clone = mat.clone();
        //将mat 变成红色
        for (int i = 0; i < mat.rows(); i++) {
            for (int j = 0; j < mat.cols(); j++) {
                double[] temp={0,0,255};
                mat.put(i,j,temp);
            }
        }
        HighGui.imshow("mat",mat);
        HighGui.imshow("mat_clone",clone);
        HighGui.moveWindow("mat",550,550);
        HighGui.moveWindow("mat_clone",680,550);
        HighGui.waitKey(0);
        System.exit(0);
    }
}
