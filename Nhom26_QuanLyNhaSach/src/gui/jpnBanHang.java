/*
  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import dao.DAO_CTHoaDon;
import dao.DAO_HoaDon;
import dao.DAO_KhachHang;
import dao.DAO_Loai;
import dao.DAO_SanPham;
import entity.CTHoaDon;
import entity.HangDoi;
import entity.HoaDon;
import entity.KhachHang;
import entity.Loai;
import entity.NhanVien;
import entity.SanPham;
import entity.SanPhamMuaTrenHoaDon;
import menuController.ProductsRenderer;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author Trí Thức
 */
public class jpnBanHang extends javax.swing.JPanel {

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnCapNhat;
	private javax.swing.JButton btnInHoaDon;
	private javax.swing.JButton btnMoHangDoi;
	private javax.swing.JButton btnThanhToan;
	private javax.swing.JButton btnThemHangDoi;
	private javax.swing.JButton btnThemKH;
	private javax.swing.JButton btnXoa;
	private javax.swing.JComboBox<String> cboLoaiSanPham;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel lblDaGiam;
	private javax.swing.JLabel lblDonGia;
	private javax.swing.JLabel lblDonViTinh;
	private javax.swing.JLabel lblGiamGia;
	private javax.swing.JLabel lblLoaiNV;
	private javax.swing.JLabel lblLoaiSanPham;
	private javax.swing.JLabel lblMaHD;
	private javax.swing.JLabel lblMaSanPham;
	private javax.swing.JLabel lblNgayLap;
	private javax.swing.JLabel lblSoLuong;
	private javax.swing.JLabel lblTenKH;
	private javax.swing.JLabel lblSoDienThoai;
	private javax.swing.JLabel lblTenNV;
	private javax.swing.JLabel lblTenSanPham;
	private javax.swing.JLabel lblTongTien;
	private javax.swing.JLabel lblTongTien1;
	private javax.swing.JLabel lblTongTien2;
	private javax.swing.JPanel pnChucNang;
	private javax.swing.JPanel pnLapHoaDon;
	private javax.swing.JPanel pnSanPham;
	private javax.swing.JPanel pnSearch;
	private javax.swing.JPanel pnThongTin;
	private javax.swing.JPanel pnThongTinHoaDon;
	private javax.swing.JPanel pnThongTinKhachHang;
	private javax.swing.JPanel pnThongTinSanPham;
	private javax.swing.JScrollPane scrTableSanPham;
	private javax.swing.JTable tblSanPham;
	private javax.swing.JTextField txtDaGiam;
	private javax.swing.JTextField txtDonGia;
	private javax.swing.JTextField txtDonViTinh;
	private javax.swing.JTextField txtGiamGia;
	private javax.swing.JTextField txtKhachDua;
	private javax.swing.JTextField txtLoaiNV;
	private javax.swing.JTextField txtMaHoaDon;
	private javax.swing.JTextField txtMaSanPham;
	private javax.swing.JTextField txtNgayLap;
	private javax.swing.JTextField txtSoDienThoai;
	private javax.swing.JTextField txtSoLuong;
	private javax.swing.JTextField txtTenKH;
	private javax.swing.JTextField txtTenNV;
	private javax.swing.JTextField txtTenSanPham;
	private javax.swing.JTextField txtTienThua;
	private javax.swing.JTextField txtTongTien;
	// End of variables declaration//GEN-END:variables

	private JList<SanPham> jlistSanPham;
//	private DAO_SanPham dao_SanPham = new DAO_SanPham();
	private DAO_SanPham dao_SanPham = splashScreen.dao_SanPham;
	private DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
	private ArrayList<SanPham> arrListSanPham = splashScreen.arrListSanPham;
	private DAO_HoaDon dao_HoaDon = new DAO_HoaDon();
	private DAO_CTHoaDon dao_CTHoaDon = new DAO_CTHoaDon();
	private NhanVien nhanVien = frmLogin.getNhanVienDangNhap();
	private KhachHang khachHangMua;
	private DefaultTableModel tblModelSanPham;
	private double tongTien;
	private static ArrayList<HangDoi> dsHangDoi = new ArrayList<>();

