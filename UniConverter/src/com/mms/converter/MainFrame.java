package com.mms.converter;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.mms.util.FILE_TYPE;

public class MainFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 8477350989539017919L;

	private JPanel contentPane;
	private JFileChooser jf;
	private JTextField src;
	private JTextField target;
	private JRadioButton rdbtnZawgyiToUnicode;
	private JRadioButton rdbtnUnicodeToZawgyi;
	private FileFilter filter;
	private JProgressBar progressBar;
	private JButton convert;
	private JButton btnNewButton;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("JZ2U File Converter");
		setBounds(100, 100, 696, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel header = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addComponent(header, GroupLayout.PREFERRED_SIZE, 673,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(111, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addComponent(header,
				GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE));

		JLabel lblJavaZcConverter = new JLabel("JZ2U File Converter");
		lblJavaZcConverter
				.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));

		JLabel lblSource = new JLabel("Source");
		src = new JTextField();
		JLabel lblTarget = new JLabel("Target");
		target = new JTextField();

		ButtonGroup bg = new ButtonGroup();
		rdbtnZawgyiToUnicode = new JRadioButton("Zawgyi To Unicode");
		rdbtnUnicodeToZawgyi = new JRadioButton("Unicode To Zawgyi");
		bg.add(rdbtnZawgyiToUnicode);
		bg.add(rdbtnUnicodeToZawgyi);
		rdbtnZawgyiToUnicode.setSelected(true);

		convert = new JButton("Convert");
		btnNewButton = new JButton(
				new ImageIcon(MainFrame.class
						.getResource("/com/mms/converter/Documents.png")));
		button = new JButton(
				new ImageIcon(MainFrame.class
						.getResource("/com/mms/converter/Documents.png")));

		convert.setActionCommand("convert");
		btnNewButton.setActionCommand("src");
		button.setActionCommand("target");

		convert.addActionListener(this);
		btnNewButton.addActionListener(this);
		button.addActionListener(this);

		progressBar = new JProgressBar();

		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_header.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_header.createParallelGroup(Alignment.TRAILING)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_header.createSequentialGroup()
							.addGroup(gl_header.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_header.createSequentialGroup()
									.addComponent(lblJavaZcConverter)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_header.createSequentialGroup()
									.addComponent(lblSource)
									.addGap(5))
								.addGroup(gl_header.createSequentialGroup()
									.addComponent(lblTarget)
									.addGap(5)))
							.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_header.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(target, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
								.addGroup(gl_header.createSequentialGroup()
									.addComponent(rdbtnZawgyiToUnicode)
									.addGap(18)
									.addComponent(rdbtnUnicodeToZawgyi)
									.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
									.addComponent(convert, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_header.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(src, GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(102))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblJavaZcConverter)
					.addGap(6)
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSource, Alignment.TRAILING)
						.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(src, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTarget, Alignment.TRAILING)
						.addComponent(button, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(target, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_header.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnZawgyiToUnicode)
						.addComponent(rdbtnUnicodeToZawgyi)
						.addComponent(convert))
					.addGap(21)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		header.setLayout(gl_header);
		contentPane.setLayout(gl_contentPane);
		jf = new JFileChooser();
		jf.setCurrentDirectory(new File("./"));

		filter = new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if (pathname.isDirectory())
					return true;
				if (pathname.getName().toLowerCase().indexOf(".txt") > 0
						|| pathname.getName().toLowerCase().indexOf(".html") > 0
						|| pathname.getName().toLowerCase().indexOf(".htm") > 0
						|| pathname.getName().toLowerCase().indexOf(".tsv") > 0
						|| pathname.getName().toLowerCase().indexOf(".csv") > 0)
					return true;
				return false;
			}
		};

		jf.setFileFilter(new Myfilter(filter));
	}

	class Myfilter extends javax.swing.filechooser.FileFilter {
		private FileFilter ff;

		public Myfilter(FileFilter ff) {
			this.ff = ff;
		}

		@Override
		public String getDescription() {
			return ".csv .tsv .txt .htm .html";
		}

		@Override
		public boolean accept(File f) {
			return ff.accept(f);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String cmd = e.getActionCommand();
			if ("convert".equals(cmd)) {
				progressBar.setValue(0);
				String srcText = src.getText();
				if (null == srcText || srcText.isEmpty())
					throw new Exception("Please select source files!");
				String targetText = target.getText();
				if (null == targetText || targetText.isEmpty())
					throw new Exception(
							"Please set the Directory for output files.");

				File targetFile = new File(targetText);
				if (!targetFile.isDirectory())
					throw new Exception("Invalid Target Directory");

				FILE_TYPE fType = null;
				if (this.rdbtnZawgyiToUnicode.isSelected())
					fType = FILE_TYPE.ZAWGYI;
				else
					fType = FILE_TYPE.UNI;

				this.setEditable(false);
				
				List<File> inFiles = new ArrayList<File>();
				String[] srcFiles = srcText.split(",");
				for (String srcFile : srcFiles) {
					inFiles.addAll(this.getFiles(new File(srcFile)));
				}

				progressBar.setMaximum(inFiles.size());
				for (int i = 0; i < inFiles.size(); i++) {
					new FileConverter(inFiles.get(i), fType)
							.writeConvertFile(this.getOutFileName(inFiles
									.get(i).getName()));
					progressBar.setValue(i + 1);
				}
				this.setEditable(true);
				JOptionPane.showMessageDialog(this, "Convertion Process is finished.");
				
			} else if ("src".equals(cmd)) {
				jf.setMultiSelectionEnabled(true);
				jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				if (JFileChooser.OPEN_DIALOG == jf.showOpenDialog(this)) {
					File[] files = jf.getSelectedFiles();
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < files.length; i++) {
						sb.append(files[i].getAbsolutePath());
						if (i < files.length - 1)
							sb.append(",");
					}
					src.setText(sb.toString());
				}

			} else {
				jf.setMultiSelectionEnabled(false);
				jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if (JFileChooser.OPEN_DIALOG == jf.showOpenDialog(this)) {
					target.setText(jf.getSelectedFile().getAbsolutePath());

				}
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Z2E Error",
					JOptionPane.ERROR_MESSAGE);
			this.setEditable(true);
		}
	}

	private String getOutFileName(String inFileName) {
		String targetStr = this.target.getText();
		StringBuilder sb = new StringBuilder(targetStr);
		if (!targetStr.endsWith("/")) {
			sb.append("/");
		}

		String[] names = inFileName.split("\\.");
		for (int i = 0; i < names.length; i++) {
			if (i == names.length - 2) {
				sb.append(names[i]).append("_");
				if (rdbtnZawgyiToUnicode.isSelected())
					sb.append("Z2U_");
				else
					sb.append("U2Z_");
				sb.append(
						new SimpleDateFormat("yyyyMMddHHmmss")
								.format(new Date())).append(".");
			} else if (i == names.length - 1){
				sb.append(names[i]);
			} else {
				sb.append(names[i]).append(".");
			}
		}
		return sb.toString();
	}

	private void setEditable(boolean status) {
		this.src.setEditable(status);
		this.target.setEditable(status);
		this.button.setEnabled(status);
		this.btnNewButton.setEnabled(status);
		this.convert.setEnabled(status);
		this.rdbtnUnicodeToZawgyi.setEnabled(status);
		this.rdbtnZawgyiToUnicode.setEnabled(status);
	}

	private List<File> getFiles(File file) {
		List<File> retfiles = new ArrayList<File>();
		if (file.isDirectory()) {
			File[] files = file.listFiles(filter);
			for (int i = 0; i < files.length; i++) {
				retfiles.addAll(this.getFiles(files[i]));
			}
		} else {
			retfiles.add(file);
		}
		return retfiles;
	}
}
