package org.oliot.bis.accessingApp;

public class CreatJSON {

	public static String createApplication(String aeName, String appId){
		String content="{\n"+
			    "\"m2m:rqp\" : {\n"+
	       " \"fr\" : \"/"+appId+"\",\n"+
	       " \"to\" : \"/"+aeName+"\",\n"+
	       " \"op\" : \"1\",\n"+
	       " \"ty\" : \"2\",\n"+
	       " \"rqi\": 123456,\n"+
	       " \"pc\": {\n"+
	       " \"m2m:ae\": {\n"+
	       "  \"api\": \"0.2.481.1.1\",\n"+
	       "   \"rr\": \"true\",\n"+
	       "     \"rn\": \""+appId+"\"\n"+
	       " 	   }\n"+
	      "  }\n"+
	  "  }\n"+
	"}";
		
		return content;
	}
	
	public static String createContainer(String aeName,String appId, String cntName){
		String content="{\n"+
			    "\"m2m:rqp\" : {\n"+
	       " \"fr\" : \"/ae-test1\",\n"+
	       " \"to\" : \"/"+aeName+"/"+appId+"\",\n"+
	       " \"op\" : \"1\",\n"+
	       " \"rqi\": 123456,\n"+
	       " \"pc\": {"+
	        "    \"m2m:cnt\" : {\n"+
	        "        \"rn\": \""+cntName+"\"\n"+
	       "     }\n"+
	      "  },\n"+
	      "  \"ty\": \"3\"\n"+
	  "  }\n"+
	"}";
		
		return content;
	}
	
	public static String createContetnInstant(String aeName,String appId, String cntName, String contentName){
		//contentName="{id:\\\"urn:entity:santander:transport:bus:busArrivalEstimation:7:2\\\", refBusStop:\\\"urn:entity:santander:transport:bus:busStop:7\\\"refBusLine\":\\\"urn:entity:santander:transport:bus:busLine:2\\\", remainingDistances:\\\"[0]\\\",   shortID:\\\"NA\\\"}";
			String content="{\n"+
				    "\"m2m:rqp\" : {\n"+
				    " \"fr\" : \"/ae-test1\",\n"+
		       " \"to\" : \"/"+aeName+"/"+appId+"/"+cntName+"\",\n"+
		       " \"op\" : \"1\",\n"+
		       " \"rqi\": 123456,\n"+
		       " \"pc\": {"+
		        "    \"m2m:cin\" : {\n"+
		        "        \"con\": \""+contentName + "\"\n"+
		       // ",\n"+
		     //   "        \"linkType\": \"No\"\n"+
		       "     }\n"+
		      "  },\n"+
		      "  \"ty\": \"4\"\n"+
		  "  }\n"+
		"}";
		
		return content;
	}
	
//	public static void main(String[] args) {
//		String flow=new CreatJSON().createContetnInstant("tex", "tex", "tex");
//		System.out.println(flow);
//	}

}
