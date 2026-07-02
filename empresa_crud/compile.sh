#!/bin/bash


cd "$(dirname "$0")" || exit

echo "🔨 Compilando projeto..."

rm -rf out/production/Empresa_crud/*

javac -d out/production/Empresa_crud \
    src/connection/ConexaoBD.java \
    src/model/entity/Cliente.java \
    src/model/entity/Usuario.java \
    src/model/dao/ClienteDAO.java \
    src/model/dao/UsuarioDAO.java \
    src/dto/LoginDTO.java \
    src/org/eclipse/wb/swing/FocusTraversalOnArray.java \
    src/controller/ClientController.java \
    src/controller/LoginController.java \
    src/view/TelaLogin.java \
    src/view/TelaCliente.java \
    src/view/TelaDeletar.java \
    src/Main.java

if [ $? -eq 0 ]; then
    echo "✅ Compilação concluída com sucesso!"
    echo ""
    echo "Para executar a aplicação, rode:"
    echo "  ./run.sh"
else
    echo "❌ Erro na compilação"
    exit 1
fi
