package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Insumos {

    private int id;
    private String[] insumos = {"Mancuernas","Barras","Press Banca","Puching Bag"};
    private int[] precios = {25000, 12000, 120000, 35000};
    private int[] adicional = {3750, 1800, 18000, 5250};
    private int stock;

    public Insumos()
    {}

    public Insumos(int id, String[] insumos, int[] precios, int stock) {
        this.id = id;
        this.insumos = insumos;
        this.precios = precios;
        this.adicional = adicional;
        this.stock = stock;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getInsumos() {
        return insumos;
    }

    public void setInsumos(String[] insumos) {
        this.insumos = insumos;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int[] getAdicional() {
        return adicional;
    }

    public void setAdicional(int[] adicional) {
        this.adicional = adicional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insumos insumos1 = (Insumos) o;
        return id == insumos1.id && stock == insumos1.stock && Arrays.equals(insumos, insumos1.insumos) && Arrays.equals(precios, insumos1.precios);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, stock);
        result = 31 * result + Arrays.hashCode(insumos);
        result = 31 * result + Arrays.hashCode(precios);
        return result;
    }

    @Override
    public String toString() {
        return "Insumos{" +
                "id=" + id +
                ", insumos=" + Arrays.toString(insumos) +
                ", precios=" + Arrays.toString(precios) +
                ", stock=" + stock +
                '}';
    }

    public int resultadoMan(int precios, int adicional)
    {
        return precios+adicional;

    }
    public int resultadoBarra(int precios, int adicional)
    {
        return precios+adicional;

    }
    public int resultadoPres(int precios, int adicional)
    {
        return precios+adicional;

    }
    public int resultadoPuch(int precios, int adicional)
    {
        return precios+adicional;

    }
}
