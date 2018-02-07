package org.oliot.bis.accessingApp;

import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;
import org.oliot.bis.configuration.Configuration;
import org.oliot.bis.model.BusEstimationSemantic;
import org.oliot.bis.model.BusLineSematic;
import org.oliot.bis.model.BusStopSemantic;
import org.oliot.bis.tutorial.Printer;
import org.oliot.model.epcis.AttributeType;
import org.oliot.model.epcis.EPC;
import org.oliot.model.epcis.EPCISDocumentType;
import org.oliot.model.epcis.EPCListType;
import org.oliot.model.epcis.ObjectEventType;
import org.oliot.model.epcis.VocabularyElementListType;
import org.oliot.model.epcis.VocabularyElementType;
import org.oliot.model.epcis.VocabularyListType;
import org.oliot.model.epcis.VocabularyType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResultTranslator {
	public static int tes =0;
	
	public void translate(String data) {
		InputStream epcisStream =new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
		EPCISDocumentType epcisDocument = JAXB.unmarshal(epcisStream, EPCISDocumentType.class);
		if(epcisDocument.getEpcisHeader() !=null) {
			if(epcisDocument.getEpcisHeader().getExtension() != null) {
				if(epcisDocument.getEpcisHeader().getExtension().getEPCISMasterData() != null) {
					if(epcisDocument.getEpcisHeader().getExtension().getEPCISMasterData().getVocabularyList() != null) {
						VocabularyListType vocabularyList=epcisDocument.getEpcisHeader().getExtension().getEPCISMasterData().getVocabularyList();
						List<VocabularyType> vocabulary=vocabularyList.getVocabulary();
						System.out.println("vocabulary size  :  " + vocabulary.size());
						for(int i=0; i<vocabulary.size(); i++){
				    		 VocabularyElementListType vocabularyElementList=vocabulary.get(i).getVocabularyElementList();
				    		 List<VocabularyElementType> vocElement=vocabularyElementList.getVocabularyElement();
				    		 String vocElementType=vocabulary.get(i).getType();
				    		 String[] serviceTpe=vocElementType.split(":");
				    		 System.out.println("vocElement size  :  " + vocElement.size());
				    		 if(serviceTpe[5].equals("stop")) {
				    			 for(int j=0; j<vocElement.size(); j++){
				    				 
				    				 System.out.println("Ieration  :  " + i+" : "+j);
				    				 
				    				 String vocElementID=vocElement.get(j).getId();
					    			 List<AttributeType> attrList=vocElement.get(j).getAttribute();
					    			 BusStopSemantic busStop=new BusStopSemantic();
					    			 for(int k=0; k<attrList.size(); k++){
					    				 String id=attrList.get(k).getId();
					    				 if(id.equals("http://epcis.example.com/bus/stop/id")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busStop.setId(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/stop/refBuses")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busStop.setRefBuses(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/stop/shortID")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busStop.setShortID(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/stop/busStopCount")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busStop.setBusStopCount(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/stop/name")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busStop.setName(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/stop/location")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busStop.setLocation(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/stop/refBusLines")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busStop.setRefBusLines(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/stop/datemodified")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busStop.setDateModified(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/stop/address")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busStop.setAddress(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/stop/direction")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busStop.setDirection(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    			 }
					    			// Printer.printBusStopSemantic(busStop);
					    			 StringWriter sw = new StringWriter();
					    			 JAXBContext jaxbContextbusStop;
									try {
										jaxbContextbusStop = JAXBContext.newInstance(BusStopSemantic.class);
										Marshaller jaxbMarshallerbusStop = jaxbContextbusStop.createMarshaller();
										jaxbMarshallerbusStop.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
						    			jaxbMarshallerbusStop.marshal(busStop, sw);
						    			String xmlString = sw.toString();
						    			
						    			System.out.println(vocElementID);
						    			String containerId="test";
						    			try {
						    				String [] containerIdList=vocElementID.split(":")[4].split("\\.");
						    				// containerId=vocElementID.split(":")[4].split("\\.")[2];
						    				//String [] containerIdList=containerId1.split("\\.");
						    				containerId=containerIdList[1]+"."+containerIdList[2];
					
						    			}catch(Exception e) {
						    				e.printStackTrace();
						    			}
						    			
						    			ObjectMapper mapper = new ObjectMapper();
						    			String jsonInString="before conv";
						    			try {
											 jsonInString = mapper.writeValueAsString(busStop);
										} catch (JsonProcessingException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
						    			
						    			PublisherREST publisherREST=new PublisherREST();
						    			publisherREST.createContainerID("busStop", containerId);
						    			publisherREST.createContentInstant("busStop", containerId, jsonInString);
						    			System.out.println("Content Instant Published : "+ containerId);
						    			//System.out.println(jsonInString);
									} catch (JAXBException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
					    			 
					    			 
					    		 }
				    		 }else if(serviceTpe[5].equals("line")) {
				    			 System.out.println("vocElement size : "+ vocElement.size());
				    			 for(int j=0; j<vocElement.size(); j++){
					    			 String vocElementID=vocElement.get(j).getId();
					    			 System.out.println( "Voc id: "+ vocElementID );
					    			 List<AttributeType> attrList=vocElement.get(j).getAttribute();
					    			 BusLineSematic busLine=new BusLineSematic();
					    			 for(int k=0; k<attrList.size(); k++){
					    				 String id=attrList.get(k).getId();
					    				 if(id.equals("http://epcis.example.com/bus/stop/id")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busLine.setId(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/line/localID")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busLine.setLocalID(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/line/shortID")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busLine.setShortID(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/line/name")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busLine.setName(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/line/refBusStops")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busLine.setRefBusStops(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/line/refStartBusStop")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busLine.setRefStartBusStop(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/line/refEndBusStop")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busLine.setRefEndBusStop(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/line/busLineType")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busLine.setBusLineType(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/line/startTime")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busLine.setStartTime(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/line/endTime")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busLine.setEndTime(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/line/intervalNorm")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busLine.setIntervalNorm(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/line/intervalHoli")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busLine.setIntervalHoli(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/line/intervalPeak")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busLine.setIntervalPeak(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 if(id.equals("http://epcis.example.com/bus/line/datemodified")) {
					    					 List<Object> content=attrList.get(k).getContent();
					    					 String contentStr=content.toString();
					    					 busLine.setDateModified(contentStr.substring(1, contentStr.length()-1));
					    				 }
					    				 
					    			 }
					    			 
					    			 
					    			 System.out.println(" From bus line "+vocElementID);
						    			String containerId="test";
						    			try {
						    				String [] containerIdList=vocElementID.split(":")[4].split("\\.");
						    				//containerId=vocElementID.split(":")[4].split("\\.")[2];
						    				//String [] containerIdList=containerId1.split("\\.");
						    				containerId=containerIdList[1]+"."+containerIdList[2];
					
						    			}catch(Exception e) {
						    				e.printStackTrace();
						    			}
						    			
						    			ObjectMapper mapper = new ObjectMapper();
						    			String jsonInString="before conv";
						    			try {
											 jsonInString = mapper.writeValueAsString(busLine);
										} catch (JsonProcessingException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
						    			
						    			PublisherREST publisherREST=new PublisherREST();
						    			publisherREST.createContainerID("busLine", containerId);
						    			publisherREST.createContentInstant("busLine", containerId, jsonInString);
						    			System.out.println("Content Instant Published : "+ containerId);
					    			 
					    		 }
				    		 }else {
				    			 Configuration.logger.error("needs to be busSto or busLine");
				    		 }
				    		
				    	}
						
					}
				}
			}
		}
		
		if(epcisDocument.getEPCISBody() != null) {
			if(epcisDocument.getEPCISBody().getEventList() != null) {
				List<Object> eventList = epcisDocument.getEPCISBody().getEventList()
						.getObjectEventOrAggregationEventOrQuantityEvent();
				System.out.println("eventList size  :  "+ eventList.size());
				for(int i=0; i<eventList.size(); i++) {
					System.out.println("Processing event -------    :  "+ i);
					Object jaxbEvent=eventList.get(i);
					@SuppressWarnings("rawtypes")
					JAXBElement eventElement = (JAXBElement) jaxbEvent;
					Object event = eventElement.getValue();
					if (event instanceof ObjectEventType) {
						BusEstimationSemantic busEstimation=new BusEstimationSemantic();
						
						try {
							ObjectEventType objectEvent=(ObjectEventType) event;
							List<EPC> epcList = null;
							String containerId="test";
							
							try {
								if (objectEvent.getEpcList() != null) {
									EPCListType epcs = objectEvent.getEpcList();
									epcList = epcs.getEpc();
									containerId=epcList.get(0).getValue();
								}
			    				 String[] containerIdList=containerId.split(":")[4].split("\\.");
			    				 containerId=containerIdList[1]+"."+containerIdList[2]; //+"."+containerIdList[3]
			    				//String [] containerIdList=containerId1.split("\\.");
		
			    			}catch(Exception e) {
			    				e.printStackTrace();
			    			}
							
							System.out.println(objectEvent.getEventTime());
							System.out.println(containerId);
							
							String content="{";
							if (objectEvent.getAny() != null) {
								List<Object> objList = objectEvent.getAny();
								for (int g = 0; g < objList.size(); g++) {
									Object obj = objList.get(g);
									if (obj instanceof Element) {
										Element element = (Element) obj;
										String qname = element.getNodeName();
										// Process Namespace
										String[] checkArr = qname.split(":");

										if (checkArr.length != 2)
											continue;

										String prefix = checkArr[0];
										String localName = checkArr[1];
										String namespaceURI = encodeMongoObjectKey(element.getNamespaceURI());
										String qnameKey = encodeMongoObjectKey(namespaceURI + "#" + localName);
										// checkArr[0] : example1
										// getNamespaceURI : http
										//map2Save.put("@" + namespaceURI, new BsonString(prefix));
										Node firstChildNode = element.getFirstChild();
										if (firstChildNode != null) {
											if (firstChildNode instanceof Text) {
												String value = firstChildNode.getTextContent();
												//value = reflectXsiType(value, element);
												//map2Save.put(qnameKey, converseType(value));
												//System.out.println("localName : "+localName+"  value: "+value);
												
												if(localName.equals("id")) {
													busEstimation.setId(value);
													content+=", id:\\\""+value+"\\\"";
												}else if(localName.equals("refBusStop")) {
													busEstimation.setRefBusStop(value);
													content+=", refBusStop:\\\""+value+"\\\"";
												}else if(localName.equals("refBusLine")) {
													busEstimation.setRefBusLine(value);
													content+=", refBusLine:\\\""+value+"\\\"";
												}else if(localName.equals("remainingDistances")) {
													busEstimation.setRemainingDistances(value);
													content+=", remainingDistances:\\\""+value+"\\\"";
												}else if(localName.equals("remainingTimes")) {
													busEstimation.setRemainingTimes(value);
													value=value.replace("\"", "\\\"");
													content+=", remainingTimes:\\\""+value+"\\\"";
												}else if(localName.equals("destinationBusLines")) {
													busEstimation.setDestinationBusLines(value);
													value=value.replace("\"", "\\\"");
													content+=", destinationBusLines:\\\""+value+"\\\"";
												}else if(localName.equals("shortID")) {
													busEstimation.setShortID(value);
													content+=", shortID:\\\""+value+"\\\"";
												}else if(localName.equals("remainingStations")) {
													busEstimation.setRemainingStations(value);
													content+=", remainingStations:\\\""+value+"\\\"";
												}else if(localName.equals("companyName")) {
													busEstimation.setCompanyName(value);
													content+=", companyName:\\\""+value+"\\\"";
												}else if(localName.equals("dateModified")) {
													busEstimation.setDateModified(value);
													content+=", dateModified:\\\""+value+"\\\"";
												}else if(localName.equals("location")) {
													busEstimation.setLocation(value);
													content+=", location:\\\""+value+"\\\"";
												}
												
												
											}
										}
									}
								}

							}
							
							//Printer.printBusEstimationSemantic(busEstimation);
							
							ObjectMapper mapper = new ObjectMapper();
			    			String jsonInString="before conv";
			    			try {
								 jsonInString = mapper.writeValueAsString(busEstimation);
							} catch (JsonProcessingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
			    		//	if(tes==0) {
			    				PublisherREST publisherREST=new PublisherREST();
				    			publisherREST.createContainerID("busEstimation", containerId);
				    			publisherREST.createContentInstant("busEstimation", containerId, jsonInString);
				    			System.out.println("BusEstimation Content Instant Published : "+ containerId);
				    			
				    			tes++;
			    		//	}
			    			
			    			
			    			
			    			/*
			    			MqttMessage message = new MqttMessage();
			    			String topic="/oneM2M/req/"+Configuration.appId+"/:"+Configuration.aeName+"/json";
			    		
			    			String busEstimationContainerNameJson= CreatJSON.createContainer(Configuration.aeName, Configuration.appId, Configuration.busEstimationContainerName +"/"+containerId);
			    			message.setPayload(busEstimationContainerNameJson.getBytes());
			    			Configuration.client_onem2m.publish(topic, message);
			    			//System.out.println(busEstimationContainerNameJson);
			    			content+="}";
			    			//String busEstimationContentInstantJson= CreatJSON.createContetnInstant(Configuration.aeName, Configuration.appId, Configuration.busEstimationContainerName +"/"+containerId, jsonInString);
			    			String busEstimationContentInstantJson= CreatJSON.createContetnInstant(Configuration.aeName, Configuration.appId, Configuration.busEstimationContainerName +"/"+containerId, content);
			    			message.setPayload(busEstimationContentInstantJson.getBytes());
			    			Configuration.client_onem2m.publish(topic, message);
			    			System.out.println(busEstimationContentInstantJson);
			    			
			    			*/
						}catch(Exception e) {
							e.printStackTrace();
						}
					
					}
					
						
					
				}
				
			}
			
		}
		
	}
	
	static public String encodeMongoObjectKey(String key) {
		key = key.replace(".", "\uff0e");
		return key;
	}
	

}
