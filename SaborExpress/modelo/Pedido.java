
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {

    private Cliente cliente;
    private LocalDate data;
    private ArrayList<Prato> pratos;

    public Pedido(Cliente cliente, LocalDate data) {

        if (cliente == null) {
            throw new IllegalArgumentException(
                "O pedido precisa ter um cliente!"
            );
        }

        this.cliente = cliente;
        this.data = data;
        this.pratos = new ArrayList<>();
    }

    public void adicionarPrato(Prato prato) {
        pratos.add(prato);
    }

    public double calcularTotal() {

        double total = 0;

        for (Prato prato : pratos) {
            total += prato.calcularPreco();
        }

        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }
}
