package dao;
 
import java.util.ArrayList;
import java.util.List;
 
import dao.LecturerSetupDAO;
import exception.DAOException;
import model.LecturerDTO;
import model.User;
 
public interface LecturerSetupDAO {
	
	/*
	 * (non-Javadoc)
	 * @see dao.mysql.LecturerSetupDAOImpl.addLecturer(model.User, model.LecturerDTO)
	 */
    public void addLecturer(User user,LecturerDTO lecturer) throws DAOException;
    
    /*
     * (non-Javadoc)
     * @see doc.mysql.LecturerSetupDAOImpl.deleteLecturer(int)
     */
    public void deleteLecturer( int lecturerID ) throws DAOException;
    
    /*
     * (non-Javadoc)
     * @see doc.mysql.LecturerSetupDAOImpl.updteLecturer(model.LecturerDTO, model.User)
     */
    public void updateLecturer( LecturerDTO lecturer,User user) throws DAOException;
    
}