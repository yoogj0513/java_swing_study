package java_swing_study.chap11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Slider_SpinnerEx extends JFrame implements ChangeListener, ActionListener {

	private JPanel contentPane;
	private JPanel pSlider1;
	private JPanel pSlider2;
	private JPanel pSpinner1;
	private JPanel pSpinner2;
	private JSlider slider1;
	private JLabel lblValue1;
	private JSlider sliderRed;
	private JSlider sliderGreen;
	private JSlider sliderBlue;
	private JLabel lblColor;
	private JPanel panel;
	private JLabel lblRed;
	private JTextField tfRed;
	private JLabel lblGreen;
	private JTextField tfGreen;
	private JLabel lblBlue;
	private JTextField tfBlue;
	private JButton btn1;
	private JPanel panel_1;
	private JSpinner spList;
	private JLabel lblList;
	private JPanel panel_2;
	private JPanel panel_3;
	private JSpinner spNumber;
	private JLabel lblNumber;
	private JSpinner spDate;
	private JLabel lblDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Slider_SpinnerEx frame = new Slider_SpinnerEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Slider_SpinnerEx() {
		initialize();
	}

	private void initialize() {
		setTitle("JSlider와 JSpinner 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));

		pSlider1 = new JPanel();
		pSlider1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC608\uC81C 11-14",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pSlider1);
		pSlider1.setLayout(new GridLayout(0, 1, 0, 0));

		slider1 = new JSlider();
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		slider1.setMinorTickSpacing(10);
		slider1.setMajorTickSpacing(50);
		slider1.setMaximum(200);
		pSlider1.add(slider1);

		lblValue1 = new JLabel("0");
		lblValue1.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue1.setFont(new Font("굴림", Font.BOLD, 12));
		lblValue1.setForeground(new Color(220, 20, 60));
		pSlider1.add(lblValue1);

		pSlider2 = new JPanel();
		pSlider2.setBorder(
				new TitledBorder(null, "\uC608\uC81C 11-15", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSlider2);
		pSlider2.setLayout(new GridLayout(0, 1, 0, 0));

		panel = new JPanel();
		pSlider2.add(panel);
		panel.setLayout(new GridLayout(0, 7, 0, 0));

		lblRed = new JLabel("Red");
		lblRed.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblRed);

		tfRed = new JTextField();
		panel.add(tfRed);
		tfRed.setColumns(10);

		lblGreen = new JLabel("Green");
		lblGreen.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblGreen);

		tfGreen = new JTextField();
		tfGreen.setColumns(10);
		panel.add(tfGreen);

		lblBlue = new JLabel("Blue");
		lblBlue.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblBlue);

		tfBlue = new JTextField();
		tfBlue.setColumns(10);
		panel.add(tfBlue);

		btn1 = new JButton("적용");
		panel.add(btn1);

		sliderRed = new JSlider();
		sliderRed.setFont(new Font("굴림", Font.BOLD, 12));
		sliderRed.setPaintLabels(true);
		sliderRed.setPaintTicks(true);
		sliderRed.setMinorTickSpacing(10);
		sliderRed.setMajorTickSpacing(50);
		sliderRed.setMaximum(255);
		sliderRed.setForeground(new Color(255, 0, 0));
		pSlider2.add(sliderRed);

		sliderGreen = new JSlider();
		sliderGreen.setFont(new Font("굴림", Font.BOLD, 12));
		sliderGreen.setForeground(new Color(0, 128, 0));
		sliderGreen.setPaintTicks(true);
		sliderGreen.setPaintLabels(true);
		sliderGreen.setMinorTickSpacing(10);
		sliderGreen.setMaximum(255);
		sliderGreen.setMajorTickSpacing(50);
		pSlider2.add(sliderGreen);

		sliderBlue = new JSlider();
		sliderBlue.setMaximum(255);
		sliderBlue.setPaintTicks(true);
		sliderBlue.setPaintLabels(true);
		sliderBlue.setMinorTickSpacing(10);
		sliderBlue.setMajorTickSpacing(50);
		sliderBlue.setForeground(new Color(30, 144, 255));
		sliderBlue.setFont(new Font("굴림", Font.BOLD, 12));
		pSlider2.add(sliderBlue);

		lblColor = new JLabel("SLIDER EXAMPLE");
		lblColor.setFont(new Font("굴림", Font.BOLD, 16));
		lblColor.setHorizontalAlignment(SwingConstants.CENTER);
		lblColor.setBackground(new Color(0, 139, 139));
		lblColor.setOpaque(true);
		pSlider2.add(lblColor);

		pSpinner1 = new JPanel();
		pSpinner1.setBorder(
				new TitledBorder(null, "JSpinner \uC608\uC81C1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSpinner1);
		pSpinner1.setLayout(new GridLayout(0, 1, 0, 0));

		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		pSpinner1.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		spList = new JSpinner();
		spList.setModel(new SpinnerListModel(
				new String[] { "\uC18C\uC124", "\uC7A1\uC9C0", "\uC804\uACF5\uC11C\uC801", "\uCDE8\uBBF8" }));
		panel_1.add(spList);

		lblList = new JLabel("List");
		lblList.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblList.setForeground(new Color(0, 139, 139));
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblList);

		panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(10, 10, 10, 10));
		pSpinner1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));

		spNumber = new JSpinner();
		spNumber.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(5)));
		panel_2.add(spNumber);

		lblNumber = new JLabel("Number");
		lblNumber.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblNumber.setForeground(new Color(0, 139, 139));
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNumber);

		panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(10, 10, 10, 10));
		pSpinner1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));

		spDate = new JSpinner();
		spDate.setModel(new SpinnerDateModel(new Date(1579186800000L), null, null, Calendar.DAY_OF_WEEK_IN_MONTH));

		panel_3.add(spDate);

		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lblDate.setForeground(new Color(0, 139, 139));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblDate);

		pSpinner2 = new JPanel();
		pSpinner2.setBorder(
				new TitledBorder(null, "JSpinner \uC608\uC81C2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pSpinner2);

		// Listener는 가장 마지막에 배치
		slider1.addChangeListener(this);
		slider1.setValue(100);

		// --------------------------------
		sliderRed.addChangeListener(this);
		sliderGreen.addChangeListener(this);
		sliderBlue.addChangeListener(this);
		sliderRed.setValue(128);
		sliderGreen.setValue(128);
		sliderBlue.setValue(128);

		btn1.addActionListener(this);

		// ---------------------------------
		spList.addChangeListener(this);
		spNumber.addChangeListener(this);
		spDate.addChangeListener(this);
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == spDate) {
			spDateStateChanged(e);
		}
		if (e.getSource() == spNumber) {
			spNumberStateChanged(e);
		}
		if (e.getSource() == spList) {
			spListStateChanged(e);
		}
		if (e.getSource() == sliderRed || e.getSource() == sliderGreen || e.getSource() == sliderBlue) {
			sliderColorStateChanged(e);
		}
		if (e.getSource() == slider1) {
			slider1StateChanged(e);
		}
	}

	private void sliderColorStateChanged(ChangeEvent e) {
		int red = sliderRed.getValue();
		int green = sliderGreen.getValue();
		int blue = sliderBlue.getValue();

		lblColor.setBackground(new Color(red, green, blue));
		tfRed.setText(sliderRed.getValue() + "");
		tfGreen.setText(sliderGreen.getValue() + "");
		tfBlue.setText(sliderBlue.getValue() + "");
	}

	protected void slider1StateChanged(ChangeEvent e) {
		lblValue1.setText(slider1.getValue() + "");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			btn1ActionPerformed(e);
		}
	}

	protected void btn1ActionPerformed(ActionEvent e) {
		int red = Integer.parseInt(tfRed.getText());
		int green = Integer.parseInt(tfGreen.getText());
		int blue = Integer.parseInt(tfBlue.getText());

		sliderRed.setValue(red);
		sliderGreen.setValue(green);
		sliderBlue.setValue(blue);
	}

	protected void spListStateChanged(ChangeEvent e) {
		lblList.setText(spList.getValue().toString());
	}

	protected void spNumberStateChanged(ChangeEvent e) {
		lblNumber.setText(spNumber.getValue().toString());
	}

	protected void spDateStateChanged(ChangeEvent e) {
		lblDate.setText(spDate.getValue().toString());
	}
}
