/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import dao.DAO_LoaiNhanVien;
import dao.DAO_NhanVien;
import dao.DAO_TaiKhoan;
import entity.KhachHang;
import entity.LoaiNhanVien;
import entity.NhanVien;
import entity.PhanQuyen;
import entity.TaiKhoan;
import imageHepler.ImageIOHelper;

/**
 *
 * @author Trí Thức
 */
public class jpnNhanVien extends javax.swing.JPanel {
	/**
	 * Creates new form jpnNhanVien
	 */
	public jpnNhanVien() {
		initComponents();
		tblDSNhanVienModel = (DefaultTableModel) tblDSNhanVien.getModel();		
		loadDataToTable();
		loadDataToComboxBox();
		tblDSNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					selectRowTable(e);
				} catch (ParseException e1) {

					e1.printStackTrace();
				}
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
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		pnThongTin = new javax.swing.JPanel();
		pnHinhAnh = new javax.swing.JPanel();
		lblHinhAnh = new javax.swing.JLabel();
		pnThongTinNV = new javax.swing.JPanel();
		lblMaNV = new javax.swing.JLabel();
		lblTenNV = new javax.swing.JLabel();
		lblNgaySinh = new javax.swing.JLabel();
		lblDiaChi = new javax.swing.JLabel();
		txtMaNV = new javax.swing.JTextField();
		txtDiaChi = new javax.swing.JTextField();
		txtTenNV = new javax.swing.JTextField();
		txtNgaySinh = new com.toedter.calendar.JDateChooser();
		lblLoaiNhanVien = new javax.swing.JLabel();
		lblHeSo = new javax.swing.JLabel();
		lblLuong = new javax.swing.JLabel();
		lblNgayVaoLam = new javax.swing.JLabel();
		cboLuong = new javax.swing.JComboBox<>();
		cboHeSo = new javax.swing.JComboBox<>();
		cboLoaiNV = new javax.swing.JComboBox<>();
		txtNgayVaoLam = new com.toedter.calendar.JDateChooser();
		lblTimKiem = new javax.swing.JLabel();
		txtTimKiem = new javax.swing.JTextField();
		pnChucNang = new javax.swing.JPanel();
		btnThem = new javax.swing.JButton();
		btnXoa = new javax.swing.JButton();
		btnCapNhat = new javax.swing.JButton();
		cboSapXep = new javax.swing.JComboBox<>();
		lblSapXep = new javax.swing.JLabel();
		pnDanhSach = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblDSNhanVien = new javax.swing.JTable();

		setBackground(new java.awt.Color(255, 255, 204));

		pnChucNang.setBackground(new Color(255, 255, 204));
		pnDanhSach.setBackground(new Color(255, 255, 204));
		pnHinhAnh.setBackground(new Color(255, 255, 204));
		pnThongTin.setBackground(new Color(255, 255, 204));
		pnThongTinNV.setBackground(new Color(255, 255, 204));

		pnThongTin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		pnHinhAnh.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ảnh Nhân Viên",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

		javax.swing.GroupLayout pnHinhAnhLayout = new javax.swing.GroupLayout(pnHinhAnh);
		pnHinhAnh.setLayout(pnHinhAnhLayout);
		pnHinhAnhLayout.setHorizontalGroup(
				pnHinhAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(lblHinhAnh,
						javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE));
		pnHinhAnhLayout.setVerticalGroup(pnHinhAnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnHinhAnhLayout.createSequentialGroup()
						.addComponent(lblHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addContainerGap()));

		pnThongTinNV.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Nhân Viên",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

		lblMaNV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblMaNV.setText("Mã Nhân Viên");

		lblTenNV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblTenNV.setText("Tên Nhân Viên");

		lblNgaySinh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblNgaySinh.setText("Ngày Sinh");

		lblDiaChi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblDiaChi.setText("Địa Chỉ");

		txtMaNV.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		txtMaNV.setToolTipText("Mã nhân viên tự động phát sinh");
		txtMaNV.setEnabled(false);

		txtDiaChi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

		txtTenNV.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

		lblLoaiNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblLoaiNhanVien.setText("Loại Nhân Viên");

		lblHeSo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblHeSo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		lblHeSo.setText("Hệ Số Lương");

		lblLuong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblLuong.setText("Lương Cơ Bản");

