package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ListEx extends JFrame implements ActionListener, ListSelectionListener {

	private JPanel contentPane;
	private ArrayList<String> listFruits;
	private ArrayList<ImageIcon> listImg;
	
	private JPanel p1;
	private JPanel pBtns1;
	private JButton btnOk1;
	private JButton btnSet1;
	//String 제네릭 추가
	private JList<String> strList;
	private JPanel p2;
	private JPanel pBtns2;
	private JScrollPane scrollPane;
	private JList<ImageIcon> imgList;
	private JButton btnOk2;
	private JButton btnSet2;
	
	private JPanel p3;
	private JTextField tf;
	private JList<String> list ;
	
	private ArrayList<String> v;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListEx frame = new ListEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListEx() {
		loadListDate();
		initialize();
	}

	private void loadListDate() {
		listFruits = new ArrayList<String>();
		listFruits.add("apple");
		listFruits.add("banana");
		listFruits.add("kiwi");
		listFruits.add("mango");
		listFruits.add("pear");
		listFruits.add("peach");
		listFruits.add("berry");
		listFruits.add("strawberry");
		listFruits.add("blackberry");
		
		String imgDirPath = System.getProperty("user.dir") + "\\images\\";
		listImg = new ArrayList<ImageIcon>();
		listImg.add(new ImageIcon(imgDirPath + "icon1.png"));
		listImg.add(new ImageIcon(imgDirPath + "icon2.png"));
		listImg.add(new ImageIcon(imgDirPath + "icon3.png"));
		listImg.add(new ImageIcon(imgDirPath + "icon4.png"));
		
		v = new ArrayList<String>();
	}
	private void initialize() {
		setTitle("JList & JCombobox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 4, 10, 10));
		
		p1 = new JPanel();
		p1.setBorder(new TitledBorder(null, "JList\uC608\uC81C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(p1);
		p1.setLayout(new BorderLayout(0, 0));
		
		// 벡터에 ArrayList 추가
		strList = new JList<>(new Vector<>(listFruits));
		strList.addListSelectionListener(this);
		p1.add(strList, BorderLayout.CENTER);
		
		pBtns1 = new JPanel();
		p1.add(pBtns1, BorderLayout.NORTH);
		pBtns1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnOk1 = new JButton("확인");
		btnOk1.addActionListener(this);
		pBtns1.add(btnOk1);
		
		btnSet1 = new JButton("선택하기");
		btnSet1.addActionListener(this);
		pBtns1.add(btnSet1);
		
		
		
		p2 = new JPanel();
		p2.setBorder(new TitledBorder(null, "JLIst\uC608\uC81C2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(p2);
		p2.setLayout(new BorderLayout(0, 0));
		
		pBtns2 = new JPanel();
		p2.add(pBtns2, BorderLayout.NORTH);
		pBtns2.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnOk2 = new JButton("확인");
		btnOk2.addActionListener(this);
		pBtns2.add(btnOk2);
		
		btnSet2 = new JButton("선택하기");
		pBtns2.add(btnSet2);
		
		scrollPane = new JScrollPane();
		p2.add(scrollPane, BorderLayout.CENTER);
		
		imgList = new JList<ImageIcon>();
		scrollPane.add(imgList);
		
		scrollPane.setViewportView(imgList);
		
		p3 = new JPanel();
		contentPane.add(p3);
		p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
		
		tf = new JTextField();
		tf.addActionListener(this);
		p3.add(tf);
		tf.setColumns(10);
		
		
		JPanel panel_1 = new JPanel();
		p3.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);
		
		list = new JList<>(new Vector<>(v));
		scrollPane_1.setViewportView(list);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tf) {
			tfActionPerformed(e);
		}
		if (e.getSource() == btnOk2) {
			btnOk2ActionPerformed(e);
		}
		if (e.getSource() == btnSet1) {
			btnSet1ActionPerformed(e);
		}
		if (e.getSource() == btnOk1) {
			btnOk1ActionPerformed(e);
		}
	}
	protected void btnOk1ActionPerformed(ActionEvent e) {
		int index = strList.getSelectedIndex();
		String message = listFruits.get(index);
		JOptionPane.showMessageDialog(null, "actionPerformed - 선택한 과일은 " + message);
		System.out.println(index + message);
	}
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == strList) {
			strListValueChanged(e);
		}
	}
	protected void strListValueChanged(ListSelectionEvent e) {
		String selectValue = strList.getSelectedValue();
		JOptionPane.showMessageDialog(null, "valueChanged - 선택한 과일은 " + selectValue);
	}
	protected void btnSet1ActionPerformed(ActionEvent e) {
		strList.setSelectedIndex(listFruits.indexOf("peach"));	
	}
	protected void btnOk2ActionPerformed(ActionEvent e) {
//		int index = imgList.getSelectedIndex();
//		System.out.println(image[index]);
	}
	protected void tfActionPerformed(ActionEvent e) {
		String newStr = tf.getText().trim();
		v.add(newStr);
		
		list.setListData(new Vector<>(v));
		tf.setText("");
	}
}
