package vplstore.shoeshop.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vplstore.shoeshop.R;
import vplstore.shoeshop.data.model.Category;
import vplstore.shoeshop.data.model.Product;
import vplstore.shoeshop.ui.adapter.CategoryAdapter;
import vplstore.shoeshop.ui.adapter.ProductAdapter;
import vplstore.shoeshop.ui.constract.HomeFragmentConstract;
import vplstore.shoeshop.ui.constract.HomeFragmentPresenter;

public class HomeFragment extends Fragment implements HomeFragmentConstract.IView {
    private HomeFragmentConstract.IPresenter mPresenter;
    private RecyclerView rc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        initGUI(rootView);
        initData();

        return rootView;
    }

    private void initGUI(View rootView){
        rc = rootView.findViewById(R.id.category_rv);
        rc.setLayoutManager(new LinearLayoutManager(getContext()));

//        rc = rootView.findViewById(R.id.new_product_rv);
//        rc.setLayoutManager(new LinearLayoutManager(getContext()));



    }

    private void initData(){
        mPresenter = new HomeFragmentPresenter(getContext());
        mPresenter.setView(this);
        mPresenter.getCategoryList();
//        mPresenter.getProductList();

    }

    @Override
    public void setCategoryListToView(List<Category> categoryList) {
        CategoryAdapter adapter = new CategoryAdapter(categoryList);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void showCategory(Category category) {

    }

    @Override
    public void setProductListToView(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(productList);
        rc.setAdapter(adapter);
        rc.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void showProduct(Product product) {

    }
}
