FROM mysql
WORKDIR /tmp
COPY test_db/*.sql /tmp/

COPY test_db/world.sql /docker-entrypoint-initdb.d
ENV MYSQL_ROOT_PASSWORD example