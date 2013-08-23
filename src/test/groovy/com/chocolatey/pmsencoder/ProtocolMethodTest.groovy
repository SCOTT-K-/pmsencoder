package com.chocolatey.pmsencoder

@groovy.transform.CompileStatic
class ProtocolMethodTest extends PMSEncoderTestCase {
    void setUp() {
        super.setUp()
        def script = this.getClass().getResource('/protocol_method.groovy')
        matcher.load(script)
    }

    void testProtocolString() {
        assertMatch([
            uri: 'file://www.example.com',
            wantMatches: [ 'Protocol String' ]
        ])
    }

    void testProtocolList() {
        assertMatch([
            uri: 'rtmp://www.example.com',
            wantMatches: [ 'Protocol List' ]
        ])
    }

    void testProtocolNoMatch() {
        assertMatch([
            uri: 'http://www.example.com',
            wantMatches: []
        ])
    }
}
