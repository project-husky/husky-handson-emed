/**
 * 
 */
package org.projecthusky.handson.dis.impl;

import java.time.Instant;
import java.util.UUID;

import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprCompositionDis;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprDocumentDis;
import org.projecthusky.fhir.emed.ch.epr.resource.dis.ChEmedEprMedicationDispenseDis;
import org.projecthusky.fhir.emed.ch.epr.service.ChEmedEprParser;
import org.projecthusky.handson.dis.DispenseBuisnessLogic;
import org.springframework.stereotype.Component;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.EncodingEnum;
import lombok.extern.log4j.Log4j2;

/**
 * 
 */
@Component
@Log4j2
public class DispenseBusinessLogicImpl implements DispenseBuisnessLogic {

	@Override
	public void createDispenseDocument() {
		
		Instant now = Instant.now();
		ChEmedEprDocumentDis document = new ChEmedEprDocumentDis(UUID.randomUUID(), now);
		ChEmedEprCompositionDis composition = new ChEmedEprCompositionDis(UUID.randomUUID(), now, LanguageCode.GERMAN);
		document.setComposition(composition);
		ChEmedEprMedicationDispenseDis medicationDispense = new ChEmedEprMedicationDispenseDis(UUID.randomUUID(), now);		
		document.addMedicationDispense(medicationDispense);
			
		
		final var ctx = FhirContext.forR4Cached();
        final var parser = new ChEmedEprParser(ctx);
        
        String serialized = parser.serializePrettyPrint(document, EncodingEnum.JSON);
        
        log.info(serialized);
	}

}
