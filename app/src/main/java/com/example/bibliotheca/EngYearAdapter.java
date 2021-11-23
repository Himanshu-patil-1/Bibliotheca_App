package com.example.bibliotheca;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EngYearAdapter extends RecyclerView.Adapter<EngYearAdapter.EngYearViewHolder> {

    private List<EngYear> engYears;

    public EngYearAdapter(List<EngYear> engYears) {
        this.engYears = engYears;
    }

    @NonNull
    @Override
    public EngYearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EngYearViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_year,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull EngYearViewHolder holder, int position) {
            holder.setYearData(engYears.get(position));
    }

    @Override
    public int getItemCount() {
        return engYears.size();
    }

    static class EngYearViewHolder extends RecyclerView.ViewHolder {

        private KenBurnsView kbvYear;
        private TextView textTitle, textYear, textLatest;

        EngYearViewHolder(@NonNull View itemView) {
            super(itemView);
            kbvYear = itemView.findViewById(R.id.kbvYear);
            textTitle = itemView.findViewById(R.id.textTitle);
            textYear = itemView.findViewById(R.id.textYear);
            textLatest = itemView.findViewById(R.id.textLatest);
        }
        void setYearData(EngYear engYear){
            Picasso.get().load(engYear.imageUrl).into(kbvYear);
            textTitle.setText(engYear.title);
            textYear.setText(String.valueOf(engYear.textLatest));
        }
    }
}
