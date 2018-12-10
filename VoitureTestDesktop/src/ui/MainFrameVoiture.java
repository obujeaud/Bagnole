package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import entity.BagnoleEntity;
import service.VoitureService;
import ui.model.VoitureModeleList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class MainFrameVoiture {

	private JFrame frame;
	@SuppressWarnings("rawtypes")
	VoitureModeleList vml = new VoitureModeleList(VoitureService.getInstance());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameVoiture window = new MainFrameVoiture();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrameVoiture() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(256, 64, 99, 23);
		panel.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(256, 99, 99, 23);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(256, 133, 99, 23);
		panel.add(btnDelete);
		
		JList listBagnole = new JList();
		listBagnole.setBounds(25, 11, 203, 197);
		listBagnole.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.add(listBagnole);
		listBagnole.setModel(vml);
		listBagnole.setVisible(true);
		
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddDialog ad = new AddDialog(null);
				ad.setModal(true);
				ad.setVisible(true);
				VoitureService.getInstance().replace(ad.getBe());
				//VoitureService.getInstance().add(ad.getBe());
				listBagnole.updateUI();
				listBagnole.repaint();
			}
			
		});
		
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BagnoleEntity b = (BagnoleEntity) vml.getElementAt(listBagnole.getSelectedIndex());
				AddDialog ad = new AddDialog(b);
				ad.setModal(true);
				ad.setVisible(true);
				VoitureService.getInstance().replace(ad.getBe());
				listBagnole.updateUI();
				listBagnole.repaint();
			}
			
		});
		
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(JOptionPane.showConfirmDialog(null, "Etes-vous sûr de vouloir détruire cet élément ?", "Suppresion", JOptionPane.YES_NO_OPTION) == 0) {
					try {
						BagnoleEntity b = (BagnoleEntity) vml.getElementAt(listBagnole.getSelectedIndex());
						VoitureService.getInstance().delete(b.getId());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					listBagnole.updateUI();
					listBagnole.repaint();
				}
			}
			
		});
	}
}
