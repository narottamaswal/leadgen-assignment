CREATE SEQUENCE lead_seq_id;

CREATE TABLE IF NOT EXISTS public.lead_master
(
    id bigint NOT NULL DEFAULT nextval('lead_seq_id'::regclass),
    lead_id bigint NOT NULL,
    first_name character varying COLLATE pg_catalog."default" NOT NULL,
    middle_name character varying COLLATE pg_catalog."default",
    last_name character varying COLLATE pg_catalog."default" NOT NULL,
    mobile_number character varying COLLATE pg_catalog."default" NOT NULL,
    gender character varying COLLATE pg_catalog."default" NOT NULL,
    date_of_birth DATE NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    CONSTRAINT leadgen_systems_info_seq_id_pkey PRIMARY KEY (id),
    CONSTRAINT leadgen_systems_info_seq_leadid_unique_key UNIQUE (lead_id)
);

ALTER TABLE IF EXISTS public.lead_master
    OWNER to postgres;
	
ALTER SEQUENCE lead_seq_id OWNED BY lead_master.id;