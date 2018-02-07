package org.oliot.bis.accessingApp;

import java.io.StringReader;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.oliot.model.epcis.EPCISQueryBodyType;
import org.oliot.model.epcis.EPCISQueryDocumentType;
import org.oliot.model.epcis.QueryResults;

public class QueryResultUtility {
	
	public  QueryResults getQueryResults(String data){
		QueryResults queryResults=new QueryResults();
		try {
			
			   JAXBContext jAXBContext = JAXBContext
						.newInstance(EPCISQueryDocumentType.class);
				@SuppressWarnings("unused")
				Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
				Source source = new StreamSource(new StringReader(data));
				EPCISQueryDocumentType ePCISQueryDocumentType = JAXB.unmarshal(
						source, EPCISQueryDocumentType.class);
				
				

				EPCISQueryBodyType epcisBody = ePCISQueryDocumentType
						.getEPCISBody();
				
				if (epcisBody != null) {
					queryResults = epcisBody.getQueryResults();
				}
		}catch(JAXBException e) {
			e.printStackTrace();
			
		}
		
			
			
			return queryResults;
	}

}
