package Directore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Connection.connection;
import net.proteanit.sql.DbUtils;
import javax.swing.ImageIcon;

public class GestionUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	String usernam = null;
	Connection cn=null;
	ResultSet rst =null;
	PreparedStatement pstm =null;
	private JButton btnSupprimer;
	private JButton btnModifier;
	private JButton btnNewButton_1;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField_2;
	void fermer() {
		dispose();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionUser frame = new GestionUser();
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
	public GestionUser() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1400,740);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(248, 248, 255));
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		cn= connection.connextion();
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String sql="select password from userutilisateur where user=?";
				try {
					pstm=cn.prepareStatement(sql);
					pstm.setString(1, textField.getText().toString());
					rst=pstm.executeQuery();
					if(rst.next()) {
					String passwor = rst.getString("password");
					textField_1.setText(passwor);}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		});
		textField.setBounds(240, 212, 150, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(240, 287, 150, 30);
		contentPane.add(textField_1);
		
		JLabel lblPassword = new JLabel("password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(117, 285, 95, 30);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(117, 212, 95, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql = "INSERT INTO userutilisateur (user,password) values(?,?)";
				try {
					pstm=cn.prepareStatement(sql);	
					pstm.setString(1,textField.getText().toString() );
					pstm.setString(2,textField_1.getText().toString() );
					if(!textField.getText().equals("")&& !textField.getText().equals("")) {
						int a = JOptionPane.showConfirmDialog(null, "voulez-vous vriement  ajouter cet element ", "Ajouter usernam ", JOptionPane.YES_NO_OPTION);
						if(a==0) {
						pstm.execute();
					JOptionPane.showMessageDialog(null, "User  ajouter ");
					textField.setText("");
					textField_1.setText("");
					UpdateTable();}}
					else {
						JOptionPane.showMessageDialog(null, "Remplesez les chemps vide ! ");	
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				 
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(40, 374, 126, 30);
		contentPane.add(btnNewButton);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql ="delete from userutilisateur where user=? and password=?";
				try {
					pstm=cn.prepareStatement(sql);
					pstm.setString(1, textField.getText().toString());
					pstm.setString(2, textField_1.getText().toString());
					if(!textField.getText().equals("") && !textField_1.getText().equals("")) {
						int a = JOptionPane.showConfirmDialog(null, "voulez-vous vriement suppremer cet element ", "suppremer  usernam ", JOptionPane.YES_NO_OPTION);
						
						if (a==0) {
						pstm.execute();
					JOptionPane.showMessageDialog(null,"User supprimer");
					textField.setText("");
					textField_1.setText("");
					UpdateTable();}}
					else {JOptionPane.showMessageDialog(null, "remplez les chemps vide !");}
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
				
			}
		});
		btnSupprimer.setFont(new Font("Arial", Font.BOLD, 15));
		btnSupprimer.setBounds(325, 374, 126, 30);
		contentPane.add(btnSupprimer);
		
		btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql ="update userutilisateur set user=? ,password=? where user='"+usernam +"'";
				try {
					pstm=cn.prepareStatement(sql);
					pstm.setString(1, textField.getText().toString());
					pstm.setString(2, textField_1.getText().toString());
					if(!textField.getText().equals("") && !textField_1.getText().equals("")) {
						int a = JOptionPane.showConfirmDialog(null, "voulez-vous vriement  modifier cet element ", "Modifier  usernam ", JOptionPane.YES_NO_OPTION);
						if(a==0) {
						pstm.execute();
					JOptionPane.showMessageDialog(null, "la modifier ruessit");
					 textField_1.setText("");
					 textField.setText("");
					 UpdateTable();}}
					else {JOptionPane.showMessageDialog(null, "remplez les chemps vide !");}
				} catch (SQLException e1) {
					//
					e1.printStackTrace();
				}
				
			}
		});
		btnModifier.setFont(new Font("Arial", Font.BOLD, 15));
		btnModifier.setBounds(176, 374, 126, 30);
		contentPane.add(btnModifier);
		
		btnNewButton_1 = new JButton("Actualiser");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateTable();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(1130, 194, 105, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("   la leste des username :");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
		lblNewLabel_2.setBounds(580, 194, 230, 32);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		scrollPane.setBounds(512, 235, 802, 360);
		contentPane.add(scrollPane);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int  ling = table_2.getSelectedRow();
				usernam =table_2.getModel().getValueAt(ling, 0).toString();
				String pass=table_2.getModel().getValueAt(ling, 1).toString();
				textField.setText(usernam);
				textField_1.setText(pass);
			}
		});
		scrollPane.setViewportView(table_2);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion des utilisateur ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblNewLabel_1.setBounds(641, 27, 394, 78);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(253, 528, 150, 30);
		contentPane.add(textField_2);
		
		JLabel lblRecherche = new JLabel(" la recherche  par Username  :");
		lblRecherche.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRecherche.setBounds(21, 526, 204, 30);
		contentPane.add(lblRecherche);
		
		JButton btnRechercher = new JButton("Rechercher :");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recherche() ;
			}
		});
		btnRechercher.setFont(new Font("Arial", Font.BOLD, 15));
		btnRechercher.setBounds(176, 592, 126, 30);
		contentPane.add(btnRechercher);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Cloud\\Pictures\\DCIM\\IMG-20220616-WA0047.jpg"));
		label.setBounds(10, 0, 1370, 701);
		contentPane.add(label);
		
	
		
	}
	public void UpdateTable() {
		String sql ="select user as Username ,password as Password from userutilisateur";
		try {
			pstm=cn.prepareStatement(sql);
			rst=pstm.executeQuery();
			table_2.setModel(DbUtils.resultSetToTableModel(rst));
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	public void Recherche() {
		String usern= textField_2.getText().toString();
		String sql ="select user as Username ,password as Password from userutilisateur where user like '%"+usern+"%'";
		try {
			pstm=cn.prepareStatement(sql);
			rst=pstm.executeQuery();
			
			table_2.setModel(DbUtils.resultSetToTableModel(rst));
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
}
