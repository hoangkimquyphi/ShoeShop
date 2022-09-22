package vplstore.shoeshop.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import vplstore.shoeshop.R;
import vplstore.shoeshop.data.model.Category;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private List<Category> categoryList;
    private Context context;

public CategoryAdapter(List<Category> categoryList){
    this.context = context;
    this.categoryList = categoryList;
}

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_category, parent, false);

        return new ViewHolder(view);
}

@Override
public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Category category = categoryList.get(position);
    holder.tvName.setText(category.name);
    holder.imageView.setImageResource(category.image);

//    holder.itemView.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Intent intent = new Intent(context, ProductActivity.class);
//            intent.putExtra(Constants.CATEGORY_NAME, category.name);
//            context.startActivity(intent);
//        }
//    });
}

@Override
public int getItemCount() {
        return categoryList.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder{
    private TextView tvName;
    private ImageView imageView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tv_name);
        imageView = itemView.findViewById(R.id.imgView);
    }
}
}