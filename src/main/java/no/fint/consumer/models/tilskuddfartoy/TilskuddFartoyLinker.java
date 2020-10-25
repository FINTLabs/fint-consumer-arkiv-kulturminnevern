package no.fint.consumer.models.tilskuddfartoy;

import no.fint.model.resource.arkiv.kulturminnevern.TilskuddFartoyResource;
import no.fint.model.resource.arkiv.kulturminnevern.TilskuddFartoyResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class TilskuddFartoyLinker extends FintLinker<TilskuddFartoyResource> {

    public TilskuddFartoyLinker() {
        super(TilskuddFartoyResource.class);
    }

    public void mapLinks(TilskuddFartoyResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public TilskuddFartoyResources toResources(Collection<TilskuddFartoyResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public TilskuddFartoyResources toResources(Stream<TilskuddFartoyResource> stream, int offset, int size, int totalItems) {
        TilskuddFartoyResources resources = new TilskuddFartoyResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(TilskuddFartoyResource tilskuddfartoy) {
        return getAllSelfHrefs(tilskuddfartoy).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(TilskuddFartoyResource tilskuddfartoy) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(tilskuddfartoy.getSoknadsnummer()) && !isEmpty(tilskuddfartoy.getSoknadsnummer().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(tilskuddfartoy.getSoknadsnummer().getIdentifikatorverdi(), "soknadsnummer"));
        }
        if (!isNull(tilskuddfartoy.getMappeId()) && !isEmpty(tilskuddfartoy.getMappeId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(tilskuddfartoy.getMappeId().getIdentifikatorverdi(), "mappeid"));
        }
        if (!isNull(tilskuddfartoy.getSystemId()) && !isEmpty(tilskuddfartoy.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(tilskuddfartoy.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(TilskuddFartoyResource tilskuddfartoy) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(tilskuddfartoy.getSoknadsnummer()) && !isEmpty(tilskuddfartoy.getSoknadsnummer().getIdentifikatorverdi())) {
            builder.add(tilskuddfartoy.getSoknadsnummer().getIdentifikatorverdi().hashCode());
        }
        if (!isNull(tilskuddfartoy.getMappeId()) && !isEmpty(tilskuddfartoy.getMappeId().getIdentifikatorverdi())) {
            builder.add(tilskuddfartoy.getMappeId().getIdentifikatorverdi().hashCode());
        }
        if (!isNull(tilskuddfartoy.getSystemId()) && !isEmpty(tilskuddfartoy.getSystemId().getIdentifikatorverdi())) {
            builder.add(tilskuddfartoy.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

