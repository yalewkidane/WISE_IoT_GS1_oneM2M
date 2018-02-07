package org.oliot.bis.capturingApp;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.oliot.bis.configuration.Configuration;
import org.oliot.bis.service.utility.ExistingQueryService;

public class CaptureUtility {
	
	
	public static int registerEPCIS(String data) {

		String url = "http://" + Configuration.epcis_ip + ":" + Configuration.epcis_port + "/epcis/Service/EventCapture";

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);

		post.setEntity(new StringEntity(data, "UTF-8"));

		HttpResponse response = null;
		try {
			response = client.execute(post);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response.getStatusLine().getStatusCode();
	}
	public static String captureToEPCIS(String data) {
		String url = "http://" + Configuration.epcis_ip + ":" + Configuration.epcis_port + "/epcis/Service/EventCapture";
		System.out.println(url);
		System.out.println(data);
		String result="Error";
		try {
			result = ExistingQueryService.normalqueryPOSTXml(url, data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

}
