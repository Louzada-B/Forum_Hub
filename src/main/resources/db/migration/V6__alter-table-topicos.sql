ALTER TABLE topicos MODIFY titulo varchar(100);
ALTER TABLE topicos MODIFY mensagem varchar(300);
ALTER TABLE topicos add ativo tinyint not null;