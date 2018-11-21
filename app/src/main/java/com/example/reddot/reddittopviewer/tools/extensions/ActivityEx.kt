
import android.app.Activity
import android.support.annotation.StringRes

fun Activity.showToast(@StringRes resId: Int) = applicationContext.showToast(resId)

fun Activity.showToast(message: String?) = applicationContext.showToast(message)

fun Activity.openChromeCustomTabs(url: String?) {
    url?.let {
        url.toString()
    }
}