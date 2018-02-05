package project.checkapp.haams.checkapp.front_adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import project.checkapp.haams.checkapp.main_fragments.TypeSection1;
import project.checkapp.haams.checkapp.main_fragments.TypeSection2;
import project.checkapp.haams.checkapp.main_fragments.TypeSection3;
import project.checkapp.haams.checkapp.main_fragments.TypeSection4;
import project.checkapp.haams.checkapp.main_fragments.TypeSection5;

/**
 * Created by haams on 2018-02-05.
 */

public class SectionStateAdapter extends FragmentStatePagerAdapter {

    private int pageNum;

    public SectionStateAdapter(FragmentManager fm, int pageNum) {
        super(fm);
        this.pageNum = pageNum;
    }

    public SectionStateAdapter(FragmentManager fm) {
        super(fm);
    }

    public static Fragment getFragmentInstance(int pageNum){
        Fragment fragment = null;
        switch (pageNum){
            case 0:
                fragment = TypeSection1.newInstance("fragment1","section1");
                break;

            case 1:
                fragment = TypeSection2.newInstance("fragment2","section2");
                break;

            case 2:
                fragment = TypeSection3.newInstance("fragment3","section3");
                break;

            case 3:
                fragment = TypeSection4.newInstance("fragment4","section4");
                break;

            case 4:
                fragment = TypeSection5.newInstance("fragment5","section5");
                break;
        }
        return fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return getFragmentInstance(position);
    }

    @Override
    public int getCount() {
        return pageNum;
    }
}
