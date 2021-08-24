package InventoryControl;

import java.util.Scanner;

public class InventoryControl {
    /* QUANTIDADE DE TIPOS DE PRODUTOS QUE A EMPRESA TRABALHA
    *  TEM POR FINALIDADE DELIMITAR O CADASTRO DE 10 TIPOS DE PRODUTOS,
    *  VALOR ESSE QUE PODERÁ SER ALTERADO CASO SE INCLUA UM NOVO TIPO / DEPARTAMENTO
    * */
    static int DEPARTAMENTS = 10;

    public static void main(String[] args) throws Exception {

        try{
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
                        System.out.println("Deseja realmente sair do programa?");
                        String option =scan.next();
                        if(confirmOperation(option)){
                            continue;
                        }
                        opcao = 1;
                        break;
//                  CADASTRO DE PRODUTOS
                    case 1:
                        menuRegister();
                        opcao = scan.nextInt();
//                      INCLUSÃO DE PRODUTO
                        if(opcao == 1){
                            includeProduct(estoque);
                            break;
                        }
//                      ALTERAÇÃO DE PRODUTO
                        else if(opcao == 2){
                            changeProduct(estoque);
                            break;
                        }
//                      CONSULTA PRODUTO POR NOME
                        else if(opcao == 3){
                            findProduct(estoque);
                            break;
                        }
//                      EXCLUSÃO DE PRODUTO
                        else if(opcao == 4){
                            removeProduct(estoque);
                            break;
                        }
//                      RETORNAR AO MENU ANTERIOR
                        else if(opcao == 0){
                            opcao = 1;
                            continue;
                        }
                        // -----------------------------------------------------//

//                  MOVIMENTAÇÃO
                    case 2:
                        menuInventoryMovement();
                        opcao = scan.nextInt();
//                      RETORNAR
                        if(opcao == 0){
                            opcao = 1;
                            continue;
                        }
//                      ENTRADA
                        else if(opcao == 1){
                            inputStock(estoque);
                            break;
                        }
//                      SAÍDA
                        else if(opcao == 2){
                            outputStock(estoque);
                            break;
                        }

//                  REAJUSTE DE PREÇOS
                    case 3:
                        updatePrice(estoque);
                        break;

                    default:
                        System.out.println("Escolha uma opção válida");
                        break;
                }
            };
        }catch (Exception e){
            e.printStackTrace();
        }

    }


//    MENUS
    private static void menuMain(){
        System.out.println("MENU PRINCIPAL");
        System.out.println("1 - CADASTRO DE PRODUTOS");
        System.out.println("2 - MOVIMENTAÇÃO");
        System.out.println("3 - REAJUSTE DE PREÇOS");
        System.out.println("4 - RELATÓRIOS");
        System.out.println("0 - FINALIZAR \n");
        System.out.print("OPÇÃO: ");
    }

    private static void menuRegister(){
        System.out.println("CADASTRO DE PRODUTOS:");
        System.out.println("1.1 - INCLUSÃO");
        System.out.println("1.2 - ALTERAÇÃO");
        System.out.println("1.3 - CONSULTA");
        System.out.println("1.4 - EXCLUSÃO");
        System.out.println("0 - RETORNAR");

        System.out.println("OPÇÃO: ");

    }

    private static void menuInventoryMovement(){
        System.out.println("MOVIMENTAÇÃO:");
        System.out.println("1 - ENTRADA");
        System.out.println("2 - SAÍDA");
        System.out.println("0 - RETORNAR");
        System.out.println("OPÇÃO: ");
    }

