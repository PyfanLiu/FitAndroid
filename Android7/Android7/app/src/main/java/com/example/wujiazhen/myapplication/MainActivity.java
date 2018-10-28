package com.example.wujiazhen.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static com.example.wujiazhen.myapplication.R.mipmap.abc;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getLayoutInflater().inflate()


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), abc);

        File cacheDir = getExternalCacheDir();

        System.out.println("cacheDir:"+cacheDir.getAbsolutePath());


        File b = new File(cacheDir, "c");
        System.out.println("b:"+b);


        File newFile = new File(cacheDir, "b/name/abc");

        if (!newFile.exists()) {
            newFile.mkdirs();
        }

        File ccc = new File(newFile, "ccc.png");

        System.out.println("newFile:"+newFile.getAbsolutePath());




        Uri contentUri = FileProvider.getUriForFile(this, "abc", ccc);

        System.out.println(contentUri.toString());
        System.out.println(contentUri.getPath());

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(ccc);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        //Uri photoURI = FileProvider.getUriForFile(this, "abc", file);

        //Uri uri = Uri.fromFile(file1);
        intent.setDataAndType(contentUri, "image/*");
        startActivity(intent);
    }

    public void click(View view) {

    }
}
