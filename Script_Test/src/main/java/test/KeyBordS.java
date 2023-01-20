package test;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.awt.event.MouseEvent;

public class KeyBordS implements NativeKeyListener {

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        nativeEvent.setKeyChar('b');
        System.out.println(nativeEvent.getKeyChar()+"pressed");
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
        System.out.println(nativeEvent.getKeyChar()+"released");
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeEvent) {
        System.out.println(nativeEvent.getKeyChar()+"typed");
    }
}
