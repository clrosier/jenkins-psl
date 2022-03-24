#!/usr/bin/env groovy
import org.apache.commons.lang3.StringUtils

def call(String gitBranch, String version) {

    if (gitBranch == "main") {
        return version
    }

    gitBranch = StringUtils.stripAccents(gitBranch);
    gitBranch = gitBranch.replace(" ", "_");
    gitBranch = gitBranch.replaceAll("[^\\.A-Za-z0-0_]", "-");

    return gitBranch + "_" + version
}