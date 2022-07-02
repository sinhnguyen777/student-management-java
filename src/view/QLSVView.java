package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;
import controller.*;

public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVModel model;
	public JTable table;
	public JTextField textField_MaSinhVien_TimKiem;
	public JTextField textField_ID;
	public JTextField textField_HoVaTen;
	public JTextField textField_NgaySinh;
	public JTextField textField_Mon1;
	public JTextField textField_Mon2;
	public JTextField textField_Mon3;
	public ButtonGroup btn_gioiTinh;
	public JComboBox comboBox_QueQuan;
	public JRadioButton radioButton_nu;
	public JRadioButton radioButton_nam;
	public JComboBox comboBox_QueQuan_TimKiem;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 711);
		
		Action action = (Action) new QLSVController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuSave);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label_QueQuan = new Label("Qu\u00EA Qu\u00E1n");
		label_QueQuan.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_QueQuan.setBounds(10, 23, 116, 32);
		contentPane.add(label_QueQuan);
		
		Label label_MaSinhVien = new Label("M\u00E3 Sinh Vi\u00EAn");
		label_MaSinhVien.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_MaSinhVien.setBounds(307, 23, 127, 32);
		contentPane.add(label_MaSinhVien);
		
		textField_MaSinhVien_TimKiem = new JTextField();
		textField_MaSinhVien_TimKiem.setBounds(456, 23, 188, 32);
		contentPane.add(textField_MaSinhVien_TimKiem);
		textField_MaSinhVien_TimKiem.setColumns(10);
		
		JButton btnTim = new JButton("T\u00ECm");
		btnTim.addActionListener(action);
		btnTim.setBackground(Color.LIGHT_GRAY);
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.setBounds(677, 23, 101, 32);
		contentPane.add(btnTim);
		
		comboBox_QueQuan_TimKiem = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_QueQuan_TimKiem.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_QueQuan_TimKiem.addItem(tinh.getTenTinh());
		}
		
		comboBox_QueQuan_TimKiem.setBounds(132, 23, 152, 32);
		contentPane.add(comboBox_QueQuan_TimKiem);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 65, 920, 2);
		contentPane.add(separator_1);
		
		Label label_QueQuan_1 = new Label("Danh S\u00E1ch Sinh Vi\u00EAn");
		label_QueQuan_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_QueQuan_1.setBounds(10, 73, 231, 32);
		contentPane.add(label_QueQuan_1);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Sinh Vi\u00EAn", "H\u1ECD T\u00EAn", "Qu\u00EA Qu\u00E1n", "Ngày Sinh", "Gi\u1EDBi T\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3"
			}
		));
		
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 119, 905, 182);
		contentPane.add(scrollPane);
		
		Label label_ID = new Label("Ma Sinh Vien");
		label_ID.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_ID.setBounds(10, 394, 127, 30);
		contentPane.add(label_ID);
		
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(162, 394, 152, 30);
		contentPane.add(textField_ID);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 322, 920, 2);
		contentPane.add(separator_1_1);
		
		Label label_QueQuan_1_1 = new Label("Th\u00F4ng tin sinh vi\u00EAn");
		label_QueQuan_1_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_QueQuan_1_1.setBounds(10, 340, 231, 32);
		contentPane.add(label_QueQuan_1_1);
		
		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(162, 435, 152, 30);
		contentPane.add(textField_HoVaTen);
		
		Label label_HoVaTen = new Label("Ho Ten");
		label_HoVaTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_HoVaTen.setBounds(10, 435, 127, 30);
		contentPane.add(label_HoVaTen);
		
		Label label_MaSinhVien_1_2 = new Label("Que Quan");
		label_MaSinhVien_1_2.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_MaSinhVien_1_2.setBounds(10, 475, 127, 30);
		contentPane.add(label_MaSinhVien_1_2);
		
		comboBox_QueQuan = new JComboBox();
		comboBox_QueQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_QueQuan.addItem(tinh.getTenTinh());
		}
		comboBox_QueQuan.setBounds(162, 475, 152, 30);
		contentPane.add(comboBox_QueQuan);
		
		Label label_NgaySinh = new Label("Ngay Sinh");
		label_NgaySinh.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_NgaySinh.setBounds(10, 516, 127, 30);
		contentPane.add(label_NgaySinh);
		
		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(162, 516, 152, 30);
		contentPane.add(textField_NgaySinh);
		
		Label label_ID_1 = new Label("Gioi Tinh");
		label_ID_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		label_ID_1.setBounds(456, 394, 87, 30);
		contentPane.add(label_ID_1);
		
		radioButton_nam = new JRadioButton("Nam");
		radioButton_nam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton_nam.setBounds(578, 394, 87, 30);
		contentPane.add(radioButton_nam);
		
		radioButton_nu = new JRadioButton("N\u1EEF");
		radioButton_nu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton_nu.setBounds(691, 394, 87, 30);
		contentPane.add(radioButton_nu);
		

		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(radioButton_nam);
		btn_gioiTinh.add(radioButton_nu);
		
		textField_Mon1 = new JTextField();
		textField_Mon1.setColumns(10);
		textField_Mon1.setBounds(608, 435, 152, 30);
		contentPane.add(textField_Mon1);
		
		Label label_Mon1 = new Label("M\u00F4n To\u00E1n");
		label_Mon1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_Mon1.setBounds(456, 435, 127, 30);
		contentPane.add(label_Mon1);
		
		textField_Mon2 = new JTextField();
		textField_Mon2.setColumns(10);
		textField_Mon2.setBounds(608, 475, 152, 30);
		contentPane.add(textField_Mon2);
		
		Label label_Mon2 = new Label("M\u00F4n L\u00FD");
		label_Mon2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_Mon2.setBounds(456, 475, 127, 30);
		contentPane.add(label_Mon2);
		
		textField_Mon3 = new JTextField();
		textField_Mon3.setColumns(10);
		textField_Mon3.setBounds(608, 516, 152, 30);
		contentPane.add(textField_Mon3);
		
		Label label_Mon3 = new Label("M\u00F4n Ho\u00E1");
		label_Mon3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_Mon3.setBounds(456, 516, 127, 30);
		contentPane.add(label_Mon3);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThem.setBackground(Color.LIGHT_GRAY);
		btnThem.setBounds(10, 599, 101, 32);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xo\u00E1");
		btnXoa.addActionListener(action);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoa.setBackground(Color.LIGHT_GRAY);
		btnXoa.setBounds(213, 599, 101, 32);
		contentPane.add(btnXoa);
		
		JButton btnCapNhat = new JButton("C\u1EADp Nh\u1EADt");
		btnCapNhat.addActionListener(action);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCapNhat.setBackground(Color.LIGHT_GRAY);
		btnCapNhat.setBounds(416, 599, 127, 32);
		contentPane.add(btnCapNhat);
		
		JButton btnLuu = new JButton("L\u01B0u");
		btnLuu.addActionListener(action);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLuu.setBackground(Color.LIGHT_GRAY);
		btnLuu.setBounds(646, 599, 101, 32);
		contentPane.add(btnLuu);
		
		JButton btnHuyBo = new JButton("Hu\u1EF7 B\u1ECF");
		btnHuyBo.addActionListener(action);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHuyBo.setBackground(Color.LIGHT_GRAY);
		btnHuyBo.setBounds(814, 599, 101, 32);
		contentPane.add(btnHuyBo);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 572, 920, 2);
		contentPane.add(separator_1_1_1);
		
		JButton btnHuyTim = new JButton("Huỷ Tìm");
		btnHuyTim.addActionListener(action);
		btnHuyTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHuyTim.setBackground(Color.LIGHT_GRAY);
		btnHuyTim.setBounds(799, 23, 116, 32);
		contentPane.add(btnHuyTim);
		
		
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_ID.setText("");
		textField_HoVaTen.setText("");
		textField_MaSinhVien_TimKiem.setText("");
		textField_NgaySinh.setText("");
		textField_Mon1.setText("");
		textField_Mon2.setText("");
		textField_Mon3.setText("");
		comboBox_QueQuan.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}
	
	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { ts.getMaThiSinh() + "", ts.getTenThiSinh(), ts.getQueQuan().getTenTinh(),
				ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
						+ (ts.getNgaySinh().getYear() + 1900),
				(ts.isGioiTinh() ? "Nam" : "Nữ"), ts.getDiemMon1() + "", ts.getDiemMon2() + "",
				ts.getDiemMon3() + "", });
	}
	
	public void ThemSinhVienVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(
				new Object[]{
						ts.getMaThiSinh()+"",
						ts.getTenThiSinh(),
						ts.getQueQuan().getTenTinh(),
						ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900),
						(ts.isGioiTinh()?"Nam" : "Nữ"),
						ts.getDiemMon1()+"",
						ts.getDiemMon2()+"",
						ts.getDiemMon3()+"",
				}
		);
	}

	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);
			this.ThemSinhVienVaoTable(ts);
			
		}else {
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if (id.equals(ts.getMaThiSinh()+"")) {
					model_table.setValueAt(ts.getMaThiSinh()+"", i, 0);
					model_table.setValueAt(ts.getTenThiSinh()+"", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh()+"", i, 2);
					model_table.setValueAt(ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900)+"", i, 3);
					model_table.setValueAt((ts.isGioiTinh()?"Nam" : "Nữ")+"", i, 4);
					model_table.setValueAt(ts.getDiemMon1()+"", i, 5);
					model_table.setValueAt(ts.getDiemMon2()+"", i, 6);
					model_table.setValueAt(ts.getDiemMon3()+"", i, 7);
				}
			}
		}
	}
	
	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		model_table.getValueAt(i_row, 0);
		
		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		String tenThiSinh = model_table.getValueAt(i_row, 1)+"";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2)+"");
		String s_ngaySinh = model_table.getValueAt(i_row, 3)+"";
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4)+"";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5)+"");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6)+"");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 5)+"");
		
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}

	public void hienThiThongTinThiSinhDaChon() {
		ThiSinh ts = getThiSinhDangChon();		
		
		this.textField_ID.setText(ts.getMaThiSinh()+"");
		this.textField_HoVaTen.setText(ts.getTenThiSinh()+"");
		this.comboBox_QueQuan.setSelectedItem(ts.getQueQuan().getTenTinh());
		String s_ngaySinh = ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900);
		this.textField_NgaySinh.setText(s_ngaySinh+"");
		if (ts.isGioiTinh()) {
			radioButton_nam.setSelected(true);
		} else {
			radioButton_nu.setSelected(true);
		}
		this.textField_Mon1.setText(ts.getDiemMon1()+"");
		this.textField_Mon2.setText(ts.getDiemMon2()+"");
		this.textField_Mon3.setText(ts.getDiemMon3()+"");
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá ?");
		if (luaChon == JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDangChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}
	}

	public void thuHienThemThiSinh() {

		int maThiSinh = Integer.valueOf(this.textField_ID.getText());
		String tenThiSinh = this.textField_HoVaTen.getText()+"";
		int queQuan = this.comboBox_QueQuan.getSelectedIndex()-1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		Date ngaySinh = new Date(this.textField_NgaySinh.getText());
		boolean gioiTinh = true;
//		String chonGioiTinh = this.view.btn_gioiTinh.getSelection()+"";
		if (this.radioButton_nam.isSelected()) {
			gioiTinh = true;
		} else if (this.radioButton_nu.isSelected()) {
			gioiTinh = false;
		}
		
		float diemMon1 = Float.valueOf(this.textField_Mon1.getText());
		float diemMon2 = Float.valueOf(this.textField_Mon2.getText());
		float diemMon3 = Float.valueOf(this.textField_Mon3.getText());
		
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		
		this.themHoacCapNhatThiSinh(ts);
		
	}

	public void thuHienTim() {
		// goi ham huy tim kiem
		
		this.thuHienTaiLaiDuLieu();
		
		int queQuan = this.comboBox_QueQuan_TimKiem.getSelectedIndex()-1;
		String maThiSinhTimKiem = this.textField_MaSinhVien_TimKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		
		int soLuongDong = model_table.getRowCount();
		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
		if (queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2)+"";
				String id = model_table.getValueAt(i, 0)+"";
				if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
			
		}if(maThiSinhTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if (!id.equals(maThiSinhTimKiem)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				if(idTrongTable.equals(idCanXoa.toString())) {
					try {						
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void thuHienTaiLaiDuLieu() {
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if (soLuongDong == 0) {
				break;
			} else {
				try {
					model_table.removeRow(0);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		for (ThiSinh ts: this.model.getDsThiSinh()) {
			this.ThemSinhVienVaoTable(ts);
		}
		
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý sinh viên");
		
	}

	public void thoaKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
						this, 
						"Bạn có chắc chắn muốn thoát khỏi chương trình ?", 
						"Exit",
						JOptionPane.YES_NO_OPTION
					);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}
	
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openFile(File file) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while ((ts = (ThiSinh) ois.readObject()) != null) {
				ds.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinh(ds);
	}

	public void thucHienSaveFile() {
		if(this.model.getTenFile().length() > 0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}

	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thuHienTaiLaiDuLieu();
		}
		
	}
}
