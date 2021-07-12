package msrms.grp1webdev6am.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import msrms.grp1webdev6am.controller.LoginDAO;
import msrms.grp1webdev6am.controller.StudentAddDao;
import msrms.grp1webdev6am.controller.StudentDeleteBenarDao;
import msrms.grp1webdev6am.controller.StudentEditBenarDao;
import msrms.grp1webdev6am.controller.StudentGetAllBEnarDao;
import msrms.grp1webdev6am.controller.StudentSearchBenarDao;
import msrms.grp1webdev6am.model.LoginModel;
import msrms.grp1webdev6am.model.StudentAddModel;
import msrms.grp1webdev6am.model.StudentModel;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.sql.SQLException;
import java.util.List;

public class FrameStudent extends JFrame {

	private JPanel contentPane;
	DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtID;
	private JTextField txtEmailAddress;
	private JTextField txtFullname;
	private JTextField txtMobile;
	private JTextField txtCity;
	private JTextField txtProvince;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameStudent frame = new FrameStudent();
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
	public FrameStudent() {
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 986, 663);
		contentPane.add(panel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 135, 857, 474);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Email Address", "Full Name", "Mobile", "City", "Province"
			}
		));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
           public void mouseClicked(java.awt.event.MouseEvent evt) {
               jTable_Display_UsersMouseClicked(evt);
           }
        });

		scrollPane.setViewportView(table);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(67, 100, 143, 25);
		panel.add(txtID);
		
		txtEmailAddress = new JTextField();
		txtEmailAddress.setColumns(10);
		txtEmailAddress.setBounds(209, 100, 143, 25);
		panel.add(txtEmailAddress);
		
		txtFullname = new JTextField();
		txtFullname.setColumns(10);
		txtFullname.setBounds(352, 100, 143, 25);
		panel.add(txtFullname);
		
		txtMobile = new JTextField();
		txtMobile.setColumns(10);
		txtMobile.setBounds(494, 100, 143, 25);
		panel.add(txtMobile);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(635, 100, 143, 25);
		panel.add(txtCity);
		
		txtProvince = new JTextField();
		txtProvince.setColumns(10);
		txtProvince.setBounds(776, 100, 143, 25);
		panel.add(txtProvince);
		
		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String emailAddress = txtEmailAddress.getText();
					String fullname = txtFullname.getText();
					String mobile = txtMobile.getText();
					String city = txtCity.getText();
					String province = txtProvince.getText();

					StudentModel newStudent = new StudentModel(emailAddress, fullname, mobile, city, province);
					System.out.println(newStudent.getEmailAddress());
					System.out.println(newStudent.getFullname());
					System.out.println(newStudent.getMobile());
					System.out.println(newStudent.getCity());
					System.out.println(newStudent.getProvince());
					
					StudentAddDao insertStudentDao = new StudentAddDao();
					insertStudentDao.insertStudent(newStudent);
					showAllStudents();
										
				}catch(SQLException e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Failed Adding the Student");
				}
			}
		});
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBorder(null);
		btnAdd.setIcon(new ImageIcon("C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\add.png"));
		btnAdd.setBounds(871, 57, 39, 33);
		panel.add(btnAdd);
		
		JButton btnEdit = new JButton("");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int editID = Integer.parseInt(txtID.getText());
					System.out.println("Not Empty ID");
					StudentModel editStudent = new StudentModel(editID, txtFullname.getText(), txtMobile.getText(), txtCity.getText(), txtProvince.getText());
					StudentEditBenarDao studentEditBenarDao = new StudentEditBenarDao();
					studentEditBenarDao.updateStudent(editStudent);
					
				}catch(Exception ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Empty ID");
				}
				if(Integer.parseInt(txtID.getText()) >= 0) {
					System.out.println("Empty ID");
				}else {
					System.out.println("Empty Not Empty");
				}
			}
		});
		btnEdit.setBackground(Color.WHITE);
		btnEdit.setBorder(null);
		btnEdit.setIcon(new ImageIcon("C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\edit.png"));
		btnEdit.setBounds(67, 51, 45, 39);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int deleteID = Integer.parseInt(txtID.getText());
					System.out.println("Not Empty ID");
					StudentModel editStudent = new StudentModel(deleteID);
					StudentDeleteBenarDao studentEditBenarDao = new StudentDeleteBenarDao();
					studentEditBenarDao.deleteStudent(deleteID);
					
				}catch(Exception ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Empty ID");
				}
				if(Integer.parseInt(txtID.getText()) >= 0) {
					System.out.println("Empty ID");
				}else {
					System.out.println("Empty Not Empty");
				}
			}
		});
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBorder(null);
		btnDelete.setIcon(new ImageIcon("C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\delete.png"));
		btnDelete.setBounds(122, 51, 45, 39);
		panel.add(btnDelete);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String emailAddress = txtEmailAddress.getText();
					String fullname = txtFullname.getText();
					String mobile = txtMobile.getText();
					String city = txtCity.getText();
					String province = txtProvince.getText();

					StudentModel searchStudent = new StudentModel(emailAddress, fullname, mobile, city, province);
					System.out.println("fr"+searchStudent.getEmailAddress());
					System.out.println(searchStudent.getFullname());
					System.out.println(searchStudent.getMobile());
					System.out.println(searchStudent.getCity());
					System.out.println(searchStudent.getProvince());
					
					showSearchStudents(searchStudent);

										
				}catch(Exception e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Failed Searching the Student (fc)");
				}
			}
		});
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBorder(null);
		btnSearch.setIcon(new ImageIcon("C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\search.png"));
		btnSearch.setBounds(177, 51, 45, 39);
		panel.add(btnSearch);
