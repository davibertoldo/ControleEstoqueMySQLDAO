package visao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FrmMovimentacaoEstoque extends JFrame {

    private JComboBox<String> cbProduto;
    private JComboBox<String> cbTipo;
    private JTextField txtQuantidade;
    private static List<String> produtos = new ArrayList<>();
    private static List<Integer> estoque = new ArrayList<>();

    public FrmMovimentacaoEstoque() {
        setTitle("Movimentação de Estoque");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblProduto = new JLabel("Produto:");
        lblProduto.setBounds(30, 30, 100, 25);
        add(lblProduto);

        cbProduto = new JComboBox<>();
        cbProduto.setBounds(140, 30, 300, 25);
        for (String produto : produtos) {
            cbProduto.addItem(produto);
        }
        add(cbProduto);

        JLabel lblMovimentacao = new JLabel("Tipo:");
        lblMovimentacao.setBounds(30, 70, 100, 25);
        add(lblMovimentacao);

        cbTipo = new JComboBox<>();
        cbTipo.setBounds(140, 70, 150, 25);
        cbTipo.addItem("Entrada");
        cbTipo.addItem("Saída");
        add(cbTipo);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(30, 110, 100, 25);
        add(lblQuantidade);

        txtQuantidade = new JTextField();
        txtQuantidade.setBounds(140, 110, 100, 25);
        add(txtQuantidade);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(80, 170, 120, 30);
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmarMovimentacao();
            }
        });
        add(btnConfirmar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(220, 170, 120, 30);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(btnCancelar);
    }

    private void confirmarMovimentacao() {
        try {
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            String tipo = (String) cbTipo.getSelectedItem();
            int index = cbProduto.getSelectedIndex();
            
            if (index >= 0) {
                int estoqueAtual = estoque.get(index);
                
                if (tipo.equals("Saída") && quantidade > estoqueAtual) {
                    JOptionPane.showMessageDialog(this, "Estoque insuficiente!");
                    return;
                }
                
                estoque.set(index, tipo.equals("Entrada") ? 
                    estoqueAtual + quantidade : 
                    estoqueAtual - quantidade);
                
                JOptionPane.showMessageDialog(this, "Movimentação registrada com sucesso!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um produto!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Quantidade inválida!");
        }
    }

    public static void adicionarProduto(String nome, int qtdInicial) {
        produtos.add(nome);
        estoque.add(qtdInicial);
    }

    public static void main(String[] args) {
        new FrmMovimentacaoEstoque().setVisible(true);
    }
}