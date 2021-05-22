# t

A new Flutter project.

## Getting Started

This project is a starting point for a Flutter application.

A few resources to get you started if this is your first Flutter project:

- [Lab: Write your first Flutter app](https://flutter.dev/docs/get-started/codelab)
- [Cookbook: Useful Flutter samples](https://flutter.dev/docs/cookbook)

For help getting started with Flutter, view our
[online documentation](https://flutter.dev/docs), which offers tutorials,
samples, guidance on mobile development, and a full API reference.

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
