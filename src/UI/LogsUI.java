package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class LogsUI extends JFrame implements ActionListener{

	private JButton close, migrate, add, view, logs, settings; 
	private JLabel label, migrateT, addT, viewT, logsT, settingsT;
	private JLabel lblHistory;
	
	public LogsUI() {
		
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
		ImageIcon img = new ImageIcon("C:/Users/Precious Dimagiba/Documents/workspace/DataMigration/Images/logsbg.jpg");
		label.setIcon(img);
		label.setBounds(0, 0, 1366, 730);
		
		close = new JButton("X");
		close.setBounds(1100, 10, 35, 35);
		close.addActionListener(this);
		getContentPane().add(close);
		
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
		add.addActionListener(this);
		getContentPane().add(add);
		
		addT = new JLabel("Add");
		addT.setFont(new Font("Verdana", Font.BOLD, 14));
		addT.setForeground(Color.white);
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
		getContentPane().add(logs);
		
		logsT = new JLabel("Logs");
		logsT.setFont(new Font("Verdana", Font.BOLD, 14));
		logsT.setForeground(Color.black);
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
		
		lblHistory = new JLabel("History");
		lblHistory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHistory.setBounds(321, 185, 50, 20);
		getContentPane().add(lblHistory);
		
		getContentPane().add(label);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
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
		
		if(e.getSource() == add){
			AddUI a = new AddUI();
			a.setVisible(true);
			dispose();
		}
		
		if(e.getSource() == view){
			ViewUI u = new ViewUI();
			u.setVisible(true);
			dispose();
		}
			
		if(e.getSource() == settings){
			SettingsUI s = new SettingsUI();
			s.setVisible(true);
			dispose();
		}
	}
	
	public static void main(String[] args) {
		
		LogsUI l = new LogsUI();
		l.setVisible(true);
	}
}
