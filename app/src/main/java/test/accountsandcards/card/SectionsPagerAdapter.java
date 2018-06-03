package test.accountsandcards.card;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<String> cards;

    public SectionsPagerAdapter(FragmentManager fm, ArrayList<String> cards) {
        super(fm);
        this.cards = cards;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1,cards.get(position));
    }

    @Override
    public int getCount() {
        return cards.size();
    }
}