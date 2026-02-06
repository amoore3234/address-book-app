CREATE TABLE IF NOT EXISTS user_data (
  id SERIAL PRIMARY KEY,
  firstName VARCHAR(200),
  lastName VARCHAR(255),
  phoneNumber VARCHAR(255),
  homeAddress VARCHAR(255),
  homeCity VARCHAR(255),
  homeState VARCHAR(10),
  homeZipCode VARCHAR(20),
  createdTimestamp Timestamptz,
  updatedTimestamp Timestamptz
);