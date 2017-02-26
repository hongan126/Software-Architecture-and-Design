package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dialog;

import javax.swing.JScrollBar;
import javax.swing.border.TitledBorder;

import Controller.SenderMQ;
import Databases.BenhNhanDAO;
import Databases.ConnectDB;
import Models.BenhNhan;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SenderUI {

	private JFrame frame;
	private SenderMQ senderMQ;
	private static JTextArea tf_diachi;
	private static JTextField tf_msbn;
	private static JTextField tf_socmnd;
	private static JTextField tf_hoten;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SenderUI window = new SenderUI();
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
	public SenderUI() {
		ConnectDB.instance();
		initialize();
		senderMQ = SenderMQ.instance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin b\u1EC7nh nh\u00E2n",
						TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		tf_msbn = new JTextField();
		tf_msbn.setBounds(143, 46, 207, 20);
		panel.add(tf_msbn);
		tf_msbn.setColumns(10);

		JLabel lblMaSoBenh = new JLabel("M\u00E3 S\u1ED1 B\u1EC7nh Nh\u00E2n");
		lblMaSoBenh.setBounds(29, 46, 92, 20);
		lblMaSoBenh.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblMaSoBenh);

		tf_socmnd = new JTextField();
		tf_socmnd.setBounds(143, 77, 207, 20);
		panel.add(tf_socmnd);
		tf_socmnd.setColumns(10);

		tf_hoten = new JTextField();
		tf_hoten.setBounds(143, 108, 207, 20);
		panel.add(tf_hoten);
		tf_hoten.setColumns(10);

		tf_diachi = new JTextArea();
		tf_diachi.setBounds(143, 150, 207, 54);
		panel.add(tf_diachi);

		JButton button = new JButton(".");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tf_msbn.getText() != null) {
					BenhNhan bn = BenhNhanDAO.FindBenhNhanById(tf_msbn.getText());
					if (bn != null)
						FillTextField(bn);
				}

			}
		});
		button.setBounds(373, 46, 30, 20);
		panel.add(button);

		JButton button_1 = new JButton(".");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf_socmnd.getText() != null) {
					BenhNhan bn = BenhNhanDAO.FindBenhNhanByCMND(tf_socmnd.getText());
					if (bn != null)
						FillTextField(bn);
				}
			}
		});
		button_1.setBounds(373, 77, 30, 20);
		panel.add(button_1);

		JLabel lblNewLabel = new JLabel("S\u1ED1 CMND");
		lblNewLabel.setBounds(29, 77, 92, 20);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("H\u1ECD V\u00E0 T\u00EAn");
		lblNewLabel_1.setBounds(29, 108, 92, 20);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u0110\u1ECBa Ch\u1EC9");
		lblNewLabel_2.setBounds(29, 152, 92, 20);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_2);

		JButton bt_Luu = new JButton("L\u01B0u Th\u00F4ng Tin");
		bt_Luu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BenhNhan bn = new BenhNhan();
				bn.setHoten(tf_hoten.getText());
				bn.setMsbn(tf_msbn.getText());
				bn.setSocmnd(tf_socmnd.getText());
				bn.setDiachi(tf_diachi.getText());

				if (BenhNhanDAO.InsertBenhNhan(bn)) {
					senderMQ.SendText(bn);
					JOptionPane.showMessageDialog(bt_Luu, "Success");
					tf_hoten.setText("");
					tf_msbn.setText("");
					tf_socmnd.setText("");
					tf_diachi.setText("");
					tf_hoten.requestFocus();
				} else {
					if (tf_msbn != null) {
						senderMQ.SendText(BenhNhanDAO.FindBenhNhanById(tf_msbn.getText()));
						JOptionPane.showMessageDialog(bt_Luu, "Success");
					} else if (tf_socmnd != null) {
						senderMQ.SendText(BenhNhanDAO.FindBenhNhanByCMND(tf_socmnd.getText()));
						JOptionPane.showMessageDialog(bt_Luu, "Success");
					} else
						JOptionPane.showMessageDialog(bt_Luu, "Error");
				}
			}
		});
		bt_Luu.setBounds(143, 215, 101, 32);
		panel.add(bt_Luu);

		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.NORTH);

		JLabel lblNhnBnh = new JLabel("NH\u1EACN B\u1EC6NH");
		lblNhnBnh.setFont(new Font("Arial", Font.BOLD, 24));
		panel_2.add(lblNhnBnh);
	}

	public void FillTextField(BenhNhan bn) {
		tf_diachi.setText(bn.getDiachi());
		tf_hoten.setText(bn.getHoten());
		tf_msbn.setText(bn.getMsbn());
		tf_socmnd.setText(bn.getSocmnd());
	}
}
