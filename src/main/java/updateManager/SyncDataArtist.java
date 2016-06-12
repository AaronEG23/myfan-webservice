package updateManager;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import myfan.models.Artista;
import myfan.models.Responses.ResultResponse;

public class SyncDataArtist {
	final String urlnewDataArtist= "http://172.26.108.130:8086/sync/newArtist"; //CambiarURL
	
	
	/*public String sendDataArtist(Artista pArtist){
        Map<String, String> vars = new HashMap<String, String>();
		
		 RestTemplate rt = new RestTemplate();
         //rt.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
         rt.getMessageConverters().add(new StringHttpMessageConverter());  
         ResultResponse returns = rt.postForObject(url, pArtist, ResultResponse.class, vars);
		return returns.getResult();
		
	}*/
	
	public String sendDataArtist(Artista pArtist){
		 RestTemplate rt = new RestTemplate();
		 
		 rt.getMessageConverters().add(new StringHttpMessageConverter());  
         ResultResponse returns = rt.postForObject(urlnewDataArtist, pArtist, ResultResponse.class);
         
         return returns.getStatus();
		
	}
	
}
