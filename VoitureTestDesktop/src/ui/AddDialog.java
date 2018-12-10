package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.BagnoleEntity;
import javax.swing.JTextField;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class AddDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField marqueField;
	private JTextField modeleField;
	private JTextField yearField;
	private BagnoleEntity be;
	
	public BagnoleEntity getBe() {
		return be;
	}

	public void setBe(BagnoleEntity be) {
		this.be = be;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddDialog dialog = new AddDialog(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddDialog(BagnoleEntity b) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 228);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			marqueField = new JTextField();
			marqueField.setBounds(113, 47, 86, 20);
			contentPanel.add(marqueField);
			marqueField.setColumns(10);
		}

		modeleField = new JTextField();
		modeleField.setBounds(113, 86, 86, 20);
		contentPanel.add(modeleField);
		modeleField.setColumns(10);
		yearField = new JTextField();
		yearField.setBounds(113, 122, 86, 20);
		contentPanel.add(yearField);
		yearField.setColumns(10);

		JLabel lblMarque = new JLabel("Marque");
		lblMarque.setBounds(57, 50, 46, 14);
		contentPanel.add(lblMarque);

		JLabel lblModle = new JLabel("Modèle");
		lblModle.setBounds(57, 89, 46, 14);
		contentPanel.add(lblModle);

		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(57, 125, 46, 14);
		contentPanel.add(lblYear);
		if(b == null) {
			marqueField.setText("");
			modeleField.setText("");
			yearField.setText("");
		}else {
			setBe(b);
			marqueField.setText(be.getMarque().toString());
			modeleField.setText(be.getModele().toString());
			yearField.setText(be.getAnnee() + "");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(b == null) {
							be = new BagnoleEntity(-1, marqueField.getText(), modeleField.getText(),
									Integer.parseInt(yearField.getText()));
						}
						be.setMarque(marqueField.getText());
						be.setModele(modeleField.getText());
						be.setAnnee(Integer.parseInt(yearField.getText()));
						dispose();
					}

				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						dispose();
					}

				});
			}
		}
	}
}
