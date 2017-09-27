package accesso;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.Controlli;
import menu.GraficaMenu;
import support.DBManager;

/**
 * The Class GraficaLogin.
 */
public class GraficaLogin extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The content pane. */
	private JPanel contentPane;

	/** The text field. */
	private JTextField textField;

	/** The password field. */
	private JPasswordField passwordField;

	/** The action. */
	private final Action action = new SwingAction();

	/** The frame. */
	static GraficaLogin frame = new GraficaLogin();

	//public static SwingAction INSTANCE = SwingAction.
	
	/**
	 * Launch the application.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GraficaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int[] varB = { 100, 100, 450, 300 };
		setBounds(varB[0], varB[1], varB[2], varB[3]);
		contentPane = new JPanel();
		int[] varA = { 5, 5, 5, 5 };
		contentPane.setBorder(new EmptyBorder(varA[0], varA[1], varA[2], varA[3]));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		int plain = 20;
		lblUsername.setFont(new Font("Arial", Font.PLAIN, plain));
		int[] varC = { 76, 75, 123, 40 };
		lblUsername.setBounds(varC[0], varC[1], varC[2], varC[3]);
		contentPane.add(lblUsername);

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		int[] varD = { 199, 88, 160, 20 };
		textField.setBounds(varD[0], varD[1], varD[2], varD[3]);
		contentPane.add(textField);
		int var = 10;
		textField.setColumns(var);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, plain));
		int[] varE = { 76, 126, 123, 40 };
		lblPassword.setBounds(varE[0], varE[1], varE[2], varE[3]);
		contentPane.add(lblPassword);

		passwordField = new JPasswordField();
		int[] varF = { 199, 139, 160, 20 };
		passwordField.setBounds(varF[0], varF[1], varF[2], varF[3]);
		contentPane.add(passwordField);
		int italic = 12;
		JLabel lblPssworDimenticata = new JLabel("Password dimenticata");
		lblPssworDimenticata.setFont(new Font("Arial", Font.ITALIC, italic));
		int[] varG = { 28, 201, 138, 29 };
		lblPssworDimenticata.setBounds(varG[0], varG[1], varG[2], varG[3]);
		contentPane.add(lblPssworDimenticata);

		JLabel lblNewLabel = new JLabel("_________________");
		int[] varH = { 28, 202, 171, 29 };
		lblNewLabel.setBounds(varH[0], varH[1], varH[2], varH[3]);
		contentPane.add(lblNewLabel);

		JButton btnAccedi = new JButton("Accedi");
		btnAccedi.setAction(action);
		btnAccedi.setFont(new Font("Arial", Font.PLAIN, italic));
		int[] varI = { 302, 205, 89, 23 };
		btnAccedi.setBounds(varI[0], varI[1], varI[2], varI[3]);
		contentPane.add(btnAccedi);
	}

	/**
	 * The Class SwingAction.
	 *
	 * @SwingAction
	 */
	public class SwingAction extends AbstractAction {

		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;

		/**
		 * Instantiates a new swing action.
		 *
		 * @SwingAction
		 */
		public SwingAction() {
			putValue(NAME, "Accedi");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		/**
		 * Action performed.
		 *
		 * @param e
		 *            the e
		 * @SwingAction
		 */
		public void actionPerformed(ActionEvent e) {
				
			Controlli c = new Controlli();
			
			
			String name = null;
			try {
				if(c.userControl(textField.getText()))
					name = textField.getText();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			
			String pass = null;
			try {
				if(c.controlPassword(String.copyValueOf(passwordField.getPassword())))
					pass = String.copyValueOf(passwordField.getPassword());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			String query = "SELECT * FROM listaUtenti WHERE username = ? AND password = ? ;";
			DBManager mysql = DBManager.getInstance();

			System.out.println(name + " " + pass);
			
			
			ResultSet rs = mysql.querySelect(query, name, pass);

			try {

				if (rs.next()) {

					GraficaMenu window = new GraficaMenu();

					window.setVisible(true);
					window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					contentPane.setVisible(false);
					frame.dispose();
				}

			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());

			}

		}
		
			
		
		
	
	}
	
	

	
//	public static SwingAction getSubInstance() {
//		
//		return new SwingAction();
//	}
//	
	
	
}
