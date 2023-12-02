FROM jboss/wildfly:latest

COPY . /opt/jboss/wildfly/standalone/deployments/

USER jboss

EXPOSE 8080

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
