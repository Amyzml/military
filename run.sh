#!/bin/sh

JAVA_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap"
java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.config.location=/opt/config/application.properties -jar /opt/military-0.0.1-SNAPSHOT.jar

