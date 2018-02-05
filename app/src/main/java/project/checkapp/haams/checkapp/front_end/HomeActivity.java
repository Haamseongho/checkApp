package project.checkapp.haams.checkapp.front_end;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import project.checkapp.haams.checkapp.R;
import project.checkapp.haams.checkapp.front_adapters.SectionStateAdapter;

public class HomeActivity extends AppCompatActivity {

    private ViewPager mViewPager;  // ViewPager
    private TabLayout mTab; // Tab >> Home , section1,2,3,4,5
    private SectionStateAdapter sectionStateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
    }

    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.mainPager);
        mTab = (TabLayout) findViewById(R.id.main_tab_header);

        mTab.setSelectedTabIndicatorHeight(10);
        mTab.setSelectedTabIndicatorColor(Color.WHITE);
        mTab.setBackgroundColor(Color.LTGRAY);

        mTab.addTab(mTab.newTab().setText("Home"));
        mTab.addTab(mTab.newTab().setText("Sect1"));
        mTab.addTab(mTab.newTab().setText("Sect2"));
        mTab.addTab(mTab.newTab().setText("Sect3"));
        mTab.addTab(mTab.newTab().setText("Sect4"));
        mTab.addTab(mTab.newTab().setText("Sect5"));

        sectionStateAdapter = new SectionStateAdapter(getSupportFragmentManager(), mTab.getTabCount());

        mViewPager.setAdapter(sectionStateAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab){
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
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
