package prueba2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class conectar implements intercon {
	int id_prod;
	String nombre;
	int precio;
	int id_categoria;
	Connection con;
	Statement st;
	ResultSet rs;
	public conectar() {
		
	}
/**
	 * @return the con
	 */
	public Connection getCon() {
		return con;
	}
	/**
	 * @param con the con to set
	 */
	public void setCon(Connection con) {
		this.con = con;
	}
	/**
	 * @return the st
	 */
	public Statement getSt() {
		return st;
	}
	/**
	 * @param st the st to set
	 */
	public void setSt(Statement st) {
		this.st = st;
	}
	/**
	 * @return the rs
	 */
	public ResultSet getRs() {
		return rs;
	}
	/**
	 * @param rs the rs to set
	 */
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
/**
	 * @return the id_prod
	 */
	public int getId_prod() {
		return id_prod;
	}
	/**
	 * @param id_prod the id_prod to set
	 */
	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the precio
	 */
	public int getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	/**
	 * @return the id_categoria
	 */
	public int getId_categoria() {
		return id_categoria;
	}
	/**
	 * @param id_categoria the id_categoria to set
	 */
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
public conectar(int id_prod, String nombre, int precio, int id_categoria) {
		super();
		this.id_prod = id_prod;
		this.nombre = nombre;
		this.precio = precio;
		this.id_categoria = id_categoria;
	}

public Connection conectar() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost/tienda";
		con=(Connection)DriverManager.getConnection(url,"root","mysqladmin");
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "error de cnexion  "+e.getMessage());
	}
	return con;
}

public DefaultTableModel mostrar(JTable tbl) {
	DefaultTableModel table = new DefaultTableModel();
	table.addColumn("id_producto");
	table.addColumn("nombre");
	table.addColumn("precio");
	table.addColumn("id_categoria");
	tbl.setModel(table);
	try {
		String query="select * from producto";
		st=conectar().createStatement();
		rs=st.executeQuery(query);
		String[] tabla = new String[4];
		while(rs.next()) {
			tabla[0]=rs.getString(1);
			tabla[1]=rs.getString(2);
			tabla[2]=rs.getString(3);
			tabla[3]=rs.getString(4);
			table.addRow(tabla);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return table;
	
}

public void insertar(int id_prod,String nombre,int precio,int id_categoria) {
	try {
		String sql="insert into producto values(?,?,?,?)";
		PreparedStatement ps=conectar().prepareStatement(sql);
		ps.setInt(1, id_prod);
		ps.setString(2, nombre);
		ps.setInt(3, precio);
		ps.setInt(4, id_categoria);
		ps.executeUpdate();
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
}
}
 
	

