package script;


import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface RobotDLL extends Library {
    public static RobotDLL robotDll= (RobotDLL) Native.loadLibrary( "msdk.dll", RobotDLL.class );
    Pointer M_open(int Nbr);
////使用M_Open_VidPid接口可以打开指定vid pid的单头盒子或者双头盒子的主控端。必须保证电脑上只插有一个这种盒子。
//        Pointer   M_Open_VidPid(int Vid, int Pid);
    Pointer  M_Open_VidPid(int Vid, int Pid);
////关闭端口；在程序退出前再关闭端口; 返回 0: 成功；!0: 失败
    int  M_Close(Pointer m_hdl);
    int  M_GetDevSn(Pointer m_hdl, Pointer lenRes, Pointer data);

////设置DLL内部参数
////ParamType = 0: 单击按键，按下和弹起之间的延时值，Param1=最小值，Param2=最大值，实际延时时间在最小最大值之间随机//默认值是50,80
////ParamType = 2: 多个按键，每个按键之间的延时值，Param1=最小值，Param2=最大值，实际延时时间在最小最大值之间随机//默认值是150,600
////ParamType = 8: 单击鼠标(左中右键)，按下和弹起之间的延时值，Param1=最小值，Param2=最大值，实际延时时间在最小最大值之间随机//默认值是50,80
////ParamType = 10: 多次单击鼠标(左中右键)，每次单击之间的延时值，Param1=最小值，Param2=最大值，实际延时时间在最小最大值之间随机//默认值是500,900
////ParamType = 12: 双击鼠标(左键)，两次单击之间的延时值，Param1=最小值，Param2=最大值，实际延时时间在最小最大值之间随机//默认值是60,110
////ParamType = 14: 多次双击鼠标(左键)，每次双击之间的延时值，Param1=最小值，Param2=最大值，实际延时时间在最小最大值之间随机//默认值是500,800
////ParamType = 20: 鼠标移动轨迹由多条直线组成，每条直线移动之间的延时值，Param1=最小值，Param2=最大值，实际延时时间在最小最大值之间随机//默认值是10,20
//        int   M_SetParam(Pointer m_hdl, int ParamType, int Param1, int Param2);
int  M_SetParam(Pointer m_hdl, int ParamType, int Param1, int Param2);
///***********键盘操作函数;以下函数中的m_hdl是指M_Open返回的句柄*******/
///***********以下所有命令返回 0: 成功；-1: 失败*******/
/////////////以下接口采用的HidKeyCode是USB键盘的KeyCode，不是windows的KeyCode，新开发程序不建议再使用
////单击(按下后立刻弹起)按键  //HidKeyCode: 键盘码; Nbr: 按下次数
//        int   M_KeyPress(Pointer m_hdl, int HidKeyCode, int Nbr);
int  M_KeyPress(Pointer m_hdl, int HidKeyCode, int Nbr);
////按下某个按键不弹起        //HidKeyCode: 键盘码
//        int   M_KeyDown(Pointer m_hdl, int HidKeyCode);
int  M_KeyDown(Pointer m_hdl, int HidKeyCode);
////弹起某个按键              //HidKeyCode: 键盘码
//        int   M_KeyUp(Pointer m_hdl, int HidKeyCode);
int   M_KeyUp(Pointer m_hdl, int HidKeyCode);
////读取按键状态              //HidKeyCode: 键盘码 //返回 0: 弹起状态；1:按下状态；-1: 失败(端口未打开)
////使用该接口，不允许手工操作键盘，否则该接口返回值有可能不正确
//        int   M_KeyState(Pointer m_hdl, int HidKeyCode);
int   M_KeyState(Pointer m_hdl, int HidKeyCode);
/////////////以上接口采用的HidKeyCode是USB键盘的KeyCode，不是windows的KeyCode，新开发程序不建议再使用
/////////////以下接口采用的KeyCode是windows的KeyCode，新开发程序建议再使用
////单击(按下后立刻弹起)按键  //KeyCode: 键盘码; Nbr: 按下次数
        int   M_KeyPress2(Pointer m_hdl, int KeyCode, int Nbr);
////按下某个按键不弹起        //KeyCode: 键盘码
        int   M_KeyDown2(Pointer m_hdl, int KeyCode);
////弹起某个按键              //KeyCode: 键盘码
        int   M_KeyUp2(Pointer m_hdl, int KeyCode);
////读取按键状态              //KeyCode: 键盘码 //返回 0: 弹起状态；1:按下状态；-1: 失败(端口未打开)
////使用该接口，不允许手工操作键盘，否则该接口返回值有可能不正确
        int   M_KeyState2(Pointer m_hdl, int KeyCode);
/////////////以上接口采用的KeyCode是windows的KeyCode，新开发程序建议再使用
////弹起所有按键
        int   M_ReleaseAllKey(Pointer m_hdl);
////读取小键盘NumLock灯的状态 //返回 0:灭；1:亮；-1: 失败
        int   M_NumLockLedState(Pointer m_hdl);
////读取CapsLock灯的状态 //返回 0:灭；1:亮；-1: 失败
        int   M_CapsLockLedState(Pointer m_hdl);
////读取ScrollLock灯的状态 //返回 0:灭；1:亮；-1: 失败
        int   M_ScrollLockLedState(Pointer m_hdl);
////输入一串ASCII字符串，如"ABCdef012,.<>"，在InputLen个字节内将忽略非ASCII字符，  //InputStr: 输入缓冲区首地址; 注意：不支持解析\n\r等转义字符！ InputLen:输出的长度
//        int   M_KeyInputString(Pointer m_hdl, char *InputStr, int InputLen);
////输入一串字符串，支持中文(GBK编码)英文混合，如"啊啊啊ABCdef012,.<>"，在InputLen个字节内将忽略非ASCII和中文字符，  //InputStr: 输入缓冲区首地址; 注意：不支持解析\n\r等转义字符！ InputLen:输出的长度
//        int   M_KeyInputStringGBK(Pointer m_hdl, char *InputStr, int InputLen);
////输入一串字符串，支持中文(Unicode编码)英文混合，如"啊啊啊ABCdef012,.<>"，在InputLen个字节内将忽略非ASCII和中文字符，  //InputStr: 输入缓冲区首地址; 注意：不支持解析\n\r等转义字符！ InputLen:输出的长度
//        int   M_KeyInputStringUnicode(Pointer m_hdl, char *InputStr, int InputLen);
///***********鼠标操作函数;以下函数中的m_hdl是指M_Open返回的句柄*******/
///***********以下所有命令返回 0: 成功；-1: 失败*******/
////左键单击   //Nbr: 左键在当前位置单击次数
        int   M_LeftClick(Pointer m_hdl,int Nbr);
////左键双击   //Nbr: 左键在当前位置双击次数
        int   M_LeftDoubleClick(Pointer m_hdl,int Nbr);
////按下左键不弹起
        int   M_LeftDown(Pointer m_hdl);
////弹起左键
        int   M_LeftUp(Pointer m_hdl);
////右键单击   //Nbr: 左键在当前位置单击次数
        int   M_RightClick(Pointer m_hdl,int Nbr);
////按下右键不弹起
        int   M_RightDown(Pointer m_hdl);
////弹起右键
        int   M_RightUp(Pointer m_hdl);
////中键单击   //Nbr: 左键在当前位置单击次数
        int   M_MiddleClick(Pointer m_hdl,int Nbr);
////按下中键不弹起
        int   M_MiddleDown(Pointer m_hdl);
////弹起中键
        int   M_MiddleUp(Pointer m_hdl);
////弹起鼠标的所有按键
        int   M_ReleaseAllMouse(Pointer m_hdl);
////读取鼠标左中右键状态   //MouseKeyCode: 1=左键 2=右键 3=中键  //返回 0: 弹起状态；1:按下状态；-1: 失败
////只能读取盒子中鼠标的状态，读取不到实体鼠标的状态
        int   M_MouseKeyState(Pointer m_hdl, int MouseKeyCode);
////滚动鼠标滚轮;  Nbr: 滚动量,  为正,向上滚动；为负, 向下滚动;
        int   M_MouseWheel(Pointer m_hdl,int Nbr);
////将鼠标移动到原点(0,0)  在出现移动出现异常时，可以用该函数将鼠标复位
        int   M_ResetMousePos(Pointer m_hdl);
////从当前位置移动鼠标    x: x方向（横轴）的距离（正:向右; 负值:向左）; y: y方向（纵轴）的距离（正:向下; 负值:向上）
        int   M_MoveR(Pointer m_hdl,int x, int y);
////移动鼠标到指定坐标    x: x方向（横轴）的坐标; y: y方向（纵轴）的坐标。坐标原点(0, 0)在屏幕左上角
////注意：如果出现过将鼠标移动的距离超过屏幕大小，再次MoveTo可能会出现无法正确移动到指定坐标的问题，如果出现该问题，需调用ResetMousePos复位
        int   M_MoveTo(Pointer m_hdl,int x, int y);
////读取当前鼠标所在坐标  返回坐标在x、y中。
////注意：该函数必须在执行一次MoveTo或ResetMousePos函数后才能正确执行！
////注意：如果曾经出现过将鼠标移动的距离超过屏幕大小，这里读取到的坐标值有可能是不正确的！如果出现该问题，需调用ResetMousePos复位
//        int   M_GetCurrMousePos(Pointer m_hdl,int *x, int *y);
//返回当前鼠标坐标X值
        int   M_GetCurrMousePosX(Pointer m_hdl); //由于某些语言不支持指针，增加此接口
////返回当前鼠标坐标Y值
        int   M_GetCurrMousePosY(Pointer m_hdl); //由于某些语言不支持指针，增加此接口
//
//////////以下接口仅适用主控机和被控机是同一台电脑的使用方式(单头模块；双头模块的两个USB头都连接到同一台电脑)
//////////以下接口将调用系统的API来获取当前鼠标位置，DLL将不记录鼠标移动的位置
////移动鼠标到指定坐标    x: x方向（横轴）的坐标; y: y方向（纵轴）的坐标。
        int   M_MoveR2(Pointer m_hdl,int x, int y);
////移动鼠标到指定坐标    x: x方向（横轴）的坐标; y: y方向（纵轴）的坐标。坐标原点(0, 0)在屏幕左上角
        int   M_MoveTo2(Pointer m_hdl,int x, int y);
////读取当前鼠标所在坐标  返回坐标在x、y中。
        int   M_GetCurrMousePos2(Pointer x, Pointer y);
//
//////////以下接口将使用绝对移动功能。该功能目前还不能支持安卓
////输入被控机分辨率
////  在使用绝对移动功能前，必须先输入被控机的屏幕分辨率，打开端口获取句柄后，只需要调用一次该接口就可以
////  x: x方向（横轴）的坐标; y: y方向（纵轴）的坐标。坐标原点(0, 0)在屏幕左上角
////  返回值如果是-10，表示该盒子不支持绝对移动功能。返回0表示执行正确。可以用该接口判断盒子是否支持绝对移动功能
        int   M_ResolutionUsed(Pointer m_hdl, int x, int y);
////将鼠标移动到指定坐标。
////  绝对移动功能，鼠标移动到指定位置时，在某些坐标上最大会有±2的误差
////  使用该接口后，可以调用M_GetCurrMousePos读取鼠标位置
        int   M_MoveTo3(Pointer m_hdl, int x, int y);
////一步到位将鼠标移动到指定坐标。
////  使用绝对移动功能，鼠标一步到位移动（没有移动轨迹）到指定位置，在某些坐标上最大会有±2的误差
////  使用该接口后，可以调用M_GetCurrMousePos读取鼠标位置
        int   M_MoveTo3_D(Pointer m_hdl, int x, int y);
///*******************通用操作函数****************************/
////延时指定时间  time:单位ms
        int   M_Delay(int time);
////在指定的最小最大值之间延时随机时间  Min_time:最小延时时间; Max_time: 最大延时时间 （单位：ms）
        int   M_DelayRandom(int Min_time, int Max_time);
////在最小最大值之间取随机数
        int   M_RandDomNbr(int Min_V, int Max_V);
//
//#ifdef __cplusplus
//    }
//#endif
//#endif
}
