package View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.lms.R;
import com.example.lms.databinding.ActivityMainBinding;
import View.fragment.DailyFragment;
import View.fragment.DataFragment;
import View.fragment.PersonFragment;
import View.fragment.ShopFragment;
import View.fragment.TaskFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    private ActivityMainBinding binding;
    private FragmentTransaction fragmentTransaction;
    private Fragment[] fragments;
    private int lastFragmentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViews();
    }

    protected void initViews(){
        BottomNavigationView bottomNavigationView = binding.bottomNavigationView;
        bottomNavigationView.setOnItemSelectedListener(this);
        fragments = new Fragment[] {
                new PersonFragment(),
                new DailyFragment(),
                new TaskFragment(),
                new ShopFragment(),
                new DataFragment() };
        fragmentTransaction =  getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_frame, fragments[0]).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.page_person:
                switchFragment(0);
                break;
            case R.id.page_daily:
                switchFragment(1);
                break;
            case R.id.page_task:
                switchFragment(2);
                break;
            case R.id.page_shop:
                switchFragment(3);
                break;
            case R.id.page_data:
                switchFragment(4);
                break;
        }
        return false;
    }

    private void switchFragment(int towardsIndex) {

        if(lastFragmentIndex == towardsIndex) {
            return;
        }
        fragmentTransaction =  getSupportFragmentManager().beginTransaction();
        if(!fragments[towardsIndex].isAdded()) {
            fragmentTransaction.add(R.id.main_frame, fragments[towardsIndex]);
        }
        fragmentTransaction.hide(fragments[lastFragmentIndex])
                .show(fragments[towardsIndex])
                .commitNowAllowingStateLoss();
        lastFragmentIndex = towardsIndex;
    }
}

