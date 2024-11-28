#!/bin/bash

# groupId is the package name
# artifactId is the project name
mvn archetype:generate -DgroupId=$1 -DartifactId=$2
