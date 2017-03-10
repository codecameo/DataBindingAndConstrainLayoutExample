package bytes.wit.databinding;

/**
 * Created by Md. Sifat-Ul Haque on 3/8/2017.
 */

public class PlaceModel {

    private String placeName, placeDescription, imageUrl;

    public PlaceModel(String name, String description, String url){
        placeName = name;
        imageUrl = url;
        placeDescription = description;
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
}
