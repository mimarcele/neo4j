<h1 align="center">Neo4j</h1>

<p align="center">API para cadastro de pessoas utilizando um gerenciador de banco de dados gráfico, o Neo4j</p>

<!--ts-->
   * [Sobre](#Sobre)
   * [Tabela de Conteudo](#tabela-de-conteudo)
   * [Instalação](#instalacao)
   * [Como usar](#como-usar)
      * [Pre Requisitos](#pre-requisitos)
      * <p>Como pré-requisito é necessário ter o docker instalado em sua máquina. Link para repositório onde explico como instalar o docker -> https://github.com/mimarcele/docker </p>
      * <p>Com o docker rodando em sua máquina, é necessário criar um container com a imagem do Neo4j.  O Neo4j é uma imagem oficial do dockerhub, basta escolher a versão desejada e inserir na seguinte linha de comando: docker run --publish=7474:7474 --publish=7687:7687 neo4j:3.5.20
 </p>
 
   * [Tecnologias](#tecnologias)
<!--te-->



### Features

- [x] Cadastro de usuário
- [x] Cadastro de cliente
- [ ] Cadastro de produtos
Tecnologias: -Spring Boot -Docker -Neo4j

Docker: Para rodar a imagem do Neo4j, basta inserir a seguinte linha de comando no seu terminal (pré-requisito ter o docker instalado) Linha de comando: docker run --publish=7474:7474 --publish=7687:7687 neo4j:3.077
