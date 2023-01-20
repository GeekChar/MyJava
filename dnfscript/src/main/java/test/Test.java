package test;

import static script.KeyCode.*;

import script.Driver;
import script.KeyCode;


public class Test {
    private static int vid=0xC216;
    private static int pid=0x301;
    private static Driver driver = Driver.getRobot(vid,pid);
    public static void main(String[] args) {
            //圣地
            int count =0;
            driver.sleep(2000L);
            test2(count);
    }
    private static void test2(int count){
        while (true){
            count++;
            addBuff();
            rightAndLeftMove(1500L, VK_Right);
            rightAndLeftMove(900L, VK_Right);
            releasesKill(VK_Q);
            rightAndLeftMove(2000L,VK_Right);
            rightAndLeftMove(500L, VK_Right);
            releasesKill(VK_Q);
            rightAndLeftMove(2000L,VK_Right);
            rightAndLeftMove(500L, VK_Right);
            releasesKill(VK_Q);
            rightAndLeftMove(2000L,VK_Right);
            rightAndLeftMove(500L, VK_Right);
            releasesKill(VK_W);
            rightAndLeftMove(2000L,VK_Right);
            rightAndLeftMove(700L, VK_Right);
            releasesKill(VK_F);
            driver.sleep(2000L);
            releasesKill(VK_ESC);
            releasesKill(VK_ESC);
            releasesKill(VK_ESC);
            releasesKill(98);
            releasesKill(VK_X);
            releasesKill(VK_X);
            releasesKill(VK_X);
            releasesKill(VK_X);
            releasesKill(VK_X);
            releasesKill(VK_X);
            releasesKill(VK_X);
            releasesKill(VK_ESC);
            releasesKill(F10);
            releasesKill(VK_ESC);
            releasesKill(F10);
            releasesKill(VK_ESC);
            releasesKill(F10);
            releasesKill(VK_ESC);
            releasesKill(F10);
            releasesKill(VK_ESC);
            releasesKill(F10);
            releasesKill(VK_ESC);
            releasesKill(F10);
            System.out.println("已完成"+count+"次!");
            driver.sleep(5000L);

        }

    }
    private void test1(){//王之摇篮
        while (true){
            driver.sleep(8000L);
            System.out.println("进入游戏开始执行");
            oneHome();
            twoHome();
            threeHome();
            fourHome();
            fiveHome();
            sixHome();
            sevenHome();
        }
    }
    private static void sevenHome() {
        upMove(300L);
        rightAndLeftMove(300L,VK_Left);
        releasesKill(VK_R);
        driver.sleep(2000L);
        releasesKill(98);
        driver.sleep(100L);
        releasesKill(VK_X);
        releasesKill(VK_X);
        releasesKill(VK_X);
        releasesKill(VK_X);
        releasesKill(VK_X);
        releasesKill(VK_X);
        releasesKill(VK_X);
        releasesKill(VK_X);
        releasesKill(VK_X);
        releasesKill(VK_X);
        releasesKill(VK_X);
        driver.sleep(10000L);
        System.out.println("结束游戏，再次挑战");
        releasesKill(F10);
    }

    private static void sixHome() {
        upMove(600L);
        rightAndLeftMove(200L, VK_Right);
         releasesKill(VK_Q);
        driver.sleep(500L);
        rightAndLeftMove(750L, VK_Right);
        upMove(900L);
        System.out.println("第六个房间已过");
        driver.sleep(1000);
    }

    private static void fiveHome() {
        rightAndLeftMove(400L,VK_Left);
        upMove(110L);
        releasesKill( VK_W);
        driver.sleep(500L);
        releasesKill(VK_F);
        driver.sleep(1500L);
        rightAndLeftMove(320L,VK_Left);
        upMove(400L);
        System.out.println("第五个房间已过");
        driver.sleep(1000L);
    }

    private static void fourHome() {
        upMove(850L);
        rightAndLeftMove(650L,VK_Left);
        releasesKill( VK_Q);
        driver.sleep(1000L);
        rightAndLeftMove(1000L,VK_Left);
        System.out.println("第四个房间已过");
        driver.sleep(1000L);
    }



    private static void threeHome() {
        rightAndLeftMove(1000L, VK_Right);
        upMove(200L);
        releasesKill( VK_Q);
        driver.sleep(500L);
        rightAndLeftMove(800L, VK_Right);
        upMove(500L);
        System.out.println("第三个房间已过");
        driver.sleep(1000L);
    }

    private static void twoHome() {
        upMove(1000L);
        rightAndLeftMove(600L, VK_Right);
        releasesKill( VK_Q);
        rightAndLeftMove(1100L, VK_Right);
        System.out.println("第二个房间已过");
        driver.sleep(800L);
    }

    private static void releasesKill(int keyCode) {
        driver.keyDown(keyCode);
        driver.sleep(50L);
        driver.keyUp(keyCode);
        driver.sleep(500L);
    }

    private static void oneHome() {
        addBuff();
        rightAndLeftMove(400L, VK_Right);
        upMove(400L);
        driver.sleep(1000L);
        System.out.println("第一个房间已过");
    }

    private static void  addBuff(){
        //
        driver.keyDown( VK_Right);
        driver.sleep(70L);
        driver.keyUp( VK_Right);
        driver.sleep(70L);
        driver.keyDown( VK_Right);
        driver.sleep(70L);
        driver.keyUp( VK_Right);
        driver.sleep(20L);
        driver.keyDown( VK_Space);
        driver.sleep(200L);
        driver.keyUp( VK_Space);
        driver.sleep(2000L);
    }
    private static void rightAndLeftMove(Long time,int keyCode) {
        driver.keyDown(keyCode);
        driver.sleep(70L);
        driver.keyUp(keyCode);
        driver.sleep(50L);
        driver.keyDown(keyCode);
        driver.sleep(time);
        driver.keyUp(keyCode);
    }

    private static void  upMove(Long time){
        driver.keyDown( VK_UP);
        driver.sleep(time);
        driver.keyUp( VK_UP);
    }
}
