package no.fint.consumer.models.tilskuddfredabygningprivateie;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import no.fint.consumer.utils.RestEndpoints;
import no.fint.event.model.HeaderConstants;
import no.fint.model.resource.arkiv.kulturminnevern.TilskuddFredaBygningPrivatEieResource;
import no.fint.relations.FintRelationsMediaType;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = {"TilskuddFredaHusPrivatEie"})
@CrossOrigin
@RestController
@RequestMapping(name = "TilskuddFredaHusPrivatEie", value = RestEndpoints.TILSKUDDFREDABYGNINGPRIVATEIE, produces = {FintRelationsMediaType.APPLICATION_HAL_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
public class TilskuddFredaBygningPrivatEieCustomController {

    private final TilskuddFredaBygningPrivatEieController controller;

    public TilskuddFredaBygningPrivatEieCustomController(TilskuddFredaBygningPrivatEieController controller) {
        this.controller = controller;
    }

    @GetMapping("/mappeid/{ar}/{sekvensnummer}")
    public TilskuddFredaBygningPrivatEieResource getTilskuddFredaHusPrivatEieByMappeArSekvensnummer(
            @PathVariable String ar,
            @PathVariable String sekvensnummer,
            @RequestHeader(name = HeaderConstants.ORG_ID, required = false) String orgId,
            @RequestHeader(name = HeaderConstants.CLIENT, required = false) String client) throws InterruptedException {
        return controller.getTilskuddFredaBygningPrivatEieByMappeId(ar + "/" + sekvensnummer, orgId, client);
    }

    @PutMapping("/mappeid/{ar}/{sekvensnummer}")
    public ResponseEntity putTilskuddFredaHusPrivatEieByMappeArSekvensnummer(
            @PathVariable String ar,
            @PathVariable String sekvensnummer,
            @RequestHeader(name = HeaderConstants.ORG_ID, required = false) String orgId,
            @RequestHeader(name = HeaderConstants.CLIENT, required = false) String client,
            @RequestBody TilskuddFredaBygningPrivatEieResource body) {
        return controller.putTilskuddFredaBygningPrivatEieByMappeId(ar + "/" + sekvensnummer, orgId, client, body);
    }

}

