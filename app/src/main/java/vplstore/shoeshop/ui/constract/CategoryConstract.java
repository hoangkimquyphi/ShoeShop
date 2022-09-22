package vplstore.shoeshop.ui.constract;

import java.util.List;

import vplstore.shoeshop.data.model.Product;

public interface CategoryConstract {
    interface IView{
        void setProductListToView(List<Product> productList);
    }

    interface IPresenter{
        void setView(HomeFragmentConstract.IView view);
        void getProductList(int categoryId);
    }
}
