import java.sql.*;
import java.util.Scanner;

public class BBDD {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		String comando = "", name = "",nombre="", cantidad="", comentario="";
		String[] insertar=null;
		
		Connection conn = null;		
		PreparedStatement consulta = null;
		ResultSet rs = null;
		
		while(!comando.equalsIgnoreCase("exit")){
			System.out.println("Escriba comando: ");
			comando = sc.nextLine();
			if(comando.startsWith("SEARCH")){
				name = comando.substring(7, comando.length());
				comando = "SEARCH";
			}else if(comando.startsWith("INSERT")){
				insertar = comando.split(":");
				comando = insertar[0];
				nombre = insertar[1];
				cantidad = insertar[2];
				comentario = insertar[3];
			}
			switch(comando.toUpperCase()){
			case "CONNECT":
				//CAMBIAR URL BBDD
				conn = DriverManager.getConnection("PONER URL DE LA BBDD"); 
				if(conn.isValid(10)){
					System.out.println("Conexción válida.");
				}else{
					System.out.println("No se ha podido conectar a la base de datos");
				}
				break;
			case "DISCONNECT":
				conn.close();
				System.out.println("Desconectada.");
				break;
			case "SHOW":
				if(rs == null){
					System.out.println("No hay nada que mostrar.");
				}else{
					while(rs.next()){
						System.out.println("Nombre: " + rs.getString(2) + ", ID: " + rs.getString(1));
					}
				}
				break;
			case "SEARCH":
				consulta = conn.prepareStatement("SELECT * FROM inventario WHERE nombre like ? ");
				consulta.setString(2, name);
				rs = consulta.executeQuery();
				if(rs.getRow() > 0){
					System.out.println("Consulta hecha con éxito.");
				}else{
					System.out.println("No existen referencias al objeto");
				}
				break;
			case "INSERT":
				consulta = conn.prepareStatement("INSERT into inventario(Nombre,Cantidad,Comentario) "
						+ "VALUES(?,?,?");
				consulta.setString(2, nombre);
				consulta.setString(3, cantidad);
				consulta.setString(4, comentario);
				int r = consulta.executeUpdate();
				if(r == 0){
					System.out.println("No se ha podido insertar los datos.");
				}else{
					System.out.println("Datos insertados con éxito.");
				}
				break;
			}
		}
		System.out.println("Programa cerrado.");
		consulta.close();
		
	}

}
