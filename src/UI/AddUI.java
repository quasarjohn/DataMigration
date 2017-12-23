package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class AddUI extends JFrame implements ActionListener {

	private JButton close, migrate, add, view, logs, settings, addData, file; 
	private JTextArea text;
	private JLabel label, migrateT, addT, viewT, logsT, settingsT;
	private JRadioButton db2, mysql, msaccess;


	
	public AddUI() {
		
		setSize(1170,730);
		setLocationRelativeTo(null);
		setResizable(false);	
		getContentPane().setLayout(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}catch(Exception e) {
			
		}
		
		label = new JLabel();
		ImageIcon img = new ImageIcon("C:/Users/Precious Dimagiba/Documents/workspace/DataMigration/Images/addbg.jpg");
		label.setIcon(img);
		label.setBounds(0, 0, 1366, 730);
		
		close = new JButton("X");
		close.setBounds(1100, 10, 35, 35);
		close.addActionListener(this);
		getContentPane().add(close);
		
		// Side Menu
		
		migrate = new JButton();
		ImageIcon migrateB = new ImageIcon("C:/Users/Precious Dimagiba/Documents/workspace/DataMigration/Images/migratedb.png");
		migrate.setIcon(migrateB);
		migrate.setOpaque(false);
		migrate.setContentAreaFilled(false);
		migrate.setBorderPainted(false);
		migrate.setBounds(60, 165, 50, 50);
		migrate.addActionListener(this);
		getContentPane().add(migrate);
		
		migrateT = new JLabel("Migrate");
		migrateT.setFont(new Font("Verdana", Font.BOLD, 14));
		migrateT.setForeground(Color.white);
		migrateT.setBounds(120, 165, 87, 50);
		getContentPane().add(migrateT);
		
		add = new JButton();
		ImageIcon addB = new ImageIcon("C:/Users/Precious Dimagiba/Documents/workspace/DataMigration/Images/add.png");
		add.setIcon(addB);
		add.setOpaque(false);
		add.setContentAreaFilled(false);
		add.setBorderPainted(false);
		add.setBounds(60, 265, 50, 50);
		getContentPane().add(add);
		
		addT = new JLabel("Add");
		addT.setFont(new Font("Verdana", Font.BOLD, 14));
		addT.setForeground(Color.BLACK);
		addT.setBounds(120, 265, 50, 50);
		getContentPane().add(addT);
		
		view = new JButton();
		ImageIcon viewB = new ImageIcon("C:/Users/Precious Dimagiba/Documents/workspace/DataMigration/Images/view.png");
		view.setIcon(viewB);
		view.setOpaque(false);
		view.setContentAreaFilled(false);
		view.setBorderPainted(false);
		view.setBounds(60, 365, 50, 50);
		view.addActionListener(this);
		getContentPane().add(view);
		
		viewT = new JLabel("View");
		viewT.setFont(new Font("Verdana", Font.BOLD, 14));
		viewT.setForeground(Color.white);
		viewT.setBounds(120, 365, 50, 50);
		getContentPane().add(viewT);
		
		logs = new JButton();
		ImageIcon logsB = new ImageIcon("C:/Users/Precious Dimagiba/Documents/workspace/DataMigration/Images/logs.png");
		logs.setIcon(logsB);
		logs.setOpaque(false);
		logs.setContentAreaFilled(false);
		logs.setBorderPainted(true);
		logs.setBounds(60, 465, 50, 50);
		logs.addActionListener(this);
		getContentPane().add(logs);
		
		logsT = new JLabel("Logs");
		logsT.setFont(new Font("Verdana", Font.BOLD, 14));
		logsT.setForeground(Color.white);
		logsT.setBounds(120, 465, 60, 50);
		getContentPane().add(logsT);
		
		settings = new JButton();
		ImageIcon systemB = new ImageIcon("C:/Users/Precious Dimagiba/Documents/workspace/DataMigration/Images/settings.png");
		settings.setIcon(systemB);
		settings.setOpaque(false);
		settings.setContentAreaFilled(false);
		settings.setBorderPainted(false);
		settings.setBounds(60, 565, 50, 50);
		settings.addActionListener(this);
		getContentPane().add(settings);
		
		settingsT = new JLabel("Settings");
		settingsT.setFont(new Font("Verdana", Font.BOLD, 14));
		settingsT.setForeground(Color.white);
		settingsT.setBounds(120, 565, 87, 50);
		getContentPane().add(settingsT);
	
		// end of side menu
		
		file = new JButton("Open File");
		file.setBounds(364, 216, 87, 36);
		file.addActionListener(this);
		getContentPane().add(file);
		
		text = new JTextArea();
		text.setEditable(false);
		text.setBounds(364, 265, 346, 250);
		getContentPane().add(text);
		
		db2 = new JRadioButton("DB2");
		db2.setBounds(364, 537, 109, 23);
		getContentPane().add(db2);
		
		mysql = new JRadioButton("MySQL");
		mysql.setBounds(364, 565, 109, 23);
		getContentPane().add(mysql);
		
		msaccess = new JRadioButton("MS Access");
		msaccess.setBounds(364, 591, 109, 23);
		getContentPane().add(msaccess);
		
		
		addData = new JButton("Add Data");
		addData.setBounds(582, 537, 89, 23);
		addData.setEnabled(false);
		addData.addActionListener(this);
		getContentPane().add(addData);
		
		
		getContentPane().add(label);
		
	}
	
		
		public void actionPerformed(ActionEvent e) {
		
			JFileChooser fileChooser = new JFileChooser("C:\\xampp\\mysql\\bin");
		
				if(e.getSource() == file) {
					int returnValue = fileChooser.showOpenDialog(null);
			
					if(returnValue == JFileChooser.APPROVE_OPTION) {
						File selectedFile = fileChooser.getSelectedFile();
						String filename = selectedFile.getAbsolutePath();
					
						try {
							FileReader reader = new FileReader(filename);
							BufferedReader br = new BufferedReader(reader);
							
							text.read(br, null);
							br.close();
							text.setText(text.getText());
							
							addData.setEnabled(true);
							
						}catch (Exception e1){
							text.setText("Error");
						}
					}
				}
				
				
				
				if(e.getSource() == close) {
					if(JOptionPane.showConfirmDialog(null, "Confirm Exit?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}
				
				if(e.getSource() == migrate){
					MigrateUI m = new MigrateUI();
					m.setVisible(true);
					dispose();
				}
				
				if(e.getSource() == view){
					ViewUI u = new ViewUI();
					u.setVisible(true);
					dispose();
				}
				
				if(e.getSource() == logs){
					LogsUI l = new LogsUI();
					l.setVisible(true);
					dispose();
				}
				
				if(e.getSource() == settings){
					SettingsUI s = new SettingsUI();
					s.setVisible(true);
					dispose();
				}
				
				if(e.getSource() == addData) {
					
					if(JOptionPane.showConfirmDialog(null, "Add Data?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
					String text1 = text.getText();
					System.out.println(text1 + "Added Successfully");
					
					JOptionPane.showMessageDialog(null, "Added Successfully");
					}
				}
		}
		
	
	public static void main(String[] args) {
		
		AddUI a = new AddUI();
		a.setVisible(true);
	}
}
