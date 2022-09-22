package vplstore.shoeshop.data;

import android.content.Context;

import vplstore.shoeshop.data.dao.CategoryDao;
import vplstore.shoeshop.data.dao.ProductDao;
import vplstore.shoeshop.data.implement.CategoryDaoImplement;
import vplstore.shoeshop.data.implement.ProductDaoImplement;

public class DatabaseSQlite extends DatabaseDao{
    private Context context;

    public DatabaseSQlite(Context context){
        this.context = context;
    }
    @Override
    public CategoryDao getCategoryDao() {
        return new CategoryDaoImplement(context);
    }

    @Override
    public ProductDao getProductDao() {
        return new ProductDaoImplement(context);
    }


}
