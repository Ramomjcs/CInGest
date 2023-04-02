package com.cingest.demo.model.apiexterna;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import com.cingest.demo.controll.IComunicacaoSistemaExterno;

@Component
public class ComunicacaoDiscord implements IComunicacaoSistemaExterno{

	@Override
	public boolean sendMessage(String message, String webhookUrl) {
		try {
		
		    CloseableHttpClient httpClient = HttpClients.createDefault();
		
		    HttpPost httpPost = new HttpPost(webhookUrl);
		    ContentType contentType = ContentType.create("application/json", Charset.forName("UTF-8"));
		
		    String json = "{\"content\":\"" + message + "\"}";
		    StringEntity entity = new StringEntity(json, contentType);
		    httpPost.setEntity(entity);
		
		    HttpResponse response = httpClient.execute(httpPost);
		    System.out.println(response.getStatusLine().getStatusCode());
		
		    httpClient.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
}