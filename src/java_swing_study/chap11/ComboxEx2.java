package java_swing_study.chap11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
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
import java.awt.event.ItemListener;

@SuppressWarnings("serial")
public class ComboxEx2 extends JFrame implements ActionListener, ItemListener {

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
					ComboxEx2 frame = new ComboxEx2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ComboxEx2() {
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
		cmbFruit.addItemListener(this);
		cmbFruit.setMaximumRowCount(5);
		pLeft.add(cmbFruit);

		tfFruit = new JTextField();
		tfFruit.addActionListener(this);
		pLeft.add(tfFruit);
		tfFruit.setColumns(10);

		lblFruit = new JLabel("과일");
		lblFruit.setForeground(Color.RED);
		lblFruit.setHorizontalAlignment(SwingConstants.CENTER);
		pLeft.add(lblFruit);

		pRight = new JPanel();
		pRight.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC608\uC81C11-13",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));

		cmbStudent = new JComboBox<>(new Vector<>());
		cmbStudent.addItemListener(this);
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
		if (e.getSource() == btnFruit) {
			btnFruitActionPerformed(e);
		}
		if(e.getSource() == tfFruit) {
			textFieldActionPerformed(e);
		}
	}

	private void textFieldActionPerformed(ActionEvent e) {
		if(!tfFruit.getText().equals("")) {
			model.addElement(tfFruit.getText().toString());
			tfFruit.setText("");
		}
	}

	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbStudent) {
			cmbStudentItemStateChanged(e);
		}
		if (e.getSource() == cmbFruit) {
			cmbFruitItemStateChanged(e);
		}
	}
	protected void cmbFruitItemStateChanged(ItemEvent e) {
		// 조건식은 선택 상태인지를 판단하기위한 조건식이다. 선택 된 경우라면 true
		if(e.getStateChange() == ItemEvent.SELECTED) {
			lblFruit.setText(model.getSelectedItem().toString());
		}
	}
	protected void btnFruitActionPerformed(ActionEvent e) {
		int selIdx = cmbFruit.getSelectedIndex();
		if(selIdx == -1) {
			JOptionPane.showMessageDialog(null, "과일을 선택하세요");
			return;
		}
		String message = cmbFruit.getSelectedItem().toString();
		JOptionPane.showMessageDialog(null, "선택한 과일은 " + message);
	}
	protected void cmbStudentItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			Student selStudent = (Student) cmbStudent.getSelectedItem();
			String text = String.format("%d %s %3d %3d %3d %3d %.2f", 
					selStudent.getStdNo(),
					selStudent.getStdName(),
					selStudent.getKor(),
					selStudent.getEng(),
					selStudent.getMath(),
					selStudent.total(),
					selStudent.avg());
			lblStudent.setText(text);
		}
	}
	protected void btnComfirmActionPerformed(ActionEvent e) {
		int selIdx = cmbStudent.getSelectedIndex();
		if(selIdx == -1) {
			JOptionPane.showMessageDialog(null, "학생을 선택하세요.");
			return;
		}
		Student selStudent = (Student) cmbStudent.getSelectedItem();
		String text = String.format("%d %s %3d %3d %3d %3d %.2f", 
				selStudent.getStdNo(),
				selStudent.getStdName(),
				selStudent.getKor(),
				selStudent.getEng(),
				selStudent.getMath(),
				selStudent.total(),
				selStudent.avg());
		JOptionPane.showMessageDialog(null, text);
	}
	protected void btnSearchActionPerformed(ActionEvent e) {
		int intext = Integer.parseInt(tfNum.getText());
		Student searchNo = new Student(intext);
		int idx = std.indexOf(searchNo);
		cmbStudent.setSelectedIndex(idx);
	}
}
