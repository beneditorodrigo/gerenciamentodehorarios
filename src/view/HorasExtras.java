package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Hora;

public class HorasExtras extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel painelFundo;
	private JPanel painelBotoes;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JButton botaoRetornar;
	private JButton botaoEncerrar;
	private DefaultTableModel modelo = new DefaultTableModel();
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botaoEncerrar) {
			System.exit(0);
		}
		if(e.getSource()==botaoRetornar) {
			
		}
	}

	public HorasExtras(ArrayList<Hora> horasExtras) {
		super("Horas Extras");
		criarTabelaHorasExtras(horasExtras);
		criaJanela();
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
		setSize(500, 320);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void criarTabelaHorasExtras(ArrayList<Hora> horasExtras) {
		
		tabela = new JTable(modelo);
		modelo.addColumn("Entrada");
		modelo.addColumn("Saída");
		
		int contador = 0;
		
		for(Hora horas : horasExtras) {
			Object[] object = {horas.getEntrada(), horas.getSaida()};
			modelo.insertRow(contador, object);
			contador++;
		}		
	}
}
