/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.DAO_HoaDon;
import dao.DAO_NhanVien;
import entity.HoaDon;
import entity.NhanVien;

/**
 *
 * @author Trí Thức
 */
public class jpnThongKe extends javax.swing.JPanel {

	/**
	 * Creates new form jpnThongKe
	 */
	public jpnThongKe() {
		initComponents();
		tblModelNhanVien = (DefaultTableModel) tblDSNhanVien.getModel();
		loadDataToTable();
		tblDSNhanVien.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			clickTable();
			getDoanhThhuNhanVien();
		}
		});
		TongDoanhThu();
		
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

		pnContent = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblDSNhanVien = new javax.swing.JTable();
		jPanel1 = new javax.swing.JPanel();
		pnTTNhanVien = new javax.swing.JPanel();
		lblMaNV = new javax.swing.JLabel();
		lblTenNV = new javax.swing.JLabel();
		lblLoai = new javax.swing.JLabel();
		lblDienThoai = new javax.swing.JLabel();
		txtMaNV = new javax.swing.JTextField();
		txtTenNV = new javax.swing.JTextField();
		txtLoai = new javax.swing.JTextField();
		txtEmail = new javax.swing.JTextField();
		pnTongSoHD = new javax.swing.JPanel();
		lblTongDon = new javax.swing.JLabel();
		pnTongTien = new javax.swing.JPanel();
		lblTongTien = new javax.swing.JLabel();
		pnTongDoanhThu = new javax.swing.JPanel();
		lblDTNgay = new javax.swing.JLabel();
		pnTongDoanhThuThang = new javax.swing.JPanel();
		lblDTThang = new javax.swing.JLabel();

		pnContent.setBackground(new java.awt.Color(255, 255, 204));
		pnContent.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhân Viên",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

		tblDSNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		tblDSNhanVien.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Mã Nhân Viên", "Tên Nhân Viên", "Chức Vụ"}) {
			boolean[] canEdit = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(tblDSNhanVien);

		javax.swing.GroupLayout pnContentLayout = new javax.swing.GroupLayout(pnContent);
		pnContent.setLayout(pnContentLayout);
		pnContentLayout.setHorizontalGroup(
				pnContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(pnContentLayout
						.createSequentialGroup().addContainerGap().addComponent(jScrollPane1).addGap(7, 7, 7)));
		pnContentLayout.setVerticalGroup(pnContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnContentLayout.createSequentialGroup()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
						.addContainerGap()));

		jPanel1.setBackground(new java.awt.Color(255, 255, 204));
		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Doanh Thu",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

		pnTTNhanVien.setBackground(new java.awt.Color(255, 255, 204));
		pnTTNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhân Viên",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

		lblMaNV.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		lblMaNV.setText("Mã Nhân Viên");

		lblTenNV.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		lblTenNV.setText("Tên Nhân Viên");

		lblLoai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		lblLoai.setText("Chức Vụ");

		lblDienThoai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
		lblDienThoai.setText("Điện Thoại");

		txtMaNV.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

		txtTenNV.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

		txtLoai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

		txtEmail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

		javax.swing.GroupLayout pnTTNhanVienLayout = new javax.swing.GroupLayout(pnTTNhanVien);
		pnTTNhanVien.setLayout(pnTTNhanVienLayout);
		pnTTNhanVienLayout.setHorizontalGroup(pnTTNhanVienLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnTTNhanVienLayout.createSequentialGroup().addContainerGap().addGroup(pnTTNhanVienLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(lblDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
						.addGroup(pnTTNhanVienLayout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(lblLoai, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
								.addComponent(lblMaNV, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(pnTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnTTNhanVienLayout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(txtMaNV))
								.addGroup(pnTTNhanVienLayout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(txtTenNV))
								.addGroup(pnTTNhanVienLayout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(txtLoai))
								.addGroup(pnTTNhanVienLayout.createSequentialGroup()
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(txtEmail)))
						.addContainerGap()));
		pnTTNhanVienLayout.setVerticalGroup(pnTTNhanVienLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnTTNhanVienLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblMaNV).addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblTenNV).addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblLoai).addComponent(txtLoai, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnTTNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblDienThoai).addComponent(txtEmail,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pnTongSoHD.setBackground(new java.awt.Color(0, 204, 255));
		pnTongSoHD.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tổng hóa đơn trong tháng",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

		lblTongDon.setBackground(new java.awt.Color(0, 204, 255));
		lblTongDon.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblTongDon.setForeground(new java.awt.Color(255, 255, 255));
		lblTongDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		javax.swing.GroupLayout pnTongSoHDLayout = new javax.swing.GroupLayout(pnTongSoHD);
		pnTongSoHD.setLayout(pnTongSoHDLayout);
		pnTongSoHDLayout
				.setHorizontalGroup(pnTongSoHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(lblTongDon, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE));
		pnTongSoHDLayout
				.setVerticalGroup(pnTongSoHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(lblTongDon, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE));

		pnTongTien.setBackground(new java.awt.Color(51, 204, 255));
		pnTongTien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tổng Tiền",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

		lblTongTien.setBackground(new java.awt.Color(0, 204, 255));
		lblTongTien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblTongTien.setForeground(new java.awt.Color(255, 255, 255));
		lblTongTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		javax.swing.GroupLayout pnTongTienLayout = new javax.swing.GroupLayout(pnTongTien);
		pnTongTien.setLayout(pnTongTienLayout);
		pnTongTienLayout
				.setHorizontalGroup(pnTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE));
		pnTongTienLayout
				.setVerticalGroup(pnTongTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(lblTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE));

		pnTongDoanhThu.setBackground(new java.awt.Color(51, 102, 255));
		pnTongDoanhThu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tổng Doanh Thu Trong Ngày",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
		pnTongDoanhThu.setToolTipText("Tổng doanh thu trong ngày");

		lblDTNgay.setBackground(new java.awt.Color(51, 102, 255));
		lblDTNgay.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblDTNgay.setForeground(new java.awt.Color(255, 255, 255));
		lblDTNgay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		javax.swing.GroupLayout pnTongDoanhThuLayout = new javax.swing.GroupLayout(pnTongDoanhThu);
		pnTongDoanhThu.setLayout(pnTongDoanhThuLayout);
		pnTongDoanhThuLayout
				.setHorizontalGroup(pnTongDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(pnTongDoanhThuLayout.createSequentialGroup().addContainerGap().addComponent(lblDTNgay,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		pnTongDoanhThuLayout.setVerticalGroup(pnTongDoanhThuLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnTongDoanhThuLayout.createSequentialGroup().addComponent(lblDTNgay,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		pnTongDoanhThuThang.setBackground(new java.awt.Color(204, 102, 255));
		pnTongDoanhThuThang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tổng Doanh Thu Trong Tháng",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
		pnTongDoanhThuThang.setToolTipText("Tổng doanh thu trong Tháng");

		lblDTThang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		lblDTThang.setForeground(new java.awt.Color(255, 255, 255));
		lblDTThang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		javax.swing.GroupLayout pnTongDoanhThuThangLayout = new javax.swing.GroupLayout(pnTongDoanhThuThang);
		pnTongDoanhThuThang.setLayout(pnTongDoanhThuThangLayout);
		pnTongDoanhThuThangLayout.setHorizontalGroup(pnTongDoanhThuThangLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnTongDoanhThuThangLayout.createSequentialGroup().addContainerGap().addComponent(lblDTThang,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		pnTongDoanhThuThangLayout.setVerticalGroup(pnTongDoanhThuThangLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnTongDoanhThuThangLayout.createSequentialGroup().addComponent(lblDTThang,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(pnTongDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pnTTNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addComponent(pnTongSoHD, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(pnTongTien, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(pnTongDoanhThuThang, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(pnTTNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(pnTongSoHD, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(pnTongTien, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(pnTongDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(18, 18, 18).addComponent(pnTongDoanhThuThang, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pnContent, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel1,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pnContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
	}// </editor-fold>//GEN-END:initComponents

	private void loadDataToTable() {
		ArrayList<NhanVien> listNV = dao_NhanVien.getAllNhanVien();
		for (NhanVien nhanVien : listNV) {
			Object[] row = { nhanVien.getMaNhanVien().toString().trim(), nhanVien.getHoTen().toString().trim(),
					nhanVien.getLoai().getTenLoai().toString().trim() };
			tblModelNhanVien.addRow(row);

		}
	}
	
	private void clickTable() {
		int sel = tblDSNhanVien.getSelectedRow();
		txtMaNV.setText(tblDSNhanVien.getValueAt(sel, 0).toString());
		txtTenNV.setText(tblDSNhanVien.getValueAt(sel, 1).toString());
		txtLoai.setText(tblDSNhanVien.getValueAt(sel, 2).toString());
		
		
	}
	
	private void TongDoanhThu() {
		ArrayList<HoaDon> arrTongDoanhThu = dao_HoaDon.getAllHoaDon();
		for (HoaDon hoaDon : arrTongDoanhThu) {
			tongDTThang += hoaDon.getTongTien();
			
		}
		ArrayList<HoaDon> arrTongDoanhThuNgay = dao_HoaDon.getHoaDonTheoNgay(new Date());
		for (HoaDon hoaDon : arrTongDoanhThuNgay) {
			tongDTNgay += hoaDon.getTongTien();
		}
		lblDTNgay.setText(convertCurrencyVN(tongDTNgay));
		lblDTThang.setText(convertCurrencyVN(tongDTThang));
	}
	private String convertCurrencyVN(double vnd) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		return currencyVN.format(vnd);

	}
	private void getDoanhThhuNhanVien() {
		String maNV = tblDSNhanVien.getValueAt(tblDSNhanVien.getSelectedRow(), 0).toString().trim();
		ArrayList<HoaDon> arrTongDoanhThu = dao_HoaDon.getHoaDonTheoNhanVien(maNV);
		tongHD = arrTongDoanhThu.size();
		if(tongHD <= 0) {
			JOptionPane.showMessageDialog(this, "Nhân viên này chưa lập hóa đơn");
		}
		for (HoaDon hoaDon : arrTongDoanhThu) {
			tongTien += hoaDon.getTongTien();
			
		}
		lblTongDon.setText(tongHD+"");
		lblTongTien.setText(convertCurrencyVN(tongTien));
		tongTien = 0;
		tongHD = 0;
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lblDTNgay;
	private javax.swing.JLabel lblDTThang;
	private javax.swing.JLabel lblDienThoai;
	private javax.swing.JLabel lblLoai;
	private javax.swing.JLabel lblMaNV;
	private javax.swing.JLabel lblTenNV;
	private javax.swing.JLabel lblTongDon;
	private javax.swing.JLabel lblTongTien;
	private javax.swing.JPanel pnContent;
	private javax.swing.JPanel pnTTNhanVien;
	private javax.swing.JPanel pnTongDoanhThu;
	private javax.swing.JPanel pnTongDoanhThuThang;
	private javax.swing.JPanel pnTongSoHD;
	private javax.swing.JPanel pnTongTien;
	private javax.swing.JTable tblDSNhanVien;
	private javax.swing.JTextField txtEmail;
	private javax.swing.JTextField txtLoai;
	private javax.swing.JTextField txtMaNV;
	private javax.swing.JTextField txtTenNV;
	// End of variables declaration//GEN-END:variables

	private DAO_HoaDon dao_HoaDon = new DAO_HoaDon();
	private DAO_NhanVien dao_NhanVien = new DAO_NhanVien();
	private DefaultTableModel tblModelNhanVien;
	private int tongHD = 0;
	private float tongTien = 0,tongDTThang,tongDTNgay;
}