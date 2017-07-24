FROM jecklgamis/oracle-java-runtime:latest
MAINTAINER Jerrico Gamis <jecklgamis@gmail.com>

RUN apt-get update -y && apt-get install -y supervisor
RUN groupadd -r app && useradd -r -gapp app
RUN mkdir -m 0755 -p /usr/local/app/bin
RUN mkdir -m 0755 -p /usr/local/app/config
RUN mkdir -m 0755 -p /usr/local/app/logs/

COPY target/springboot-scala-example.jar /usr/local/app/bin
COPY run-app.sh /usr/local/app/bin

COPY app-supervisor.conf /etc/supervisor/conf.d

RUN chown -R app:app /usr/local/app
RUN chmod +x /usr/local/app/bin/run-app.sh

EXPOSE 8080

#CMD ["/usr/bin/supervisord"]
CMD ["/usr/local/app/bin/run-app.sh"]

