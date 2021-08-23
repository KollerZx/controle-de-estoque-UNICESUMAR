package InventoryControl;


public class RegisterProducts {
    private Product[] listaDeProdutos;
    private int qtdProdutos;

    public RegisterProducts(int capacidade){
        this.listaDeProdutos = new Product[capacidade];
        this.qtdProdutos = 0;
    }

    public Product[] getListProduct(){
        return this.listaDeProdutos;
    }

    public void addProduct(Product elemento) throws Exception {
        try{
            if(validDataProducts(elemento)){
                this.listaDeProdutos[this.qtdProdutos] = elemento;
                this.qtdProdutos++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public int findProduct(String name){
        if(this.qtdProdutos == 0){ return -1; }
        for(int i=0; i < this.qtdProdutos; i++ ){
            if(this.listaDeProdutos[i].getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }
    public boolean validDataProducts(Product elemento) throws Exception {
        var isValid = false;
        if(this.findProduct(elemento.getName()) > -1){
            isValid = true;
            throw new Exception("Já existe um produto cadastrado com o mesmo nome");
        }
        if(this.qtdProdutos < this.listaDeProdutos.length) {
            isValid = true;
            throw new Exception("Não foi possivel cadastrar o produto, pois não há mais espaço em estoque");
        }
        //inserir validação para verificar se valor, unidade e qtd são maior que zero

        return isValid;

    }

    public static void menuRegister(){
        System.out.println("CADASTRO DE PRODUTOS:");
        System.out.println("1.1 - INCLUSÃO");
        System.out.println("1.2 - ALTERAÇÃO");
        System.out.println("1.3 - CONSULTA");
        System.out.println("1.4 - EXCLUSÃO");
        System.out.println("0 - RETORNAR");

        System.out.println("OPÇÃO: ");

    }





}
