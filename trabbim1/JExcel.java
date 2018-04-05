package trabbim1;

import java.awt.Component;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JExcel extends JFrame implements ActionListener{
	private JPanel jpnTopo;
	private JScrollPane jpnCentro;
	private JTable tabela;
	private JButton btnNovaLinha, btnNovaColuna, btnRemoveLinha, btnRemoveColuna, btnSalva, btnCarrega;
	private ModelTabela modelo;
	public JExcel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Java Excel");
		setSize(700,500);
		criaTabela();
		criaBotoes();
		setVisible(true);
	}
	private void criaBotoes(){
		jpnTopo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnCarrega = new JButton("Abrir Dados");
		btnCarrega.setName("btnCarrega");
		btnCarrega.addActionListener(this);
		jpnTopo.add(btnCarrega);
		btnSalva = new JButton("Salvar Dados");
		btnSalva.setName("btnSalva");
		btnSalva.addActionListener(this);
		jpnTopo.add(btnSalva);
		btnNovaLinha = new JButton("Nova Linha");
		btnNovaLinha.setName("btnNovaLinha");
		btnNovaLinha.addActionListener(this);
		jpnTopo.add(btnNovaLinha);
		btnNovaColuna = new JButton("Nova Coluna");
		btnNovaColuna.setName("btnNovaColuna");
		btnNovaColuna.addActionListener(this);
		jpnTopo.add(btnNovaColuna);
		btnRemoveLinha = new JButton("Remove Linha");
		btnRemoveLinha.setName("btnRemoveLinha");
		btnRemoveLinha.addActionListener(this);
		jpnTopo.add(btnRemoveLinha);
		btnRemoveColuna = new JButton("Remove Coluna");
		btnRemoveColuna.setName("btnRemoveColuna");
		btnRemoveColuna.addActionListener(this);
		jpnTopo.add(btnRemoveColuna);
		add("North",jpnTopo);
	}
	private void criaTabela(){
		modelo = new ModelTabela();
		tabela = new JTable(modelo);
		jpnCentro = new JScrollPane(tabela);
		add("Center",jpnCentro);
	}
	public static void main(String[] args) {
		new JExcel();
	}
	
	private int getNumLinhaTabela(){
		return tabela.getSelectedRow();
	}
	private int getNumColunaTabela(){
		return tabela.getSelectedColumn();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Component compClicado = (Component) arg0.getSource();
		if(compClicado.getName().equals("btnNovaLinha")){
			modelo.setNumLin(modelo.getNumLin()+1);
		}else{
			if(compClicado.getName().equals("btnNovaColuna")){
				modelo.setNumCol(modelo.getNumCol()+1);
			}else{
				if(compClicado.getName().equals("btnCarrega")){
					FileDialog fdAbrir = new FileDialog(this,"Abrir Arquivo",FileDialog.LOAD);
					fdAbrir.show();
					System.out.println("Arquivo selecionado: " + fdAbrir.getDirectory()+fdAbrir.getFile());
				}else{
					if(compClicado.getName().equals("btnSalva")){
						FileDialog fdGravar = new FileDialog(this,"Gravar Arquivo",FileDialog.SAVE);
						fdGravar.show();
						System.out.println("Arquivo selecionado: " + fdGravar.getDirectory()+fdGravar.getFile());
					}else{
						if(compClicado.getName().equals("btnRemoveLinha")){
							System.out.println("Linha selecionada " + getNumLinhaTabela());
							modelo.setNumLin(modelo.getNumLin()-1);
						}else{
							if(compClicado.getName().equals("btnRemoveColuna")){
								System.out.println("Linha selecionada " + getNumColunaTabela());
							}
						}
					}
				}
			}
		}
	}
}
