package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Directore.AutentificationAdmin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import Utilisateur.Autentification;



public class Interface extends JFrame {

	private JPanel contentPane;
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
					Interface frame = new Interface();
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
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000,478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLycee = new JButton("Derector");
		btnLycee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Autentification obj = new Autentification();
				obj.setVisible(true);
				fermer();
				obj.setLocationRelativeTo(null);
				
			}
		});
		btnLycee.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnLycee.setBounds(145, 107, 262, 170);
		contentPane.add(btnLycee);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AutentificationAdmin obj = new AutentificationAdmin();
				obj.setVisible(true);
				fermer();
				obj.setLocationRelativeTo(null);
			}
		});
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnAdmin.setBounds(592, 107, 262, 170);
		contentPane.add(btnAdmin);
	}
}
