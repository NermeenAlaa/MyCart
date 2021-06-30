package com.example.mycartshopping.viewmodels;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mycartshopping.models.CartItem;
import com.example.mycartshopping.models.Product;
import com.example.mycartshopping.repositories.CartRebo;
import com.example.mycartshopping.repositories.ShopRebo;

import java.util.List;

public class ShopViewModel extends ViewModel {

    ShopRebo shopRepo = new ShopRebo();
    CartRebo cartRepo = new CartRebo();

    MutableLiveData<Product> mutableProduct = new MutableLiveData<>();

   // public LiveData<List<Product>> getProducts() {
     //   return shopRepo.getProducts();
    //}

    public void setProduct(Product product) {
        mutableProduct.setValue(product);
    }

    public LiveData<Product> getProduct() {
        return mutableProduct;
    }

    public LiveData<List<CartItem>> getCart() {
        return cartRepo.getCart();
    }

    public boolean addItemToCart(Product product) {
        return cartRepo.addItemToCart(product);
    }

    public void removeItemFromCart(CartItem cartItem) {
        cartRepo.removeItemFromCart(cartItem);
    }

    public void changeQuantity(CartItem cartItem, int quantity) {
        cartRepo.changeQuantity(cartItem, quantity);
    }

    public LiveData<Double> getTotalPrice() {
        return cartRepo.getTotalPrice();
    }

    public void resetCart() {
        cartRepo.initCart();
    }

}