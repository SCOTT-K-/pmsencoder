// move all of this to GitHub issues

/* add $mencoder_feature_level (bool) to stash based on MEncoder version */

/* XPath scraping? */

    scrape(
        uri:    uri, // default
        xpath:  '//foo/bar/@baz',
        regex:  'foo:(?<bar>bar):baz'
        format: 'html' // default if xpath is defined
    )

/*
    document the outstanding issue with e.g. "${URI}&has_verified" barfing:

        java.net.URISyntaxException: Illegal character in path at index 5: class java.net.URI&has_verified=1

    investigate using a custom GroovyShell without URI autoimported

*/

/*
    infinite loop/stack overflow in maven assembly plugin (in Plexus Archiver) with
    Groovy++ 0.2.26: https://groups.google.com/group/groovyplusplus/msg/a765fe77975650db
*/

// script management: disable/enable scripts through the Swing UI (cf. GreaseMonkey)

/*
    fix the sigil mess - the whole thing is a workaround for the URI property conflicting with the class
    groovysh has the same problem, but groovy script.groovy doesn't
    also: https://code.google.com/p/awsgroovyclouds/source/browse/trunk/AWSDrivers/src/com/groovyclouds/aws/S3Driver.groovy#897

        private static final def URI = "URI"
*/

/*
  investigate adding seek support for YouTube videos:

      http://stackoverflow.com/questions/3302384/youtubes-hd-video-streaming-server-technology
*/

// WEB.groovy (path is relative to the renderer's root folder):

videostream ('Web/TV') {
    uri  = 'mms://example.com/stream'
    name = 'Example'
    thumbnail = 'http://example.com/rss.jpg' // optional
}

// use the user-specified folder, rather than appending the feed name, so feeds can be merged:

videofeed ('Web/YouTube/Favourites') {
    uri = 'http://youtube.com/api/whatever?1-50'
}

videofeed ('Web/YouTube/Favourites') {
    uri = 'http://youtube.com/api/whatever?50-100'
}

/*

fix the design: http://groovy.codehaus.org/Replace+Inheritance+with+Delegation

Should be:

    Matcher receives an exchange (request/response) object. It creates a
    wrapper that holds methods and members common to Patterns and Actions:

        def exchange = new Exchange(this, request)

    For each Profile, Matcher instantiates a Pattern:

        def pattern = new Pattern(exchange)

    If the pattern matches, it then creates an Action:

        def action = new Action(exchange)

Read-only options could go in request and r/w objects in response e.g.

new Request(
    DOWNLOADER_OUT: ...,
    TRANSCODER_OUT: ...,
    URI: ...,
)

new Response(
    ARGS: ...,
    DOWNLOADER: ...
    TRANSCODER: ...
    URI: ...
)

matcher.run(request, response)

http://stackoverflow.com/questions/325346/name-for-http-requestresponse
http://stackoverflow.com/questions/1039513/what-is-a-request-response-pair-called

*/

// Fix the Script delegate so that globals can be shared e.g. (unix_paths_example.groovy):

script {
    PERL             = '/usr/bin/perl'
    PYTHON           = '/usr/bin/python'
    YOUTUBE_DL       = '/usr/bin/youtube-dl'
    GET_FLASH_VIDEOS = '/usr/bin/get-flash-videos'
}

// make $URI a URI rather than a String?

// tests for prepend and append

// migrate (some) regex scrapers to Geb (or Geb + regex)

// when documenting scripting, note poor man's script versioning via Github's "Switch Tags" menu

// a suite of scrapers and extractors:

    scrape:  regex
    browse:  Geb
    query:   Doj and/or port Zombie.js
    xpath:   HtmlUnit?

// use block syntax for scrape?

    scrape { 'foo/bar(?<baz>\\w+)' }
    scrape (uri: uri) { 'foo/bar(?<baz>\\w+)' }

// download/install standard library (GitHub API/JGit):

    pmsencoder.library.root = /tmp/pmsencoder/scripts
    pmsencoder.library.repository = http://example.com/path/to/scripts,http://...

