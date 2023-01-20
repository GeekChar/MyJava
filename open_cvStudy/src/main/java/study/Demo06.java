package study;

import nu.pattern.OpenCV;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Demo06 {
    public static void main(String[] args) {
        OpenCV.loadLocally();
        Mat kunKun = Imgcodecs.imread(Demo03.class.getClassLoader().getResource("kunkun.jpg").getPath().replaceFirst("/",""));
        Mat iKun = Imgcodecs.imread(Demo03.class.getClassLoader().getResource("ikun.jpg").getPath().replaceFirst("/",""));
        //现在我们要将kun 和 ikun 两张图片混合
//        Core.addWeighted();
    }
}