//		model=new DefaultTableModel();
//		Object [] column = {"ID", "Email Address", "Full Name", "Mobile", "City", "Province"};
//		Object [] row = new Object[0];
//		model.setColumnIdentifiers(column);
		showAllStudents();
	}
	public void showSearchStudents(StudentModel studentSearchBenarDao){
		   
		   StudentSearchBenarDao getSearchBenarDao = new StudentSearchBenarDao();
	       List<StudentModel> list = getSearchBenarDao.getSearchStudents(studentSearchBenarDao);
	       DefaultTableModel model = (DefaultTableModel)table.getModel();
	       model.setRowCount(0);
	       Object[] row = new Object[6];
	       for(int i = 0; i < list.size(); i++)
	       {
	           row[0] = list.get(i).getId();
	           row[1] = list.get(i).getEmailAddress();
	           row[2] = list.get(i).getFullname();
	           row[3] = list.get(i).getMobile();
	           row[4] = list.get(i).getCity();
	           row[5] = list.get(i).getProvince();
	           
	           model.addRow(row);
	           System.out.println("fr"+i);	       }
	    }
	public void showAllStudents(){
	   
		   StudentGetAllBEnarDao getAllBenarDao = new StudentGetAllBEnarDao();
	       List<StudentModel> list = getAllBenarDao.getAllStudents();
	       DefaultTableModel model = (DefaultTableModel)table.getModel();
	       model.setRowCount(0);
	       Object[] row = new Object[6];
	       for(int i = 0; i < list.size(); i++)
	       {
	           row[0] = list.get(i).getId();
	           row[1] = list.get(i).getEmailAddress();
	           row[2] = list.get(i).getFullname();
	           row[3] = list.get(i).getMobile();
	           row[4] = list.get(i).getCity();
	           row[5] = list.get(i).getProvince();
	           
	           model.addRow(row);
	       }
	    }
	   private void jTable_Display_UsersMouseClicked(java.awt.event.MouseEvent evt) {                                                  
	       // Get The Index Of The Slected Row 
	        int i = table.getSelectedRow();
	        System.out.println("table clicked");

	        TableModel model = table.getModel();
	        
	         // Display Slected Row In JTexteFields
	        txtID.setText(model.getValueAt(i,0).toString());
	        txtEmailAddress.setText(model.getValueAt(i,1).toString());
	        txtFullname.setText(model.getValueAt(i,2).toString());
	        txtMobile.setText(model.getValueAt(i,3).toString());
	        txtCity.setText(model.getValueAt(i,4).toString());
	        txtProvince.setText(model.getValueAt(i,5).toString());
	    }

}
