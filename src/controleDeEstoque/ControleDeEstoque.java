package controleDeEstoque;

import java.util.Scanner;

public class ControleDeEstoque {
    static int ESTOQUE_MAXIMO = 10;
    static int tam = 0;
    Produto listaDeProdutos[] = new Produto[ESTOQUE_MAXIMO];
    public static void main(String[] args) {
        int opcao=9;
        Scanner scan = new Scanner(System.in);
        ControleDeEstoque estoque = new ControleDeEstoque();
        while(opcao!=0){
            menuPrincipal();
            System.out.print("OPÇÃO: ");
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao){
                case 1:
                    CadastroDeProdutos.menu();
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
                        estoque.listaDeProdutos[tam] = new CadastroDeProdutos(nome, preco, unidade, qtd);
                    }
                    //retorna o produto armazenado, incluir essa instrução na rotina de consulta
                   //estoque.listaDeProdutos[0].getProduto();
            }
        };


    }

    static void menuPrincipal(){
        System.out.println("MENU PRINCIPAL");
        System.out.println("1 - CADASTRO DE PRODUTOS");
        System.out.println("2 - MOVIMENTAÇÃO");
        System.out.println("3 - REAJUSTE DE PREÇOS");
        System.out.println("4 - RELATÓRIOS");
        System.out.println("0 - FINALIZAR");

    }

}