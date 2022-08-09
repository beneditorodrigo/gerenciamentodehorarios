package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import entity.Horarios;
import view.InserirHorarioDeTrabalho;

public class MenuPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	Horarios horarios;
	JMenu menuHorarios, menuMarcacoes, menuAtrasos, menuHorasExtras, menuGerenciamento;
	JButton i1, i2, i3, i4, i5, i6;

	public MenuPrincipal(Horarios horarios) {
		this.horarios = horarios;
		
		JFrame f = new JFrame("Menu Principal");
		JMenuBar menuBar = new JMenuBar();
		
		menuHorarios = new JMenu("Horarios");
		i1 = new JButton("Cadastrar Horários");
		menuHorarios.add(i1);
		
		menuMarcacoes = new JMenu("Marcações");		
		i2 = new JButton("Cadastrar Marcação");
		menuMarcacoes.add(i2);
		
		menuAtrasos = new JMenu("Atrasos");
		i3 = new JButton("Relatório de Atrasos");
		menuAtrasos.add(i3);
		
		menuHorasExtras = new JMenu("Horas Extras");
		i4 = new JButton("Relatório de Horas Extras");
		menuHorasExtras.add(i4);
		
		menuGerenciamento = new JMenu("Gerenciamento");
		i5 = new JButton("Limpar Dados");
		i6 = new JButton("Encerrar");
		menuGerenciamento.add(i5);
		menuGerenciamento.add(i6);

		menuBar.add(menuHorarios);
		menuBar.add(menuMarcacoes);
		menuBar.add(menuAtrasos);
		menuBar.add(menuHorasExtras);
		menuBar.add(menuGerenciamento);
		
		f.setJMenuBar(menuBar);
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == i1) {
			System.out.println("Funcionoi");
			setVisible(false);
			InserirHorarioDeTrabalho inserirHorarioDeTrabalho = new InserirHorarioDeTrabalho(horarios.getHorariosDeTrabalho(), horarios);
		}

	}
}
