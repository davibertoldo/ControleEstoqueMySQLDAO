import javax.swing.JOptionPane;
public class ExemploFor {
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            JOptionPane.showMessageDialog(null, "Valor de i:" + i);
            i++;    
        }
    }
}
