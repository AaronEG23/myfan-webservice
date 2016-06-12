package sqlConstants;

public final class ConstantsQueries {
	
	public static final String sqlLogin= "SELECT NEW myfan.models.UserEntity(UserID,Login,Pass,userType) from UserEntity WHERE login=? AND pass=?";
	
	public static final String sqlprofileUser= "SELECT NEW myfan.models.UserEntity(UserID,Login,Pass,Name,Country,Email,userType,AccountStatus,Photo) from UserEntity WHERE login=?";
	
	public static final String sqlprofileFan= "SELECT NEW myfan.models.FanaticoEntity(Login,Genre,BirthDate) from FanaticoEntity WHERE login=?";

	public static final String sqlprofileArtist= "SELECT NEW myfan.models.ArtistaEntity(userID,Login,Hashtag,CreateYear,Biography,Integrants,Followers) from ArtistaEntity WHERE login=?";
	
	
	public static final String sqlSearchByName="select usuarios.Name,usuarios.Country, generos.Name from UserEntity usuarios,GenreAssociationEntity genders,"
			  +" MGenreEntity generos"
			  +" where usuarios.UserID = genders.UserID AND generos.MGenreID=genders.MGenreID"
			  + " AND usuarios.Name=?";
	
	
	
}
