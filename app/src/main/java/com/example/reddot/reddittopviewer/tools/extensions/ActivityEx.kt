
import android.app.Activity
import android.support.annotation.StringRes
import com.example.reddot.reddittopviewer.App

val Activity.customApplication: App
    get() = application as App

fun Activity.showToast(@StringRes resId: Int) = applicationContext.showToast(resId)

fun Activity.showToast(message: String?) = applicationContext.showToast(message)

fun Activity.toastD(message: String?) = applicationContext.toastD(message)