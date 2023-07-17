/*TYPES ANIMES----------------*/
insert into tb_typesAnimes(tipos) values ('Shounen');
insert into tb_typesAnimes(tipos) values ('Shoujo');
insert into tb_typesAnimes(tipos) values ('Seinen');
insert into tb_typesAnimes(tipos) values ('Josei');
insert into tb_typesAnimes(tipos) values ('Isekai');
insert into tb_typesAnimes(tipos) values ('Gore');
insert into tb_typesAnimes(tipos) values ('Slice of Life');

/*ANIMES -----------------*/
/*series*/
insert into tb_animes(title, link, release_year, description_anime, studio, creator, id_typesAnimes) values ('BOKU NO HERO', 'https://www.youtube.com/watch?v=L1FdEBTJXus', 2016, 'um anime de humanos mutantes que estudam em uma escola de heróis', 'Bones', 'Kōhei Horikoshi', 1);
insert into tb_animes(title, link, release_year, description_anime, studio, creator, id_typesAnimes) values ('Viland Saga', 'https://www.youtube.com/watch?v=f8JrZ7Q_p-8', 2019, 'anime de época que se passa na ocupação nórdica na Grã-Bretanha durante a Idade Média', 'Mappa', 'Makoto Yukimura', 3);
/*filmes*/
insert into tb_animes(title, link, release_year, description_anime, studio, creator, id_typesAnimes) values ('A Viagem de Chihiro', 'https://www.youtube.com/watch?v=ByXuk9QqQkk', 2003, 'uma garota entra em um mundo mágico desconhecido onde precisa lutar pela sua sobrevivência e resgatar seus pais das garras do vilão', 'Studio Ghibli', 'Hayao Miyazaki', 5);

/*SERIES -------------*/
insert into tb_series(number_episodes, number_seasons, id_animes) values(138, 6, 1);
insert into tb_series(number_episodes, number_seasons, id_animes) values(48, 2, 3);

/*MOVIES-----------*/
insert into tb_movies(duration_min, id_animes) values(420, 2);

select * from tb_movies;
select * from tb_series;
select * from tb_typesAnimes;