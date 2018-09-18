
import android.app.Activity
import android.net.Uri
import android.support.annotation.StringRes
import android.support.customtabs.CustomTabsIntent

fun Activity.showToast(@StringRes resId: Int) = applicationContext.showToast(resId)

fun Activity.showToast(message: String?) = applicationContext.showToast(message)

fun Activity.openChromeCustomTabs(url: String?) {
    url?.let {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(url))
    }
}