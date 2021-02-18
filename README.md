<h1 align="center">Neo4j</h1>

   ## 📰Sobre:
   API para cadastro de pessoas utilizando um gerenciador de banco de dados gráfico, o Neo4j
   
   ## 🛠Ferramentas Utilizadas:
   -Intellij
   -Docker
   -Postman
   -Cmder
   
   ## 🎮Tecnologias Utilizadas:
  - Java11
  - Neo4j
  - Spring Boot
  - Lombok
  - Mapstruct



   Pre Requisitos
      - Como pré-requisito é necessário ter o docker instalado em sua máquina. Link para repositório onde explico como instalar o docker -> https://github.com/mimarcele/docker 
      - Com o docker rodando em sua máquina, é necessário criar um container com a imagem do Neo4j.  O Neo4j é uma imagem oficial do dockerhub, basta escolher a versão desejada e inserir na seguinte linha de comando em seu terminal:
 

 
 ## Comando Utilizados no Cmder para criar o container do Neo4j:

```bash
#criar um novo container
docker run --publish=7474:7474 --publish=7687:7687 neo4j:3.5.20

#listar todos container
docker container ls -a

```

  ### Features

- [x] Cadastro de usuário
- [x] Cadastro de cliente
- [ ] Cadastro de produtos


