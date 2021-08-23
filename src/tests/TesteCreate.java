package tests;

import InventoryControl.RegisterProducts;
import InventoryControl.Product;

import java.util.Scanner;

public class TesteCreate {
    public static void main(String[] args) throws Exception {

        try {
            RegisterProducts estoque = new RegisterProducts(5);
            Scanner scan = new Scanner(System.in);
            estoque.addProduct(new Product("camiseta",50,1,15));
            estoque.addProduct(new Product("camiseta",24,1,15));

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
