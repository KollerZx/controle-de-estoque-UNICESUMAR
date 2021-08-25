package tests;

import InventoryControl.Controllers;
import InventoryControl.Product;
import InventoryControl.RegisterProducts;

public class TestReport {
    public static void main(String[] args) throws Exception {
        try {
            RegisterProducts estoque = new RegisterProducts(3);
            //Scanner scan = new Scanner(System.in);
            estoque.addProduct(new Product("camiseta",50,1,15));
            estoque.addProduct(new Product("jeans",109,1,10));
            estoque.addProduct(new Product("blusa",145,1,8));

            Controllers.reportProducts(estoque);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
