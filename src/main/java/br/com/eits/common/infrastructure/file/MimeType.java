package br.com.eits.common.infrastructure.file;

/**
 * 
 * @author rodrigo
 */
public enum MimeType 
{
	/*-------------------------------------------------------------------
	 *				 		     		ENUMS
	 *-------------------------------------------------------------------*/
    $323 		("text/h323"),
    $3GP 		("video/3gpp"),
    $7Z 		("application/x-7z-compressed"),
    ABW 		("application/x-abiword"),
    AI 			("application/postscript"),
    AIF 		("audio/x-aiff"),
    AIFC 		("audio/x-aiff"),
    AIFF 		("audio/x-aiff"),
    ALC 		("chemical/x-alchemy"),
    ART 		("image/x-jg"),
    ASC 		("text/plain"),
    ASF 		("video/x-ms-asf"),
    $ASN 		("chemical/x-ncbi-asn1"),
    ASN 		("chemical/x-ncbi-asn1-spec"),
    ASO 		("chemical/x-ncbi-asn1-binary"),
    ASX 		("video/x-ms-asf"),
    ATOM 		("application/atom"),
    ATOMCAT 	("application/atomcat+xml"),
    ATOMSRV 	("application/atomserv+xml"),
    AU 			("audio/basic"),
    AVI 		("video/x-msvideo"),
    BAK 		("application/x-trash"),
    BAT 		("application/x-msdos-program"),
    B 			("chemical/x-molconn-Z"),
    BCPIO 		("application/x-bcpio"),
    BIB 		("text/x-bibtex"),
    BIN 		("application/octet-stream"),
    BMP 		("image/x-ms-bmp"),
    BOOK 		("application/x-maker"),
    BOO 		("text/x-boo"),
    BSD 		("chemical/x-crossfire"),
    C3D 		("chemical/x-chem3d"),
    CAB 		("application/x-cab"),
    CAC 		("chemical/x-cache"),
    CACHE 		("chemical/x-cache"),
    CAP 		("application/cap"),
    CASCII 		("chemical/x-cactvs-binary"),
    CAT 		("application/vnd.ms-pki.seccat"),
    CBIN 		("chemical/x-cactvs-binary"),
    CBR 		("application/x-cbr"),
    CBZ 		("application/x-cbz"),
    CC 			("text/x-c++src"),
    CDF 		("application/x-cdf"),
    CDR 		("image/x-coreldraw"),
    CDT 		("image/x-coreldrawtemplate"),
    CDX 		("chemical/x-cdx"),
    CDY 		("application/vnd.cinderella"),
    CEF 		("chemical/x-cxf"),
    CER 		("chemical/x-cerius"),
    CHM 		("chemical/x-chemdraw"),
    CHRT 		("application/x-kchart"),
    CIF 		("chemical/x-cif"),
    $CLASS 		("application/java-vm"),
    CLS 		("text/x-tex"),
    CMDF 		("chemical/x-cmdf"),
    CML 		("chemical/x-cml"),
    COD 		("application/vnd.rim.cod"),
    COM 		("application/x-msdos-program"),
    CPA 		("chemical/x-compass"),
    CPIO 		("application/x-cpio"),
    CPP 		("text/x-c++src"),
    $CPT 		("application/mac-compactpro"),
    CPT 		("image/x-corelphotopaint"),
    CRL 		("application/x-pkcs7-crl"),
    CRT 		("application/x-x509-ca-cert"),
    CSF 		("chemical/x-cache-csf"),
    $CSH 		("application/x-csh"),
    CSH 		("text/x-csh"),
    CSM 		("chemical/x-csml"),
    CSML 		("chemical/x-csml"),
    CSS 		("text/css"),
    CSV 		("text/csv"),
    CTAB 		("chemical/x-cactvs-binary"),
    C 			("text/x-csrc"),
    CTX 		("chemical/x-ctx"),
    CU 			("application/cu-seeme"),
    CUB 		("chemical/x-gaussian-cube"),
    CXF 		("chemical/x-cxf"),
    CXX 		("text/x-c++src"),
    DAT 		("chemical/x-mopac-input"),
    DCR 		("application/x-director"),
    DEB 		("application/x-debian-package"),
    DIFF 		("text/x-diff"),
    DIF 		("video/dv"),
    DIR 		("application/x-director"),
    DJV 		("image/vnd.djvu"),
    DJVU 		("image/vnd.djvu"),
    DLL 		("application/x-msdos-program"),
    DL 			("video/dl"),
    DMG 		("application/x-apple-diskimage"),
    DMS 		("application/x-dms"),
    DOC 		("application/msword"),
    DOT 		("application/msword"),
    D 			("text/x-dsrc"),
    DVI 		("application/x-dvi"),
    DV 			("video/dv"),
    DX 			("chemical/x-jcamp-dx"),
    DXR 		("application/x-director"),
    EMB 		("chemical/x-embl-dl-nucleotide"),
    EMBL 		("chemical/x-embl-dl-nucleotide"),
    EML 		("message/rfc822"),
    $ENT 		("chemical/x-ncbi-asn1-ascii"),
    ENT 		("chemical/x-pdb"),
    EPS 		("application/postscript"),
    ETX 		("text/x-setext"),
    EXE 		("application/x-msdos-program"),
    EZ 			("application/andrew-inset"),
    FB 			("application/x-maker"),
    FBDOC 		("application/x-maker"),
    FCH 		("chemical/x-gaussian-checkpoint"),
    FCHK 		("chemical/x-gaussian-checkpoint"),
    FIG 		("application/x-xfig"),
    FLAC 		("application/x-flac"),
    FLI 		("video/fli"),
    FM 			("application/x-maker"),
    FRAME 		("application/x-maker"),
    FRM 		("application/x-maker"),
    GAL 		("chemical/x-gaussian-log"),
    GAM 		("chemical/x-gamess-input"),
    GAMIN 		("chemical/x-gamess-input"),
    GAU 		("chemical/x-gaussian-input"),
    GCD 		("text/x-pcs-gcd"),
    GCF 		("application/x-graphing-calculator"),
    GCG 		("chemical/x-gcg8-sequence"),
    GEN 		("chemical/x-genbank"),
    GF 			("application/x-tex-gf"),
    GIF 		("image/gif"),
    GJC 		("chemical/x-gaussian-input"),
    GJF 		("chemical/x-gaussian-input"),
    GL 			("video/gl"),
    GNUMERIC 	("application/x-gnumeric"),
    GPT 		("chemical/x-mopac-graph"),
    GSF 		("application/x-font"),
    GSM 		("audio/x-gsm"),
    GTAR 		("application/x-gtar"),
    HDF 		("application/x-hdf"),
    HH 			("text/x-c++hdr"),
    HIN 		("chemical/x-hin"),
    HPP 		("text/x-c++hdr"),
    HQX 		("application/mac-binhex40"),
    HS 			("text/x-haskell"),
    HTA 		("application/hta"),
    HTC 		("text/x-component"),
    $H 			("text/x-chdr"),
    HTML 		("text/html"),
    HTM 		("text/html"),
    HXX 		("text/x-c++hdr"),
    ICA 		("application/x-ica"),
    ICE 		("x-conference/x-cooltalk"),
    ICO 		("image/x-icon"),
    ICS 		("text/calendar"),
    ICZ 		("text/calendar"),
    IEF 		("image/ief"),
    IGES 		("model/iges"),
    IGS 		("model/iges"),
    III 		("application/x-iphone"),
    INP 		("chemical/x-gamess-input"),
    INS 		("application/x-internet-signup"),
    ISO 		("application/x-iso9660-image"),
    ISP 		("application/x-internet-signup"),
    IST 		("chemical/x-isostar"),
    ISTR 		("chemical/x-isostar"),
    JAD 		("text/vnd.sun.j2me.app-descriptor"),
    JAR 		("application/java-archive"),
    JAVA 		("text/x-java"),
    JDX 		("chemical/x-jcamp-dx"),
    JMZ 		("application/x-jmol"),
    JNG 		("image/x-jng"),
    JNLP 		("application/x-java-jnlp-file"),
    JPEG 		("image/jpeg"),
    JPE 		("image/jpeg"),
    JPG 		("image/jpeg"),
    JS 			("application/x-javascript"),
    KAR 		("audio/midi"),
    KEY 		("application/pgp-keys"),
    KIL 		("application/x-killustrator"),
    KIN 		("chemical/x-kinemage"),
    KML 		("application/vnd.google-earth.kml+xml"),
    KMZ 		("application/vnd.google-earth.kmz"),
    KPR 		("application/x-kpresenter"),
    KPT 		("application/x-kpresenter"),
    KSP 		("application/x-kspread"),
    KWD 		("application/x-kword"),
    KWT 		("application/x-kword"),
    LATEX 		("application/x-latex"),
    LHA 		("application/x-lha"),
    LHS 		("text/x-literate-haskell"),
    LSF 		("video/x-la-asf"),
    LSX 		("video/x-la-asf"),
    LTX 		("text/x-tex"),
    LYX 		("application/x-lyx"),
    LZH 		("application/x-lzh"),
    LZX 		("application/x-lzx"),
    $M3U 		("audio/mpegurl"),
    M3U 		("audio/x-mpegurl"),
    $M4A 		("audio/mpeg"),
    M4A 		("video/mp4"),
    M4B 		("video/mp4"),
    M4V 		("video/mp4"),
    MAKER 		("application/x-maker"),
    MAN 		("application/x-troff-man"),
    MCIF 		("chemical/x-mmcif"),
    MCM 		("chemical/x-macmolecule"),
    MDB 		("application/msaccess"),
    ME 			("application/x-troff-me"),
    MESH 		("model/mesh"),
    MID 		("audio/midi"),
    MIDI 		("audio/midi"),
    MIF 		("application/x-mif"),
    MM 			("application/x-freemind"),
    MMD 		("chemical/x-macromodel-input"),
    MMF 		("application/vnd.smaf"),
    MML 		("text/mathml"),
    MMOD 		("chemical/x-macromodel-input"),
    MNG 		("video/x-mng"),
    MOC 		("text/x-moc"),
    MOL2 		("chemical/x-mol2"),
    MOL 		("chemical/x-mdl-molfile"),
    MOO 		("chemical/x-mopac-out"),
    MOP 		("chemical/x-mopac-input"),
    MOPCRT 		("chemical/x-mopac-input"),
    MOVIE 		("video/x-sgi-movie"),
    MOV 		("video/quicktime"),
    MP2 		("audio/mpeg"),
    MP3 		("audio/mpeg"),
    MP4 		("video/mp4"),
    MPC 		("chemical/x-mopac-input"),
    MPEGA 		("audio/mpeg"),
    MPEG 		("video/mpeg"),
    MPE 		("video/mpeg"),
    MPGA 		("audio/mpeg"),
    MPG 		("video/mpeg"),
    MS 			("application/x-troff-ms"),
    MSH 		("model/mesh"),
    MSI 		("application/x-msi"),
    MVB 		("chemical/x-mopac-vib"),
    MXU 		("video/vnd.mpegurl"),
    NB 			("application/mathematica"),
    NC 			("application/x-netcdf"),
    NWC 		("application/x-nwc"),
    O 			("application/x-object"),
    ODA 		("application/oda"),
    ODB 		("application/vnd.oasis.opendocument.database"),
    ODC 		("application/vnd.oasis.opendocument.chart"),
    ODF 		("application/vnd.oasis.opendocument.formula"),
    ODG 		("application/vnd.oasis.opendocument.graphics"),
    ODI 		("application/vnd.oasis.opendocument.image"),
    ODM 		("application/vnd.oasis.opendocument.text-master"),
    ODP 		("application/vnd.oasis.opendocument.presentation"),
    ODS 		("application/vnd.oasis.opendocument.spreadsheet"),
    ODT 		("application/vnd.oasis.opendocument.text"),
    OGA 		("audio/ogg"),
    OGG 		("application/ogg"),
    OGV 		("video/ogg"),
    OGX 		("application/ogg"),
    OLD 		("application/x-trash"),
    OTG 		("application/vnd.oasis.opendocument.graphics-template"),
    OTH 		("application/vnd.oasis.opendocument.text-web"),
    OTP 		("application/vnd.oasis.opendocument.presentation-template"),
    OTS 		("application/vnd.oasis.opendocument.spreadsheet-template"),
    OTT 		("application/vnd.oasis.opendocument.text-template"),
    OZA 		("application/x-oz-application"),
    P7R 		("application/x-pkcs7-certreqresp"),
    PAC 		("application/x-ns-proxy-autoconfig"),
    PAS 		("text/x-pascal"),
    PATCH 		("text/x-diff"),
    PAT 		("image/x-coreldrawpattern"),
    PBM 		("image/x-portable-bitmap"),
    PCAP 		("application/cap"),
    PCF 		("application/x-font"),
    PCX 		("image/pcx"),
    PDB 		("chemical/x-pdb"),
    PDF 		("application/pdf"),
    PFA 		("application/x-font"),
    PFB 		("application/x-font"),
    PGM 		("image/x-portable-graymap"),
    PGN 		("application/x-chess-pgn"),
    PGP 		("application/pgp-signature"),
    PHP3 		("application/x-httpd-php3"),
    PHP3P 		("application/x-httpd-php3-preprocessed"),
    PHP4 		("application/x-httpd-php4"),
    PHP 		("application/x-httpd-php"),
    PHPS 		("application/x-httpd-php-source"),
    PHT 		("application/x-httpd-php"),
    PHTML 		("application/x-httpd-php"),
    PK 			("application/x-tex-pk"),
    PLS 		("audio/x-scpls"),
    PL 			("text/x-perl"),
    PM 			("text/x-perl"),
    PNG 		("image/png"),
    PNM 		("image/x-portable-anymap"),
    POT 		("text/plain"),
    PPM 		("image/x-portable-pixmap"),
    PPS 		("application/vnd.ms-powerpoint"),
    PPT 		("application/vnd.ms-powerpoint"),
    PRF 		("application/pics-rules"),
    PRT 		("chemical/x-ncbi-asn1-ascii"),
    PS 			("application/postscript"),
    PSD 		("image/x-photoshop"),
    P 			("text/x-pascal"),
    PYC 		("application/x-python-code"),
    PYO 		("application/x-python-code"),
    PY 			("text/x-python"),
    QTL 		("application/x-quicktimeplayer"),
    QT 			("video/quicktime"),
    $RA 		("audio/x-pn-realaudio"),
    RA 			("audio/x-realaudio"),
    RAM 		("audio/x-pn-realaudio"),
    RAR 		("application/rar"),
    RAS 		("image/x-cmu-raster"),
    RD 			("chemical/x-mdl-rdfile"),
    RDF 		("application/rdf+xml"),
    RGB 		("image/x-rgb"),
    RHTML 		("application/x-httpd-eruby"),
    RM 			("audio/x-pn-realaudio"),
    ROFF 		("application/x-troff"),
    ROS 		("chemical/x-rosdal"),
    RPM 		("application/x-redhat-package-manager"),
    RSS 		("application/rss+xml"),
    RTF 		("application/rtf"),
    RTX 		("text/richtext"),
    RXN 		("chemical/x-mdl-rxnfile"),
    SCT 		("text/scriptlet"),
    SD2 		("audio/x-sd2"),
    SDA 		("application/vnd.stardivision.draw"),
    SDC 		("application/vnd.stardivision.calc"),
    SD 			("chemical/x-mdl-sdfile"),
    SDD 		("application/vnd.stardivision.impress"),
    $SDF 		("application/vnd.stardivision.math"),
    SDF 		("chemical/x-mdl-sdfile"),
    SDS 		("application/vnd.stardivision.chart"),
    SDW 		("application/vnd.stardivision.writer"),
    SER 		("application/java-serialized-object"),
    SGF 		("application/x-go-sgf"),
    SGL 		("application/vnd.stardivision.writer-global"),
    $SH 		("application/x-sh"),
    SHAR 		("application/x-shar"),
    SH 			("text/x-sh"),
    SHTML 		("text/html"),
    SID 		("audio/prs.sid"),
    SIK 		("application/x-trash"),
    SILO 		("model/mesh"),
    SIS 		("application/vnd.symbian.install"),
    SISX 		("x-epoc/x-sisx-app"),
    SIT 		("application/x-stuffit"),
    SITX 		("application/x-stuffit"),
    SKD 		("application/x-koan"),
    SKM 		("application/x-koan"),
    SKP 		("application/x-koan"),
    SKT 		("application/x-koan"),
    SMI 		("application/smil"),
    SMIL 		("application/smil"),
    SND 		("audio/basic"),
    SPC 		("chemical/x-galactic-spc"),
    $SPL 		("application/futuresplash"),
    SPL 		("application/x-futuresplash"),
    SPX 		("audio/ogg"),
    SRC 		("application/x-wais-source"),
    STC 		("application/vnd.sun.xml.calc.template"),
    STD 		("application/vnd.sun.xml.draw.template"),
    STI 		("application/vnd.sun.xml.impress.template"),
    STL 		("application/vnd.ms-pki.stl"),
    STW 		("application/vnd.sun.xml.writer.template"),
    STY 		("text/x-tex"),
    SV4CPIO 	("application/x-sv4cpio"),
    SV4CRC 		("application/x-sv4crc"),
    SVG 		("image/svg+xml"),
    SVGZ 		("image/svg+xml"),
    SW 			("chemical/x-swissprot"),
    SWF 		("application/x-shockwave-flash"),
    SWFL 		("application/x-shockwave-flash"),
    SXC 		("application/vnd.sun.xml.calc"),
    SXD 		("application/vnd.sun.xml.draw"),
    SXG 		("application/vnd.sun.xml.writer.global"),
    SXI 		("application/vnd.sun.xml.impress"),
    SXM 		("application/vnd.sun.xml.math"),
    SXW 		("application/vnd.sun.xml.writer"),
    T 			("application/x-troff"),
    TAR 		("application/x-tar"),
    TAZ 		("application/x-gtar"),
    $TCL 		("application/x-tcl"),
    TCL 		("text/x-tcl"),
    TEXI 		("application/x-texinfo"),
    TEXINFO 	("application/x-texinfo"),
    TEX 		("text/x-tex"),
    TEXT 		("text/plain"),
    TGF 		("chemical/x-mdl-tgf"),
    TGZ 		("application/x-gtar"),
    TIFF 		("image/tiff"),
    TIF 		("image/tiff"),
    TK 			("text/x-tcl"),
    TM 			("text/texmacs"),
    TORRENT 	("application/x-bittorrent"),
    TR 			("application/x-troff"),
    TSP 		("application/dsptype"),
    TS 			("text/texmacs"),
    TSV 		("text/tab-separated-values"),
    TXT 		("text/plain"),
    UDEB 		("application/x-debian-package"),
    ULS 		("text/iuls"),
    USTAR 		("application/x-ustar"),
    VAL 		("chemical/x-ncbi-asn1-binary"),
    VCD 		("application/x-cdlink"),
    VCF 		("text/x-vcard"),
    VCS 		("text/x-vcalendar"),
    VMD 		("chemical/x-vmd"),
    VMS 		("chemical/x-vamas-iso14976"),
    $VRML 		("model/vrml"),
    VRML 		("x-world/x-vrml"),
    VRM 		("x-world/x-vrml"),
    VSD 		("application/vnd.visio"),
    WAD 		("application/x-doom"),
    WAV 		("audio/x-wav"),
    WAX 		("audio/x-ms-wax"),
    WBMP 		("image/vnd.wap.wbmp"),
    WBXML 		("application/vnd.wap.wbxml"),
    WK 			("application/x-123"),
    WMA 		("audio/x-ms-wma"),
    WMD 		("application/x-ms-wmd"),
    WMLC 		("application/vnd.wap.wmlc"),
    WMLSC 		("application/vnd.wap.wmlscriptc"),
    WMLS 		("text/vnd.wap.wmlscript"),
    WML 		("text/vnd.wap.wml"),
    WM 			("video/x-ms-wm"),
    WMV 		("video/x-ms-wmv"),
    WMX 		("video/x-ms-wmx"),
    WMZ 		("application/x-ms-wmz"),
    WP5 		("application/wordperfect5.1"),
    WPD 		("application/wordperfect"),
    $WRL 		("model/vrml"),
    WRL 		("x-world/x-vrml"),
    WSC 		("text/scriptlet"),
    WVX 		("video/x-ms-wvx"),
    WZ 			("application/x-wingz"),
    XBM 		("image/x-xbitmap"),
    XCF 		("application/x-xcf"),
    XHT 		("application/xhtml+xml"),
    XHTML 		("application/xhtml+xml"),
    XLB 		("application/vnd.ms-excel"),
    XLS 		("application/vnd.ms-excel"),
    XLT 		("application/vnd.ms-excel"),
    XML 		("application/xml"),
    XPI 		("application/x-xpinstall"),
    XPM 		("image/x-xpixmap"),
    XSL 		("application/xml"),
    XTEL 		("chemical/x-xtel"),
    XUL 		("application/vnd.mozilla.xul+xml"),
    XWD 		("image/x-xwindowdump"),
    XYZ 		("chemical/x-xyz"),
    ZIP 		("application/zip"),
    ZMT 		("chemical/x-mopac-input");
	
	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/
	/**
	 * 
	 */
    public String value;

	/*-------------------------------------------------------------------
	 *				 		     CONSTRUCTORS
	 *-------------------------------------------------------------------*/
    /**
     * 
     * @param contentType
     */
    private MimeType( String value ) 
    { 
        this.value = value;
    }
}