	/**
	 * Creates new form jpnBanHang
	 */
	public jpnBanHang() {
		initComponents();
		setThongTinlapHoaDon("");
		getThongTinNhanVien();
		jlistSanPham = createListProducts(arrListSanPham);
		loadDanhSachSanPham(jlistSanPham);
		loadComboBox();

		txtKhachDua.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				tinhTienThua();
			}
		});

		tblSanPham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickToTable();
			}
		});
		tblModelSanPham = (DefaultTableModel) tblSanPham.getModel();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		pnSanPham = new javax.swing.JPanel();
		pnLapHoaDon = new javax.swing.JPanel();
		pnChucNang = new javax.swing.JPanel();
		lblTongTien = new javax.swing.JLabel();
		txtTongTien = new javax.swing.JTextField();
		lblTongTien1 = new javax.swing.JLabel();
		txtKhachDua = new javax.swing.JTextField();
		lblTongTien2 = new javax.swing.JLabel();
		txtTienThua = new javax.swing.JTextField();
		btnThanhToan = new javax.swing.JButton();
		btnMoHangDoi = new javax.swing.JButton();
		lblDaGiam = new javax.swing.JLabel();
		txtDaGiam = new javax.swing.JTextField();
		btnInHoaDon = new javax.swing.JButton();
		btnThemHangDoi = new javax.swing.JButton();
		pnThongTinSanPham = new javax.swing.JPanel();
		lblDonViTinh = new javax.swing.JLabel();
		lblSoLuong = new javax.swing.JLabel();
		lblDonGia = new javax.swing.JLabel();
		txtDonViTinh = new javax.swing.JTextField();
		txtSoLuong = new javax.swing.JTextField();
		txtDonGia = new javax.swing.JTextField();
		btnCapNhat = new javax.swing.JButton();
		lblGiamGia = new javax.swing.JLabel();
		txtGiamGia = new javax.swing.JTextField();
		btnXoa = new javax.swing.JButton();
		pnSearch = new javax.swing.JPanel();
		lblTenSanPham = new javax.swing.JLabel();
		lblMaSanPham = new javax.swing.JLabel();
		lblLoaiSanPham = new javax.swing.JLabel();
		txtTenSanPham = new javax.swing.JTextField();
		txtMaSanPham = new javax.swing.JTextField();
		cboLoaiSanPham = new javax.swing.JComboBox<>();
		scrTableSanPham = new javax.swing.JScrollPane();
		tblSanPham = new javax.swing.JTable();
		pnThongTin = new javax.swing.JPanel();
		pnThongTinHoaDon = new javax.swing.JPanel();
		lblMaHD = new javax.swing.JLabel();
		lblNgayLap = new javax.swing.JLabel();
		txtMaHoaDon = new javax.swing.JTextField();
		txtNgayLap = new javax.swing.JTextField();
		pnThongTinKhachHang = new javax.swing.JPanel();
		lblTenKH = new javax.swing.JLabel();
		lblSoDienThoai = new javax.swing.JLabel();
		txtTenKH = new javax.swing.JTextField();
		txtSoDienThoai = new javax.swing.JTextField();
		btnThemKH = new javax.swing.JButton();
		jPanel1 = new javax.swing.JPanel();
		lblTenNV = new javax.swing.JLabel();
		lblLoaiNV = new javax.swing.JLabel();
		txtLoaiNV = new javax.swing.JTextField();
		txtTenNV = new javax.swing.JTextField();

		setPreferredSize(new java.awt.Dimension(750, 769));

		pnSanPham.setBackground(new java.awt.Color(255, 255, 204));
		pnSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Sản Phẩm",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

		pnSanPham.setLayout(new BorderLayout());
		pnSanPham.setPreferredSize(new Dimension(360, 582));

		pnLapHoaDon.setBackground(new java.awt.Color(255, 255, 204));
		pnLapHoaDon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		pnChucNang.setBackground(new java.awt.Color(255, 255, 204));
		pnChucNang.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		lblTongTien.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		lblTongTien.setText("Tổng Tiền :");

		txtTongTien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
		txtTongTien.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtTongTien.setFocusable(false);
		txtTongTien.setText(convertCurrencyVN(0));

		lblTongTien1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		lblTongTien1.setText("Khách Đưa :");

		txtKhachDua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
		txtKhachDua.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtKhachDua.setText(txtTongTien.getText());

		lblTongTien2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		lblTongTien2.setText("Tiền Thừa :");

		txtTienThua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
		txtTienThua.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtTienThua.setFocusable(false);
		txtTienThua.setText(convertCurrencyVN(0));

		btnThanhToan.setBackground(new java.awt.Color(76, 175, 80));
		btnThanhToan.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
		btnThanhToan.setText("Thanh Toán");
		btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnThanhToanActionPerformed(evt);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});

		btnMoHangDoi.setBackground(new java.awt.Color(52, 84, 87));
		btnMoHangDoi.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		btnMoHangDoi.setForeground(new java.awt.Color(255, 255, 255));
		btnMoHangDoi.setText("Mở Hàng Đợi");
		btnMoHangDoi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnMoHangDoiActionPerformed(evt);
			}
		});

		lblDaGiam.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		lblDaGiam.setText("Đã Giảm");

		txtDaGiam.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
		txtDaGiam.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		txtDaGiam.setFocusable(false);

		btnInHoaDon.setBackground(new java.awt.Color(52, 84, 87));
		btnInHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		btnInHoaDon.setForeground(new java.awt.Color(255, 255, 255));
		btnInHoaDon.setText("In Hóa Đơn");
		btnInHoaDon.setVisible(false);

		btnThemHangDoi.setBackground(new java.awt.Color(52, 84, 87));
		btnThemHangDoi.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		btnThemHangDoi.setForeground(new java.awt.Color(255, 255, 255));
		btnThemHangDoi.setText("Hàng Đợi");
		btnThemHangDoi.setToolTipText("");
		btnThemHangDoi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemHangDoiActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnChucNangLayout = new javax.swing.GroupLayout(pnChucNang);
		pnChucNang.setLayout(pnChucNangLayout);
		pnChucNangLayout.setHorizontalGroup(pnChucNangLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnChucNangLayout.createSequentialGroup().addContainerGap().addGroup(pnChucNangLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnChucNangLayout.createSequentialGroup().addComponent(btnMoHangDoi).addGap(18, 18, 18)
								.addComponent(btnThemHangDoi).addGap(18, 18, 18).addComponent(btnInHoaDon))
						.addGroup(pnChucNangLayout.createSequentialGroup()
								.addGroup(pnChucNangLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(pnChucNangLayout.createSequentialGroup()
												.addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(15, 15, 15).addComponent(txtTongTien,
														javax.swing.GroupLayout.PREFERRED_SIZE, 217,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(pnChucNangLayout.createSequentialGroup()
												.addComponent(lblDaGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 94,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(25, 25, 25).addComponent(txtDaGiam)))
								.addGap(57, 57, 57).addGroup(
										pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lblTongTien2).addComponent(lblTongTien1))))
						.addGap(13, 13, 13)
						.addGroup(pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtTienThua).addComponent(txtKhachDua).addComponent(btnThanhToan,
										javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addContainerGap()));
		pnChucNangLayout.setVerticalGroup(pnChucNangLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnChucNangLayout.createSequentialGroup().addGap(10, 10, 10)
						.addGroup(pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTongTien1, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblTongTien2, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDaGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDaGiam, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
						.addGroup(pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnMoHangDoi).addComponent(btnThemHangDoi).addComponent(btnInHoaDon)
								.addComponent(btnThanhToan))
						.addContainerGap()));

		pnThongTinSanPham.setBackground(new java.awt.Color(255, 255, 204));
		pnThongTinSanPham.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Sản Phẩm",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

		lblDonViTinh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblDonViTinh.setText("Đơn Vị Tính");

		lblSoLuong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblSoLuong.setText("Số Lượng");

		lblDonGia.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblDonGia.setText("Đơn Giá");

		txtDonViTinh.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		txtDonViTinh.setFocusable(false);

		txtSoLuong.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

		txtDonGia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		txtDonGia.setFocusable(false);

		btnCapNhat.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		btnCapNhat.setText("Cập Nhật");
		btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCapNhatActionPerformed(evt);
			}
		});

		lblGiamGia.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblGiamGia.setText("Giảm Giá");

		txtGiamGia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		txtGiamGia.setToolTipText("");
		txtGiamGia.setFocusable(false);

		btnXoa.setText("Xóa");
		btnXoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnThongTinSanPhamLayout = new javax.swing.GroupLayout(pnThongTinSanPham);
		pnThongTinSanPham.setLayout(pnThongTinSanPhamLayout);
		pnThongTinSanPhamLayout.setHorizontalGroup(pnThongTinSanPhamLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnThongTinSanPhamLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnThongTinSanPhamLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(pnThongTinSanPhamLayout.createSequentialGroup().addComponent(btnXoa)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnCapNhat))
								.addGroup(pnThongTinSanPhamLayout.createSequentialGroup()
										.addGroup(pnThongTinSanPhamLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lblDonViTinh).addComponent(lblSoLuong)
												.addComponent(lblDonGia).addComponent(lblGiamGia))
										.addGap(18, 18, 18)
										.addGroup(pnThongTinSanPhamLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
												.addComponent(txtDonViTinh, javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(txtDonGia).addComponent(txtGiamGia))))
						.addContainerGap()));
		pnThongTinSanPhamLayout.setVerticalGroup(pnThongTinSanPhamLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnThongTinSanPhamLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnThongTinSanPhamLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(lblDonViTinh, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtDonViTinh, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
						.addGap(15, 15, 15)
						.addGroup(
								pnThongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(15, 15, 15)
						.addGroup(
								pnThongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(lblDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
												javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(
								pnThongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(lblGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(pnThongTinSanPhamLayout.createSequentialGroup()
												.addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(1, 1, 1)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
						.addGroup(
								pnThongTinSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(btnCapNhat).addComponent(btnXoa))
						.addContainerGap()));

		pnSearch.setBackground(new java.awt.Color(255, 255, 204));
		pnSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Sản Phẩm",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

		lblTenSanPham.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblTenSanPham.setText("Tên Sản Phẩm");

		lblMaSanPham.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblMaSanPham.setText("Mã Sản Phẩm");

		lblLoaiSanPham.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblLoaiSanPham.setText("Loại Sản Phẩm");

		txtTenSanPham.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		txtTenSanPham.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		txtTenSanPham.setPreferredSize(new java.awt.Dimension(68, 26));
		txtTenSanPham.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				timKiemSanPham(txtTenSanPham.getText().trim());

			}
		});

		txtMaSanPham.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		txtMaSanPham.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		txtMaSanPham.setPreferredSize(new java.awt.Dimension(68, 26));
		txtMaSanPham.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				timKiemSanPham(txtMaSanPham.getText().trim());

			}
		});

		cboLoaiSanPham.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		cboLoaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn Loại Sản Phẩm" }));
		cboLoaiSanPham.setPreferredSize(new java.awt.Dimension(72, 26));
		cboLoaiSanPham.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DAO_Loai dao_Loai = new DAO_Loai();
				if (cboLoaiSanPham.getSelectedIndex() > 0) {
					String key = dao_Loai.getLoaiTheoTen(cboLoaiSanPham.getSelectedItem().toString().trim()).getMaLoai()
							.trim();
					if (key != null)
						timKiemSanPham(key);
				}

			}
		});

		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});

		javax.swing.GroupLayout pnSearchLayout = new javax.swing.GroupLayout(pnSearch);
		pnSearchLayout.setHorizontalGroup(pnSearchLayout.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				pnSearchLayout.createSequentialGroup().addContainerGap().addGroup(pnSearchLayout
						.createParallelGroup(Alignment.TRAILING).addComponent(btnLamMoi)
						.addGroup(pnSearchLayout.createSequentialGroup()
								.addGroup(pnSearchLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblLoaiSanPham, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTenSanPham, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblMaSanPham, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(pnSearchLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(cboLoaiSanPham, 0, 209, Short.MAX_VALUE)
										.addComponent(txtMaSanPham, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
										.addComponent(txtTenSanPham, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))))
						.addContainerGap()));
		pnSearchLayout.setVerticalGroup(pnSearchLayout.createParallelGroup(Alignment.LEADING).addGroup(pnSearchLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(pnSearchLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTenSanPham, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTenSanPham, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(pnSearchLayout
						.createParallelGroup(Alignment.BASELINE).addComponent(lblMaSanPham).addComponent(txtMaSanPham,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(pnSearchLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblLoaiSanPham)
						.addComponent(cboLoaiSanPham, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(btnLamMoi).addContainerGap(64, Short.MAX_VALUE)));
		pnSearch.setLayout(pnSearchLayout);

		tblSanPham.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		tblSanPham.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Mã Sản Phẩm", "Tên Sản Phẩm", "Đơn Vị Tính", "Đơn Giá", "Số Lượng", "Giảm Giá",
				"Thành Tiền" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		scrTableSanPham.setViewportView(tblSanPham);

		javax.swing.GroupLayout pnLapHoaDonLayout = new javax.swing.GroupLayout(pnLapHoaDon);
		pnLapHoaDon.setLayout(pnLapHoaDonLayout);
		pnLapHoaDonLayout
				.setHorizontalGroup(pnLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnLapHoaDonLayout.createSequentialGroup()
								.addComponent(pnSearch, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pnThongTinSanPham, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(pnChucNang, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(scrTableSanPham));
		pnLapHoaDonLayout
				.setVerticalGroup(pnLapHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnLapHoaDonLayout.createSequentialGroup()
								.addGroup(pnLapHoaDonLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(pnThongTinSanPham, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(pnSearch, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(scrTableSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 226,
										Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pnChucNang, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

		pnThongTin.setBackground(new java.awt.Color(255, 255, 204));
		pnThongTin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		pnThongTinHoaDon.setBackground(new java.awt.Color(255, 255, 204));
		pnThongTinHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hoá Đơn",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

		lblMaHD.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblMaHD.setText("Mã Hoá Đơn");

		lblNgayLap.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblNgayLap.setText("Ngày Lập");

		txtMaHoaDon.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		txtMaHoaDon.setToolTipText("Mã hoá đơn tự động phát sinh");
		txtMaHoaDon.setFocusable(false);

		txtNgayLap.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		txtNgayLap.setToolTipText("Ngày lập hóa đơn");
		txtNgayLap.setFocusable(false);

		javax.swing.GroupLayout pnThongTinHoaDonLayout = new javax.swing.GroupLayout(pnThongTinHoaDon);
		pnThongTinHoaDon.setLayout(pnThongTinHoaDonLayout);
		pnThongTinHoaDonLayout.setHorizontalGroup(pnThongTinHoaDonLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnThongTinHoaDonLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnThongTinHoaDonLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(lblMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
								.addComponent(lblNgayLap, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtNgayLap, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
								.addComponent(txtMaHoaDon))
						.addContainerGap()));
		pnThongTinHoaDonLayout.setVerticalGroup(pnThongTinHoaDonLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnThongTinHoaDonLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(15, 15, 15)
						.addGroup(pnThongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pnThongTinKhachHang.setBackground(new java.awt.Color(255, 255, 204));
		pnThongTinKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khách Hàng",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

		lblTenKH.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblTenKH.setText("Tên Khách Hàng");

		lblSoDienThoai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblSoDienThoai.setText("Số Điện Thoại");

		txtTenKH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		txtTenKH.setFocusable(false);
		txtSoDienThoai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		txtSoDienThoai.setFocusable(false);

		btnThemKH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		btnThemKH.setIcon(new javax.swing.ImageIcon("img//addPerson.png")); // NOI18N
		btnThemKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemKHActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnThongTinKhachHangLayout = new javax.swing.GroupLayout(pnThongTinKhachHang);
		pnThongTinKhachHang.setLayout(pnThongTinKhachHangLayout);
		pnThongTinKhachHangLayout.setHorizontalGroup(pnThongTinKhachHangLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinKhachHangLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pnThongTinKhachHangLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
										.addGap(0, 0, Short.MAX_VALUE).addComponent(btnThemKH))
								.addGroup(pnThongTinKhachHangLayout.createSequentialGroup()
										.addGroup(pnThongTinKhachHangLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(lblTenKH, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(pnThongTinKhachHangLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 192,
														Short.MAX_VALUE)
												.addComponent(txtSoDienThoai))))
						.addContainerGap()));
		pnThongTinKhachHangLayout.setVerticalGroup(pnThongTinKhachHangLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnThongTinKhachHangLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnThongTinKhachHangLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(lblTenKH, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
						.addGap(15, 15, 15)
						.addGroup(pnThongTinKhachHangLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(lblSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnThemKH)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jPanel1.setBackground(new java.awt.Color(255, 255, 204));
		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhân Viên",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

		lblTenNV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblTenNV.setText("Tên Nhân Viên");

		lblLoaiNV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblLoaiNV.setText("Chức vụ");

		txtLoaiNV.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		txtLoaiNV.setFocusable(false);

		txtTenNV.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		txtTenNV.setFocusable(false);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(lblTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
								.addComponent(lblLoaiNV, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtTenNV).addComponent(txtLoaiNV))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblLoaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtLoaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(44, 44, 44)));

		javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
		pnThongTin.setLayout(pnThongTinLayout);
		pnThongTinLayout
				.setHorizontalGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnThongTinLayout.createSequentialGroup()
								.addComponent(pnThongTinHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pnThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
		pnThongTinLayout
				.setVerticalGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(pnThongTinKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pnThongTinHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(pnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pnLapHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(pnThongTin, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
				.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pnThongTin, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(pnLapHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
	}// </editor-fold>//GEN-END:initComponents

	private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemKHActionPerformed
		jpnKhachHang pnKhachHang = new jpnKhachHang();
		pnKhachHang.getBtnBack().setVisible(true);
		MainFrame.setContentView(pnKhachHang);
		pnKhachHang.getTblDSKhachHang().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JTable table = pnKhachHang.getTblDSKhachHang();
				int selRow = table.getSelectedRow();
				if (e.getClickCount() == 2 && selRow >= 0) {
					int op = JOptionPane.showConfirmDialog(pnKhachHang,
							"Chọn Khách Hàng " + table.getValueAt(selRow, 1).toString().trim(), "Xác Nhận",
							JOptionPane.YES_NO_OPTION);
					if (op == JOptionPane.YES_OPTION) {
						khachHangMua = dao_KhachHang.getKhachHangTheoMa(table.getValueAt(selRow, 0).toString().trim());
						txtTenKH.setText(khachHangMua.getHoTen().trim());
						txtSoDienThoai.setText(khachHangMua.getDiaChi().trim());
						if (khachHangMua != null)
							tinhGiamGia(khachHangMua.getDiemTichLuy());
						MainFrame.setContentView(MainFrame.getLapHoaDon());

					}
				}
			}
		});
	}// GEN-LAST:event_btnThemKHActionPerformed

	private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {// GEN-FIRST:event_btnThanhToanActionPerformed
		if (tblSanPham.getRowCount() <= 0) {
			JOptionPane.showMessageDialog(this, "Chưa có sản phẩm nào !");
		} else {
			String maHD = txtMaHoaDon.getText().trim();
			Date ngayLap = new SimpleDateFormat("yyyy-MM-dd").parse(txtNgayLap.getText());
			String GiamGia = txtDaGiam.getText();
			Double khachDua = 0.0;
			Pattern p = Pattern.compile("^\\d{1,}$");
			Matcher m = p.matcher(txtKhachDua.getText().trim());
			boolean check = m.find();
			if (!check)
				JOptionPane.showMessageDialog(this, "Hãy nhập chữ số");
			else if (!txtKhachDua.getText().trim().isEmpty())
				khachDua = Double.valueOf(txtKhachDua.getText().trim());
			Double tienThua = khachDua - tongTien;
			if (khachHangMua == null) {
				JOptionPane.showMessageDialog(this, "Chưa có thông tin khách hàng !");
			} else {

				HoaDon hoaDon = new HoaDon(maHD, ngayLap, GiamGia, nhanVien, khachHangMua,
						Float.valueOf(tongTien + ""));

				if (tienThua >= 0) {
					ArrayList<SanPham> dsSanPhamMua = new ArrayList<>();
					int slRow = tblSanPham.getRowCount();
					String thongBaoSoLuong = "";
					for (int i = 0; i < slRow; i++) {
						SanPham sp = dao_SanPham.getSanPhamTheoMa(tblSanPham.getValueAt(i, 0).toString().trim());
						dsSanPhamMua.add(sp);
						int sl = Integer.parseInt(tblSanPham.getValueAt(i, 4).toString().trim());
						if (sp.getSoLuong() < sl) {
							thongBaoSoLuong += "Sản phẩm " + sp.getMaSanPham().trim() + " Không đủ số lượng tồn ! \n";
						}
					}
					if (thongBaoSoLuong.isEmpty()) {

						if (dao_HoaDon.themHoaDon(hoaDon)) {
							int j = 0;
							for (SanPham sanPham : dsSanPhamMua) {
								int sl = Integer.parseInt(tblSanPham.getValueAt(j, 4).toString().trim());
								j++;
								CTHoaDon ctHoaDon = new CTHoaDon(hoaDon, sanPham, sl);
								dao_CTHoaDon.themCTHD(ctHoaDon);
								dao_SanPham.capNhatSoLuongTon(sanPham.getMaSanPham().trim(), sl);
							}
							dao_KhachHang.capNhatDiemTichLuy(khachHangMua.getMaKhachHang().trim(), quyDoiDiemTichLuy());
							setThongTinlapHoaDon("");
							tongTien = 0;
							txtTenKH.setText("");
							txtSoDienThoai.setText("");
							txtTenSanPham.setText("");
							txtMaSanPham.setText("");
							txtDonGia.setText("");
							txtGiamGia.setText("");
							txtSoLuong.setText("");
							txtDaGiam.setText(convertCurrencyVN(0));
							txtTongTien.setText(convertCurrencyVN(0));
							txtKhachDua.setText("");
							txtTienThua.setText(convertCurrencyVN(0));
							txtDonViTinh.setText("");
							khachHangMua = null;
							int row = tblSanPham.getRowCount();
							for (int i = 0; i < row; i++) {
								tblModelSanPham.removeRow(0);
							}
							JOptionPane.showMessageDialog(this, "Hoàn Thành !");
							new frmXuatHoaDon(hoaDon).setVisible(true);

						} else {
							JOptionPane.showMessageDialog(this, "Thanh Toán Thất Bại !");

						}
					} else
						JOptionPane.showMessageDialog(this, thongBaoSoLuong);
				} else
					JOptionPane.showMessageDialog(this, "Vui lòng trả đủ số tiền !");
			}
		}
	}// GEN-LAST:event_btnThanhToanActionPerformed

	private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCapNhatActionPerformed
		if (txtSoLuong.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Chưa nhập số lượng !");
		} else {
			int sl = Integer.parseInt(txtSoLuong.getText().trim());
			if (sl > 0) {
				double gia = Double.valueOf(tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 3).toString());
				tblModelSanPham.setValueAt(sl, tblSanPham.getSelectedRow(), 4);
				tblModelSanPham.setValueAt((sl * gia), tblSanPham.getSelectedRow(), 6);
				if (khachHangMua != null)
					tinhGiamGia(khachHangMua.getDiemTichLuy());
				tinhTongThanhTien();
				tinhTienThua();
			} else
				JOptionPane.showMessageDialog(this, "Số Lượng Phải Lớn Hơn 0");
		}
	}// GEN-LAST:event_btnCapNhatActionPerformed

	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCapNhatActionPerformed
		int sel = tblSanPham.getSelectedRow();
		if (sel < 0) {
			JOptionPane.showMessageDialog(this, "Chọn sản phẩm cần xóa");
		} else {
			tblModelSanPham.removeRow(sel);
			txtTenSanPham.setText("");
			txtMaSanPham.setText("");
			txtDonGia.setText("");
			txtSoLuong.setText("");
			txtDaGiam.setText("");
			txtDonViTinh.setText("");
			cboLoaiSanPham.setSelectedIndex(0);
			if (khachHangMua != null)
				tinhGiamGia(khachHangMua.getDiemTichLuy());
			tinhTongThanhTien();
			tinhTienThua();
		}
	}// GEN-LAST:event_btnCapNhatActionPerformed

	private void btnThemHangDoiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemHangDoiActionPerformed
		String maHD = txtMaHoaDon.getText().trim();
		String ngayLap = txtNgayLap.getText().trim();
		dsHangDoi.add(new HangDoi(maHD, ngayLap, nhanVien, khachHangMua, getDSSanPhamMuaTrenHoaDon()));

		setThongTinlapHoaDon("T");
		tongTien = 0;
		txtTenKH.setText("");
		txtSoDienThoai.setText("");
		txtTenSanPham.setText("");
		txtMaSanPham.setText("");
		txtDonGia.setText("");
		txtGiamGia.setText("");
		txtSoLuong.setText("");
		txtDaGiam.setText(convertCurrencyVN(0));
		txtTongTien.setText(convertCurrencyVN(0));
		txtKhachDua.setText("");
		txtTienThua.setText(convertCurrencyVN(0));
		txtDonViTinh.setText("");
		khachHangMua = null;
		int row = tblSanPham.getRowCount();
		for (int i = 0; i < row; i++) {
			tblModelSanPham.removeRow(0);
		}

		JOptionPane.showMessageDialog(this, "Đã Thêm Vào Hàng Đợi");
	}// GEN-LAST:event_btnThemHangDoiActionPerformed

	private void btnMoHangDoiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMoHangDoiActionPerformed
		if (dsHangDoi.size() <= 0)
			JOptionPane.showMessageDialog(this, "Chưa có hóa đơn trong hàng đợi");
		else {
			frmHangDoi hangDoi_gui = new frmHangDoi(dsHangDoi);
			hangDoi_gui.setVisible(true);
			JTable tblHangDoi = hangDoi_gui.getTable();
			tblHangDoi.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					int selRow = tblHangDoi.getSelectedRow();
					if (e.getClickCount() == 2 && selRow >= 0) {
						int op = JOptionPane.showConfirmDialog(hangDoi_gui, "Thanh Toán Hóa Đơn Này", "Xác Nhận",
								JOptionPane.YES_NO_OPTION);
						if (op == JOptionPane.YES_OPTION) {
							String maHDChon = tblHangDoi.getValueAt(selRow, 0).toString();
							for (HangDoi hd : dsHangDoi) {
								if (hd.getMaHD().equalsIgnoreCase(maHDChon)) {

									clearForm();
									txtMaHoaDon.setText(hd.getMaHD());
									txtNgayLap.setText(hd.getNgayLap());
									getThongTinNhanVien();
									khachHangMua = hd.getKhachHang();
									txtTenKH.setText(khachHangMua.getHoTen().trim());
									txtSoDienThoai.setText(khachHangMua.getDiaChi().trim());
									if (khachHangMua != null)
										tinhGiamGia(khachHangMua.getDiemTichLuy());
									for (SanPhamMuaTrenHoaDon sanPham : hd.getDsSanPhamMua()) {
										Object[] row = { sanPham.getMaSP(), sanPham.getTenSP(), sanPham.getDonViTinh(),
												sanPham.getDonGia(), sanPham.getSoLuong(), txtGiamGia.getText(),
												sanPham.getThanhTien() };
										tblModelSanPham.addRow(row);
									}
									tinhTongThanhTien();
									tinhTienThua();
									dsHangDoi.remove(hd);
									hangDoi_gui.dispose();

								}
							}

						}
					}
				}
			});

		}
	}// GEN-LAST:event_btnMoHangDoiActionPerformed

	private void clearForm() {
		tongTien = 0;
		txtTenKH.setText("");
		txtSoDienThoai.setText("");
		txtTenSanPham.setText("");
		txtMaSanPham.setText("");
		txtDonGia.setText("");
		txtGiamGia.setText("");
		txtSoLuong.setText("");
		txtDaGiam.setText(convertCurrencyVN(0));
		txtTongTien.setText(convertCurrencyVN(0));
		txtKhachDua.setText("");
		txtTienThua.setText(convertCurrencyVN(0));
		txtDonViTinh.setText("");
		khachHangMua = null;
		int row = tblSanPham.getRowCount();
		for (int i = 0; i < row; i++) {
			tblModelSanPham.removeRow(0);
		}
	}

	private void getThongTinNhanVien() {

		txtTenNV.setText(nhanVien.getHoTen().trim());
		txtLoaiNV.setText(nhanVien.getLoai().getTenLoai().trim());
	}

	private ArrayList<SanPhamMuaTrenHoaDon> getDSSanPhamMuaTrenHoaDon() {
		ArrayList<SanPhamMuaTrenHoaDon> dsSanPhamMua = new ArrayList<>();
		int rowCount = tblSanPham.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			String maSP = tblSanPham.getValueAt(i, 0).toString().trim();
			String tenSP = tblSanPham.getValueAt(i, 1).toString().trim();
			String donViTinh = tblSanPham.getValueAt(i, 2).toString().trim();
			double donGia = Double.valueOf(tblSanPham.getValueAt(i, 3).toString().trim());
			int sl = Integer.parseInt(tblSanPham.getValueAt(i, 4).toString().trim());
			double thanhTien = Double.valueOf(tblSanPham.getValueAt(i, 6).toString().trim());
			dsSanPhamMua.add(new SanPhamMuaTrenHoaDon(maSP, tenSP, donViTinh, sl, donGia, thanhTien));
		}
		return dsSanPhamMua;
	}

	private void refresh() {
		arrListSanPham = dao_SanPham.getALLSanPham();
		jlistSanPham = createListProducts(arrListSanPham);
		loadDanhSachSanPham(jlistSanPham);

	}

	private void addRowToTable(SanPham sanPham, int sl) {
		Double gia = Double.valueOf(sanPham.getDonGia());
		Double thanhTien = gia * sl;
		Object[] row = { sanPham.getMaSanPham().trim(), sanPham.getTenSanPham().trim(), sanPham.getDonViTinh(), gia, sl,
				txtGiamGia.getText().trim(), thanhTien };
		tblModelSanPham.addRow(row);
		if (khachHangMua != null)
			tinhGiamGia(khachHangMua.getDiemTichLuy());
		tinhTongThanhTien();
		tinhTienThua();
	}

	private void clickToTable() {
		int sel = tblSanPham.getSelectedRow();
		txtMaSanPham.setText(tblModelSanPham.getValueAt(sel, 0).toString());
		txtTenSanPham.setText(tblModelSanPham.getValueAt(sel, 1).toString());
		txtDonViTinh.setText(tblModelSanPham.getValueAt(sel, 2).toString());
		txtDonGia.setText(tblModelSanPham.getValueAt(sel, 3).toString());
		txtSoLuong.setText(tblModelSanPham.getValueAt(sel, 4).toString());
		txtGiamGia.setText(tblModelSanPham.getValueAt(sel, 5).toString());
		cboLoaiSanPham.setSelectedItem(dao_SanPham.getSanPhamTheoMa(tblModelSanPham.getValueAt(sel, 0).toString())
				.getLoai().getTenLoai().trim());
	}

	private void setThongTinlapHoaDon(String key) {
		phatSinhMaHoaDon(key);
		txtNgayLap.setText(LocalDate.now().toString());
	}

	private JList<SanPham> createListProducts(ArrayList<SanPham> listProducts) {

		DefaultListModel<SanPham> model = new DefaultListModel<>();
		for (SanPham sanPham : listProducts) {
			model.addElement(sanPham);
		}
		JList<SanPham> list = new JList<SanPham>(model);
		list.setCellRenderer(new ProductsRenderer());
		return list;
	}

	private JPanel createProductsPanel(JList<SanPham> jlSanPham) {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		JScrollPane jscListSanPham = new JScrollPane(jlSanPham);
		panel.add(jscListSanPham, BorderLayout.CENTER);
		return panel;
	}

	private void loadDanhSachSanPham(JList<SanPham> jlSanPham) {
		pnSanPham.removeAll();
		pnSanPham.setLayout(new BorderLayout());
		pnSanPham.add(createProductsPanel(jlSanPham), BorderLayout.CENTER);
		pnSanPham.validate();
		pnSanPham.repaint();
		jlSanPham.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				boolean flag = false;
				if (khachHangMua == null) {
					JOptionPane.showMessageDialog(getRootPane().getParent(), "Chưa có thông tin khách hàng !");
				} else {
					SanPham sanPhamSel = jlSanPham.getSelectedValue();
					String inSoLuong = JOptionPane.showInputDialog("Số Lượng");
					if (inSoLuong != null) {
						Pattern p = Pattern.compile("^\\d{1,}$");
						Matcher m = p.matcher(inSoLuong);
						boolean check = m.find();
						if (!check) {
							JOptionPane.showMessageDialog(getRootPane().getParent(), "Hãy nhập chữ số !");
						} else if (inSoLuong != null) {
							if (!inSoLuong.trim().isEmpty()) {
								int soLuong = Integer.parseInt(inSoLuong);
								if (soLuong > 0) {
									for (int i = 0; i < tblSanPham.getRowCount(); i++) {
										if (sanPhamSel.getMaSanPham().trim()
												.equalsIgnoreCase(tblSanPham.getValueAt(i, 0).toString().trim())) {
											int slHienTai = Integer.parseInt(tblSanPham.getValueAt(i, 4).toString());
											tblSanPham.setValueAt(slHienTai + soLuong, i, 4);
											Double gia = Double.valueOf(sanPhamSel.getDonGia());
											Double thanhTien = gia * (slHienTai + soLuong);
											tblSanPham.setValueAt(thanhTien, i, 6);
											if (khachHangMua != null)
												tinhGiamGia(khachHangMua.getDiemTichLuy());
											tinhTongThanhTien();
											tinhTienThua();
											flag = true;

										}
									}

									if (!flag) {
										addRowToTable(sanPhamSel, soLuong);
										flag = false;
									}

								} else {
									JOptionPane.showMessageDialog(getRootPane().getParent(),
											"Nhập Số Lượng Lớn Hơn 0 !");

									flag = false;
								}
							}
						}

					}
				}
			}
		});

	}

	private void phatSinhMaHoaDon(String key) {
		String maHDCuoiCung = dao_HoaDon.getMaHDCuoiCung().trim();
		String[] slHD = maHDCuoiCung.split("D", 2);
		int sl = Integer.parseInt(slHD[1].toString().trim());
		int slMaHD = (key.equalsIgnoreCase("T")) ? sl + (dsHangDoi.size() + 1) : sl + 1;

		String maHD = "HD";
		if (slMaHD < 10) {
			maHD += "00" + slMaHD;
		} else if (slMaHD < 100) {
			maHD += "0" + slMaHD;
		} else
			maHD += "" + slMaHD;

		txtMaHoaDon.setText(maHD);

	}

	private void timKiemSanPham(String key) {
		JList<SanPham> rsList = null;
		ArrayList<SanPham> arrSanPham = dao_SanPham.search(key);
		if (!arrSanPham.isEmpty()) {
			rsList = createListProducts(arrSanPham);
			loadDanhSachSanPham(rsList);
		}

	}

	private int quyDoiDiemTichLuy() {
		return (int) ((tongTien / 100000) * 10);
	}

	private void tinhTongThanhTien() {
		int slRow = tblSanPham.getRowCount();
		tongTien = 0;
		for (int i = 0; i < slRow; i++) {
			tongTien += Double.parseDouble(tblSanPham.getValueAt(i, 6).toString());
		}
		if (!txtGiamGia.getText().trim().isEmpty()) {
			Double giamgia = Double.valueOf(txtGiamGia.getText().trim());
			Double daGiam = tongTien * giamgia / 100;
			txtDaGiam.setText(convertCurrencyVN(daGiam));
			tongTien = tongTien - daGiam;
		}
		txtTongTien.setText(convertCurrencyVN(tongTien));
		txtKhachDua.setText(Double.toString(tongTien));
	}

	private void tinhTienThua() {
		if (!txtKhachDua.getText().trim().isEmpty()) {
			Double khachDua = Double.parseDouble(txtKhachDua.getText().trim());
			Double tienThua = khachDua - tongTien;
			txtTienThua.setText(convertCurrencyVN(tienThua));
		}

	}

	private void loadComboBox() {
		DAO_Loai dao_Loai = new DAO_Loai();
		ArrayList<Loai> loais = dao_Loai.getAllLoai();
		for (Loai loai : loais) {
			cboLoaiSanPham.addItem(loai.getTenLoai().trim());
		}
	}

	private void tinhGiamGia(int diemTichLuy) {
		if (khachHangMua != null) {
			if (khachHangMua.getDiemTichLuy() < 200) {
				txtGiamGia.setText("0");
			} else if (khachHangMua.getDiemTichLuy() < 300) {
				txtGiamGia.setText("5");
			} else if (khachHangMua.getDiemTichLuy() < 500) {
				txtGiamGia.setText("10");
			} else
				txtGiamGia.setText("20");
		}
	}

	public double getTongTien() {
		return tongTien;
	}

	public static ArrayList<HangDoi> getDSHangDoi() {
		return dsHangDoi;
	}

	private String convertCurrencyVN(double vnd) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		return currencyVN.format(vnd);

	}
}
