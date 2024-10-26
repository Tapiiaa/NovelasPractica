package com.example.novelaspractica.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.novelaspractica.R;
import com.example.novelaspractica.Novel;

import java.util.ArrayList;
import java.util.List;

public class NovelAdapter extends RecyclerView.Adapter<NovelAdapter.NovelHolder> {

    private List<Novel> novels = new ArrayList<>();

    @NonNull
    @Override
    public NovelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.novel_item, parent, false);
        return new NovelHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NovelHolder holder, int position) {
        Novel currentNovel = novels.get(position);
        holder.textViewTitle.setText(currentNovel.getTitle());
        holder.textViewAuthor.setText(currentNovel.getAuthor());
    }

    @Override
    public int getItemCount() {
        return novels.size();
    }

    public void setNovels(List<Novel> novels) {
        this.novels = novels;
        notifyDataSetChanged();
    }

    class NovelHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewAuthor;

        public NovelHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewAuthor = itemView.findViewById(R.id.text_view_author);
        }
    }

    public List<Novel> getNovels() {
        return novels;
    }
}

