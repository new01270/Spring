package co.syeon.ex3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("dao")
public class DaoTest {

	//@Autowired
	private DataSource dataSource; // <bean id="dataSource" />

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql = "SELECT membername FROM member WHERE memberid='hong'";

	public void run() {
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			System.out.println("DB연결 성공~!");

			if (rs.next()) {
				System.out.println(rs.getString("membername"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
