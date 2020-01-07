package java_swing_study.chap09;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ContentPaneEx extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ContentPaneEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창의 엑스버튼을 누르면 클로즈
		setBounds(100, 100, 450, 300); // 가로좌표, 세로좌표, 가로너비, 세로너비
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // EmptyBorder(상, 하, 좌, 우); == css패팅과 같음
		contentPane.setLayout(new BorderLayout(0, 0)); // BorderLayout은 총 다섯 영역이 있음. 위, 아래, 좌, 우, 중앙
		setContentPane(contentPane);// contentPane을 넣어라. set
	}

}
