package myfan.models.Responses;

import myfan.models.JsonModels.ArtistaJson;
import myfan.models.JsonModels.FanaticoJson;

public class ResponseProfileArtist extends ResultResponse {
	private ArtistaJson content;

	public ArtistaJson getContent() {
		return content;
	}

	public void setContent(ArtistaJson content) {
		this.content = content;
	}

		
}
