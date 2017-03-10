package bytes.wit.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import bytes.wit.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ArrayList<PlaceModel> placeModels = new ArrayList<>();
    private EventHandler eventHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        eventHandler = new EventHandler();
        placeModels = Utils.getPlaceInfo(this);
        binding.setPlaceModel(placeModels.get(0));
        binding.setEventCallBack(eventHandler);
    }

    public class EventHandler{
        public void onPreviousClicked(View view, PlaceModel placeModel) {
            Toast.makeText(MainActivity.this,placeModel.getPlaceName(),Toast.LENGTH_SHORT).show();
        }
        public void onNextClicked(View view, PlaceModel placeModel) {
            Toast.makeText(MainActivity.this,placeModel.getPlaceName(),Toast.LENGTH_SHORT).show();
        }
    }
}