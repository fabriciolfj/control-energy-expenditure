create table gastos (
    id              bigserial      primary key not null,
    nome_pessoa     varchar(255)   not null,
    descricao       varchar(255)   not null,
    valor           numeric(15,4)   not null,
    data_hora       timestamp     not null,
    tag             varchar(30)     not null,
);
