package uk.gov.nhsdigital.fgmv2.fgmserver.main;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Flag;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader;
import ca.uhn.fhir.model.dstu2.resource.OperationOutcome;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Parameters;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import uk.gov.nhsdigital.fgmv2.fgmclient.main.CreateFGMFlagXML;
import uk.gov.nhsdigital.fgmv2.fgmclient.main.CreateFGMQueryv2;
import uk.gov.nhsdigital.fgmv2.fgmclient.main.DeleteFGMFlagXML;

public class FGMServer {

	/*
	 * This class contains FGMFHIRServer test responses
	 */


public static void fgmQueryRequestResponse() {

	    // create a context for DSTU2
		FhirContext ctx = FhirContext.forDstu2();
			
		Bundle bndlresp = CreateXMLResponseNoFGM.createBundle();
		MessageHeader mh = CreateXMLResponseNoFGM.createMessageHeader();
		//Flag flag = CreateXMLResponseNoFGM.createFlag();
		OperationOutcome oout = CreateXMLResponseNoFGM.createOperationOutcome();
		//Patient pait = CreateXMLResponseNoFGM.createPatient();
		
		final Entry entryBundle = bndlresp.addEntry();		
		
		//final Entry entryMh = bndlresp.addEntry();
		//final Entry entryFlag = bndlresp.addEntry();
		final Entry entryOOut = bndlresp.addEntry();
		//final Entry entryPat = bndlresp.addEntry();
		
		
		entryBundle.setResource(mh);
		//entryFlag.setResource(flag);
		entryOOut.setResource(oout);
		//entryPat.setResource(pait);
		
		// We can now use a parser to encode this resource into a string.
		String output = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(bndlresp);
			
		System.out.println(output);
		
		//create client
//		String serverBaseUrl = "http://fhirtest.uhn.ca/baseDstu2";
//		//String serverBaseUrl = "http://fhir3.healthintersections.com.au/open";
//		IGenericClient client = ctx.newRestfulGenericClient(serverBaseUrl);
//		
//		//use client to store a new resource instance
//		MethodOutcome outcome = client.create().resource(bndl).execute();
//		System.out.println(outcome.getId());

}

public static void fgmCreateFlagSuccessResponse() {
	
	 // create a context for DSTU2
	FhirContext ctx = FhirContext.forDstu2();
		
	Bundle bndlresp = CreateXMLResponseCreateFlagSuccess.createBundle();
	MessageHeader mh = CreateXMLResponseCreateFlagSuccess.createMessageHeader();
		
	final Entry entryBundle = bndlresp.addEntry();		
		
	entryBundle.setResource(mh);
		
	// We can now use a parser to encode this resource into a string.
	String output = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(bndlresp);
		
	System.out.println(output);
	
	//create client
//	String serverBaseUrl = "http://fhirtest.uhn.ca/baseDstu2";
//	//String serverBaseUrl = "http://fhir3.healthintersections.com.au/open";
//	IGenericClient client = ctx.newRestfulGenericClient(serverBaseUrl);
//	
//	//use client to store a new resource instance
//	MethodOutcome outcome = client.create().resource(bndl).execute();
//	System.out.println(outcome.getId());

}

public static void fgmDeleteFlagSuccessResponse() {

	 // create a context for DSTU2
		FhirContext ctx = FhirContext.forDstu2();
			
		Bundle bndlresp = CreateXMLResponseDeleteFlagSuccess.createBundle();
		MessageHeader mh = CreateXMLResponseDeleteFlagSuccess.createMessageHeader();
			
		final Entry entryBundle = bndlresp.addEntry();		
	
		entryBundle.setResource(mh);

			
		// We can now use a parser to encode this resource into a string.
		String output = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(bndlresp);
			
		System.out.println(output);
		
		//create client
//		String serverBaseUrl = "http://fhirtest.uhn.ca/baseDstu2";
//		//String serverBaseUrl = "http://fhir3.healthintersections.com.au/open";
//		IGenericClient client = ctx.newRestfulGenericClient(serverBaseUrl);
	//	
//		//use client to store a new resource instance
//		MethodOutcome outcome = client.create().resource(bndl).execute();
//		System.out.println(outcome.getId());

	}



	public static void main(String[] args) {

		//fgmQueryRequestResponse();
     //fgmCreateFlagSuccessResponse();
     fgmDeleteFlagSuccessResponse();
		
	}
	
}
