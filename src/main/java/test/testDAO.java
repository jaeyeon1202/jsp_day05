package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.proxy.annotation.Pre;

public class testDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public testDAO() {
		con = DBConnect.getConnect();
		System.out.println("dao 생성자 실행");
	}
	
	public ArrayList<testDTO> list() {
		System.out.println("list실행");
		ArrayList<testDTO> list = new ArrayList<>();
		
		//String sql = "select * from test_board";
		String sql =  "select * from test_board order by idgroup desc, step asc";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				testDTO dto = new testDTO();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setSavedate(rs.getTimestamp("savedate"));
				dto.setHit(rs.getInt("hit"));
				dto.setStep(rs.getInt("step"));
				dto.setIndent(rs.getInt("indent"));
				dto.setIdgroup(rs.getInt("idgroup"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}//list
	

	public int writeSave(testDTO dto) {
		System.out.println("wrtieSave 실행");
		int result = 0;
		
		String sql =
				"insert into test_board(id,name,title,content,idgroup,step,indent)"
				+" values(test_board_seq.nextval,?,?,?,test_board_seq.currval,0,0)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}//wrtieSave
	
	private void upHit(int id) {
		System.out.println("uphit 실행");
		String sql = "update test_board set hit = hit + 1 where id ="+id;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//upHit
	
	public testDTO contentView(int id) {
		upHit(id);
		System.out.println("contentView 실행");
		testDTO dto = null;
		String sql = "select * from test_board where id="+id;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new testDTO();
				
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setSavedate(rs.getTimestamp("savedate"));
				dto.setHit(rs.getInt("hit"));
				dto.setStep(rs.getInt("step"));
				dto.setIndent(rs.getInt("indent"));
				dto.setIdgroup(rs.getInt("idgroup"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}//contentView
	
	public void modify(testDTO dto){
		System.out.println("modify 실행");
		
		String sql = "update test_board set name=?, title=?, content=? where id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			ps.setInt(4, dto.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//modify
	
	public int delete(int id) {
		System.out.println("delete 실행");
		String sql = "delete from test_board where id="+id;
		int result =0;
		try {
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}//delete
	
	private void replyShape(testDTO d) {
		String sql = "update test_board set step=step+1 where idgroup=? and step>?";
		try {
			ps =con.prepareStatement(sql);
			
			ps.setInt(1, d.getIdgroup());
			ps.setInt(2, d.getStep());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//replyShape
	
	public void reply(testDTO dto) {
		System.out.println("reply 실행");
		
		testDTO d = contentView(dto.getId());
		System.out.println("dd"+d.getIdgroup());
		
		replyShape(d);
		
		String sql = "insert into test_board(id, name, title, content, idgroup, step, indent)"
				+"values(test_board_seq.nextval,?,?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			
			ps.setInt(4, d.getIdgroup());
			ps.setInt(5, d.getStep()+1);
			ps.setInt(6, d.getIndent()+1);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//reply
	
}
