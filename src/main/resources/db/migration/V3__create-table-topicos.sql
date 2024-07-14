create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensagem varchar(300) not null unique,
    id_autor bigint not null,
    data_de_criacao timestamp not null,
    status varchar(100) not null,
    id_curso bigint not null,
    foreign key (id_curso) references cursos(id),
    foreign key (id_autor) references usuarios(id),
    primary key(id)
)