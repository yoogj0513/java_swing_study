package java_swing_study.chap09.layout;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class GridLayoutEx extends JFrame {

	private JPanel contentPane;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblNO;
	private JTextField tfNo;
	private JLabel lblDept;
	private JTextField tfDept;
	private JLabel lblSubj;
	private JTextField tfSubj;

	public GridLayoutEx() {
		initialize();
	}
	private void initialize() {
		setTitle("GridLayout Sample");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 5));
		
		lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		lblNO = new JLabel("학번");
		lblNO.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNO);
		
		tfNo = new JTextField();
		tfNo.setColumns(10);
		contentPane.add(tfNo);
		
		lblDept = new JLabel("학과");
		lblDept.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblDept);
		
		tfDept = new JTextField();
		tfDept.setColumns(10);
		contentPane.add(tfDept);
		
		lblSubj = new JLabel("과목");
		lblSubj.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblSubj);
		
		tfSubj = new JTextField();
		tfSubj.setColumns(10);
		contentPane.add(tfSubj);
	}
}
