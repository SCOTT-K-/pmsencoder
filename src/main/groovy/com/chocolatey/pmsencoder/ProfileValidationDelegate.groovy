package com.chocolatey.pmsencoder

import groovy.transform.CompileStatic

@CompileStatic
class ProfileValidationDelegate {
    public Closure patternBlock
    public Closure actionBlock
    public String name

    ProfileValidationDelegate(String name) {
        this.name = name
    }

    // DSL method
    private void action(Closure closure) throws PMSEncoderException {
        if (this.actionBlock == null) {
            this.actionBlock = closure
        } else {
            throw new PMSEncoderException("invalid profile ($name): multiple action blocks defined")
        }
    }

    // DSL method
    private void pattern(Closure closure) throws PMSEncoderException {
        if (this.patternBlock == null) {
            this.patternBlock = closure
        } else {
            throw new PMSEncoderException("invalid profile ($name): multiple pattern blocks defined")
        }
    }

    public void runProfileBlock(@DelegatesTo(ProfileValidationDelegate) Closure closure) {
        closure.delegate = this
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure()
        // the pattern block is optional; if not supplied, the profile always matches
        // the action block is optional; if not supplied no action is performed
    }
}
