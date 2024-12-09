#!/usr/bin/env bash

function main(){
  npm install
  npm run build
  title="simple-rpg-ng"
  version="1.0.0"
  docker build -t "${title}:${version}" .
}

main "$@"
