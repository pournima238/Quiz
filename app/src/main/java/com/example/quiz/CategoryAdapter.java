package com.example.quiz;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewholder> {
    public CategoryAdapter(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    private List<CategoryModel> categoryModelList;
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
     holder.setData(categoryModelList.get(position).getImageUrl(),categoryModelList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    class viewholder extends RecyclerView.ViewHolder{
        private CircleImageView imageview;
        private TextView title;


        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageview=itemView.findViewById(R.id.image_view);
            title=itemView.findViewById(R.id.title);

        }
        private void setData(String url, final String title){
            Glide.with(itemView.getContext()).load(url).into(imageview);
            this.title.setText(title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent setIntent=new Intent(itemView.getContext(),SetsActivity.class);
                    setIntent.putExtra("title",title);
                    itemView.getContext().startActivity(setIntent);

                }
            });


        }

    }

}
