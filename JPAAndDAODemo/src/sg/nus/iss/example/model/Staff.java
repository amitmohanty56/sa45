package sg.nus.iss.example.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="staff")
public class Staff {
	@Id
	private int idStaff;
	@Basic
	@Column(name="staffname")
	private String name;
	@Basic
	@Column(name="staffnickname")
	private String nick;
	public Staff(int idStaff, String name, String nick) {
		super();
		this.idStaff = idStaff;
		this.name = name;
		this.nick = nick;
	}
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idStaff;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		if (idStaff != other.idStaff)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Staff [idStaff=" + idStaff + ", name=" + name + ", nick=" + nick + "]";
	}
	

}
