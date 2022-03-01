CREATE TABLE POST (
  id INT IDENTITY PRIMARY KEY,
  title VARCHAR(400) NOT NULL,
  content VARCHAR(2000) NULL,
  created VARCHAR(400) NULL
);

CREATE TABLE COMMENT (
    id INT IDENTITY PRIMARY KEY,
    post_id INT NOT NULL,
    content VARCHAR(2000) NULL,
    created VARCHAR(400) NULL
);

ALTER TABLE COMMENT
    ADD CONSTRAINT comment_post_id
    FOREIGN KEY (post_id) REFERENCES post(id)