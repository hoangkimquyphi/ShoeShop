package vplstore.shoeshop;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vplstore.shoeshop.data.model.Product;
import vplstore.shoeshop.ui.adapter.ProductAdapter;
import vplstore.shoeshop.ui.constract.ProductConstract;
import vplstore.shoeshop.ui.constract.ProductPresenter;

public class ProductActivity extends AppCompatActivity implements ProductConstract.IView {
    private ProductConstract.IPresenter mPresenter;
    private  RecyclerView rc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
//        Product product = new Product("Cà rốt",20,20000,R.drawable.raucu,1);
////
//        mPresenter = new ProductPresenter(this);
//        mPresenter.insertProduct(product);

        initGUI();
        initData();
    }

    private void initGUI(){
        rc.findViewById(R.id.new_product_rv);
        rc.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initData(){
        mPresenter = new ProductPresenter(this);
        mPresenter.setView(this);
        mPresenter.getProductList();
    }
    @Override
    public void setProductListToView(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(productList);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public void setHotProductsToView(List<Product> productList) {

    }

    @Override
    public void setNewProductsToView(List<Product> productList) {

    }

    @Override
    public void showProduct(Product product) {

    }
}