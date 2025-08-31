CREATE TABLE wishlist
(
    user_id    BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, product_id),
    CONSTRAINT users_wishlist_fk
        FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    CONSTRAINT products_wishlist_fk
        FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE
);