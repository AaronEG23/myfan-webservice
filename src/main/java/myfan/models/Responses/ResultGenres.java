package myfan.models.Responses;

import java.util.List;

import myfan.models.GenerosMusicales;
import myfan.models.MGenreEntity;

public class ResultGenres extends ResultResponse{
	private List<MGenreEntity> content;

	public List<MGenreEntity> getContent() {
		return content;
	}

	public void setContent(List<MGenreEntity> content) {
		this.content = content;
	}

	
	
	
}
