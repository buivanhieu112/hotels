/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.DAO_ChucVu;
import dao.DAO_LoaiDichVu;
import dao.DAO_LoaiPhong;
import dao.DAO_NhanVien;
import entity.ChucVu;
import entity.LoaiDichVu;
import entity.NhanVien;

/**
 *
 * @author admin
 */
public class GD_QuanLyLoaiDichVu extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Creates new form GD_QuanLyLoaiDichVu
     */
    public GD_QuanLyLoaiDichVu() {
        initComponents();
        setExtendedState(GD_QuanLyLoaiDichVu.MAXIMIZED_BOTH);

    }
    private DefaultTableModel modelDSLDV;
    private String[] colsLoaiDV={"Mã loại dịch vụ", "Tên loại dịch vụ"};
    
    public void DocDuLieuDatabaseVaoDSLoaiDV() {
    	ArrayList<LoaiDichVu> listPhong = DAO_LoaiDichVu.getAllLoaiDV();
    	for (LoaiDichVu p : listPhong) {
    		modelDSLDV.addRow(new Object[] {
    				p.getMaLoaiDichVu(),p.getTenLoaiDichVu()
    				});}
        }
    
    public void DocDuLieuVaoTextFiedLoaiDV()
    {
    	ArrayList<LoaiDichVu> lstP = DAO_LoaiDichVu.getAllLoaiDV();
		int i = tblDSLDV.getSelectedRow();
		if(i!=-1) {
			LoaiDichVu p = lstP.get(i);
			txtMaLoaiDV.setText(p.getMaLoaiDichVu());
			txtTenLoaiDV.setText(p.getTenLoaiDichVu());
		}
    }
    
    public String maLoaiDVMoi() {
    	ArrayList<LoaiDichVu> listPhong = DAO_LoaiDichVu.getAllLoaiDV();
    	if(listPhong.size()==0) {
    		return "LDV001";
    	}
    	
    	String ma = listPhong.get(listPhong.size()-1).getMaLoaiDichVu().substring(3);
    	
    	int i = Integer.parseInt(ma) + 1;
    	
    	if(i<10)
    		ma = "00" + i;
    	else if(i>=10 && i<=99)
    		ma = "0" + i;
    	else if(i>=100)
    		ma = i+"";
    	return "LDV"+ma;
    }
    
    
    public void LamMoiTextField() {
    	txtMaLoaiDV.setText(maLoaiDVMoi());
    	txtTenLoaiDV.setText("");
    }
    
    public void taiLaiDSDV() {
    	modelDSLDV.setRowCount(0);
    	DocDuLieuDatabaseVaoDSLoaiDV();
    	LamMoiTextField();
    	txtTim.setText("");
    }
    
