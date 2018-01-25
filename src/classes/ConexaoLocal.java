package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ConexaoLocal {

	Connection conexao;
	
	public ConexaoLocal(){
		System.out.println("Inicio Conexao com Postgres");
		
		try {
			String usuario = "dba";
			String senha = "mobile";
			String ip = "127.0.0.1";
			String porta = "5432";
			String nomeBanco = "produtoo";
			
			Class.forName("org.postgresql.Driver");
			
			conexao = DriverManager.getConnection( "jdbc:postgresql://" + ip + ":" + porta + "/" + nomeBanco, usuario, senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public void salvar(List<Cliente> produtos) {
		
		System.out.println("Inserindo clientes...");

		try {
			
			String insert = "INSERT INTO cliente ( idcliente, idconvenio, idpagamento, idpromocao, ufclifor, nome, cnpjcpf, endereco, bairro, perdesconto, dtcadastro, fonefax, fone1, fone2, fonecelular, numcartaomag, vallimitecredito, vallimiteconvenio, vallimitecheque, dtvalidadecartao, inscrestadual, obsgeral, senhaconvenio, nomefantasia, email, tipofisicajuridica, flaginativo, flagnaoconschqserasa, dtultimaalteracao, url, dtalteracao, flagclientevip, descrcidade, cep, tipotestecliente, chapafolhapgto, numeroresidencial, idcidade, flagnaoconsultacheques, flagrestringeformaspagto, perminimoentrada, idvencimentocartaoproprio, flagutilizapontuacao, descrestado, pais, codigoibge, tipocadastro, flagnaoenviadadoscliforxml, dtinicialpromocao, dtfinalpromocao, progpontuacao  ) ";
			insert += " VALUES ( ?, ?, ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?, ?, ?, ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?, ?, ?, ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?, ?, ?, ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?, ?, ?, ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?, ? ) ";

			PreparedStatement ps = conexao.prepareStatement( insert );
			
			for( Cliente p : produtos){
				
				ps.setLong( 1, p.getIdcliente() );
				ps.setLong( 2, p.getIdconvenio( ) );
				ps.setLong( 3, p.getIdpagamento( ) );
				ps.setLong( 4, p.getIdpromocao( ) );
				ps.setString( 5, p.getUfclifor(  ) );
				ps.setString( 6, p.getNome( ) );
				ps.setString( 7, p.getCnpjcpf( ) );
				ps.setString( 8, p.getEndereco( ) );
				ps.setString( 9, p.getBairro( ) );
				ps.setDouble( 10, p.getPerdesconto( ) );
				ps.setDate( 11, p.getDtcadastro( ) );
				ps.setString( 12, p.getFonefax( ) );
				ps.setString( 13, p.getFone1( ) );
				ps.setString( 14, p.getFone2( ) );
				ps.setString( 15, p.getFonecelular( ) );
				ps.setString( 16, p.getNumcartaomag( ) );
				ps.setDouble( 17, p.getVallimitecredito( ) );
				ps.setDouble( 18, p.getVallimiteconvenio( ) );
				ps.setDouble( 19, p.getVallimitecheque( ) );
				ps.setDate( 20, p.getDtvalidadecartao( ) );
				ps.setString( 21, p.getInscrestadual( ) );
				ps.setString( 22, p.getObsgeral( ) );
				ps.setInt( 23, p.getSenhaconvenio( ) );
				ps.setString( 24, p.getNomefantasia( ) );
				ps.setString( 25, p.getEmail( ) );
				ps.setString( 26, p.getTipofisicajuridica( ) );
				ps.setString( 27, p.getFlaginativo( ) );
				ps.setString( 28, p.getFlagnaoconschqserasa( ) );
				ps.setDate( 29, p.getDtultimaalteracao( ) );
				ps.setString( 30, p.getUrl( ) );
				ps.setDate( 31, p.getDtalteracao( ) );
				ps.setString( 32, p.getFlagclientevip( ) );
				ps.setString( 33, p.getDescrcidade( ) );
				ps.setString( 34, p.getCep( ) );
				ps.setString( 35, p.getTipotestecliente( ) );
				ps.setString( 36, p.getChapafolhapgto( ) );
				ps.setString( 37, p.getNumeroresidencial( ) );
				ps.setInt( 38, p.getIdcidade( ) );
				ps.setString( 39, p.getFlagnaoconsultacheques( ) );
				ps.setString( 40, p.getFlagrestringeformaspagto( ) );
				ps.setDouble( 41, p.getPerminimoentrada( ) );
				ps.setLong( 42, p.getIdvencimentocartaoproprio( ) );
				ps.setString( 43, p.getFlagutilizapontuacao( ) );
				ps.setString( 44, p.getDescrestado( ) );
				ps.setString( 45, p.getPais( ) );
				ps.setLong( 46, p.getCodigoibge(  ) );
				ps.setString( 47, p.getTipocadastro( ) );
				ps.setString( 48, p.getFlagnaoenviadadoscliforxml( ) );
				ps.setDate( 49, p.getDtinicialpromocao( ) );
				ps.setDate( 50, p.getDtfinalpromocao( ) );
				ps.setString( 51, p.getProgpontuacao( ) );
				
				ps.addBatch();
			}
			
			ps.executeBatch();
			ps.close();

			System.out.println("Clientes inseridos");			
						
			//this.AtualizarDadosNosCaixas();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}

	private void AtualizarDadosNosCaixas() {
		try {
			String usuario = "dba";
			String senha = "mobile";
			String porta = "5432";
			String nomeBanco = "produtoo";
			
			Class.forName("org.postgresql.Driver");
			
			String ip = "127.0.0.1";
			conexao = DriverManager.getConnection( "jdbc:postgresql://" + ip + ":" + porta + "/" + nomeBanco, usuario, senha);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Desconectar(){
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
