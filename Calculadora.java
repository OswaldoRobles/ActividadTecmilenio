import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {
    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JTextField txtResultado;
    private JButton btnSumar;
    private JButton btnRestar;
    private JButton btnMultiplicar;
    private JButton btnDividir;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Campos de texto
        JLabel lblNumero1 = new JLabel("Número 1:");
        lblNumero1.setBounds(30, 20, 150, 25);
        add(lblNumero1);

        txtNumero1 = new JTextField();
        txtNumero1.setBounds(120, 20, 100, 25);
        add(txtNumero1);

        JLabel lblNumero2 = new JLabel("Número 2:");
        lblNumero2.setBounds(30, 50, 150, 25);
        add(lblNumero2);

        txtNumero2 = new JTextField();
        txtNumero2.setBounds(120, 50, 100, 25);
        add(txtNumero2);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(30, 80, 80, 25);
        add(lblResultado);

        txtResultado = new JTextField();
        txtResultado.setBounds(120, 80, 100, 25);
        txtResultado.setEditable(false);
        add(txtResultado);

        // Botones
        btnSumar = new JButton("Sumar");
        btnSumar.setBounds(250, 20, 100, 25);
        add(btnSumar);

        btnRestar = new JButton("Restar");
        btnRestar.setBounds(250, 50, 100, 25);
        add(btnRestar);

        btnMultiplicar = new JButton("Multiplicar");
        btnMultiplicar.setBounds(250, 80, 100, 25);
        add(btnMultiplicar);

        btnDividir = new JButton("Dividir");
        btnDividir.setBounds(250, 110, 100, 25);
        add(btnDividir);

        // Listeners para cada botón
        btnSumar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular('+');
            }
        });

        btnRestar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular('-');
            }
        });

        btnMultiplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular('*');
            }
        });

        btnDividir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcular('/');
            }
        });
    }

    private void calcular(char operacion) {
        try {
            double numero1 = Double.parseDouble(txtNumero1.getText());
            double numero2 = Double.parseDouble(txtNumero2.getText());
            double resultado = 0;

            switch (operacion) {
                case '+':
                    resultado = numero1 + numero2;
                    break;
                case '-':
                    resultado = numero1 - numero2;
                    break;
                case '*':
                    resultado = numero1 * numero2;
                    break;
                case '/':
                    if (numero2 != 0) {
                        resultado = numero1 / numero2;
                    } else {
                        txtResultado.setText("División por cero");
                        return;
                    }
                    break;
            }

            txtResultado.setText(String.valueOf(resultado));
        } catch (NumberFormatException ex) {
            txtResultado.setText("Entrada no válida");
        }
    }

    public static void main(String[] args) {
        new Calculadora()
            .setVisible(true);
    }
}
