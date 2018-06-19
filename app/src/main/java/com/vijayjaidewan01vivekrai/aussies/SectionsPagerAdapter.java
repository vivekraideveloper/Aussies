package com.vijayjaidewan01vivekrai.aussies;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by MR VIVEK RAI on 31-05-2018.
 */
class SectionsPagerAdapter extends FragmentPagerAdapter {


    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Tweets tweets = new Tweets();
                return tweets;


            case 1:
                Blogs blogs = new Blogs();
                return blogs;

            case 2:

                Videos videos = new Videos();
                return videos;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Posts";

            case 1:
                return "Blogs";

            case 2:
                return "Videos";

            default:
                return null;
        }

    }

}