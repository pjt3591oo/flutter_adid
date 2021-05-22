package com.example.chat.AD_SDK

import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.MutableLiveData
import java.io.IOException

import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import io.flutter.plugin.common.MethodChannel

interface MethodChannelResult{
  fun success(result: String)
}

class ADID(var applicationContext: android.content.Context, var methodChannelResult: MethodChannel.Result): AsyncTask<String, String, String>() {

  override fun doInBackground(vararg parameters: String): String {
      return _getAdid()
  }

  protected override fun onProgressUpdate(vararg progress: String) { }

  override fun onPostExecute(result: String) {
    Log.d("[NATIVE] ADID: ", result)
    methodChannelResult.success(result)
  }

  fun _getAdid(): String {
      var adInfo: AdvertisingIdClient.Info? = null

      try {
          adInfo = AdvertisingIdClient.getAdvertisingIdInfo(applicationContext)
      } catch (e: IOException) {

      } catch (e: GooglePlayServicesNotAvailableException) {

      }
      val id = adInfo!!.id
      val isLAT = adInfo!!.isLimitAdTrackingEnabled

      return id
  }
}