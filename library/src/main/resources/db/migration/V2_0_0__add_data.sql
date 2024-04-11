INSERT INTO book (title,author,isbn ,publication_date,created_at,updated_at)
VALUES ('The Lord of the Rings', 'J.R.R. Tolkien', '9780261102694',TO_DATE('1954-07-29', 'YYYY-MM-DD') ,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO book (title,author,isbn ,publication_date,created_at,updated_at)
VALUES('Pride and Prejudice', 'Jane Austen', '9780140439516', TO_DATE('1813-01-28', 'YYYY-MM-DD'),CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO book (title,author,isbn ,publication_date,created_at,updated_at)
VALUES('To Kill a Mockingbird', 'Harper Lee', '9780425173410', TO_DATE('1960-07-11', 'YYYY-MM-DD'),CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO book (title,author,isbn ,publication_date,created_at,updated_at)
VALUES('The Catcher in the Rye', 'J.D. Salinger', '9780316769482', TO_DATE('1951-07-16', 'YYYY-MM-DD'),CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO book (title,author,isbn ,publication_date,created_at,updated_at)
VALUES('1984', 'George Orwell', '9780451524935', TO_DATE('1949-06-8', 'YYYY-MM-DD'),CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO book (title,author,isbn ,publication_date,created_at,updated_at)
VALUES('The Great Gatsby', 'F. Scott Fitzgerald', '9780743273565', TO_DATE('1925-04-10', 'YYYY-MM-DD'),CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO book (title,author,isbn ,publication_date,created_at,updated_at)
VALUES('The Adventures of Huckleberry Finn', 'Mark Twain', '9781503288802', TO_DATE('1885-12-18', 'YYYY-MM-DD'),CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO book (title,author,isbn ,publication_date,created_at,updated_at)
VALUES('The Hitchhiker''s Guide to the Galaxy', 'Douglas Adams', '9780345391803', TO_DATE('1979-10-12', 'YYYY-MM-DD'),CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO book (title,author,isbn ,publication_date,created_at,updated_at)
VALUES('Animal Farm', 'George Orwell', '9780449914426', TO_DATE('1945-08-17', 'YYYY-MM-DD'),CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO book (title,author,isbn ,publication_date,created_at,updated_at)
VALUES('The Book Thief', 'Markus Zusak', '9780375838907', TO_DATE('2005-03-01', 'YYYY-MM-DD'),CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


INSERT INTO PATRON (patron_name,email,contact,created_at,updated_at)
VALUES ('John Doe', 'john.doe@example.com', '+971551234567',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO PATRON (patron_name,email,contact,created_at,updated_at)
VALUES ('Jane Smith', 'jane.smith@example.com', '+971551234577',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO PATRON (patron_name,email,contact,created_at,updated_at)
VALUES ('Michael Brown', 'michael.brown@example.com', '+971551234587',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO PATRON (patron_name,email,contact,created_at,updated_at)
VALUES ('Alice Johnson', 'alice.johnson@example.com', '+971551234537',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO PATRON (patron_name,email,contact,created_at,updated_at)
VALUES ('David Miller', 'david.miller@example.com', '+971551234547',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);