package no.fint.consumer.config;

import com.google.common.collect.ImmutableMap;
import no.fint.consumer.utils.RestEndpoints;
import no.fint.model.arkiv.kulturminnevern.DispensasjonAutomatiskFredaKulturminne;
import no.fint.model.arkiv.kulturminnevern.TilskuddFartoy;
import no.fint.model.arkiv.kulturminnevern.TilskuddFredaBygningPrivatEie;

import java.util.Map;

public class LinkMapper {

    public static Map<String, String> linkMapper(String contextPath) {
        return ImmutableMap.<String, String>builder()
                .put(DispensasjonAutomatiskFredaKulturminne.class.getName(), contextPath + RestEndpoints.DISPENSASJONAUTOMATISKFREDAKULTURMINNE)
                .put(TilskuddFartoy.class.getName(), contextPath + RestEndpoints.TILSKUDDFARTOY)
                .put(TilskuddFredaBygningPrivatEie.class.getName(), contextPath + RestEndpoints.TILSKUDDFREDABYGNINGPRIVATEIE)
                .put("no.fint.model.administrasjon.organisasjon.Organisasjonselement", "/administrasjon/organisasjon/organisasjonselement")
                .put("no.fint.model.administrasjon.personal.Personalressurs", "/administrasjon/personal/personalressurs")
                .put("no.fint.model.arkiv.kodeverk.DokumentStatus", "/arkiv/kodeverk/dokumentstatus")
                .put("no.fint.model.arkiv.kodeverk.DokumentType", "/arkiv/kodeverk/dokumenttype")
                .put("no.fint.model.arkiv.kodeverk.JournalStatus", "/arkiv/kodeverk/journalstatus")
                .put("no.fint.model.arkiv.kodeverk.JournalpostType", "/arkiv/kodeverk/journalposttype")
                .put("no.fint.model.arkiv.kodeverk.Klassifikasjonstype", "/arkiv/kodeverk/klassifikasjonstype")
                .put("no.fint.model.arkiv.kodeverk.KorrespondansepartType", "/arkiv/kodeverk/korrespondanseparttype")
                .put("no.fint.model.arkiv.kodeverk.Merknadstype", "/arkiv/kodeverk/merknadstype")
                .put("no.fint.model.arkiv.kodeverk.PartRolle", "/arkiv/kodeverk/partrolle")
                .put("no.fint.model.arkiv.kodeverk.Rolle", "/arkiv/kodeverk/rolle")
                .put("no.fint.model.arkiv.kodeverk.Saksstatus", "/arkiv/kodeverk/saksstatus")
                .put("no.fint.model.arkiv.kodeverk.Skjermingshjemmel", "/arkiv/kodeverk/skjermingshjemmel")
                .put("no.fint.model.arkiv.kodeverk.Tilgangsrestriksjon", "/arkiv/kodeverk/tilgangsrestriksjon")
                .put("no.fint.model.arkiv.kodeverk.TilknyttetRegistreringSom", "/arkiv/kodeverk/tilknyttetregistreringsom")
                .put("no.fint.model.arkiv.kodeverk.Variantformat", "/arkiv/kodeverk/variantformat")
                .put("no.fint.model.arkiv.noark.AdministrativEnhet", "/arkiv/noark/administrativenhet")
                .put("no.fint.model.arkiv.noark.Arkivdel", "/arkiv/noark/arkivdel")
                .put("no.fint.model.arkiv.noark.Arkivressurs", "/arkiv/noark/arkivressurs")
                .put("no.fint.model.arkiv.noark.Dokumentfil", "/arkiv/noark/dokumentfil")
                .put("no.fint.model.arkiv.noark.Klassifikasjonssystem", "/arkiv/noark/klassifikasjonssystem")
                .put("no.fint.model.felles.kodeverk.Kommune", "/felles/kodeverk/kommune")
                .put("no.fint.model.felles.kodeverk.iso.Landkode", "/felles/kodeverk/iso/landkode")
                /* .put(TODO,TODO) */
                .build();
    }

}
