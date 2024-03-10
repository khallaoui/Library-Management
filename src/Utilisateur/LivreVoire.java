package Utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connection.connection;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class LivreVoire extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Connection cn=null;
	ResultSet rst =null;
	PreparedStatement pstm =null;
	private JTable table;
	JComboBox comboBox;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LivreVoire frame = new LivreVoire();
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
	public LivreVoire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400,740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		cn= connection.connextion();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 274, 1096, 342);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Actualiser");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateTable();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(235, 233, 108, 30);
		contentPane.add(btnNewButton);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModifier.setBounds(30, 45, 108, 30);
		contentPane.add(btnModifier);
		
		JLabel lblNewLabel = new JLabel("La leste des livres ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(402, 48, 396, 45);
		contentPane.add(lblNewLabel);
		
		JButton btnRecherche = new JButton("Recherche");
		btnRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String combo=comboBox.getSelectedItem().toString();
				String recherche = textField.getText().toString();
				
				
				
				
				
				switch(combo) {
				case "Titre_de_livre":
					String sqlf ="select id_livre ,date_entree, titre,auteur ,editeur ,lieu ,annee_publication,parties ,copie ,edition ,source ,num_etage  from livre where titre = '"+recherche+"'";
					try {
						pstm=cn.prepareStatement(sqlf);
						rst=pstm.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rst));
					} catch (SQLException ex) {
					
						ex.printStackTrace();
					}
					break;
				case "Auteur":
					String sql ="select id_livre ,date_entree, titre,auteur ,editeur ,lieu ,annee_publication,parties ,copie ,edition ,source ,num_etage  from livre where auteur = '"+recherche+"'";
					try {
						pstm=cn.prepareStatement(sql);
						rst=pstm.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rst));
					} catch (SQLException ex) {
					
						ex.printStackTrace();
					}
					break;
				case "Date_entree":
					String sqlbn ="select id_livre ,date_entree, titre,auteur ,editeur ,lieu ,annee_publication,parties ,copie ,edition ,source ,num_etage  from livre where date_entree = '"+recherche+"'";
					try {
						pstm=cn.prepareStatement(sqlbn);
						rst=pstm.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rst));
					} catch (SQLException ex) {
					
						ex.printStackTrace();
					}
					break;
					
				case "Num_etage":
					String sqll ="select id_livre ,date_entree, titre,auteur ,editeur ,lieu ,annee_publication,parties ,copie ,edition ,source ,num_etage  from livre where num_etage ='"+recherche+"'";
					try {
						pstm=cn.prepareStatement(sqll);
						rst=pstm.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rst));
					} catch (SQLException ex) {
					
						ex.printStackTrace();
					}
					break;
				case "Num_Inscreption":
					String sqllx ="select id_livre ,date_entree, titre,auteur ,editeur ,lieu ,annee_publication,parties ,copie ,edition ,source ,num_etage  from livre where id_livre ='"+recherche+"'";
					try {
						pstm=cn.prepareStatement(sqllx);
						rst=pstm.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rst));
					} catch (SQLException ex) {
					
						ex.printStackTrace();
					}
					break;}
			}
		});
		btnRecherche.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRecherche.setBounds(1232, 274, 108, 30);
		contentPane.add(btnRecherche);
		
		 comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Titre_de_livre", "Auteur", "Date_entree", "Num_etage", "Num_Inscreption"}));
		comboBox.setBounds(1044, 218, 153, 29);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(1217, 211, 130, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblRechercherPar = new JLabel("Rechercher par :");
		lblRechercherPar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRechercherPar.setBounds(1044, 150, 396, 45);
		contentPane.add(lblRechercherPar);
		
		JLabel label = new JLabel("Date");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(1125, 48, 81, 23);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setText((String) null);
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(1217, 51, 110, 23);
		contentPane.add(textField_1);
		textField_1.setText(showDate());
		
		JButton btnQuiter = new JButton("Quiter");
		btnQuiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnQuiter.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQuiter.setBounds(300, 627, 108, 30);
		contentPane.add(btnQuiter);
		
		JButton btnRetoure = new JButton("retoure");
		btnRetoure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menue obj = new Menue();
				dispose();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
			}
		});
		btnRetoure.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRetoure.setBounds(437, 627, 108, 30);
		contentPane.add(btnRetoure);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Cloud\\Pictures\\DCIM\\IMG-20220616-WA0051.jpg"));
		label_1.setBounds(0, 0, 1370, 701);
		contentPane.add(label_1);
	}
	public void UpdateTable() {
		String sql ="select id_livre ,date_entree, titre,auteur ,editeur ,lieu ,annee_publication,parties ,copie ,edition ,source ,num_etage  from livre";
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
