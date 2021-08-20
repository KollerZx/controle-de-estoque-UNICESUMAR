package controleDeEstoque;

import org.jetbrains.annotations.Contract;

import java.util.Scanner;

public class ControleDeEstoque {
    /* QUANTIDADE DE TIPOS DE PRODUTOS QUE A EMPRESA TRABALHA
    *  TEM POR FINALIDADE DELIMITAR O CADASTRO DE 10 TIPOS DE PRODUTOS,
    *  VALOR ESSE QUE PODERÁ SER ALTERADO CASO SE INCLUA UM NOVO TIPO / DEPARTAMENTO
    * */
    static int DEPARTAMENTOS = 10;
    static int tam = 0;

    /* INSTANCIA UMA LISTA DE PRODUTOS, QUE PODERÁ CONTER 10 DE TIPOS DE PRODUTOS, QUE SÃO SEPARADOS POR DEPARTAMENTO*/
    static Produto listaDeProdutos[] = new Produto[DEPARTAMENTOS];

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
                case 0:
                    continue;
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
                        tam++;

                        break;
                    }
                    else if(opt == 3){
                        //retorna o produto armazenado, incluir essa instrução na rotina de consulta

                        if(estoque.listaDeProdutos[0] == null) {
                            System.out.println("Não existem produtos cadastrados");
                            continue;
                        }
                        for(int i=0; i < estoque.listaDeProdutos.length; i++){

                            estoque.listaDeProdutos[i].getProduto();
                        }

                        continue;
                    }
                    else if(opt == 0){
                        continue;
                    }

                    break;
                default:
                    System.out.println("Escolha uma opção válida");
                    break;
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