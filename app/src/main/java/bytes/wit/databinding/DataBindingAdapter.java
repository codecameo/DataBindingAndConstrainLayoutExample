package bytes.wit.databinding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Md. Sifat-Ul Haque on 3/10/2017.
 */

public class DataBindingAdapter {

    @BindingAdapter(value={"imageUrl", "placeholder"}, requireAll=false)
    public static void ImageUrl(ImageView imageView, String imageUrl, Drawable placeHolder){
        Picasso.with(imageView.getContext()).load(imageUrl).placeholder(placeHolder).into(imageView);
    }

}
