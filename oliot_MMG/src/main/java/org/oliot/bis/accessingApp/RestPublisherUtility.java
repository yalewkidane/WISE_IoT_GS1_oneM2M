package org.oliot.bis.accessingApp;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.oliot.bis.configuration.Configuration;

public class RestPublisherUtility {
	
	public static final String aeInternalIpAddress =Configuration.oneM2M_ip + ":"+Configuration.oneM2M_port;
	
	
	static String csebase=Configuration.csebase;
	
	
	public static String aeRegistrationMessage(String aeName, String appId) throws Exception {
		String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
							"<m2m:ae xmlns:m2m=\"http://www.onem2m.org/xml/protocols\"> rn=\"MY_SENSOR2\"\n" + 
							"<api>app-sensor</api>"+
							"<rr>false</rr>"+
							"<rn>"+""+ appId +"</rn>"+
							"<App-ID>" + appId + "</App-ID>\n" +
							"</m2m:ae>";

		StringEntity entity = new StringEntity(
				new String(requestBody.getBytes()));

		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost(aeInternalIpAddress)
				.setPath(csebase)
				//.setParameter("ty", "AE")
				.setParameter("ty", "2")
				.setParameter("nm", aeName)
				.build();
		
		HttpPost post = new HttpPost(uri);
				post.setHeader("From", "localhost");
				post.setHeader("X-M2M-RI", "0001");
				post.setHeader("X-M2M-Origin", "/admin:admin");
				post.setHeader("Accept", "application/onem2m-resource+xml");
				post.setHeader("Content-Type", "application/onem2m-resource+xml; ty=2");
				post.setEntity(entity);
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpResponse response = httpClient.execute(post);
		
		int responseCode = response.getStatusLine().getStatusCode();
		
		System.out.println("Return Http response code : " + responseCode);
		
		HttpEntity responseEntity = response.getEntity();
		
		String responseString = EntityUtils.toString(responseEntity);
		
		System.out.println("Return Http response body : " + responseString);
		
		httpClient.close();
		
		return responseString;
	}
	
	public static String containerCreateMessage(String appId, String containerName) throws Exception {
		String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
							"<m2m:cnt xmlns:m2m=\"http://www.onem2m.org/xml/protocols\" rn=\"" + containerName+"\">\n" + 
							"<containerType>testType</containerType>\n" +
							"<container>con1</container>\n" +
							"<container>con2</container>\n" +
							"</m2m:cnt>";

		StringEntity entity = new StringEntity(
				new String(requestBody.getBytes()));

		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost(aeInternalIpAddress)
				.setPath(csebase + "/" + appId)//
				//.setPath(csebase + "/in-name/ae_645408574")
				//.setParameter("ty", "container")
				.setParameter("ty", "3")
				.setParameter("nm", containerName)
				.build();
		
		HttpPost post = new HttpPost(uri);
				post.setHeader("From", "localhost");
				post.setHeader("X-M2M-RI", "0001");
				post.setHeader("X-M2M-Origin", "/admin:admin");
				post.setHeader("Accept", "application/onem2m-resource+xml");
				post.setHeader("Content-Type", "application/onem2m-resource+xml; ty=3");
				post.setEntity(entity);
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpResponse response = httpClient.execute(post);
		
		int responseCode = response.getStatusLine().getStatusCode();
		
		System.out.println("Return Http response code : " + responseCode);
		
		HttpEntity responseEntity = response.getEntity();
		
		String responseString = EntityUtils.toString(responseEntity);
		
		System.out.println("Return Http response body : " + responseString);
		
		httpClient.close();
		
		return responseString;
	}
	
	public static String contentInstanceCreateMessage(String appId, String containerName, String content, String service) throws Exception {
		String requestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
							"<m2m:cin"
							+ " xmlns:m2m=\"http://www.onem2m.org/xml/protocols\">\n" + 
							"<typeOfContent>String</typeOfContent>\n" + 
							//"<content>" + content + "</content>\n" +
							//"<rn>ae-22</rn>"+
							"<con>" + content + "</con>\n" +
							"<cr>" + service + "</cr>\n" +
							"<linkType>no</linkType>\n" +
							"</m2m:cin>";

		System.out.println(requestBody);
		StringEntity entity = new StringEntity(
				new String(requestBody.getBytes()));

		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost(aeInternalIpAddress)
				.setPath(csebase + "/" + appId + "/" + containerName)
				//.setPath(csebase + "/in-name/ae_645408574"+ "/" + containerName)
				//.setParameter("ty", "contentInstance")
				.setParameter("ty", "4")
				.build();
		
		HttpPost post = new HttpPost(uri);
				post.setHeader("From", "localhost");
				post.setHeader("X-M2M-RI", "0001");
				post.setHeader("X-M2M-Origin", "/admin:admin");
				post.setHeader("Accept", "application/onem2m-resource+xml");
				post.setHeader("Content-Type", "application/onem2m-resource+xml; ty=4");
				post.setEntity(entity);
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpResponse response = httpClient.execute(post);
		
		int responseCode = response.getStatusLine().getStatusCode();
		
		System.out.println("Return Http response code : " + responseCode);
		
		HttpEntity responseEntity = response.getEntity();
		
		String responseString = EntityUtils.toString(responseEntity);
		
		System.out.println("Return Http response body : " + responseString);
		
		httpClient.close();
		
		return responseString;
	}

}
