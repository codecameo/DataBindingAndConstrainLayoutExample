package bytes.wit.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Md. Sifat-Ul Haque on 3/8/2017.
 */

public class PlaceModel extends BaseObservable{

    private String placeName, placeDescription, imageUrl;
    private int color;


    public PlaceModel(String name, String description, String url, int color){
        placeName = name;
        imageUrl = url;
        placeDescription = description;
        this.color = color;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public void setPlaceDescription(String placeDescription) {
        this.placeDescription = placeDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Bindable
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        notifyPropertyChanged(BR.color);
    }
}
