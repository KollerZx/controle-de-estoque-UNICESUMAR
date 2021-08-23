package InventoryControl;

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
                    int opt = scan.nextInt();
                    if(opt == 1){
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
                    else if(opt == 3){

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
                        break;
                    }
                    else if(opt == 0){
                        continue;
                    }
                    // -----------------------------------------------------//
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

    static boolean confirmOperation(String option){
        if(option.equalsIgnoreCase("sim" ) || option.equalsIgnoreCase("s")){
            return true;
        }
        return false;
    }
}