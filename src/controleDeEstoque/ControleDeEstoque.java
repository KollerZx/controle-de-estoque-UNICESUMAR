package controleDeEstoque;

import java.util.Scanner;

public class ControleDeEstoque {
    /* QUANTIDADE DE TIPOS DE PRODUTOS QUE A EMPRESA TRABALHA
    *  TEM POR FINALIDADE DELIMITAR O CADASTRO DE 10 TIPOS DE PRODUTOS,
    *  VALOR ESSE QUE PODERÁ SER ALTERADO CASO SE INCLUA UM NOVO TIPO / DEPARTAMENTO
    * */
    static int DEPARTAMENTOS = 10;

    public static void main(String[] args) throws Exception {
        int opcao=9;
        Scanner scan = new Scanner(System.in);

        /* CRIA UM ESTOQUE, QUE PODERÁ CONTER 10 DE TIPOS DE PRODUTOS, QUE SÃO SEPARADOS POR DEPARTAMENTO*/
        CadastroDeProdutos estoque = new CadastroDeProdutos(DEPARTAMENTOS);


        while(opcao!=0){
            menuPrincipal();
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao){
                case 0:
                    continue;
                case 1:
                    CadastroDeProdutos.menuRegister();
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
                        estoque.addProduto(new Produto(nome,preco,unidade,qtd));

                        break;
                    }
                    else if(opt == 3){
                        //retorna o produto armazenado, incluir essa instrução na rotina de consulta
                        System.out.println("Digite o nome do produto que deseja consultar: ");
                        String nome = scan.next();
                        int indiceDoProduto = estoque.findProduct(nome);

                        if(indiceDoProduto > -1){
                            Produto[] listaDeProdutos = estoque.getListaDeProdutos();
                            listaDeProdutos[indiceDoProduto].getProduto();
                        }
                        else{
                            System.out.println("Não existe produto com esse nome");
                        }


                        break;
                    }
                    else if(opt == 0){
                        continue;
                    }
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
        System.out.println("0 - FINALIZAR \n");
        System.out.print("OPÇÃO: ");

    }


}