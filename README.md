# 🎵 MusicFy — Sistema Web de Estúdio de Gravação Musical

<p align="center">
  <img src="https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge" alt="Status"/>
  <img src="https://img.shields.io/badge/Projeto-Acadêmico-blue?style=for-the-badge" alt="Projeto"/>
  <img src="https://img.shields.io/badge/Licença-MIT-yellow?style=for-the-badge" alt="Licença"/>
</p>

<p align="center">
  Sistema web para gestão de um <strong>estúdio de gravação musical</strong>, com autenticação de usuários, cadastro de clientes/sessões, cálculo automático de taxas e CRUD completo integrado ao banco de dados MySQL.
</p>

---

## ✨ Sobre o Projeto

O **MusicFy** foi desenvolvido como projeto avaliativo de universidade, com o objetivo de aplicar conceitos de Programação Orientada a Objetos (atributos e métodos), desenvolvimento **Front-end** (telas de interação com o usuário) e **Back-end** (persistência e recuperação de dados no banco).

A aplicação permite:

- 🔐 Login e logout com sessão HTTP
- 📝 Cadastro de clientes e sessões de estúdio
- 📋 Listagem de todos os registros
- ✏️ Alteração de dados
- 🗑️ Exclusão de registros
- 💰 Cálculo automático de faturamento, mixagem e valor total

---

## 🛠️ Tecnologias Utilizadas

### Linguagens

<p align="left">
  <a href="https://www.java.com/" target="_blank" rel="noreferrer">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="Java" width="50" height="50"/>
  </a>
  &nbsp;&nbsp;
  <a href="https://developer.mozilla.org/en-US/docs/Web/HTML" target="_blank" rel="noreferrer">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/html5/html5-original.svg" alt="HTML5" width="50" height="50"/>
  </a>
  &nbsp;&nbsp;
  <a href="https://developer.mozilla.org/en-US/docs/Web/CSS" target="_blank" rel="noreferrer">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/css3/css3-original.svg" alt="CSS3" width="50" height="50"/>
  </a>
  &nbsp;&nbsp;
  <a href="https://www.mysql.com/" target="_blank" rel="noreferrer">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original.svg" alt="MySQL" width="50" height="50"/>
  </a>
</p>

