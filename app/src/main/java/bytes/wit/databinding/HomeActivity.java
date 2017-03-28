package bytes.wit.databinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import bytes.wit.databinding.databinding.ActivityHomeBinding;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<PlaceModel> placeModels = new ArrayList<>();
    private EventHandler eventHandler;
    private ActivityHomeBinding binding;
    private int mColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        placeModels = Utils.getPlaceInfo(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        eventHandler = new EventHandler();
        binding.setPlaceModel(placeModels.get(0));
        binding.setEventCallBack(eventHandler);
        setSupportActionBar(binding.appBarHome.toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.appBarHome.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            startActivity(new Intent(this, UserSignUpActivity.class));
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public class EventHandler{
        public void onPreviousClicked(View view, PlaceModel placeModel) {
            Toast.makeText(HomeActivity.this,placeModel.getPlaceName(),Toast.LENGTH_SHORT).show();
            //binding.appBarHome.content.colorPicker.setColor(Color.GREEN);
            placeModels.get(0).setColor(Color.GREEN);
        }
        public void onNextClicked(View view, PlaceModel placeModel) {
            Toast.makeText(HomeActivity.this,placeModel.getPlaceName(),Toast.LENGTH_SHORT).show();
            //binding.appBarHome.content.colorPicker.setColor(Color.RED);
            placeModels.get(0).setColor(Color.RED);
        }

        public void onColorChanged(int color){
            Toast.makeText(HomeActivity.this,"Color "+color,Toast.LENGTH_SHORT).show();
        }
    }
}
