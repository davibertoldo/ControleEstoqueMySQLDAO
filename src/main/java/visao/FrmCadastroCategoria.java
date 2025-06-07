package visao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FrmCadastroCategoria extends JFrame {

    private JTextField txtNome;
    private static List<String> categoriasCadastradas = new ArrayList<>();

    public FrmCadastroCategoria() {
        setTitle("Cadastro de Categoria");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome da Categoria:");
        lblNome.setBounds(30, 30, 150, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(180, 30, 180, 25);
        add(txtNome);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(80, 100, 100, 30);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarCategoria();
            }
        });
        add(btnSalvar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 100, 100, 30);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(btnCancelar);
    }

    private void salvarCategoria() {
        String nome = txtNome.getText().trim();
        if (!nome.isEmpty()) {
            categoriasCadastradas.add(nome);
            JOptionPane.showMessageDialog(this, "Categoria salva com sucesso!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Informe o nome da categoria!");
        }
    }

    public static List<String> getCategorias() {
        return new ArrayList<>(categoriasCadastradas);
    }

    public static void main(String[] args) {
        new FrmCadastroCategoria().setVisible(true);
    }
}