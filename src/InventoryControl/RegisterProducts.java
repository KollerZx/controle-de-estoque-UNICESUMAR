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

    public void addProduct(Product elemento) throws Exception{
            if(!productNameAlreadyExists(elemento)){
                this.listaDeProdutos[this.qtdProdutos] = elemento;
                this.qtdProdutos++;
            }

    }

    public void updateProduct(int index, float price, int unit, int qtd) throws Exception{
        this.listaDeProdutos[index].setPriceUnit(price);
        this.listaDeProdutos[index].setUnit(unit);
        this.listaDeProdutos[index].setQtdInventory(qtd);


    }

    public void removeProduct(String nome){

    }

    public void inputStock(int indice, int qtdProduct) throws Exception {
        if(qtdProduct == 0){
            throw new Exception("Deve-se informar um valor maior que zero para Entrada");
        }
        var stockActually = this.listaDeProdutos[indice].getQtdInventory();
        var updateStock = stockActually + qtdProduct;
        this.listaDeProdutos[indice].setQtdInventory(updateStock);
    }

    public void outputStock(int indice, int qtdProduct) throws Exception {
        if(qtdProduct == 0){
            throw new Exception("Deve-se informar um valor maior que zero para Saída");
        }
        var stockActually = this.listaDeProdutos[indice].getQtdInventory();
        var updateStock = stockActually - qtdProduct;
        this.listaDeProdutos[indice].setQtdInventory(updateStock);
    }

    public int findProductByName(String name){
        if(this.qtdProdutos == 0){ return -1; }
        for(int i=0; i < this.qtdProdutos; i++ ){
            if(this.listaDeProdutos[i].getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }

    private boolean productNameAlreadyExists(Product elemento) throws Exception{
        var productExists = false;
        if(this.findProductByName(elemento.getName()) > -1){
            productExists = true;
            throw new Exception("Já existe um produto cadastrado com o mesmo nome");
        }
        return productExists;
    }

    private boolean checkStockAvailable() throws Exception {
        var isValid = true;
        if(this.qtdProdutos > this.listaDeProdutos.length) {
            isValid = false;
            throw new Exception("Não foi possivel cadastrar o produto, pois não há mais espaço em estoque");
        }
        return isValid;

    }

}
