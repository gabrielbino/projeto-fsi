import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int proximoIdPedido = 1;

    private int id;
    private LocalDate dataEntrega;
    private String informacoesContatoCliente;
    private List<Integer> produtosIds;

    public Pedido() {
        this.id = proximoIdPedido++;
        this.dataEntrega = LocalDate.now();
        this.produtosIds = new ArrayList<>();
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getInformacoesContatoCliente() {
        return informacoesContatoCliente;
    }

    public void setInformacoesContatoCliente(String informacoesContatoCliente) {
        this.informacoesContatoCliente = informacoesContatoCliente;
    }

    public List<Integer> getProdutosIds() {
        return produtosIds;
    }

    public void setProdutosIds(List<Integer> produtosIds) {
        this.produtosIds = produtosIds;
    }
}
