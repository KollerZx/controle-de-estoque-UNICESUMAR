package tests;

import InventoryControl.Controllers;
import InventoryControl.Product;
import InventoryControl.RegisterProducts;

import java.util.Scanner;

public class TestRemove {
    public static void main(String[] args) {
        try {
            RegisterProducts estoque = new RegisterProducts(3);
            Scanner scan = new Scanner(System.in);
            estoque.addProduct(new Product("camiseta",50,1,15));
            estoque.addProduct(new Product("jeans",109,1,10));
            estoque.addProduct(new Product("blusa",145,1,8));
            Controllers.removeProduct(estoque);

            //estoque.getListProduct()[estoque.getListProduct().length].getProduct();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
