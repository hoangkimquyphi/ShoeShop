package vplstore.shoeshop.ui.constract;

import java.util.List;

import vplstore.shoeshop.data.model.Category;
import vplstore.shoeshop.data.model.Product;

public interface HomeFragmentConstract {
    interface IView{
        void setCategoryListToView(List<Category> categoryList);
        void showCategory(Category category);

        void setProductListToView(List<Product> productList);
        void showProduct(Product product);
    }

    interface IPresenter{
        void setView(IView view);
        void getCategoryList();
        void getProductList();
        void getCategory(int categoryId);
        void insertCategory(Category category);
    }
}
