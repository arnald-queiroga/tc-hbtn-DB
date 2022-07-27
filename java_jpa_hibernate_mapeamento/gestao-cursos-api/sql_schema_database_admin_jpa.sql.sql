-- TABLE
CREATE TABLE tb_aluno (id  integer, email varchar(255), matricula varchar(255), nascimento datetime, nomeCompleto varchar(255), primary key (id));
CREATE TABLE tb_aluno_curso (aluno_id bigint not null, curso_id bigint not null, primary key (aluno_id, curso_id));
CREATE TABLE tb_curso (id  integer, url varchar(255), nome varchar(255), sigla varchar(255), materialCurso_id bigint, tb_materialCurso bigint, primary key (id));
CREATE TABLE tb_endereco (id  integer, bairro varchar(255), cep integer, cidade varchar(255), endereco varchar(255), estado varchar(255), logradouro varchar(255), numero varchar(255), aluno_id bigint, endereco_id bigint, primary key (id));
CREATE TABLE tb_professor (id  integer, email varchar(255), matricula varchar(255), nomeCompleto varchar(255), primary key (id));
CREATE TABLE tb_professor_tb_curso (Professor_id bigint not null, cursos_id bigint not null, primary key (Professor_id, cursos_id), unique (cursos_id));
CREATE TABLE tb_telefone (id  integer, DDD varchar(255), numero varchar(255), aluno_id bigint, telefone_id bigint, primary key (id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
