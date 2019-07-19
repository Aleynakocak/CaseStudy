package dbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class connection {
    static Connection conn;
    static Statement myStat;
    static ResultSet myRs;
   
    
	static ResultSet baglan(){
		ResultSet myRs=null;
  try { 
	   conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stok_db?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey&useSSL=false","root","1234");
	   myStat=(Statement) conn.createStatement();
	   myRs=myStat.executeQuery("select * from stok_karti");
	 
	  }catch(Exception e){
		 e.printStackTrace();
	   }  
   return myRs;
	}
	
	
	//---KAYDET---//
	static void kaydet(String sql_sorgu) {
		
		try {
			
			baglan();
			myStat.executeUpdate(sql_sorgu);

		} catch (SQLException e) {
		
			e.printStackTrace();
		}

	}
	
	
	//---GÜNCELLE---//
    static void guncelle(String sql_sorgu) {
		
		try {
			
			baglan();
			myStat.executeUpdate(sql_sorgu);
			
				 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	  }
    
    
	//---SÝL---//
    static void sil(String sql_sorgu) {
		
  		try {
  			
  			baglan();
  			myStat.executeUpdate(sql_sorgu);
  			
  				 
  		} catch (SQLException e) {
  			
  			e.printStackTrace();
  		}
  	  }
    
    
	//---ARA---//
    static ResultSet ara(String sql_string) {
    	
    	ResultSet myRs=null;
    	
    	try {
    		baglan();
			myRs=myStat.executeQuery(sql_string);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return myRs;
    	
    }
    
    
	//---KOPYALA---//
    static void kopyala(String sql_sorgu) {
		
		try {
			
			baglan();
			myStat.executeUpdate(sql_sorgu);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
    
    
}
