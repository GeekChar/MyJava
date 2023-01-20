package study;
import nu.pattern.OpenCV;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
public class Demo03 {
    public static void main(String[] args) {
        OpenCV.loadLocally();
        //使用Imgcodes 读取 图片
        Mat mat = Imgcodecs.imread(Demo03.class.getClassLoader().getResource("yellow.jpg").getPath().replaceFirst("/",""));
        //Mat为 一般彩色图像读进内存之后是一个h * w * c的矩阵，其中h为图像高(相当于矩阵的行)，w为图像宽(相当于矩阵列)，c为通道数。
        //总行数
        int rows = mat.rows();
        //总列数
        int cols = mat.cols();
        //总通道数
        int channels = mat.channels();
        //遍历mat
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //得到的是 i行j列 的像素点的数据
                double[] data = mat.get(i, j);
                String temp="(";
                for (int k = 0; k < channels; k++) {
                    temp+=(int)data[k]+",";
                }
              temp=temp.substring(0,temp.length()-1);
                temp+=") ";
                System.out.print(temp);
            }
            System.out.println();
        }
    }
}
