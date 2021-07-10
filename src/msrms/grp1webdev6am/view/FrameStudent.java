package msrms.grp1webdev6am.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

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
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 30));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Email Address", "Full Name", "Mobile", "City", "Province"
			}
		));
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
		txtProvince.setText("Province");
		txtProvince.setColumns(10);
		txtProvince.setBounds(776, 100, 143, 25);
		panel.add(txtProvince);
		
		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBorder(null);
		btnAdd.setIcon(new ImageIcon("C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\add.png"));
		btnAdd.setBounds(871, 57, 39, 33);
		panel.add(btnAdd);
		
		JButton btnEdit = new JButton("");
		btnEdit.setBackground(Color.WHITE);
		btnEdit.setBorder(null);
		btnEdit.setIcon(new ImageIcon("C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\edit.png"));
		btnEdit.setBounds(67, 51, 45, 39);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("");
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBorder(null);
		btnDelete.setIcon(new ImageIcon("C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\delete.png"));
		btnDelete.setBounds(122, 51, 45, 39);
		panel.add(btnDelete);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBorder(null);
		btnSearch.setIcon(new ImageIcon("C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\search.png"));
		btnSearch.setBounds(177, 51, 45, 39);
		panel.add(btnSearch);
		model=new DefaultTableModel();
		Object [] column = {"ID", "Email Address", "Full Name", "Mobile", "City", "Province"};
		Object [] row = new Object[0];
		model.setColumnIdentifiers(column);
	}

}
