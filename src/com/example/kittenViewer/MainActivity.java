package com.example.kittenViewer;

import android.app.Activity;
import android.os.Bundle;
import android.content.res.AssetManager;
import java.io.InputStream;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import java.io.IOException;

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
}
