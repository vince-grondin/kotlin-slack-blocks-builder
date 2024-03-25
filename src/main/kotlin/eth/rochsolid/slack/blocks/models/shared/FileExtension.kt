package eth.rochsolid.slack.blocks.models.shared

import kotlinx.serialization.SerialName

/**
 * [Possible `filetype` values.](https://api.slack.com/types/file#types)
 */
enum class FileExtension(val description: String) {
    @SerialName("auto")
    AUTO_DETECT_TYPE("Auto Detect Type"),

    @SerialName("text")
    PLAIN_TEXT("Plain Text"),

    @SerialName("ai")
    ILLUSTRATOR_FILE("Illustrator File"),

    @SerialName("apk")
    APK("APK"),

    @SerialName("applescript")
    APPLE_SCRIPT("AppleScript"),

    @SerialName("binary")
    BINARY("Binary"),

    @SerialName("bmp")
    BITMAP("Bitmap"),

    @SerialName("boxnote")
    BOX_NOTE("BoxNote"),

    @SerialName("c")
    C("C"),

    @SerialName("csharp")
    C_SHARP("C#"),

    @SerialName("cpp")
    C_PLUS_PLUS("C++"),

    @SerialName("css")
    CSS("CSS"),

    @SerialName("csv")
    CSV("CSV"),

    @SerialName("clojure")
    CLOJURE("Clojure"),

    @SerialName("coffeescript")
    COFFEE_SCRIPT("CoffeeScript"),

    @SerialName("cfm")
    COLD_FUSION("ColdFusion"),

    @SerialName("d")
    D("D"),

    @SerialName("dart")
    DART("Dart"),

    @SerialName("diff")
    DIFF("Diff"),

    @SerialName("doc")
    WORD_DOCUMENT("Word Document"),

    @SerialName("docx")
    WORD_DOCUMENT_EXTENDED("Extended Word document"),

    @SerialName("dockerfile")
    DOCKER("Docker"),

    @SerialName("dotx")
    WORD_TEMPLATE("Word template"),

    @SerialName("email")
    EMAIL("Email"),

    @SerialName("eps")
    EPS("EPS"),

    @SerialName("epub")
    EPUB("EPUB"),

    @SerialName("erlang")
    ERLANG("Erlang"),

    @SerialName("fla")
    FLASH_FLA("Flash FLA"),

    @SerialName("flv")
    FLASH_VIDEO("Flash video"),

    @SerialName("fsharp")
    F_SHARP("F#"),

    @SerialName("fortran")
    FORTRAN("Fortran"),

    @SerialName("gdoc")
    GDOCS_DOCUMENT("GDocs Document"),

    @SerialName("gdraw")
    GDOCS_DRAWING("GDocs Drawing"),

    @SerialName("gif")
    GIF("GIF"),

    @SerialName("go")
    GO("Go"),

    @SerialName("gpres")
    GDOCS_PRESENTATION("GDocs Presentation"),

    @SerialName("groovy")
    GROOVY("Groovy"),

    @SerialName("gsheet")
    GDOCS_SPREADSHEET("GDocs Spreadsheet"),

    @SerialName("gzip")
    GZIP("Gzip"),

    @SerialName("html")
    HTML("HTML"),

    @SerialName("handlebars")
    HANDLEBARS("Handlebars"),

    @SerialName("haskell")
    HASKELL("Haskell"),

    @SerialName("haxe")
    HAXE("Haxe"),

    @SerialName("indd")
    IN_DESIGN_DOCUMENT("InDesign Document"),

    @SerialName("java")
    JAVA("Java"),

    @SerialName("javascript")
    JAVASCRIPT("JavaScript"),

    @SerialName("jpg")
    JPEG("JPEG"),

    @SerialName("json")
    JSON("JSON"),

    @SerialName("keynote")
    KEYNOTE_DOCUMENT("Keynote Document"),

    @SerialName("kotlin")
    KOTLIN("Kotlin"),

    @SerialName("latex")
    LATEX("LaTeX/sTeX"),

    @SerialName("lisp")
    LISP("Lisp"),

    @SerialName("lua")
    LUA("Lua"),

    @SerialName("m4a")
    MPEG_4_AUDIO("MPEG 4 audio"),

    @SerialName("markdown")
    MARKDOWN("Markdown @SerialName(raw)"),

    @SerialName("matlab")
    MATLAB("MATLAB"),

    @SerialName("mhtml")
    MHTML("MHTML"),

    @SerialName("mkv")
    MATROSKA_VIDEO("Matroska video"),

    @SerialName("mov")
    QUICKTIME_VIDEO("QuickTime video"),

    @SerialName("mp3")
    MP3("mp4"),

    @SerialName("mp4")
    MPEG_4_VIDEO("MPEG 4 video"),