// Them
    public boolean themLoaiDV() throws ParseException {
    	String maPhong, tenPhong;
//    	double giaPhong;
    	if(kiemTraDuLieuPhong()) {
    		maPhong = txtMaLoaiDV.getText();
        	tenPhong = txtTenLoaiDV.getText();
        	
        	LoaiDichVu p = new LoaiDichVu(maPhong, tenPhong);
        	if(!DAO_LoaiDichVu.themLoaiDV(p))
        		return false;
        	JOptionPane.showMessageDialog(rootPane, "Thêm loại dịch vụ thành công!");
        	
    	}
    	return true;
    }
    
    public boolean kiemTraDuLieuPhong() {
		String tenDV=txtTenLoaiDV.getText().trim();
		
		if (tenDV.trim().length() > 0) {
			if (!(tenDV.matches("[^.\\/\\_\\+\\?\\#\\%\\@\\!\\$\\^\\&\\*\\(\\)]+"))) {
				JOptionPane.showMessageDialog(this, "Tên loại phòng không chứa ký tự đặc biệt");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(this, "Tên loại phòng không được để trống");
			return false;
		}
		return true;
    }
    
// cap nhat
    
    
    public boolean capNhatLDV() throws Exception {
    	String maPhong, tenPhong;
//    	double giaPhong;
    	if(kiemTraDuLieuPhong())
    	{
    		maPhong = txtMaLoaiDV.getText();
        	tenPhong = txtTenLoaiDV.getText();
        	
        	
        	LoaiDichVu p = new LoaiDichVu(maPhong, tenPhong);
        	if(!DAO_LoaiDichVu.capNhatLoaiDV(p)) {
        		JOptionPane.showMessageDialog(rootPane, "Cập nhật không thành công!");
        		return false;
        	}
        	JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công!");
    	}
    	
    	return true;
    }
    
// xoa phong    
    
public boolean xoaLP() {
    	
    	int result = JOptionPane.showConfirmDialog(rootPane,
                "Bạn có chắc muốn xóa phòng này!",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
        	DAO_LoaiPhong.xoaLP(txtMaLoaiDV.getText());
        	JOptionPane.showMessageDialog(rootPane, "Xóa phòng thành công!");
        	return true;
        } else if (result == JOptionPane.NO_OPTION) {
        	JOptionPane.showMessageDialog(rootPane, "Đã hủy thao tác xóa!");
        }
        return false;
    }

// tim phong

	public void timLDV(String ten) {
		ArrayList<LoaiDichVu> listPhong = DAO_LoaiDichVu.timLoaiDV(ten);
		for (LoaiDichVu p : listPhong) {
			modelDSLDV.addRow(new Object[] {
					p.getMaLoaiDichVu(),p.getTenLoaiDichVu()
					});}
	}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlTTNV = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenLoaiDV = new javax.swing.JTextField();
        txtMaLoaiDV = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        pnlDSNV = new javax.swing.JPanel();
        scrollDSLDV = new javax.swing.JScrollPane();
        tblDSLDV = new javax.swing.JTable();
        lblDSLP = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        pnlBottom = new javax.swing.JPanel();
        btnDangXuat = new javax.swing.JButton();
        lblTenNVLogin = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuPhong = new javax.swing.JMenu();
        PhongDangSuDung = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        DatPhong = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        QuanLyPhong = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        QuanLyLoaiPhong = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        menuDichVu = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        quanlyDV = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        quanLyLoaiDV = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        quanLyDonVi = new javax.swing.JMenuItem();
        menuKhachHang = new javax.swing.JMenu();
        quanLyKH = new javax.swing.JMenuItem();
        menuNhanVien = new javax.swing.JMenu();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        quanLyNhanVien = new javax.swing.JMenuItem();
        menuHoaDon = new javax.swing.JMenu();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        quanLyHoaDon = new javax.swing.JMenuItem();
        menuThongKe = new javax.swing.JMenu();
        tkBieuDo = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlTTNV.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Mã Loại Dịch Vụ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Tên Loại Dịch Vụ");

        txtTenLoaiDV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMaLoaiDV.setEditable(false);
        txtMaLoaiDV.setBackground(new java.awt.Color(153, 153, 153));
        txtMaLoaiDV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaLoaiDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaLoaiDVActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon("C:\\hotels (4)\\hotels\\src\\main\\java\\images\\ic_add.png")); // NOI18N
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					btnThemActionPerformed(evt);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        btnCapNhat.setIcon(new javax.swing.ImageIcon("C:\\hotels (4)\\hotels\\src\\main\\java\\images\\ic_upd.png")); // NOI18N
        btnCapNhat.setText("CẬP NHẬT");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Thông Tin Loại Dịch Vụ");

        javax.swing.GroupLayout pnlTTNVLayout = new javax.swing.GroupLayout(pnlTTNV);
        pnlTTNV.setLayout(pnlTTNVLayout);
        pnlTTNVLayout.setHorizontalGroup(
            pnlTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTTNVLayout.createSequentialGroup()
                .addGroup(pnlTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTTNVLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlTTNVLayout.createSequentialGroup()
                                .addGroup(pnlTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(pnlTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaLoaiDV)
                                    .addComponent(txtTenLoaiDV)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlTTNVLayout.createSequentialGroup()
                                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 268, Short.MAX_VALUE))))
                    .addGroup(pnlTTNVLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel9)))
                .addGap(15, 15, 15))
            .addGroup(pnlTTNVLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCapNhat)
                .addGap(47, 47, 47))
        );
        pnlTTNVLayout.setVerticalGroup(
            pnlTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTTNVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(91, 91, 91)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(pnlTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(pnlTTNVLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtTenLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(pnlTTNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDSNV.setBackground(new java.awt.Color(102, 204, 255));

        tblDSLDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Loại Dịch Vụ", "Tên Loại Dịch Vụ"
            }
        ));
        scrollDSLDV.setViewportView(tblDSLDV);

        lblDSLP.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDSLP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDSLP.setText("Danh Sách Loại Dịch Vụ");

        btnTim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTim.setIcon(new javax.swing.ImageIcon("C:\\hotels (4)\\hotels\\src\\main\\java\\images\\ic_search.png")); // NOI18N
        btnTim.setText("TÌM");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon("C:\\hotels (4)\\hotels\\src\\main\\java\\images\\ic_refresh.png")); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDSNVLayout = new javax.swing.GroupLayout(pnlDSNV);
        pnlDSNV.setLayout(pnlDSNVLayout);
        pnlDSNVLayout.setHorizontalGroup(
            pnlDSNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDSNVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDSNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDSLP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDSNVLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTim)
                        .addGap(0, 345, Short.MAX_VALUE))
                    .addComponent(scrollDSLDV))
                .addContainerGap())
        );
        pnlDSNVLayout.setVerticalGroup(
            pnlDSNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDSNVLayout.createSequentialGroup()
                .addComponent(lblDSLP)
                .addGap(15, 15, 15)
                .addGroup(pnlDSNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollDSLDV, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlBottom.setBackground(new java.awt.Color(102, 204, 255));

        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDangXuat.setText("Đăng Xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					btnDangXuatActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        lblTenNVLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenNVLogin.setText("họ tên nhân viên");
        lblTenNVLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTenNVLoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlBottomLayout = new javax.swing.GroupLayout(pnlBottom);
        pnlBottom.setLayout(pnlBottomLayout);
        pnlBottomLayout.setHorizontalGroup(
            pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBottomLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTenNVLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBottomLayout.setVerticalGroup(
            pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBottomLayout.createSequentialGroup()
                        .addComponent(lblTenNVLogin)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(pnlTTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDSNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDSNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTTNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Menu.setPreferredSize(new java.awt.Dimension(94, 60));

        jMenu1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jMenu1.setIcon(new javax.swing.ImageIcon("C:\\HocTap\\KLTN_T7\\KLTN_HV_Hotels\\src\\main\\java\\images\\logo.png")); // NOI18N
        jMenu1.setActionCommand("HV HOTEL");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jMenu1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenu1.setMinimumSize(new java.awt.Dimension(100, 45));
        jMenu1.setPreferredSize(new java.awt.Dimension(100, 45));
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        Menu.add(jMenu1);

        menuPhong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuPhong.setIcon(new javax.swing.ImageIcon("C:\\HocTap\\KLTN_T7\\KLTN_HV_Hotels\\src\\main\\java\\images\\ic_room.png")); // NOI18N
        menuPhong.setText("   PHÒNG");
        menuPhong.setToolTipText("");
        menuPhong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuPhong.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        menuPhong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        menuPhong.setMinimumSize(new java.awt.Dimension(190, 52));
        menuPhong.setPreferredSize(new java.awt.Dimension(180, 45));
        menuPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPhongActionPerformed(evt);
            }
        });

        PhongDangSuDung.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        PhongDangSuDung.setIcon(new javax.swing.ImageIcon("C:\\HocTap\\KLTN_T7\\KLTN_HV_Hotels\\src\\main\\java\\images\\ic_phong.png")); // NOI18N
        PhongDangSuDung.setText("PHÒNG");
        PhongDangSuDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhongDangSuDungActionPerformed(evt);
            }
        });
        menuPhong.add(PhongDangSuDung);
        menuPhong.add(jSeparator12);

        DatPhong.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        DatPhong.setIcon(new javax.swing.ImageIcon("C:\\KLTN\\KLTN_HV_Hotel\\src\\main\\java\\images\\ic_datPhong.png")); // NOI18N
        DatPhong.setText("ĐẶT PHÒNG");
        DatPhong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatPhongActionPerformed(evt);
            }
        });
        menuPhong.add(DatPhong);
        menuPhong.add(jSeparator13);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon("C:\\HocTap\\KLTN_T7\\KLTN_HV_Hotels\\src\\main\\java\\images\\ic_checkout (1).png")); // NOI18N
        jMenuItem3.setText("TRẢ PHÒNG");
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuPhong.add(jMenuItem3);
        menuPhong.add(jSeparator1);

        QuanLyPhong.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        QuanLyPhong.setIcon(new javax.swing.ImageIcon("C:\\KLTN\\KLTN_HV_Hotel\\src\\main\\java\\images\\ic_phong.png")); // NOI18N
        QuanLyPhong.setText("QUẢN LÝ PHÒNG");
        QuanLyPhong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        QuanLyPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuanLyPhongActionPerformed(evt);
            }
        });
        menuPhong.add(QuanLyPhong);
        menuPhong.add(jSeparator2);

        QuanLyLoaiPhong.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        QuanLyLoaiPhong.setIcon(new javax.swing.ImageIcon("C:\\KLTN\\KLTN_HV_Hotel\\src\\main\\java\\images\\ic_phong.png")); // NOI18N
        QuanLyLoaiPhong.setText("QUẢN LÝ LOẠI PHÒNG");
        QuanLyLoaiPhong.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        QuanLyLoaiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuanLyLoaiPhongActionPerformed(evt);
            }
        });
        menuPhong.add(QuanLyLoaiPhong);
        menuPhong.add(jSeparator11);

        Menu.add(menuPhong);

        menuDichVu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuDichVu.setIcon(new javax.swing.ImageIcon("C:\\HocTap\\KLTN_T7\\KLTN_HV_Hotels\\src\\main\\java\\images\\ic_service.png")); // NOI18N
        menuDichVu.setText("DỊCH VỤ");
        menuDichVu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuDichVu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        menuDichVu.setPreferredSize(new java.awt.Dimension(180, 34));
        menuDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDichVuActionPerformed(evt);
            }
        });
        menuDichVu.add(jSeparator3);

        quanlyDV.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        quanlyDV.setIcon(new javax.swing.ImageIcon("C:\\KLTN\\KLTN_HV_Hotel\\src\\main\\java\\images\\ic_list.png")); // NOI18N
        quanlyDV.setText("QUẢN LÝ DỊCH VỤ");
        quanlyDV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quanlyDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanlyDVActionPerformed(evt);
            }
        });
        menuDichVu.add(quanlyDV);
        menuDichVu.add(jSeparator7);
        menuDichVu.add(jSeparator8);

        quanLyLoaiDV.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        quanLyLoaiDV.setIcon(new javax.swing.ImageIcon("C:\\KLTN\\KLTN_HV_Hotel\\src\\main\\java\\images\\ic_list.png")); // NOI18N
        quanLyLoaiDV.setText("QUẢN LÝ LOẠI DỊCH VỤ");
        quanLyLoaiDV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quanLyLoaiDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanLyLoaiDVActionPerformed(evt);
            }
        });
        menuDichVu.add(quanLyLoaiDV);
        menuDichVu.add(jSeparator9);

        quanLyDonVi.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        quanLyDonVi.setIcon(new javax.swing.ImageIcon("C:\\KLTN\\KLTN_HV_Hotel\\src\\main\\java\\images\\ic_list.png")); // NOI18N
        quanLyDonVi.setText("QUẢN LÝ ĐƠN VỊ");
        quanLyDonVi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quanLyDonVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanLyDonViActionPerformed(evt);
            }
        });
        menuDichVu.add(quanLyDonVi);

        Menu.add(menuDichVu);

        menuKhachHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuKhachHang.setIcon(new javax.swing.ImageIcon("C:\\HocTap\\KLTN_T7\\KLTN_HV_Hotels\\src\\main\\java\\images\\ic_customer.png")); // NOI18N
        menuKhachHang.setText("KHÁCH HÀNG");
        menuKhachHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        menuKhachHang.setPreferredSize(new java.awt.Dimension(205, 34));

        quanLyKH.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        quanLyKH.setIcon(new javax.swing.ImageIcon("C:\\KLTN\\KLTN_HV_Hotel\\src\\main\\java\\images\\ic_list.png")); // NOI18N
        quanLyKH.setText("QUẢN LÝ KHÁCH HÀNG");
        quanLyKH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quanLyKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanLyKHActionPerformed(evt);
            }
        });
        menuKhachHang.add(quanLyKH);

        Menu.add(menuKhachHang);

        menuNhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuNhanVien.setIcon(new javax.swing.ImageIcon("C:\\HocTap\\KLTN_T7\\KLTN_HV_Hotels\\src\\main\\java\\images\\ic_employee.png")); // NOI18N
        menuNhanVien.setText("NHÂN VIÊN");
        menuNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        menuNhanVien.setMaximumSize(new java.awt.Dimension(185, 32767));
        menuNhanVien.setPreferredSize(new java.awt.Dimension(180, 34));
        menuNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNhanVienActionPerformed(evt);
            }
        });
        menuNhanVien.add(jSeparator4);

        quanLyNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        quanLyNhanVien.setIcon(new javax.swing.ImageIcon("C:\\KLTN\\KLTN_HV_Hotel\\src\\main\\java\\images\\ic_list.png")); // NOI18N
        quanLyNhanVien.setText("QUẢN LÝ NHÂN VIÊN");
        quanLyNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quanLyNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanLyNhanVienActionPerformed(evt);
            }
        });
        menuNhanVien.add(quanLyNhanVien);

        Menu.add(menuNhanVien);

        menuHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuHoaDon.setIcon(new javax.swing.ImageIcon("C:\\HocTap\\KLTN_T7\\KLTN_HV_Hotels\\src\\main\\java\\images\\ic_oder.png")); // NOI18N
        menuHoaDon.setText("  HOÁ ĐƠN");
        menuHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        menuHoaDon.setPreferredSize(new java.awt.Dimension(180, 34));
        menuHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuHoaDonMouseClicked(evt);
            }
        });
        menuHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHoaDonActionPerformed(evt);
            }
        });
        menuHoaDon.add(jSeparator5);

        quanLyHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        quanLyHoaDon.setIcon(new javax.swing.ImageIcon("C:\\KLTN\\KLTN_HV_Hotel\\src\\main\\java\\images\\ic_list.png")); // NOI18N
        quanLyHoaDon.setText("QUẢN LÝ HOÁ ĐƠN");
        quanLyHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quanLyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quanLyHoaDonActionPerformed(evt);
            }
        });
        menuHoaDon.add(quanLyHoaDon);

        Menu.add(menuHoaDon);

        menuThongKe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuThongKe.setIcon(new javax.swing.ImageIcon("C:\\HocTap\\KLTN_T7\\KLTN_HV_Hotels\\src\\main\\java\\images\\ic_chart_1.png")); // NOI18N
        menuThongKe.setText(" THỐNG KÊ");
        menuThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuThongKe.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        menuThongKe.setPreferredSize(new java.awt.Dimension(180, 34));
        menuThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuThongKeMouseClicked(evt);
            }
        });
        menuThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuThongKeActionPerformed(evt);
            }
        });

        tkBieuDo.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        tkBieuDo.setIcon(new javax.swing.ImageIcon("C:\\KLTN\\KLTN_HV_Hotel\\src\\main\\java\\images\\ic_chart.png")); // NOI18N
        tkBieuDo.setText("BIỂU ĐỒ");
        tkBieuDo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tkBieuDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkBieuDoActionPerformed(evt);
            }
        });
        menuThongKe.add(tkBieuDo);
        menuThongKe.add(jSeparator6);

        Menu.add(menuThongKe);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
        
      setDefaultCloseOperation(0);
      setResizable(false);
      modelDSLDV = new DefaultTableModel(colsLoaiDV,0);
      tblDSLDV = new JTable(modelDSLDV);
      scrollDSLDV.setViewportView(tblDSLDV);
      
