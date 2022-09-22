package vplstore.shoeshop.data.dao;
import java.util.List;

import vplstore.shoeshop.data.model.Product;

public interface ProductDao  {
    Product find(int id);
    List<Product> all();
    void insert(Product product);
    void update(Product product);
    void delete(int id);
    List<Product> findByName(String name);
    List<Product> getHotProducts();
    List<Product> getNewProducts();
}
