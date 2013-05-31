// work around incomplete HTTP support (for e.g. HTTP 301) in older ffmpeg builds
init {
    profile ('Chase Redirects', stopOnMatch: false) {
        pattern {
            domain([ 'rss.feedsportal.com', 'feedproxy.google.com', 'theonion.com' ])
        }

        action {
            uri = http.target(uri) ?: uri
        }
    }
}
