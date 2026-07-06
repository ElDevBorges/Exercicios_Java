#!/bin/bash


cd "$(dirname "$0")" || exit

# Compile (opcional - descomente para recompilar)
# javac -d out/production/Empresa_crud \
#     src/connection/ConexaoBD.java \
#     src/model/entity/Cliente.java \
#     src/model/entity/Usuario.java \
#     src/model/dao/ClienteDAO.java \
#     src/model/dao/UsuarioDAO.java \
#     src/dto/LoginDTO.java \
#     src/org/eclipse/wb/swing/FocusTraversalOnArray.java \
#     src/controller/ClientController.java \
#     src/controller/LoginController.java \
#     src/view/TelaLogin.java \
#     src/view/TelaCliente.java \
#     src/view/TelaDeletar.java \
#     src/Main.java

java -cp "out/production/Empresa_crud:mysql-connector-j-9.7.0.jar" Main
