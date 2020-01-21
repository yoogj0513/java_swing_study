package java_swing_study.chap11.exam;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;

// 제네릭 바꿈
public abstract class AbstractTblPanel_Test<T> extends JPanel {
	private JScrollPane scrollPane;
	protected JTable table;
	protected NotEditableModel model;

	public AbstractTblPanel_Test() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
	}

	public void setPopupMenu(JPopupMenu popupMenu) {
		scrollPane.setComponentPopupMenu(popupMenu);
		table.setComponentPopupMenu(popupMenu);
	}
	
	// 추상화
	public void loadData(ArrayList<T> items) {		
		model = new NotEditableModel(getRows(items), getColNames());
		table.setModel(model); 
		
		// 정렬
		setTbWidthAlign(); 
		
		// row 정렬
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		
//		table.getColumnModel().getColumn(2).setCellRenderer(new ReturnTableCellRenderer());		
	}

	protected abstract void setTbWidthAlign();

	protected void tableCellAlign(int align, int...idx) { //가변인수는 가장 마지막으로 넣어야함 갯수를 알수 없기 때문에
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel cModel = table.getColumnModel();
		for(int i=0; i<idx.length; i++) {
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}
				
	}

	protected void tableSetWidth(int...width) { //int...width -> 가변 인수 [배열로 들어옴] 
		TableColumnModel cModel = table.getColumnModel();
		for(int i=0; i<width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	protected abstract String[] getColNames();
	
	// 자식들이 접근할 것이기 때문에 protected로 설정
	protected Object[][] getRows(ArrayList<T> items) {
		Object[][] rows = new Object[items.size()][];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = toArray(items.get(i));
		}
		return rows;
	}

	protected abstract Object[] toArray(T item);
	
	public void removeRow() {
		int selectedIdx = getSelectedRowIdx();
		model.removeRow(selectedIdx);
	}
	
	public abstract void updateRow(T item, int updateIdx);
	
	public void addItem(T item) {
		model.addRow(toArray(item));
	}

	public int getSelectedRowIdx() {
		int selectedIdx = table.getSelectedRow();
		if(selectedIdx == -1) {
			throw new RuntimeException("해당 학생을 선택하세요.");
		}
		return selectedIdx;
	}
	
	public abstract T getSelectedItem();
	
	//수정금지하기위한 모델 선언 (상속받아서 만듬)
	protected class NotEditableModel extends DefaultTableModel {

		public NotEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			// 수정 불가능하게 오버라이딩
			return false;
		}
		
	}
	
/*
	public class ReturnTableCellRenderer extends JLabel implements TableCellRenderer {
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			if(value == null) return this;
			setText(value.toString());
			setOpaque(true);
			setHorizontalAlignment(JLabel.CENTER);
			
			if(Integer.parseInt(table.getValueAt(row, 2).toString()) >= 90) {
				setBackground(Color.CYAN);
			} else if (Integer.parseInt(table.getValueAt(row, 2).toString()) >= 80) {
				setBackground(Color.LIGHT_GRAY);
			} else {
				setBackground(Color.WHITE);
			}
			
			if(isSelected) {
				setBackground(Color.ORANGE);
			}
			
			return this;
		}
		
	}
*/
	
	public void clearSelection() {
		table.clearSelection();
	}

}
