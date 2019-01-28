FROM hub.daicy.net/cmi/openjdk:8u171-jre-slim-stretch

MAINTAINER lge@daicy.net

ENV START_SCRIPT /root/run.sh

ADD ./target/military-0.0.1-SNAPSHOT.jar /opt/military-0.0.1-SNAPSHOT.jar
ADD run.sh $START_SCRIPT
RUN chmod +x $START_SCRIPT
EXPOSE 8088
CMD ./$START_SCRIPT