| Tecnologia | Uso no projeto |
|------------|----------------|
| ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) | Lógica de negócio, Servlets e DAO |
| ![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white) | Estrutura das páginas |
| ![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white) | Estilização da tela de login |
| ![JSP](https://img.shields.io/badge/JSP-007396?style=for-the-badge&logo=java&logoColor=white) | Views dinâmicas do sistema |
| ![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white) | Banco de dados relacional |
| ![Tomcat](https://img.shields.io/badge/Apache%20Tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black) | Servidor de aplicações |

### Bibliotecas e recursos

<p align="left">
  <img src="https://img.shields.io/badge/JDBC-007396?style=flat-square&logo=java&logoColor=white" alt="JDBC"/>
  <img src="https://img.shields.io/badge/JSTL-007396?style=flat-square&logo=java&logoColor=white" alt="JSTL"/>
  <img src="https://img.shields.io/badge/Servlet%20API-ED8B00?style=flat-square&logo=java&logoColor=white" alt="Servlet"/>
  <img src="https://img.shields.io/badge/Font%20Awesome-339AF0?style=flat-square&logo=fontawesome&logoColor=white" alt="Font Awesome"/>
  <img src="https://img.shields.io/badge/Google%20Fonts-4285F4?style=flat-square&logo=google&logoColor=white" alt="Google Fonts"/>
</p>

---

## 📁 Estrutura do Projeto

```
sistemawebmusic-main/
├── README.md
├── docs/
│   ├── DOCUMENTACAO.md      # Documentação técnica completa
│   └── INSTALACAO.md        # Guia de instalação e execução
├── database/
│   └── schema.sql           # Script de criação do banco
└── sistemawebmusica/
    └── sistemawebmusica/
        ├── src/
        │   ├── controller/
        │   │   └── MeuServlet.java      # Controlador (Servlet)
        │   ├── model/
        │   │   ├── Music.java           # Entidade / regras de negócio
        │   │   ├── MusicDao.java        # Acesso a dados (DAO)
        │   │   ├── Conexao.java         # Conexão JDBC com MySQL
        │   │   └── mixarMusica.java     # Classe auxiliar
        │   └── teste/
        │       ├── TesteAutentica.java
        │       ├── TesteCadastro.java
        │       ├── TesteConexao.java
        │       ├── TesteAltera.java
        │       ├── TesteExcluiPorIdCliente.java
        │       ├── TesteMostraPorIdCliente.java
        │       └── TesteMostraTodosClientes.java
        └── WebContent/
            ├── index.html               # Tela de login (MusicFy)
            ├── style.css                # Estilos da tela de login
            ├── META-INF/
            │   └── MANIFEST.MF
            └── WEB-INF/
                └── view/
                    ├── cadastro.jsp     # Formulário de cadastro
                    ├── mostratodos.jsp  # Listagem de clientes
                    ├── altera.jsp       # Formulário de alteração
                    └── mixarMusica.jsp  # View auxiliar
```

---

## 🏗️ Arquitetura

O sistema segue o padrão **MVC (Model–View–Controller)**:

```
┌─────────────┐      ┌──────────────────┐      ┌─────────────┐
│   VIEW      │      │   CONTROLLER     │      │   MODEL     │
│  HTML/JSP   │◄────►│   MeuServlet     │◄────►│ Music       │
│  CSS        │      │   (ações CRUD)   │      │ MusicDao    │
└─────────────┘      └──────────────────┘      │ Conexao     │
                                               └──────┬──────┘
                                                      │
                                               ┌──────▼──────┐
                                               │   MySQL     │
                                               │ databasemusic│
                                               └─────────────┘
```

| Camada | Responsabilidade | Arquivos |
|--------|------------------|----------|
| **View** | Interface com o usuário | `index.html`, `*.jsp`, `style.css` |
| **Controller** | Roteamento de ações e sessão | `MeuServlet.java` |
| **Model** | Entidade, regras e persistência | `Music.java`, `MusicDao.java`, `Conexao.java` |

---

## ⚙️ Funcionalidades

| Ação | Método HTTP | Descrição |
|------|-------------|-----------|
| `login` | POST | Autentica o usuário e cria sessão |
| `logout` | GET | Invalida a sessão e redireciona ao login |
| `cadastro` | GET / POST | Exibe formulário e grava novo cliente |
| `mostratodos` | GET | Lista todos os clientes cadastrados |
| `altera` | GET / POST | Carrega e atualiza dados de um cliente |
| `exclui` | GET | Remove um cliente pelo `idCliente` |

### Regras de cálculo automático

| Faixa de horas no estúdio | Faturamento |
|---------------------------|-------------|
| 1 a 3 horas | R$ 50,00 |
| 4 a 7 horas | R$ 100,00 |
| 8 a 10 horas | R$ 200,00 |
| 11 a 15 horas | R$ 500,00 |
| 16+ horas | R$ 700,00 |

- **Mixagem:** `número de músicas gravadas × R$ 50,00`
- **Valor total:** `faturamento + mixagem`

---

## 🚀 Como Executar

> Guia detalhado em [`docs/INSTALACAO.md`](docs/INSTALACAO.md)

### Pré-requisitos

- JDK 8 ou superior
- Apache Tomcat 9+
- MySQL 5.7 / 8.x
- IDE (Eclipse IDE for Enterprise Java Developers recomendada)
- Driver MySQL Connector/J

### Passos rápidos

1. Crie o banco com o script [`database/schema.sql`](database/schema.sql)
2. Ajuste usuário/senha em `Conexao.java` se necessário
3. Importe o projeto no Eclipse como **Dynamic Web Project**
4. Adicione o MySQL Connector/J ao `WEB-INF/lib`
5. Faça o deploy no Tomcat e acesse:

```
http://localhost:8080/sistemawebmusica
```

---

## 📚 Documentação

| Documento | Conteúdo |
|-----------|----------|
| [Documentação completa](docs/DOCUMENTACAO.md) | Arquitetura, classes, fluxos, banco e APIs internas |
| [Instalação](docs/INSTALACAO.md) | Ambiente, configuração e execução |
| [Schema SQL](database/schema.sql) | Criação do banco e tabela |

---

## 🧪 Classes de Teste

O pacote `teste` contém classes `main` para validar o DAO sem o servidor:

| Classe | O que testa |
|--------|-------------|
| `TesteConexao` | Conexão com o MySQL |
| `TesteAutentica` | Login / autenticação |
| `TesteCadastro` | Inserção de cliente |
| `TesteMostraTodosClientes` | Listagem completa |
| `TesteMostraPorIdCliente` | Busca por ID |
| `TesteAltera` | Atualização de registro |
| `TesteExcluiPorIdCliente` | Exclusão por ID |

---

## 👤 Autor

Projeto acadêmico desenvolvido como avaliação universitária — tema: **Estúdio de Gravação Musical**.

---

## 📄 Licença

Este projeto está sob a licença MIT. Sinta-se livre para estudar, adaptar e evoluir o código.
