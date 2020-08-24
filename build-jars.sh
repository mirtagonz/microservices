#!/bin/bash
PROJECTS=" golden arquimedes gandalf knowsmore kangaroo"
WORKING_DIR=$PWD
for PRO in $PROJECTS; do
	cd $PRO
	echo "Building $PRO"
	sleep 1
	mvn -DskipTests clean install
	cd $WORKING_DIR
done

