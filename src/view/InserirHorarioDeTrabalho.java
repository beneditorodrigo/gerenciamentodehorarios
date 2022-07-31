package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Hora;

public class InserirHorarioDeTrabalho extends JFrame {

	private static final long serialVersionUID = 1L;

	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel painelFundo;
	private JButton botaoSalvar;
	private JButton botaoLimpar;
	private JLabel lbNome;
	private JLabel lbTelefone;
	private JTextField txEntrada;
	private JTextField txSaida;

	public InserirHorarioDeTrabalho(DefaultTableModel model) {
		super("Horários de Trabalho");
		criaJanela();
		modelo = model;
	}

	public void criaJanela() {
		botaoSalvar = new JButton("Salvar");
		botaoLimpar = new JButton("Limpar");
		lbNome = new JLabel("Entrada: ");
		lbTelefone = new JLabel("Saída: ");
		txEntrada = new JTextField(10);
		txSaida = new JTextField();

		painelFundo = new JPanel();
		painelFundo.setLayout(new GridLayout(4, 2, 2, 4));
		painelFundo.add(lbNome);
		painelFundo.add(txEntrada);
		painelFundo.add(lbTelefone);
		painelFundo.add(txSaida);
		painelFundo.add(botaoLimpar);
		painelFundo.add(botaoSalvar);

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		botaoSalvar.addActionListener(new BtSalvarListener());
		botaoLimpar.addActionListener(new BtLimparListener());
	}

	private class BtSalvarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Hora hora = new Hora();
			hora.setEntrada(txEntrada.getText());
			hora.setSaida(txSaida.getText());

			setVisible(false);
		}
	}

	private class BtLimparListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			txEntrada.setText("");
			txSaida.setText("");
		}
	}
}