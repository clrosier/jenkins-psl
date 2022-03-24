#!/usr/bin/env groovy
import org.apache.commons.lang3.StringUtils

def call(String versionFilePath = "VERSION") {
    File versionFile = new File(versionFilePath)
    String version = versionFile.text
    
    def parser = /(?<major>\d+).(?<minor>\d+).(?<patch>\d+)/
    def match = version =~ parser
    if (match.matches()) {
        return version
    } else {
        throw new Exception("The version string does not conform to Semantic Versioning!")
    }

}