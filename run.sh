#!/usr/bin/env bash
mvn package assembly:single

echo "Starting server..."
java -cp target/bank_api-1.0-SNAPSHOT-jar-with-dependencies.jar Main