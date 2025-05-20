import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime dataHoraEntrada = LocalDateTime.of(2023, 10, 26, 10, 30);
        LocalDateTime dataHoraSaida = LocalDateTime.of(2023, 10, 26, 12, 0);

        Carro c1 = new Carro(TipoVeiculo.CARRO, dataHoraEntrada, dataHoraSaida);

        c1.imprimirRelatorio();
    }
}
