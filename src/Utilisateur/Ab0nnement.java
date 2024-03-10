package Utilisateur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class Ab0nnement extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textId;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_1;
	private JTable table;
	Connection cn=null;
	ResultSet rst =null;
	PreparedStatement pstm =null;
	String id_abonement;
	JComboBox comboBox;
	private JTextField txtDd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ab0nnement frame = new Ab0nnement();
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
	public Ab0nnement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400,740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		cn= connection.connextion();
		
		JLabel lblNewLabel = new JLabel("Numero de mombre");
		lblNewLabel.setBounds(30, 91, 142, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(205, 141, 142, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDateEntree = new JLabel("Nom_Prenom");
		lblDateEntree.setBounds(30, 143, 142, 19);
		contentPane.add(lblDateEntree);
		
		JLabel lblTitreDuLivre = new JLabel("Date de naissance");
		lblTitreDuLivre.setBounds(30, 177, 142, 19);
		contentPane.add(lblTitreDuLivre);
		
		JLabel lblAuteur = new JLabel("Date abonnement");
		lblAuteur.setBounds(30, 211, 142, 19);
		contentPane.add(lblAuteur);
		
		JLabel lblEditeur = new JLabel("Date de renouvellement");
		lblEditeur.setBounds(24, 245, 159, 19);
		contentPane.add(lblEditeur);
		
		textId = new JTextField();
		textId.setEnabled(false);
		textId.setColumns(10);
		textId.setBounds(205, 90, 142, 23);
		contentPane.add(textId);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(205, 175, 142, 23);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(205, 209, 142, 23);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(205, 243, 142, 23);
		contentPane.add(textField_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(403, 155, 922, 307);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int  ling = table.getSelectedRow();
				id_abonement=table.getModel().getValueAt(ling, 0).toString();
				 
			     String sql="select * from abonement where id_abonement ='"+id_abonement+"'";
			     try {
					pstm=cn.prepareStatement(sql);
					rst=pstm.executeQuery();
					if(rst.next()) {
						textField.setText(rst.getString("nom_prenom"));
						textField_2.setText(rst.getString("date_naissence"));
						textField_3.setText(rst.getString("date_abenement"));
						textField_4.setText(rst.getString("date_renouvellement"));
						
						textId.setText(rst.getString("id_abonement"));
					  
						
					}
				} catch (SQLException e) {
			
					e.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom_prenom  =textField.getText().toString();
				String  date_naissence  =textField_2.getText().toString();
				String date_abenement  =textField_3.getText().toString();
				String date_renouvellement=textField_4.getText().toString();
				
				String sql ="insert into abonement(nom_prenom ,date_naissence ,date_abenement,date_renouvellement) values(?,?,?,?) ";
				try {
				
				if( !nom_prenom.equals("")&&  !date_naissence.equals("")&&  !date_abenement.equals("")&&  !date_renouvellement.equals("")) {
					
						pstm=cn.prepareStatement(sql);
					pstm.setString(1, nom_prenom);
					pstm.setString(2, date_naissence);
					pstm.setString(3,date_abenement);
					pstm.setString(4, date_renouvellement);
					
					
					int a = JOptionPane.showConfirmDialog(null, "voulez-vous vriement  ajouter cet element ", "Ajouter abonement ", JOptionPane.YES_NO_OPTION);
					if(a==0) {
					pstm.execute();
					JOptionPane.showMessageDialog(null, "Abonement ajouter ");
					UpdateTable();
					textField.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textId.setText("");
					}
					}else {JOptionPane.showMessageDialog(null, "Remplessez les chemps vide ! "); }
					
				} catch (Exception  e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(268, 303, 110, 33);
		contentPane.add(btnNewButton);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom_prenom  =textField.getText().toString();
				String  date_naissence  =textField_2.getText().toString();
				String date_abenement  =textField_3.getText().toString();
				String date_renouvellement=textField_4.getText().toString();
				String sql ="update abonement  set nom_prenom=? ,date_naissence=? ,date_abenement=?,date_renouvellement=? where id_abonement ='"+ id_abonement +"'";
				try {
					if( !nom_prenom.equals("")&&  !date_naissence.equals("")&&  !date_abenement.equals("")&&  !date_renouvellement.equals("")) {
						
						pstm=cn.prepareStatement(sql);
					pstm.setString(1, nom_prenom);
					pstm.setString(2, date_naissence);
					pstm.setString(3,date_abenement);
					pstm.setString(4, date_renouvellement);
						
						
						int a = JOptionPane.showConfirmDialog(null, "voulez-vous vriement  modifier cet element ", "Modifier  abonement ", JOptionPane.YES_NO_OPTION);
						if(a==0) {
						pstm.execute();
						JOptionPane.showMessageDialog(null, "Abonement Modifier  ");
						UpdateTable();
						textField.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						
						textId.setText("");}
						 
						}else {JOptionPane.showMessageDialog(null, "Remplessez les chemps vide ! "); }
				} catch ( Exception ex) {
					//
					ex.printStackTrace();
				}
			}
		});
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModifier.setBounds(268, 363, 110, 33);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom_prenom  =textField.getText().toString();
				String  date_naissence  =textField_2.getText().toString();
				String date_abenement  =textField_3.getText().toString();
				String date_renouvellement=textField_4.getText().toString();
				String sql ="delete from abonement  where id_abonement ='"+id_abonement+"'";
				try {
					
					if( !nom_prenom.equals("")&&  !date_naissence.equals("")&&  !date_abenement.equals("")&&  !date_renouvellement.equals("")) {
						int a = JOptionPane.showConfirmDialog(null, "voulez-vous vriement suppremer cet element ", "suppremer  abonement ", JOptionPane.YES_NO_OPTION);
					  pstm=cn.prepareStatement(sql);
						
					  if (a==0) {pstm.execute();
					JOptionPane.showMessageDialog(null,"Abonement  supprimer");
					UpdateTable();
					textField.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textId.setText("");}
					}
					else {JOptionPane.showMessageDialog(null, "remplez les chemps vide !");}
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSupprimer.setBounds(268, 418, 110, 33);
		contentPane.add(btnSupprimer);
		
		JLabel lblNewLabel_1 = new JLabel("La liste des livres ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(663, 106, 403, 38);
		contentPane.add(lblNewLabel_1);
		
		JButton btnActualiser = new JButton("Actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTable();
			}
		});
		btnActualiser.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnActualiser.setBounds(1197, 121, 110, 23);
		contentPane.add(btnActualiser);
		
		JButton btnRechercher = new JButton("rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String combo=comboBox.getSelectedItem().toString();
					String recherche = textField_1.getText().toString();
					
					
					
					
					
					
					
					
					
					switch(combo) {
					case "Numero_de_Mombre":
						String sqlf ="select id_abonement ,nom_prenom ,date_naissence ,date_abenement,date_renouvellement   from abonement where id_abonement = '"+recherche+"'";
						try {
							pstm=cn.prepareStatement(sqlf);
							rst=pstm.executeQuery();
							
							table.setModel(DbUtils.resultSetToTableModel(rst));
						} catch (SQLException ex) {
						
							ex.printStackTrace();
						}
						break;
					case "Nom_Prenom":
						String sql ="select id_abonement ,nom_prenom ,date_naissence ,date_abenement,date_renouvellement   from abonement where nom_prenom like '%"+recherche+"%'";
						try {
							pstm=cn.prepareStatement(sql);
							rst=pstm.executeQuery();
							
							table.setModel(DbUtils.resultSetToTableModel(rst));
						} catch (SQLException ex) {
						
							ex.printStackTrace();
						}
						break;
					case "Date_Naissance":
						String sqlbn ="select id_abonement ,nom_prenom ,date_naissence ,date_abenement,date_renouvellement   from abonement where date_naissence = '"+recherche+"'";
						try {
							pstm=cn.prepareStatement(sqlbn);
							rst=pstm.executeQuery();
							
							table.setModel(DbUtils.resultSetToTableModel(rst));
						} catch (SQLException ex) {
						
							ex.printStackTrace();
						}
						break;
						
					case "Date_Abonement":
						String sqll ="select id_abonement ,nom_prenom ,date_naissence ,date_abenement,date_renouvellement   from abonement where date_abenement ='"+recherche+"'";
						try {
							pstm=cn.prepareStatement(sqll);
							rst=pstm.executeQuery();
							
							table.setModel(DbUtils.resultSetToTableModel(rst));
						} catch (SQLException ex) {
						
							ex.printStackTrace();
						}
						break;
					case "Date_Renouvellement":
						String sqllx ="select id_abonement ,nom_prenom ,date_naissence ,date_abenement,date_renouvellement   from abonement where date_renouvellement ='"+recherche+"'";
						try {
							pstm=cn.prepareStatement(sqllx);
							rst=pstm.executeQuery();
							
							table.setModel(DbUtils.resultSetToTableModel(rst));
						} catch (SQLException ex) {
						
							ex.printStackTrace();
						}
						break;
				
				
					}
			}
		});
		btnRechercher.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRechercher.setBounds(232, 618, 127, 33);
		contentPane.add(btnRechercher);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(232, 571, 142, 19);
		contentPane.add(textField_1);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Numero_de_Mombre", "Nom_Prenom", "Date_Naissance", "Date_Abonement", "Date_Renouvellement"}));
		comboBox.setBounds(68, 567, 142, 28);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("rechercher par :");
		lblNewLabel_2.setBounds(104, 543, 154, 19);
		contentPane.add(lblNewLabel_2);
		
		txtDd = new JTextField();
		txtDd.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtDd.setForeground(Color.BLACK);
		txtDd.setEditable(false);
		txtDd.setBounds(1026, 24, 110, 23);
		contentPane.add(txtDd);
		txtDd.setColumns(10);
		txtDd.setText(showDate());
		JLabel lblNewLabel_3 = new JLabel("Date");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(935, 24, 81, 23);
		contentPane.add(lblNewLabel_3);
		
		JButton button = new JButton("Quiter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(1066, 570, 108, 30);
		contentPane.add(button);
		
		JButton button_1 = new JButton("retoure");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menue obj = new Menue();
				dispose();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_1.setBounds(1199, 570, 108, 30);
		contentPane.add(button_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Cloud\\Pictures\\DCIM\\IMG-20220616-WA0047.jpg"));
		label.setBounds(0, 11, 1370, 701);
		contentPane.add(label);
	}
	public void UpdateTable() {
		String sql ="select id_abonement ,nom_prenom ,date_naissence ,date_abenement,date_renouvellement   from abonement";
		try {
			pstm=cn.prepareStatement(sql);
			rst=pstm.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rst));
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	String showDate(){
	    Date d=new Date();
	    SimpleDateFormat sdf=new SimpleDateFormat(" YYYY-MM-dd");
	     return sdf.format(d);
	            
	}
}