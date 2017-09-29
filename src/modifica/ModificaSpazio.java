package modifica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controlli;
import enums.Table;
import menu.GraficaMenu;
import support.DBManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Action;
import java.awt.event.ActionListener;

/**
 * The Class ModificaSpazio.
 */
public class ModificaSpazio extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The content pane. */
	private JPanel contentPane;

	/** The text field. */
	private JTextField textField;

	/** The text field 1. */
	private JTextField textField_1;

	/** The text field 2. */
	private JTextField textField_2;

	/** The action. */
	private final Action action = new SwingAction();

	/** The text field 10. */
	private JTextField textField_10;

	/**
	 * Create the frame.
	 */
	public ModificaSpazio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		set1();
		set2();
		set3();
	}

	private void set3() {
		textField_10.setBounds(215, 9, 86, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);

		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(321, 8, 89, 23);
		contentPane.add(btnOk);

		btnOk.addActionListener(new ActionListener() {
			/**
			 * actionPerformed
			 */
			public void actionPerformed(ActionEvent e) {
				String id = textField_10.getText();
				String query = "SELECT * FROM myspazio WHERE ID_Spazio = ?";
				DBManager mysql = DBManager.getInstance();
				ResultSet rs = mysql.querySelect(query, id);

				try {
					if (rs.next()) {

						int id1 = rs.getInt("ID_Spazio");
						String nome = rs.getString("Nome");
						String descrizione = rs.getString("Descrizione");

						textField.setText("" + id1);
						textField_1.setText(nome);
						textField_2.setText(descrizione);

					} else {
						JOptionPane.showMessageDialog(null, "Errore");
					}

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Errore");
				}
			}
		});
	}

	private void set2() {
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setAction(action);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(300, 211, 110, 39);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Ricerca per ID:");
		lblNewLabel_2.setBounds(110, 6, 107, 27);
		contentPane.add(lblNewLabel_2);

		textField_10 = new JTextField();
		textField_10.addActionListener(new ActionListener() {
			/**
			 * actionPerformed
			 */
			public void actionPerformed(ActionEvent arg0) {
				String id = textField_10.getText();

				String query = "SELECT * FROM myspazio WHERE ID_Spazio = ?";
				DBManager mysql = DBManager.getInstance();
				ResultSet rs = mysql.querySelect(query, id);

				try {

					if (rs.next()) {

						GraficaMenu window = new GraficaMenu();

						window.setVisible(true);
						window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						contentPane.setVisible(false);

					}

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Errore");
				}

			}
		});
	}

	private void set1() {
		JLabel lblModificaSpazio = new JLabel("Modifica Spazio");
		lblModificaSpazio.setBounds(10, 12, 127, 14);
		contentPane.add(lblModificaSpazio);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(81, 70, 18, 14);
		contentPane.add(lblId);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(81, 114, 36, 14);
		contentPane.add(lblNome);

		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setBounds(81, 151, 77, 17);
		contentPane.add(lblDescrizione);

		textField = new JTextField();
		textField.setBounds(161, 67, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(161, 111, 221, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(161, 149, 238, 51);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}

	/**
	 * The Class SwingAction.
	 *
	 * @SwingAction
	 */
	private class SwingAction extends AbstractAction {

		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;

		/**
		 * Instantiates a new swing action.
		 *
		 * @SwingAction
		 */
		public SwingAction() {
			putValue(NAME, "Modifica");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		/**
		 * actionPerformed.
		 *
		 * @param e
		 *            the e
		 */
		public void actionPerformed(ActionEvent e) {
			ArrayList<JTextField> textList = new ArrayList<>();
			Controlli c = new Controlli();

			boolean on = false;

			try {
				on = c.IDControl(textField, Table.SPAZIO, this.getClass().getName()) && c.notEmptyStringControl(textField_1) && 
						c.notEmptyStringControl(textField_2);
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			if (on) {
				textList.add(textField);
				textList.add(textField_1);
				textList.add(textField_2);

				if (textList.isEmpty()) {

					String query = "UPDATE myspazio SET ID_Spazio= ? AND Nome= ?  AND "
							+ "Descrizione = ?  WHERE ID_Spazio = ?;";

					DBManager mysql = DBManager.getInstance();
					mysql.query(query, textField.getText(), textField_1.getText(), textField_2.getText(),
							textField_10.getText());

				}

			}

		}
	}
}