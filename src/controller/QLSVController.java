package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JOptionPane;

import model.ThiSinh;
import model.Tinh;
import view.QLSVView;

public class QLSVController implements Action{
	
	public QLSVView view;
	
	
	
	public QLSVController(QLSVView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
//		JOptionPane.showMessageDialog(view, "Bạn vừa nhấn: " + cm);
		
		if (cm.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm");
		}else if (cm.equals("Lưu")) {
			try {
				this.view.thuHienThemThiSinh();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (cm.equals("Cập Nhật")) {
			this.view.hienThiThongTinThiSinhDaChon();
		} else if (cm.equals("Xoá")) {
			this.view.thucHienXoa();
		} else if (cm.equals("Huỷ bỏ")) {
			this.view.xoaForm();
		}else if (cm.equals("Tìm")) {
			this.view.thuHienTim();
		}else if (cm.equals("Huỷ Tìm")) {
			this.view.thuHienTaiLaiDuLieu();
		}else if (cm.equals("About Me")) {
			this.view.hienThiAbout();
		}else if (cm.equals("Exit")) {
			this.view.thoaKhoiChuongTrinh();
		}else if (cm.equals("Save")) {
			this.view.thucHienSaveFile();
		}else if (cm.equals("Open")) {
			this.view.thucHienOpenFile();
		}
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}
	
}
