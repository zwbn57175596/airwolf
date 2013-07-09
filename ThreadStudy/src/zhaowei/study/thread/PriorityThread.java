package zhaowei.study.thread;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PriorityThread extends JApplet {
	JTextField txt1 = new JTextField(10);
	JTextField txt2 = new JTextField(10);
	JTextField txt3 = new JTextField(20);
	ThreadClass thread1;
	ThreadClass thread2;
	JButton jb1 = new JButton("�ۼ�");
	JButton jb2 = new JButton("�ۼ�");
	int count1 = 0; // ���ܷ����ڲ����в�Ȼ���ʵľͲ���ͬһ���ڴ�
	int count2 = 0;

	public void init() {

		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(txt1);
		cp.add(txt2);
		cp.add(txt3);
		jb1.addActionListener(new AddL());
		jb2.addActionListener(new Decrease());
		cp.add(jb1);
		cp.add(jb2);
	}

	class AddL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (thread1 == null) // �жϴ˶����Ƿ����
			{
				thread1 = new ThreadClass();
				thread1.flag = true;
				thread1.setPriority(Thread.MAX_PRIORITY);// ���ô��߳�Ϊ�����ȼ�
				// ��������ֵ�ͻ��𽥵������
				thread1.start();
			}
		}
	}

	class Decrease implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (thread2 == null) // �жϴ˶����Ƿ����
			{
				thread2 = new ThreadClass();
				thread2.flag = false;
				thread2.setPriority(Thread.MIN_PRIORITY);// ���ô��߳�Ϊ������ȼ�
				thread2.start();

			}

		}
	}

	class ThreadClass extends Thread// �ò���д����thread��
	// ֻ��Ҫһ�����㹻����flag���ж�
	{
		boolean flag;

		public void run() {

			while (true) {
				if (flag) {
					txt1.setText(Integer.toString(count1++));
				} else {
					txt2.setText(Integer.toString(count2--));
				}
				txt3.setText("count1+count2=" + Integer.toString(count1 + count2));
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}
}
