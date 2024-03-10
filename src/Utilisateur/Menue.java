package Utilisateur;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Interface.Interface;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Menue extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menue frame = new Menue();
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
	public Menue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setForeground(new Color(0, 100, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Liste de livres");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Cloud\\Pictures\\DCIM\\IMG-20220616-WA0050.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivreVoire obj = new LivreVoire();
				obj.setVisible(true);
				dispose();
				obj.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(36, 61, 273, 146);
		contentPane.add(btnNewButton);
		
		JButton btnAbonnement = new JButton("Abonnement");
		btnAbonnement.setIcon(new ImageIcon("C:\\Users\\Cloud\\Pictures\\DCIM\\IMG-20220616-WA0019.jpg"));
		btnAbonnement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ab0nnement obj = new Ab0nnement();
				obj.setVisible(true);
				dispose();
				obj.setLocationRelativeTo(null);
			}
		});
		btnAbonnement.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAbonnement.setBounds(362, 54, 225, 161);
		contentPane.add(btnAbonnement);
		
		JButton btnPretExterne = new JButton("pret externe");
		btnPretExterne.setIcon(new ImageIcon("C:\\Users\\Cloud\\Pictures\\DCIM\\IMG-20220616-WA0039.jpg"));
		btnPretExterne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PretExterne obj = new PretExterne();
				obj.setVisible(true);
				dispose();
				obj.setLocationRelativeTo(null);
			}
		});
		btnPretExterne.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPretExterne.setBounds(241, 259, 254, 129);
		contentPane.add(btnPretExterne);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interface obj = new Interface();
				obj.setVisible(true);
				dispose();
				obj.setLocationRelativeTo(null);
			}
		});
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQuitter.setBounds(10, 349, 101, 25);
		contentPane.add(btnQuitter);
	}

}
