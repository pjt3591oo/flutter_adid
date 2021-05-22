# t

A new Flutter project.

## 네이트브 통신방법

```kt
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodChannel

import androidx.annotation.NonNull
import io.flutter.embedding.engine.FlutterEngine

import android.util.Log

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
          Log.d("[NATIVE]", "method channel success result")
          result.success("result data")
        }
      }
    }
  }
}
```
