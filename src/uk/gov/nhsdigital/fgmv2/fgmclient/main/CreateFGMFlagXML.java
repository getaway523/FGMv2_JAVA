package uk.gov.nhsdigital.fgmv2.fgmclient.main;

import java.util.ArrayList;
import java.util.List;
import ca.uhn.fhir.model.api.ResourceMetadataKeyEnum;
import ca.uhn.fhir.model.base.resource.ResourceMetadataMap;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.composite.PeriodDt;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Flag;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader.Destination;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader.Source;
import ca.uhn.fhir.model.dstu2.resource.Practitioner.PractitionerRole;
import ca.uhn.fhir.model.dstu2.valueset.BundleTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointSystemEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.FlagStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.IdentifierUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.NameUseEnum;
import ca.uhn.fhir.model.primitive.DateDt;
import ca.uhn.fhir.model.primitive.DateTimeDt;
import ca.uhn.fhir.model.primitive.InstantDt;


public class CreateFGMFlagXML {
	
	@SuppressWarnings("unchecked")
	public static Bundle createBundle(){
		
		final Bundle bndl = new Bundle();
		
		bndl.setId("13daadee-26e1-4d6a-9e6a-7f4af9b58877");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/spine-message-bundle-1-0");
		bndl.setResourceMetadata(meta);
		//SWK bundle type
		//These valuesets must either be empty, or be populated with a value drawn from the list of allowable values 
		//defined by FHIR. HAPI provides special typesafe Enums to help in dealing with these fields.
		// HAPI provides Java enumerated types which make it easier to
		// deal with coded values. This code achieves the exact same result
		bndl.setType(BundleTypeEnum.MESSAGE);
		// end bundle type
		return bndl;
	}
	
	public static MessageHeader createMessageHeader(){
		
		MessageHeader msgH = new MessageHeader();
		msgH.setId("14daadee-26e1-4d6a-9e6a-7f4af9b58877");
		
		InstantDt dt = new InstantDt();
		dt.setValueAsString("2015-06-22T14:04:44+00:00");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		//lastUpdated meta element not needed in FGM Query message
		//meta.put(ResourceMetadataKeyEnum.UPDATED, dt);
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/spine-request-messageheader-2-0");
		msgH.setResourceMetadata(meta);
		
		dt.setValueAsString("2015-07-04T09:10:14+00:00");
		msgH.setTimestamp(dt);
		
		CodingDt event = new CodingDt();
		
		event.setSystem("http://fhir.nhs.net/ValueSet/message-event-2-0");
		event.setCode("urn:nhs:names:services:clinicals-sync:FGMCreate_1_0");
		msgH.setEvent(event);
		Source src = new Source();
		src.setName("FooBar NHS Trust").setSoftware("FooBar Patient Manager").setEndpoint("urn:nhs:addressing:asid:047192794544");
		src.setContact(new ContactPointDt().setSystem(ContactPointSystemEnum.PHONE).setValue("0207 444777"));
		msgH.setSource(src);
		
		msgH.addDestination(new Destination().setName("SPINE").setEndpoint("urn:nhs:addressing:asid:990101234567"));
		msgH.setAuthor(new ResourceReferenceDt().setReference("Practitioner/41fe704c-18e5-11e5-b60b-1697f925ec7b").setDisplay("Dr Town Wood"));
		
		ResourceReferenceDt rr2 = new ResourceReferenceDt();
		rr2.setReference("Flag/7cb73a48-090d-469a-a2b2-04f1e6b11ea2");
		List<ResourceReferenceDt> rr2list = new ArrayList<ResourceReferenceDt>();
		rr2list.add(rr2);
		
		msgH.setData(rr2list);
		
		return msgH;
		
	}
	
	
	@SuppressWarnings("deprecation")
	public static Flag createFlag() {
		
		Organization org1 = new Organization();
		org1.setId("#99600119-ebaf-4362-bb89-d473a33b1675");
		ResourceMetadataMap meta2 = new ResourceMetadataMap();
		meta2.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/spine-gp-organization-1-0");
		org1.setResourceMetadata(meta2);
		IdentifierDt rr2 = new IdentifierDt();
		rr2.setSystem("http://fhir.nhs.net/Id/ods-organization-code").setValue("B86022");
		List<IdentifierDt> idenList = new ArrayList<IdentifierDt>();
		idenList.add(rr2);
		org1.setIdentifier(idenList);
		//org1.getNameElement().setValue("GP WHITTINGTON PRACTICE");
		
		Patient pat = new Patient();
		pat.setId("#13daadee-26e1-4d6a-9e6a-7f4af9b58878");
		ResourceMetadataMap meta1 = new ResourceMetadataMap();
		meta1.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/spine-ris-patient-2-0");
		pat.setResourceMetadata(meta1);
		pat.addIdentifier().setSystem("http://fhir.nhs.net/Id/nhs-number").setValue("1352465790");
		pat.setBirthDate(new DateDt("1957-01-01"));
		pat.addCareProvider().setResource(org1);
		
		Flag flg = new Flag();
		flg.setId("7cb73a48-090d-469a-a2b2-04f1e6b11ea2");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/spine-ris-flag-1-0");
		flg.setResourceMetadata(meta);
		flg.setStatus(FlagStatusEnum.ACTIVE);
		flg.setPeriod(new PeriodDt().setStart(new DateTimeDt("2015-02-04")));
		
		//flg.setSubject(new ResourceReferenceDt().setReference("#20daadee-26e1-4d6a-9e6a-7f4af9b58877"));
		flg.getSubject().setResource(pat);
		
		// Coded types can naturally be set using plain strings
		CodingDt flgCoding = flg.getCode().addCoding();
		flgCoding.setSystem("http://fhir.nhs.net/ValueSet/risk-indicator-type-1-0");
		flgCoding.setCode("FGM");

		return flg;
		
	}
	