//    --------------------------------------------

    public static boolean confirmOperation(String option){
        if(option.equalsIgnoreCase("sim" ) || option.equalsIgnoreCase("s")){
            return true;
        }
        return false;
    }

    private static void changeProduct(RegisterProducts estoque) throws Exception {
        boolean changeAgain = false;

        do{
            System.out.println("ALTERAÇÃO");
            Scanner scan = new Scanner(System.in);
            System.out.println(" ATENÇÃO: Essa opção só deve ser utilizada para correção do produto cadastrado");
            System.out.println("Para entrada e saída do estoque, utilizar a funcionalidade MOVIMENTAÇÃO");
            System.out.println("Deseja continuar e alterar a quantidade em estoque?");
            String opcao = scan.next();

            if(confirmOperation(opcao)){
                System.out.println("Informe o nome do produto a ser alterado: ");
                String nome = scan.next();
                int productUpdate = estoque.findProductByName(nome);
                if(productUpdate > -1) {
                    var listaDeProdutos = estoque.getListProduct();
                    listaDeProdutos[productUpdate].getProduct();

                    System.out.println("Informe os dados de atualização abaixo:");
                    System.out.println("novo preço Unitário:");
                    float preco = scan.nextFloat();
                    System.out.println("nova unidade do produto:");
                    int unidade = scan.nextInt();

                    System.out.println("Informe a quantidade em estoque: ");
                    int qtd = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Deseja confirmar a alteração");
                    opcao = scan.next();
                    if(confirmOperation(opcao)){
                        estoque.updateProduct(productUpdate, preco, unidade,qtd);
                    }
                    else{
                        System.out.println("Operação cancelada, retornando ao menu anterior");
                        continue;
                    }
                }
                else{
                    System.out.println("O produto não existe no estoque");
                }
                System.out.println("Deseja repetir a operação?");
                opcao = scan.next();
                if(confirmOperation(opcao)){
                    changeAgain = true;
                }
                else{
                    changeAgain = false;
                    System.out.println("Retornando ao menu anterior");
                    continue;
                }
            }

        }while(changeAgain);

    }

    private static void includeProduct(RegisterProducts estoque) throws Exception{
        boolean registerAgain = false;
        Scanner scan = new Scanner(System.in);
        do{
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
                registerAgain = false;
                continue;

            }
            System.out.println("Deseja repetir a Operação?");
            option = scan.next();
            if(confirmOperation(option)){
                registerAgain = true;
            }else{
                System.out.println("Retornando ao menu anterior");
                registerAgain = false;
            }
        }
        while(registerAgain);
    }

    private static void findProduct(RegisterProducts estoque) throws Exception{
        Scanner scan = new Scanner(System.in);
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

    private static void removeProduct(RegisterProducts estoque) throws Exception{

    }

    private static void inputStock(RegisterProducts estoque) throws Exception{
        System.out.println(" ------------- ENTRADA DE ESTOQUE --------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o nome do produto que deseja: ");
        String nome = scan.next();
        int indiceProduct = estoque.findProductByName(nome);

        if(indiceProduct > -1){
            int qtdInventoryActually = estoque.getListProduct()[indiceProduct].getQtdInventory();
            System.out.println("Quantidade atual em estoque: " + qtdInventoryActually);

            System.out.println("Informe a quantidade de entrada no estoque: ");
            int qtdInventory = scan.nextInt();

            System.out.println("Deseja confirmar a Operação? ");
            String option = scan.next();
            if(confirmOperation(option)) {
                estoque.inputStock(indiceProduct,qtdInventory);
                int qtdInventoryUpdated = estoque.getListProduct()[indiceProduct].getQtdInventory();
                System.out.println("Quantidade estoque atualizada: " + qtdInventoryUpdated);
            }
        }
    }

    private static void outputStock(RegisterProducts estoque) throws Exception{
        System.out.println(" ------------- SAÍDA DE ESTOQUE --------------");
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o nome do produto que deseja: ");
        String nome = scan.next();
        int indiceProduct = estoque.findProductByName(nome);

        if(indiceProduct > -1){
            int qtdInventoryActually = estoque.getListProduct()[indiceProduct].getQtdInventory();
            System.out.println("Quantidade atual em estoque: " + qtdInventoryActually);

            System.out.println("Informe a quantidade de saída do estoque: ");
            int qtdInventory = scan.nextInt();

            System.out.println("Deseja confirmar a Operação? ");
            String option = scan.next();
            if(confirmOperation(option)) {
                estoque.outputStock(indiceProduct, qtdInventory);

                int qtdInventoryUpdated = estoque.getListProduct()[indiceProduct].getQtdInventory();

                System.out.println("Quantidade estoque atualizada: " + qtdInventoryUpdated);
            }
        }
    }

    private static void updatePrice(RegisterProducts estoque) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o nome do produto que deseja atualizar o preço: ");
        String nome = scan.next();
        int indiceProduct = estoque.findProductByName(nome);
        if(indiceProduct > -1){
            System.out.println("Dados do produto: ");
            estoque.getListProduct()[indiceProduct].getProduct();
            System.out.println("Informe o novo preço");
            float newPrice = scan.nextFloat();
            System.out.println("Deseja confirmar a alteração?");
            String opcao = scan.next();
            if(confirmOperation(opcao)){
                estoque.getListProduct()[indiceProduct].setPriceUnit(newPrice);
                System.out.println("Dados do produto apos a atualização");
                estoque.getListProduct()[indiceProduct].getProduct();
            }
        }
        else{
            System.out.println("Não foi encontrado nenhum produto com esse nome");
        }
    }



}