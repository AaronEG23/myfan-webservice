package myfan.models.Responses;

import myfan.models.JsonModels.FanaticoJson;

public class ResponseProfileFan extends ResultResponse {
	
	private FanaticoJson content;

	public FanaticoJson getContent() {
		return content;
	}

	public void setContent(FanaticoJson content) {
		this.content = content;
	}
}
