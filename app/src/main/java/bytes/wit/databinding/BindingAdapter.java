package bytes.wit.databinding;

import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by Md. Sifat-Ul Haque on 3/10/2017.
 */

public class BindingAdapter {

    @android.databinding.BindingAdapter("imageUrl")
    public static void ImageUrl(ImageView imageView, String imageUrl){
        Picasso.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

}
