FROM amazoncorretto:21
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:9091
COPY server/target/*.jar stats.jar
ENTRYPOINT ["java","-jar","/stats.jar"]