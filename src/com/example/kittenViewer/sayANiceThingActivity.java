package com.example.kittenViewer;

import android.app.Activity;
import android.os.Bundle;
import android.content.res.AssetManager;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import java.io.IOException;

public class sayANiceThingActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		AssetManager manager = getAssets();
		try {
			AssetFileDescriptor afd = manager.openFd("meow.mp3");
			MediaPlayer mp = new MediaPlayer();
			mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
			mp.prepareAsync();
			mp.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
