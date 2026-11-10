
package servico;

import java.util.ArrayList;
import modelo.Pedido;

public class ControlePedidos {

    private ArrayList<Pedido> pedidos;

    public ControlePedidos() {
        pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
