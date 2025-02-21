[CMD]
sqlplus conn as sysdba;

[SQLPLUS]
create user jdbcboard identified jdbcboard;
create user jdbcboard identified by jdbcboard;
grant connect, resource to jdbcboard;

[TRIGGER]
CREATE OR REPLACE TRIGGER TRG_UPDATE_BACNT
AFTER INSERT ON ARTICLE
FOR EACH ROW 
BEGIN
	UPDATE BOARD SET BACNT = BACNT +1 WHERE BID=:NEW.BID
END;