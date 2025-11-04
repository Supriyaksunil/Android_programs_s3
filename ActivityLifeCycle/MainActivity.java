package com.example.activitylifecycle;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle","onCreate invoked");
    }
    protected void onStart(){
        super.onStart();
        Log.d("lifecycle","onStart invoked");

    }
    protected void onResume(){
        super.onResume();
        Log.d("lifecycle","onResume invoked");

    }
    protected void onPause(){
        super.onPause();
        Log.d("onPause","onPause invoked");
    }

    protected void onStop(){
        super.onStop();
        Log.d("lifecycle","onStop invoked");

    }
    protected void onRestart(){
        super.onRestart();
        Log.d("lifecycle","onRestart invoked");

    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoked");

    }
}
