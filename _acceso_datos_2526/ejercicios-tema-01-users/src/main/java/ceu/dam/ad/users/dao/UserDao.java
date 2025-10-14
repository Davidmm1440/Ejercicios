package ceu.dam.ad.users.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ceu.dam.ad.users.model.User;

public class UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

	/** Debe insertar un usuario en BBDD. Devuelve el ID generado. */
	public Long insert(Connection conn, User user) throws SQLException {
		String sql = "insert into usuarios (username, password, email, fecha_alta) values (?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.setDate(4, Date.valueOf(user.getCreatedDate()));
		ps.execute();
		logger.info("Usuario insertado");
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		return rs.getLong(1);

	}

	/**
	 * Debe consultar un usuario por su email y devolverlo. Si no existe, devolverá
	 * null
	 */
	public User getByEmail(Connection conn, String email) throws SQLException {
		String sql = "select * from usuarios where email = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			logger.info("Usuario encontrado con email: " + email);
			return rellenarUsuario(rs);
		}
		logger.error("No hay usuarios con ese email");
		return null;

	}

	/**
	 * Debe consultar un usuario por su ID y devolverlo. Si no existe, devolverá
	 * null. NOTA: no dupliques código
	 */
	public User getById(Connection conn, Long id) throws SQLException {
		String sql = "select * from usuarios where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			logger.info("Usuario encontrado con id: " + id);
			return rellenarUsuario(rs);
		}
		logger.error("No hay usuarios con ese id");
		return null;
	}

	/**
	 * Debe consultar un usuario por su username y devolverlo. Si no existe,
	 * devolverá null. NOTA: no dupliques código
	 */
	public User getByUserName(Connection conn, String userName) throws SQLException {
		String sql = "select * from usuarios where username = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			logger.info("Usuario encontrado con username: " + userName);
			return rellenarUsuario(rs);
		}
		logger.error("No hay usuarios con ese username");
		return null;
	}

	/**
	 * Debe actualizar todos los datos de un usuario y devolver el número de
	 * registros actualizados.
	 */
	public Integer update(Connection conn, User user) throws SQLException {
		String sql = "update usuarios set username = ?, password = ?, email = ?, fecha_alta = ?, fecha_ult_login = ? where id = ?"; // integer
																																	// i
																																	// =
																																	// ps.executeUpdate();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getEmail());
		ps.setDate(4, Date.valueOf(user.getCreatedDate()));
		ps.setDate(5, Date.valueOf(user.getLastLoginDate()));
		ps.setLong(5, user.getId());
		return ps.executeUpdate();
	}

	private User rellenarUsuario(ResultSet rs) throws SQLException {
		User u = new User();
		u.setId(rs.getLong("id"));
		u.setUsername(rs.getString("username"));
		u.setPassword(rs.getString("password"));
		u.setEmail(rs.getString("email"));
		Date date = rs.getDate("fecha_alta");
		u.setCreatedDate(date.toLocalDate());
		Date date2 = rs.getDate("fecha_ult_login");
		if (date2 != null) {
			u.setLastLoginDate(date2.toLocalDate());
			u.setLastLoginDate(LocalDate.now());
		}
		u.setLastLoginDate(null);
		return u;
	}

}
