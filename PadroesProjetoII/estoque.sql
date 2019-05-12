--
-- PostgreSQL database dump
--

-- Dumped from database version 10.4
-- Dumped by pg_dump version 10.4

-- Started on 2018-08-31 23:22:58

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2853 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 16468)
-- Name: historico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.historico (
    idpedido integer NOT NULL,
    data date,
    hora time without time zone,
    situacao integer,
    observacao character varying(200)
);


ALTER TABLE public.historico OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16473)
-- Name: item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.item (
    id integer NOT NULL,
    idpedido integer,
    idproduto integer,
    quantidade double precision,
    precounitario double precision
);


ALTER TABLE public.item OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16471)
-- Name: item_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.item_id_seq OWNER TO postgres;

--
-- TOC entry 2854 (class 0 OID 0)
-- Dependencies: 197
-- Name: item_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.item_id_seq OWNED BY public.item.id;


--
-- TOC entry 200 (class 1259 OID 16481)
-- Name: movimento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movimento (
    id integer NOT NULL,
    data date,
    hora time with time zone,
    idtipo integer,
    referencia character varying(50),
    idproduto integer,
    quantidade integer
);


ALTER TABLE public.movimento OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16479)
-- Name: movimento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.movimento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.movimento_id_seq OWNER TO postgres;

--
-- TOC entry 2855 (class 0 OID 0)
-- Dependencies: 199
-- Name: movimento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.movimento_id_seq OWNED BY public.movimento.id;


--
-- TOC entry 206 (class 1259 OID 16505)
-- Name: pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido (
    id integer NOT NULL,
    data date,
    hora time without time zone
);


ALTER TABLE public.pedido OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16503)
-- Name: pedido_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pedido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pedido_id_seq OWNER TO postgres;

--
-- TOC entry 2856 (class 0 OID 0)
-- Dependencies: 205
-- Name: pedido_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pedido_id_seq OWNED BY public.pedido.id;


--
-- TOC entry 204 (class 1259 OID 16497)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produto (
    id integer NOT NULL,
    nome character varying(30),
    foto character varying(50),
    quantidade integer,
    precounitario double precision
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16495)
-- Name: produto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.produto_id_seq OWNER TO postgres;

--
-- TOC entry 2857 (class 0 OID 0)
-- Dependencies: 203
-- Name: produto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produto_id_seq OWNED BY public.produto.id;


--
-- TOC entry 201 (class 1259 OID 16485)
-- Name: situacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.situacao (
    id integer NOT NULL,
    descricao character varying(30)
);


ALTER TABLE public.situacao OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16490)
-- Name: tipodemovimento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipodemovimento (
    id integer NOT NULL,
    descricao character varying(30)
);


ALTER TABLE public.tipodemovimento OWNER TO postgres;

--
-- TOC entry 2700 (class 2604 OID 16476)
-- Name: item id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item ALTER COLUMN id SET DEFAULT nextval('public.item_id_seq'::regclass);


--
-- TOC entry 2701 (class 2604 OID 16484)
-- Name: movimento id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimento ALTER COLUMN id SET DEFAULT nextval('public.movimento_id_seq'::regclass);


--
-- TOC entry 2703 (class 2604 OID 16508)
-- Name: pedido id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido ALTER COLUMN id SET DEFAULT nextval('public.pedido_id_seq'::regclass);


--
-- TOC entry 2702 (class 2604 OID 16500)
-- Name: produto id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto ALTER COLUMN id SET DEFAULT nextval('public.produto_id_seq'::regclass);


--
-- TOC entry 2835 (class 0 OID 16468)
-- Dependencies: 196
-- Data for Name: historico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.historico (idpedido, data, hora, situacao, observacao) FROM stdin;
1	2018-08-31	05:02:57	3	Pedido entregue parcialmente.
1	2018-08-31	10:50:59	3	Pedido entregue parcialmente.
\.


--
-- TOC entry 2837 (class 0 OID 16473)
-- Dependencies: 198
-- Data for Name: item; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.item (id, idpedido, idproduto, quantidade, precounitario) FROM stdin;
1	1	1	2	2000.01
\.


--
-- TOC entry 2839 (class 0 OID 16481)
-- Dependencies: 200
-- Data for Name: movimento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movimento (id, data, hora, idtipo, referencia, idproduto, quantidade) FROM stdin;
1	2018-08-31	05:02:57-03	2	Pedido número 1	1	2
2	2018-08-31	10:50:59-03	2	Pedido número 1	1	2
\.


--
-- TOC entry 2845 (class 0 OID 16505)
-- Dependencies: 206
-- Data for Name: pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedido (id, data, hora) FROM stdin;
1	2018-09-18	12:00:00
\.


--
-- TOC entry 2843 (class 0 OID 16497)
-- Dependencies: 204
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produto (id, nome, foto, quantidade, precounitario) FROM stdin;
2	Radio AM FM	radio001.png	20	200
1	TV Smart 32	tv001.png	96	2000
\.


--
-- TOC entry 2840 (class 0 OID 16485)
-- Dependencies: 201
-- Data for Name: situacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.situacao (id, descricao) FROM stdin;
\.


--
-- TOC entry 2841 (class 0 OID 16490)
-- Dependencies: 202
-- Data for Name: tipodemovimento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipodemovimento (id, descricao) FROM stdin;
\.


--
-- TOC entry 2858 (class 0 OID 0)
-- Dependencies: 197
-- Name: item_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.item_id_seq', 1, true);


--
-- TOC entry 2859 (class 0 OID 0)
-- Dependencies: 199
-- Name: movimento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.movimento_id_seq', 2, true);


--
-- TOC entry 2860 (class 0 OID 0)
-- Dependencies: 205
-- Name: pedido_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pedido_id_seq', 1, true);


--
-- TOC entry 2861 (class 0 OID 0)
-- Dependencies: 203
-- Name: produto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produto_id_seq', 2, true);


--
-- TOC entry 2705 (class 2606 OID 16478)
-- Name: item item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (id);


--
-- TOC entry 2713 (class 2606 OID 16510)
-- Name: pedido pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (id);


--
-- TOC entry 2711 (class 2606 OID 16502)
-- Name: produto produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id);


--
-- TOC entry 2707 (class 2606 OID 16489)
-- Name: situacao situacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.situacao
    ADD CONSTRAINT situacao_pkey PRIMARY KEY (id);


--
-- TOC entry 2709 (class 2606 OID 16494)
-- Name: tipodemovimento tipodemovimento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipodemovimento
    ADD CONSTRAINT tipodemovimento_pkey PRIMARY KEY (id);


-- Completed on 2018-08-31 23:22:58

--
-- PostgreSQL database dump complete
--

