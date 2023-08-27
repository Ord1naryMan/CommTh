-- docker exec -it commth-cassandra-1 bash -c "cqlsh -u cassandra -p cassandra"

CREATE KEYSPACE spring_cassandra WITH replication = {'class' : 'SimpleStrategy', 'replication_factor' : 1};
create table spring_cassandra.message_content(id UUID PRIMARY KEY, message_content text);