#!/usr/bin/env groovy
import org.apache.commons.lang3.StringUtils
import groovy.io.FileType.FILES

def call(String workspace, String versionFileName = "VERSION") {
    File versionFile = new File(workspace, versionFileName)
    String version = versionFile.text

    def list = []

    def dir = new File(workspace)
    dir.eachFileRecurse (FileType.FILES) { file ->
        list << file
    }

    list.each {
        println it.path
    }

    def parser = /(?<major>\d+).(?<minor>\d+).(?<patch>\d+)/
    def match = version =~ parser
    if (match.matches()) {
        return version
    } else {
        throw new Exception("The version string does not conform to Semantic Versioning!")
    }

}