
package gui;

import java.util.ArrayList;
import java.util.List;
import menuController.ControllerChange;
import menuController.DanhMucJFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.Color;

/**
 *
 * @author Trí Thức
 */
public class MainFrame extends javax.swing.JFrame {

// Variables declaration - do not modify                 
	private javax.swing.JLabel lblHoaDon;
	private javax.swing.JLabel lblSanPham;
	private javax.swing.JLabel lblNhanVien;
	private javax.swing.JLabel lblThongKe;
	private javax.swing.JPanel pnMenu;
	private javax.swing.JPanel pnHoaDon;
	private javax.swing.JPanel pnSanPham;
	private javax.swing.JPanel pnNhanVien;
	private javax.swing.JPanel pnThongKe;
	private javax.swing.JPanel pnBanHang;
	private javax.swing.JPanel pnTrangChu;
	private javax.swing.JLabel lblBanHang;
	private javax.swing.JLabel lblLogo;
	private javax.swing.JLabel lblTrangChu;
	private static javax.swing.JPanel pnView;

	private javax.swing.JLabel lblKhachHang;
	private javax.swing.JPanel pnKhachHang;
	// End of variables declaration
	private static List<DanhMucJFrame> listDanhMuc = new ArrayList<>();
	private static jpnBanHang jpnLapHoaDon = new jpnBanHang();

	public MainFrame() {
		initComponents();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Nhà Sách Tri Thức");

		listDanhMuc.add(new DanhMucJFrame("TrangChu", pnTrangChu, lblTrangChu));
		listDanhMuc.add(new DanhMucJFrame("BanHang", pnBanHang, lblBanHang));
		listDanhMuc.add(new DanhMucJFrame("HoaDon", pnHoaDon, lblHoaDon));
		listDanhMuc.add(new DanhMucJFrame("SanPham", pnSanPham, lblSanPham));
		listDanhMuc.add(new DanhMucJFrame("NhanVien", pnNhanVien, lblNhanVien));
		listDanhMuc.add(new DanhMucJFrame("KhachHang", pnKhachHang, lblKhachHang));
		listDanhMuc.add(new DanhMucJFrame("ThongKe", pnThongKe, lblThongKe));
		setContentView(new jpnTrangChu());
		
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

	public static void setContentView(JPanel jpn) {
		ControllerChange controller = new ControllerChange(pnView);
		controller.setView(jpn);
		controller.setEvent(listDanhMuc);
	}

	public static JPanel getLapHoaDon() {
		return jpnLapHoaDon;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		pnMenu = new javax.swing.JPanel();
		pnTrangChu = new javax.swing.JPanel();
		lblLogo = new javax.swing.JLabel();
		lblTrangChu = new javax.swing.JLabel();
		pnBanHang = new javax.swing.JPanel();
		lblBanHang = new javax.swing.JLabel();
		pnHoaDon = new javax.swing.JPanel();
		lblHoaDon = new javax.swing.JLabel();
		pnSanPham = new javax.swing.JPanel();
		lblSanPham = new javax.swing.JLabel();
		pnNhanVien = new javax.swing.JPanel();
		lblNhanVien = new javax.swing.JLabel();
		pnThongKe = new javax.swing.JPanel();
		lblThongKe = new javax.swing.JLabel();
		pnView = new javax.swing.JPanel();
		pnKhachHang = new JPanel();
		lblKhachHang = new JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(1550, 800));

		pnMenu.setBackground(new java.awt.Color(255, 255, 204));
		pnMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		pnMenu.setPreferredSize(new Dimension(300, 0));

		pnTrangChu.setBackground(new java.awt.Color(255, 255, 204));
		pnTrangChu.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

		lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblLogo.setIcon(
				new javax.swing.ImageIcon("E:\\HocTap\\Code\\Java2\\Nhom26_QuanLyNhaSach\\img\\logoTriThuc_mini.png"));

		lblTrangChu.setFont(new Font("Times New Roman", Font.BOLD, 22)); // NOI18N
		lblTrangChu.setForeground(new java.awt.Color(52, 84, 87));
		lblTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblTrangChu.setText("NHÀ SÁCH TRI THỨC");

		javax.swing.GroupLayout gl_pnTrangChu = new javax.swing.GroupLayout(pnTrangChu);
		pnTrangChu.setLayout(gl_pnTrangChu);
		gl_pnTrangChu
				.setHorizontalGroup(
						gl_pnTrangChu.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(gl_pnTrangChu.createSequentialGroup()
										.addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(lblTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap()));
		gl_pnTrangChu.setVerticalGroup(gl_pnTrangChu.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						gl_pnTrangChu.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 45,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(31, 31, 31))
				.addComponent(lblLogo, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE));

		pnBanHang.setBackground(new java.awt.Color(52, 84, 87));
		pnBanHang.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		lblBanHang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		lblBanHang.setForeground(new java.awt.Color(255, 255, 255));
		lblBanHang.setIcon(new javax.swing.ImageIcon("img\\Sale.png")); // NOI18N
		lblBanHang.setText("Bán Hàng");
		lblBanHang.setPreferredSize(new java.awt.Dimension(60, 21));

		javax.swing.GroupLayout gl_pnBanHang = new javax.swing.GroupLayout(pnBanHang);
		gl_pnBanHang.setHorizontalGroup(gl_pnBanHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnBanHang.createSequentialGroup().addContainerGap()
						.addComponent(lblBanHang, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE).addContainerGap()));
		gl_pnBanHang.setVerticalGroup(gl_pnBanHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnBanHang.createSequentialGroup().addContainerGap()
						.addComponent(lblBanHang, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(11, Short.MAX_VALUE)));
		pnBanHang.setLayout(gl_pnBanHang);

