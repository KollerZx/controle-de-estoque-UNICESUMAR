package InventoryControl;

import java.util.Scanner;

public class Controllers {
    private Scanner scan;

    public Controllers(){
        this.scan = new Scanner(System.in);
    }
    public boolean confirmOperation(String option){
        if(option.equalsIgnoreCase("sim" ) || option.equalsIgnoreCase("s")){
            return true;
        }
        return false;
    }

    private boolean repeatOperation(){
        boolean again;
        System.out.println("Deseja repetir a operação?");
        String option = this.scan.next();
        if(confirmOperation(option)){
            again = true;
        }
        else{
            again = false;
            System.out.println("Retornando ao menu anterior");
        }
        return again;
    }

    public void changeProduct(RegisterProducts estoque) throws Exception {
        boolean changeAgain = false;

        do{
            System.out.println("ALTERAÇÃO");

            System.out.println(" ATENÇÃO: Essa opção só deve ser utilizada para correção do produto cadastrado. \n" +
                                "Para entrada e saída do estoque, utilizar a funcionalidade MOVIMENTAÇÃO\n" +
                                "Deseja continuar e alterar as informações do produto?");

            String opcao = this.scan.next();

            if(confirmOperation(opcao)){
                System.out.println("Informe o nome do produto a ser alterado: ");
                String nome = this.scan.next();
                int productUpdate = estoque.findProductByName(nome);
                if(productUpdate > -1) {
                    var listaDeProdutos = estoque.getListProduct();
                    listaDeProdutos[productUpdate].getProduct();
                    System.out.println("Informe os dados de atualização abaixo:");
                    System.out.println("novo preço Unitário:");
                    float preco = this.scan.nextFloat();
                    System.out.println("nova unidade do produto:");
                    int unidade = this.scan.nextInt();
                    System.out.println("Informe a quantidade em estoque: ");
                    int qtd = this.scan.nextInt();
                    this.scan.nextLine();
                    System.out.println("Deseja confirmar a alteração");
                    opcao = this.scan.next();
                    if(confirmOperation(opcao)){
                        estoque.updateProduct(productUpdate, preco, unidade,qtd);
                    }
                    else{
                        System.out.println("Operação cancelada, retornando ao menu anterior");
                        continue;
                    }
                }

                else{
                    System.out.println("\n O produto informado não existe! \n");
                }

                changeAgain = repeatOperation();
            }
        }while(changeAgain);

    }

    public void includeProduct(RegisterProducts estoque) throws Exception{
        boolean registerAgain;

        do{
            System.out.println("Digite o nome do Produto:");
            String nome = this.scan.next();
            System.out.println("Informe o preço Unitário:");
            float preco = this.scan.nextFloat();
            System.out.println("Informe a unidade do produto:");
            int unidade = this.scan.nextInt();
            System.out.println("Informe a quantidade de produtos a somar no estoque:");
            int qtd = this.scan.nextInt();
            this.scan.nextLine();
            System.out.println("Deseja confirmar a Operação? ");
            String option = this.scan.next();

            if(confirmOperation(option)){
                estoque.addProduct(new Product(nome,preco,unidade,qtd));
            }
            else{
                System.out.println("Operação ignorada!");
                registerAgain = false;
                continue;

            }

            registerAgain = repeatOperation();

        }
        while(registerAgain);
    }

    public void findProduct(RegisterProducts estoque) throws Exception{
        boolean findAgain;

        do {
            System.out.println("Digite o nome do produto que deseja consultar: ");
            String nome = this.scan.next();
            int indiceDoProduto = estoque.findProductByName(nome);

            if (indiceDoProduto > -1) {
                Product[] listaDeProdutos = estoque.getListProduct();
                listaDeProdutos[indiceDoProduto].getProduct();
            } else {
                System.out.println("Não existe produto com esse nome");
            }

            findAgain = repeatOperation();
        }while(findAgain);
    }

