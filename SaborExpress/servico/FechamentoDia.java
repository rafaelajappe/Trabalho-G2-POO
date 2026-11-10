
package servico;

import java.util.ArrayList;
import modelo.Pedido;
import modelo.Prato;
import relatorio.DestinoRelatorio;

public class FechamentoDia {

    private DestinoRelatorio destino;

    public FechamentoDia(DestinoRelatorio destino) {
        this.destino = destino;
    }

    public void gerarRelatorio(ArrayList<Pedido> pedidos) {

        String relatorio = "\n========== SABOREXPRESS ==========\n";

        double faturamentoTotal = 0;
        Pedido pedidoMaisCaro = null;

        for (Pedido pedido : pedidos) {

            double totalPedido = pedido.calcularTotal();

            faturamentoTotal += totalPedido;

            relatorio += "\nCliente: "
                    + pedido.getCliente().getNome();

            relatorio += "\nData: " + pedido.getData();

            relatorio += "\nPratos:\n";

            for (Prato prato : pedido.getPratos()) {

                relatorio += "- " + prato.getNome()
                        + " | R$ "
                        + String.format("%.2f", prato.calcularPreco())
                        + "\n";
            }

            relatorio += "Total do pedido: R$ "
                    + String.format("%.2f", totalPedido)
                    + "\n";

            if (pedidoMaisCaro == null ||
                    totalPedido > pedidoMaisCaro.calcularTotal()) {

                pedidoMaisCaro = pedido;
            }
        }

        relatorio += "\n========== FECHAMENTO ==========\n";

        relatorio += "Faturamento total: R$ "
                + String.format("%.2f", faturamentoTotal);

        if (pedidoMaisCaro != null) {

            relatorio += "\nPedido mais caro: "
                    + pedidoMaisCaro.getCliente().getNome();

            relatorio += "\nValor: R$ "
                    + String.format("%.2f",
                            pedidoMaisCaro.calcularTotal());

        } else {

            relatorio += "\nNenhum pedido registrado.";
        }

        destino.enviar(relatorio);
    }
}
