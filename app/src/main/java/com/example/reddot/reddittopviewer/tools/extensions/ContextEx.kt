
import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import android.support.annotation.StringRes
import android.widget.Toast
import com.example.reddot.reddittopviewer.App
import com.example.reddot.reddittopviewer.BuildConfig

val Context.customApplication: App
    get() = this as App

@SuppressLint("HardwareIds")
fun Context.deviceId(): String {
    return Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID)
}

fun Context.osType(): String {
    return "2" // 1-iOS, 2-Android
}

fun Context.showToast(@StringRes resId: Int) {
    Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
}

fun Context.showToast(message: String?) {
    message?.let {
        if (message.isNotEmpty())
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }
}

fun Context.toastD(message: String?) {
    if (BuildConfig.DEBUG)
        message?.let {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
}
