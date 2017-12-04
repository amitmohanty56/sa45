package sample.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javassist.NotFoundException;
import sample.dao.StudentDAO;
import sample.model.Student;

public class StudentDAOImpl implements StudentDAO {

	
	public StudentDAOImpl() {
		
	}

	
	public Student getObject(int studentId) throws NotFoundException, SQLException {
		Connection	conn = DBUtility.getConnection();
		Student valueObject = createValueObject();
		valueObject.setStudentId(studentId);
		find(valueObject);
		return valueObject;
	}

	private Student createValueObject() {
		// TODO Auto-generated method stub
		return new Student();
	}

	
	public Student find(Student valueObject) throws SQLException {
		Student s = null;
		String sql = "SELECT * FROM student WHERE (id = ? ) ";
		PreparedStatement stmt = null;
		Connection	conn = DBUtility.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getStudentId());

			s= singleQuery(stmt, valueObject);

		} finally {
			if (stmt != null)
				stmt.close();
		}
		return s;
	}

    public List<Student> findAll() throws SQLException {
    	Connection	conn = DBUtility.getConnection();
		String sql = "SELECT * FROM student ORDER BY id ASC ";
		List<Student> searchResults = listQuery(conn.prepareStatement(sql));

		return searchResults;
	}


	public synchronized int create(Student valueObject) throws SQLException {
		Connection	conn = DBUtility.getConnection();
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;
		int rowcount = 0;

		try {
			sql = "INSERT INTO student ( name, nick, course) VALUES (?, ?, ?) ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, valueObject.getName());
			stmt.setString(2, valueObject.getNick());
			stmt.setString(3, valueObject.getCourse());

			rowcount = databaseUpdate(stmt);
			if (rowcount != 1) {
				// System.out.println("PrimaryKey Error when updating DB!");
				throw new SQLException("PrimaryKey Error when updating DB!");
			}

		} finally {
			if (stmt != null)
				stmt.close();
		}

		/**
		 * The following query will read the automatically generated primary key back to
		 * valueObject. This must be done to make things consistent for upper layer
		 * processing logic.
		 */
		sql = "SELECT last_insert_id()";

		try {
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();

			if (result.next()) {

				valueObject.setStudentId((int) result.getLong(1));

			} else {
				// System.out.println("Unable to find primary-key for created object!");
				throw new SQLException("Unable to find primary-key for created object!");
			}
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}
       return rowcount;
	}

	
	public int update(Student valueObject) throws SQLException {
		Connection	conn = DBUtility.getConnection();
		String sql = "UPDATE student SET name = ?, nick = ?, course = ? WHERE (id = ? ) ";
		PreparedStatement stmt = null;
		int rowcount = 0;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, valueObject.getName());
			stmt.setString(2, valueObject.getNick());
			stmt.setString(3, valueObject.getCourse());

			stmt.setInt(4, valueObject.getStudentId());

			rowcount = databaseUpdate(stmt);
			if (rowcount == 0) {
				System.out.println("Object could not be saved! (PrimaryKey not found)");
				
			}
			if (rowcount > 1) {
				// System.out.println("PrimaryKey Error when updating DB! (Many objects were
				// affected!)");
				throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
			}
		} finally {
			if (stmt != null)
				stmt.close();
		}
		return rowcount;
	}

	
	public int delete(Student valueObject) throws SQLException {
		Connection	conn = DBUtility.getConnection();
		String sql = "DELETE FROM student WHERE (id = ? ) ";
		PreparedStatement stmt = null;
		int rowcount = 0;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getStudentId());

			rowcount = databaseUpdate(stmt);
			if (rowcount == 0) {
				 System.out.println("Object could not be deleted (PrimaryKey not found)");
				}
			if (rowcount > 1) {
				// System.out.println("PrimaryKey Error when updating DB! (Many objects were
				// deleted!)");
				throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
			}
		} finally {
			if (stmt != null)
				stmt.close();
		}
		return rowcount;
	}

	
	public List<Student> searchMatching(Student valueObject) throws SQLException {
		Connection	conn = DBUtility.getConnection();
		List<Student> searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM student WHERE 1=1 ");

		if (valueObject.getStudentId() != 0) {
			if (first) {
				first = false;
			}
			sql.append("AND id = ").append(valueObject.getStudentId()).append(" ");
		}

		if (valueObject.getName() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND name LIKE '").append(valueObject.getName()).append("%' ");
		}

		if (valueObject.getNick() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND nick LIKE '").append(valueObject.getNick()).append("%' ");
		}

		if (valueObject.getCourse() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND course LIKE '").append(valueObject.getCourse()).append("%' ");
		}

		sql.append("ORDER BY id ASC ");

		// Prevent accidential full table results.
		// Use loadAll if all rows must be returned.
		if (first)
			searchResults = new ArrayList<Student>();
		else
			searchResults = listQuery(conn.prepareStatement(sql.toString()));

		return searchResults;
	}

	protected int databaseUpdate(PreparedStatement stmt) throws SQLException {

		int result = stmt.executeUpdate();

		return result;
	}

	protected Student singleQuery(PreparedStatement stmt, Student valueObject) throws SQLException {

		
		ResultSet result = null;

		try {
			result = stmt.executeQuery();

			if (result.next()) {

				valueObject.setStudentId(result.getInt("id"));
				valueObject.setName(result.getString("name"));
				valueObject.setNick(result.getString("nick"));
				valueObject.setCourse(result.getString("course"));

			} else {
				 System.out.println("Student Object Not Found!");
				
			}
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}
		return valueObject;
	}

	protected List<Student> listQuery(PreparedStatement stmt) throws SQLException {

		ArrayList<Student> searchResults = new ArrayList<Student>();
		ResultSet result = null;

		try {
			result = stmt.executeQuery();

			while (result.next()) {
				Student temp = createValueObject();

				temp.setStudentId(result.getInt("id"));
				temp.setName(result.getString("name"));
				temp.setNick(result.getString("nick"));
				temp.setCourse(result.getString("course"));

				searchResults.add(temp);
			}

		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}

		return (List<Student>) searchResults;
	}

}
