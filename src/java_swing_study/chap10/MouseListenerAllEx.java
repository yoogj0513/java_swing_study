package java_swing_study.chap10;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MouseListenerAllEx extends JFrame {
	private JLabel la = new JLabel("No Mouse Event"); // 메세지 출력 레이블 컴포넌트

	public static void main(String[] args) {
		new MouseListenerAllEx();
	}

	
	public MouseListenerAllEx() {
		setTitle("MouseListener와 MouseMotionListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		MyMouseListener listener = new MyMouseListener(); // 리스너 객체 생성
		c.addMouseListener(listener); // MouseListener 리스너 등록
		c.addMouseMotionListener(listener); // MouseMotionListener 리스너 등록
		
		c.add(la);
		setSize(300, 200);
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			la.setText("mousePressed (" + e.getX() + ", " + e.getY() + ")");//마우스가 눌러진 위치 (x, y) 점을 출력
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}


