package menuController;

import gui.MainFrame;
import gui.jpnBanHang;
import gui.jpnHoaDon;
import gui.jpnKhachHang;
import gui.jpnNhanVien;
import gui.jpnSanPham;
import gui.jpnThongKe;
import gui.jpnTrangChu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Trí Thức
 */
public class ControllerChange {
	private JPanel pnView;
	private String kindSelected = "";
	private List<DanhMucJFrame> listDanhMuc = null;;

	public ControllerChange(JPanel pnView) {
		this.pnView = pnView;
	}

	public void setView(JPanel jpn) {
		pnView.removeAll();
		pnView.setLayout(new BorderLayout());
		pnView.add(jpn);
		pnView.validate();
		pnView.repaint();

	}
	
	

	public void setEvent(List<DanhMucJFrame> listDanhMuc) {
		this.listDanhMuc = listDanhMuc;
		for (DanhMucJFrame item : listDanhMuc) {
			item.getJpn().addMouseListener(new PanelEvent(item.getKind(), item.getJpn(), item.getJlb()));
		}
	}

	class PanelEvent implements MouseListener {

		private String kind;
		private JPanel node, jpnItem;
		private JLabel jlbItem;

		public PanelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
			this.kind = kind;
			this.jpnItem = jpnItem;
			this.jlbItem = jlbItem;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			switch (kind) {
			case "TrangChu":
				node = new jpnTrangChu();
				break;
			case "BanHang":
				node = MainFrame.getLapHoaDon();
				break;
			case "HoaDon":
				node = new jpnHoaDon();
				break;
			case "SanPham":
				node = new jpnSanPham();
				break;
			case "NhanVien":
				node = new jpnNhanVien();
				break;
			case "KhachHang":
				node = new jpnKhachHang();
				break;
			case "ThongKe":
				node = new jpnThongKe();
				break;
			default:
				break;
			}
			pnView.removeAll();
			pnView.setLayout(new BorderLayout());
			pnView.add(node);
			pnView.validate();
			pnView.repaint();
			setChangeBackground(kind);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			kindSelected = kind;
			if (!kind.equalsIgnoreCase("TrangChu")) {
				jpnItem.setBackground(new Color(76, 175, 80));
				jlbItem.setBackground(new Color(76, 175, 80));
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (!kind.equalsIgnoreCase("TrangChu")) {
				jpnItem.setBackground(new Color(76, 175, 80));
				jlbItem.setBackground(new Color(76, 175, 80));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (!kind.equalsIgnoreCase("TrangChu")) {
				if (!kindSelected.equalsIgnoreCase(kind)) {
					jpnItem.setBackground(new Color(52, 84, 87));
					jlbItem.setBackground(new Color(52, 84, 87));
				}
			}
		}

		public void setChangeBackground(String kind) {
			for (DanhMucJFrame item : listDanhMuc) {
				if (!item.getKind().equalsIgnoreCase("TrangChu")) {
					if (item.getKind().equalsIgnoreCase(kind)) {
						item.getJpn().setBackground(new Color(76, 175, 80));
						item.getJlb().setBackground(new Color(76, 175, 80));
					} else {
						item.getJpn().setBackground(new Color(52, 84, 87));
						item.getJlb().setBackground(new Color(52, 84, 87));
					}
				}
			}
		}

	}

}
