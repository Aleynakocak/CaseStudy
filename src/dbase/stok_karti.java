package dbase;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class stok_karti extends JFrame {

	private JPanel contentPane;
	private JTextField txt_stok_kodu;
	private JTextField txt_stok_adi;
	private JTextField txt_barkod;
	private JTable table;
	private JTextField txtAra;

	
     DefaultTableModel model= new DefaultTableModel();
     Object[] kolonlar= {"stok_kodu","stok_adi","stok_tipi","birim","barkod","kdv_tipi","aciklama","tarih"};
	 Object[] satirlar= new Object[8];
	 
	 
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stok_karti frame = new stok_karti();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public stok_karti() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1056, 782);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 182, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		txt_stok_kodu = new JTextField();
		txt_stok_kodu.setBounds(245, 378, 115, 27);
		contentPane.add(txt_stok_kodu);
		txt_stok_kodu.setColumns(10);
		
		txt_stok_adi = new JTextField();
		txt_stok_adi.setColumns(10);
		txt_stok_adi.setBounds(245, 415, 115, 27);
		contentPane.add(txt_stok_adi);
		
		txt_barkod = new JTextField();
		txt_barkod.setColumns(10);
		txt_barkod.setBounds(245, 572, 115, 27);
		contentPane.add(txt_barkod);
		
		txtAra = new JTextField();
		txtAra.setBounds(268, 80, 139, 43);
		contentPane.add(txtAra);
		txtAra.setColumns(10);
		
		
		
		JLabel lblStokTakip = new JLabel("STOK    TAK\u0130P");
		lblStokTakip.setForeground(new Color(0, 0, 0));
		lblStokTakip.setBounds(348, 10, 315, 60);
		lblStokTakip.setHorizontalAlignment(SwingConstants.CENTER);
		lblStokTakip.setFont(new Font("Serif", Font.BOLD, 33));
		contentPane.add(lblStokTakip);		
		
		JLabel lblNewLabel = new JLabel("Stok Ad\u0131");
		lblNewLabel.setBounds(124, 420, 89, 27);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel);
		
		JLabel lblStokKodu = new JLabel("Stok Kodu");
		lblStokKodu.setBounds(105, 374, 108, 27);
		lblStokKodu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStokKodu.setFont(new Font("Serif", Font.BOLD, 20));
		contentPane.add(lblStokKodu);
		
		JLabel lblStokTipi = new JLabel("Stok Tipi");
		lblStokTipi.setBounds(124, 494, 89, 27);
		lblStokTipi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStokTipi.setFont(new Font("Serif", Font.BOLD, 20));
		contentPane.add(lblStokTipi);
		
		JLabel lblBirim = new JLabel("Birim");
		lblBirim.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBirim.setFont(new Font("Serif", Font.BOLD, 20));
		lblBirim.setBounds(124, 457, 89, 27);
		contentPane.add(lblBirim);
		
		JLabel lblBarkod = new JLabel("Barkod");
		lblBarkod.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBarkod.setFont(new Font("Serif", Font.BOLD, 20));
		lblBarkod.setBounds(124, 568, 89, 27);
		contentPane.add(lblBarkod);
		
		JLabel lblKdvTipi = new JLabel("Kdv Tipi");
		lblKdvTipi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKdvTipi.setFont(new Font("Serif", Font.BOLD, 20));
		lblKdvTipi.setBounds(124, 531, 89, 27);
		contentPane.add(lblKdvTipi);
		
		JLabel lblAklama = new JLabel("A\u00E7\u0131klama");
		lblAklama.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAklama.setFont(new Font("Serif", Font.BOLD, 20));
		lblAklama.setBounds(124, 641, 89, 27);
		contentPane.add(lblAklama);
		
		JLabel lblOluturmaTarihi = new JLabel("Olu\u015Fturma Tarihi");
		lblOluturmaTarihi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOluturmaTarihi.setFont(new Font("Serif", Font.BOLD, 20));
		lblOluturmaTarihi.setBounds(47, 611, 166, 27);
		contentPane.add(lblOluturmaTarihi);
		
		JLabel lblArananStokKodu = new JLabel("Stok Kodu:");
		lblArananStokKodu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArananStokKodu.setFont(new Font("Serif", Font.BOLD, 20));
		lblArananStokKodu.setBounds(89, 80, 169, 43);
		contentPane.add(lblArananStokKodu);
		
		JComboBox cmb_stok_tipi = new JComboBox();
		cmb_stok_tipi.setFont(new Font("Serif", Font.PLAIN, 16));
		cmb_stok_tipi.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz", "10", "100", "1000"}));
		cmb_stok_tipi.setBounds(245, 496, 115, 27);
		contentPane.add(cmb_stok_tipi);
		
		JComboBox cmb_birim = new JComboBox();
		DefaultComboBoxModel theModel = (DefaultComboBoxModel)cmb_birim.getModel();
		theModel.removeAllElements();
		cmb_birim.setFont(new Font("Serif", Font.PLAIN, 16));
		cmb_birim.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz", "adet", "koli"}));
		cmb_birim.setBounds(245, 459, 115, 27);
		contentPane.add(cmb_birim);
		
		JComboBox cmb_kdv_tipi = new JComboBox();
		cmb_kdv_tipi.setFont(new Font("Serif", Font.PLAIN, 16));
		cmb_kdv_tipi.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz", "0.8", "1.0", "1.8"}));
		cmb_kdv_tipi.setBounds(245, 533, 115, 27);
		contentPane.add(cmb_kdv_tipi);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(245, 651, 212, 71);
		contentPane.add(textArea);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(245, 615, 175, 27);
		contentPane.add(formattedTextField);
		
		
		
		
		//---KAYDET BUTONU---//
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String kod,ad,stokBirim,barkod,aciklama,tarih,sql_string;
			    int  stokTipi;
			    double kdvTipi;
			    
				kod=txt_stok_kodu.getText();
				ad=txt_stok_adi.getText();
				stokTipi=Integer.valueOf(cmb_stok_tipi.getSelectedItem().toString());
				stokBirim=cmb_birim.getSelectedItem().toString();
				barkod=txt_barkod.getText();
				kdvTipi=Double.valueOf(cmb_kdv_tipi.getSelectedItem().toString());
				aciklama=textArea.getText();
				tarih=formattedTextField.getText();
				sql_string="INSERT INTO stok_karti (stok_kodu,stok_adi,stok_tipi,birim,barkod,kdv_tipi,aciklama,tarih) VALUES('"+kod+"','"+ad+"','"+stokTipi+"','"+stokBirim+"','"+barkod+"','"+kdvTipi+"','"+aciklama+"','"+tarih+"') ";
				//System.out.println(sql_string);
				
				connection.kaydet(sql_string);

			}
		});
		btnKaydet.setFont(new Font("Serif", Font.BOLD, 20));
		btnKaydet.setBounds(578, 403, 145, 43);
		contentPane.add(btnKaydet);
		
		
		
		
		//---SÝL BUTONU---//
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    String kod,sql_string;
				kod=txt_stok_kodu.getText();
				//JOptionPane.showMessageDialog(null, "Var olmayan stok kodu", "Mesaj -1", -1);
				sql_string="DELETE FROM stok_karti WHERE stok_kodu='"+kod+"'";
				connection.sil(sql_string);
			}
		});
		
		
		btnSil.setFont(new Font("Serif", Font.BOLD, 20));
		btnSil.setBounds(578, 568, 145, 43);
		contentPane.add(btnSil);
		
		
		
		
		//---GÜNCELLE BUTONU---//
		JButton btnGncelle = new JButton("G\u00FCncelle");
		btnGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String kod,ad,stokBirim,barkod,aciklama,tarih,sql_string;
			    int  stokTipi;
			    double kdvTipi;
				kod=txt_stok_kodu.getText();
				ad=txt_stok_adi.getText();
				stokTipi=Integer.valueOf(cmb_stok_tipi.getSelectedItem().toString());
				stokBirim=cmb_birim.getSelectedItem().toString();
				barkod=txt_barkod.getText();
				kdvTipi=Double.valueOf(cmb_kdv_tipi.getSelectedItem().toString());
				aciklama=textArea.getText();
				tarih=formattedTextField.getText();
				sql_string="UPDATE stok_karti  SET stok_kodu='"+kod+"', stok_adi='"+ad+"', stok_tipi='"+stokTipi+"', birim='"+stokBirim+"',barkod='"+barkod+"',kdv_tipi='"+kdvTipi+"',aciklama='"+aciklama+"',tarih='"+tarih+"' WHERE stok_kodu='"+kod+"'";
				connection.guncelle(sql_string);
			    //JOptionPane.showMessageDialog(null, "Güncellendi", "Mesaj -1", -1);
				
			}
		});
		btnGncelle.setFont(new Font("Serif", Font.BOLD, 20));
		btnGncelle.setBounds(578, 457, 145, 43);
		contentPane.add(btnGncelle);
		
		
		
		
		//---KOPYALA BUTONU---//
		
		
		JButton btnKopyala = new JButton("Kopyala");
		btnKopyala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kod,ad,stokBirim,barkod,aciklama,tarih,sql_string;
			    int  stokTipi;
			    double kdvTipi;
				kod=txt_stok_kodu.getText();
				ad=txt_stok_adi.getText();
				stokTipi=Integer.valueOf(cmb_stok_tipi.getSelectedItem().toString());
				stokBirim=cmb_birim.getSelectedItem().toString();
				barkod=txt_barkod.getText();
				kdvTipi=Double.valueOf(cmb_kdv_tipi.getSelectedItem().toString());
				aciklama=textArea.getText();
				tarih=formattedTextField.getText();
				sql_string="INSERT INTO stok_karti (stok_kodu,stok_adi,stok_tipi,birim,barkod,kdv_tipi,aciklama,tarih) VALUES('"+kod+"','"+ad+"','"+stokTipi+"','"+stokBirim+"','"+barkod+"','"+kdvTipi+"','"+aciklama+"','"+tarih+"') ";
				//sql_string="INSERT INTO stok_karti( idstok_kodu,stok_adi,stok_tipi,birim,barkod,kdv_tipi,aciklama,olusturma_tarihi ) VALUES ( '"+kopya+"','"+ad+"','"+stokTipi+"','"+stokBirim+"','"+barkod+"','"+kdvTipi+"','"+aciklama+"','"+tarih+"' ) WHERE idstok_kodu = '"+kod+"'";
			    connection.kopyala(sql_string);
			}
		});
		btnKopyala.setFont(new Font("Serif", Font.BOLD, 20));
		btnKopyala.setBounds(578, 510, 145, 43);
		contentPane.add(btnKopyala);


		
		 
		//---ARA BUTONU---//
		JButton btnArama = new JButton("Ara");
		btnArama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				String kod=txtAra.getText();
				ResultSet myRs=null;
				String sql_string="SELECT * FROM stok_karti WHERE stok_kodu='"+kod+"'";
				
				myRs=connection.ara(sql_string);
				try {
					while(myRs.next()) {
						satirlar[0]=myRs.getString("stok_kodu");
						satirlar[1]=myRs.getString("stok_adi");
						satirlar[2]=myRs.getString("stok_tipi");
						satirlar[3]=myRs.getString("birim");
						satirlar[4]=myRs.getString("barkod");
						satirlar[5]=myRs.getString("kdv_tipi");
						satirlar[6]=myRs.getString("aciklama");
						satirlar[7]=myRs.getString("tarih");
						model.addRow(satirlar);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}					

					table.setModel(model);
			}
		});
		btnArama.setFont(new Font("Serif", Font.BOLD, 20));
		btnArama.setBounds(417, 80, 145, 43);
		contentPane.add(btnArama);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(66, 152, 896, 209);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model.setColumnIdentifiers(kolonlar);

		table.setBounds(521, 450, 461, 187);
		//contentPane.add(table);
		scrollPane.setViewportView(table);
		
		
		
		
		//---LÝSTELE BUTONU---//
		JButton btnListele = new JButton("Listele");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0); //listeleye kaç kere týklanýrsa týklansýn bir kere listeler.
				
				ResultSet myRs=connection.baglan();
				try {
					while(myRs.next()) {
						satirlar[0]=myRs.getString("stok_kodu");
						satirlar[1]=myRs.getString("stok_adi");
						satirlar[2]=myRs.getString("stok_tipi");
						satirlar[3]=myRs.getString("birim");
						satirlar[4]=myRs.getString("barkod");
					    satirlar[5]=myRs.getString("kdv_tipi");
						satirlar[6]=myRs.getString("aciklama");
						satirlar[7]=myRs.getString("tarih");
						model.addRow(satirlar);

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				table.setModel(model);
			}
		});
		btnListele.setFont(new Font("Serif", Font.BOLD, 20));
		btnListele.setBounds(572, 80, 223, 43);
		contentPane.add(btnListele);
		
		//---TEMÝZLE BUTONU---//
		JButton btn_temizle = new JButton("Temizle");
		btn_temizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  txt_stok_kodu.setText("");
			      txt_stok_adi.setText("");		
			      cmb_stok_tipi.setSelectedIndex(0);
			      cmb_birim.setSelectedIndex(0);		
			      txt_barkod.setText("");
			      cmb_kdv_tipi.setSelectedIndex(0);			     
			      formattedTextField.setText("");
			}
		});
		btn_temizle.setFont(new Font("Serif", Font.BOLD, 20));
		btn_temizle.setBounds(578, 625, 145, 43);
		contentPane.add(btn_temizle);
		
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			  
			    public void mouseClicked(MouseEvent e) {
			    	
			
				txt_stok_kodu.setText((String) model.getValueAt(table.getSelectedRow(), 0));
				txt_stok_adi.setText((String) model.getValueAt(table.getSelectedRow(), 1));
			    cmb_stok_tipi.setSelectedItem((String) model.getValueAt(table.getSelectedRow(),2));
			    cmb_birim.setSelectedItem((String) model.getValueAt(table.getSelectedRow(),3));
				txt_barkod.setText((String) model.getValueAt(table.getSelectedRow(), 4));
			    cmb_kdv_tipi.setSelectedItem((String) model.getValueAt(table.getSelectedRow(),5));
				textArea.setText((String) model.getValueAt(table.getSelectedRow(), 6));
				formattedTextField.setText((String) model.getValueAt(table.getSelectedRow(), 7));
				
			}
		});
		
		
	}
}