// asynchronously downloads + installs scripts for this version of PMSEncoder and saves them to the specified
// (writable) location under the version

    /tmp/pmsencoder/scripts/1.3.0
    /tmp/pmsencoder/scripts/1.4.0

// Do this by default and eliminate the built-in DEFAULT.groovy?

// query youtube-dl and get-flash-videos for supported sites at startup?

// add (overridable) INIT.groovy (or DEFAULT.groovy) for one-off initializations (e.g. $DEFAULT_MENCODER_ARGS)

// print a debug version of the MEncoder (if used) command-line (i.e. pump up the debug level), target e.g.
// deleteme.tmp, and quote the URI (i.e. would need to be done in DEFAULT.groovy)

// add namespace support (required?):

    script (namespace: 'http://www.example.com', author: 'chocolateboy', version: 1.04) { ... }

// use a web interface because a) Swing sucks and b) headless servers. Only use swing to enable/disable the web server
// and set the port.

// investigate using busybox-w32/ash instead of cmd.exe on Windows

// Pattern: add extension matcher (use URI):

    extension 'm3u8'
    extension ([ 'mp4', 'm4v' ])

// profile: add $EXTENSION variable

// use URI for protocol parsing rather than a regex

/*

Groovy++ bytecode compilation error (both at compile-time and runtime): see Plugin.groovy

[ERROR] Failed to execute goal org.codehaus.gmaven:gmaven-plugin:1.3:compile (default) on project pmsencoder: startup failed:
[ERROR] /home/chocolateboy/dev/public/pmsencoder/src/main/groovy/com/chocolatey/pmsencoder/Plugin.groovy: 50: Internal Error: java.lang.VerifyError: (class: com/chocolatey/pmsencoder/Plugin, method: <init> signature: ()V) Register 3 contains wrong type
[ERROR] @ line 50, column 5.
[ERROR] public Plugin() {
[ERROR] ^
[ERROR] org.codehaus.groovy.syntax.SyntaxException: Internal Error: java.lang.VerifyError: (class: com/chocolatey/pmsencoder/Plugin, method: <init> signature: ()V) Register 3 contains wrong type
[ERROR] @ line 50, column 5.
[ERROR] at org.mbte.groovypp.compiler.CompilerTransformer.addError(CompilerTransformer.java:92)
[ERROR] at org.mbte.groovypp.compiler.StaticMethodBytecode.<init>(StaticMethodBytecode.java:84)
[ERROR] at org.mbte.groovypp.compiler.StaticMethodBytecode.replaceMethodCode(StaticMethodBytecode.java:98)
[ERROR] at org.mbte.groovypp.compiler.CompileASTTransform.visit(CompileASTTransform.java:108)
[ERROR] at org.codehaus.groovy.transform.ASTTransformationVisitor.visitClass(ASTTransformationVisitor.java:129)
[ERROR] at org.codehaus.groovy.transform.ASTTransformationVisitor$2.call(ASTTransformationVisitor.java:172)
[ERROR] at org.codehaus.groovy.control.CompilationUnit.applyToPrimaryClassNodes(CompilationUnit.java:936)
[ERROR] at org.codehaus.groovy.control.CompilationUnit.doPhaseOperation(CompilationUnit.java:513)
[ERROR] at org.codehaus.groovy.control.CompilationUnit.processPhaseOperations(CompilationUnit.java:491)
[ERROR] at org.codehaus.groovy.control.CompilationUnit.compile(CompilationUnit.java:468)
[ERROR] at org.codehaus.groovy.control.CompilationUnit.compile(CompilationUnit.java:447)

*/

/*
    script loading order:

        builtin scripts
        user scripts

    script stages:

        begin
        init
        script
        check
        end

document this:

    replacing a profile with a profile with a different name
    does not change its canonical name. this ensures other replacement profiles
    have a predictable, consistent name to refer to

TODO: determine behaviour (if any) if a replacement has a different stage

TODO: re-stage all the profiles in a script block, preserving the natural order

keep a list of Script objects rather than (just) a hash of profiles?

*/

