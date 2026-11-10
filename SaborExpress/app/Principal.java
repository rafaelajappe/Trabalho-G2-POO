
import java.time.LocalDate;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Prato;
import modelo.PratoExecutivo;
import modelo.Combo;
import modelo.PratoEspecial;

import exception.PrecoInvalidoException;

import servico.ControlePedidos;
import servico.FechamentoDia;

import relatorio.RelatorioConsole;

public class Principal {

    public static void main(String[] args) {

        // Cadastro dos clientes

        Cliente cliente1 = new Cliente(
            "Ana Silva",
            "Rua das Flores, 100",
            "99999-1111"
        );

        Cliente cliente2 = new Cliente(
            "Pedro Souza",
            "Rua Central, 200",
            "99999-2222"
        );

        try {

            // Criação dos pratos

            Prato executivo = new PratoExecutivo(
                "Frango grelhado",
                25.00,
                20
            );

            Prato combo = new Combo(
                "Combo hamburguer",
                40.00,
                15
            );

            Prato especial = new PratoEspecial(
                "File especial",
                50.00,
                30,
                15.00
            );

            // Criação do primeiro pedido

            Pedido pedido1 = new Pedido(
                cliente1,
                LocalDate.now()
            );

            pedido1.adicionarPrato(executivo);
            pedido1.adicionarPrato(combo);

            // Criação do segundo pedido

            Pedido pedido2 = new Pedido(
                cliente2,
                LocalDate.now()
            );

            pedido2.adicionarPrato(especial);
            pedido2.adicionarPrato(executivo);

            // Controle dos pedidos

            ControlePedidos controle = new ControlePedidos();

            controle.adicionarPedido(pedido1);
            controle.adicionarPedido(pedido2);

            // Teste de preço negativo

            System.out.println("TESTE DE ERRO:");

            try {

                Prato pratoInvalido = new PratoExecutivo(
                    "Prato invalido",
                    -10.00,
                    10
                );

            } catch (PrecoInvalidoException e) {

                System.out.println(
                    "Erro tratado: " + e.getMessage()
                );
            }

            // Fechamento do dia

            RelatorioConsole relatorio = new RelatorioConsole();

            FechamentoDia fechamento = new FechamentoDia(relatorio);

            fechamento.gerarRelatorio(controle.getPedidos());

        } catch (PrecoInvalidoException e) {

            System.out.println(
                "Erro ao cadastrar prato: " + e.getMessage()
            );
        }
    }
}
