import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Veiculo {
    protected TipoVeiculo tipoVeiculo;
    protected LocalDateTime entrada;
    protected LocalDateTime saida;
    protected long tempoPermanencia;

    public Veiculo() {
        this.tipoVeiculo = null;
        this.entrada = null;
        this.saida = null;
        this.tempoPermanencia = 0;
    }

    public Veiculo(TipoVeiculo tipoVeiculo, LocalDateTime entrada, LocalDateTime saida) {
        this.tipoVeiculo = tipoVeiculo;
        this.entrada = entrada;
        this.saida = saida;
        this.tempoPermanencia = calcularTempoPermanencia(entrada, saida);
    }

    public long calcularTempoPermanencia(LocalDateTime entrada, LocalDateTime saida) {
        Duration duracao = Duration.between(entrada, saida);
        return duracao.toMinutes();
    }

    public abstract BigDecimal calcularValor(long tempoPermanencia); /*{
        BigDecimal precoPorMinuto = new BigDecimal("0.25");
        return precoPorMinuto.multiply(BigDecimal.valueOf(tempoPermanencia));
    }*/

    public void imprimirRelatorio() {
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        System.out.println("Tipo do veículo: "  + this.tipoVeiculo);
        System.out.println("Data e horário de entrada: " + this.entrada.format(formatar));
        System.out.println("Data e horário de saída: " + this.saida.format(formatar));
        System.out.println("Tempo de permanência: " + this.calcularTempoPermanencia(entrada, saida) + " minutos.");
        System.out.printf("Valor total: " + this.calcularValor(this.getTempoPermanencia()));
        System.out.println();
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }
    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }
    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public long getTempoPermanencia() {
        return tempoPermanencia;
    }

    public void setTempoPermanencia(long tempoPermanencia) {
        this.tempoPermanencia = tempoPermanencia;
    }
}
