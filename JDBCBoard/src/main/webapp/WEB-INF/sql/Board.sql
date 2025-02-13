[CMD]
sqlplus conn as sysdba;

[SQLPLUS]
create user jdbcboard identified jdbcboard;
create user jdbcboard identified by jdbcboard;
grant connect, resource to jdbcboard;