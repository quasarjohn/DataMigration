package UI;

import Domain.BatFormat;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class MigrateUI extends JFrame implements ActionListener {

    private JButton close, migrate, add, view, logs, settings, file, migrateButton, undoButton, startMigrate, clearSource, clearTarget, saveAs, newFile;
    private JLabel label, migrateT, addT, viewT, logsT, settingsT, sourceDbLabel, targetDbLabel;
    private JTextArea sourceDb, targetDb;
    private JComboBox source, target;
    private JScrollPane scrollPane, scrollPane_1;

    private int targetIndex = 0;

    public MigrateUI() {

        setSize(1170, 730);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {

        }

        label = new JLabel();
        ImageIcon img = new ImageIcon("C:/Users/Precious Dimagiba/Documents/workspace/DataMigration/Images/migratebg.jpg");
        label.setIcon(img);
        label.setBounds(0, 0, 1366, 730);

        close = new JButton("X");
        close.setBounds(1100, 10, 35, 35);
        close.addActionListener(this);
        getContentPane().add(close);


        //side menu
        migrate = new JButton();
        ImageIcon migrateB = new ImageIcon("C:/Users/Precious Dimagiba/Documents/workspace/DataMigration/Images/migratedb.png");
        migrate.setIcon(migrateB);
        migrate.setOpaque(false);
        migrate.setContentAreaFilled(false);
        migrate.setBorderPainted(false);
        migrate.setBounds(60, 165, 50, 50);
        getContentPane().add(migrate);

        migrateT = new JLabel("Migrate");
        migrateT.setFont(new Font("Verdana", Font.BOLD, 14));
        migrateT.setForeground(Color.BLACK);
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

        scrollPane = new JScrollPane();
        scrollPane.setBounds(340, 230, 300, 350);
        getContentPane().add(scrollPane);

        //end of side menu

        sourceDb = new JTextArea();
        scrollPane.setViewportView(sourceDb);
        sourceDb.setEditable(false);

        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(713, 230, 300, 350);
        getContentPane().add(scrollPane_1);

        targetDb = new JTextArea();
        scrollPane_1.setViewportView(targetDb);
        targetDb.setEditable(false);

        file = new JButton("Open");
        file.setBounds(350, 591, 89, 23);
        file.addActionListener(this);
        getContentPane().add(file);

        migrateButton = new JButton("->");
        migrateButton.setEnabled(false);
        migrateButton.setBounds(645, 347, 65, 50);
        migrateButton.addActionListener(this);
        getContentPane().add(migrateButton);

        undoButton = new JButton("<-");
        undoButton.setEnabled(false);
        undoButton.setBounds(645, 408, 65, 50);
        undoButton.addActionListener(this);
        getContentPane().add(undoButton);

        sourceDbLabel = new JLabel("Source Database");
        sourceDbLabel.setBounds(362, 165, 100, 14);
        getContentPane().add(sourceDbLabel);

        targetDbLabel = new JLabel("Target Database");
        targetDbLabel.setBounds(747, 165, 100, 14);
        getContentPane().add(targetDbLabel);

        saveAs = new JButton("Save as");
        saveAs.setEnabled(false);
        saveAs.setBounds(924, 205, 89, 23);
        saveAs.addActionListener(this);
        getContentPane().add(saveAs);

        startMigrate = new JButton("Start Migrate");
        startMigrate.setEnabled(false);
        startMigrate.setBounds(900, 592, 100, 23);
        startMigrate.addActionListener(this);
        getContentPane().add(startMigrate);

        source = new JComboBox();
        source.setModel(new DefaultComboBoxModel(new String[]{"---SELECT---", "IBM DB2", "MySQL", "Microsoft Access"}));
        source.setBounds(340, 182, 140, 20);
        source.addActionListener(this);
        getContentPane().add(source);

        target = new JComboBox();
        target.setModel(new DefaultComboBoxModel(new String[]{"---SELECT---", "IBM DB2", "MySQL", "Microsoft Access"}));
        target.setEnabled(false);
        target.setBounds(713, 182, 140, 20);
        target.addActionListener(this);
        getContentPane().add(target);

        clearSource = new JButton("Clear");
        clearSource.setBounds(340, 205, 89, 23);
        clearSource.addActionListener(this);
        getContentPane().add(clearSource);

        clearTarget = new JButton("Clear");
        clearTarget.setBounds(713, 205, 89, 23);
        clearTarget.setEnabled(false);
        clearTarget.addActionListener(this);
        getContentPane().add(clearTarget);

        newFile = new JButton("Create file");
        newFile.setBounds(825, 205, 89, 23);
        newFile.setEnabled(false);
        newFile.addActionListener(this);
        getContentPane().add(newFile);

        getContentPane().add(label);

        target.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == target) {
            targetIndex = target.getSelectedIndex();
        }

        if (e.getSource() == close) {
            if (JOptionPane.showConfirmDialog(null, "Confirm Exit?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }

        if (e.getSource() == add) {
            AddUI a = new AddUI();
            a.setVisible(true);
            dispose();
        }

        if (e.getSource() == view) {
            ViewUI v = new ViewUI();
            v.setVisible(true);
            dispose();
        }

        if (e.getSource() == logs) {
            LogsUI l = new LogsUI();
            l.setVisible(true);
            dispose();
        }

        if (e.getSource() == settings) {
            SettingsUI s = new SettingsUI();
            s.setVisible(true);
            dispose();
        }

        if (e.getSource() == source) {


        }

        if (e.getSource() == file) {
            mysqlOpenFile();
        }

        if (e.getSource() == clearSource) {
            JTextArea text = sourceDb;
            text.setText("");

            file.setEnabled(true);
            source.setEnabled(true);
            migrateButton.setEnabled(false);
            target.setEnabled(false);
            undoButton.setEnabled(false);
            startMigrate.setEnabled(false);
            saveAs.setEnabled(false);

        }

        if (e.getSource() == clearTarget) {
            JTextArea text = targetDb;
            text.setText("");

            target.setEnabled(false);
            clearTarget.setEnabled(false);
            migrateButton.setEnabled(false);
            undoButton.setEnabled(false);
            source.setEnabled(true);
            clearSource.setEnabled(true);
            file.setEnabled(true);
        }


        if (e.getSource() == newFile) {

            Runtime runtime = Runtime.getRuntime();
            try {
                Process process = runtime.exec("C://Windows//system32//notepad.exe");
            } catch (IOException e1) {

                e1.printStackTrace();
            }
        }

        if (e.getSource() == migrateButton) {

            mysqltodb2();

            file.setEnabled(false);
            source.setEnabled(false);
            clearSource.setEnabled(false);
            clearTarget.setEnabled(true);
            undoButton.setEnabled(true);
            target.setEnabled(true);
            saveAs.setEnabled(true);
            newFile.setEnabled(true);

        }

        if (e.getSource() == targetDb) {
            saveAs.setEnabled(true);
            migrateButton.setEnabled(true);
        }

        if (e.getSource() == saveAs) {

            try {
                saveAs();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            startMigrate.setEnabled(true);
        }

        if (e.getSource() == undoButton) {
            String text = targetDb.getText();

            targetDb.setText("");
            sourceDb.append(text);


            //buttons
            clearSource.setEnabled(true);
            saveAs.setEnabled(false);
            target.setEnabled(false);
            startMigrate.setEnabled(false);
            clearTarget.setEnabled(false);

        }

        if (e.getSource() == startMigrate) {
            String text = targetDb.getText();


            if (JOptionPane.showConfirmDialog(null, "Start Migration?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {


                try {
                    Runtime runtime = Runtime.getRuntime();

                    String[] args = {"cmd /c start " + workingDirectory + "/" + drivername + ".bat"};
                    Process process = runtime.exec("cmd /c start C:/Users/Berstek/Desktop/db2driver.bat");

                } catch (IOException e1) {

                    e1.printStackTrace();
                }

                System.out.println(text + "Migration Successfully");
                JOptionPane.showMessageDialog(null, "Migration Successfully");
            }
        }
    }


    //db2 open file
    public void db2OpenFile() {

        JFileChooser fileChooser = new JFileChooser("C:\\IBM DB2");

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filename = selectedFile.getAbsolutePath();

            try {
                FileReader reader = new FileReader(filename);
                BufferedReader br = new BufferedReader(reader);

                sourceDb.read(br, null);
                br.close();
                sourceDb.setText(sourceDb.getText());

                target.setEnabled(true);


            } catch (Exception e1) {
                sourceDb.setText("Error");
            }
        }
    }

    //MYSQL open file
    public void mysqlOpenFile() {

        JFileChooser fileChooser = new JFileChooser("C:\\MySQL");

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filename = selectedFile.getAbsolutePath();

            try {
                FileReader reader = new FileReader(filename);
                BufferedReader br = new BufferedReader(reader);

                sourceDb.read(br, null);
                br.close();
                sourceDb.setText(sourceDb.getText());

                target.setEnabled(true);
                migrateButton.setEnabled(true);


            } catch (Exception e1) {
                sourceDb.setText("Error");
            }
        }
    }

    //MSACCESS open file
    public void msaccessOpenFile() {

        JFileChooser fileChooser = new JFileChooser("C:\\Microsoft Access");

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filename = selectedFile.getAbsolutePath();

            try {
                FileReader reader = new FileReader(filename);
                BufferedReader br = new BufferedReader(reader);

                sourceDb.read(br, null);
                br.close();
                sourceDb.setText(sourceDb.getText());

                target.setEnabled(true);
                migrateButton.setEnabled(true);


            } catch (Exception e1) {
                sourceDb.setText("Error");
            }
        }
    }

    //migrating process MYSQL to DB2
    public void mysqltodb2() {

        String text = sourceDb.getText();

        targetDb.append(text.replace("DROP DATABASE IF EXISTS studentdb;", "")
                .replace("USE", "CONNECT TO")
                .replace("LOAD DATA LOCAL INFILE", "IMPORT FROM")
                .replace("INTO TABLE", "OF DEL INSERT INTO")
                .replace(" FIELDS TERMINATED BY ','", "")
                .replace(" ENCLOSED BY '\"'", "")
                .replace(" LINES TERMINATED BY", "")
                .replace("\\", "")
                .replace(" 'n'", ""));

        sourceDb.setText("");

    }

    //migrating process DB2 to MYSQL
    public void db2tomysql() {

        String text = sourceDb.getText();

        targetDb.append(text.replace("CONNECT TO", "USE")
                .replace("IMPORT FROM", "LOAD DATA LOCAL INFILE")
                .replace("OF DEL INSERT INTO", "INTO TABLE")
                .replace("", " FIELDS TERMINATED BY ','")
                .replace("", " ENCLOSED BY '\"'")
                .replace("", " LINES TERMINATED BY"));
    }

    private String workingDirectory = "";
    private String fileName = "";
    private String drivername = "";


    //save as
    public void saveAs() throws IOException {
        String fileExtension;

        switch (targetIndex) {
            case 1:
                fileExtension = ".txt";
                break;
            case 2:
                fileExtension = ".sql";
                break;
            default:
                fileExtension = ".txt";
                break;
        }

        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("All files", fileExtension);

        JFileChooser saveAsFileChooser = new JFileChooser("C:/a");
        saveAsFileChooser.setApproveButtonText("Save");
        saveAsFileChooser.setFileFilter(extensionFilter);

        int actionDialog = saveAsFileChooser.showOpenDialog(this);
        if (actionDialog != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File file = saveAsFileChooser.getSelectedFile();
        if (!file.getName().endsWith(fileExtension)) {
            file = new File(file.getAbsolutePath() + fileExtension);
            workingDirectory = file.getParentFile().getAbsolutePath();
            fileName = file.getName();
        }

        BufferedWriter outFile = null;

        try {
            outFile = new BufferedWriter(new FileWriter(file));

            targetDb.write(outFile);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (outFile != null) {
                try {
                    outFile.close();
                } catch (IOException ex) {

                }
            }
        }


        //eto yung ginagawa ko. bale depende sa selection ng user,
        // magbabago lang yung file extension saka file name ng driver.

        //hindi ko pa natetest kung magrurun sya. Di ko na ininstall yung db2 kasi wala na pala ako space.

        //try mo na lang irun

        //write bat file
        String batContent = "";

        switch (targetIndex) {
            case 1:
                batContent = BatFormat.getDb2();
                drivername = "db2driver";
                break;
            case 2:
                batContent = BatFormat.getMySQL();
                drivername = "mysqldriver";
                break;
            default:
                break;
        }

        FileWriter writer = new FileWriter(workingDirectory + "/" + drivername + ".bat");
        String content;
        content = batContent.replace("workingdirectory", workingDirectory).replace("filename", fileName);
        writer.write(content);
        writer.close();
    }

    public static void main(String[] args) {

        MigrateUI m = new MigrateUI();
        m.setVisible(true);
    }
}
