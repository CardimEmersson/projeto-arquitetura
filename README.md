# Atividade prática de desenvolvimento I
## Arquitetura de Software - ADS - IFBA Campus Eunápolis
> <p>Repositório para atividade prática I da Disciplina de Arquitetura de Software.</p>
> <p>Discentes: Emersson Cardim, Lucas Cardoso, Yuri Carvalho.</p>

Tecnologias utilizadas:
=================
<!--ts-->
* [Docker](https://www.docker.com/)
* [Docker Swarm](https://docs.docker.com/get-started/swarm-deploy/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [PostgreSQL](https://www.postgresql.org/)
 
<!--te-->

## Diagramas da aplicação:
<p><b>Diagrama de Componentes</b></p>

![Diagrama de Componentes](https://user-images.githubusercontent.com/75703602/133001984-110b60e3-4f00-42cb-9ffb-211a3c218d75.png)
<
<p><b>Diagrama de Classes</b></p>

![Diagrama de Classes](https://user-images.githubusercontent.com/75703602/133002000-db70e1ef-76a2-4423-a923-8a908d267f3d.png)

## Planilha de Requisitos:
[Planilha](https://docs.google.com/spreadsheets/d/1oaoLdADJX-Co9HcibigfcjVjz1ZsCv2h/edit?usp=sharing&ouid=103142025522406814186&rtpof=true&sd=true)

## Dependencias utilizadas:
<!--ts-->
* <b>WEB</b>
   * Spring web

* <b>SQL</b>
  * Spring Data JPA
  * PostgreSQL Driver

* <b>I/O</b>
  * Validation

* <b>DEVELOPER TOOLS</b>
  * Lombock

* <b>PACOTES</b>
  * CONTROLLERS: Responsável por intermediar as requisições enviadas pela view.

* <b>DTOS</b>
  * Objetos que vamos receber do método post.

* <b>ENUMS</b>
  * Onde vamos definir os tipos do status do curso.

* <b>MODELS</b>
  * Onde vamos salvar os dados do curso. Então sempre algum serviço/usuário precisar cadastrar algum 		curso, este microsserviço vai receber os dados referentes ao 		curso. Os models já serão marcadas como entidades.

* <b>REPOSITORIES</b>
  * Contém objetos que isolam os objetos ou entidades do domínio do código que acessa o banco de dados.	

* <b>SERVICES</b>
  * Camada intermediária entre o repository e o controller.
<!--te-->

* <b>EXECUÇÃO DO DOCKER</b>
* ```bash
# Entre na pasta 'api-gateway' e excute o comando para gerar a imagem do gateway
$ docker build -t ifba/gateway:v1 .

# Entre na pasta 'microservice-curso' e excute o comando para gerar a imagem do curso
$ docker build -t ifba/servicecurso:v1 .

# Entre na pasta 'monolith-ifba' e excute o comando para gerar a imagem do ifba
$ docker build -t ifba/ifba:v1 .

# Vá até a raiz do projeto e execute o comando para executar os containers
$ docker stack deploy -c docker-compose.yml servicecurso

# O comando abaixo irá listar os serviços em execução
$ docker service ls


# O comando abaixo irá replicar os container para gerar a alta disponibilidade, no exemplo 5 containers
$ docker service update --replicas 5 <service name>

```
