package vplstore.shoeshop.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import vplstore.shoeshop.R;
import vplstore.shoeshop.data.model.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> productList;

    public ProductAdapter( List<Product> productList){
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        return new ViewHolder(view);
    }

    @NonNull

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
//        holder.imgProduct.setImageResource(product.img);
        holder.tvProductName.setText(product.name);
        holder.tvPrice.setText((int) product.price);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgProduct;
        private TextView tvProductName;
        private TextView tvPrice;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            tvProductName = itemView.findViewById(R.id.tv_productname);
            tvPrice = itemView.findViewById(R.id.tv_price);
        }
    }
}
