CREATE TABLE users
(
  id serial NOT NULL,
  first_name character varying,
  last_name character varying,
  birthday character varying,
  address character varying,
  address_complement character varying,
  district character varying,
  telephone character varying,
  mobile_phone character varying,
  rg character varying,
  cpf character varying,
  state character varying,
  city character varying,
  postcode character varying,
  CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO postgres;



insert into users(first_name, last_name, birthday,  address, address_complement, district, telephone, mobile_phone, rg, cpf, state, city, postcode) values('David', 'Melo', '1988-04-11T03:00:00.000Z', 'Rua Ministro', 'Apt 601', 'Guararapes', '8531236431', '85991728463', '62341674412312', '52214641231', 'CE', 'Fortaleza', '60810010');
insert into users(first_name, last_name, birthday,  address, address_complement, district, telephone, mobile_phone, rg, cpf, state, city, postcode) values('Leonardo', 'Brito', '1987-09-09T03:00:00.000Z', 'Rua Eduardo', '', 'Meireles', '853264214', '85995317654', '62341674412312', '52214641231', 'CE', 'Fortaleza', '60810010');
insert into users(first_name, last_name, birthday,  address, address_complement, district, telephone, mobile_phone, rg, cpf, state, city, postcode) values('Mário', 'Soares', '1987-12-13T03:00:00.000Z', 'Rua Ellery', 'Apt 1302', 'Aerolandia', '8532134421', '85991236875', '62341674412312', '52214641231', 'CE', 'Fortaleza', '60810010');
insert into users(first_name, last_name, birthday,  address, address_complement, district, telephone, mobile_phone, rg, cpf, state, city, postcode) values('Sérgio', 'Teófilo', '1987-12-13T03:00:00.000Z', 'Rua Ministro Ellery', '', 'Jardim Secreto', '8532735216', '85991236864', '62341674412312', '52214641231', 'CE', 'Fortaleza', '60810010');
insert into users(first_name, last_name, birthday,  address, address_complement, district, telephone, mobile_phone, rg, cpf, state, city, postcode) values('Juan', 'Pinheiro', '1987-04-11T03:00:00.000Z', 'Rua Eduardo Ellery', '', 'Vila Sátiro', '8532841246', '85991357367', '62341674412312', '52214641231', 'CE', 'Fortaleza', '60810010');
insert into users(first_name, last_name, birthday,  address, address_complement, district, telephone, mobile_phone, rg, cpf, state, city, postcode) values('Priscila', 'Almeida', '1989-09-28T03:00:00.000Z', 'Rua Ministro Eduard', '', 'Bom Jardim', '8532135753', '85998741235', '62341674412312', '52214641231', 'CE', 'Fortaleza', '60810010');
insert into users(first_name, last_name, birthday,  address, address_complement, district, telephone, mobile_phone, rg, cpf, state, city, postcode) values('Wania', 'Melo', '1960-04-11T03:00:00.000Z', 'Avenida Bezerra de Menezes', 'Apt 01', 'Parquelândia', '85321234843', '85991236975', '62341674412312', '52214641231', 'CE', 'Fortaleza', '60810010');
insert into users(first_name, last_name, birthday,  address, address_complement, district, telephone, mobile_phone, rg, cpf, state, city, postcode) values('Carlos', 'Augusto', '1955-04-11T03:00:00.000Z', 'Avenida Washington Soares', '', 'Água Fria', '8532123155', '85991235775', '62341674412312', '52214641231', 'CE', 'Fortaleza', '60810010');
insert into users(first_name, last_name, birthday,  address, address_complement, district, telephone, mobile_phone, rg, cpf, state, city, postcode) values('Michelle', 'Melo', '1983-08-24T03:00:00.000Z', 'Avenida Meireles', '', 'Messejana', '8532174246', '85991376423', '62341674412312', '52214641231', 'CE', 'Fortaleza', '60810010');
insert into users(first_name, last_name, birthday,  address, address_complement, district, telephone, mobile_phone, rg, cpf, state, city, postcode) values('Tiago', 'Chaves', '1986-12-10T03:00:00.000Z', 'Rua Suécia', 'Apt 1301', 'Conjunto', '8532864123', '85996532986', '62341674412312', '52214641231', 'CE', 'Fortaleza', '60810010');