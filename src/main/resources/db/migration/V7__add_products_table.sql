
CREATE TABLE products (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10,2) DEFAULT 0,
    category_id TINYINT NOT NULL,
    CONSTRAINT products_categories_fk
                      FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE RESTRICT
);