    public void removeProduct(RegisterProducts estoque) throws Exception{
        boolean removeAgain;
            do {
                System.out.println("Lista de produtos no estoque");
                reportProducts(estoque);
                System.out.println("Informe o nome do produto a ser removido");
                String nome = this.scan.next();
                int index = estoque.findProductByName(nome);
                estoque.removeProduct(index);

                System.out.println("Lista de produtos no estoque após remoção");
                reportProducts(estoque);

                removeAgain = repeatOperation();
            }while(removeAgain);
    }

    public void inputStock(RegisterProducts estoque) throws Exception{
        System.out.println(" ------------- ENTRADA DE ESTOQUE --------------");
        boolean repeat;

        try {
            do {
                System.out.println("Informe o nome do produto que deseja: ");
                String nome = this.scan.next();
                int indiceProduct = estoque.findProductByName(nome);

                if (indiceProduct > -1) {
                    estoque.getListProduct()[indiceProduct].getProduct();

                    System.out.println("Informe a quantidade de entrada no estoque: ");
                    int qtdInventory = this.scan.nextInt();

                    System.out.println("Deseja confirmar a Operação? ");
                    String option = this.scan.next();
                    if (confirmOperation(option)) {
                        estoque.inputStock(indiceProduct, qtdInventory);
                        int qtdInventoryUpdated = estoque.getListProduct()[indiceProduct].getQtdInventory();
                        System.out.println("Quantidade estoque atualizada: " + qtdInventoryUpdated);
                    }
                } else {
                    System.out.println("\n O Produto informado não existe! \n");
                }
                repeat = repeatOperation();
            } while (repeat);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void outputStock(RegisterProducts estoque) throws Exception{
        System.out.println(" ------------- SAÍDA DE ESTOQUE --------------\n");
        boolean repeat;
        try{
            do{
            System.out.println("Informe o nome do produto que deseja: ");
            String nome = this.scan.next();
            int indiceProduct = estoque.findProductByName(nome);

            if(indiceProduct > -1){
                int qtdInventoryActually = estoque.getListProduct()[indiceProduct].getQtdInventory();
                System.out.println("Quantidade atual em estoque: " + qtdInventoryActually);

                System.out.println("Informe a quantidade de saída do estoque: ");
                int qtdInventory = this.scan.nextInt();

                System.out.println("Deseja confirmar a Operação? ");
                String option = this.scan.next();
                if(confirmOperation(option)) {
                    estoque.outputStock(indiceProduct, qtdInventory);

                    int qtdInventoryUpdated = estoque.getListProduct()[indiceProduct].getQtdInventory();

                    System.out.println("Quantidade estoque atualizada: " + qtdInventoryUpdated);
                }
            }else{
                System.out.println("\n O Produto informado não existe! \n");
            }
            repeat = repeatOperation();
        }while(repeat);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void percentPriceAdjust(RegisterProducts estoque) throws Exception {
        boolean repeat;

        do{
            System.out.println("Informe o nome do produto que deseja atualizar o preço: ");
            String nome = this.scan.next();
            int indiceProduct = estoque.findProductByName(nome);
            if(indiceProduct > -1){
                System.out.println("Dados do produto: ");
                estoque.getListProduct()[indiceProduct].getProduct();
                System.out.println("Informe o percentual(%) de ajuste: ");
                float percent = this.scan.nextFloat();
                System.out.println("Deseja confirmar a alteração?");
                String opcao = this.scan.next();
                if(confirmOperation(opcao)){
                    estoque.percentPriceAdjust(indiceProduct,percent);
                    System.out.println("Dados do produto apos a atualização");
                    estoque.getListProduct()[indiceProduct].getProduct();
                }
            }
            else{
                System.out.println("Não foi encontrado nenhum produto com esse nome");
            }

            repeat = repeatOperation();
        }while(repeat);

    }

    public void reportProducts(RegisterProducts estoque) throws Exception {
        System.out.println("\n Lista de Produtos disponíveis: \n");
        Product[] productList = estoque.getListProduct();

        for (int index = 0; index < (productList.length); index++) {
            if(productList[0] == null){
                System.out.println("\n NÃO HÁ PRODUTOS NO ESTOQUE \n");
                break;
            }
            if(productList[index] == null){
                continue;
            }
            System.out.println("Produto - " + (index+1));
            productList[index].getProduct();
        }
    }
}