		lblNgayVaoLam.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblNgayVaoLam.setText("Ngày Vào Làm");

		cboLuong.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

		cboHeSo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		cboHeSo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

		cboLoaiNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

		lblTimKiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblTimKiem.setIcon(new javax.swing.ImageIcon("img//search_icon.png")); // NOI18N

		javax.swing.GroupLayout pnThongTinNVLayout = new javax.swing.GroupLayout(pnThongTinNV);
		pnThongTinNV.setLayout(pnThongTinNVLayout);
		pnThongTinNVLayout.setHorizontalGroup(pnThongTinNVLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnThongTinNVLayout.createSequentialGroup().addContainerGap().addGroup(pnThongTinNVLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
						.addComponent(lblMaNV, javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(lblTenNV, javax.swing.GroupLayout.Alignment.LEADING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(lblNgaySinh, javax.swing.GroupLayout.Alignment.LEADING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(lblDiaChi, javax.swing.GroupLayout.Alignment.LEADING,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(pnThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnThongTinNVLayout.createSequentialGroup().addGroup(pnThongTinNVLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txtMaNV)
										.addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 203,
												Short.MAX_VALUE)
										.addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 203,
												Short.MAX_VALUE)
										.addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(82, 82, 82)
										.addGroup(pnThongTinNVLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(lblLoaiNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblLuong, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblNgayVaoLam, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblHeSo, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(pnThongTinNVLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(cboLuong, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(cboHeSo, javax.swing.GroupLayout.Alignment.TRAILING, 0,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(cboLoaiNV, javax.swing.GroupLayout.Alignment.TRAILING, 0,
														203, Short.MAX_VALUE)
												.addComponent(txtNgayVaoLam, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addComponent(txtTimKiem))
						.addContainerGap()));
		pnThongTinNVLayout.setVerticalGroup(pnThongTinNVLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnThongTinNVLayout.createSequentialGroup().addGap(20, 20, 20)
						.addGroup(pnThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(pnThongTinNVLayout.createSequentialGroup().addGap(1, 1, 1)
										.addGroup(pnThongTinNVLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(lblLoaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
														26, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(cboLoaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGap(18, 18, 18)
						.addGroup(pnThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnThongTinNVLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(pnThongTinNVLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(lblLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(cboLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(20, 20, 20)
						.addGroup(pnThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(pnThongTinNVLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(lblHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(cboHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(19, 19, 19)
						.addGroup(pnThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnThongTinNVLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNgayVaoLam, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(txtNgayVaoLam, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(20, 20, 20)
						.addGroup(pnThongTinNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblTimKiem).addComponent(txtTimKiem,
										javax.swing.GroupLayout.PREFERRED_SIZE, 26,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout pnThongTinLayout = new javax.swing.GroupLayout(pnThongTin);
		pnThongTin.setLayout(pnThongTinLayout);
		pnThongTinLayout
				.setHorizontalGroup(pnThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnThongTinLayout.createSequentialGroup()
								.addComponent(pnHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(pnThongTinNV, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnThongTinLayout.setVerticalGroup(pnThongTinLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pnHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(pnThongTinNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));

		pnChucNang.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		btnThem.setBackground(new java.awt.Color(76, 175, 80));
		btnThem.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
		btnThem.setForeground(new java.awt.Color(255, 255, 255));
		btnThem.setText("Thêm Nhân Viên");
		btnThem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					btnThemActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
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
				btnXoaActionPerformed(evt);
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
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		cboSapXep.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
		cboSapXep.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "Lương Cơ Bản", "Hệ Số Lương", "Ngày Vào Làm" }));

		lblSapXep.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
		lblSapXep.setText("Sắp Xếp Theo:");

		javax.swing.GroupLayout pnChucNangLayout = new javax.swing.GroupLayout(pnChucNang);
		pnChucNang.setLayout(pnChucNangLayout);
		pnChucNangLayout
				.setHorizontalGroup(pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnChucNangLayout.createSequentialGroup()
								.addComponent(lblSapXep, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(cboSapXep, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
								.addContainerGap()));
		pnChucNangLayout.setVerticalGroup(pnChucNangLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnChucNangLayout.createSequentialGroup().addContainerGap().addGroup(pnChucNangLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(cboSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(lblSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 53,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pnDanhSach.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		tblDSNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		tblDSNhanVien.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Mã Nhân Viên", "Họ Tên", "Ngày Sinh", "Địa Chỉ", "Loại Nhân Viên", "Lương Cơ bản",
				"Hệ Số Lương", "Ngày Vào Làm" }) {
			boolean[] canEdit = new boolean[] { false, true, false, true, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(tblDSNhanVien);

		javax.swing.GroupLayout pnDanhSachLayout = new javax.swing.GroupLayout(pnDanhSach);
		pnDanhSach.setLayout(pnDanhSachLayout);
		pnDanhSachLayout.setHorizontalGroup(pnDanhSachLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1));
		pnDanhSachLayout.setVerticalGroup(pnDanhSachLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 0)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(pnDanhSach, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pnThongTin, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(pnChucNang, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(0, 0, 0)
						.addComponent(pnThongTin, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pnDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(pnChucNang,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)));
	}// </editor-fold>//GEN-END:initComponents

	private void btnXoaActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		if (btnXoa.getText().equalsIgnoreCase("Xóa")) {
			int n = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không ?", "Xóa",
					JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				if (xoaNhanVien()) {

					JOptionPane.showMessageDialog(this, "Xóa Thành Công !");
					clearForm();
				} else
					JOptionPane.showMessageDialog(this, "Xóa Thất Bại !");
			}
		} else {
			btnThem.setText("Thêm Nhân Viên");
			btnCapNhat.setText("Cập Nhật");
			btnXoa.setText("Xóa");
		}
	}

	private boolean xoaNhanVien() {
		String maNV = tblDSNhanVien.getValueAt(tblDSNhanVien.getSelectedRow(), 0).toString().trim();
		if (dao_NhanVien.xoaNhanVien(maNV)) {
			tblDSNhanVienModel.getDataVector().removeAllElements();
			loadDataToTable();
			return true;
		}
		return false;
	}

	private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, IOException {// GEN-FIRST:event_btnCapNhatActionPerformed
		// TODO add your handling code here:
		if (btnCapNhat.getText().trim().equalsIgnoreCase("Chọn Ảnh")) {
			File file = chooserImage();
			ImageIcon ico = new ImageIcon(file.getAbsolutePath());
			Image img = ImageIOHelper.resize(ico.getImage(), lblHinhAnh.getWidth(), lblHinhAnh.getHeight());
			ImageIcon reIco = new ImageIcon(img);
			lblHinhAnh.setIcon(reIco);
			hinhAnhNV = ImageIOHelper.toByteArray(reIco.getImage(), "png");
		} else {
			if (updateNhanVien()) {
				JOptionPane.showMessageDialog(this, "Cập nhập thành công !");
			} else
				JOptionPane.showMessageDialog(this, "Cập nhập thất bại !");
		}

	}// GEN-LAST:event_btnCapNhatActionPerformed

	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) throws IOException {// GEN-FIRST:event_btnThemActionPerformed
		if (btnThem.getText().equalsIgnoreCase("Thêm Nhân Viên")) {
			clearForm();
			btnXoa.setText("Hủy");
			btnCapNhat.setText("Chọn Ảnh");
			btnThem.setText("Lưu Nhân Viên");
			phatSinhMa();
		} else {

			if (themNhanVien()) {
				phatSinhMa();
				clearForm();
				JOptionPane.showMessageDialog(this, "Thêm Thành Công !");
				btnCapNhat.setText("Cập Nhật");
				;
				btnThem.setText("Thêm Nhân Viên");
				btnXoa.setText("Xóa");
			} else
				JOptionPane.showMessageDialog(this, "Thêm Thất bại !");
		}

	}// GEN-LAST:event_btnThemActionPerformed

	private void phatSinhMa() {
		ArrayList<NhanVien> list = dao_NhanVien.getAllNhanVien();
		String mKHCuoiCung = list.get(list.size() - 1).getMaNhanVien();
		String[] slKH = mKHCuoiCung.split("V", 2);
		int sl = Integer.parseInt(slKH[1].toString().trim()) + 1;

		String maNV = "KH";
		if (sl < 10) {
			maNV += "00" + sl;
		} else if (sl < 100) {
			maNV += "0" + sl;
		} else
			maNV += "" + sl;

		txtMaNV.setText(maNV);

	}
//
//	private void setThongTinNhanVien() {
//		NhanVien nv = frmLogin.getNhanVienDangNhap();
//		txtMaNV.setText(nv.getMaNhanVien().trim());
//		txtTenNV.setText(nv.getHoTen().trim());
//		txtNgaySinh.setDate(nv.getNgaySinh());
//		txtNgayVaoLam.setDate(nv.getNgayVaoLam());
//		txtDiaChi.setText(nv.getDiaChi());
//		cboLoaiNV.setSelectedItem(nv.getLoai().getTenLoai());
//		cboLuong.setSelectedItem(nv.getLuongCoBan());
//		cboHeSo.setSelectedItem(nv.getHeSoLuong());
//		Image img = ImageIOHelper.resize(nv.getHinhAnh(), lblHinhAnh.getWidth(), lblHinhAnh.getHeight());
//		try {
//			hinhAnhNV = ImageIOHelper.toByteArray(img, "png");
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		lblHinhAnh.setIcon(new ImageIcon(img));
//	}

	private void loadDataToTable() {
		listNhanVien = new ArrayList<>();
		listNhanVien = dao_NhanVien.getAllNhanVien();
		for (NhanVien nhanVien : listNhanVien) {
			Object[] row = { nhanVien.getMaNhanVien().trim(), nhanVien.getHoTen().trim(), nhanVien.getNgaySinh(),
					nhanVien.getDiaChi().trim(), nhanVien.getLoai().getTenLoai().trim(), nhanVien.getLuongCoBan(),
					nhanVien.getHeSoLuong(), nhanVien.getNgayVaoLam() };
			tblDSNhanVienModel.addRow(row);
		}
	}

	private void loadDataToComboxBox() {
		ArrayList<LoaiNhanVien> dsLoaiNhanVien = dao_LoaiNhanVien.getAllLoaiNhanVien();
		for (LoaiNhanVien loaiNhanVien : dsLoaiNhanVien) {
			cboLoaiNV.addItem(loaiNhanVien.getTenLoai().trim());
		}
		ArrayList<NhanVien> dsNhanVien = dao_NhanVien.getAllNhanVien();
		for (NhanVien nhanVien : dsNhanVien) {
			if (!checkTonTai(cboLuong, nhanVien.getLuongCoBan()))
				cboLuong.addItem(nhanVien.getLuongCoBan());
			if (!checkTonTai(cboHeSo, nhanVien.getHeSoLuong()))
				cboHeSo.addItem(nhanVien.getHeSoLuong());
		}

	}

	private boolean checkTonTai(JComboBox<Object> cbo, Object item) {
		int size = cbo.getItemCount();
		for (int i = 0; i < size; i++) {
			if (cbo.getItemAt(i).toString().trim().equalsIgnoreCase(item.toString().trim()))
				return true;
		}
		return false;
	}

	private void clearForm() {
		lblHinhAnh.setIcon(null);
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtDiaChi.setText("");
		txtTimKiem.setText("");
		txtNgaySinh.setCalendar(null);
		txtNgayVaoLam.setCalendar(null);
		cboLoaiNV.setSelectedIndex(0);
		cboHeSo.setSelectedIndex(0);
		cboLuong.setSelectedIndex(0);
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

	private void selectRowTable(MouseEvent e) throws ParseException {
		int index = tblDSNhanVien.getSelectedRow();
		txtMaNV.setText(tblDSNhanVien.getValueAt(index, 0).toString());
		txtTenNV.setText(tblDSNhanVien.getValueAt(index, 1).toString());
		Date ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(tblDSNhanVien.getValueAt(index, 2).toString());
		Date ngayVaoLam = new SimpleDateFormat("yyyy-MM-dd").parse(tblDSNhanVien.getValueAt(index, 7).toString());
		txtNgaySinh.setDate(ngaySinh);
		txtNgayVaoLam.setDate(ngayVaoLam);
		txtDiaChi.setText(tblDSNhanVien.getValueAt(index, 3).toString());
		cboLoaiNV.setSelectedItem(tblDSNhanVien.getValueAt(index, 4).toString());
		cboLuong.setSelectedItem(tblDSNhanVien.getValueAt(index, 5));
		cboHeSo.setSelectedItem(tblDSNhanVien.getValueAt(index, 6).toString());
		NhanVien kh = dao_NhanVien.getNhanVienTheoMa(tblDSNhanVien.getValueAt(index, 0).toString());
		Image img = ImageIOHelper.resize(kh.getHinhAnh(), lblHinhAnh.getWidth(), lblHinhAnh.getHeight());
		try {
			hinhAnhNV = ImageIOHelper.toByteArray(img, "png");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		lblHinhAnh.setIcon(new ImageIcon(img));
	}

	private NhanVien revertNhanVien() {
		String maNV = txtMaNV.getText().trim();
		String tenNV = txtTenNV.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		Date ngaySinh = txtNgaySinh.getDate();
		Date ngayVaoLam = txtNgayVaoLam.getDate();
		float hsLuong = Float.parseFloat(cboHeSo.getSelectedItem().toString());
		int luong = Integer.parseInt(cboLuong.getSelectedItem().toString());
		LoaiNhanVien loaiNV = dao_LoaiNhanVien.getLoaiNhanVienTheoTen(cboLoaiNV.getSelectedItem().toString().trim());
		PhanQuyen quyen;
		if (cboLoaiNV.getSelectedItem().toString().trim().equalsIgnoreCase("Quản Lý")) {
			quyen = new PhanQuyen("PQ001", "Quản Lý");
		} else
			quyen = new PhanQuyen("PQ002", "Nhân Viên");
		TaiKhoan taiKhoan = new TaiKhoan(maNV, quyen, "", maNV, maNV);
		//
		ImageIcon ico = new ImageIcon(hinhAnhNV);
		Image img = ico.getImage();
		NhanVien nhanVien = new NhanVien(maNV, tenNV, diaChi, ngaySinh, ngayVaoLam, hsLuong, luong, loaiNV, taiKhoan,
				img);
		return nhanVien;
	}

	private boolean themNhanVien() throws IOException {
		NhanVien nhanVien = revertNhanVien();
		if (dao_NhanVien.themNhanVien(nhanVien)) {
			tblDSNhanVienModel.getDataVector().removeAllElements();
			loadDataToTable();
			return true;
		}
		return false;
	}

	private boolean updateNhanVien() throws IOException {
		NhanVien nv = revertNhanVien();
		if (dao_NhanVien.suaNhanVien(nv)) {
			tblDSNhanVienModel.getDataVector().removeAllElements();
			loadDataToTable();
			return true;
		}
		return false;
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnCapNhat;
	private javax.swing.JButton btnThem;
	private javax.swing.JButton btnXoa;
	private javax.swing.JComboBox<Object> cboHeSo;
	private javax.swing.JComboBox<String> cboLoaiNV;
	private javax.swing.JComboBox<Object> cboLuong;
	private javax.swing.JComboBox<String> cboSapXep;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lblDiaChi;
	private javax.swing.JLabel lblHeSo;
	private javax.swing.JLabel lblHinhAnh;
	private javax.swing.JLabel lblLoaiNhanVien;
	private javax.swing.JLabel lblLuong;
	private javax.swing.JLabel lblMaNV;
	private javax.swing.JLabel lblNgaySinh;
	private javax.swing.JLabel lblNgayVaoLam;
	private javax.swing.JLabel lblSapXep;
	private javax.swing.JLabel lblTenNV;
	private javax.swing.JLabel lblTimKiem;
	private javax.swing.JPanel pnChucNang;
	private javax.swing.JPanel pnDanhSach;
	private javax.swing.JPanel pnHinhAnh;
	private javax.swing.JPanel pnThongTin;
	private javax.swing.JPanel pnThongTinNV;
	private javax.swing.JTable tblDSNhanVien;
	private javax.swing.JTextField txtDiaChi;
	private javax.swing.JTextField txtMaNV;
	private com.toedter.calendar.JDateChooser txtNgaySinh;
	private com.toedter.calendar.JDateChooser txtNgayVaoLam;
	private javax.swing.JTextField txtTenNV;
	private javax.swing.JTextField txtTimKiem;
	// End of variables declaration//GEN-END:variables
	private DAO_NhanVien dao_NhanVien = new DAO_NhanVien();
	private DAO_LoaiNhanVien dao_LoaiNhanVien = new DAO_LoaiNhanVien();
	private DAO_TaiKhoan dao_TaiKhoan = new DAO_TaiKhoan();
	private ArrayList<NhanVien> listNhanVien;
	private DefaultTableModel tblDSNhanVienModel;
	private byte[] hinhAnhNV;
}
