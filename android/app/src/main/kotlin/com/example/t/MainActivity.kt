package com.example.t
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import android.util.Log
import androidx.annotation.NonNull
import io.flutter.embedding.engine.FlutterEngine

import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.example.chat.AD_SDK.*

class MainActivity: FlutterActivity() {
  private val CHANNEL = "flutter_adid_plugin"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  @ExperimentalStdlibApi
  override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
    MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler{
      call, result -> 
      when {
        call.method.equals("get_adid_or_idfa") -> {
          ADID(applicationContext, result).execute("send")
        }
      }
    }
  }
}
