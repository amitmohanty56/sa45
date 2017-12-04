package sample.dao.jpa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javassist.NotFoundException;
import sample.dao.StudentDAO;
import sample.model.Student;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public Student createValueObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getObject(Connection conn, int studentId) throws NotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load(Connection conn, Student valueObject) throws NotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List loadAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Connection conn, Student valueObject) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(Connection conn, Student valueObject) throws NotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Connection conn, Student valueObject) throws NotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int countAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List searchMatching(Connection conn, Student valueObject) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
