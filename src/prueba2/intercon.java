package prueba2;

import java.sql.Connection;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface intercon  {
public  Connection conectar();
public DefaultTableModel mostrar(JTable tbl);
public void insertar(int id_prod,String nombre,int precio,int id_categoria);
	

}
