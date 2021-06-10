package com.example.add_flutter_to_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.add_flutter_to_android.common.CacheId;

import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends AppCompatActivity {
    AppCompatButton bt_flutter_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_flutter_activity = findViewById(R.id.bt_flutter_activity);
        bt_flutter_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(FlutterActivity.withCachedEngine(CacheId.MY_ENGINE_ID).build(MainActivity.this));

//                startActivity(FlutterActivity.createDefaultIntent(MainActivity.this));
            }
        });
    }
}