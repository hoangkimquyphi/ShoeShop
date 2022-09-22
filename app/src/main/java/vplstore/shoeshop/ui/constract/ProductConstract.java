package vplstore.shoeshop.ui.constract;
import java.util.List;

import vplstore.shoeshop.data.model.Product;

public interface ProductConstract {
    interface IView{
        void setProductListToView(List<Product> productList);
        void setHotProductsToView(List<Product> productList);
        void setNewProductsToView(List<Product> productList);
        void showProduct(Product product);
    }

    interface IPresenter{
        void setView(IView view);
        void getProductList();
        void getProduct(int productId);
        void getHotProducts();
        void getNewProducts();

        void insertProduct(Product product);
    }
}
