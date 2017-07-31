package com.example.noahlovato.framework.Framework;

import android.graphics.Bitmap;

import com.example.noahlovato.framework.Interfaces.Graphics;
import com.example.noahlovato.framework.Interfaces.Pixmap;

/**
 * Created by noah.lovato on 7/31/2017.
 */

public class AndroidPixmap implements Pixmap {

    Bitmap bitmap;
    Graphics.PixmapFormat pixmapFormat;

    public AndroidPixmap(Bitmap bitmap, Graphics.PixmapFormat pixmapFormat){
        this.bitmap = bitmap;
        this.pixmapFormat = pixmapFormat;
    }

    @Override
    public int getWidth(){
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public Graphics.PixmapFormat getFormat() {
        return pixmapFormat;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }

}
