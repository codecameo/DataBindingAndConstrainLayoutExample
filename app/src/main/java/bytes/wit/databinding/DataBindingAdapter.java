package bytes.wit.databinding;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.databinding.BindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.databinding.adapters.ListenerUtil;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Md. Sifat-Ul Haque on 3/10/2017.
 */

@InverseBindingMethods({
        @InverseBindingMethod(type = ColorPicker.class,
                attribute = "color",
                method = "getColor")
})
public class DataBindingAdapter {

    @BindingAdapter(value={"imageUrl", "placeholder"} , requireAll = true)
    public static void ImageUrl(ImageView imageView, String imageUrl, Drawable placeHolder){
        Log.d("Parameter","both params");
        Picasso.with(imageView.getContext()).load(imageUrl).placeholder(placeHolder).into(imageView);
    }

    /*@BindingAdapter("imageUrl")
    public static void ImageUrl(ImageView imageView, String oldImageUrl, String newImageUrl){
        Log.d("Parameter",oldImageUrl+" and "+newImageUrl);
        Picasso.with(imageView.getContext()).load(newImageUrl).into(imageView);
    }*/

    @BindingAdapter("onColorChange")
    public static void setColorChangeListener(ColorPicker view,
                                              ColorPicker.OnColorChangeListener oldListener,
                                              ColorPicker.OnColorChangeListener newListener) {
        if (oldListener != null) {
            view.removeListener(oldListener);
        }
        if (newListener != null) {
            view.addListener(newListener);
        }
    }

    @BindingAdapter(value={"event:onColorChange", "colorAttrChanged"}, requireAll = false)
    public static void setColorChangeListener(ColorPicker view,
                                              final ColorPicker.OnColorChangeListener onColorChangeListener,
                                              final InverseBindingListener inverseBindingListener) {

        ColorPicker.OnColorChangeListener newListener;
        if (inverseBindingListener == null) {
            newListener = onColorChangeListener;
        } else {
            newListener = new ColorPicker.OnColorChangeListener() {
                @Override
                public void onColorChangeListener(ColorPicker colorPicker,
                                          int newColor) {
                    if (onColorChangeListener != null) {
                        onColorChangeListener.onColorChangeListener(colorPicker,
                                newColor);
                    }
                    inverseBindingListener.onChange();
                }
            };
        }

        ColorPicker.OnColorChangeListener oldListener =
                ListenerUtil.trackListener(view, newListener,
                        R.id.onColorChangedListner);

        if (oldListener != null) {
            view.removeListener(oldListener);
        }

        if (newListener != null) {
            view.addListener(newListener);
        }

    }

    @BindingAdapter("color")
    public static void setColor(ColorPicker view, int color){
        /**
         * Preventing Infinite Loops between model change and view update
         * */
        if (color != view.getColor())
            view.setColor(color);
    }

    @BindingAdapter("animatedVisibility")
    public static void setVisibility(final View view,
                                     final int visibility) {
        // Were we animating before? If so, what was the visibility?
        Integer endAnimVisibility =
                (Integer) view.getTag(R.id.finalVisibility);
        int oldVisibility = endAnimVisibility == null
                ? view.getVisibility()
                : endAnimVisibility;

        if (oldVisibility == visibility) {
            // just let it finish any current animation.
            return;
        }

        boolean isVisibile = oldVisibility == View.VISIBLE;
        boolean willBeVisible = visibility == View.VISIBLE;

        view.setVisibility(View.VISIBLE);
        float startAlpha = isVisibile ? 1f : 0f;
        if (endAnimVisibility != null) {
            startAlpha = view.getAlpha();
        }
        float endAlpha = willBeVisible ? 1f : 0f;

        // Now create an animator
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view,
                View.ALPHA, startAlpha, endAlpha);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            alpha.setAutoCancel(true);
        }

        alpha.addListener(new AnimatorListenerAdapter() {
            private boolean isCanceled;

            @Override
            public void onAnimationStart(Animator anim) {
                view.setTag(R.id.finalVisibility, visibility);
            }

            @Override
            public void onAnimationCancel(Animator anim) {
                isCanceled = true;
            }

            @Override
            public void onAnimationEnd(Animator anim) {
                view.setTag(R.id.finalVisibility, null);
                if (!isCanceled) {
                    view.setAlpha(1f);
                    view.setVisibility(visibility);
                }
            }
        });
        alpha.start();
    }
}