// remove rtmpdump protocol and manage everything through pmsencoder://

// PMS.setValue('com.chocolatey.pmsencoder.Matcher', Matcher)

// cleaner Gradle-style names (no sigils!):

class MyTranscoder extends Transcoder {
    List<String> toCommandLine() {

    }
}

profile('Foo') {
    pattern {
        match { uri == 'http://whatever' } // TODO: make uri an actual URI rather than a string
    }

    action {
        // default
        transcoder = new FFmpeg() // assigns default args
        transcoder.args = "string -or -list"
        transcoder.output = "string -or -list" // ffmpeg only: output options

        // add a downloader
        def mplayer = new MPlayer(uri)
        mplayer.args = [ 'string', '-or', '-list' ]
        mplayer.args.set([ '-foo': 'bar' ])
        transcoder.downloader = mplayer
    }
}

// No need to expose $PMS. Just use PMS.get() as normal

// store the original URI: e.g. for mplayer.groovy

if (originalUri.protocol == 'concat') { ... }

// bring back reject: e.g. for mplayer.groovy:

reject $URI: '^concat:'

// add a commit method which stops all further profile matching for this request

/*

    image to video:

        ffmpeg -r 24 -i http://ip:port/plugin/name/imdb_plot?id=42&fmt=png \
            -vcodec mpeg2video -qscale 2 -vframes 1 transcoder.out

*/

/*

Players:

    MEncoder
    FFmpeg

Downloaders:

    SopCast
    MPlayer
    GetFlashVideos
    YoutubeDL
*/

// Ruby-style initialization blocks?

profile ('Whatever') {
    transcoder = new FFmpegTranscoder() {
        downloader = new CustomDownloader() {
            executable = '/path/to/mydownloader'
            args = "-referrer $referrer -o $downloaderOut -i $uri"
        }
    }
    hook = "foo bar baz"
}

// add a navix:// protocol e.g. navix://default?referrer=url_encoded_uri&url=...

// need to be more precise/verbose with the names e.g. MPlayer could be used as a "null"/identity transcoder
// (-oac copy -ovc copy):

transcoder = new NullTranscoder()

// need to pass in the renderer

// test Pattern.scrape

/// FIXME: MPlayer can't dump to stdout: http://lists.mplayerhq.hu/pipermail/mplayer-users/2006-April/059898.html

// need better vlc detection

// make the rtmp2pms functionality available via a web page (e.g. GitHub page) using JavaScript:
// i.e. enter 1) name/path 2) the command line 3) optional thumbnail URI and click to generate the WEB.conf
// line

// Env.js + jQuery + Rhino:

/*
    var stage = new Stage('script');
    var profile = new Profile('Foo');
    stage.addProfile(profile);

    profile.pattern = function() {
        if (url.match(/^http:\/\/www.whatever.com/) {
            return true;
        }
        return false
    };

    profile.action = ...
*/

// spock-esque?

    pattern:

        if (uri.whatever()) {
            return true;
        } else {
            return false;
        }

    action:

        uri = $(...)

// propertyMissing + methodMissing?

    uri = query { $(...).foo().bar().baz() }

// complement (asynchronous) $HOOK with $BEFORE and $AFTER. $AFTER attaches a dummy process started by stopProcess()

    script {
        // .js files use common.js exports object to export jsPattern and jsAction
        // e.g. exports['jsPattern'] = function(uri) { ... };
        // methods looked up in map via methodMissing?
        jsLoadResource('jspattern.js')
        jsLoadFile('jsaction.js')

        pattern {
            match { jsPattern(uri) }
        }

        action {
            transcoder = jsAction(uri)
        }
    }

// allow it to be demoted: only place it first if it's not already in the engine list

// get-flash-videos and youtube-dl: query them to see if they support the URI
// if they do and the resolved domain matches the source domain, cache the domain and match on that

// builtins shouldn't work if a downloader matches
// soluton: commit method to abort further matches? (but what about the mms correction?)
