package visao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmCadastroProduto extends JFrame {

    private JTextField txtNome;
    private JTextField txtPreco;
    private JTextField txtUnidade;
    private JTextField txtQtdEstoque;
    private JTextField txtQtdMin;
    private JTextField txtQtdMax;
    private JComboBox<String> cbCategoria;

    public FrmCadastroProduto() {
        setTitle("Cadastro de Produto");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 30, 100, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(140, 30, 300, 25);
        add(txtNome);

        JLabel lblPreco = new JLabel("Preço:");
        lblPreco.setBounds(30, 70, 100, 25);
        add(lblPreco);

        txtPreco = new JTextField();
        txtPreco.setBounds(140, 70, 100, 25);
        add(txtPreco);

        JLabel lblUnidade = new JLabel("Unidade:");
        lblUnidade.setBounds(30, 110, 100, 25);
        add(lblUnidade);

        txtUnidade = new JTextField();
        txtUnidade.setBounds(140, 110, 100, 25);
        add(txtUnidade);

        JLabel lblQtdEstoque = new JLabel("Qtd. Estoque:");
        lblQtdEstoque.setBounds(30, 150, 100, 25);
        add(lblQtdEstoque);

        txtQtdEstoque = new JTextField();
        txtQtdEstoque.setBounds(140, 150, 100, 25);
        add(txtQtdEstoque);

        JLabel lblQtdMin = new JLabel("Qtd. Mínima:");
        lblQtdMin.setBounds(30, 190, 100, 25);
        add(lblQtdMin);

        txtQtdMin = new JTextField();
        txtQtdMin.setBounds(140, 190, 100, 25);
        add(txtQtdMin);

        JLabel lblQtdMax = new JLabel("Qtd. Máxima:");
        lblQtdMax.setBounds(30, 230, 100, 25);
        add(lblQtdMax);

        txtQtdMax = new JTextField();
        txtQtdMax.setBounds(140, 230, 100, 25);
        add(txtQtdMax);

        JLabel lblCategoria = new JLabel("Categoria:");
        lblCategoria.setBounds(30, 270, 100, 25);
        add(lblCategoria);

        cbCategoria = new JComboBox<>();
        cbCategoria.setBounds(140, 270, 200, 25);
        
        // Carregar categorias do cadastro
        for (String categoria : FrmCadastroCategoria.getCategorias()) {
            cbCategoria.addItem(categoria);
        }
        add(cbCategoria);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(80, 320, 100, 30);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarProduto();
            }
        });
        add(btnSalvar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 320, 100, 30);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(btnCancelar);
    }

    private void salvarProduto() {
        try {
            String nome = txtNome.getText();
            double preco = Double.parseDouble(txtPreco.getText());
            String unidade = txtUnidade.getText();
            int qtdEstoque = Integer.parseInt(txtQtdEstoque.getText());
            int qtdMin = Integer.parseInt(txtQtdMin.getText());
            int qtdMax = Integer.parseInt(txtQtdMax.getText());
            String categoria = (String) cbCategoria.getSelectedItem();

            // Validações
            if (nome.isEmpty() || unidade.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
                return;
            }

            if (qtdMin > qtdMax) {
                JOptionPane.showMessageDialog(this, "Quantidade mínima não pode ser maior que máxima!");
                return;
            }

            // Simular persistência
            FrmMovimentacaoEstoque.adicionarProduto(nome, qtdEstoque);
            JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
            dispose();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Valores numéricos inválidos!");
        }
    }

    public static void main(String[] args) {
        new FrmCadastroProduto().setVisible(true);
    }
}