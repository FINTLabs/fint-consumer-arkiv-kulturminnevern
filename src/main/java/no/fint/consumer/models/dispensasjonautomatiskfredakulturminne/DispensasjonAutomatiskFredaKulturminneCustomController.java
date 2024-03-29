package no.fint.consumer.models.dispensasjonautomatiskfredakulturminne;

import no.fint.consumer.exceptions.EventResponseException;
import no.fint.consumer.utils.RestEndpoints;
import no.fint.event.model.HeaderConstants;
import no.fint.model.resource.arkiv.kulturminnevern.DispensasjonAutomatiskFredaKulturminneResource;
import no.fint.relations.FintRelationsMediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = RestEndpoints.DISPENSASJONAUTOMATISKFREDAKULTURMINNE, produces = {FintRelationsMediaType.APPLICATION_HAL_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
public class DispensasjonAutomatiskFredaKulturminneCustomController {
    @Autowired
    private DispensasjonAutomatiskFredaKulturminneController dispensasjonAutomatiskFredaKulturminneController;

    @GetMapping("/mappeid/{ar}/{sekvensnummer}")
    public DispensasjonAutomatiskFredaKulturminneResource getDispensasjonAutomatiskFredaKulturminneByMappeArSekvensnummer(
            @PathVariable String ar,
            @PathVariable String sekvensnummer,
            @RequestHeader(name = HeaderConstants.ORG_ID, required = false) String orgId,
            @RequestHeader(name = HeaderConstants.CLIENT, required = false) String client) throws InterruptedException {
        return dispensasjonAutomatiskFredaKulturminneController.getDispensasjonAutomatiskFredaKulturminneByMappeId(ar + "/" + sekvensnummer, orgId, client);
    }

    @PutMapping("/mappeid/{ar}/{sekvensnummer}")
    public ResponseEntity putDispensasjonAutomatiskFredaKulturminneByMappeArSekvensnummer(
            @PathVariable String ar,
            @PathVariable String sekvensnummer,
            @RequestHeader(name = HeaderConstants.ORG_ID, required = false) String orgId,
            @RequestHeader(name = HeaderConstants.CLIENT, required = false) String client,
            @RequestBody DispensasjonAutomatiskFredaKulturminneResource body) {
        return dispensasjonAutomatiskFredaKulturminneController.putDispensasjonAutomatiskFredaKulturminneByMappeId(ar + "/" + sekvensnummer, orgId, client, body);
    }

    //
    // Exception handlers
    //
    @ExceptionHandler(EventResponseException.class)
    public ResponseEntity handleEventResponseException(EventResponseException e) {
        return ResponseEntity.status(e.getStatus()).body(e.getResponse());
    }

}
