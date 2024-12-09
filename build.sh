#!/usr/bin/env bash

function main(){
	cd ./simple-rpg-character/; sh ./build.sh; cd ..
	cd ./simple-rpg-profession/; sh ./build.sh; cd ..
	cd ./simple-rpg-gateway/; sh ./build.sh; cd ..
	cd ./simple-rpg-ng/; sh ./build.sh; cd ..
}
main "$@"
