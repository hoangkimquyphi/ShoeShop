package vplstore.shoeshop.data.implement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vplstore.shoeshop.data.DatabaseHelper;
import vplstore.shoeshop.data.dao.ProductDao;
import vplstore.shoeshop.data.model.Product;

public class ProductDaoImplement extends DatabaseHelper implements ProductDao {
    public ProductDaoImplement(Context context) {
        super(context);
    }

    @Override
    public Product find(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("products", null, "id = ?", new String[] { String.valueOf(id) },null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Product product = new Product(cursor.getInt(0), cursor.getString(1),  cursor.getString(2), cursor.getString(3),  cursor.getDouble(4), cursor.getInt(5), cursor.getInt(6));
        return product;
    }

    @Override
    public List<Product> all() {
        List<Product>  productList = new ArrayList<>();
        String query = "SELECT * FROM products";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {
            Product product = new Product(cursor.getInt(0), cursor.getString(1),  cursor.getString(2), cursor.getString(3),  cursor.getDouble(4), cursor.getInt(5), cursor.getInt(6));
            productList.add(product);
            cursor.moveToNext();
        }
        return productList;
    }

    @Override
    public void insert(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("name", product.name);
        values.put("img", product.img);
        values.put("description", product.description);
        values.put("price", product.price);
        values.put("quantity", product.quantity);
        values.put("categoryId", product.categoryId);


        db.insert("products", null, values);
        db.close();
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public List<Product> getHotProducts() {
        return null;
    }

    @Override
    public List<Product> getNewProducts() {
        return null;
    }
}
