package responseAdministrator;

import myfan.models.Responses.ResultLogin;
import myfan.models.Responses.ResultResponse;

public class SessionRespBuilder {
	
	public ResultResponse createRespRegister(String result){
		ResultResponse response= new ResultResponse();
		response.setStatus(result);		
		return response;
		
	}
	
	public ResultResponse createRespLogout(String result){
		ResultResponse response= new ResultResponse();
		response.setStatus(result);		
		return response;
		
	}
	
	public ResultLogin createRespLogin(String result){
		ResultLogin response= new ResultLogin();
		if(result.equals("0"))
			response.setStatus(result);	
		else{
			response.setStatus("1");
			response.setContent(result);
		}
		return response;
		
	}

}
