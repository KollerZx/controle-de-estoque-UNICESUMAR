package tests;

import InventoryControl.RegisterProducts;
import InventoryControl.Product;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) throws Exception {

        try {
            RegisterProducts estoque = new RegisterProducts(5);
            Scanner scan = new Scanner(System.in);
            estoque.addProduct(new Product("camiseta",25,1,15));
            estoque.addProduct(new Product("jeans",0,1,15));
            System.out.println("Digite o nome do produto que deseja consultar: ");
            String nome = scan.next();
            int indiceDoProduto = estoque.findProduct(nome);

            if(indiceDoProduto > -1){
                Product[] listaDeProdutos = estoque.getListProduct();
                listaDeProdutos[indiceDoProduto].getProduct();
            }
            else{
                System.out.println("Não existe produto com esse nome");
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
