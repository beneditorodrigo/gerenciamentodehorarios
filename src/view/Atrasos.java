package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.Hora;
import entity.Horarios;
import main.MenuPrincipal;

public class Atrasos extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JPanel painelFundo;
	private JPanel painelBotoes;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JButton botaoRetornar;
	private JButton botaoEncerrar;
	private DefaultTableModel modelo = new DefaultTableModel();
	private Horarios horarios;
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botaoEncerrar) {
			System.exit(0);
		}
		if(e.getSource()==botaoRetornar) {
			setVisible(false);
			MenuPrincipal menu = new MenuPrincipal(horarios);
		}
	}

	public Atrasos(Horarios horarios) {
		super("Atrasos");
		criarTabelaAtrasos(horarios);
		criaJanela();
		this.horarios = horarios;
	}

	public void criaJanela() {

		botaoRetornar = new JButton("Retornar");
		botaoRetornar.addActionListener(this);
		botaoEncerrar = new JButton("Encerrar");
		botaoEncerrar.addActionListener(this);

		painelBotoes = new JPanel();
		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.CENTER, barraRolagem);

		painelBotoes.add(botaoRetornar);
		;
		painelBotoes.add(botaoEncerrar);
		painelFundo.add(BorderLayout.SOUTH, painelBotoes);

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void criarTabelaAtrasos(Horarios horarios) {
		
		tabela = new JTable(modelo);
		modelo.addColumn("Entrada");
		modelo.addColumn("Saída");
		
		int contador = 0;
		
		for(Hora horas : horarios.getAtrasos()) {
			Object[] object = {horas.getEntrada(), horas.getSaida()};
			modelo.insertRow(contador, object);
			contador++;
		}		
	}
}
