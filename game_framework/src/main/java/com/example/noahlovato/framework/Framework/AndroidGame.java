package com.example.noahlovato.framework.Framework;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.example.noahlovato.framework.Interfaces.Audio;
import com.example.noahlovato.framework.Interfaces.FileIO;
import com.example.noahlovato.framework.Interfaces.Game;
import com.example.noahlovato.framework.Interfaces.Graphics;
import com.example.noahlovato.framework.Interfaces.Input;
import com.example.noahlovato.framework.Interfaces.Screen;

/**
 * Created by noah.lovato on 7/31/2017.
 */

public class AndroidGame extends Activity implements Game {

    AndroidFastRenderView renderView;
    Graphics graphics;
    Audio audio;
    Input input;
    FileIO fileIO;
    Screen screen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        boolean isLandscape = getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE;

        int frameBufferWidth = isLandscape ? 480 : 320;
        int frameBufferHeight = isLandscape ? 320 : 480;
        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth, frameBufferHeight,
                Bitmap.Config.RGB_565);

        float scaleX = (float) frameBufferWidth / getWindowManager().getDefaultDisplay().
                getWidth();

        float scaleY = (float) frameBufferWidth / getWindowManager().getDefaultDisplay().
                getHeight();

        renderView = new AndroidFastRenderView(this, frameBuffer);
        graphics = new AndroidGraphics(getAssets(), frameBuffer);
        fileIO = new AndroidFileIO(this);
        audio = new AndroidAudio(this);
        input = new AndroidInput(this, renderView, scaleX, scaleY);
        screen = getStartScreen();
        setContentView(renderView);
    }
}
