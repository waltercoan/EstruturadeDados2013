package trabbim1;

import javax.swing.table.AbstractTableModel;

public class ModelTabela extends AbstractTableModel{
	private int numCol=10, numLin=10;
	
	@Override
	public int getColumnCount() {
		return numCol;
	}

	@Override
	public int getRowCount() {
		return numLin;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		//AQUI voce deve escrever a l�gica para ler a lista 
		//duplamente encadeada e alimentar as c�lulas atrav�s 
		//dos valores dos nodos.
		return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// todas as celulas s�o editaveis
		return true;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		//AQUI voce deve escrever a l�gica para guardar nos nodos 
		//da lista duplamente encadeada somente os valores das c�lulas
		//que foram preenchidas pelo usu�rio.
	}

	public int getNumLin() {
		return numLin;
	}

	public void setNumLin(int numLin) {
		this.numLin = numLin;
		fireTableStructureChanged();
		fireTableDataChanged();
	}

	public int getNumCol() {
		return numCol;
	}

	public void setNumCol(int numCol) {
		this.numCol = numCol;
		fireTableStructureChanged();
		fireTableDataChanged();
	}

}
