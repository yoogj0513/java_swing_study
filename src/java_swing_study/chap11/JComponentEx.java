package java_swing_study.chap11;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.event.ContainerListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ContainerEvent;

public class JComponentEx extends JFrame implements ActionListener, ContainerListener {

	private JPanel contentPane;
	private JPanel pLeft;
	private JPanel pRight;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComponentEx frame = new JComponentEx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JComponentEx() {
		initialize();
	}

	private void initialize() {
		setTitle("JComponent의 공통 메소드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 5, 5));

		pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "11-1\uC608\uC81C",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pLeft);
		pLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btn1 = new JButton("Magenta/Yellow Button");
		btn1.addActionListener(this);
		btn1.setFont(new Font("Arial", Font.ITALIC, 16));
		btn1.setForeground(Color.MAGENTA);
		btn1.setBackground(Color.YELLOW);
		pLeft.add(btn1);

		btn2 = new JButton("Disabled Button");
		btn2.setEnabled(false);
		pLeft.add(btn2);

		btn3 = new JButton("getX(), getY()");
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				JComponentEx frame = (JComponentEx) b.getTopLevelAncestor();
				frame.setTitle(b.getX() + ", " + b.getY());
			}
		});
		pLeft.add(btn3);

		btn4 = new JButton("Right Panel Add Btn");
		btn4.addActionListener(this);
		pLeft.add(btn4);

		btn5 = new JButton("Right Panel remove Btn");
		btn5.addActionListener(this);
		pLeft.add(btn5);

		pRight = new JPanel();
		pRight.addContainerListener(this);
		pRight.setBorder(new TitledBorder(null, "JComponent\uBA54\uC11C\uB4DC", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		contentPane.add(pRight);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn5) {
			btn5ActionPerformed(e);
		}
		if (e.getSource() == btn4) {
			btn4ActionPerformed(e);
		}
		if (e.getSource() == btn1) {
			btn1ActionPerformed(e);
		}
	}

	protected void btn1ActionPerformed(ActionEvent e) {
		if (btn2.isEnabled() == true) {
			btn2.setEnabled(false);
		} else {
			btn2.setEnabled(true);
		}
	}

	protected void btn4ActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "버튼추가");
		JButton btn = new JButton("AddBtn");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Test");
				frame.addWindowListener(new WindowListener() {
					
					@Override
					public void windowOpened(WindowEvent e) {
						System.out.printf("%s()%n", "windowOpened");
					}
					
					@Override
					public void windowIconified(WindowEvent e) {
						System.out.printf("%s()%n", "windowIconified");
					}
					
					@Override
					public void windowDeiconified(WindowEvent e) {
						System.out.printf("%s()%n", "windowDeiconified");
					}
					
					@Override
					public void windowDeactivated(WindowEvent e) {
						System.out.printf("%s()%n", "windowDeactivated");
					}
					
					@Override
					public void windowClosing(WindowEvent e) {
						System.out.printf("%s()%n", "windowClosing");
					}
					
					@Override
					public void windowClosed(WindowEvent e) {
						System.out.printf("%s()%n", "windowClosed");
					}
					
					@Override
					public void windowActivated(WindowEvent e) {
						System.out.printf("%s()%n", "windowActivated");
					}
				});
				frame.setBounds(600, 100, 450, 300);
				frame.setVisible(true);
			}
		});
		pRight.add(btn);
		pRight.revalidate();
		pRight.repaint();
	}

	protected void btn5ActionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "버튼 삭제");
		Container c = pRight;
		c.removeAll();
		c.revalidate();
		c.repaint();
	}

	public void componentAdded(ContainerEvent e) {
		if (e.getSource() == pRight) {
			pRightComponentAdded(e);
		}
	}

	public void componentRemoved(ContainerEvent e) {

	}

	protected void pRightComponentAdded(ContainerEvent e) {

	}
}
