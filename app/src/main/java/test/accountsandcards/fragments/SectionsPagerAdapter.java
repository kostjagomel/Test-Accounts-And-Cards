package test.accountsandcards.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import test.accountsandcards.buisness.model.Card;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private List<Card> cards;

    public SectionsPagerAdapter(FragmentManager fm, List<Card> cards) {
        super(fm);
        this.cards = cards;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Log.d(getClass().getSimpleName(),"getItem position=" + position);
        return PlaceholderFragment.newInstance(position + 1,cards.get(position));
    }

    @Override
    public int getCount() {
        return cards.size();
    }
}