package uk.gov.nhsdigital.fgmv2.fgmclient.main;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Flag;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Parameters;
//import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.IGenericClient;



public class FGMClient {

/*
	 * This class contains FGMFHIRClient test calls
	 */


public static void fgmQueryRequest() {

	    // create a context for DSTU2
		FhirContext ctx = FhirContext.forDstu2();
			
		Bundle bndl = CreateFGMQueryv2.createBundle();
		MessageHeader mh = CreateFGMQueryv2.createMessageHeader();
		Parameters pm = CreateFGMQueryv2.createParameters();
		Practitioner prac = CreateFGMQueryv2.createPractitioner();
		Organization orgn = CreateFGMQueryv2.createOrganization();
			
		final Entry entryBundle = bndl.addEntry();		
			
		//final Entry entryMh = bndl.addEntry();
		final Entry entryParam = bndl.addEntry();
		final Entry entryPrac = bndl.addEntry();
		final Entry entryOrg = bndl.addEntry();
			
		//entryMh.setResource(mh);
		//entryBundle.setResource(orgn);
			
		entryBundle.setResource(mh);
		entryParam.setResource(pm);
		entryPrac.setResource(prac);
		entryOrg.setResource(orgn);
			
		// We can now use a parser to encode this resource into a string.
		String output = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(bndl);
			
		System.out.println(output);
		
		//create client
		//String serverBaseUrl = "http://fhirtest.uhn.ca/baseDstu2";
		//String serverBaseUrl = "http://fhir3.healthintersections.com.au/open";
		//String serverBaseUrl = "http://phh-l-iopweb-l1:8080/hapi-fhir-jpaserver/baseDstu2";
		//IGenericClient client = ctx.newRestfulGenericClient(serverBaseUrl);
//		
//		//use client to store a new resource instance
		//MethodOutcome outcome = client.create().resource(bndl).execute();
		//System.out.println(outcome.getId());

}

public static void fgmCreateFlag() {
	
	 // create a context for DSTU2
	FhirContext ctx = FhirContext.forDstu2();
		
	Bundle bndl = CreateFGMFlagXML.createBundle();
	MessageHeader mh = CreateFGMFlagXML.createMessageHeader();
	Flag flag = CreateFGMFlagXML.createFlag();
	Practitioner prac = CreateFGMFlagXML.createPractitioner();
	Organization orgn = CreateFGMQueryv2.createOrganization();
		
	final Entry entryBundle = bndl.addEntry();		
		
	//final Entry entryMh = bndl.addEntry();
	final Entry entryFlag = bndl.addEntry();
	final Entry entryPrac = bndl.addEntry();
	final Entry entryOrg = bndl.addEntry();
		
	//entryMh.setResource(mh);
	//entryBundle.setResource(orgn);
		
	entryBundle.setResource(mh);
	entryFlag.setResource(flag);
	entryPrac.setResource(prac);
	entryOrg.setResource(orgn);
		
	// We can now use a parser to encode this resource into a string.
	String output = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(bndl);
		
	System.out.println(output);
	
	//create client
//String serverBaseUrl = "http://fhirtest.uhn.ca/baseDstu2";
//	//String serverBaseUrl = "http://fhir3.healthintersections.com.au/open";
//	IGenericClient client = ctx.newRestfulGenericClient(serverBaseUrl);
//	
//	//use client to store a new resource instance
//	MethodOutcome outcome = client.create().resource(bndl).execute();
//	System.out.println(outcome.getId());

}

public static void fgmDeleteFlag() {

	 // create a context for DSTU2
		FhirContext ctx = FhirContext.forDstu2();
			
		Bundle bndl = DeleteFGMFlagXML.createBundle();
		MessageHeader mh = DeleteFGMFlagXML.createMessageHeader();
		Parameters pm = DeleteFGMFlagXML.createParameters();
		Practitioner prac = DeleteFGMFlagXML.createPractitioner();
		Organization orgn = DeleteFGMFlagXML.createOrganization();
			
		final Entry entryBundle = bndl.addEntry();		
			
		//final Entry entryMh = bndl.addEntry();
		final Entry entryParam = bndl.addEntry();
		final Entry entryPrac = bndl.addEntry();
		final Entry entryOrg = bndl.addEntry();
			
		//entryMh.setResource(mh);
		//entryBundle.setResource(orgn);
			
		entryBundle.setResource(mh);
		entryParam.setResource(pm);
		entryPrac.setResource(prac);
		entryOrg.setResource(orgn);
			
		// We can now use a parser to encode this resource into a string.
		String output = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(bndl);
			
		System.out.println(output);
		
		//create client
//		String serverBaseUrl = "http://fhirtest.uhn.ca/baseDstu2";
//		//String serverBaseUrl = "http://fhir3.healthintersections.com.au/open";
//		IGenericClient client = ctx.newRestfulGenericClient(serverBaseUrl);

//		//use client to store a new resource instance
//		MethodOutcome outcome = client.create().resource(bndl).execute();
//		System.out.println(outcome.getId());

	}



	public static void main(String[] args) {

		fgmQueryRequest();
      //fgmCreateFlag();
      //fgmDeleteFlag();
		
	}
	
}