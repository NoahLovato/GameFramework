package com.example.noahlovato.framework.Framework;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import com.example.noahlovato.framework.Interfaces.Music;

import java.io.IOException;

/**
 * Created by noah.lovato on 7/28/2017.
 */

public class AndroidMusic implements Music {

    MediaPlayer mediaPlayer;
    boolean isPrepared = false;

    public AndroidMusic(AssetFileDescriptor assetFileDescriptor) {
        mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(),
                    assetFileDescriptor.getStartOffset(),
                    assetFileDescriptor.getLength());
            isPrepared = true;
        }
        catch (IOException e) {

        }
    }
}
