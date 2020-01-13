package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class LabelEx extends JFrame {

	private JPanel contentPane;
	private JLabel lblImg1;
	private JLabel lblText;
	private JLabel lblImg2;
	private JButton btn1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LabelEx frame = new LabelEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LabelEx() {
		initialize();
	}
	private void initialize() {
		setTitle("레이블, 이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblText = new JLabel("사랑합니다.");
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblText, BorderLayout.NORTH);
		
		lblImg1 = new JLabel("New label");
		lblImg1.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseClicked()");
			}
		});
		
//		lblNewLabel.setIcon(new ImageIcon("D:\\workspace\\workspace_java\\java_swing_study\\images\\beauty.jpg"));
		// 작업하고 있는 경로에서 이미지 폴더에 있는 이미지를 가져와야함
		String dirPath = System.getProperty("user.dir") + "\\images\\";
		lblImg1.setIcon(new ImageIcon(dirPath + "beauty.jpg"));
		contentPane.add(lblImg1, BorderLayout.CENTER);
		
		
		ImageIcon normalIcon = new ImageIcon(dirPath + "normalIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon(dirPath + "rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon(dirPath + "pressedIcon.gif");
		
		btn1 = new JButton("call~~", normalIcon);
		btn1.setHorizontalAlignment(SwingConstants.CENTER);
		btn1.setPressedIcon(pressedIcon);
		btn1.setRolloverIcon(rolloverIcon);
		contentPane.add(btn1, BorderLayout.SOUTH);
		
		
		setSize(400, 600);
	}

}
