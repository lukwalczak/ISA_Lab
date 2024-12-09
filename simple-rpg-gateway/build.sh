#!/usr/bin/env bash

function main(){
  JAVA_HOME=/usr/lib/jvm/java-17 mvn clean verify
  title="simple-rpg-gateway"
  version="1.0.0"
  docker build -t "${title}:${version}" .
}

main "$@"