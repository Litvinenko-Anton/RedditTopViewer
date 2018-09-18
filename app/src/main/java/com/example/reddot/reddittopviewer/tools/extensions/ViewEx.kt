import android.support.annotation.DrawableRes
import android.support.annotation.RawRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ViewGroup.inflate(layoutRes: Int): View = LayoutInflater.from(context).inflate(layoutRes, this, false)

fun ImageView.load(url: String?) = Glide.with(context).load(url).into(this)

fun ImageView.load(@DrawableRes idRes: Int) = Glide.with(context).load(idRes).into(this)

/**
 * Returns true when this view's visibility is [View.VISIBLE], false otherwise.
 */
inline var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) = this.setVisibilityToView(value, isVisible, isInvisible, View.VISIBLE, View.INVISIBLE)

/**
 * Returns true when this view's visibility is [View.INVISIBLE], false otherwise.
 */
inline var View.isInvisible: Boolean
    get() = visibility == View.INVISIBLE
    set(value) = this.setVisibilityToView(value, isInvisible, isVisible, View.INVISIBLE, View.VISIBLE)

/**
 * Returns true when this view's visibility is [View.GONE], false otherwise.
 */
inline var View.isGone: Boolean
    get() = visibility == View.GONE
    set(value) = this.setVisibilityToView(value, isGone, isVisible, View.GONE, View.VISIBLE)


fun View.setVisibilityToView(value: Boolean,
                             currentValue: Boolean,
                             reversValue: Boolean,
                             currentVisibility: Int,
                             reversVisibility: Int) {
    if (value) {
        if (!currentValue) visibility = currentVisibility
    } else {
        if (!reversValue) visibility = reversVisibility
    }
}

fun ImageView.loadUrl(url: String?) {
    Glide.with(context).load(url).into(this)
}

fun ImageView.loadUrl(url: String?, requestOptions: RequestOptions) {
    if (url != null)
        Glide.with(context).load(url).apply(requestOptions).into(this)
    else
        setImageDrawable(null)
}

fun ImageView.loadRes(@RawRes @DrawableRes idRes: Int) {
    Glide.with(context).load(idRes).into(this)
}
