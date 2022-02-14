CREATE TABLE IF NOT EXISTS cinema_users (
  id BIGSERIAL PRIMARY KEY,
  first_name TEXT NOT NULL,
  last_name TEXT NOT NULL,
  phone_number TEXT UNIQUE NOT NULL,
  password TEXT NOT NULL
);