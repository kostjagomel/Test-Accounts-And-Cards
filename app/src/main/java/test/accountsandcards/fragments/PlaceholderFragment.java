package test.accountsandcards.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.accountsandcards.R;
import test.accountsandcards.buisness.model.Card;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber, Card card) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_NUMBER, card.getCardTitle());
//        args.putString(ARG_SECTION_NUMBER, "" + sectionNumber + card);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cards, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.cardTitleView);
//        textName.setText(getString(R.string.section_format) + getArguments().getString(ARG_SECTION_NUMBER));
        textView.setText(getArguments().getString(ARG_SECTION_NUMBER));


        RecyclerView rvCards = (RecyclerView)rootView.findViewById(R.id.infos_view);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rvCards.setLayoutManager(llm);


        RecyclerInfoAdapter.Info info = new RecyclerInfoAdapter.Info(getArguments().getString(ARG_SECTION_NUMBER),"ahahahhahahaha");
        List<RecyclerInfoAdapter.Info> infos = new ArrayList<>();
        infos.add(info);
        infos.add(info);
        infos.add(info);
        infos.add(info);


        RecyclerInfoAdapter recyclerInfoAdapter = new RecyclerInfoAdapter(infos);
        rvCards.setAdapter(recyclerInfoAdapter);

        return rootView;
    }
}
