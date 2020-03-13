ALTER TABLE CARTITEMS DROP FOREIGN KEY FK_CARTITEMS_cart_id
ALTER TABLE cart DROP FOREIGN KEY FK_cart_USER_user_id
ALTER TABLE order_details DROP FOREIGN KEY FK_order_details_order_id
ALTER TABLE products DROP FOREIGN KEY FK_products_category_id
ALTER TABLE shipments DROP FOREIGN KEY FK_shipments_order_id
ALTER TABLE orders DROP FOREIGN KEY FK_orders_user_id
DROP TABLE CARTITEMS
DROP TABLE cart
DROP TABLE order_details
DROP TABLE users
DROP TABLE products
DROP TABLE shipments
DROP TABLE orders
DROP TABLE category
