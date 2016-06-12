package myfan.models.Responses;

import java.util.List;

import myfan.models.JsonModels.FanaticoJson;

public class ResponseSearchArtist extends ResultResponse {
	private List<Object> content;

	public List<Object> getContent() {
		return content;
	}

	public void setContent(List<Object> content) {
		this.content = content;
	}

	
}
