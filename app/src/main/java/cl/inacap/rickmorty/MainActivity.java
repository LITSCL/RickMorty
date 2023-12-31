package cl.inacap.rickmorty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import cl.inacap.rickmorty.adapters.TabsNavPageAdapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager vp;
    private TabLayout tl;
    private TabsNavPageAdapter tpa;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        this.vp = findViewById(R.id.viewPager);
        this.tl = findViewById(R.id.tabLayout);
        this.tpa = new TabsNavPageAdapter(getSupportFragmentManager());
        this.vp.setAdapter(this.tpa);
        this.tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}