    @SerialName("mpg")
    MPEG_VIDEO("MPEG video"),

    @SerialName("mumps")
    MUMPS("MUMPS"),

    @SerialName("numbers")
    NUMBERS_DOCUMENT("Numbers Document"),

    @SerialName("nzb")
    NZB("NZB"),

    @SerialName("objc")
    OBJECTIVE_C("Objective-C"),

    @SerialName("ocaml")
    OCAML("OCaml"),

    @SerialName("odg")
    OPEN_DOCUMENT_DRAWING("OpenDocument Drawing"),

    @SerialName("odi")
    OPEN_DOCUMENT_IMAGE("OpenDocument Image"),

    @SerialName("odp")
    OPEN_DOCUMENT_PRESENTATION("OpenDocument Presentation"),

    @SerialName("ods")
    OPEN_DOCUMENT_SPREADSHEET("OpenDocument Spreadsheet"),

    @SerialName("odt")
    OPEN_DOCUMENT_TEXT("OpenDocument Text"),

    @SerialName("ogg")
    OGG_VORBIS("Ogg Vorbis"),

    @SerialName("ogv")
    OGG_VIDEO("Ogg video"),

    @SerialName("pages")
    PAGES_DOCUMENT("Pages Document"),

    @SerialName("pascal")
    PASCAL("Pascal"),

    @SerialName("pdf")
    PDF("PDF"),

    @SerialName("perl")
    PERL("Perl"),

    @SerialName("php")
    PHP("PHP"),

    @SerialName("pig")
    PIG("Pig"),

    @SerialName("png")
    PNG("PNG"),

    @SerialName("post")
    SLACK_POST("Slack Post"),

    @SerialName("powershell")
    POWERSHELL("PowerShell"),

    @SerialName("ppt")
    POWERPOINT_PRESENTATION("PowerPoint presentation"),

    @SerialName("pptx")
    POWERPOINT_PRESENTATION_EXTENDED("Extended PowerPoint presentation"),

    @SerialName("psd")
    PHOTOSHOP_DOCUMENT("Photoshop Document"),

    @SerialName("puppet")
    PUPPET("Puppet"),

    @SerialName("python")
    PYTHON("Python"),

    @SerialName("qtz")
    QUARTZ_COMPOSER_COMPOSITION("Quartz Composer Composition"),

    @SerialName("r")
    R("R"),

    @SerialName("rtf")
    RICH_TEXT_FILE("Rich Text File"),

    @SerialName("ruby")
    RUBY("Ruby"),

    @SerialName("rust")
    RUST("Rust"),

    @SerialName("sql")
    SQL("SQL"),

    @SerialName("sass")
    SASS("Sass"),

    @SerialName("scala")
    SCALA("Scala"),

    @SerialName("scheme")
    SCHEME("Scheme"),

    @SerialName("sketch")
    SKETCH_FILE("Sketch File"),

    @SerialName("shell")
    SHELL("Shell"),

    @SerialName("smalltalk")
    SMALLTALK("Smalltalk"),

    @SerialName("svg")
    SVG("SVG"),

    @SerialName("swf")
    FLASH_SWF("Flash SWF"),

    @SerialName("swift")
    SWIFT("Swift"),

    @SerialName("tar")
    TARBALL("Tarball"),

    @SerialName("tiff")
    TIFF("TIFF"),

    @SerialName("tsv")
    TSV("TSV"),

    @SerialName("vb")
    VB_DOT_NET("VB.NET"),

    @SerialName("vbscript")
    VBSCRIPT("VBScript"),

    @SerialName("vcard")
    VCARD("vCard"),

    @SerialName("velocity")
    VELOCITY("Velocity"),

    @SerialName("verilog")
    VERILOG("Verilog"),

    @SerialName("wav")
    WAVEFORM_AUDIO("Waveform audio"),

    @SerialName("webm")
    WEBM("WebM"),

    @SerialName("wmv")
    WINDOWS_MEDIA_VIDEO("Windows Media Video"),

    @SerialName("xls")
    EXCEL_SPREADSHEET("Excel spreadsheet"),

    @SerialName("xlsx")
    EXCEL_SPREADSHEET_EXTENDED("Extended Excel spreadsheet"),

    @SerialName("xlsb")
    EXCEL_SPREADSHEET_BINARY_MACRO_ENABLED("Excel Spreadsheet"),

    @SerialName("xlsm")
    EXCEL_SPREADSHEET_MACRO_ENABLED("Excel Spreadsheet"),

    @SerialName("xltx")
    EXCEL_TEMPLATE("Excel template"),

    @SerialName("xml")
    XML("XML"),

    @SerialName("yaml")
    YAML("YAML"),

    @SerialName("zip")
    ZIP("Zip")
}
