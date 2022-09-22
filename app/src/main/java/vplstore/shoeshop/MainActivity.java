package vplstore.shoeshop;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import vplstore.shoeshop.ui.fragment.FavouriteFragment;
import vplstore.shoeshop.ui.fragment.HomeFragment;
import vplstore.shoeshop.ui.fragment.SearchFragment;
import vplstore.shoeshop.ui.fragment.OrderFragment;
import vplstore.shoeshop.ui.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Fragment fragment = new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initGUI();
    }

    private void initGUI(){
        bottomNavigationView  = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                        return true;
                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new SearchFragment()).commit();
                        return true;
                    case R.id.favotrites:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FavouriteFragment()).commit();
                        return true;
                    case R.id.order:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new OrderFragment()).commit();
                        return true;
                    case R.id.user:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new UserFragment()).commit();
                        return true;
                }
                return false;
            }
        });
    }
}