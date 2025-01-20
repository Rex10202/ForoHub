DELETE FROM `forohub`.`usuarios`;

INSERT INTO `forohub`.`usuarios` (`id`, `nombre`, `correo`, `contrasena`, `rol`)
VALUES ('1', 'Rex administrador', 'rex1.administrador@correo.com', '$2a$10$b9zlppJ2mXdrhkTf6QgIdOCGAfToxLuMflllpMuYi.ifOeTcvKiGy', 'ADMINISTRADOR');
INSERT INTO `forohub`.`usuarios` (`id`, `nombre`, `correo`, `contrasena`, `rol`)
VALUES ('2', 'Rex moderador', 'rex2.moderador@correo.com', '$2a$10$b9zlppJ2mXdrhkTf6QgIdOCGAfToxLuMflllpMuYi.ifOeTcvKiGy', 'MODERADOR');
INSERT INTO `forohub`.`usuarios` (`id`, `nombre`, `correo`, `contrasena`, `rol`)
VALUES ('3', 'Rex usuario', 'rex3.usuario@correo.com', '$2a$10$b9zlppJ2mXdrhkTf6QgIdOCGAfToxLuMflllpMuYi.ifOeTcvKiGy', 'USUARIO');