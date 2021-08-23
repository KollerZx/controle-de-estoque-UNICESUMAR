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
        var isValid = true;
        if(this.findProduct(elemento.getName()) > -1){
            isValid = false;
            throw new Exception("Já existe um produto cadastrado com o mesmo nome");
        }
        if(this.qtdProdutos > this.listaDeProdutos.length) {
            isValid = false;
            throw new Exception("Não foi possivel cadastrar o produto, pois não há mais espaço em estoque");
        }
        if((elemento.getPriceUnit() <= 0) || (elemento.getUnit() <= 0 ) || (elemento.getQtdInventory() <= 0) ){
            isValid = false;
            throw new Exception("O Produto não pode ter valor, unidade, ou quantidade igual a zero");
        }

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
