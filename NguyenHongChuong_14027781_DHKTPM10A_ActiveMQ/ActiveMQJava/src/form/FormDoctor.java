package form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import org.apache.log4j.BasicConfigurator;

import entity.BenhNhan;
import helper.ConvertXML;
import helper.DataCloseConnect;
import helper.DataQuerry;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Properties;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class FormDoctor extends JFrame {

	private JPanel contentPane;
	private JTextField txtMasoBN;
	private JTextField txtSoCMND;
	private JTextField txtHoTen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDoctor frame = new FormDoctor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws NamingException 
	 * @throws JMSException 
	 */
	public FormDoctor() throws NamingException, JMSException {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("Ba\u0301c si\u0303 kha\u0301m b\u00EA\u0323nh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 476);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(10, 11, 714, 424);
		contentPane.add(splitPane);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setPreferredSize(new Dimension(220, 404));
		splitPane.setLeftComponent(splitPane_1);
		
		JButton btnGoiKham = new JButton("Go\u0323i kha\u0301m");
		btnGoiKham.setFont(new Font("Tahoma", Font.PLAIN, 13));
		splitPane_1.setRightComponent(btnGoiKham);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Danh sa\u0301ch b\u00EA\u0323nh nh\u00E2n ch\u01A1\u0300 kha\u0301m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setPreferredSize(new Dimension(200, 370));
		splitPane_1.setLeftComponent(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 198, 336);
		panel_2.add(scrollPane);
		
		JList listBN = new JList();
		scrollPane.setViewportView(listBN);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin b\u00EA\u0323nh nh\u00E2n \u0111\u01B0\u01A1\u0323c cho\u0323n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setToolTipText("");
		splitPane.setRightComponent(panel);
		panel.setLayout(null);
		
		JLabel lblMaSBnh = new JLabel("Ma\u0303 s\u00F4\u0301 b\u00EA\u0323nh nh\u00E2n:");
		lblMaSBnh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaSBnh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaSBnh.setBounds(10, 40, 129, 14);
		panel.add(lblMaSBnh);
		
		JLabel lblSCmnd = new JLabel("S\u00F4\u0301 CMND:");
		lblSCmnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSCmnd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSCmnd.setBounds(42, 77, 97, 14);
		panel.add(lblSCmnd);
		
		JLabel lblHoVaTn = new JLabel("Ho\u0323 va\u0300 t\u00EAn:");
		lblHoVaTn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHoVaTn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHoVaTn.setBounds(42, 115, 97, 14);
		panel.add(lblHoVaTn);
		
		JLabel lbliaChi = new JLabel("\u0110i\u0323a chi\u0309:");
		lbliaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbliaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		lbliaChi.setBounds(42, 152, 97, 14);
		panel.add(lbliaChi);
		
		txtMasoBN = new JTextField();
		txtMasoBN.setEditable(false);
		txtMasoBN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMasoBN.setBounds(149, 34, 317, 26);
		panel.add(txtMasoBN);
		txtMasoBN.setColumns(10);
		
		txtSoCMND = new JTextField();
		txtSoCMND.setEditable(false);
		txtSoCMND.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSoCMND.setColumns(10);
		txtSoCMND.setBounds(149, 71, 317, 27);
		panel.add(txtSoCMND);
		
		txtHoTen = new JTextField();
		txtHoTen.setEditable(false);
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(149, 109, 317, 27);
		panel.add(txtHoTen);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(149, 147, 317, 65);
		panel.add(scrollPane_1);
		
		JTextArea txtDiaChi = new JTextArea();
		txtDiaChi.setEditable(false);
		scrollPane_1.setViewportView(txtDiaChi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "N\u00F4\u0323i dung kha\u0301m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 223, 467, 194);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 22, 447, 114);
		panel_1.add(scrollPane_2);
		
		JTextArea txtNoiDungKham = new JTextArea();
		txtNoiDungKham.setEditable(false);
		scrollPane_2.setViewportView(txtNoiDungKham);
		
		JButton btnCapnhatTT = new JButton("C\u00E2\u0323p nh\u00E2\u0323t th\u00F4ng tin kha\u0301m b\u00EA\u0323nh");
		btnCapnhatTT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCapnhatTT.setBounds(125, 144, 225, 39);
		panel_1.add(btnCapnhatTT);
		
		DefaultListModel<BenhNhan> listBNModel = new DefaultListModel<>();
		listBN.setModel(listBNModel);
		
		BasicConfigurator.configure();
		//thiết lập môi trường cho JJNDI
		Properties settings=new Properties();
		settings.setProperty(Context.INITIAL_CONTEXT_FACTORY,
		"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
		
		//tạo context
		Context ctx=new InitialContext(settings);
		//lookup JMS connection factory
		Object obj=ctx.lookup("ConnectionFactory");
		ConnectionFactory factory =(ConnectionFactory)obj;
		//lookup destination
		Destination destination =(Destination) ctx.lookup("dynamicQueues/hospital");
		
		//tạo connection
		Connection con=factory.createConnection("admin","admin");
		//nối đến MOM
		con.start();
		//tạo session
		Session session=con.createSession(
		/*transaction*/false,
		/*ACK*/Session.CLIENT_ACKNOWLEDGE
		);
		//tạo consumer
		MessageConsumer receiver = session.createConsumer(destination);
		System.out.println("I was listened on queue...");
		receiver.setMessageListener(new MessageListener() {
			@Override
			//có message đến queue, phương thức này được thực thi
			public void onMessage(Message msg) {//msg là message nhận được
			try {
				if(msg instanceof TextMessage){
					TextMessage tm=(TextMessage)msg;
					BenhNhan bn = new BenhNhan("aa","ss","dd","eee");
					ConvertXML<BenhNhan>bn2 = new ConvertXML<BenhNhan>(bn);
					BenhNhan bn1= bn2.xml2Object(tm.getText().trim());
					System.out.println("Nhận được AGAEGSDF"+ bn1.toString());
					
					if(listBNModel.size()!=0)
					{
						for(int i=0;i<listBNModel.size();i++)
						{
							if(listBNModel.getElementAt(i).equals(bn1)==false)
							{
								listBNModel.addElement(bn1);
								listBN.setModel(listBNModel);
							}
							
						}
					}
					else
					{
						listBNModel.addElement(bn1);
						listBN.setModel(listBNModel);
					}
					
					msg.acknowledge();//gửi tín hiệu ack
				}
				else if(msg instanceof ObjectMessage){
					ObjectMessage om=(ObjectMessage)msg;
					System.out.println(om);
				}
				
				//others message type....
			} catch (Exception e) {
			e.printStackTrace();
			}
			}
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát ?","Thoát ứng dụng",JOptionPane.YES_NO_OPTION);
				if(confirm == JOptionPane.YES_OPTION)
				{
					try {
						session.close();
						con.close();
						
					} catch (JMSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.exit(0);
				}
			}
		});
		
		btnGoiKham.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(listBN.getSelectedIndex()<0)
				{
					JOptionPane.showMessageDialog(null, "Vui lòng chọn bệnh nhân để khám");
				}
				else
				{
					BenhNhan bn = listBNModel.get(listBN.getSelectedIndex());
					txtMasoBN.setText(bn.getMasoBN());
					txtSoCMND.setText(bn.getSoCMND());
					txtHoTen.setText(bn.getHoTen());
					txtDiaChi.setText(bn.getDiaChi());
					txtNoiDungKham.setEditable(true);
					txtNoiDungKham.requestFocus();
				}
			}
		});
		
		btnCapnhatTT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String masoBN = txtMasoBN.getText().trim();
				String soCMND = txtSoCMND.getText().trim();
				String hoTen = txtHoTen.getText().trim();
				String diaChi = txtDiaChi.getText().trim();
				String ndKham = txtNoiDungKham.getText().trim();
				BenhNhan bn = new BenhNhan(masoBN, soCMND, hoTen, diaChi);
				if(masoBN.equals("") || soCMND.equals("") || hoTen.equals("") || diaChi.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Chưa có thông tin khám bệnh");
				}
				else
				{
					if(!DataQuerry.dataUpdate(bn, ndKham))
					{
						JOptionPane.showMessageDialog(null, "Không cập nhật được nội dung khám bệnh");
					}
					else
					{
						if(listBNModel.size()!=0)
						{
							for(int i=0;i<listBNModel.size();i++)
							{
								if(listBNModel.getElementAt(i).equals(bn)==true)
								{
									listBNModel.remove(i);
									listBN.setModel(listBNModel);
								}
								
							}
						}
					}
				}
				
			}
		});
	}
}
