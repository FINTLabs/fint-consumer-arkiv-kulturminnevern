package no.fint.consumer.models.tilskuddfredabygningprivateie;

import no.fint.model.resource.arkiv.kulturminnevern.TilskuddFredaBygningPrivatEieResource;
import no.fint.model.resource.arkiv.kulturminnevern.TilskuddFredaBygningPrivatEieResources;
import no.fint.relations.FintLinker;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static org.springframework.util.StringUtils.isEmpty;

@Component
public class TilskuddFredaBygningPrivatEieLinker extends FintLinker<TilskuddFredaBygningPrivatEieResource> {

    public TilskuddFredaBygningPrivatEieLinker() {
        super(TilskuddFredaBygningPrivatEieResource.class);
    }

    public void mapLinks(TilskuddFredaBygningPrivatEieResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public TilskuddFredaBygningPrivatEieResources toResources(Collection<TilskuddFredaBygningPrivatEieResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public TilskuddFredaBygningPrivatEieResources toResources(Stream<TilskuddFredaBygningPrivatEieResource> stream, int offset, int size, int totalItems) {
        TilskuddFredaBygningPrivatEieResources resources = new TilskuddFredaBygningPrivatEieResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(TilskuddFredaBygningPrivatEieResource tilskuddfredabygningprivateie) {
        return getAllSelfHrefs(tilskuddfredabygningprivateie).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(TilskuddFredaBygningPrivatEieResource tilskuddfredabygningprivateie) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(tilskuddfredabygningprivateie.getSoknadsnummer()) && !isEmpty(tilskuddfredabygningprivateie.getSoknadsnummer().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(tilskuddfredabygningprivateie.getSoknadsnummer().getIdentifikatorverdi(), "soknadsnummer"));
        }
        if (!isNull(tilskuddfredabygningprivateie.getMappeId()) && !isEmpty(tilskuddfredabygningprivateie.getMappeId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(tilskuddfredabygningprivateie.getMappeId().getIdentifikatorverdi(), "mappeid"));
        }
        if (!isNull(tilskuddfredabygningprivateie.getSystemId()) && !isEmpty(tilskuddfredabygningprivateie.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(tilskuddfredabygningprivateie.getSystemId().getIdentifikatorverdi(), "systemid"));
        }
        
        return builder.build();
    }

    int[] hashCodes(TilskuddFredaBygningPrivatEieResource tilskuddfredabygningprivateie) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(tilskuddfredabygningprivateie.getSoknadsnummer()) && !isEmpty(tilskuddfredabygningprivateie.getSoknadsnummer().getIdentifikatorverdi())) {
            builder.add(tilskuddfredabygningprivateie.getSoknadsnummer().getIdentifikatorverdi().hashCode());
        }
        if (!isNull(tilskuddfredabygningprivateie.getMappeId()) && !isEmpty(tilskuddfredabygningprivateie.getMappeId().getIdentifikatorverdi())) {
            builder.add(tilskuddfredabygningprivateie.getMappeId().getIdentifikatorverdi().hashCode());
        }
        if (!isNull(tilskuddfredabygningprivateie.getSystemId()) && !isEmpty(tilskuddfredabygningprivateie.getSystemId().getIdentifikatorverdi())) {
            builder.add(tilskuddfredabygningprivateie.getSystemId().getIdentifikatorverdi().hashCode());
        }
        
        return builder.build().toArray();
    }

}

