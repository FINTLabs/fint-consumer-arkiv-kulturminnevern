package no.novari.fint.consumer.config;

public enum Constants {
;

    public static final String COMPONENT = "arkiv-kulturminnevern";
    public static final String COMPONENT_CONSUMER = COMPONENT + " consumer";
    public static final String CACHE_SERVICE = "CACHE_SERVICE";

    
    public static final String CACHE_INITIALDELAY_DISPENSASJONAUTOMATISKFREDAKULTURMINNE = "${fint.consumer.cache.initialDelay.dispensasjonautomatiskfredakulturminne:900000}";
    public static final String CACHE_FIXEDRATE_DISPENSASJONAUTOMATISKFREDAKULTURMINNE = "${fint.consumer.cache.fixedRate.dispensasjonautomatiskfredakulturminne:900000}";
    
    public static final String CACHE_INITIALDELAY_KLASSE = "${fint.consumer.cache.initialDelay.klasse:1000000}";
    public static final String CACHE_FIXEDRATE_KLASSE = "${fint.consumer.cache.fixedRate.klasse:900000}";
    
    public static final String CACHE_INITIALDELAY_TILSKUDDFARTOY = "${fint.consumer.cache.initialDelay.tilskuddfartoy:1100000}";
    public static final String CACHE_FIXEDRATE_TILSKUDDFARTOY = "${fint.consumer.cache.fixedRate.tilskuddfartoy:900000}";
    
    public static final String CACHE_INITIALDELAY_TILSKUDDFREDABYGNINGPRIVATEIE = "${fint.consumer.cache.initialDelay.tilskuddfredabygningprivateie:1200000}";
    public static final String CACHE_FIXEDRATE_TILSKUDDFREDABYGNINGPRIVATEIE = "${fint.consumer.cache.fixedRate.tilskuddfredabygningprivateie:900000}";
    

}
