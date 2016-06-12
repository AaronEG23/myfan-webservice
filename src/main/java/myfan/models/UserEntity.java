package myfan.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Users")
public class UserEntity {
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int UserID ;
	@Id
	private String Login;
	private String Pass;
	private String Name;
	private String Country;
	private String Email;
	private String userType;
	private String AccountStatus;
	private String SessionStatus;
	@Lob
	private String Photo;
	
	public UserEntity(){
		
	}
	
public UserEntity(int userID,String pLogin, String pPass,String pName ,String pCountry 
				,String pEmail, String pType,String pAccountStatus,String pPhoto){
		this.setUserID(userID);
		Login=pLogin;
		Pass=pPass;
		Name=pName;
		Country=pCountry;
		Email=pEmail;
		userType=pType;
		AccountStatus=pAccountStatus;
		Photo=pPhoto;
	}

public UserEntity(int userID,String pLogin, String pPass,String pType){
	this.setUserID(userID);
	Login=pLogin;
	Pass=pPass;
	userType=pType;
}
	
	

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getAccountStatus() {
		return AccountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		AccountStatus = accountStatus;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getSessionStatus() {
		return SessionStatus;
	}

	public void setSessionStatus(String sessionStatus) {
		SessionStatus = sessionStatus;
	}
	



	
	
	
}
