import java.util.ArrayList;
import java.util.List;

public class SistemaPedido {
    private static int proximoIdProduto = 1;
    private static int proximoIdPedido = 1;

    private int numeroCliente;
    private List<Produto> produtos;
    private List<Pedido> pedidos;

    public SistemaPedido() {
        this.numeroCliente = 1;
        this.produtos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    // Getters e setters
    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    // Método para inserir um novo produto
    public int inserirProduto(Produto produto) {
        produto.setId(proximoIdProduto++);
        produtos.add(produto);
        return produto.getId();
    }

    public Pedido criarPedido(List<Integer> produtosIds, String informacoesContatoCliente) {
        Pedido novoPedido = new Pedido();
        novoPedido.setProdutosIds(produtosIds);
        novoPedido.setInformacoesContatoCliente(informacoesContatoCliente + " - Cliente " + numeroCliente);

        pedidos.add(novoPedido);

        // Incrementa o número do cliente para o próximo pedido
        numeroCliente++;

        // Imprime o número do cliente no terminal
        System.out.println("Número do Cliente: " + (numeroCliente - 1));

        return novoPedido;
    }

    // Método para visualizar todos os produtos
    public void visualizarProdutos() {
        System.out.println("Produtos Disponíveis:");
        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome() + ", Preço: R$ " + produto.getPreco());
        }
        System.out.println();
    }

    // Método para visualizar todos os pedidos
    public void visualizarPedidos() {
        System.out.println("Pedidos Realizados:");
        for (Pedido pedido : pedidos) {
            System.out.println("ID do Pedido: " + pedido.getId() +
                    ", Data de Entrega: " + pedido.getDataEntrega() +
                    ", Informações de Contato do Cliente: " + pedido.getInformacoesContatoCliente() +
                    ", Produtos: " + pedido.getProdutosIds());
        }
        System.out.println();
    }
    
    public Produto buscarProdutoPorId(int produtoId) {
    for (Produto produto : produtos) {
        if (produto.getId() == produtoId) {
            return produto;
        }
    }
    return null; // Retorna null se o produto não for encontrado
}
}
