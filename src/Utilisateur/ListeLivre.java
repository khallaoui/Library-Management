package Utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JMonthChooser;

import Connection.connection;
import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class ListeLivre extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textId;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_1;
	private JTable table;
	Connection cn=null;
	ResultSet rst =null;
	PreparedStatement pstm =null;
	String id_livre;
	JComboBox comboBox;
	private JTextField txtDd;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeLivre frame = new ListeLivre();
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
	public ListeLivre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400,740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		cn= connection.connextion();
		
		JLabel lblNewLabel = new JLabel("Numero Inscreption");
		lblNewLabel.setBounds(30, 72, 110, 19);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(150, 105, 142, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDateEntree = new JLabel("Date entree");
		lblDateEntree.setBounds(30, 106, 110, 19);
		contentPane.add(lblDateEntree);
		
		JLabel lblTitreDuLivre = new JLabel("Titre du livre");
		lblTitreDuLivre.setBounds(30, 142, 110, 19);
		contentPane.add(lblTitreDuLivre);
		
		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setBounds(30, 172, 110, 19);
		contentPane.add(lblAuteur);
		
		JLabel lblLieu = new JLabel("Lieu");
		lblLieu.setBounds(30, 249, 110, 19);
		contentPane.add(lblLieu);
		
		JLabel lblAnneeDePublication = new JLabel("Annee de publication");
		lblAnneeDePublication.setBounds(30, 290, 110, 19);
		contentPane.add(lblAnneeDePublication);
		
		JLabel lblParties = new JLabel("Parties");
		lblParties.setBounds(30, 331, 110, 19);
		contentPane.add(lblParties);
		
		JLabel lblCopie = new JLabel("Copie");
		lblCopie.setBounds(30, 361, 110, 19);
		contentPane.add(lblCopie);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setBounds(30, 395, 110, 19);
		contentPane.add(lblEdition);
		
		JLabel lblS = new JLabel("Source");
		lblS.setBounds(30, 438, 110, 19);
		contentPane.add(lblS);
		
		JLabel lblEditeur = new JLabel("Editeur");
		lblEditeur.setBounds(30, 209, 110, 19);
		contentPane.add(lblEditeur);
		
		JLabel lblNumeroEtager = new JLabel("Numero etager");
		lblNumeroEtager.setBounds(30, 473, 110, 19);
		contentPane.add(lblNumeroEtager);
		
		textId = new JTextField();
		textId.setEnabled(false);
		textId.setColumns(10);
		textId.setBounds(150, 71, 142, 19);
		contentPane.add(textId);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(151, 141, 142, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(151, 171, 142, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(151, 208, 142, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(151, 248, 142, 19);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(151, 289, 142, 19);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(151, 330, 142, 19);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(151, 360, 142, 19);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(151, 394, 142, 19);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(151, 437, 142, 19);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(151, 472, 142, 19);
		contentPane.add(textField_11);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(323, 155, 1002, 307);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int  ling = table.getSelectedRow();
			      id_livre=table.getModel().getValueAt(ling, 0).toString();
			     String sql="select * from livre where id_livre ='"+id_livre+"'";
			     try {
					pstm=cn.prepareStatement(sql);
					rst=pstm.executeQuery();
					if(rst.next()) {
						textField.setText(rst.getString("date_entree"));
						textField_2.setText(rst.getString("titre"));
						textField_3.setText(rst.getString("auteur"));
						textField_4.setText(rst.getString("editeur"));
						textField_5.setText(rst.getString("lieu"));
						textField_6.setText(rst.getString("annee_publication"));
						textField_7.setText(rst.getString("parties"));
						textField_8.setText(rst.getString("copie"));
						textField_9.setText(rst.getString("edition"));
						textField_10.setText(rst.getString("source"));
					    textField_11.setText(rst.getString("num_etage"));
						textId.setText(rst.getString("id_livre"));
					  
						
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
				String date_entree =textField.getText().toString();
				String titre =textField_2.getText().toString();
				String auteur  =textField_3.getText().toString();
				String editeur =textField_4.getText().toString();
				String lieu =textField_5.getText().toString();
				String annee_publication=textField_6.getText().toString();
				String parties =textField_7.getText().toString();
				String copie=textField_8.getText().toString();
				String edition=textField_9.getText().toString();
				String source=textField_10.getText().toString();
				String num_etage=textField_11.getText().toString();
				String sql ="insert into livre(date_entree, titre,auteur ,editeur ,lieu ,annee_publication,parties ,copie ,edition ,source ,num_etage) values(?,?,?,?,?,?,?,?,?,?,?) ";
				try {
				
				if( !date_entree.equals("")&&  !titre.equals("")&&  !auteur.equals("")&&  !editeur.equals("")&& 
							!lieu.equals("")&&  !annee_publication.equals("")&&  !parties.equals("")&& 
							!copie.equals("")&&  !edition.equals("")&&  !source.equals("") &&  !num_etage.equals("")) {
					
						pstm=cn.prepareStatement(sql);
					pstm.setString(1, date_entree);
					pstm.setString(2, titre);
					pstm.setString(3,auteur);
					pstm.setString(4, editeur);
					pstm.setString(5, lieu);
					pstm.setString(6, annee_publication);
					pstm.setString(7,parties );
					pstm.setString(8, copie);
					pstm.setString(9, edition);
					pstm.setString(10, source);
					pstm.setString(11, num_etage);
					
					int a = JOptionPane.showConfirmDialog(null, "voulez-vous vriement  ajouter cet element ", "Ajouter livre ", JOptionPane.YES_NO_OPTION);
					if(a==0) {
					pstm.execute();
					JOptionPane.showMessageDialog(null, "Livre ajouter ");
					UpdateTable();
					textField.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					textField_8.setText("");
					textField_9.setText("");
					textField_10.setText("");
					textField_11.setText("");
					textId.setText("");
					}
					}else {JOptionPane.showMessageDialog(null, "Remplessez les chemps vide ! "); }
					
				} catch (Exception  e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(606, 485, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date_entree =textField.getText().toString();
				String titre =textField_2.getText().toString();
				String auteur  =textField_3.getText().toString();
				String editeur =textField_4.getText().toString();
				String lieu =textField_5.getText().toString();
				String annee_publication=textField_6.getText().toString();
				String parties =textField_7.getText().toString();
				String copie=textField_8.getText().toString();
				String edition=textField_9.getText().toString();
				String source=textField_10.getText().toString();
				String num_etage=textField_11.getText().toString();
				String sql ="update livre  set date_entree=?, titre=?,auteur=? ,editeur=? ,lieu=? ,annee_publication=?,parties=?,copie=? ,edition=? ,source=? ,num_etage=? where id_livre ='"+ id_livre +"'";
				try {
					if( !date_entree.equals("")&&  !titre.equals("")&&  !auteur.equals("")&&  !editeur.equals("")&& 
							!lieu.equals("")&&  !annee_publication.equals("")&&  !parties.equals("")&& 
							!copie.equals("")&&  !edition.equals("")&&  !source.equals("") &&  !num_etage.equals("")) {
						pstm=cn.prepareStatement(sql);
						pstm.setString(1, date_entree);
						pstm.setString(2, titre);
						pstm.setString(3,auteur);
						pstm.setString(4, editeur);
						pstm.setString(5, lieu);
						pstm.setString(6, annee_publication);
						pstm.setString(7,parties );
						pstm.setString(8, copie);
						pstm.setString(9, edition);
						pstm.setString(10, source);
						pstm.setString(11, num_etage);
						
						
						int a = JOptionPane.showConfirmDialog(null, "voulez-vous vriement  modifier cet element ", "Modifier  livre ", JOptionPane.YES_NO_OPTION);
						if(a==0) {
						pstm.execute();
						JOptionPane.showMessageDialog(null, "Livre Modifier  ");
						UpdateTable();
						textField.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
						textField_5.setText("");
						textField_6.setText("");
						textField_7.setText("");
						textField_8.setText("");
						textField_9.setText("");
						textField_10.setText("");
						textField_11.setText("");
						textId.setText("");}
						 
						}else {JOptionPane.showMessageDialog(null, "Remplessez les chemps vide ! "); }
				} catch ( Exception ex) {
					//
					ex.printStackTrace();
				}
			}
		});
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnModifier.setBounds(736, 485, 89, 23);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date_entree =textField.getText().toString();
				String titre =textField_2.getText().toString();
				String auteur  =textField_3.getText().toString();
				String editeur =textField_4.getText().toString();
				String lieu =textField_5.getText().toString();
				String annee_publication=textField_6.getText().toString();
				String parties =textField_7.getText().toString();
				String copie=textField_8.getText().toString();
				String edition=textField_9.getText().toString();
				String source=textField_10.getText().toString();
				String num_etage=textField_11.getText().toString();
				String sql ="delete from livre  where id_livre ='"+id_livre+"'";
				try {
					
					if( !date_entree.equals("")&&  !titre.equals("")&&  !auteur.equals("")&&  !editeur.equals("")&& 
							!lieu.equals("")&&  !annee_publication.equals("")&&  !parties.equals("")&& 
							!copie.equals("")&&  !edition.equals("")&&  !source.equals("") &&  !num_etage.equals("")) {
						int a = JOptionPane.showConfirmDialog(null, "voulez-vous vriement suppremer cet element ", "suppremer  livre ", JOptionPane.YES_NO_OPTION);
					  pstm=cn.prepareStatement(sql);
						
					  if (a==0) {pstm.execute();
					JOptionPane.showMessageDialog(null,"Livre  supprimer");
					UpdateTable();
					textField.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					textField_8.setText("");
					textField_9.setText("");
					textField_10.setText("");
					textField_11.setText("");
					textId.setText("");}
					}
					else {JOptionPane.showMessageDialog(null, "remplez les chemps vide !");}
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSupprimer.setBounds(871, 486, 110, 23);
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Titre_de_livre", "Auteur", "Date_entree", "Num_etage", "Num_Inscreption"}));
		comboBox.setBounds(75, 572, 127, 19);
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
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Cloud\\Pictures\\DCIM\\IMG-20220616-WA0047.jpg"));
		lblNewLabel_4.setBounds(0, 0, 1370, 701);
		contentPane.add(lblNewLabel_4);
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
