package test.accountsandcards;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import test.accountsandcards.buisness.Logic;
import test.accountsandcards.buisness.model.Card;
import test.accountsandcards.fragments.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.

        Logic.getInstance().updateContent(this, new Logic.LogicCallback() {
            @Override
            public void update(final List<Card> cards) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (Card card:cards)
                        Log.d(getClass().getSimpleName(),"Card = "  + card.getAccountNumber());


                        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),cards);

                        // Set up the ViewPager with the sections adapter.
                        mViewPager = (ViewPager) findViewById(R.id.container);
                        mViewPager.setAdapter(mSectionsPagerAdapter);
                    }
                });
            }
        });



    }

}
