package com.example.kittenViewer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.res.AssetManager;
import java.io.InputStream;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import java.io.IOException;

import android.content.res.AssetManager;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

	AssetManager manager = getAssets();
	try {
		InputStream open = manager.open("firewalkwithme.jpg");
		Bitmap bitmap = BitmapFactory.decodeStream(open);
		ImageView view = (ImageView) findViewById(R.id.catContent);
		view.setImageBitmap(bitmap);
	} catch (IOException e) {
		e.printStackTrace();
	}
    }

	public void sayANiceThing(View view) {
		AssetManager manager = getAssets();
		try {
			AssetFileDescriptor afd = manager.openFd("meow.mp3");
			MediaPlayer mp = new MediaPlayer();
			mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
			mp.prepare();
			mp.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
