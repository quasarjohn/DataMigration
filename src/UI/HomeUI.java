package UI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class HomeUI extends JFrame {
	
	private JPanel panel;
	private JButton migrate, add, view, logs, settings; 
	private JTextArea area;
	private JLabel label, migrateT, addT, viewT, logsT, settingsT;
	
	public HomeUI() {
		
		setSize(1170,730);
		setLocationRelativeTo(null);
		setResizable(false);	
		setLayout(null);
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
		ImageIcon img = new ImageIcon("C:/Users/Precious Dimagiba/Documents/workspace/DataMigration/Images/background1.jpg");
		label.setIcon(img);
		label.setBounds(0, 0, 1366, 730);
		
		migrate = new JButton();
		ImageIcon migrateB = new ImageIcon("C:/Users/Precious Dimagiba/Documents/workspace/DataMigration/Images/migratedb.png");
		migrate.setIcon(migrateB);
		migrate.setOpaque(false);
		migrate.setContentAreaFilled(false);
		migrate.setBorderPainted(false);
		migrate.setBounds(17, 150, 50, 50);
		
		migrateT = new JLabel("Migrate");
		Font migrateF = new Font("Verdana", Font.PLAIN, 12);
		migrateT.setFont(migrateF);
		migrateT.setForeground(Color.white);
		migrateT.setBounds(20, 186, 50, 50);
		
		add = new JButton();
		ImageIcon addB = new ImageIcon("C:/Users/Precious Dimagiba/Documents/workspace/DataMigration/Images/add.png");
		add.setIcon(addB);
		add.setOpaque(false);
		add.setContentAreaFilled(false);
		add.setBorderPainted(false);
		add.setBounds(17, 235, 50, 50);
		
		addT = new JLabel("Add");
		Font addF = new Font("Verdana", Font.PLAIN, 12);
		addT.setFont(addF);
		addT.setForeground(Color.white);
		addT.setBounds(30, 273, 50, 50);
		
		view = new JButton();
		ImageIcon viewB = new ImageIcon("C:/Users/Precious Dimagiba/Documents/workspace/DataMigration/Images/view.png");
		view.setIcon(viewB);
		view.setOpaque(false);
		view.setContentAreaFilled(false);
		view.setBorderPainted(false);
		view.setBounds(17, 317, 50, 50);
		
		viewT = new JLabel("View");
		Font viewF = new Font("Verdana", Font.PLAIN, 12);
		viewT.setFont(viewF);
		viewT.setForeground(Color.white);
		viewT.setBounds(27, 352, 50, 50);
		
		logs = new JButton();
		ImageIcon logsB = new ImageIcon("C:/Users/Precious Dimagiba/Documents/workspace/DataMigration/Images/logs.png");
		logs.setIcon(logsB);
		logs.setOpaque(false);
		logs.setContentAreaFilled(false);
		logs.setBorderPainted(true);
		logs.setBounds(17, 397, 50, 50);
		
		logsT = new JLabel("Logs");
		Font logsF = new Font("Verdana", Font.PLAIN, 12);
		logsT.setFont(logsF);
		logsT.setForeground(Color.white);
		logsT.setBounds(27, 432, 60, 50);
		
		settings = new JButton();
		ImageIcon systemB = new ImageIcon("C:/Users/Precious Dimagiba/Documents/workspace/DataMigration/Images/settings.png");
		settings.setIcon(systemB);
		settings.setOpaque(false);
		settings.setContentAreaFilled(false);
		settings.setBorderPainted(false);
		settings.setBounds(17, 475, 50, 50);
		
		settingsT = new JLabel("Settings");
		Font settingsF = new Font("Verdana", Font.PLAIN, 12);
		settingsT.setFont(settingsF);
		settingsT.setForeground(Color.white);
		settingsT.setBounds(17, 512, 60, 50);
		
		add(migrate);
		add(migrateT);
		add(add);
		add(addT);
		add(view);
		add(viewT);
		add(logs);
		add(logsT);
		add(settings);
		add(settingsT);
		add(label);
		
			
	}
	
	public static void main (String[] args) {
		
		HomeUI h = new HomeUI();
		h.setVisible(true);
	}
	
}
