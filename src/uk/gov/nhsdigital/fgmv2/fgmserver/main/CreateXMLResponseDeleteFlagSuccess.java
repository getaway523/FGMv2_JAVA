package uk.gov.nhsdigital.fgmv2.fgmserver.main;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.api.ExtensionDt;
import ca.uhn.fhir.model.api.IResource;
import ca.uhn.fhir.model.api.ResourceMetadataKeyEnum;
import ca.uhn.fhir.model.api.TemporalPrecisionEnum;
import ca.uhn.fhir.model.base.resource.ResourceMetadataMap;
import ca.uhn.fhir.model.dstu.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu.resource.Medication;
import ca.uhn.fhir.model.dstu.resource.OperationOutcome.Issue;
import ca.uhn.fhir.model.dstu.valueset.IssueSeverityEnum;
import ca.uhn.fhir.model.dstu.valueset.IssueTypeEnum;
import ca.uhn.fhir.model.dstu2.composite.BoundCodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.ContainedDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.composite.PeriodDt;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader.Destination;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader.Response;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader.Source;
import ca.uhn.fhir.model.dstu2.resource.Parameters.Parameter;
import ca.uhn.fhir.model.dstu2.resource.Flag;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.OperationOutcome;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.model.dstu2.resource.Practitioner.PractitionerRole;
import ca.uhn.fhir.model.dstu2.valueset.BundleTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointSystemEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.FlagStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.IdentifierUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.NameUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.ResponseTypeEnum;
import ca.uhn.fhir.model.primitive.BoundCodeDt;
import ca.uhn.fhir.model.primitive.CodeDt;
import ca.uhn.fhir.model.primitive.DateDt;
import ca.uhn.fhir.model.primitive.DateTimeDt;
import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.model.primitive.InstantDt;
import ca.uhn.fhir.model.primitive.StringDt;

public class CreateXMLResponseDeleteFlagSuccess {

	@SuppressWarnings("unchecked")
	public static Bundle createBundle(){
		
		final Bundle bndl = new Bundle();
		
		bndl.setId("13daadee-26e1-4d6a-9e6a-7f4af9b58877");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/spine-message-bundle-1-0");
		bndl.setResourceMetadata(meta);
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
		//lastUpdated meta element not needed in FGM response message
		//meta.put(ResourceMetadataKeyEnum.UPDATED, dt);
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/spine-response-messageheader-2-0");
		msgH.setResourceMetadata(meta);
		
		dt.setValueAsString("2015-07-04T09:10:14+00:00");
		msgH.setTimestamp(dt);
		
		CodingDt event = new CodingDt();
	
		event.setSystem("http://fhir.nhs.net/ValueSet/message-event-2-0");
		event.setCode("urn:nhs:names:services:clinicals-sync:FGMDeleteResponse_1_0");
		msgH.setEvent(event);
		
		Response rsp = new Response();
		rsp.setIdentifier("14daadee-26e1-4d6a-9e6a-7f4af9b58877");
		rsp.setCode(ResponseTypeEnum.OK);
		msgH.setResponse(rsp);
		
		Source src = new Source();
		src.setName("SPINE").setEndpoint("urn:nhs:addressing:asid:990101234567");
		msgH.setSource(src);
		
		msgH.addDestination(new Destination().setName("FooBar NHS Trust").setEndpoint("urn:nhs:addressing:asid:047192794544"));

		return msgH;
		
	}

	
}
