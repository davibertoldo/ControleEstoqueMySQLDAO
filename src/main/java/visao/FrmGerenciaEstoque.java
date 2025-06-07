package visao;

import javax.swing.*;

public class FrmGerenciaEstoque extends JFrame {

    public FrmGerenciaEstoque() {
        setTitle("Gerenciar Estoque");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblProduto = new JLabel("Produto:");
        lblProduto.setBounds(30, 30, 100, 25);
        add(lblProduto);

        JComboBox<String> cbProduto = new JComboBox<>();
        cbProduto.setBounds(140, 30, 300, 25);
        cbProduto.addItem("Produto 1");
        cbProduto.addItem("Produto 2");
        add(cbProduto);

        JLabel lblMovimentacao = new JLabel("Tipo:");
        lblMovimentacao.setBounds(30, 70, 100, 25);
        add(lblMovimentacao);

        JComboBox<String> cbTipo = new JComboBox<>();
        cbTipo.setBounds(140, 70, 150, 25);
        cbTipo.addItem("Entrada");
        cbTipo.addItem("Saída");
        add(cbTipo);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(30, 110, 100, 25);
        add(lblQuantidade);

        JTextField txtQuantidade = new JTextField();
        txtQuantidade.setBounds(140, 110, 100, 25);
        add(txtQuantidade);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setBounds(80, 170, 120, 30);
        add(btnConfirmar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(220, 170, 120, 30);
        add(btnCancelar);
    }

    public static void main(String[] args) {
        new FrmGerenciaEstoque().setVisible(true);
    }
}