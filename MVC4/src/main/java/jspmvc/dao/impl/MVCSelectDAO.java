package jspmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jspmvc.dao.MVCAbstractDAO;
import jspmvc.model.MVCDTO;
import jspmvc.util.ConnectionUtil;

public class MVCSelectDAO extends MVCAbstractDAO {
   
   @Override
   public List<MVCDTO> select() {
      
      String sql = " select sid, title, content from jspmvc order by sid desc ";
      
      ConnectionUtil connUtil = new ConnectionUtil();
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      List<MVCDTO> list = null;
      
      try {
         conn = connUtil.getConnection();
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         if (rs!=null) {
            list = new ArrayList<MVCDTO>();
            while (rs.next()) {
               MVCDTO dto = new MVCDTO();
               dto.setSid(rs.getInt("sid"));
               dto.setTitle(rs.getString("title"));
               dto.setContent(rs.getString("content"));
               list.add(dto);
            }
         }
         return list;
      } catch (Exception ex) {
         ex.printStackTrace();
         return null;
      } finally {
         try {
            connUtil.closeConnection(conn);
         } catch (Exception ex) {
            ex.printStackTrace();
         }
      }
      
   } // select

@Override
public MVCDTO get(int sid) {
	// TODO Auto-generated method stub
	return null;
}

} // class







