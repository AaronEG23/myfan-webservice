package myfan.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MGenre")
public class MGenreEntity {
	@Id
	private int MGenreID;
	private String Name;
	public int getMGenreID() {
		return MGenreID;
	}
	public void setMGenreID(int mGenreID) {
		MGenreID = mGenreID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	
}
