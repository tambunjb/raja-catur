import java.sql.*;
public class Data  
{
	private int no,waktu;
	private String query;
	private String nama;
	private double skor;
	Connection con;
	Statement stmt;
	ResultSet rs;
	Data(){
		query = "";
		 try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=Catur.mdb");
				stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		}catch(ClassNotFoundException cnfe) {
				System.out.println("Terjadi kesalahan: " + cnfe.getMessage());
		}catch(SQLException sqle) {
				System.out.println("Terjadi kesalahan: " + sqle.getMessage());
		}
	}
	public void tambahData(String nama, double skor, int waktu){
		try
		{
			int count = 1;
			rs = stmt.executeQuery("SELECT * FROM Data");
			while (rs.next())
			{
				count++;
			}
			query = "INSERT INTO Data VALUES("+count+",'"+nama+"',"+skor+","+waktu+")";
			//System.out.println(query);
			//stmt = con.createStatement();
			stmt.executeUpdate(query);
			//stmt.close();
		}
		catch (SQLException sqle)
		{
			System.out.println("Terjadi kesalahan: " + sqle.getMessage());
		}
	}
	public void updateWaktu(String nm, int wkt){
		try
		{
			query = "UPDATE Data SET Waktu = 44.5 WHERE Nama='Cor'";
			//stmt = con.createStatement();
			int row = stmt.executeUpdate(query);
			//System.out.println(row);
			
			//stmt.close();
		}
		catch (SQLException sqle)
		{
			System.out.println("Terjadi kesalahan: " + sqle.getMessage());
		}		
	}
	public void updateSkor(String nm, double skr){
		double temp=0;		
		try
		{
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("SELECT * FROM Data");
			while (rs.next())
			{
				if (rs.getString("Nama").equals(nm))
				{
					temp = skr + rs.getDouble("Skor");					
				}
			}
			query = "UPDATE Data SET Skor = "+temp+" WHERE Waktu = 70";
			//System.out.println(query);
			int row = stmt.executeUpdate(query);
			stmt.close();
		}
		catch (SQLException sqle)
		{
			System.out.println("Terjadi kesalahan: " + sqle.getMessage());
		}		
	}
	public void highScore(){
		int hs = 0,cek= 0,temp,ths;
		String name="",tname;
		Double scor=0.0d,tscor;
		ResultSet rs1;
		try
		{
			stmt = con.createStatement();
			rs1 = stmt.executeQuery("SELECT * FROM Data");
			while (rs1.next())
			{
				ths = rs1.getInt("Waktu");
				tname = rs1.getString("Nama");
				tscor = rs1.getDouble("Skor");
				if (cek==0)
				{
					hs = ths;
					name = tname;
					scor = tscor;cek++;
				}
				if (hs>ths)
				{
					hs = ths;
					name = tname;
					scor = tscor;cek++;
				}				
			}
			
			System.out.println("Nama	Skor	Waktu");
			System.out.println(""+name+"\t"+scor+"\t"+hs);
			stmt.close();			
		}
		catch (SQLException sqle)
		{
			System.out.println("Terjadi kesalahan : "+sqle.getMessage());
		}
	}
	public static void main(String [] agrs){
		Data d = new Data();
		d.tambahData("Dosen",1.3,70);
		//d.highScore();
		d.updateSkor("Dosen",10.9);
		//d.updateWaktu("Jona",345);

	}
}
