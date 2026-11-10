
package modelo;

import exception.PrecoInvalidoException;

public class PratoEspecial extends Prato {

    private double custoIngredientePremium;

    public PratoEspecial(String nome, double precoBase,
                         int tempoPreparo, double custoIngredientePremium)
            throws PrecoInvalidoException {

        super(nome, precoBase, tempoPreparo);

        if (custoIngredientePremium < 0) {
            throw new PrecoInvalidoException(
                "O custo do ingrediente premium não pode ser negativo!"
            );
        }

        this.custoIngredientePremium = custoIngredientePremium;
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase() + custoIngredientePremium;
    }
}
