package vplstore.shoeshop.data;


import vplstore.shoeshop.data.dao.CategoryDao;
import vplstore.shoeshop.data.dao.ProductDao;

public abstract class DatabaseDao {
    private static DatabaseDao instance;
    public static void init(DatabaseDao inst){
        instance = inst;
    }
    public static DatabaseDao getInstance(){
        return instance;
    }
    public abstract CategoryDao getCategoryDao();
    public abstract ProductDao getProductDao();

}
