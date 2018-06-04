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
    private static final String CARD_TITLE = "CARD_TITLE";
    private static final String AMOUNT = "AMOUNT";
    private static final String NUMBER = "NUMBER";
    private static final String ACCOUNT_TYPE = "ACCOUNT_TYPE";

    public PlaceholderFragment() {
    }


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber, Card card) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putString(CARD_TITLE, card.getCardTitle());
        args.putString(AMOUNT, card.getCardAmount() + card.getCardCurrency());
        args.putString(NUMBER, card.getAccountNumber());
        args.putString(ACCOUNT_TYPE, card.getCardAccountType());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cards, container, false);
        TextView cardTitleView = rootView.findViewById(R.id.card_title_view);
        cardTitleView.setText(getArguments().getString(CARD_TITLE));

        TextView textCardAmount = rootView.findViewById(R.id.text_card_amount);
        textCardAmount.setText(getArguments().getString(AMOUNT));

        TextView accountTypeView = rootView.findViewById(R.id.text_card_account_type);
        accountTypeView.setText(getArguments().getString(ACCOUNT_TYPE));


        RecyclerView rvCards = rootView.findViewById(R.id.infos_view);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rvCards.setLayoutManager(llm);


        List<RecyclerInfoAdapter.Info> infos = new ArrayList<>();
        infos.add(new RecyclerInfoAdapter.Info(null,"ДЕТАЛИ СЧЕТА",0));
        infos.add(new RecyclerInfoAdapter.Info("Название счета",getArguments().getString(CARD_TITLE),R.drawable.ic_info_edit));
        infos.add(new RecyclerInfoAdapter.Info("Номер счета",getArguments().getString(NUMBER),R.drawable.ic_info_share));
        infos.add(new RecyclerInfoAdapter.Info("Тип счета",getArguments().getString(ACCOUNT_TYPE),0));
        infos.add(new RecyclerInfoAdapter.Info("Доступные средства",getArguments().getString(AMOUNT),0));


        RecyclerInfoAdapter recyclerInfoAdapter = new RecyclerInfoAdapter(infos);
        rvCards.setAdapter(recyclerInfoAdapter);

        return rootView;
    }
}
