package no.fint.consumer.models.dispensasjonautomatiskfredakulturminne;

import no.fint.model.resource.arkiv.kulturminnevern.DispensasjonAutomatiskFredaKulturminneResource;
import no.fint.model.resource.arkiv.kulturminnevern.DispensasjonAutomatiskFredaKulturminneResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class DispensasjonAutomatiskFredaKulturminneLinker extends FintLinker<DispensasjonAutomatiskFredaKulturminneResource> {

    public DispensasjonAutomatiskFredaKulturminneLinker() {
        super(DispensasjonAutomatiskFredaKulturminneResource.class);
    }

    public void mapLinks(DispensasjonAutomatiskFredaKulturminneResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public DispensasjonAutomatiskFredaKulturminneResources toResources(Collection<DispensasjonAutomatiskFredaKulturminneResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public DispensasjonAutomatiskFredaKulturminneResources toResources(Stream<DispensasjonAutomatiskFredaKulturminneResource> stream, int offset, int size, int totalItems) {
        DispensasjonAutomatiskFredaKulturminneResources resources = new DispensasjonAutomatiskFredaKulturminneResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(DispensasjonAutomatiskFredaKulturminneResource dispensasjonautomatiskfredakulturminne) {
        return getAllSelfHrefs(dispensasjonautomatiskfredakulturminne).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(DispensasjonAutomatiskFredaKulturminneResource dispensasjonautomatiskfredakulturminne) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(dispensasjonautomatiskfredakulturminne.getSoknadsnummer()) && !isEmpty(dispensasjonautomatiskfredakulturminne.getSoknadsnummer().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(dispensasjonautomatiskfredakulturminne.getSoknadsnummer().getIdentifikatorverdi(), "soknadsnummer"));
        }
        if (!isNull(dispensasjonautomatiskfredakulturminne.getMappeId()) && !isEmpty(dispensasjonautomatiskfredakulturminne.getMappeId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(dispensasjonautomatiskfredakulturminne.getMappeId().getIdentifikatorverdi(), "mappeid"));
        }
        if (!isNull(dispensasjonautomatiskfredakulturminne.getSystemId()) && !isEmpty(dispensasjonautomatiskfredakulturminne.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(dispensasjonautomatiskfredakulturminne.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(DispensasjonAutomatiskFredaKulturminneResource dispensasjonautomatiskfredakulturminne) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(dispensasjonautomatiskfredakulturminne.getSoknadsnummer()) && !isEmpty(dispensasjonautomatiskfredakulturminne.getSoknadsnummer().getIdentifikatorverdi())) {
            builder.add(dispensasjonautomatiskfredakulturminne.getSoknadsnummer().getIdentifikatorverdi().hashCode());
        }
        if (!isNull(dispensasjonautomatiskfredakulturminne.getMappeId()) && !isEmpty(dispensasjonautomatiskfredakulturminne.getMappeId().getIdentifikatorverdi())) {
            builder.add(dispensasjonautomatiskfredakulturminne.getMappeId().getIdentifikatorverdi().hashCode());
        }
        if (!isNull(dispensasjonautomatiskfredakulturminne.getSystemId()) && !isEmpty(dispensasjonautomatiskfredakulturminne.getSystemId().getIdentifikatorverdi())) {
            builder.add(dispensasjonautomatiskfredakulturminne.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

