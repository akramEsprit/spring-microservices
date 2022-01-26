#!/bin/sh
echo "Waiting for upcoming Config Server"
while ! nc -z config 8888 ; do
    echo "Waiting for upcoming Config Server"
    sleep 2
done

java -jar /app/spring-app.jar