		pnHoaDon.setBackground(new java.awt.Color(52, 84, 87));
		pnHoaDon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		lblHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		lblHoaDon.setForeground(new java.awt.Color(255, 255, 255));
		lblHoaDon.setIcon(new javax.swing.ImageIcon("img\\HoaDon.png")); // NOI18N
		lblHoaDon.setText("Hoá Đơn");
		lblHoaDon.setPreferredSize(new java.awt.Dimension(60, 21));

		javax.swing.GroupLayout gl_pnHoaDon = new javax.swing.GroupLayout(pnHoaDon);
		gl_pnHoaDon.setHorizontalGroup(gl_pnHoaDon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnHoaDon.createSequentialGroup().addContainerGap()
						.addComponent(lblHoaDon, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE).addContainerGap()));
		gl_pnHoaDon.setVerticalGroup(gl_pnHoaDon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnHoaDon.createSequentialGroup().addContainerGap()
						.addComponent(lblHoaDon, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(40, Short.MAX_VALUE)));
		pnHoaDon.setLayout(gl_pnHoaDon);

		pnSanPham.setBackground(new java.awt.Color(52, 84, 87));
		pnSanPham.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		lblSanPham.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		lblSanPham.setForeground(new java.awt.Color(255, 255, 255));
		lblSanPham.setIcon(new javax.swing.ImageIcon("img\\book.png")); // NOI18N
		lblSanPham.setText("Sản Phẩm");
		lblSanPham.setPreferredSize(new java.awt.Dimension(60, 21));

		javax.swing.GroupLayout gl_pnSanPham = new javax.swing.GroupLayout(pnSanPham);
		gl_pnSanPham.setHorizontalGroup(gl_pnSanPham.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnSanPham.createSequentialGroup().addContainerGap()
						.addComponent(lblSanPham, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE).addContainerGap()));
		gl_pnSanPham.setVerticalGroup(gl_pnSanPham.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_pnSanPham.createSequentialGroup().addContainerGap()
						.addComponent(lblSanPham, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(40, Short.MAX_VALUE)));
		pnSanPham.setLayout(gl_pnSanPham);

		pnNhanVien.setBackground(new java.awt.Color(52, 84, 87));
		pnNhanVien.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		lblNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		lblNhanVien.setForeground(new java.awt.Color(255, 255, 255));
		lblNhanVien.setIcon(new javax.swing.ImageIcon("img\\NhanVien.png")); // NOI18N
		lblNhanVien.setText("Nhân Viên");
		lblNhanVien.setPreferredSize(new java.awt.Dimension(60, 21));

		javax.swing.GroupLayout gl_pnNhanVien = new javax.swing.GroupLayout(pnNhanVien);
		gl_pnNhanVien.setHorizontalGroup(gl_pnNhanVien.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnNhanVien.createSequentialGroup().addContainerGap()
						.addComponent(lblNhanVien, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE).addContainerGap()));
		gl_pnNhanVien.setVerticalGroup(gl_pnNhanVien.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_pnNhanVien.createSequentialGroup().addContainerGap()
						.addComponent(lblNhanVien, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(40, Short.MAX_VALUE)));
		pnNhanVien.setLayout(gl_pnNhanVien);

		pnThongKe.setBackground(new java.awt.Color(52, 84, 87));
		pnThongKe.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		lblThongKe.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		lblThongKe.setForeground(new java.awt.Color(255, 255, 255));
		lblThongKe.setIcon(new javax.swing.ImageIcon("img\\ThongKe.png")); // NOI18N
		lblThongKe.setText("Báo Cáo Thống Kê");
		lblThongKe.setPreferredSize(new java.awt.Dimension(60, 21));

		javax.swing.GroupLayout gl_pnThongKe = new javax.swing.GroupLayout(pnThongKe);
		gl_pnThongKe.setHorizontalGroup(gl_pnThongKe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnThongKe.createSequentialGroup().addContainerGap()
						.addComponent(lblThongKe, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE).addContainerGap()));
		gl_pnThongKe.setVerticalGroup(gl_pnThongKe.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				gl_pnThongKe.createSequentialGroup().addContainerGap()
						.addComponent(lblThongKe, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(40, Short.MAX_VALUE)));
		pnThongKe.setLayout(gl_pnThongKe);

		// ---------------------------------
		pnKhachHang.setBackground(new java.awt.Color(52, 84, 87));
		pnKhachHang.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		lblKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		lblKhachHang.setForeground(new java.awt.Color(255, 255, 255));
		lblKhachHang.setIcon(new javax.swing.ImageIcon("img\\KhachHang.png")); // NOI18N
		lblKhachHang.setText("Khách Hàng");
		lblKhachHang.setPreferredSize(new java.awt.Dimension(60, 21));

		javax.swing.GroupLayout gl_pnKhachHang = new javax.swing.GroupLayout(pnKhachHang);
		gl_pnKhachHang.setHorizontalGroup(gl_pnKhachHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnKhachHang.createSequentialGroup().addContainerGap()
						.addComponent(lblKhachHang, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE).addContainerGap()));
		gl_pnKhachHang
				.setVerticalGroup(gl_pnKhachHang.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_pnKhachHang.createSequentialGroup().addContainerGap()
								.addComponent(lblKhachHang, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(40, Short.MAX_VALUE)));
		pnKhachHang.setLayout(gl_pnKhachHang);
		
		JButton btnLogout = new JButton("Đăng Xuất");
		btnLogout.setBackground(new Color(165, 42, 42));
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logout();
				
			}
		});

		// ----------------------------------

		javax.swing.GroupLayout gl_pnMenu = new javax.swing.GroupLayout(pnMenu);
		gl_pnMenu.setHorizontalGroup(
			gl_pnMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnMenu.createSequentialGroup()
					.addGroup(gl_pnMenu.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnMenu.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_pnMenu.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnMenu.createParallelGroup(Alignment.LEADING)
								.addComponent(pnThongKe, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
								.addComponent(pnKhachHang, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_pnMenu.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(pnNhanVien, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(pnSanPham, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
									.addComponent(pnHoaDon, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(pnBanHang, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(pnTrangChu, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pnMenu.setVerticalGroup(
			gl_pnMenu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnMenu.createSequentialGroup()
					.addComponent(pnTrangChu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addComponent(pnBanHang, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnHoaDon, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnSanPham, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnNhanVien, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnKhachHang, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnThongKe, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		pnMenu.setLayout(gl_pnMenu);

		javax.swing.GroupLayout pnViewLayout = new javax.swing.GroupLayout(pnView);
		pnView.setLayout(pnViewLayout);
		pnViewLayout.setHorizontalGroup(pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 760, Short.MAX_VALUE));
		pnViewLayout.setVerticalGroup(pnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pnMenu, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pnView, GroupLayout.PREFERRED_SIZE, 1181, GroupLayout.PREFERRED_SIZE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnMenu, GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
				.addComponent(pnView, GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE));
		getContentPane().setLayout(layout);

		pack();
	}// </editor-fold>
	
	private void logout() {
		new frmLogin().setVisible(true);
		this.dispose();
	}
}
