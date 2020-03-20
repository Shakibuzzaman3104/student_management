package com.techtrixbd.studentattendence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;


public class StartActivity extends AppCompatActivity {

    boolean isNewInstallation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        isNewInstallation = !isStored() && writeResponseBodyToDisk();
    }

    private boolean isStored() {

        boolean isFound = false;

        File path = getExternalFilesDir(null);
        File file = new File(path.getPath() + "/checker/");


        Log.e("file checker", file.getAbsolutePath());
        if (!file.exists()) {
            file.mkdirs();
        }


        if (file.isDirectory()) {
            String[] files = file.list();
            if (files != null && files.length > 0) {
                isFound = true;
            }
        }
        return isFound;
    }


    private boolean writeResponseBodyToDisk() {

        try {
            String subjectNameWithExtension = "checker.txt";

            File sdcard = getExternalFilesDir(null);
            File questionFileDir = new File(sdcard.getPath() + "/checker/");


            if (!questionFileDir.exists()) {
                boolean isDirectoryCreated = questionFileDir.mkdir();
                if (!isDirectoryCreated)
                    Log.i("Directory_not_created", "Can't create directory to save the image");
            }

            String filename = questionFileDir.getAbsolutePath() + File.separator + subjectNameWithExtension;

            String textToWrite = "This is some text!";
            FileOutputStream outputStream;

            try {
                outputStream = openFileOutput(filename , Context.MODE_PRIVATE);
                outputStream.write(textToWrite.getBytes());
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }


}
