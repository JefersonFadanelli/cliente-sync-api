package classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SincronizadorMain {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		long inicio;
		List<Cliente> clientes;
		ConexaoLocal conexaoLocal;
		ConexaoERP conexaoERP;
		int contador = 0;
		conexaoERP = new ConexaoERP();
		conexaoLocal = new ConexaoLocal();

		while( true ){
			
			clientes = new ArrayList<Cliente>(); 
						
			inicio = System.currentTimeMillis();
			
			clientes = conexaoERP.getProdutos();
			
			if( clientes.size() > 0 ) {
				

				conexaoLocal.salvar( clientes );

				long atual = System.currentTimeMillis() - inicio;
				System.out.println("Atualização completada - Tempo: " + atual + "ms");
				
			}else{
				System.out.println("Nenhuma atualização");				
			}
			
			try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }

			//break;

			if(contador < 3){
				contador++;
			}else{
				break;
			}
		}
		
		conexaoERP.Desconectar();
		conexaoLocal.Desconectar();

	}

}
