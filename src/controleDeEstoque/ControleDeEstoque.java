package controleDeEstoque;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.Scanner;

public class ControleDeEstoque {
    /* QUANTIDADE DE TIPOS DE PRODUTOS QUE A EMPRESA TRABALHA
    *  TEM POR FINALIDADE DELIMITAR O CADASTRO DE 10 TIPOS DE PRODUTOS,
    *  VALOR ESSE QUE PODERÁ SER ALTERADO CASO SE INCLUA UM NOVO TIPO / DEPARTAMENTO
    * */
    static int DEPARTAMENTOS = 10;
    static int tam = 0;

    public static void main(String[] args) throws Exception {
        int opcao=9;
        Scanner scan = new Scanner(System.in);

        /* CRIA UM ESTOQUE, QUE PODERÁ CONTER 10 DE TIPOS DE PRODUTOS, QUE SÃO SEPARADOS POR DEPARTAMENTO*/
        CadastroDeProdutos estoque = new CadastroDeProdutos(DEPARTAMENTOS);


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

                        /*if(tam !=0){
                            for(int i=0; i < tam; i++ ){

                                if(estoque.getListaDeProdutos()[i].getNome().equalsIgnoreCase(nome)){
                                    System.out.println("Ja existe um produto com esse nome");
                                    break;
                                }
                            }
                            break;
                        }*/



                        System.out.println("Informe o preço Unitário:");
                        float preco = scan.nextFloat();
                        System.out.println("Informe a unidade do produto:");
                        int unidade = scan.nextInt();
                        System.out.println("Informe a quantidade de produtos a somar no estoque:");
                        int qtd = scan.nextInt();
                        scan.nextLine();
                        estoque.addProduto(new Produto(nome,preco,unidade,qtd));
                        tam++;

                        break;
                    }
                    else if(opt == 3){
                        //retorna o produto armazenado, incluir essa instrução na rotina de consulta

                        /*

                        if(listaDeProdutos[0] == null) {
                            System.out.println("Não existem produtos cadastrados");
                            continue;
                        }
                        for(int i=0; i < listaDeProdutos.length; i++){

                            listaDeProdutos[i].getProduto();
                        }

                        continue;

                        */
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