package bytes.wit.databinding;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.databinding.adapters.ListenerUtil;
import android.graphics.drawable.Drawable;
import android.util.Log;
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
}
