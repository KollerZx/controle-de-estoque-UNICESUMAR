package tests;

import InventoryControl.RegisterProducts;
import InventoryControl.Product;

import java.util.Scanner;

public class TestCreate {
    public static void main(String[] args) throws Exception {

        try {
            RegisterProducts estoque = new RegisterProducts(3);
            Scanner scan = new Scanner(System.in);
            estoque.addProduct(new Product("camiseta",50,1,15));
            estoque.addProduct(new Product("camiseta",109,1,10));
            estoque.addProduct(new Product("blusa",145,1,8));

            var product = estoque.findProductByName("camiseta");
            estoque.getListProduct()[product].getProduct();
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
