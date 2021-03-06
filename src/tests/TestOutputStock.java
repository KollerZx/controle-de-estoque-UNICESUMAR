package tests;

import InventoryControl.Controllers;
import InventoryControl.Product;
import InventoryControl.RegisterProducts;

import java.util.Scanner;


public class TestOutputStock {
    public static void main(String[] args) throws Exception {
        try {
            RegisterProducts estoque = new RegisterProducts(3);
            Scanner scan = new Scanner(System.in);
            estoque.addProduct(new Product("camiseta", 50, 1, 15));
            estoque.addProduct(new Product("blusa", 145, 1, 8));

            System.out.println(" ------------- SAÍDA DE ESTOQUE --------------");
            System.out.println("Informe o nome do produto que deseja: ");
            String nome = scan.next();
            int indiceProduct = estoque.findProductByName(nome);

            if(indiceProduct > -1){
                var qtdInventoryActually = estoque.getListProduct()[indiceProduct].getQtdInventory();
                System.out.println("Quantidade atual em estoque: " + qtdInventoryActually);

                System.out.println("Informe a quantidade de saída do estoque: ");
                int qtdInventory = scan.nextInt();

                System.out.println("Deseja confirmar a Operação? ");
                String option = scan.next();
                if(Controllers.confirmOperation(option)) {
                    estoque.outputStock(indiceProduct, qtdInventory);

                    var qtdInventoryUpdated = estoque.getListProduct()[indiceProduct].getQtdInventory();

                    System.out.println("Quantidade estoque atualizada: " + qtdInventoryUpdated);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}