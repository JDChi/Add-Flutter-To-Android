package com.example.add_flutter_to_android;

import android.app.Application;

import com.example.add_flutter_to_android.common.CacheId;

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;

public class MyApplication extends Application {
    public FlutterEngine flutterEngine;

    @Override
    public void onCreate() {
        super.onCreate();
        // 实例化 FlutterEngine ，用于缓存提升速度
        flutterEngine = new FlutterEngine(this);
        // 当 executeDartEntrypoint 调用的时候，Dart 的入口方法就开始执行
        // 尤其是入口方法里调用 runApp()，此时 Flutter 引用开始运行在一个大小为0的窗口里
        flutterEngine.getDartExecutor().executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault());
        FlutterEngineCache.getInstance().put(CacheId.MY_ENGINE_ID, flutterEngine);

        // 当使用一个缓存的 FlutterEngine 时， FlutterEngine 会比展示它的 FlutterActivity 或 FlutterFragment 存活得更久。
        // 要停止代码运行和清理相关资源，可以从 FlutterEngineCache 中获取你的 FlutterEngine，然后使用 FlutterEngine.destroy() 来销毁 FlutterEngine。
        // FlutterEngine cacheEngine = FlutterEngineCache.getInstance().get(CacheId.MY_ENGINE_ID);
        // cacheEngine.destroy();
    }
}
