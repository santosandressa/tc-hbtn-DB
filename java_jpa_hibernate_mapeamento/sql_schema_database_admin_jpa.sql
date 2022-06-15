-- TABLE
CREATE TABLE Aluno (id  integer, email_aluno varchar(255), numero_matricula varchar(255), data_nascimento date, nome_aluno varchar(255), primary key (id));
CREATE TABLE Curso (id  integer, nome_curso varchar(255), sigla_curso varchar(255), materialCurso_id bigint not null, professor_id bigint not null, primary key (id), unique (materialCurso_id));
CREATE TABLE curso_aluno (curso_id bigint not null, aluno_id bigint not null);
CREATE TABLE Endereco (id  integer, cep integer, cidade varchar(255), endereco varchar(255), estado varchar(255), logradouro varchar(255), numero varchar(255), aluno_id bigint, primary key (id));
CREATE TABLE MaterialCurso (id  integer, url_material varchar(255), primary key (id));
CREATE TABLE Professor (id  integer, email_professor varchar(255), numero_matricula varchar(255), nome_professor varchar(255), primary key (id));
CREATE TABLE Telefone (id  integer, DDD varchar(255), numero varchar(255), aluno_id bigint, primary key (id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
