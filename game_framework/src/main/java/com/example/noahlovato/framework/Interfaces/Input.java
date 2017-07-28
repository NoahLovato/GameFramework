package com.example.noahlovato.framework.Interfaces;

/**
 * Created by noah.lovato on 7/28/2017.
 */

public interface Input {

    public class KeyEvent {
        public static final int KEY_DOWN = 0;
        public static final int KEY_UP = 1;

        public int type;
        public int keyCode;
        public char keyChar;
    }

    public class TouchEvent {
        public static final int TOUCH_DOWN = 0;
        public static final int TOUCH_UP = 1;
        public static final int TOUCH_DRAGGED = 2;

        public int type;
        public int x,y;
        public int pointer;
    }


}
