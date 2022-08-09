package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import entity.Horarios;
import model.ResetDosDados;
import view.Atrasos;
import view.HorasExtras;
import view.InserirHorarioDeTrabalho;
import view.InserirMarcacoes;

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
		i1.addActionListener(this);
		menuHorarios.add(i1);
		
		menuMarcacoes = new JMenu("Marcações");		
		i2 = new JButton("Cadastrar Marcação");
		i2.addActionListener(this);
		menuMarcacoes.add(i2);
		
		menuAtrasos = new JMenu("Atrasos");
		i3 = new JButton("Relatório de Atrasos");
		i3.addActionListener(this);
		menuAtrasos.add(i3);
		
		menuHorasExtras = new JMenu("Horas Extras");
		i4 = new JButton("Relatório de Horas Extras");
		i4.addActionListener(this);
		menuHorasExtras.add(i4);
		
		menuGerenciamento = new JMenu("Gerenciamento");
		i5 = new JButton("Limpar Dados");
		i5.addActionListener(this);
		i6 = new JButton("Encerrar");
		i6.addActionListener(this);
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
			InserirHorarioDeTrabalho inserirHorarioDeTrabalho = new InserirHorarioDeTrabalho(horarios.getHorariosDeTrabalho(), horarios);
		}
		
		if(e.getSource() == i2) {
			InserirMarcacoes marcacoes = new InserirMarcacoes(horarios.getMarcacoesFeitas(), horarios);
		}

		if(e.getSource() == i3) {
			Atrasos atrasos = new Atrasos(horarios);
		}
		
		if(e.getSource() == i4) {
			HorasExtras horasExtras = new HorasExtras(horarios);
		}
		
		if(e.getSource() == i5) {
			ResetDosDados resetDados = new ResetDosDados();
			boolean retorno = resetDados.limparDados(horarios);
			if(retorno) {
				JOptionPane.showMessageDialog(null, "Dados Apagados");
			} else {
				JOptionPane.showMessageDialog(null, "ERRO");
			}
		}
		
		if(e.getSource() == i6) {
			System.exit(0);
		}
	}
}
