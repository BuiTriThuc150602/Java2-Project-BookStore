package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
//import java.util.Properties;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import dao.DAO_NhanVien;
import dao.DAO_TaiKhoan;
import entity.NhanVien;
import entity.TaiKhoan;

import javax.swing.GroupLayout.Alignment;

public class frmLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnDangNhap;
	private JLabel lblLogo;
	private JLabel lblMatKhau;
	private JLabel lblQuenMatKhau;
	private JLabel lblTenDangNhap;
	private JLabel lblTitle;
	private JPanel panelDangNhap;
	private JPanel panelForm;
	private JPanel panelLogo;
	private  JPasswordField pwdMatKhau ;
	private JTextField txttenDangNhap;
	private DAO_TaiKhoan dao_taiKhoan = new DAO_TaiKhoan();
	private DAO_NhanVien dao_NhanVien = new DAO_NhanVien();
	public static NhanVien nhanVienDangNhap;

	public frmLogin() {
		initComponents();
		setTitle("Nhà Sách Tri Thức");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		btnDangNhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xacThucDangNhap();

			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				if (JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình không ?", "Confirm",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	}

	private void initComponents() {

		panelLogo = new JPanel();
		panelDangNhap = new JPanel();
		panelForm = new JPanel();
		lblLogo = new JLabel();
		lblTitle = new JLabel();
		lblMatKhau = new JLabel();
		lblQuenMatKhau = new JLabel();
		lblTenDangNhap = new JLabel();
		txttenDangNhap = new JTextField();
		pwdMatKhau = new JPasswordField();
		btnDangNhap = new JButton();

		panelLogo.setBackground(new java.awt.Color(255, 255, 204));
		panelLogo.setBorder(BorderFactory.createEtchedBorder());
		panelLogo.setPreferredSize(new java.awt.Dimension(300, 400));

		lblLogo.setBackground(new java.awt.Color(255, 255, 204));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon("img//logoTriThuc.png"));

		GroupLayout panelLogoLayout = new GroupLayout(panelLogo);
		panelLogoLayout.setHorizontalGroup(panelLogoLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, panelLogoLayout.createSequentialGroup().addGap(2)
						.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 278, Short.MAX_VALUE).addContainerGap()));
		panelLogoLayout
				.setVerticalGroup(panelLogoLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						panelLogoLayout.createSequentialGroup().addGap(66)
								.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(76, Short.MAX_VALUE)));
		panelLogo.setLayout(panelLogoLayout);

		panelDangNhap.setBackground(new java.awt.Color(255, 255, 204));
		panelDangNhap.setBorder(BorderFactory.createEtchedBorder());
		panelDangNhap.setPreferredSize(new java.awt.Dimension(300, 400));

		lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setIcon(new ImageIcon("img//user.png")); // NOI18N
		lblTitle.setText("Đăng Nhập");

		panelForm.setBackground(new java.awt.Color(255, 255, 204));
		panelForm.setBorder(BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

		lblTenDangNhap.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblTenDangNhap.setText("Tên Đăng Nhập");

		lblMatKhau.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblMatKhau.setText("Mật Khẩu");

		txttenDangNhap.setText("quanly01");
		txttenDangNhap.setToolTipText("Nhập tên đăng nhập");

		pwdMatKhau.setText("ql01");
		pwdMatKhau.setToolTipText("Nhập mật khẩu");

		lblQuenMatKhau.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
		lblQuenMatKhau.setForeground(new java.awt.Color(0, 51, 204));
		lblQuenMatKhau.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuenMatKhau.setText("Quên mật khẩu");

		GroupLayout panelFormLayout = new GroupLayout(panelForm);
		panelForm.setLayout(panelFormLayout);
		panelFormLayout.setHorizontalGroup(panelFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelFormLayout.createSequentialGroup().addContainerGap().addGroup(panelFormLayout
						.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(lblQuenMatKhau, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addGroup(panelFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(panelFormLayout.createSequentialGroup()
										.addComponent(lblTenDangNhap, GroupLayout.PREFERRED_SIZE, 110,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(txttenDangNhap, GroupLayout.PREFERRED_SIZE, 300,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(panelFormLayout.createSequentialGroup()
										.addComponent(lblMatKhau, GroupLayout.PREFERRED_SIZE, 110,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(pwdMatKhau, GroupLayout.PREFERRED_SIZE, 300,
												GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(28, Short.MAX_VALUE)));
		panelFormLayout.setVerticalGroup(panelFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelFormLayout.createSequentialGroup().addGap(31, 31, 31)
						.addGroup(panelFormLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblTenDangNhap, GroupLayout.PREFERRED_SIZE, 35,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txttenDangNhap, GroupLayout.PREFERRED_SIZE, 35,
										GroupLayout.PREFERRED_SIZE))
						.addGap(28, 28, 28)
						.addGroup(panelFormLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lblMatKhau, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(pwdMatKhau, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addComponent(lblQuenMatKhau, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(68, Short.MAX_VALUE)));

		btnDangNhap.setBackground(new java.awt.Color(52, 84, 87));
		btnDangNhap.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		btnDangNhap.setForeground(new java.awt.Color(255, 255, 255));
		btnDangNhap.setIcon(new ImageIcon("img//login_icon.png"));
		btnDangNhap.setText("Đăng Nhập");

		GroupLayout panelDangNhapLayout = new GroupLayout(panelDangNhap);
		panelDangNhap.setLayout(panelDangNhapLayout);
		panelDangNhapLayout.setHorizontalGroup(panelDangNhapLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(panelForm, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(panelDangNhapLayout.createSequentialGroup().addGroup(panelDangNhapLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(panelDangNhapLayout.createSequentialGroup().addGap(142, 142, 142)
								.addComponent(btnDangNhap, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
						.addGroup(panelDangNhapLayout.createSequentialGroup().addGap(114, 114, 114)
								.addComponent(lblTitle)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelDangNhapLayout.setVerticalGroup(panelDangNhapLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelDangNhapLayout.createSequentialGroup()
						.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(panelForm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnDangNhap, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE).addContainerGap()));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(panelDangNhap, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(panelLogo, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
								.addComponent(panelDangNhap, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
						.addContainerGap()));

		pack();
	}

	public boolean xacThucDangNhap() {
		String tenDangnhap = txttenDangNhap.getText().trim();
		String matKhau = new String(pwdMatKhau.getPassword());
		ArrayList<TaiKhoan> dsTaiKhoan = dao_taiKhoan.getAllTaiKhoan();
		for (TaiKhoan taiKhoan : dsTaiKhoan) {

			if (taiKhoan.getTenDangnhap().trim().equalsIgnoreCase(tenDangnhap)) {
				if (matKhau.trim().equalsIgnoreCase(taiKhoan.getMatKhau().trim())) {
					JOptionPane.showMessageDialog(this, "Đăng nhập thành công !");
					nhanVienDangNhap = dao_NhanVien.getNhanVienTheoTaiKhoan(taiKhoan.getMaTaiKhoan().trim());
					MainFrame mFrame = new MainFrame();
					mFrame.setVisible(true);
					this.dispose();
					return true;

				} else {
					JOptionPane.showMessageDialog(this, "Mật khẩu sai !");
					pwdMatKhau.selectAll();
					pwdMatKhau.requestFocus();
					return false;
				}
			}
		}
		JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại !");
		pwdMatKhau.selectAll();
		pwdMatKhau.requestFocus();
		return false;

	}

	public static NhanVien getNhanVienDangNhap() {

		return nhanVienDangNhap;
	}

//	public boolean sendEmail(String email, String password, String messageTo) {
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.socketFactory.port", 465);
//		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//		props.put("mail.smtp.port", 465);
//
//		// get Session
//		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(email, password);
//			}
//		});
//
//		// compose message
//		try {
//			MimeMessage message = new MimeMessage(session);
//			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(messageTo));
//			message.setSubject("Testing Subject");
//			message.setText("Welcome to gpcoder.com");
//
//			// send message
//			Transport.send(message);
//
//			System.out.println("Message sent successfully");
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
//		return true;
//
//	}

}
