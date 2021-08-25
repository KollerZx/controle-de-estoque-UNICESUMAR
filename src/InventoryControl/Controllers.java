package InventoryControl;

import java.util.Scanner;

public class Controllers {
    public static boolean confirmOperation(String option){
        if(option.equalsIgnoreCase("sim" ) || option.equalsIgnoreCase("s")){
            return true;
        }
        return false;
    }

    public static void changeProduct(RegisterProducts estoque) throws Exception {
        boolean changeAgain = false;

        do{
            System.out.println("ALTERAÇÃO");
            Scanner scan = new Scanner(System.in);
            System.out.println(" ATENÇÃO: Essa opção só deve ser utilizada para correção do produto cadastrado");
            System.out.println(" Para entrada e saída do estoque, utilizar a funcionalidade MOVIMENTAÇÃO");
            System.out.println(" Deseja continuar e alterar a quantidade em estoque?");
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
                }
            }
        }while(changeAgain);

    }

    public static void includeProduct(RegisterProducts estoque) throws Exception{
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

    public static void findProduct(RegisterProducts estoque) throws Exception{
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

    public static void removeProduct(RegisterProducts estoque) throws Exception{
        Scanner scan = new Scanner(System.in);
        System.out.println("Lista de produtos no estoque");
        reportProducts(estoque);
        System.out.println("Informe o nome do produto a ser removido");
        String nome = scan.next();
        int index = estoque.findProductByName(nome);
        estoque.removeProduct(index);

        System.out.println("Lista de produtos no estoque após remoção");
        reportProducts(estoque);
    }

    public static void inputStock(RegisterProducts estoque) throws Exception{
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

    public static void outputStock(RegisterProducts estoque) throws Exception{
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

    public static void percentPriceAdjust(RegisterProducts estoque) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o nome do produto que deseja atualizar o preço: ");
        String nome = scan.next();
        int indiceProduct = estoque.findProductByName(nome);
        if(indiceProduct > -1){
            System.out.println("Dados do produto: ");
            estoque.getListProduct()[indiceProduct].getProduct();
            System.out.println("Informe o percentual(%) de ajuste: ");
            float percent = scan.nextFloat();
            System.out.println("Deseja confirmar a alteração?");
            String opcao = scan.next();
            if(confirmOperation(opcao)){
                estoque.percentPriceAdjust(indiceProduct,percent);
                System.out.println("Dados do produto apos a atualização");
                estoque.getListProduct()[indiceProduct].getProduct();
            }
        }
        else{
            System.out.println("Não foi encontrado nenhum produto com esse nome");
        }
    }

    public static void reportProducts(RegisterProducts estoque) throws Exception {
        Product[] productList = estoque.getListProduct();

        for (int index = 0; index < (productList.length); index++) {
            if(productList[index] == null){
                continue;
            }
            System.out.println("Produto - " + (index+1));
            productList[index].getProduct();
        }
    }
}
