create database db_animescut;
use db_animescut;

create table tb_user(
	id int primary key auto_increment,
    full_name varchar(60) not null,
    email varchar(80) not null,
    pass varchar(80) not null
);

create table tb_typesAnimes(
	id int primary key auto_increment,
	title varchar(50)
);

create table tb_animes(
	id int primary key auto_increment,
    title varchar(50) not null,
    link varchar(200) not null,
    release_year int,
	description_anime varchar(600),
    studio varchar(50),
    creator varchar(50)

);

create table tb_movies(
	id int primary key auto_increment,
    duration_min int
    
);

create table tb_series(
	id int primary key auto_increment,
    number_episodes int,
    number_seasons int
);

create table tb_avaliation(
	id int primary key auto_increment,
    status_avaliation varchar(500)
    /*Assistido*/
    /*Não assistido*/
    /*Assistido não gostei*/
);

create table tb_animes_has_avaliation(
 id int primary key auto_increment,
 id_animes int not null,
 id_user int not null,
 id_avaliation int not null
);

create table tb_favorites(
	id int primary key auto_increment
    
);

ALTER TABLE tb_animes ADD COLUMN id_typesAnimes INT;
ALTER TABLE tb_animes ADD CONSTRAINT fk_typesAnimes FOREIGN KEY(id_typesAnimes) REFERENCES tb_typesAnimes(id) ON DELETE CASCADE;

ALTER TABLE tb_movies ADD COLUMN id_animes INT;
ALTER TABLE tb_movies ADD CONSTRAINT fk_animes FOREIGN KEY(id_animes) REFERENCES tb_animes(id) ON DELETE CASCADE;

ALTER TABLE tb_series ADD COLUMN id_animes INT;
ALTER TABLE tb_series ADD CONSTRAINT fk_animes2 FOREIGN KEY(id_animes) REFERENCES tb_animes(id) ON DELETE CASCADE;


alter table tb_animes_has_avaliation add constraint fk_animes3 foreign key (id_animes) references tb_animes (id) on delete cascade;
alter table tb_animes_has_avaliation add constraint fk_user2 foreign key (id_user) references tb_user (id) on delete cascade;
alter table tb_animes_has_avaliation add constraint fk_avalitaion foreign key (id_avaliation) references tb_avaliation (id) on delete cascade;


ALTER TABLE tb_favorites ADD COLUMN id_user INT;
ALTER TABLE tb_favorites ADD CONSTRAINT fk_user3 FOREIGN KEY(id_user) REFERENCES tb_user(id) ON DELETE CASCADE;
ALTER TABLE tb_favorites ADD COLUMN id_animes INT;
ALTER TABLE tb_favorites ADD CONSTRAINT fk_animes4 FOREIGN KEY(id_animes) REFERENCES tb_animes(id) ON DELETE CASCADE;

/*drop database db_animescut;*/