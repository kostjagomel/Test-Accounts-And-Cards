package test.accountsandcards.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.List;

import test.accountsandcards.R;

public class RecyclerInfoAdapter extends RecyclerView.Adapter<RecyclerInfoAdapter.InfoViewHolder> {

    List<Info> infos;

    public RecyclerInfoAdapter(List<Info> infos) {
        this.infos = infos;
    }

    @Override
    public InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_view,parent,false);
        InfoViewHolder infoViewHolder = new InfoViewHolder(v);
        return infoViewHolder;
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, int position) {
        if(infos.get(position).name!=null)
            holder.textName.setText(infos.get(position).name);
        else holder.textName.setVisibility(View.GONE);

        if(infos.get(position).value!=null)
            holder.textValue.setText(infos.get(position).value);
        else holder.textValue.setVisibility(View.GONE);

        if(infos.get(position).imageId!=0)
            holder.imageButton.setImageResource(infos.get(position).imageId);
        else holder.imageButton.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return infos.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder {
        View view;
        TextView textName;
        TextView textValue;
        ImageButton imageButton;

        public InfoViewHolder(View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.info_view);
            textName = itemView.findViewById(R.id.text_name);
            textValue =  itemView.findViewById(R.id.text_value);
            imageButton = itemView.findViewById(R.id.imageButton);
        }
    }

    public static class Info{
        String name;
        String value;
        int imageId;

        public Info(String name, String value, int imageId) {
            this.name = name;
            this.value = value;
            this.imageId = imageId;

        }
    }
}
