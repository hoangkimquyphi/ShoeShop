package vplstore.shoeshop.ui.constract;

import android.content.Context;

import java.util.List;

import vplstore.shoeshop.data.DatabaseDao;
import vplstore.shoeshop.data.DatabaseSQlite;
import vplstore.shoeshop.data.model.Product;

public class ProductPresenter implements ProductConstract.IPresenter {
    private ProductConstract.IView mView;
    public ProductPresenter(Context context){
        DatabaseDao.init((new DatabaseSQlite(context)));
    }

    @Override
    public void setView(ProductConstract.IView view) {
        mView = view;
    }

    @Override
    public void getProductList() {
        List<Product> productList = DatabaseDao.getInstance().getProductDao().all();
        mView.setProductListToView(productList);
    }

    @Override
    public void getProduct(int productId) {
        Product product = DatabaseDao.getInstance().getProductDao().find(productId);
        mView.showProduct(product);
    }

    @Override
    public void getHotProducts() {

    }

    @Override
    public void getNewProducts() {

    }

    @Override
    public void insertProduct(Product product) {
        DatabaseDao.getInstance().getProductDao().insert(product);
    }
}
