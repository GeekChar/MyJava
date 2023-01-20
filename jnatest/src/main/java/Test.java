import com.sun.jna.platform.win32.Kernel32;

public class Test {
    public static void main(String[] args) {
        User32 user32 = User32.INSTANCE;

        user32.MessageBox(null,"hello","title",1);
    }
}
