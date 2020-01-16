package java_swing_study.chap11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java_swing_study.chap11.exam.Student;

@SuppressWarnings("serial")
public class ComboxEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JComboBox<String> cmbFruit;
	private DefaultComboBoxModel<String> model;
	private JTextField tfFruit;
	private JLabel lblFruit;
	private JButton btnFruit;
	private JComboBox<Student> cmbStudent;
	private JLabel lblStudent;
	private JButton btnComfirm;
	private JPanel pSearch;
	private JLabel lblNum;
	private JTextField tfNum;
	private JButton btnSearch;
	private ArrayList<Student> std;
	private DefaultComboBoxModel<Student> student;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboxEx frame = new ComboxEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ComboxEx() {
		initialize();
	}

	private void initialize() {
		setTitle("콤보박스예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		pLeft = new JPanel();
		pLeft.setBorder(
				new TitledBorder(null, "\uC608\uC81C11-12", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new GridLayout(0, 1, 0, 0));

		cmbFruit = new JComboBox<>();
		cmbFruit.addActionListener(this);
		cmbFruit.setMaximumRowCount(5);
		pLeft.add(cmbFruit);

		tfFruit = new JTextField();
		tfFruit.addActionListener(this);
		pLeft.add(tfFruit);
		tfFruit.setColumns(10);

		lblFruit = new JLabel("New label");
		lblFruit.setForeground(Color.RED);
		lblFruit.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft.add(lblFruit);

		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC608\uC81C11-13",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));

		cmbStudent = new JComboBox<>(new Vector<>());
		cmbStudent.addActionListener(this);
		pRight.add(cmbStudent);

		lblStudent = new JLabel("학생정보");
		lblStudent.setForeground(Color.MAGENTA);
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		pRight.add(lblStudent);

		btnComfirm = new JButton("학생확인");
		btnComfirm.addActionListener(this);
		pRight.add(btnComfirm);

		pSearch = new JPanel();
		pRight.add(pSearch);
		pSearch.setLayout(new GridLayout(0, 3, 0, 0));

		lblNum = new JLabel("번호");
		lblNum.setHorizontalAlignment(SwingConstants.CENTER);
		pSearch.add(lblNum);

		tfNum = new JTextField();
		pSearch.add(tfNum);
		tfNum.setColumns(10);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		pSearch.add(btnSearch);

		cmbFruit.setModel(getModel());
		// 처음 콤보박스에 선택되어 있을 model
		cmbFruit.setSelectedIndex(-1);

		btnFruit = new JButton("확인");
		btnFruit.addActionListener(this);
		pLeft.add(btnFruit);

		cmbStudent.setModel(getStudent());
		cmbStudent.setSelectedIndex(-1);

	}

	private ComboBoxModel<Student> getStudent() {
		student = new DefaultComboBoxModel<Student>();

		std = new ArrayList<Student>();
		std.add(new Student(1, "서현진", 80, 90, 70));
		std.add(new Student(2, "이성경", 90, 90, 40));
		std.add(new Student(3, "이유영", 50, 50, 60));

		for (Student s : std) {
			student.addElement(s);
		}
		return student;
	}

	private ComboBoxModel<String> getModel() {

		model = new DefaultComboBoxModel<String>();

		String[] fs = new String[] { "apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry",
				"blackberry" };
		for (String f : fs) {
			model.addElement(f);
		}

		return model;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {
			btnSearchActionPerformed(e);
		}
		if (e.getSource() == btnComfirm) {
			btnComfirmActionPerformed(e);
		}
		if (e.getSource() == cmbStudent) {
			cmbStudentActionPerformed(e);
		}
		if (e.getSource() == btnFruit) {
			btnFruitActionPerformed(e);
		}
		if (e.getSource() == cmbFruit) {
			cmbFruitActionPerformed(e);
		}
		if (e.getSource() == tfFruit) {
			tfFruitActionPerformed(e);
		}
	}

	protected void tfFruitActionPerformed(ActionEvent e) {
		int cnt = cmbFruit.getItemCount();
		String addText = tfFruit.getText();
		for (int i = 0; i < cnt; i++) {
			if (cmbFruit.getItemAt(i).equals(addText)) {
				JOptionPane.showMessageDialog(null, "이미 있는 과일입니다");
				return;
			}
		}
		cmbFruit.addItem(tfFruit.getText());
	}

	protected void cmbFruitActionPerformed(ActionEvent e) {
		int selFruit = cmbFruit.getSelectedIndex();
		if (selFruit == -1) {
			lblFruit.setText("과일선택");
		} else {
			lblFruit.setText(cmbFruit.getSelectedItem() + "");
		}
	}

	protected void btnFruitActionPerformed(ActionEvent e) {
		String message = lblFruit.getText();
		if (message.equals("과일선택")) {
			message = "없습니다";
		}
		JOptionPane.showMessageDialog(null, "선택한 과일은 " + message);
	}

	protected void cmbStudentActionPerformed(ActionEvent e) {
		int idx = cmbStudent.getSelectedIndex();
		if (idx == -1) {
			lblStudent.setText("학생정보");
			return;
		}
		lblStudent.setText(cmbStudent.getSelectedItem() + "");
	}

	protected void btnComfirmActionPerformed(ActionEvent e) {
		String message = lblStudent.getText();
		if (message.equals("학생정보")) {
			message = "선택된 학생이 없습니다.";
		}
		JOptionPane.showMessageDialog(null, message);
	}

	protected void btnSearchActionPerformed(ActionEvent e) {
		int searchNo = Integer.parseInt(tfNum.getText());
		
		Iterator<Student> it = std.iterator();
		
		while(it.hasNext()) {
			Student n = it.next();
			int num = n.getStdNo();
			
			if(num == searchNo) {
				System.out.println(n);
				System.out.println();
			}
		}
		
	}
}
