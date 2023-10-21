#!/bin/bash

snap=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
echo RELEASE_VERSION=$(echo "${snap//-SNAPSHOT/}") >> $GITHUB_ENV