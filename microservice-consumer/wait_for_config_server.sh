#!/bin/sh
echo "Waiting for upcoming Config Server"
while ! nc -z config 8888 ; do
    echo "Waiting for upcoming Config Server"
    sleep 2
done

java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9678 -jar /app/spring-app.jar 