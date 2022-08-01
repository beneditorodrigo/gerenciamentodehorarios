package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import model.Hora;
import model.Horarios;

public class InserirMarcacoes extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	private JPanel painelFundo;
	private JPanel painelBotoes;
	private JPanel painelCadastro;

	private JTable tabela;
	private JScrollPane barraRolagem;

	private JLabel labelEntrada;
	private JLabel labelSaida;

	private JFormattedTextField entrada;
	private JFormattedTextField saida;
	private MaskFormatter mascara;

	private JButton botaoRetornar;
	private JButton botaoEncerrar;
	private JButton botaoCadastrar;

	private DefaultTableModel modelo = new DefaultTableModel();
	
	private Horarios horarios = new Horarios();

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoEncerrar) {
			System.exit(0);
		}
		if (e.getSource() == botaoRetornar) {

		}

		if (e.getSource() == botaoCadastrar) {
			entrada.setText("");
			saida.setText("");
		}
	}

	public InserirMarcacoes(ArrayList<Hora> horariosDeTrabalho) {
		super("Marcações");
		criarTabelaMarcacoes(horariosDeTrabalho);
		criaJanela();
	}

	public void criaJanela() {

		try {
			mascara = new MaskFormatter("##:##");
			entrada = new JFormattedTextField(mascara);
			saida = new JFormattedTextField(mascara);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		labelEntrada = new JLabel("Entrada:");
		labelSaida = new JLabel("Saída:");

		botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.addActionListener(this);

		botaoRetornar = new JButton("Retornar");
		botaoRetornar.addActionListener(this);
		botaoEncerrar = new JButton("Encerrar");
		botaoEncerrar.addActionListener(this);

		painelCadastro = new JPanel();
		painelBotoes = new JPanel();

		painelCadastro.add(labelEntrada);
		painelCadastro.add(entrada);
		painelCadastro.add(labelSaida);
		painelCadastro.add(saida);
		painelCadastro.add(botaoCadastrar);

		painelBotoes.add(botaoRetornar);
		painelBotoes.add(botaoEncerrar);

		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.CENTER, barraRolagem);

		painelFundo.add(BorderLayout.SOUTH, painelBotoes);
		painelFundo.add(BorderLayout.BEFORE_FIRST_LINE, painelCadastro);

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void criarTabelaMarcacoes(ArrayList<Hora> horasMarcacoes) {

		tabela = new JTable(modelo);
		modelo.addColumn("Entrada");
		modelo.addColumn("Saída");

		int contador = 0;

		for (Hora horas : horasMarcacoes) {
			Object[] object = { horas.getEntrada(), horas.getSaida() };
			modelo.insertRow(contador, object);
			contador++;
		}
	}
}
