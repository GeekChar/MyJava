package study;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Demo01 {
    public static void main(String[] args) throws Exception {
            Robot robot = new Robot();
            //截取屏幕
            BufferedImage bufferedImage = robot.createScreenCapture(new Rectangle(0, 0, 1920, 1080));
            //保存到本地
            ImageIO.write(bufferedImage,"jpg",new File("D:\\1.jpg"));
    }
}
