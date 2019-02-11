package com.example.shame.myfirst;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.io.File;

import static android.net.Uri.fromFile;


public class GalleryActivity extends AppCompatActivity {
    private static final int TAKE_PICTURE = 1;
    Button button1;
    private Uri imageUri;
    GridView gridview;
    Bitmap help1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gallery);
        gridview = findViewById(R.id.gridView);
        button1 = findViewById(R.id.buttonCam);


        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TakePictureIntent();
            }
        });

    }

    private void TakePictureIntent() {

        int count = 0;
        Intent takepictureintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        imageUri = fromFile(new File(Environment.getExternalStorageDirectory(), "fname_" + "v" + count + ".jpg"));
        takepictureintent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(takepictureintent, TAKE_PICTURE);
        count++;

        Log.i("nnn", "tk" + count);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == TAKE_PICTURE) {
            if (resultCode == Activity.RESULT_OK) {
                try {

                    Log.i("mmm", "ar");
                    help1 = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                    gridview.setAdapter(new ImageAdapter(this));
                } catch (Exception e) {
                    Log.i("fff", e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private class ImageAdapter extends BaseAdapter {


        public ImageAdapter(GalleryActivity galleryActivity) {
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }

    }

}