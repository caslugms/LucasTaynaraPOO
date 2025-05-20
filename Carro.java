import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Carro extends Veiculo {
    private BigDecimal valor = BigDecimal.ZERO;

    public Carro(TipoVeiculo tipoVeiculo, LocalDateTime entrada, LocalDateTime saida) {
        super(tipoVeiculo, entrada, saida);
        this.valor = calcularValor(calcularTempoPermanencia(entrada, saida));
    }

    @Override
    public BigDecimal calcularValor(long tempoPermanencia) {
        BigDecimal precoPorMinuto = new BigDecimal("0.25");
        return precoPorMinuto.multiply(BigDecimal.valueOf(tempoPermanencia));
    }
    
}
