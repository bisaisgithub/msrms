package msrms.grp1webdev6am.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class FrameClassRyn extends JFrame {

	private JPanel contentPane;
	DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtID_class;
	private JTextField txtEmailAddress_class;
	private JTextField txtFullname_class;
	private JTextField txtClassName;
	private JTextField txtInstructor;
	private JTextField txtStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameClassRyn frame = new FrameClassRyn();
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
	public FrameClassRyn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 986, 663);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel banner = new JPanel();
		banner.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.GRAY));
		banner.setBackground(Color.WHITE);
		banner.setBounds(0, 0, 986, 111);
		panel.add(banner);
		banner.setLayout(null);
		
		JLabel mtdiLogo = new JLabel("");
		mtdiLogo.setBounds(48, 28, 124, 61);
		String path = "C:\\\\Users\\\\mar\\\\eclipse-proj1\\\\msrms\\\\src\\\\img\\MTDI.png";
		banner.add(mtdiLogo);
		ImageIcon MyImage = new ImageIcon(path);
		Image logo = MyImage.getImage();
		Image newLogo = logo.getScaledInstance(mtdiLogo.getWidth(), mtdiLogo.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newLogo);
		mtdiLogo.setIcon(image);
		
		JButton studentBtn = new JButton("Student");
		studentBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		studentBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		studentBtn.setBounds(397, 32, 104, 22);
		studentBtn.setOpaque(false);
		studentBtn.setContentAreaFilled(false);
		banner.add(studentBtn);
		
		JButton classBtn = new JButton("Class");
		classBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		classBtn.setBorder(new MatteBorder(0, 0, 3, 0, (Color) SystemColor.textHighlight));
		classBtn.setForeground(SystemColor.textHighlight);
		classBtn.setBounds(526, 31, 71, 20);
		classBtn.setOpaque(false);
		classBtn.setContentAreaFilled(false);
		banner.add(classBtn);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(72, 280, 857, 383);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setForeground(SystemColor.textHighlight);
		table.setOpaque(false);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setGridColor(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Email Address", "Full Name", "Class Name", "Instructor", "Status"
			}
		));
		scrollPane.setViewportView(table);
		JTableHeader THeader = table.getTableHeader();
		THeader.setBackground(new Color(0,0,0,50));	
		THeader.setOpaque(false);
		table.setDefaultRenderer(Object.class, new TableCellRenderer(){
            private DefaultTableCellRenderer DEFAULT_RENDERER =  new DefaultTableCellRenderer();
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row%2 == 0){
                    c.setBackground(Color.WHITE);
                }
                else {
                    c.setBackground(new Color(230,230,230,230));
                }                        
                return c;
            }

        });
		
		table.setRowHeight(30);	
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		
		txtID_class = new JTextField();
		txtID_class.addFocusListener(new FocusAdapter() {
			
			public void focusGained(FocusEvent e) {
				if(txtID_class.getText().equals("ID")) 
				{
					txtID_class.setText("");
					txtID_class.setForeground(Color.BLACK);				
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(txtID_class.getText().equals("")) 
				{
					txtID_class.setText("ID");
					txtID_class.setForeground(new Color(153,153,153,153));				
				}				
			}
		});
		txtID_class.setForeground(Color.LIGHT_GRAY);
		txtID_class.setText("ID");
		txtID_class.setColumns(10);
		txtID_class.setBounds(94, 245, 84, 25);
		panel.add(txtID_class);
		
		txtEmailAddress_class = new JTextField();
		txtEmailAddress_class.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(txtEmailAddress_class.getText().equals("email@email.com")) 
				{
					txtEmailAddress_class.setText("");
					txtEmailAddress_class.setForeground(Color.BLACK);				
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(txtEmailAddress_class.getText().equals("")) 
				{
					txtEmailAddress_class.setText("email@email.com");
					txtEmailAddress_class.setForeground(new Color(153,153,153,153));				
				}
			}
		});
		txtEmailAddress_class.setText("email@email.com");
		txtEmailAddress_class.setForeground(Color.LIGHT_GRAY);
		txtEmailAddress_class.setColumns(10);
		txtEmailAddress_class.setBounds(188, 245, 152, 25);
		panel.add(txtEmailAddress_class);
		
		txtFullname_class = new JTextField();
		txtFullname_class.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e)
			{
				if(txtFullname_class.getText().equals("Name")) 
				{
					txtFullname_class.setText("");
					txtFullname_class.setForeground(Color.BLACK);				
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(txtFullname_class.getText().equals("")) 
				{
					txtFullname_class.setText("Name");
					txtFullname_class.setForeground(new Color(153,153,153,153));				
				}
			}
		});
		txtFullname_class.setForeground(Color.LIGHT_GRAY);
		txtFullname_class.setText("Name");
		txtFullname_class.setColumns(10);
		txtFullname_class.setBounds(350, 245, 143, 25);
		panel.add(txtFullname_class);
		
		txtClassName = new JTextField();
		txtClassName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(txtClassName.getText().equals("Class Name")) 
				{
					txtClassName.setText("");
					txtClassName.setForeground(Color.BLACK);				
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(txtClassName.getText().equals("")) 
				{
					txtClassName.setText("Class Name");
					txtClassName.setForeground(new Color(153,153,153,153));				
				}
			}
		});
		txtClassName.setForeground(Color.LIGHT_GRAY);
		txtClassName.setText("Class Name");
		txtClassName.setColumns(10);
		txtClassName.setBounds(503, 245, 143, 25);
		panel.add(txtClassName);
		
		txtInstructor = new JTextField();
		txtInstructor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(txtInstructor.getText().equals("Instructor")) 
				{
					txtInstructor.setText("");
					txtInstructor.setForeground(Color.BLACK);				
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(txtInstructor.getText().equals("")) 
				{
					txtInstructor.setText("Instructor");
					txtInstructor.setForeground(Color.BLACK);				
				}
			}
		});
		txtInstructor.setForeground(Color.LIGHT_GRAY);
		txtInstructor.setText("Instructor");
		txtInstructor.setColumns(10);
		txtInstructor.setBounds(656, 245, 143, 25);
		panel.add(txtInstructor);
		
		txtStatus = new JTextField();
		txtStatus.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(txtStatus.getText().equals("Status")) 
				{
					txtStatus.setText("");
					txtStatus.setForeground(Color.BLACK);				
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(txtStatus.getText().equals("")) 
				{
					txtStatus.setText("Status");
					txtStatus.setForeground(new Color(153,153,153,153));				
				}
			}
		});
		txtStatus.setBounds(728, 197, 86, 20);
		txtStatus.setForeground(Color.LIGHT_GRAY);
		txtStatus.setText("Status");
		txtStatus.setColumns(10);
		txtStatus.setBounds(809, 245, 95, 25);
		panel.add(txtStatus);
		
		
		JButton btnAdd = new JButton("");
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBorder(null);
		path="C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\add.png";
		btnAdd.setBounds(865, 186, 25, 25);
		panel.add(btnAdd);
		ImageIcon MyAdd = new ImageIcon(path);
		Image add = MyAdd.getImage();
		Image newAdd = add.getScaledInstance(btnAdd.getWidth(), btnAdd.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon addImage = new ImageIcon(newAdd);
		btnAdd.setIcon(addImage);
		
		//reset button	
		JButton btnReset = new JButton("");
		btnReset.setBorder(null);
		btnReset.setBackground(Color.WHITE);
		path="C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\risit.png";
		btnReset.setBounds(902, 184, 27, 27);
		panel.add(btnReset);
		ImageIcon myReset = new ImageIcon(path);
		Image reset = myReset.getImage();
		Image newReset = reset.getScaledInstance(btnReset.getWidth(), btnReset.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon resetImage = new ImageIcon(newReset);
		btnReset.setIcon(resetImage);

		JButton btnEdit = new JButton("");
		btnEdit.setBackground(Color.WHITE);
		btnEdit.setBorder(null);
		path = "C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\edit.png";
		btnEdit.setBounds(72, 186, 25, 25);
		panel.add(btnEdit);
		ImageIcon MyEdit = new ImageIcon(path);
		Image edit = MyEdit.getImage();
		Image newEdit = edit.getScaledInstance(btnEdit.getWidth(), btnEdit.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon editImage = new ImageIcon(newEdit);
		btnEdit.setIcon(editImage);
		
		JButton btnDelete = new JButton("");
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBorder(null);
		path="C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\delete.png";
		btnDelete.setBounds(102, 186, 20, 25);
		panel.add(btnDelete);
		ImageIcon myDel = new ImageIcon(path);
		Image del = myDel.getImage();
		Image newDel = del.getScaledInstance(btnDelete.getWidth(), btnDelete.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon delImage = new ImageIcon(newDel);
		btnDelete.setIcon(delImage);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBorder(null);
		path = "C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\search.png";
		btnSearch.setBounds(132, 186, 20, 25);
		panel.add(btnSearch);
		ImageIcon mySearch = new ImageIcon(path);
		Image search = mySearch.getImage();
		Image newSearch = search.getScaledInstance(btnSearch.getWidth(), btnSearch.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon searchImage = new ImageIcon(newSearch);
		btnSearch.setIcon(searchImage);
		model=new DefaultTableModel();
		Object [] column = {"ID", "Email Address", "Full Name", "Class Name", "Instructor", "Status"};
		Object [] row = new Object[0];
		model.setColumnIdentifiers(column);
		
		JLabel classLabel = new JLabel("Class List");
		classLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		classLabel.setForeground(SystemColor.textHighlight);
		classLabel.setBounds(72, 143, 130, 14);
		panel.add(classLabel);
		
		JLabel greetLabel = new JLabel("Welcome back,");
		greetLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		greetLabel.setBounds(799, 143, 84, 14);
		panel.add(greetLabel);
		
		JLabel adminName = new JLabel("Admin");
		adminName.setForeground(new Color(255, 0, 51));
		adminName.setFont(new Font("SansSerif", Font.PLAIN, 12));
		adminName.setBounds(885, 143, 84, 14);
		panel.add(adminName);
	
	}
}
