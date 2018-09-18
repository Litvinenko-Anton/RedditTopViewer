
import android.content.Context
import android.content.Intent
import android.support.annotation.StringRes
import android.widget.Toast
import com.example.reddot.reddittopviewer.App
import com.example.reddot.reddittopviewer.BuildConfig

val Context.customApplication: App
    get() = this as App

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

fun Context.sharedContentIntent(content: String) {
    val shareIntent = Intent(Intent.ACTION_SEND)
    shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    shareIntent.type = "text/plain"
    shareIntent.putExtra(Intent.EXTRA_TEXT, content)
    val intent = Intent.createChooser(shareIntent, "Share it")
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    this.startActivity(intent)
}
