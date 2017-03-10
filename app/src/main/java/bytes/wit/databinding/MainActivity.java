package bytes.wit.databinding;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import bytes.wit.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ArrayList<PlaceModel> placeModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        placeModels = Utils.getPlaceInfo(this);
        binding.setPlaceModel(placeModels.get(0));
    }
}
