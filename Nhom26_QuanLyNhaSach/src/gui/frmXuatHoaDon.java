package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.Main;
import entity.CTHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class frmXuatHoaDon extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea Area;
	private JScrollPane sp;
	private JButton btnInHoaDon;
	private JButton btnHuy;

	/**
	 * Create the frame.
	 */
	public frmXuatHoaDon(HoaDon hoaDon) {
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(525, 700);
		setLocationRelativeTo(null);
		setThongTinHoaDon(hoaDon);
		btnInHoaDon.addActionListener(this);
		btnHuy.addActionListener(this);
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

	public void initComponents() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Area = new JTextArea(10, 10);
		Area.setEditable(false);
		Area.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Area.setWrapStyleWord(true);
		Area.setLineWrap(true);

		sp = new JScrollPane(Area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(0, 0, 525, 580);
		getContentPane().add(sp);

		btnInHoaDon = new JButton("In Hóa Đơn");
		btnInHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnInHoaDon.setBounds(90, 585, 150, 45);
		contentPane.add(btnInHoaDon);

		btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHuy.setBounds(330, 585, 150, 45);
		contentPane.add(btnHuy);
	}

	private void setThongTinHoaDon(HoaDon hoaDon) {
		ArrayList<CTHoaDon> dsCTHD = splashScreen.dao_CTHoaDon.getCTHoaDonTheoMaHoaDon(hoaDon.getMaHoaDon().trim());
		String str = "";
		str += String.format("\n%58s", "NHÀ SÁCH TRI THỨC");
		str += String.format("\n%66s", "Địa chỉ : Số 12 Nguyễn Văn Bảo, Phường 4");
		str += String.format("\n%63s", "Quận Gò Vấp, Thành phố Hồ Chí Minh");
		str += String.format("\n%66s", "Điện thoại: 0963.015.348");

		str += String.format("\n%s",
				"------------------------------------------------------------------------------------");
		str += String.format("\n%58s", "HÓA ĐƠN MUA HÀNG\n");
		str += String.format("\n%14s", "Mã Hóa Đơn:");
		str += String.format("%8s", hoaDon.getMaHoaDon().trim());

		str += String.format("%31s", "Nhân Viên:  ");
		str += String.format("%-25s\n", hoaDon.getNhanVien().getHoTen().trim());

		str += String.format("%12s", "Ngày Mua:");
		SimpleDateFormat fmDate = new SimpleDateFormat("dd/MM/yyyy");
		str += String.format("\t%12s", fmDate.format(hoaDon.getNgayLap()));

		str += String.format("%26s", "Khách Hàng:   ");
		str += String.format("%-20s", hoaDon.getKhachHang().getHoTen().trim());

		str += String.format("%s",
				"\n------------------------------------------------------------------------------------");

		str += String.format("\n%-60s|%10s|%20s|", "   Tên Sản Phẩm", "SL", "Đơn Giá");
		str += String.format("%s",
				"\n------------------------------------------------------------------------------------\n");

		for (CTHoaDon ctHoaDon : dsCTHD) {
			int sl = ctHoaDon.getSoLuong();
			double donGia = ctHoaDon.getSanPham().getDonGia();
			str += String.format("\n%-53.30s%10d%20s", ctHoaDon.getSanPham().getTenSanPham().trim(), sl,
					convertCurrencyVN(donGia));

		}
		str += String.format("\n%s",
				"------------------------------------------------------------------------------------\n");
		str += String.format("\n%28s", "Tổng Tiền Đã Thanh Toán: ");
		str += String.format("\t%s", convertCurrencyVN(hoaDon.getTongTien()));
		str += String.format("\n%22s", "Tổng Tiền Đã Giảm: ");
		str += String.format("\t%s", hoaDon.getGiamGia());

		Area.append(str);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj.equals(btnInHoaDon)) {
			try {
				Area.print();
				this.dispose();
			} catch (PrinterException ex) {
				ex.printStackTrace();
			}
		}
		if (obj.equals(btnHuy))
			this.dispose();
	}

	private String convertCurrencyVN(double vnd) {

		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		return currencyVN.format(vnd);

	}

//	public static void main(String[] args) {
//		NhanVien nhanVien = new NhanVien("NV012", "Bùi Trí Thức", "", new Date(), new Date(), 1, 1, null, null, null);
//		KhachHang khachHang = new KhachHang("KH012", "Nguyễn Thị Tuyền", "", "", 100, null);
//		HoaDon hd = new HoaDon("HD030", new Date(), "", nhanVien, khachHang, 16000000);
//		new frmXuatHoaDon(hd).setVisible(true);
//	}
}
