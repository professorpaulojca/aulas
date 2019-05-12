--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

-- Started on 2018-09-03 10:30:26

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12387)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2161 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 16394)
-- Name: historico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE historico (
    idpedido integer NOT NULL,
    data date,
    situacao integer,
    observacao character varying(200),
    hora time without time zone
);


ALTER TABLE historico OWNER TO postgres;

--
-- TOC entry 2162 (class 0 OID 0)
-- Dependencies: 185
-- Name: TABLE historico; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE historico IS 'data, hora, situacao, observacao';


--
-- TOC entry 189 (class 1259 OID 16410)
-- Name: item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE item (
    id integer NOT NULL,
    idpedido integer,
    idproduto integer,
    quantidade integer,
    precounitario double precision
);


ALTER TABLE item OWNER TO postgres;

--
-- TOC entry 2163 (class 0 OID 0)
-- Dependencies: 189
-- Name: TABLE item; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE item IS 'item.id,item.idproduto,item.quantidade,item.precounitario';


--
-- TOC entry 188 (class 1259 OID 16408)
-- Name: item_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE item_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE item_id_seq OWNER TO postgres;

--
-- TOC entry 2164 (class 0 OID 0)
-- Dependencies: 188
-- Name: item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE item_id_seq OWNED BY item.id;


--
-- TOC entry 186 (class 1259 OID 16397)
-- Name: movimento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE movimento (
    data date,
    hora time without time zone,
    idtipo integer,
    referencia character varying(50),
    idproduto integer,
    quantidade integer
);


ALTER TABLE movimento OWNER TO postgres;

--
-- TOC entry 2165 (class 0 OID 0)
-- Dependencies: 186
-- Name: TABLE movimento; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE movimento IS 'data, hora, idtipo, referencia, idproduto, quantidade';


--
-- TOC entry 191 (class 1259 OID 16418)
-- Name: pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE pedido (
    id integer NOT NULL,
    data date,
    hora time without time zone
);


ALTER TABLE pedido OWNER TO postgres;

--
-- TOC entry 2166 (class 0 OID 0)
-- Dependencies: 191
-- Name: TABLE pedido; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE pedido IS 'pedido.id,pedido.data,pedido.hora';


--
-- TOC entry 190 (class 1259 OID 16416)
-- Name: pedido_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pedido_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE pedido_id_seq OWNER TO postgres;

--
-- TOC entry 2167 (class 0 OID 0)
-- Dependencies: 190
-- Name: pedido_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pedido_id_seq OWNED BY pedido.id;


--
-- TOC entry 187 (class 1259 OID 16402)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE produto (
    nome character varying(30),
    foto character varying(100),
    quantidade integer,
    preco double precision,
    id integer NOT NULL
);


ALTER TABLE produto OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 16424)
-- Name: produto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE produto_id_seq OWNER TO postgres;

--
-- TOC entry 2168 (class 0 OID 0)
-- Dependencies: 192
-- Name: produto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE produto_id_seq OWNED BY produto.id;


--
-- TOC entry 2022 (class 2604 OID 16413)
-- Name: item id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item ALTER COLUMN id SET DEFAULT nextval('item_id_seq'::regclass);


--
-- TOC entry 2023 (class 2604 OID 16421)
-- Name: pedido id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido ALTER COLUMN id SET DEFAULT nextval('pedido_id_seq'::regclass);


--
-- TOC entry 2021 (class 2604 OID 16426)
-- Name: produto id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY produto ALTER COLUMN id SET DEFAULT nextval('produto_id_seq'::regclass);


--
-- TOC entry 2147 (class 0 OID 16394)
-- Dependencies: 185
-- Data for Name: historico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY historico (idpedido, data, situacao, observacao, hora) FROM stdin;
1	2018-09-03	3	Pedido entregue parcialmente.	\N
\.


--
-- TOC entry 2151 (class 0 OID 16410)
-- Dependencies: 189
-- Data for Name: item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY item (id, idpedido, idproduto, quantidade, precounitario) FROM stdin;
2	1	2	2	25.5
1	1	1	1	1200
\.


--
-- TOC entry 2169 (class 0 OID 0)
-- Dependencies: 188
-- Name: item_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('item_id_seq', 2, true);


--
-- TOC entry 2148 (class 0 OID 16397)
-- Dependencies: 186
-- Data for Name: movimento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY movimento (data, hora, idtipo, referencia, idproduto, quantidade) FROM stdin;
2018-09-03	09:33:26	2	Pedido número 1	2	2
2018-09-03	10:17:08	2	Pedido número 1	1	1
2018-09-03	10:21:32	2	Pedido número 1	2	2
2018-09-03	10:22:23	2	Pedido número 1	2	2
2018-09-03	10:27:22	2	Pedido número 1	1	1
\.


--
-- TOC entry 2153 (class 0 OID 16418)
-- Dependencies: 191
-- Data for Name: pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pedido (id, data, hora) FROM stdin;
1	2018-03-09	09:22:00
\.


--
-- TOC entry 2170 (class 0 OID 0)
-- Dependencies: 190
-- Name: pedido_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pedido_id_seq', 1, true);


--
-- TOC entry 2149 (class 0 OID 16402)
-- Dependencies: 187
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY produto (nome, foto, quantidade, preco, id) FROM stdin;
Mouse Genérico	img2.jpg	94	25.5	2
TV 32" Smart LG	img1.jpg	18	1200	1
\.


--
-- TOC entry 2171 (class 0 OID 0)
-- Dependencies: 192
-- Name: produto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('produto_id_seq', 2, true);


--
-- TOC entry 2027 (class 2606 OID 16415)
-- Name: item item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY item
    ADD CONSTRAINT item_pkey PRIMARY KEY (id);


--
-- TOC entry 2029 (class 2606 OID 16423)
-- Name: pedido pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (id);


--
-- TOC entry 2025 (class 2606 OID 16431)
-- Name: produto produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id);


-- Completed on 2018-09-03 10:30:28

--
-- PostgreSQL database dump complete
--