	public static Practitioner createPractitioner(){
		
		Practitioner prac = new Practitioner();
		prac.setId("41fe704c-18e5-11e5-b60b-1697f925ec7b");
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/spine-practitioner-1-0");
		prac.setResourceMetadata(meta);
		
		List<IdentifierDt> identifierList = new ArrayList<IdentifierDt>();
		
		identifierList.add(0,new IdentifierDt().setSystem("http://fhir.nhs.net/Id/sds-user-id").setValue("200009876204"));
		identifierList.add(1,new IdentifierDt().setSystem("http://fhir.nhs.net/Id/sds-role-profile-id").setValue("100077650987"));
		prac.setIdentifier(identifierList);
		
		List<PractitionerRole> PracRoleList = new ArrayList<PractitionerRole>();
		
		PractitionerRole pr1 = new PractitionerRole();
		pr1.setManagingOrganization(new ResourceReferenceDt().setReference("Organization/41fe704c-18e5-11e5-b60b-1697f925ec7b"));
		PracRoleList.add(pr1);
		prac.setPractitionerRole(PracRoleList);
		
		return prac;
		
	}
	
	public static Organization createOrganization(){
		
		Organization org = new Organization();
		org.setId("13daadee-26e1-4d6a-9e6a-7f4af9b58878");
		org.setName("THE WHITTINGTON HOSPITAL NHS TRUST");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/spine-organization-1-0");
		org.setResourceMetadata(meta);
		
		IdentifierDt rr2 = new IdentifierDt();
		rr2.setSystem("http://fhir.nhs.net/Id/ods-organization-code").setValue("RKE");
		List<IdentifierDt> idenList = new ArrayList<IdentifierDt>();
		idenList.add(rr2);
		org.setIdentifier(idenList);
		return org;
	}
		
public static Patient createPatient(){
		
		Patient pat = new Patient();
		pat.setId("13daadee-26e1-4d6a-9e6a-7f4af9b58878");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/spine-ris-patient-1-0");
		pat.setResourceMetadata(meta);
		
		List<IdentifierDt> patIdList = new ArrayList<IdentifierDt>();
		
		patIdList.add(0,new IdentifierDt().setSystem("http://fhir.nhs.net/Id/nhs-number").setValue("1234567890"));
		pat.setIdentifier(patIdList);
		
		return pat;
	}
	
}
