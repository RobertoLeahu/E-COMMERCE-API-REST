INSERT INTO categorias (nombre, descripcion) VALUES ('Tecnología', 'Dispositivos electrónicos, portátiles, componentes y gadgets de última generación.');
INSERT INTO categorias (nombre, descripcion) VALUES ('Accesorios', 'Periféricos, teclados, ratones y complementos para optimizar tu espacio de trabajo.');

INSERT INTO productos (nombre, descripcion, precio, stock, imagen_url, categoria_id) VALUES ('Portátil PRO 14', 'Portátil de alta gama con procesador de última generación, 16GB RAM y 512GB SSD.', 1249.99, 15, 'https://images.unsplash.com/photo-1517336714731-489689fd1ca8', 1);
INSERT INTO productos (nombre, descripcion, precio, stock, imagen_url, categoria_id) VALUES ('Ratón Ergonómico Inalámbrico', 'Ratón vertical inalámbrico con batería recargable y diseño ergonómico para largas jornadas.', 45.50, 100, 'https://images.unsplash.com/photo-1615663245857-ac93bb7c39e7', 2);
INSERT INTO productos (nombre, descripcion, precio, stock, imagen_url, categoria_id) VALUES ('Teclado Mecánico RGB', 'Teclado mecánico con switches silenciosos y retroiluminación RGB configurable.', 89.90, 50, 'https://images.unsplash.com/photo-1587829741301-dc798b83add3', 2);

INSERT INTO usuarios (email, password, rol) VALUES ('admin@ecommerce.com', 'admin123', 'ADMIN');
INSERT INTO usuarios (email, password, rol) VALUES ('cliente@ecommerce.com', 'cliente123', 'CLIENTE');

INSERT INTO perfiles (nombre, apellido, telefono, usuario_id) VALUES ('Carlos', 'Administrador', '+34600111222', 1);
INSERT INTO perfiles (nombre, apellido, telefono, usuario_id) VALUES ('Ana', 'Gómez', '+34600333444', 2);

INSERT INTO direcciones (titulo, calle, ciudad, estado, codigo_postal, pais, usuario_id) VALUES ('Casa', 'Calle Mayor 12, 3ºB', 'Madrid', 'Madrid', '28001', 'España', 2);
INSERT INTO direcciones (titulo, calle, ciudad, estado, codigo_postal, pais, usuario_id) VALUES ('Oficina', 'Avenida de la Constitución 45', 'Barcelona', 'Cataluña', '08001', 'España', 2);