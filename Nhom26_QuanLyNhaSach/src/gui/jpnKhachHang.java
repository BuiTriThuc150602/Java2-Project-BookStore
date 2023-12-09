/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DAO_KhachHang;
import entity.HoaDon;
import entity.KhachHang;
import imageHepler.ImageIOHelper;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

/**
 *
 * @author Trí Thức
 */
public class jpnKhachHang extends javax.swing.JPanel {

	private DAO_KhachHang dao_KhachHang = new DAO_KhachHang();
	private ArrayList<KhachHang> listKhachHang = splashScreen.arrListKhachHang;
	private byte[] hinhAnhKH;

	/**
	 * Creates new form jpnKhachHang
	 */
	public jpnKhachHang() {
		initComponents();
		tblDSKhachHangModel = (DefaultTableModel) tblDSKhachHang.getModel();

		loadDataToTable(listKhachHang);
		tblDSKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectRowTable(e);
			}
		});

		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				timKiemKhachHang(txtTimKiem.getText().trim());
			}
		});

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel4 = new javax.swing.JPanel();
		pnThongTin = new javax.swing.JPanel();
		pnHinhAnh = new javax.swing.JPanel();
		lblHinhAnh = new javax.swing.JLabel();
		pnThongTinKH = new javax.swing.JPanel();
		lblMaKhachHang = new javax.swing.JLabel();
		lblHoTen = new javax.swing.JLabel();
		lblSoDienThoai = new javax.swing.JLabel();
		lblDiaChi = new javax.swing.JLabel();
		lblDiemTichLuy = new javax.swing.JLabel();
		txtMaKhachHang = new javax.swing.JTextField();
		txtMaKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtHoTen = new javax.swing.JTextField();
		txtHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtSoDienThoai = new javax.swing.JTextField();
		txtSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtDiaChi = new javax.swing.JTextField();
		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtDiemTichLuy = new javax.swing.JTextField();
		txtDiemTichLuy.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtTimKiem = new javax.swing.JTextField();
		txtTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTimKiem = new javax.swing.JLabel();
		pnDanhSach = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblDSKhachHang = new javax.swing.JTable();
		pnChucNang = new javax.swing.JPanel();
		btnThemKhachHang = new javax.swing.JButton();
		btnCapNhat = new javax.swing.JButton();
		btnXoa = new javax.swing.JButton();

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));

		setBackground(new java.awt.Color(255, 255, 204));
		pnChucNang.setBackground(new java.awt.Color(255, 255, 204));
		pnDanhSach.setBackground(new java.awt.Color(255, 255, 204));
		pnHinhAnh.setBackground(new java.awt.Color(255, 255, 204));
		pnThongTin.setBackground(new java.awt.Color(255, 255, 204));
		pnThongTinKH.setBackground(new java.awt.Color(255, 255, 204));

		pnThongTin.setPreferredSize(new java.awt.Dimension(992, 266));

		pnHinhAnh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ảnh Khách Hàng",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
		pnHinhAnh.setPreferredSize(new java.awt.Dimension(267, 24));

		javax.swing.GroupLayout pnHinhAnhLayout = new javax.swing.GroupLayout(pnHinhAnh);
		pnHinhAnh.setLayout(pnHinhAnhLayout);
		pnHinhAnhLayout.setHorizontalGroup(
				pnHinhAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblHinhAnh,
						javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 257,
						Short.MAX_VALUE));
		pnHinhAnhLayout.setVerticalGroup(pnHinhAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(lblHinhAnh, javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pnThongTinKH.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Khách Hàng",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
		pnThongTinKH.setFocusable(false);
		pnThongTinKH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		pnThongTinKH.setPreferredSize(new java.awt.Dimension(715, 262));

		lblMaKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblMaKhachHang.setText("Mã Khách Hàng");

		lblHoTen.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblHoTen.setText("Họ Tên");

		lblSoDienThoai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblSoDienThoai.setText("Số Điện Thoại");

		lblDiaChi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblDiaChi.setText("Địa Chỉ");

		lblDiemTichLuy.setFont(new Font("Times New Roman", Font.BOLD, 14)); // NOI18N
		lblDiemTichLuy.setText("Điểm Tích Lũy");

		lblTimKiem.setIcon(new javax.swing.ImageIcon("img//search_icon.png")); // NOI18N
		javax.swing.GroupLayout pnThongTinKHLayout = new javax.swing.GroupLayout(pnThongTinKH);
		pnThongTinKH.setLayout(pnThongTinKHLayout);
		pnThongTinKHLayout.setHorizontalGroup(pnThongTinKHLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnThongTinKHLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblMaKhachHang).addComponent(lblHoTen).addComponent(lblSoDienThoai)
								.addComponent(lblDiaChi)
								.addComponent(lblTimKiem, javax.swing.GroupLayout.Alignment.TRAILING))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pnThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtTimKiem).addComponent(txtMaKhachHang).addComponent(txtHoTen)
								.addComponent(txtDiaChi)
								.addGroup(pnThongTinKHLayout.createSequentialGroup()
										.addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 242,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(lblDiemTichLuy)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(txtDiemTichLuy, javax.swing.GroupLayout.DEFAULT_SIZE, 224,
												Short.MAX_VALUE)))
						.addContainerGap()));
		pnThongTinKHLayout.setVerticalGroup(pnThongTinKHLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnThongTinKHLayout.createSequentialGroup().addGap(11, 11, 11)
						.addGroup(pnThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblMaKhachHang)
								.addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pnThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblHoTen).addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pnThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblSoDienThoai)
								.addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDiemTichLuy)
								.addComponent(txtDiemTichLuy, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(22, 22, 22)
						.addGroup(pnThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblDiaChi).addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
						.addGroup(pnThongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTimKiem))
						.addGap(24, 24, 24)));

		javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
		pnThongTin.setLayout(pnThongTinLayout);
		pnThongTinLayout.setHorizontalGroup(pnThongTinLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnThongTinLayout.createSequentialGroup()
						.addComponent(pnHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pnThongTinKH, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)));
		pnThongTinLayout.setVerticalGroup(pnThongTinLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnThongTinLayout.createSequentialGroup()
						.addGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(pnHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
								.addComponent(pnThongTinKH, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
						.addGap(0, 0, 0)));

		pnDanhSach.setPreferredSize(new java.awt.Dimension(456, 400));

		tblDSKhachHang.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Mã Khách Hàng", "Họ Tên", "Địa Chỉ", "Số Điện Thoại", "Điểm Tích Lũy", }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tblDSKhachHang.setPreferredSize(new Dimension(122, 420));

		jScrollPane1.setViewportView(tblDSKhachHang);

		javax.swing.GroupLayout pnDanhSachLayout = new javax.swing.GroupLayout(pnDanhSach);
		pnDanhSach.setLayout(pnDanhSachLayout);
		pnDanhSachLayout.setHorizontalGroup(pnDanhSachLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1));
		pnDanhSachLayout
				.setVerticalGroup(pnDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE));

		pnChucNang.setPreferredSize(new java.awt.Dimension(988, 69));

		btnThemKhachHang.setBackground(new java.awt.Color(76, 175, 80));
		btnThemKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		btnThemKhachHang.setForeground(new java.awt.Color(255, 255, 255));
		btnThemKhachHang.setText("Thêm Khách Hàng");
		btnThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnThemKhachHangActionPerformed(evt);
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		});

		btnCapNhat.setBackground(new java.awt.Color(76, 175, 80));
		btnCapNhat.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
		btnCapNhat.setText("Cập Nhật");
		btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnCapNhatActionPerformed(evt);
				} catch (HeadlessException | IOException e) {

					e.printStackTrace();
				}
			}
		});

		btnXoa.setBackground(new java.awt.Color(76, 175, 80));
		btnXoa.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		btnXoa.setForeground(new java.awt.Color(255, 255, 255));
		btnXoa.setText("Xóa");
		btnXoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnXoaActionPerformed(evt);
				} catch (HeadlessException | IOException e) {

					e.printStackTrace();
				}
			}
		});

		btnBack = new JButton();
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnThoat();

			}

		});
		btnBack.setText("Thoát");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnBack.setBackground(new Color(76, 175, 80));
		btnBack.setVisible(false);

		javax.swing.GroupLayout pnChucNangLayout = new javax.swing.GroupLayout(pnChucNang);
		pnChucNangLayout.setHorizontalGroup(pnChucNangLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(pnChucNangLayout.createSequentialGroup().addGap(26)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE).addGap(18)
						.addComponent(btnThemKhachHang, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnCapNhat, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE).addContainerGap()));
		pnChucNangLayout.setVerticalGroup(pnChucNangLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(pnChucNangLayout.createSequentialGroup().addGap(29).addGroup(pnChucNangLayout
						.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnThemKhachHang, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnChucNang.setLayout(pnChucNangLayout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(pnThongTin, GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
								.addComponent(pnDanhSach, GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
								.addComponent(pnChucNang, GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE))
						.addGap(0)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pnThongTin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pnDanhSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(pnChucNang, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)));
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents

	private void loadDataToTable(ArrayList<KhachHang> listKH) {
		tblDSKhachHangModel.getDataVector().removeAllElements();
		for (KhachHang khachHang : listKH) {
			Object[] row = { khachHang.getMaKhachHang().trim(), khachHang.getHoTen().trim(),khachHang.getDiaChi(), khachHang.getSoDT(),
					 khachHang.getDiemTichLuy() };
			tblDSKhachHangModel.addRow(row);
		}
		tblDSKhachHang.updateUI();
	}

	private void btnThoat() {
		MainFrame.setContentView(MainFrame.getLapHoaDon());
	}

	private void btnThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) throws IOException {// GEN-FIRST:event_btnThemKhachHangActionPerformed
		if (btnThemKhachHang.getText().equalsIgnoreCase("Thêm khách hàng")) {
			clearForm();
			btnCapNhat.setText("Chọn Ảnh");
			btnXoa.setText("Hủy");
			btnThemKhachHang.setText("Lưu khách hàng");
			phatSinhMa();
		} else {
			if (themKhachHang()) {
				clearForm();
				JOptionPane.showMessageDialog(this, "Thêm Thành Công !");
				loadDataToTable(dao_KhachHang.getAllKhachHang());
				btnThemKhachHang.setText("Thêm Khách Hàng");
				btnXoa.setText("Xóa");
				btnCapNhat.setText("Cập Nhật");
			} else
				JOptionPane.showMessageDialog(this, "Thêm Thất bại !");
		}

	}// GEN-LAST:event_btnThemKhachHangActionPerformed

	private boolean themKhachHang() throws IOException {
		KhachHang kh = revertKhachHang();
		if (dao_KhachHang.themKhachHang(kh)) {
			tblDSKhachHangModel.getDataVector().removeAllElements();
			loadDataToTable(listKhachHang);
			return true;
		}
		return false;
	}

	private void phatSinhMa() {
		ArrayList<KhachHang> list = dao_KhachHang.getAllKhachHang();
		String mKHCuoiCung = list.get(list.size() - 1).getMaKhachHang();
		String[] slKH = mKHCuoiCung.split("H", 2);
		int sl = Integer.parseInt(slKH[1].toString().trim()) + 1;

		String maKH = "KH";
		if (sl < 10) {
			maKH += "00" + sl;
		} else if (sl < 100) {
			maKH += "0" + sl;
		} else
			maKH += "" + sl;

		txtMaKhachHang.setText(maKH);

	}

	private KhachHang revertKhachHang() {
		String maKH = txtMaKhachHang.getText().trim();
		String tenKH = txtHoTen.getText().trim();
		String sdt = txtSoDienThoai.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String diem = txtDiemTichLuy.getText().trim();
		int diemTichLuy = 0;
		Pattern p = Pattern.compile("^\\d{1,}$");
		Matcher m = p.matcher(diem);
		boolean check = m.find();
		if (diem.isEmpty() || !check) {
			JOptionPane.showMessageDialog(this, "Điểm tích lũy là số");
		} else {
			diemTichLuy = Integer.parseInt(diem);
		}
		ImageIcon ico = new ImageIcon(hinhAnhKH);
		Image img = ico.getImage();

		KhachHang kh = new KhachHang(maKH, tenKH, diaChi, sdt, diemTichLuy, img);
		return kh;
	}

	private void clearForm() {
		lblHinhAnh.setIcon(null);
		txtDiaChi.setText("");
		txtDiemTichLuy.setText("");
		txtHoTen.setText("");
		txtSoDienThoai.setText("");
		txtMaKhachHang.setText("");

	}

	public File chooserImage() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Hinh anh", "jpg", "png");
		chooser.setFileFilter(extensionFilter);
		chooser.setMultiSelectionEnabled(false);
		int index = chooser.showDialog(this, "Chọn File");
		if (index == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			return file;
		}
		return null;
	}

	private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, IOException {// GEN-FIRST:event_btnCapNhatActionPerformed
		// TODO add your handling code here:

		if (btnCapNhat.getText().trim().equalsIgnoreCase("Chọn Ảnh")) {
			File file = chooserImage();
			ImageIcon ico = new ImageIcon(file.getAbsolutePath());
			Image img = ImageIOHelper.resize(ico.getImage(), lblHinhAnh.getWidth(), lblHinhAnh.getHeight());
			ImageIcon reIco = new ImageIcon(img);
			lblHinhAnh.setIcon(reIco);
			hinhAnhKH = ImageIOHelper.toByteArray(reIco.getImage(), "png");
		} else {
			if (updateKhachHang()) {
				JOptionPane.showMessageDialog(this, "Cập nhập thành công!!!");
			} else
				JOptionPane.showMessageDialog(this, "Cập nhập thất bại!!!");
		}
	}

	private boolean updateKhachHang() throws IOException {
		// TODO Auto-generated method stubNhanVien nv = revertNhanVien();
		KhachHang kh = revertKhachHang();
		if (dao_KhachHang.suaKhachHang(kh)) {
			loadDataToTable(dao_KhachHang.getAllKhachHang());
			return true;
		}
		return false;
	}// GEN-LAST:event_btnCapNhatActionPerformed

	private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, IOException {// GEN-FIRST:event_btnXoaActionPerformed
		// TODO add your handling code here:
		if (btnXoa.getText().equalsIgnoreCase("Xóa")) {
			int n = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không?", "Xóa",
					JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				if (xoaKhachHang()) {
					clearForm();
					JOptionPane.showMessageDialog(this, "Xoa thanh cong!!!");
				} else
					JOptionPane.showMessageDialog(this, "Xoa that bai!!!");
			}
		} else {
			clearForm();
			btnThemKhachHang.setText("Thêm Khách Hàng");
			btnXoa.setText("Xóa");
			btnCapNhat.setText("Cập Nhật");
		}
	}// GEN-LAST:event_btnXoaActionPerformed

	private boolean xoaKhachHang() throws IOException {
		// TODO Auto-generated method stub
		String ma = tblDSKhachHang.getValueAt(tblDSKhachHang.getSelectedRow(), 0).toString().trim();
		if (dao_KhachHang.xoaKhachHang(ma)) {
			tblDSKhachHangModel.getDataVector().removeAllElements();
			loadDataToTable(dao_KhachHang.getAllKhachHang());
			return true;
		}
		return false;
	}

	private void selectRowTable(MouseEvent e) {
		int index = tblDSKhachHang.getSelectedRow();
		txtMaKhachHang.setText(tblDSKhachHang.getValueAt(index, 0).toString());
		txtHoTen.setText(tblDSKhachHang.getValueAt(index, 1).toString());
		txtDiaChi.setText((String) tblDSKhachHang.getValueAt(index, 2));
		txtSoDienThoai.setText((String) tblDSKhachHang.getValueAt(index, 3));
		txtDiemTichLuy.setText(tblDSKhachHang.getValueAt(index, 4).toString());

		KhachHang kh = dao_KhachHang.getKhachHangTheoMa(tblDSKhachHang.getValueAt(index, 0).toString());
		Image img = ImageIOHelper.resize(kh.getHinhAnh(), lblHinhAnh.getWidth(), lblHinhAnh.getHeight());
		try {
			hinhAnhKH = ImageIOHelper.toByteArray(img, "png");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		lblHinhAnh.setIcon(new ImageIcon(img));

	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public JTable getTblDSKhachHang() {
		return tblDSKhachHang;
	}

	private void timKiemKhachHang(String key) {
		ArrayList<KhachHang> listKH = dao_KhachHang.search(key);
		if (!listKH.isEmpty()) {
			tblDSKhachHangModel.getDataVector().removeAllElements();
			loadDataToTable(listKH);
		}
		else {
			tblDSKhachHangModel.getDataVector().removeAllElements();
			loadDataToTable(listKhachHang);
		}

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnCapNhat;
	private javax.swing.JButton btnThemKhachHang;
	private javax.swing.JButton btnXoa;
	private javax.swing.JButton btnBack;
	private javax.swing.JLabel lblTimKiem;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField txtTimKiem;
	private javax.swing.JLabel lblDiaChi;
	private javax.swing.JLabel lblDiemTichLuy;
	private javax.swing.JLabel lblHinhAnh;
	private javax.swing.JLabel lblHoTen;
	private javax.swing.JLabel lblMaKhachHang;
	private javax.swing.JLabel lblSoDienThoai;
	private javax.swing.JPanel pnChucNang;
	private javax.swing.JPanel pnDanhSach;
	private javax.swing.JPanel pnHinhAnh;
	private javax.swing.JPanel pnThongTin;
	private javax.swing.JPanel pnThongTinKH;
	private javax.swing.JTable tblDSKhachHang;
	private javax.swing.JTextField txtDiaChi;
	private javax.swing.JTextField txtDiemTichLuy;
	private javax.swing.JTextField txtHoTen;
	private javax.swing.JTextField txtMaKhachHang;
	private DefaultTableModel tblDSKhachHangModel;
	private javax.swing.JTextField txtSoDienThoai;
}
