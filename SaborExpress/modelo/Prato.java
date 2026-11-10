
package modelo;

import exception.PrecoInvalidoException;

public abstract class Prato {

    private String nome;
    private double precoBase;
    private int tempoPreparo;

    public Prato(String nome, double precoBase, int tempoPreparo)
            throws PrecoInvalidoException {

        if (precoBase < 0) {
            throw new PrecoInvalidoException(
                "O preço base não pode ser negativo!"
            );
        }

        this.nome = nome;
        this.precoBase = precoBase;
        this.tempoPreparo = tempoPreparo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public abstract double calcularPreco();
}
