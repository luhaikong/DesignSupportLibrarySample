package com.design.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

public class BottomNavigationActivity extends BaseActivity {

    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        initFragment();
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item1:
                        currentFragment = new FiveFragment("吴小龙1");
                        switchContent(currentFragment);
                        return true;
                    case R.id.item2:
                        currentFragment = new FiveFragment("吴小龙2");
                        switchContent(currentFragment);
                        return true;
                    case R.id.item3:
                        currentFragment = new FiveFragment("吴小龙3");
                        switchContent(currentFragment);
                        return true;
                }
                return false;
            }
        });
    }

    private void initFragment() {
        currentFragment = new FiveFragment("吴小龙1");
        switchContent(currentFragment);
    }

    public void switchContent(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contentLayout, fragment).commit();
    }
}
