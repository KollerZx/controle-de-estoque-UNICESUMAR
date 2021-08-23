package InventoryControl;

public class Product {
    protected String name;
    protected float priceUnit;
    protected int unit;
    private int qtdInventory;

    public Product(String name, float priceUnit, int unit, int qtdInventory){

        setName(name);
        setPriceUnit(priceUnit);
        setUnit(unit);
        setQtdInventory(qtdInventory);
    }

    public void setName(String nome){
        this.name = nome;
    }

    public void setPriceUnit(float precoUnitario) {
        this.priceUnit = precoUnitario;
    }

    public void setUnit(int unidade) {
        this.unit = unidade;
    }

    public void setQtdInventory(int qtdEstoque) {
        this.qtdInventory = qtdEstoque;
    }

    public String getName() {
        return this.name;
    }

    public float getPriceUnit() {
        return this.priceUnit;
    }

    public int getUnit() {
        return this.unit;
    }

    public int getQtdInventory() {
        return this.qtdInventory;
    }

    public void getProduct(){
        System.out.println("Nome: " + getName());
        System.out.println("Preço: " + getPriceUnit());
        System.out.println("Unidade: " + getUnit());
        System.out.println("Quantidade: " + getQtdInventory());
        System.out.println();
    }


}
