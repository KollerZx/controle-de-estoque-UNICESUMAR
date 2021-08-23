package tests;

import InventoryControl.Product;
import InventoryControl.RegisterProducts;

import java.util.Scanner;

public class TestFind {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        RegisterProducts estoque = new RegisterProducts(5);
        estoque.addProduct(new Product("Jeans",65,1,15));
        estoque.addProduct(new Product("camiseta",70,1,80));
        System.out.println("Digite o nome do produto que deseja consultar: ");
        String nome = scan.next();
        int indiceDoProduto = estoque.findProductByName(nome);

        if(indiceDoProduto > -1){
            Product[] listaDeProdutos = estoque.getListProduct();
            listaDeProdutos[indiceDoProduto].getProduct();
        }
        else{
            System.out.println("Não existe produto com esse nome");
        }
    }
}
