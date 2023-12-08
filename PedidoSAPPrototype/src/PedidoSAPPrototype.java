import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PedidoSAPPrototype extends JFrame {
    private JTextField productNameField;
    private JTextField quantityField;
    private JButton createOrderButton;
    private SistemaPedido sistemaPedido;

    public PedidoSAPPrototype(SistemaPedido sistemaPedido) {
        this.sistemaPedido = sistemaPedido;

        // Configuração da janela...
        setTitle("Módulo de Pedidos SAP (Protótipo)");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Componentes da interface
        JLabel productNameLabel = new JLabel("Nome do Produto:");
        JLabel quantityLabel = new JLabel("Quantidade:");

        productNameField = new JTextField(20);
        quantityField = new JTextField(5);

        createOrderButton = new JButton("Criar Pedido");

        // Layout da interface
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(productNameLabel);
        panel.add(productNameField);
        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(createOrderButton);

        // Evento do botão "Criar Pedido"
        createOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                criarPedido();
            }
        });

        // Adiciona o painel à janela
        add(panel);
    }

    private void criarPedido() {
    String productName = productNameField.getText();
    String quantityStr = quantityField.getText();

    if (productName.isEmpty() || quantityStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int quantity = Integer.parseInt(quantityStr);

    // Criar um Produto com preço dinâmico
    double preco = Math.random() * 100; // Preço aleatório para ilustrar
    Produto produto = new Produto(productName, preco);

    // Cria uma lista mutável para armazenar o ID do produto
    List<Integer> produtosIds = new ArrayList<>();

    // Adiciona o ID do produto à lista
    int produtoId = sistemaPedido.inserirProduto(produto);
    produtosIds.add(produtoId);

    // Cria o pedido com a lista de IDs de produtos
    Pedido novoPedido = sistemaPedido.criarPedido(produtosIds, "Cliente");

    // Exibe informações do Pedido criado
    StringBuilder mensagem = new StringBuilder();
    mensagem.append("Pedido criado:\n");

    // Adiciona informações dos produtos
    mensagem.append("Produtos:\n");
    for (int id : produtosIds) {
        Produto p = sistemaPedido.buscarProdutoPorId(id);
        mensagem.append("- ").append(p.getNome()).append(" (ID: ").append(p.getId()).append(")\n");
    }

    // Adiciona outras informações do pedido
    mensagem.append("Informações do Pedido:\n");
    mensagem.append(novoPedido.getInformacoesContatoCliente()).append("\n");
    mensagem.append("- Data de Entrega: ").append(novoPedido.getDataEntrega()).append("\n");

    JOptionPane.showMessageDialog(this, mensagem.toString(), "Pedido Criado", JOptionPane.INFORMATION_MESSAGE);

    // Imprime informações no terminal
    System.out.println("Produtos:");
    for (int id : produtosIds) {
        Produto p = sistemaPedido.buscarProdutoPorId(id);
        System.out.println("- " + p.getNome() + " (ID: " + p.getId() + ")\n");
    }
    
    System.out.println("Informações do Pedido:\n" +
            novoPedido.getInformacoesContatoCliente() + "\n" +
            "- Data de Entrega: " + novoPedido.getDataEntrega());
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SistemaPedido sistemaPedido = new SistemaPedido();
                PedidoSAPPrototype app = new PedidoSAPPrototype(sistemaPedido);
                app.setVisible(true);
            }
        });
    }
}

