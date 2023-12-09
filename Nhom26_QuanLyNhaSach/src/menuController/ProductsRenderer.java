package menuController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import entity.SanPham;

public class ProductsRenderer extends JPanel implements ListCellRenderer<SanPham> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbIcon = new JLabel();
	private JLabel lbName = new JLabel();
	private JLabel lblPrice = new JLabel();
	private JLabel lblTonKho = new JLabel();

	public ProductsRenderer() {
		setLayout(new BorderLayout(5, 5));
		setBorder(BorderFactory.createEtchedBorder());
		JPanel panelText = new JPanel(new GridLayout(0, 1));
//		JPanel panelPrice = new JPanel(new GridLayout(0, 2));
		JPanel panelIco = new JPanel(new BorderLayout());
		lblPrice.setBackground(new Color(255, 255, 204));
		lbIcon.setBackground(new Color(255, 255, 204));
		lbName.setBackground(new Color(255, 255, 204));
		panelIco.setSize(50, 70);
		panelText.add(lbName);
//		panelPrice.add(lblPrice);
//		panelPrice.add(lblTonKho);
		panelText.add(lblPrice);
		panelText.add(lblTonKho);
		panelIco.add(lbIcon);
		add(panelIco, BorderLayout.WEST);
		add(panelText, BorderLayout.CENTER);
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends SanPham> list, SanPham sanPham, int index,
			boolean isSelected, boolean cellHasFocus) {

		ImageIcon img = new ImageIcon(sanPham.getHinhAnh());
		Image scaleImg = scaleImage(img.getImage(), 50, 50);
		lbIcon.setIcon(new ImageIcon(scaleImg));
		lbName.setText(sanPham.getTenSanPham());
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		NumberFormat vn = NumberFormat.getInstance(localeVN);
		String price = currencyVN.format(sanPham.getDonGia());
		lblPrice.setText(price);
		lblPrice.setForeground(Color.blue);
		lblTonKho.setText("Tồn Kho: " + vn.format(sanPham.getSoLuong()));
		lblTonKho.setForeground(Color.blue);
		setToolTipText("Tồn Kho: " + vn.format(sanPham.getSoLuong()));

		// set Opaque to change background color of JLabel
		lbName.setOpaque(true);
		lblPrice.setOpaque(true);
		lblTonKho.setOpaque(true);
		lbIcon.setOpaque(true);

//		list.setSelectionBackground(new Color(255, 255, 204));

		// when select item
		if (isSelected) {

			lbName.setBackground(list.getSelectionBackground());
			lblPrice.setBackground(list.getSelectionBackground());
			lblTonKho.setBackground(list.getSelectionBackground());
			lbIcon.setBackground(list.getSelectionBackground());
			setBackground(list.getSelectionBackground());
		} else { // when don't select
			lbName.setBackground(list.getBackground());
			lblPrice.setBackground(list.getBackground());
			lblTonKho.setBackground(list.getBackground());
			lbIcon.setBackground(list.getBackground());
			setBackground(list.getBackground());
		}

		return this;
	}

	private Image scaleImage(Image image, int w, int h) {
		Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return scaled;
	}

}
