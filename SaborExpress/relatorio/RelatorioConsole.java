
package relatorio;

public class RelatorioConsole implements DestinoRelatorio {

    @Override
    public void enviar(String mensagem) {
        System.out.println(mensagem);
    }
}

