package java_swing_study.chap11;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java_swing_study.chap11.exam.Student;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class StudentTblPanel extends JPanel {
	private JScrollPane scrollPane;
	private JTable table;
	private NotEditableModel model;

	public StudentTblPanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		// 접근지정자는 가장 폭이 좁은 것에서 점차적으로 넓은쪽으로 변경
		// 자동 완성된 테이블코드를 메소드로 뺀다. 
//		table.setModel(new DefaultTableModel( 
//			new Object[][] { {null, null, null, null, null, null, null}, }, 
//			new String[] { "New column", "New column", "New column", "New column", "New column", "New column", "New column"} 
//		));

		// 외부에서 호출
		ArrayList<Student> stds = new ArrayList<Student>();
		stds.add(new Student(1, "서현진", 80, 90, 70));
		stds.add(new Student(2, "이성경", 90, 90, 40));
		stds.add(new Student(3, "이유영", 50, 50, 60));
		loadData(stds);
		
	}

	public void setPopupMenu(JPopupMenu popupMenu) {
		scrollPane.setComponentPopupMenu(popupMenu);
		table.setComponentPopupMenu(popupMenu);
	}

	private void loadData(ArrayList<Student> stds) {
//		table.setModel(new DefaultTableModel(getRows(stds), getColNames())); // (데이터, 컬럼명); // 메소드로 뺀다.
		
		model = new NotEditableModel(getRows(stds), getColNames());
		table.setModel(model); 
		
		// 정렬
		setTbWidthAlign(); 
		
	}

	private void setTbWidthAlign() {
		//각 컬럼의 폭과 셀의 수평정렬 //setModel 이후에 작성되어야 함
		tableSetWidth(50, 150, 50, 50, 50, 70, 70);
		//가변인수는 가장 마지막으로 넣어야함 갯수를 알수 없기 때문에
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 4); 
		tableCellAlign(SwingConstants.RIGHT, 5, 6); 
		tableCellAlign(SwingConstants.LEFT, 3);
	}

	private void tableCellAlign(int align, int...idx) { //가변인수는 가장 마지막으로 넣어야함 갯수를 알수 없기 때문에
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		
		TableColumnModel cModel = table.getColumnModel();
		for(int i=0; i<idx.length; i++) {
			cModel.getColumn(idx[i]).setCellRenderer(dtcr);
		}
		
//		cModel.getColumn(0).setCellRenderer(dtcr);
//		cModel.getColumn(1).setCellRenderer(dtcr);
//		cModel.getColumn(2).setCellRenderer(dtcr);
//		cModel.getColumn(3).setCellRenderer(dtcr);
//		cModel.getColumn(4).setCellRenderer(dtcr);
		
	}

	private void tableSetWidth(int...width) { //int...width -> 가변 인수 [배열로 들어옴] 
		TableColumnModel cModel = table.getColumnModel();
		for(int i=0; i<width.length; i++) {
			cModel.getColumn(i).setPreferredWidth(width[i]);
//			System.out.println(width[i]);
		}
//		cModel.getColumn(0).setPreferredWidth(50);
//		cModel.getColumn(1).setPreferredWidth(150);
//		cModel.getColumn(2).setPreferredWidth(50);
//		cModel.getColumn(3).setPreferredWidth(50);
//		cModel.getColumn(4).setPreferredWidth(50);
//		cModel.getColumn(5).setPreferredWidth(70);
//		cModel.getColumn(6).setPreferredWidth(70);
	}

	private String[] getColNames() {
		return new String[] { "번호", "학생명", "국어", "영어", "수학", "총점", "평균" };
	}

	private Object[][] getRows(ArrayList<Student> stds) {
		Object[][] rows = new Object[stds.size()][];
		for (int i = 0; i < rows.length; i++) {
			rows[i] = toArray(stds.get(i));
		}
		return rows;
	}

	private Object[] toArray(Student std) {
		return new Object[] { 
				String.format("%03d", std.getStdNo()), //"S%03d"로 하면 S001로 나옴
				std.getStdName(), 
				std.getKor(), 
				std.getEng(), 
				std.getMath(), 
				std.total(), 
				String.format("%.2f", std.avg())};
	}
	
	public void removeRow() {
		int selectedIdx = getSelectedRowIdx();
		model.removeRow(selectedIdx);
	}
	
	public void updateRow(Student std, int updateIdx) {
		model.setValueAt(String.format("%03d", std.getStdNo()), updateIdx, 0);
		model.setValueAt(std.getStdName(), updateIdx, 1);
		model.setValueAt(std.getKor(), updateIdx, 2);
		model.setValueAt(std.getEng(), updateIdx, 3);
		model.setValueAt(std.getMath(), updateIdx, 4);
		model.setValueAt(std.total(), updateIdx, 5);
		model.setValueAt(String.format("%.2f", std.avg()), updateIdx, 6);
	}
	
	public void addItem(Student std) {
		model.addRow(toArray(std));
	}

	private int getSelectedRowIdx() {
		int selectedIdx = table.getSelectedRow();
		if(selectedIdx == -1) {
			// Exception을 쓸 경우 throws 설정이 번거로운편
//			throw new Exception("해당 학생을 선택하세요.");
			throw new RuntimeException("해당 학생을 선택하세요.");
		}
		return selectedIdx;
	}
	
	public Student getSelectedItem() {
		int selectedIdx = getSelectedRowIdx();
		//(row, 컬럼index)
//		int stdNo = (int) model.getValueAt(selectedIdx, 0); //001로 설정해두어서 에러가 남
		int stdNo = Integer.parseInt((String)model.getValueAt(selectedIdx, 0));
		String stdName = (String) model.getValueAt(selectedIdx, 1);
		int kor = (int) model.getValueAt(selectedIdx, 2);
		int math = (int) model.getValueAt(selectedIdx, 3);
		int eng = (int) model.getValueAt(selectedIdx, 4);
		return new Student(stdNo, stdName, kor, math, eng);
	}
	
	//수정금지하기위한 모델 선언 (상속받아서 만듬)
	private class NotEditableModel extends DefaultTableModel {

		public NotEditableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			// 수정 불가능하게 오버라이딩
			return false;
		}
		
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(10, 10, 450, 500);
		
		StudentTblPanel tbl = new StudentTblPanel();
		frame.add(tbl);
		frame.setVisible(true);
		
		JPopupMenu popMenu = new JPopupMenu();
		
		JMenuItem addItem = new JMenuItem("추가");
		addItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Student newStudent = new Student(10, "장현서", 80, 90, 70);
				tbl.addItem(newStudent);
			}
		});
		popMenu.add(addItem);
		
		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Student upStd = new Student(2, "이상원", 100, 100, 100);
				
				tbl.updateRow(upStd, 1); // 이성경 학생을 이상원으로 변경
			}
		});
		popMenu.add(updateItem);
		
		JMenuItem getSelectedItem = new JMenuItem("선택한 학생 확인");
		getSelectedItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Student selectedStd = tbl.getSelectedItem();
				JOptionPane.showMessageDialog(null, "선택한 학생은 " + selectedStd);
			}
		});
		popMenu.add(getSelectedItem);
		
		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {					
					tbl.removeRow();
				} catch (RuntimeException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		popMenu.add(deleteItem);
		
		tbl.setPopupMenu(popMenu);;
		
	}

}
