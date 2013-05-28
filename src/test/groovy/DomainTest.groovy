package com.chocolatey.pmsencoder

@groovy.transform.CompileStatic
class DomainTest extends PMSEncoderTestCase {
    void setUp() {
        super.setUp()
        def script = this.getClass().getResource('/domain.groovy')
        matcher.load(script)
    }

    void testDomainString() {
        assertMatch([
            // XXX squashed bug: previously only http(s) were matched by domain(...)
            uri: 'mms://www.domain-string.com',
            wantMatches: [ 'Domain String' ]
        ])
    }

    void testDomainList() {
        assertMatch([
            uri: 'http://www.domain-list.com',
            wantMatches: [ 'Domain List' ]
        ])
    }

    void testDomainsString() {
        assertMatch([
            uri: 'http://www.domains-string.com',
            wantMatches: [ 'Domains String' ]
        ])
    }

    void testDomainsList() {
        assertMatch([
            uri: 'http://www.domains-list.com',
            wantMatches: [ 'Domains List' ]
        ])
    }

    void testGotDot() {
        assertMatch([
            uri: 'http://www.dot.com',
            wantMatches: [ 'Got Dot' ]
        ])
    }

    void testNotDot() {
        assertMatch([
            uri: 'http://www.dotacom',
            wantMatches: []
        ])
    }
}