//      tblDSPhong.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      tblDSLDV.getColumnModel().getColumn(0).setPreferredWidth(80);
      tblDSLDV.getColumnModel().getColumn(1).setPreferredWidth(152);
      
      // Sự kiện click trên tblDSPhongTrong
      ListSelectionModel listSelectionModelDSPhongTrong = tblDSLDV.getSelectionModel();
      // Thiết lập chỉ click được 1 dòng
      listSelectionModelDSPhongTrong.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      // Xử lý sự kiện click
      listSelectionModelDSPhongTrong.addListSelectionListener(new ListSelectionListener() {
  		
  		@Override
  		public void valueChanged(ListSelectionEvent e) {
  			DocDuLieuVaoTextFiedLoaiDV();
  		}
  	});
      DocDuLieuDatabaseVaoDSLoaiDV();
      
      hienThiNVDN();
      
      if(quanLy()) {
      	lblTenNVLogin.addMouseListener(new java.awt.event.MouseAdapter() {
              public void mouseClicked(java.awt.event.MouseEvent evt) {
                  lblTenNVLoginMouseClicked(evt);
              }
          });
      }
      else
      	lblTenNVLogin.setEnabled(false);
        
    }// </editor-fold>//GEN-END:initComponents
    
//    setDefaultCloseOperation(0);
//    setResizable(false);
//    modelDSLDV = new DefaultTableModel(colsLoaiDV,0);
//    tblDSLDV = new JTable(modelDSLDV);
//    scrollDSLDV.setViewportView(tblDSLDV);
//    
////    tblDSPhong.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//    tblDSLDV.getColumnModel().getColumn(0).setPreferredWidth(80);
//    tblDSLDV.getColumnModel().getColumn(1).setPreferredWidth(152);
//    
//    // Sự kiện click trên tblDSPhongTrong
//    ListSelectionModel listSelectionModelDSPhongTrong = tblDSLDV.getSelectionModel();
//    // Thiết lập chỉ click được 1 dòng
//    listSelectionModelDSPhongTrong.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//    // Xử lý sự kiện click
//    listSelectionModelDSPhongTrong.addListSelectionListener(new ListSelectionListener() {
//		
//		@Override
//		public void valueChanged(ListSelectionEvent e) {
//			DocDuLieuVaoTextFiedLoaiDV();
//		}
//	});
//    DocDuLieuDatabaseVaoDSLoaiDV();
//    
//    hienThiNVDN();
//    
//    if(quanLy()) {
//    	lblTenNVLogin.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                lblTenNVLoginMouseClicked(evt);
//            }
//        });
//    }
//    else
//    	lblTenNVLogin.setEnabled(false);
    
    public void hienThiNVDN() {
    	NhanVien nv = DAO_NhanVien.getNhanVienDangLogin();
		lblTenNVLogin.setText(getTenChucVu(nv.getChucVu().getMaCV())+" - " + nv.getTenNV());
    }
    public boolean quanLy() {
    	NhanVien nv = DAO_NhanVien.getNhanVienDangLogin();
    	if((nv.getChucVu().getMaCV()).equalsIgnoreCase("CV001")==true)
    		return true;
    	return false;
    }
    
    public String getTenChucVu(String maCV) {
    	ArrayList<ChucVu> lstChucVu = DAO_ChucVu.getAllChucVu();
    	for (ChucVu cv : lstChucVu) {
    		if(cv.getMaCV().equalsIgnoreCase(maCV))
    			return cv.getTenCV();
    	}
    	return "";
    }

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
    	LamMoiTextField();

    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    	themLoaiDV();
    	
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        try {
        	capNhatLDV();
        	taiLaiDSDV();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
    	String ten = txtTim.getText().replaceAll("\\s\\s+", " ").trim();
    	modelDSLDV.setRowCount(0);
    	timLDV(ten);
    	LamMoiTextField(); 
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
    	taiLaiDSDV();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
    	int result = JOptionPane.showConfirmDialog(rootPane,
                "Bạn có chắc muốn đăng xuất!",
                "XÁC NHẬN",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
        	GD_DangNhap uiLogout = new GD_DangNhap();
//        	GD_DaiSanh uiDaiSanh = new GD_DaiSanh();
            ArrayList<NhanVien> listNV = DAO_NhanVien.getAllNhanVien();
            for (NhanVien nv : listNV) {
    			if(nv.isTinhTrang()==true)
    				DAO_NhanVien.capNhatTinhTrangNVDX(nv);
    	        this.setVisible(false);
    	        uiLogout.setVisible(true);
    		}
            JOptionPane.showMessageDialog(rootPane, "Bạn đã đăng xuất!!!");
        } else if (result == JOptionPane.NO_OPTION) {
        	JOptionPane.showMessageDialog(rootPane, "Đăng xuất thất bại!!");
        }
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void lblTenNVLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTenNVLoginMouseClicked
        // TODO add your handling code here:
        GD_ThongTinNhanVien uiTTNV = new GD_ThongTinNhanVien();
        //    	this.setVisible(false);
        uiTTNV.setVisible(true);
    }//GEN-LAST:event_lblTenNVLoginMouseClicked

    private void txtMaLoaiDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaLoaiDVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaLoaiDVActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        GD_DaiSanh uiSanh = new GD_DaiSanh();
        this.setVisible(false);
        uiSanh.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    	GD_DaiSanh uiMain = new GD_DaiSanh();
        this.setVisible(false);
        uiMain.setVisible(true);
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void PhongDangSuDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhongDangSuDungActionPerformed
        // TODO add your handling code here:
        GD_Chinh ui = new GD_Chinh();
        this.setVisible(false);
        ui.setVisible(true);
    }//GEN-LAST:event_PhongDangSuDungActionPerformed

    private void DatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatPhongActionPerformed
        // TODO add your handling code here:
        GD_DatPhong uiDatPhong = new GD_DatPhong();

        uiDatPhong.setVisible(true);
    }//GEN-LAST:event_DatPhongActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        GD_TraPhong uiTraPhong = new GD_TraPhong();

        uiTraPhong.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void QuanLyPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuanLyPhongActionPerformed
        // TODO add your handling code here:
        GD_QuanLyPhong uiQLP = new  GD_QuanLyPhong();
        this.setVisible(false);
        uiQLP.setVisible(true);
    }//GEN-LAST:event_QuanLyPhongActionPerformed

    private void QuanLyLoaiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuanLyLoaiPhongActionPerformed
        // TODO add your handling code here:
        GD_QuanLyLoaiPhong uiQLLoaiPhong = new GD_QuanLyLoaiPhong();
        this.setVisible(false);
        uiQLLoaiPhong.setVisible(true);
    }//GEN-LAST:event_QuanLyLoaiPhongActionPerformed

    private void menuPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuPhongActionPerformed

    private void quanlyDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanlyDVActionPerformed
        // TODO add your handling code here:
        GD_QuanLyDichVu uiDV = new GD_QuanLyDichVu();
        this.setVisible(false);
        uiDV.setVisible(true);
    }//GEN-LAST:event_quanlyDVActionPerformed

    private void quanLyLoaiDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanLyLoaiDVActionPerformed
        // TODO add your handling code here:
        GD_QuanLyLoaiDichVu uiLoaiDV = new GD_QuanLyLoaiDichVu();
        this.setVisible(false);
        uiLoaiDV.setVisible(true);
    }//GEN-LAST:event_quanLyLoaiDVActionPerformed

    private void quanLyDonViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanLyDonViActionPerformed
        // TODO add your handling code here:
        GD_QuanLyDonVi uiDonVi = new GD_QuanLyDonVi();
        this.setVisible(false);
        uiDonVi.setVisible(true);
    }//GEN-LAST:event_quanLyDonViActionPerformed

    private void menuDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDichVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuDichVuActionPerformed

    private void quanLyKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanLyKHActionPerformed
        GD_QuanLyKhachHang uiKH = new GD_QuanLyKhachHang();
        this.setVisible(false);
        uiKH.setVisible(true);
    }//GEN-LAST:event_quanLyKHActionPerformed

    private void quanLyNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanLyNhanVienActionPerformed
        // TODO add your handling code here:
        GD_QuanLyNhanVien uiQLNV = new GD_QuanLyNhanVien();
        this.setVisible(false);
        uiQLNV.setVisible(true);
    }//GEN-LAST:event_quanLyNhanVienActionPerformed

    private void menuNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuNhanVienActionPerformed

    private void quanLyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quanLyHoaDonActionPerformed
        GD_QuanLyHoaDon uiHD = new GD_QuanLyHoaDon();
        this.setVisible(false);
        uiHD.setVisible(true);
    }//GEN-LAST:event_quanLyHoaDonActionPerformed

    private void menuHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuHoaDonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuHoaDonMouseClicked

    private void menuHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuHoaDonActionPerformed

    private void tkBieuDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkBieuDoActionPerformed
        // TODO add your handling code here:
        GD_ThongKeBieuDo uiTK = new GD_ThongKeBieuDo();
        this.setVisible(false);
        uiTK.setVisible(true);
    }//GEN-LAST:event_tkBieuDoActionPerformed

    private void menuThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuThongKeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuThongKeMouseClicked

    private void menuThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuThongKeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuThongKeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLyLoaiDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLyLoaiDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLyLoaiDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GD_QuanLyLoaiDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GD_QuanLyLoaiDichVu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem DatPhong;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenuItem PhongDangSuDung;
    private javax.swing.JMenuItem QuanLyLoaiPhong;
    private javax.swing.JMenuItem QuanLyPhong;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JLabel lblDSLP;
    private javax.swing.JLabel lblTenNVLogin;
    private javax.swing.JMenu menuDichVu;
    private javax.swing.JMenu menuHoaDon;
    private javax.swing.JMenu menuKhachHang;
    private javax.swing.JMenu menuNhanVien;
    private javax.swing.JMenu menuPhong;
    private javax.swing.JMenu menuThongKe;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlDSNV;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTTNV;
    private javax.swing.JMenuItem quanLyDonVi;
    private javax.swing.JMenuItem quanLyHoaDon;
    private javax.swing.JMenuItem quanLyKH;
    private javax.swing.JMenuItem quanLyLoaiDV;
    private javax.swing.JMenuItem quanLyNhanVien;
    private javax.swing.JMenuItem quanlyDV;
    private javax.swing.JScrollPane scrollDSLDV;
    private javax.swing.JTable tblDSLDV;
    private javax.swing.JMenuItem tkBieuDo;
    private javax.swing.JTextField txtMaLoaiDV;
    private javax.swing.JTextField txtTenLoaiDV;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
