CREATE KEYSPACE tv-shows
WITH replication = {'class' : 'SimpleStrategy', 'replication_factor' : 3}
AND durable_writes = true;

use tv-shows;

CREATE TABLE series(
    id uuid,
    name text,
    description text,
    genre text,
    where_to_watch text,
    PRIMARY KEY (id)
);