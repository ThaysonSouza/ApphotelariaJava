<div align="center">

# Hotel Management System — Desktop

**Aplicação desktop completa para gestão hoteleira com interface gráfica JavaFX**

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-UI-007396?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0+-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-Driver-59666C?style=for-the-badge&logo=hibernate&logoColor=white)

<br/>

*Aplicação desktop robusta com arquitetura MVC + DAO, interface rica em JavaFX e persistência via JDBC com PreparedStatements.*

[Funcionalidades](#-funcionalidades) •
[Arquitetura](#%EF%B8%8F-arquitetura) •
[Como Rodar](#%EF%B8%8F-como-rodar-localmente) •
[Diferenciais](#-diferenciais-técnicos)

</div>

---

## Sobre o Projeto

O **Hotel Management System Desktop** é uma aplicação de gestão hoteleira construída em Java com interface gráfica JavaFX. O sistema oferece uma experiência desktop completa para operadores de hotel gerenciarem quartos, reservas, clientes e usuários do sistema.

O projeto aplica o padrão **MVC com DAO** (Data Access Object), garantindo total desacoplamento entre a lógica de negócio, a interface gráfica e a camada de persistência — permitindo que qualquer camada seja substituída sem afetar as demais.

### Problema Resolvido

- Interface desktop intuitiva para operação do hotel (recepção, gestão)
- Autenticação de operadores com hashing no banco de dados
- CRUD completo de todas as entidades do domínio hoteleiro
- Configuração externalizada para deploy em múltiplos ambientes

---

## Funcionalidades

### Autenticação
- Login de usuários com hashing MD5 no MySQL
- Validação de credenciais via DAO dedicado
- Feedback visual de autenticação

### Gestão de Quartos
- Cadastro com nome, número, camas (casal/solteiro), preço e disponibilidade
- Input masks customizados para campos monetários (R$)
- Spinners com validação para campos numéricos
- Atualização e exclusão com feedback

### Reservas & Pedidos
- Criação e gestão de reservas vinculadas a quartos e pedidos
- Controle de adicionais por reserva
- Histórico de pedidos por cliente

### Clientes & Usuários
- Cadastro completo de clientes e operadores
- Sistema de Roles (papéis) para controle de acesso
- Herança OOP: `Pessoa` → `Cliente` / `Usuario`

### Interface Gráfica
- Sidebar de navegação reutilizável
- Painel de botões componentizado
- Fontes customizadas (Roboto Condensed)
- Layout responsivo com BorderPane + GridPane

---

## 🛠️ Tecnologias Utilizadas

| Camada | Tecnologia | Propósito |
|--------|-----------|-----------|
| **Linguagem** | Java 17+ | Lógica de negócio, OOP |
| **Interface** | JavaFX | GUI desktop rica e responsiva |
| **Persistência** | JDBC + MySQL | Acesso a dados via PreparedStatements |
| **Config** | Properties | Externalização de credenciais |
| **IDE** | IntelliJ IDEA | Desenvolvimento e debugging |

---

## 🏗️ Arquitetura

```
ApphotelariaJava/
└── src/
    ├── controller/
    │   └── UsuariosController.java    # Orquestração de fluxos
    ├── dao/
    │   ├── QuartosDAO.java            # CRUD quartos via JDBC
    │   ├── ReservasDAO.java           # CRUD reservas
    │   ├── PedidosDAO.java            # CRUD pedidos
    │   ├── ClientesDAO.java           # CRUD clientes
    │   ├── UsuariosDAO.java           # Auth + CRUD usuários
    │   ├── AdicionaisDAO.java         # CRUD adicionais
    │   └── RolesDAO.java              # Gestão de papéis
    ├── model/
    │   ├── Pessoa.java                # Classe base (herança)
    │   ├── Cliente.java               # extends Pessoa
    │   ├── Usuario.java               # extends Pessoa
    │   ├── Quarto.java                # Entidade quarto
    │   ├── Reserva.java               # Entidade reserva
    │   ├── Pedido.java                # Entidade pedido
    │   └── Adicionais.java            # Entidade adicional
    ├── view/
    │   ├── CadQuarto.java             # Tela de cadastro de quartos
    │   ├── CadCliente.java            # Tela de cadastro de clientes
    │   ├── CadUsuario.java            # Tela de cadastro de usuários
    │   ├── LoginCliente.java          # Tela de login
    │   ├── components/
    │   │   ├── Sidebar.java           # Menu lateral reutilizável
    │   │   └── PainelBotoes.java      # Botões de ação reutilizáveis
    │   └── resources/
    │       ├── fonts/                 # Roboto Condensed
    │       └── img/                   # Ícones e logo
    └── util/
        ├── Conexao.java               # Conexão JDBC via Properties
        └── TesteConexao.java          # Testes de conectividade
```

### Padrões Aplicados

- **MVC** — Model (entidades), View (JavaFX), Controller (orquestração)
- **DAO Pattern** — Cada entidade tem seu Data Access Object dedicado
- **Herança (OOP)** — `Pessoa` como superclasse para `Cliente` e `Usuario`
- **Properties Config** — Credenciais externalizadas via `config.properties`
- **Component Pattern** — `Sidebar` e `PainelBotoes` reutilizáveis nas views

---


## Como Rodar Localmente

### Pré-requisitos

- JDK 17+
- MySQL 8.0+
- JavaFX SDK
- IntelliJ IDEA (recomendado)

### Instalação

```bash
# Clone o repositório
git clone https://github.com/ThaysonSouza/ApphotelariaJava.git

# Importe o projeto no IntelliJ IDEA
# File → Open → selecione a pasta do projeto

# Configure o MySQL
# Importe o schema do banco de dados

# Configure src/config.properties
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/hotel
usuario=seu_usuario
senha=sua_senha

# Execute a classe principal
# Run → CadQuarto.java (ou LoginCliente.java)
```

---

## 📈 Diferenciais Técnicos

| Aspecto | Implementação |
|---------|--------------|
| **Desacoplamento** | DAO Pattern isola 100% da persistência — trocar MySQL por PostgreSQL exige zero mudança nos controllers |
| **OOP Sólido** | Herança com `Pessoa`, encapsulamento com getters/setters, modelos coesos |
| **Segurança** | PreparedStatements em todas as queries, hashing de senhas no banco |
| **Config Externalizada** | `config.properties` via ClassLoader — deploy em N ambientes sem recompilação |
| **UI Componentizada** | Sidebar e PainelBotoes como componentes reutilizáveis em todas as telas |
| **Input Validation** | Masks customizados com listeners reativos no `textProperty()` |

---

## 📚 Aprendizados

Este projeto demonstra domínio em:

- Programação Orientada a Objetos aplicada: herança, encapsulamento, polimorfismo
- Padrão DAO para desacoplamento entre lógica de negócio e persistência
- JDBC puro com PreparedStatements — entendendo o que um ORM abstrai
- Construção de interfaces desktop ricas com JavaFX e componentes reutilizáveis
- Externalização de configurações para ambientes múltiplos

---

## 👨‍💻 Autor

Desenvolvido por **Thayson Sousa**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/thayson-sousa)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/ThaysonSouza)

---

<div align="center">
  <sub>Projeto desenvolvido durante formação no Senac Sorocaba</sub>
</div>
