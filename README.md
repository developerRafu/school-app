# SCHOOL-APP
  Aplicação de gerenciamento de escolas, com front-end desenvolvido com Angular e Bootstrap, Back-end em Java/Spring e banco de dados MYSQL no docker.
# Requisitos
  -Nodejs 10
  -Angular CLI 10
  -JDK ou JRE 11
# Executando a aplicação
  -Instale o MySQL server no Docker:
    ```bash
    sudo docker volume create mysql-volume
    ```
    ```bash
    sudo docker run --name container-mysql -p3306:3306 -v mysql-volume:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=12345 -d mysql/mysql-server:latest
    ```
    ```bash
    sudo docker start container-mysql
    ```
  -Abra a pasta demo no sts ou eclipse e baixe as dependências do maven e depois compile.
  -Abra a pasta school-app no terminal e rode os comandos:
    ```bash
    npm install
    ```
    ```bash
    ng serve
    ```
  -Abra alguma browser na porta 4200
