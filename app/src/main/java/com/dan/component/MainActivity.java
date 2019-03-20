package com.dan.component;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.dan.libraryrouter.router.RouterPath;

public class MainActivity extends AppCompatActivity {
    RadioButton bottomHome;
    RadioGroup radioGroup;
    private Fragment[] list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    protected void initView() {
        bottomHome = findViewById(R.id.bottom_home);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bottom_home:
                        changeFragment(1);
                        break;
                    case R.id.bottom_sort:
                        changeFragment(2);
                        break;
                    case R.id.bottom_cart:
                        changeFragment(3);
                        break;
                    case R.id.bottom_user:
                        changeFragment(4);
                        break;
                }
            }
        });
        Fragment fragmentTravel = (Fragment) ARouter.getInstance().build(RouterPath.DEMO_TRAVEL).navigation();
        Fragment fragmentWork = (Fragment) ARouter.getInstance().build(RouterPath.DEMO_MY).navigation();;
        Fragment fragmentOrder = (Fragment) ARouter.getInstance().build(RouterPath.DEMO_TRAVEL).navigation();
        Fragment fragmentMine = (Fragment) ARouter.getInstance().build(RouterPath.DEMO_MY).navigation();
        list = new Fragment[]{fragmentTravel, fragmentWork, fragmentOrder, fragmentMine};
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        beginTransaction.add(R.id.main, fragmentTravel);
        beginTransaction.add(R.id.main, fragmentWork);
        beginTransaction.add(R.id.main, fragmentOrder);
        beginTransaction.add(R.id.main, fragmentMine);
        beginTransaction.commit();
        showHome();
    }


    public void showHome() {
        bottomHome.setChecked(true);
        changeFragment(1);
    }

    public void changeFragment(int index) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < list.length; i++) {
            if (i + 1 != index) {
                // 隐藏选项卡
                fragmentTransaction.hide(list[i]);
            } else {
                // 显示选项卡
                fragmentTransaction.show(list[i]);

            }
        }
        fragmentTransaction.commitAllowingStateLoss();
    }
}
