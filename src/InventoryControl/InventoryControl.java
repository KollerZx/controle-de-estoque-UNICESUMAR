package InventoryControl;

import javax.naming.Binding;
import java.util.Scanner;

public class InventoryControl {
    /* QUANTIDADE DE TIPOS DE PRODUTOS QUE A EMPRESA TRABALHA
    *  TEM POR FINALIDADE DELIMITAR O CADASTRO DE 10 TIPOS DE PRODUTOS,
    *  VALOR ESSE QUE PODERÁ SER ALTERADO CASO SE INCLUA UM NOVO TIPO / DEPARTAMENTO
    * */
    static int DEPARTAMENTS = 10;

    public static void main(String[] args) throws Exception {
        int opcao=9;
        Scanner scan = new Scanner(System.in);
        /* CRIA UM ESTOQUE, QUE PODERÁ CONTER 10 DE TIPOS DE PRODUTOS, QUE SÃO SEPARADOS POR DEPARTAMENTO*/
        RegisterProducts estoque = new RegisterProducts(DEPARTAMENTS);
        while(opcao!=0){
            menuMain();
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao){
                case 0:
                    continue;

                    // CADASTRO DE PRODUTOS
                case 1:
                    RegisterProducts.menuRegister();
                    opcao = scan.nextInt();
                    // INCLUSÃO DE PRODUTO
                    if(opcao == 1){
                        System.out.println("Digite o nome do Produto:");
                        String nome = scan.next();
                        System.out.println("Informe o preço Unitário:");
                        float preco = scan.nextFloat();
                        System.out.println("Informe a unidade do produto:");
                        int unidade = scan.nextInt();
                        System.out.println("Informe a quantidade de produtos a somar no estoque:");
                        int qtd = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Deseja confirmar a Operação? ");
                        String option = scan.next();
                        if(confirmOperation(option)){
                            estoque.addProduct(new Product(nome,preco,unidade,qtd));
                        }
                        else{
                            System.out.println("Operação ignorada!");
                            continue;
                        }
                    }

//                  ALTERAÇÃO DE PRODUTO
                    else if(opcao == 2){
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

                        }
                    }

//                  CONSULTA PRODUTO POR NOME
                    else if(opcao == 3){

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
                        break;
                    }

//                  EXCLUSÃO DE PRODUTO
                    else if(opcao == 4){

                    }

//                  RETORNAR AO MENU ANTERIOR
                    else if(opcao == 0){
                        RegisterProducts.menuRegister();
                    }
                    // -----------------------------------------------------//

//              MOVIMENTAÇÃO
                case 2:
                    RegisterProducts.menuInventoryMovement();
                    opcao = scan.nextInt();

//                  RETORNAR
                    if(opcao == 0){
                        break;
                    }
//                  ENTRADA
                    else if(opcao == 1){
                        System.out.println(" ------------- ENTRADA DE ESTOQUE --------------");
                        System.out.println("Informe o nome do produto que deseja: ");
                        String nome = scan.next();
                        int indiceProduct = estoque.findProductByName(nome);

                        if(indiceProduct > -1){
                            var qtdInventoryActually = estoque.getListProduct()[indiceProduct].getQtdInventory();
                            System.out.println("Quantidade atual em estoque: " + qtdInventoryActually);

                            System.out.println("Informe a quantidade de entrada no estoque: ");
                            int qtdInventory = scan.nextInt();

                            System.out.println("Deseja confirmar a Operação? ");
                            String option = scan.next();
                            if(confirmOperation(option)) {
                                estoque.inputStock(indiceProduct,qtdInventory);
                                var qtdInventoryUpdated = estoque.getListProduct()[indiceProduct].getQtdInventory();
                                System.out.println("Quantidade estoque atualizada: " + qtdInventoryUpdated);
                            }
                        }
                    }

//                  SAÍDA
                    else if(opcao == 2){
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
                            if(confirmOperation(option)) {
                                estoque.outputStock(indiceProduct, qtdInventory);

                                var qtdInventoryUpdated = estoque.getListProduct()[indiceProduct].getQtdInventory();

                                System.out.println("Quantidade estoque atualizada: " + qtdInventoryUpdated);
                            }
                        }
                    }

//              REAJUSTE DE PREÇOS
                case 3:

                default:
                    System.out.println("Escolha uma opção válida");
                    break;
            }
        };
    }

    static void menuMain(){
        System.out.println("MENU PRINCIPAL");
        System.out.println("1 - CADASTRO DE PRODUTOS");
        System.out.println("2 - MOVIMENTAÇÃO");
        System.out.println("3 - REAJUSTE DE PREÇOS");
        System.out.println("4 - RELATÓRIOS");
        System.out.println("0 - FINALIZAR \n");
        System.out.print("OPÇÃO: ");
    }

    public static boolean confirmOperation(String option){
        if(option.equalsIgnoreCase("sim" ) || option.equalsIgnoreCase("s")){
            return true;
        }
        return false;
    }
}