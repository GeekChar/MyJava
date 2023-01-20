package script;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;

public class Driver {
    private RobotDLL robotDLL;
    private Pointer handler;
    private static Driver driver;
    private int pid,vid;
    private Driver(int vid,int pid) {
        this.vid=vid;
        this.pid=vid;
       robotDLL =RobotDLL.robotDll;
       handler = robotDLL.M_Open_VidPid(vid, pid);
        System.out.println(robotDLL.M_ResolutionUsed(handler, 1920, 1080));
    }
    public static  Driver getRobot(int vid,int pid){
        if (driver==null){
            synchronized (Driver.class){
            if (driver==null) {
                driver = new Driver(vid, pid);
            }
            }
        }
        return driver;
    }
    public boolean keyUp(int keyCode){
        return  robotDLL.M_KeyUp(handler, keyCode)==0?true:false;
    }
    public boolean keyDown(int keyCode){
        return robotDLL.M_KeyDown(handler,keyCode)==0?true:false;
    }
    public boolean kePress(int keyCode){
        return robotDLL.M_KeyPress(handler,keyCode,1)==0?true:false;
    }
    public boolean leftClick(int count){
        return robotDLL.M_LeftClick(handler,count)==0?true:false;
    }
    public boolean leftDown(){
        return robotDLL.M_LeftDown(handler)==0?true:false;
    }
    public boolean leftUp(){
        return robotDLL.M_LeftUp(handler)==0?true:false;
    }
    public boolean unLoadDll(){
        boolean flag =false;
        if (robotDLL!=null){
            if (robotDLL.M_Close(handler)==0) {
                flag=true;
            }
        }
        return flag;
    }
    public boolean rightUp(){
        return robotDLL.M_RightUp(handler)==0?true:false;
    }
    public boolean rightDown(){
        return robotDLL.M_LeftDown(handler)==0?true:false;
    }
    public boolean rightClick(){
        return robotDLL.M_RightClick(handler,1)==0?true:false;
    }
    public boolean midUp(){
        return robotDLL.M_MiddleUp(handler)==0?true:false;
    }
    public boolean midDown(){
        return robotDLL.M_MiddleDown(handler)==0?true:false;
    }
    public boolean midClick(){
        return robotDLL.M_MiddleClick(handler,1)==0?true:false;
    }
    public boolean mouseMove(int x,int y){
        return robotDLL.M_MoveR(handler,x,y)==0?true:false;
    }
    public boolean mouseMoveto(int x,int y){//todo
//        Memory posX=new Memory(4);
//        Memory posY=new Memory(4);
//        robotDLL.M_GetCurrMousePos2(posX,posY);
//        int currentX=posX.getInt(0);
//        int currentY=posY.getInt(0);
//        int lenX=x-currentX;
//        int lenY=y-currentY;
//        int temp=lenX*lenY;
//        int count=Math.abs((int)time*1000/temp);
//        for (long l = 0; l < count; l++) {
//            mouseMove(lenX/count,lenY/count);
//            sleep(time/count);
//        }
        robotDLL.M_MoveTo3(handler,x,y);
        return false;
    }
    public boolean mouseReset(){
        return robotDLL.M_ResetMousePos(handler)==0?true:false;
    }
    public void sleep(long m){
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
