package tests;

import InventoryControl.Product;
import InventoryControl.RegisterProducts;

import java.util.Scanner;

public class TestUpdated {
    public static void main(String[] args) throws Exception{
        try{
            RegisterProducts estoque = new RegisterProducts(5);
            Scanner scan = new Scanner(System.in);
            estoque.addProduct(new Product("camiseta",25,1,15));


            System.out.println("ALTERAÇÃO");
            System.out.println("Informe o nome do produto a ser alterado: ");
            String nome = scan.next();
            var productUpdate = estoque.findProductByName(nome);
            if(productUpdate > -1) {
                var listaDeProdutos = estoque.getListProduct();
                listaDeProdutos[productUpdate].getProduct();

                System.out.println("Informe os dados de atualização abaixo:");
                System.out.println("novo preço Unitário:");
                float preco = scan.nextFloat();
                System.out.println("nova unidade do produto:");
                int unidade = scan.nextInt();
                System.out.println("Quantidade de produtos a somar no estoque:");
                int qtd = scan.nextInt();
                scan.nextLine();

                estoque.updateProduct(productUpdate, preco, unidade,qtd);

                listaDeProdutos[productUpdate].getProduct();



            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
