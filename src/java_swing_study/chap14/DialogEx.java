package java_swing_study.chap14;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java_swing_study.chap11.exam.Student;
import java_swing_study.chap11.exam.StudentPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogEx extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private StudentPanel pStd;
	private MenuActionEventEx parent;
	private JButton cancelButton;

	public void setParent(MenuActionEventEx parent) {
		this.parent = parent;
	}

	public DialogEx() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			pStd = new StudentPanel();
			contentPanel.add(pStd, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelButton) {
			cancelButtonActionPerformed(e);
		}
		if (e.getSource() == okButton) {
			okButtonActionPerformed(e);
		}
	}

	protected void okButtonActionPerformed(ActionEvent e) {
		Student std = pStd.getItem();
		System.out.println(std);
		parent.setStudentText(std);
		pStd.clearTf();
		dispose();
	}

	public void setStudent(Student std) {
		pStd.setItem(std);
	}

	public Student getStudent() {
		return pStd.getItem();
	}

	protected void cancelButtonActionPerformed(ActionEvent e) {
		setVisible(false);
	}

	public Student getInput() {
		Student std = pStd.getItem();
//		System.out.println(std);
		return std;
	}
}
