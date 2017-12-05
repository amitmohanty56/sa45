package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.StudentDTO;
import model.User;

public interface StudentDAO {

	/* (non-Javadoc)
	 * @see dao.StudentDAOin#addStudentOne(model.User, model.StudentDTO)
	 */
	void addStudentOne(User user, StudentDTO student) throws SQLException;

	/* (non-Javadoc)
	 * @see dao.StudentDAOin#deleteStudent(int)
	 */
	void deleteStudent(int id) throws SQLException;

	/* (non-Javadoc)
	 * @see dao.StudentDAOin#updateStudent(model.StudentDTO)
	 */
	void updateStudent(StudentDTO student) throws SQLException;

	/* (non-Javadoc)
	 * @see dao.StudentDAOin#findAllStudents()
	 */
	ArrayList<StudentDTO> findAllStudents() throws SQLException;

	/* (non-Javadoc)
	 * @see dao.StudentDAOin#findStudentOne(java.lang.String)
	 */
	StudentDTO findStudentOne(int id) throws SQLException;

}