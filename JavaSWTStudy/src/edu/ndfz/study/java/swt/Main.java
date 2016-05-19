package edu.ndfz.study.java.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.*;

public class Main {

	public static void main(String[] args) {
		
		// step 1
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Hello World");
//		shell.setSize(800, 600);
		shell.setLayout(new FillLayout(SWT.VERTICAL));
		

		Label label = new Label(shell, SWT.CENTER);
		label.setText("This is the label text");
		
		Text name = new Text(shell, SWT.LEFT);
		name.setText("<none>");
		name.setTextLimit(50);
		name.setToolTipText("Enter your name -- Last, First");
		name.selectAll();
		
		
		shell.open();
		// step1
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
