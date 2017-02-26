package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.IReciveMessage;
import Controller.ReciverMMQ;
import Databases.KhamBenhDAO;
import Models.BenhNhan;
import Models.KhamBenh;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class ReciverUI {

	private JFrame frame;
	private JTextField tf_msbn;
	private JTextField tf_socmnd;
	private JTextField tf_hoten;
	private JTextArea tf_diachi;
	private static JList<String> jlist;
	private static DefaultListModel<String> defaultListModel;
	private static ArrayList<BenhNhan> listBenhNhan;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					ReciverUI window = new ReciverUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				ReciverMMQ.instance(new IReciveMessage() {
					@Override
					public void OnReciveMessage(BenhNhan benhnhan) {
						listBenhNhan.add(benhnhan);
						defaultListModel.addElement(benhnhan.getMsbn());
					}
				});
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReciverUI() {
		listBenhNhan = new ArrayList<>();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(-10, 0, 584, 350);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(51, 153, 255)),
				"Danh s\u00E1ch b\u1EC7nh nh\u00E2n ch\u1EDD kh\u00E1m", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(21, 11, 191, 328);
		panel.add(panel_1);
		panel_1.setLayout(null);

		defaultListModel = new DefaultListModel<>();
		jlist = new JList<String>();
		jlist.setModel(defaultListModel);
		jlist.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selected = jlist.getSelectedIndex();
				if (selected != -1) {
					BenhNhan bn = listBenhNhan.get(selected);
					tf_hoten.setText(bn.getHoten());
					tf_msbn.setText(bn.getMsbn());
					tf_socmnd.setText(bn.getSocmnd());
					tf_diachi.setText(bn.getDiachi());
				}
			}
		});
		JButton bt_GOIKHAM = new JButton("G\u1ECDi Kh\u00E1m...");
		bt_GOIKHAM.setBounds(0, 284, 191, 33);
		panel_1.add(bt_GOIKHAM);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 164, 252);
		panel_1.add(scrollPane);

		scrollPane.setViewportView(jlist);
		bt_GOIKHAM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(51, 153, 255)),
				"Th\u00F4ng tin b\u1EC7nh nh\u00E2n \u0111\u01B0\u1EE3c ch\u1ECDn", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(222, 11, 352, 339);
		panel.add(panel_2);
		panel_2.setLayout(null);

		tf_msbn = new JTextField();
		tf_msbn.setEditable(false);
		tf_msbn.setBounds(118, 29, 189, 22);
		panel_2.add(tf_msbn);
		tf_msbn.setColumns(10);

		tf_socmnd = new JTextField();
		tf_socmnd.setEditable(false);
		tf_socmnd.setColumns(10);
		tf_socmnd.setBounds(118, 62, 189, 22);
		panel_2.add(tf_socmnd);

		tf_hoten = new JTextField();
		tf_hoten.setEditable(false);
		tf_hoten.setColumns(10);
		tf_hoten.setBounds(118, 95, 189, 22);
		panel_2.add(tf_hoten);

		tf_diachi = new JTextArea();
		tf_diachi.setBounds(118, 128, 189, 80);
		panel_2.add(tf_diachi);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(51, 153, 255)), "N\u1ED9i dung kh\u00E1m",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 219, 332, 80);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JTextArea tf_ghichu = new JTextArea();
		tf_ghichu.setBounds(10, 21, 312, 48);
		panel_3.add(tf_ghichu);

		JLabel lblNewLabel = new JLabel("M\u00E3 s\u1ED1 b\u1EC7nh nh\u00E2n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(10, 33, 98, 14);
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("S\u1ED1 CMND");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(62, 66, 46, 14);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("H\u1ECD T\u00EAn");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(62, 99, 46, 14);
		panel_2.add(lblNewLabel_2);

		JLabel lblaCh = new JLabel("\u0110\u1ECBa Ch\u1EC9");
		lblaCh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblaCh.setBounds(62, 133, 46, 14);
		panel_2.add(lblaCh);

		JButton btnCpNhtThng = new JButton("C\u1EADp nh\u1EADt th\u00F4ng tin kh\u00E1m b\u1EC7nh");
		btnCpNhtThng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = jlist.getSelectedIndex();
				if(index >= 0){
					defaultListModel.remove(index);
					listBenhNhan.remove(index);
					if(listBenhNhan.size() > 0){
						jlist.setSelectedIndex(defaultListModel.size() - 1); 
					}
					java.util.Date dt = new java.util.Date();
					java.text.SimpleDateFormat sdf = 
					     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String msbn = tf_msbn.getText();
					String msbs ="BS01";
					String ghichu = tf_ghichu.getText();
					KhamBenh kb = new KhamBenh(msbn, msbs, sdf.format(dt), ghichu);
					KhamBenhDAO.SaveKhamBenhToDTB(kb);
					
				}
			}
		});
		btnCpNhtThng.setBounds(97, 305, 177, 23);
		panel_2.add(btnCpNhtThng);
	}
}
