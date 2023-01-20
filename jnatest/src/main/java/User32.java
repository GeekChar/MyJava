import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

public interface User32 extends StdCallLibrary, WinUser, WinNT {
User32 INSTANCE = (User32)Native.load("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);

int MessageBox(HWND hwnd,String text,String title ,int type);

}
